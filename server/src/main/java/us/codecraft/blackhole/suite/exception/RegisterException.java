package us.codecraft.blackhole.suite.exception;

/**
 *
 */
public class RegisterException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final String code;

    public RegisterException(String code) {
        super(code);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
