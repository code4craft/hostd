package us.codecraft.blackhole.suite.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import us.codecraft.blackhole.suite.exception.LoginException;
import us.codecraft.blackhole.suite.model.JsonResult;
import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.service.UserPassportSerivce;
import us.codecraft.blackhole.suite.service.UserZonesService;
import us.codecraft.blackhole.suite.util.UserPassportUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

/**
 * User: cairne
 * Date: 13-5-15
 * Time: 上午6:10
 */
@Controller
@RequestMapping("login")
public class LoginController extends MultiActionController {

    @Autowired
    private UserPassportSerivce userPassportSerivce;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserZonesService userZonesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object doLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password) {
        UserPassport userPassport = null;
        try {
            userPassport = userPassportSerivce.doLogin(username, password);
            UserPassportUtil.saveUserPassportCookie(response, userPassport);
            userZonesService.mergeUserZones(request, response, userPassport);
            Map<String, Object> resultMap = JsonResult.success("Success！").toMap();
            resultMap.put("token", userPassport.getTicket());
            return resultMap;
        } catch (LoginException e) {
            return JsonResult.error(messageSource.getMessage(e.getCode(), null, Locale.CHINA));
        }
    }

}