package us.codecraft.blackhole.suite.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import sun.misc.BASE64Decoder;
import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.service.UserZonesService;
import us.codecraft.blackhole.suite.util.CookieUtils;
import us.codecraft.blackhole.suite.util.IPUtils;
import us.codecraft.blackhole.suite.util.RequestThreadUtils;
import us.codecraft.blackhole.suite.util.UserZonesUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @RequestMapping("z")
    public ModelAndView dashboardZ(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false, value = "z") String zonesBase64) throws IOException {
        return dashboard(request,response,zonesBase64);
    }

    @RequestMapping("")
    public ModelAndView dashboard(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false, value = "z") String zonesBase64) throws IOException {
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        String zones = userZonesService.getZones(userPassport);
        if (zones == null) {
            zones = CookieUtils.getZones(request);
        }
        if (StringUtils.isBlank(zones) && !StringUtils.isBlank(zonesBase64)) {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            zones = new String(base64Decoder.decodeBuffer(zonesBase64), "utf-8");
            CookieUtils.saveZones(response, zones);
        }
        String localIp = IPUtils.getLocalIP();
        ModelAndView modelAndView = new ModelAndView("zonespick");
        modelAndView.addObject("zones", UserZonesUtils.toJson(zones));
        modelAndView.addObject("localIp", localIp);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("pick")
    public Object pick(HttpServletRequest request, HttpServletResponse response, @RequestParam("json") String json) throws IOException {
        String text = UserZonesUtils.fromJson(json);
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        userZonesService.updateZones(userPassport, text);
        CookieUtils.saveZones(response, text);
        return zonesApplyController.save(text, request);
    }

}
