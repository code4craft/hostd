package us.codecraft.blackhole.suite.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import us.codecraft.blackhole.suite.model.UserPassport;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-3-31
 */
public class RequestThreadUtils {

    private final static String PASSPORT_KEY = "userPassport";

    public static UserPassport getUserPassport() {
        return getAttribute(PASSPORT_KEY, UserPassport.class);
    }

    public static void setUserPassport(UserPassport userPassport) {
        setAttribute(PASSPORT_KEY, userPassport);
    }

    public static String getAttribute(String name) {
        return getAttribute(name, String.class);
    }

    public static <T> T getAttribute(String name, Class<T> clazz) {
        return clazz.cast(RequestContextHolder.currentRequestAttributes().getAttribute(name,
                RequestAttributes.SCOPE_REQUEST));
    }

    public static <T> void setAttribute(String name, T t) {
        RequestContextHolder.currentRequestAttributes().setAttribute(name, t,
                RequestAttributes.SCOPE_REQUEST);
    }

}
