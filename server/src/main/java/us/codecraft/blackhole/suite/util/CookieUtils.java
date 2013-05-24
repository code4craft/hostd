package us.codecraft.blackhole.suite.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: cairne
 * Date: 13-5-14
 * Time: 上午7:18
 */
public class CookieUtils {

    public static final String TICKET_KEY = "_t";

    public static String getCookie(HttpServletRequest request, String key) {
        final Cookie[] cookies = request.getCookies();
        return getCookie(cookies, key);
    }

    public static String getCookie(Cookie[] cookies, String key) {
        if (cookies == null || cookies.length == 0) {
            return null;
        }

        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(key)) {
                return cookies[i].getValue();
            }
        }

        return null;
    }

    public static void saveCookie(HttpServletResponse response, String key, String value,
                                  int second, String path) {
        value = StringUtils.remove(value, '\n');
        value = StringUtils.remove(value, '\r');
        Cookie cookie = new Cookie(key, value);
        cookie.setPath(path);
        cookie.setMaxAge(second);
        response.addCookie(cookie);
    }
}
