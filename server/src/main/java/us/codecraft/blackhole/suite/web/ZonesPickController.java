package us.codecraft.blackhole.suite.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.service.UserZonesService;
import us.codecraft.blackhole.suite.util.CookieUtils;
import us.codecraft.blackhole.suite.util.RequestThreadUtils;
import us.codecraft.blackhole.suite.util.UserZonesCodec;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:40
 */
@Controller
@RequestMapping("zonespick")
public class ZonesPickController extends MultiActionController {

    @Autowired
    private UserZonesService userZonesService;

    @RequestMapping("")
    public ModelAndView dashboard(HttpServletRequest request) throws IOException {
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        String zones = userZonesService.getZones(userPassport);
        if (zones == null) {
            zones = CookieUtils.getZones(request);
        }
        ModelAndView modelAndView = new ModelAndView("zonespick");
        modelAndView.addObject("zones", UserZonesCodec.toJson(zones));
        return modelAndView;
    }

}
