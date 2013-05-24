package us.codecraft.blackhole.suite.exception;

/**
 * @author cairne
 * @date 2012-3-31
 */
public class LoginException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final String code;

    public LoginException(String code) {
        super(code);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
