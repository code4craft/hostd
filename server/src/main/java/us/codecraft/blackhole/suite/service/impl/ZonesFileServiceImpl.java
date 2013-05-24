package us.codecraft.blackhole.suite.service.impl;

import org.springframework.stereotype.Service;
import us.codecraft.blackhole.suite.dao.ZonesFileDao;
import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.model.ZonesFile;
import us.codecraft.blackhole.suite.service.ZonesFileService;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * User: cairne
 * Date: 13-5-14
 * Time: 下午1:23
 */
@Service
public class ZonesFileServiceImpl implements ZonesFileService{

    @Resource
    private ZonesFileDao zonesFileDao;

    @Override
    public Map<String, List<ZonesFile>> getZonesFileList(UserPassport userPassport) {
        Map<String, List<ZonesFile>> result = new LinkedHashMap<String, List<ZonesFile>>();
        List<ZonesFile> zonesFiles = zonesFileDao.findPublic();
        result.put("public", zonesFiles);
        if (userPassport != null) {
            List<ZonesFile> byUser = zonesFileDao.findByUser(userPassport.getUsername());
            result.put("personal", byUser);
        } else {
            result.put("personal", Collections.<ZonesFile>emptyList());
        }
        return result;
    }
}
