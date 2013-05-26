package us.codecraft.blackhole.suite.web;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.model.ZonesFile;
import us.codecraft.blackhole.suite.service.ZonesFileService;
import us.codecraft.blackhole.suite.util.RequestThreadUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * User: cairne
 * Date: 13-5-12
 * Time: 下午7:40
 */
@Controller
@RequestMapping("share")
public class ShareController extends MultiActionController {


    @Autowired
    private ZonesFileService zonesFileService;

    @RequestMapping("")
    public ModelAndView dashboard(HttpServletRequest request) throws IOException {
        ModelAndView modelAndView = new ModelAndView("shareboard");
        UserPassport userPassport = RequestThreadUtils.getUserPassport();
        Map<String, List<ZonesFile>> zonesFileList = zonesFileService.getZonesFileList(userPassport);
        modelAndView.addAllObjects(zonesFileList);

        constructJsonData(modelAndView, zonesFileList);
        return modelAndView;
    }

    private void constructJsonData(ModelAndView modelAndView, Map<String, List<ZonesFile>> zonesFileList) throws IOException {
        Map<Integer, ZonesFile> dataMap = new LinkedHashMap<Integer, ZonesFile>();
        for (List<ZonesFile> zonesFiles : zonesFileList.values()) {
            for (ZonesFile zonesFile : zonesFiles) {
                dataMap.put(zonesFile.getId(), zonesFile);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String data = objectMapper.writeValueAsString(dataMap);
        modelAndView.addObject("data", data);
    }
}
