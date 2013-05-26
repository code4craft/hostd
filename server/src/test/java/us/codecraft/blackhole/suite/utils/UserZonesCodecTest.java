package us.codecraft.blackhole.suite.utils;

import org.junit.Test;
import us.codecraft.blackhole.suite.util.UserZonesCodec;

import java.io.IOException;

/**
 * User: cairne
 * Date: 13-5-26
 * Time: 下午4:45
 */
public class UserZonesCodecTest {

    @Test
    public void test() throws IOException {
        String text = "##10.10.5.12\n" +
                "#127.0.0.1 www.baidu.com www.xu.com\n" +
                "192.168.61.91 ctx.lc\n" +
                "127.0.0.1 hyh.local.dp\n" +
                "#10.10.5.100 m1.img.libdd.com m2.img.libdd.com m3.img.libdd.com a.libdd.com a.libdd.com\n" +
                "#10.10.5.11 asdaaa1231.diandian.com testqqtransfer6.diandian.com #testdaily.diandian.com \n" +
                "#10.10.5.11 s.libdd.com\n" +
                "#G10.10.7.38 s.libdd.com\n" +
                "#10.10.5.11 ops.d.diandian.com\n" +
                "#127.0.0.1 www.fashiondes.com\n" +
                "#127.0.0.1 www.diandian.com\n" +
                "#127.0.0.1 www.ycool.com\n" +
                "127.0.0.1 activate.adobe.com\n" +
                "127.0.0.1 practivate.adobe.com\n" +
                "127.0.0.1 ereg.adobe.com\n" +
                "127.0.0.1 activate.wip3.adobe.com\n" +
                "127.0.0.1 wip3.adobe.com\n" +
                "127.0.0.1 3dns-3.adobe.com\n" +
                "127.0.0.1 3dns-2.adobe.com\n" +
                "127.0.0.1 adobe-dns.adobe.com\n" +
                "127.0.0.1 adobe-dns-2.adobe.com\n" +
                "127.0.0.1 adobe-dns-3.adobe.com\n" +
                "127.0.0.1 ereg.wip3.adobe.com\n" +
                "127.0.0.1 activate-sea.adobe.com\n" +
                "127.0.0.1 wwis-dubc1-vip60.adobe.com\n" +
                "127.0.0.1 activate-sjc0.adobe.com\n" +
                "127.0.0.1 adobe.activate.com\n" +
                "127.0.0.1 209.34.83.73:443\n" +
                "127.0.0.1 209.34.83.73:43\n" +
                "127.0.0.1 209.34.83.73\n" +
                "127.0.0.1 209.34.83.67:443\n" +
                "127.0.0.1 209.34.83.67:43\n" +
                "127.0.0.1 209.34.83.67\n" +
                "127.0.0.1 ood.opsource.net\n" +
                "127.0.0.1 CRL.VERISIGN.NET\n" +
                "127.0.0.1 199.7.52.190:80\n" +
                "127.0.0.1 199.7.52.190\n" +
                "127.0.0.1 adobeereg.com\n" +
                "127.0.0.1 OCSP.SPO1.VERISIGN.COM\n" +
                "127.0.0.1 199.7.54.72:80\n" +
                "127.0.0.1 199.7.54.72\n" +
                "207.97.227.239 github.com\n" +
                "#127.0.0.1 github.com\n" +
                "207.97.227.252 nodeload.github.com\n" +
                "207.97.227.243 raw.github.com\n" +
                "204.232.175.78 documentcloud.github.com \n" +
                "204.232.175.94 gist.github.com\n";
        String s = UserZonesCodec.toJson(text);
        System.out.println(s);
        String s1 = UserZonesCodec.fromJson(s);
        System.out.println(s1);
    }
}
