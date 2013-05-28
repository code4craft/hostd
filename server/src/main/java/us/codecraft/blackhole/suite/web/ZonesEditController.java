package us.codecraft.blackhole.suite.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import us.codecraft.blackhole.suite.dao.ZonesFileDAO;
import us.codecraft.blackhole.suite.model.JsonResult;
import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.model.ZonesFile;
import us.codecraft.blackhole.suite.service.UserZonesService;
import us.codecraft.blackhole.suite.util.CookieUtils;
import us.codecraft.blackhole.suite.util.RequestThreadUtils;
import us.codecraft.blackhole.suite.util.UserZonesUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:40
 */
@Controller
@RequestMapping("edit")
public class ZonesEditController extends MultiActionController {

    @Resource
    private ZonesFileDAO zonesFileDAO;

    @Autowired
    private UserZonesService userZonesService;

    @Autowired
    private ZonesApplyController zonesApplyController;

    @ResponseBody
    @RequestMapping("delete/{id}")
    public Object delete(@PathVariable("id") int id) {
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        if (userPassport == null) {
            return JsonResult.result(403, "请先登录！");
        }
        zonesFileDAO.deleteById(id);
        return JsonResult.success("删除成功！");
    }

    @RequestMapping("new")
    public ModelAndView newZones() {
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        if (userPassport == null) {
            return new ModelAndView("redirect:/login");
        }
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("name", "新的配置");
        modelAndView.addObject("id", 0);
        modelAndView.addObject("content", "");
        modelAndView.addObject("user", userPassport.getUsername());
        return modelAndView;
    }

    @RequestMapping("{id}")
    public ModelAndView edit(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        ZonesFile zonesFile = zonesFileDAO.load(id);
        if (zonesFile != null) {
            modelAndView.addObject("id", id);
            modelAndView.addObject("name", zonesFile.getName());
            modelAndView.addObject("content", zonesFile.getText());
            modelAndView.addObject("user", zonesFile.getUser());
        }
        return modelAndView;
    }

    @RequestMapping("")
    public ModelAndView editDefault(HttpServletRequest request) throws IOException {
        ModelAndView modelAndView = new ModelAndView("edit");
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        String zones = userZonesService.getZones(userPassport);
        if (zones == null) {
            zones = CookieUtils.getZones(request);
        }
        modelAndView.addObject("id", 0);
        modelAndView.addObject("content", zones);
        modelAndView.addObject("type", "userZones");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Object saveDefault(HttpServletRequest request,HttpServletResponse response, @RequestParam("text") String text) throws UnsupportedEncodingException {
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        userZonesService.updateZones(userPassport, text);
        CookieUtils.saveZones(response,text);
        return zonesApplyController.save(text, request);
    }

    @ResponseBody
    @RequestMapping(value = "save/{id}", method = RequestMethod.POST)
    public Object save(@PathVariable(value = "id") int id, @RequestParam("text") String text, @RequestParam("name") String name) {
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        if (userPassport == null) {
            return JsonResult.result(403, "请先登录！");
        }
        int type = userPassport.isAdmin() ? 1 : 2;
        if (id == 0) {
            ZonesFile zonesFile = new ZonesFile();
            zonesFile.setText(text).setUser(userPassport.getUsername()).setName(name).setType(type);
            int add = zonesFileDAO.add(zonesFile);
            if (add > 0) {
                return JsonResult.success("新增成功！");
            }
        } else {
            ZonesFile zonesFile = new ZonesFile();
            zonesFile.setText(text).setName(name).setType(type).setId(id);
            int update = zonesFileDAO.update(zonesFile);
            if (update > 0) {
                return JsonResult.success("修改成功！");
            }
        }
        return JsonResult.error("修改失败！");
    }
}
