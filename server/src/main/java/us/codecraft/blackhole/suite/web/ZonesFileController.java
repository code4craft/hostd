package us.codecraft.blackhole.suite.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import us.codecraft.blackhole.suite.dao.ZonesFileDao;
import us.codecraft.blackhole.suite.model.ZonesFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * User: cairne
 * Date: 13-5-12
 * Time: 下午4:46
 */
@Controller
@RequestMapping("zones")
public class ZonesFileController extends MultiActionController {

    @Resource
    private ZonesFileDao zonesFileDao;

    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Object show(@RequestParam("id") int id) throws IOException {
        ZonesFile zonesFile = zonesFileDao.load(id);
        return zonesFile;
    }
}
