package us.codecraft.blackhole.suite.service;

import us.codecraft.blackhole.suite.model.UserPassport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: cairne
 * Date: 13-5-14
 * Time: 下午1:22
 */
public interface UserZonesService {

    public String getZones(UserPassport userPassport);

    public void updateZones(UserPassport userPassport,String zones);

    /**
     * merge zones when not login to userZones
     * @param request
     * @param response
     * @param userPassport
     */
    public void mergeUserZones(HttpServletRequest request, HttpServletResponse response,UserPassport userPassport);

}
