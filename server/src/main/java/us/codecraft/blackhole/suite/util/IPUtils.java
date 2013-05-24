package us.codecraft.blackhole.suite.util;

import javax.servlet.http.HttpServletRequest;

/**
 * User: cairne
 * Date: 13-5-13
 * Time: 上午8:09
 */
public class IPUtils {

    public static String getClientIp(HttpServletRequest request) {
        return request.getRemoteAddr();
    }
}
