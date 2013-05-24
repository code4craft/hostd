package us.codecraft.blackhole.suite.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.model.ZonesFile;
import us.codecraft.blackhole.suite.service.UserPassportSerivce;
import us.codecraft.blackhole.suite.service.ZonesFileService;
import us.codecraft.blackhole.suite.util.RequestThreadUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * User: cairne
 * Date: 13-5-12
 * Time: 下午4:46
 */
@Controller
@RequestMapping("zones")
public class ZonesListController extends MultiActionController {

    @Autowired
    private ZonesFileService zonesFileService;

    @Autowired
    private UserPassportSerivce userPassportSerivce;

    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Object show(HttpServletRequest httpServletRequest) throws IOException {
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        Map<String, List<ZonesFile>> zonesFileList = zonesFileService.getZonesFileList(userPassport);
        return zonesFileList;
    }
}
