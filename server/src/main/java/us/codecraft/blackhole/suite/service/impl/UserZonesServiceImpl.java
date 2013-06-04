package us.codecraft.blackhole.suite.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import us.codecraft.blackhole.suite.dao.UserZonesDAO;
import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.service.UserZonesService;
import us.codecraft.blackhole.suite.util.CookieUtils;
import us.codecraft.blackhole.suite.util.UserZonesUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: cairne
 * Date: 13-5-26
 * Time: 上午10:58
 */
@Service
public class UserZonesServiceImpl implements UserZonesService {


    @Resource
    private UserZonesDAO userZonesDAO;

    @Override
    public String getZones(UserPassport userPassport) {
        if (userPassport != null) {
            return userZonesDAO.getZones(userPassport.getId());
        }
        return null;
    }

    @Override
    public void updateZones(UserPassport userPassport, String zones) {
        if (userPassport != null) {
            userZonesDAO.updateZones(userPassport.getId(), zones);
        }
    }

    @Override
    public void mergeUserZones(HttpServletRequest request, HttpServletResponse response,UserPassport userPassport) {
        String userZones = getZones(userPassport);
        String cookieZones = CookieUtils.getZones(request);
        if (cookieZones != null) {
            userZones = UserZonesUtils.merge(userZones, cookieZones);
            updateZones(userPassport, userZones);
            CookieUtils.saveZones(response,cookieZones);
        }
    }
}
