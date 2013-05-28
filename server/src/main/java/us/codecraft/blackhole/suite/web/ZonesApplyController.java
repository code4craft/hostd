package us.codecraft.blackhole.suite.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import us.codecraft.blackhole.suite.connector.BlackholeConnector;
import us.codecraft.blackhole.suite.connector.ZonesFileApplyer;
import us.codecraft.blackhole.suite.model.JsonResult;
import us.codecraft.blackhole.suite.util.IPUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * User: cairne
 * Date: 13-5-12
 * Time: 下午8:53
 */
@Controller
@RequestMapping("apply")
public class ZonesApplyController extends MultiActionController {

    @Autowired
    private ZonesFileApplyer zonesFileApplyer;

    @Autowired
    private BlackholeConnector blackholeConnector;

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object save(@RequestParam("text") String text, HttpServletRequest request) {
        zonesFileApplyer.apply(IPUtils.getClientIp(request), text);
        if (blackholeConnector.isConnected()) {
            return JsonResult.success("Aplly success!");
        } else {
            return JsonResult.error("Aplly failed，Blackhole is not connected！");
        }
    }
}
