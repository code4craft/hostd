package us.codecraft.blackhole.suite.service;

import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.model.ZonesFile;

import java.util.List;
import java.util.Map;

/**
 * User: cairne
 * Date: 13-5-14
 * Time: 下午1:22
 */
public interface ZonesFileService {

    public Map<String,List<ZonesFile>> getZonesFileList(UserPassport userPassport);
}
