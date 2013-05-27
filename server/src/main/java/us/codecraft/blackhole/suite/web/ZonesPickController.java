package us.codecraft.blackhole.suite.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.service.UserZonesService;
import us.codecraft.blackhole.suite.util.CookieUtils;
import us.codecraft.blackhole.suite.util.RequestThreadUtils;
import us.codecraft.blackhole.suite.util.UserZonesCodec;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;

/**
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:40
 */
@Controller
@RequestMapping("")
public class ZonesPickController extends MultiActionController {

    @Autowired
    private UserZonesService userZonesService;

    @Autowired
    private ZonesApplyController zonesApplyController;

    @RequestMapping("")
    public ModelAndView dashboard(HttpServletRequest request) throws IOException {
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        String zones = userZonesService.getZones(userPassport);
        if (zones == null) {
            zones = CookieUtils.getZones(request);
        }
        String localIp = InetAddress.getLocalHost().getHostAddress().toString();
        ModelAndView modelAndView = new ModelAndView("zonespick");
        modelAndView.addObject("zones", UserZonesCodec.toJson(zones));
        modelAndView.addObject("localIp", localIp);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("pick")
    public Object pick(HttpServletRequest request, HttpServletResponse response,@RequestParam("json") String json) throws IOException {
        String text = UserZonesCodec.fromJson(json);
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        userZonesService.updateZones(userPassport, text);
        CookieUtils.saveZones(response, text);
        return zonesApplyController.save(text,request);
    }

}
