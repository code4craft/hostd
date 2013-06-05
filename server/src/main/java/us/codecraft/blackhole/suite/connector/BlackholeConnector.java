package us.codecraft.blackhole.suite.connector;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import us.codecraft.wifesays.wife.WifeSays;

import java.io.IOException;

/**
 * User: cairne
 * Date: 13-5-13
 * Time: 上午7:44
 */
@Service
public class BlackholeConnector implements InitializingBean {

    //delete_zones_ip_192.168.0.1
    private static final String DELETE_ZONES_IP = "delete_zones_ip_";
    //add_zones_ip_192.168.0.1:127.0.0.1_*.dianping.com
    private static final String ADD_ZONES_IP = "add_zones_ip_";

    private WifeSays wifeSays;

    private Logger logger = Logger.getLogger(getClass());

    public void deleteAllByIp(String ip) {
        wifeSays.say(DELETE_ZONES_IP + ip);
    }

    public void addByIp(String ip, String line) {
        if (line.startsWith("#")) {
            return;
        }
        if (line.contains(":")) {
            line = StringUtils.substringAfterLast(line, ":");
        }
        line = StringUtils.trim(line);
        line = line.replaceAll("\\s+#[^\\s]+", "");
        line = line.replaceAll("\\s+", "_");
        wifeSays.say(ADD_ZONES_IP + ip + ":" + line);
    }

    public boolean isConnected() {
        return wifeSays.isConnected();
    }

    public void setConnected(boolean connected) {
        wifeSays.setConnected(connected);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        wifeSays = new WifeSays();
        try {
            wifeSays.connect();
        } catch (IOException e) {
            logger.warn("connnect error", e);
        }
    }
}
