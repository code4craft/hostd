package us.codecraft.blackhole.suite.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: cairne
 * Date: 13-5-15
 * Time: 上午6:34
 */
public class JsonResult {

    private final int code;

    private final String msg;

    private JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static JsonResult success(String msg) {
        return new JsonResult(200, msg);
    }

    public static JsonResult error(String msg) {
        return new JsonResult(500, msg);
    }

    public static JsonResult result(int code, String msg) {
        return new JsonResult(code, msg);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Map<String,Object> toMap(){
        Map<String,Object> resultMap = new LinkedHashMap<String, Object>();
        resultMap.put("code",code);
        resultMap.put("msg",msg);
        return resultMap;
    }
}
