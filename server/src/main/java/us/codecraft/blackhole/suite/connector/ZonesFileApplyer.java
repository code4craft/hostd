package us.codecraft.blackhole.suite.connector;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * User: cairne
 * Date: 13-5-13
 * Time: 上午7:51
 */
@Service
public class ZonesFileApplyer {

    @Autowired
    private BlackholeConnector blackholeConnector;

    private Logger logger = Logger.getLogger(getClass());

    public void apply(String ip, String text) {

        BufferedReader bufferedReader = new BufferedReader(new StringReader(
                text));
        String line = null;
        try {
            blackholeConnector.deleteAllByIp(ip);
            while ((line = bufferedReader.readLine()) != null) {
                blackholeConnector.addByIp(ip, line);
            }
        } catch (IOException e) {
            logger.info("wtf!??", e);
        }
    }
}
