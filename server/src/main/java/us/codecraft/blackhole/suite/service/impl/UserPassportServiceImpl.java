package us.codecraft.blackhole.suite.service.impl;

import org.springframework.stereotype.Service;
import us.codecraft.blackhole.suite.constant.LoginConstant;
import us.codecraft.blackhole.suite.dao.UserPassportDAO;
import us.codecraft.blackhole.suite.exception.LoginException;
import us.codecraft.blackhole.suite.exception.RegisterException;
import us.codecraft.blackhole.suite.model.UserPassport;
import us.codecraft.blackhole.suite.service.UserPassportSerivce;
import us.codecraft.blackhole.suite.util.UserPassportUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserPassportServiceImpl implements UserPassportSerivce {

    @Resource
    private UserPassportDAO userPassportDAO;


    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public UserPassport addUserPassport(String username, String password) throws RegisterException {
        if (userPassportDAO.getByUsername(username) != null) {
            throw new RegisterException(LoginConstant.REGISTER_ERROR_USERNAME_EXIST);
        }
        String salt = UserPassportUtil.generateSalt();
        String ticket = UserPassportUtil.generateTicket(username);
        while (userPassportDAO.getByTicket(ticket) != null) {
            ticket = UserPassportUtil.generateTicket(username);
        }
        String passwordSalt = UserPassportUtil.salt(password, salt);
        UserPassport userPassport = new UserPassport(username, passwordSalt, salt, ticket);
        try {
            userPassportDAO.insert(userPassport);
        } catch (Exception e) {
            throw new RegisterException(LoginConstant.REGISTER_ERROR);
        }
        UserPassport byUsername = userPassportDAO.getByUsername(username);
        userPassport.setId(byUsername.getId());
        return userPassport;
    }

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public UserPassport doLogin(String username, String password) throws LoginException {
        UserPassport userPassport = userPassportDAO.getByUsername(username);
        if (userPassport == null) {
            throw new LoginException(LoginConstant.LOGIN_ERROR_USER_NOTEXIST);
        }
        String passwordSalt = UserPassportUtil.salt(password, userPassport.getSalt());
        if (passwordSalt.equals(userPassport.getPasswordSalt())) {
//            //登录时重新生成票
//            final String generateTicket = UserPassportUtil.generateTicket(userPassport.getUsername());
//            userPassport.setTicket(generateTicket);
//            userPassportDAO.update(userPassport);
            return userPassport;
        } else {
            throw new LoginException(LoginConstant.LOGIN_ERROR_PASSWORD_INCORRECT);
        }
    }

    @Override
    public UserPassport getUserPassport(HttpServletRequest request) {
        final String ticketFromCookie = UserPassportUtil.getTicketFromCookie(request);
        if (ticketFromCookie == null) {
            return null;
        }
        return userPassportDAO.getByTicket(ticketFromCookie);
    }

}
