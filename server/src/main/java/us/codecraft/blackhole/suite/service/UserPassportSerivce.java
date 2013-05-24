package us.codecraft.blackhole.suite.service;

import us.codecraft.blackhole.suite.exception.LoginException;
import us.codecraft.blackhole.suite.exception.RegisterException;
import us.codecraft.blackhole.suite.model.UserPassport;

import javax.servlet.http.HttpServletRequest;

public interface UserPassportSerivce {

    public UserPassport addUserPassport(String username, String password) throws RegisterException;

    public UserPassport doLogin(String username, String password) throws LoginException;

    public UserPassport getUserPassport(HttpServletRequest request);

}
