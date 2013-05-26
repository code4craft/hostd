package us.codecraft.blackhole.suite.util;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**
 * User: cairne
 * Date: 13-5-14
 * Time: 上午7:18
 */
public class CookieUtils {

    public static final String TICKET_KEY = "_t";

    public final static String ZONES_KEY = "_zones";

    public static String getCookie(HttpServletRequest request, String key) {
        final Cookie[] cookies = request.getCookies();
        return getCookie(cookies, key);
    }

    public static String getZones(HttpServletRequest request) {
        String zones = CookieUtils.getCookie(request, CookieUtils.ZONES_KEY);
        if (zones != null) {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            try {
                zones = new String(base64Decoder.decodeBuffer(zones), "utf-8");
            } catch (IOException e) {
                zones = null;
            }
        }
        return zones;
    }

    public static void saveZones(HttpServletResponse response,String text){
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //cookie only support single line,so encode text to base64.
        String encode = null;
        try {
            encode = base64Encoder.encode(text.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
        }
        CookieUtils.saveCookie(response, CookieUtils.ZONES_KEY, encode,
                (int) TimeUnit.DAYS.toSeconds(30), "/");
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
