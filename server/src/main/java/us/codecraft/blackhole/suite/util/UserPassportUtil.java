package us.codecraft.blackhole.suite.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;
import us.codecraft.blackhole.suite.model.UserPassport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class UserPassportUtil {

    private static Random random = new Random();

    public static String salt(String password, String salt) {
        return DigestUtils.md5DigestAsHex((password + salt).getBytes());
    }

    public static boolean checkPassword(UserPassport userPassport, String password) {
        if (salt(password, userPassport.getSalt()).equals(userPassport.getPasswordSalt())) {
            return true;
        } else {
            return false;
        }
    }

    public static String generateTicket(String email) {
        return DigestUtils.md5DigestAsHex((email + random.nextInt() + System.currentTimeMillis())
                .getBytes());
    }

    public static String generateSalt() {
        return StringUtils.substring(DigestUtils.md5DigestAsHex(("" + random.nextInt() + System
                .currentTimeMillis()).getBytes()), 20);
    }

    public static String getTicketFromCookie(HttpServletRequest request) {
        String ticket = CookieUtils.getCookie(request, CookieUtils.TICKET_KEY);
        return ticket;
    }

    public static void saveUserPassportCookie(HttpServletResponse response, UserPassport userPassport) {
        CookieUtils.saveCookie(response, CookieUtils.TICKET_KEY, userPassport.getTicket(),
                (int) TimeUnit.DAYS.toSeconds(30), "/");
    }

}
