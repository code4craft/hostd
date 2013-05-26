package us.codecraft.blackhole.suite.service;

import us.codecraft.blackhole.suite.model.UserPassport;

/**
 * User: cairne
 * Date: 13-5-14
 * Time: 下午1:22
 */
public interface UserZonesService {

    public String getZones(UserPassport userPassport);

    public void updateZones(UserPassport userPassport,String zones);

}
