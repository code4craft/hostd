package us.codecraft.blackhole.suite.utils;

import org.junit.Assert;
import org.junit.Test;
import us.codecraft.blackhole.suite.util.UserZonesUtils;

import java.io.IOException;

/**
 * User: cairne
 * Date: 13-5-26
 * Time: 下午4:45
 */
public class UserZonesUtilsTest {

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
        String json = UserZonesUtils.toJson(text);
        Assert.assertEquals(json,"[{\"domain\":\"www.baidu.com\",\"config\":[{\"domain\":\"www.baidu.com\",\"active\":false,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"www.xu.com\",\"config\":[{\"domain\":\"www.xu.com\",\"active\":false,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"ctx.lc\",\"config\":[{\"domain\":\"ctx.lc\",\"active\":true,\"ip\":\"192.168.61.91\"}]},{\"domain\":\"hyh.local.dp\",\"config\":[{\"domain\":\"hyh.local.dp\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"m1.img.libdd.com\",\"config\":[{\"domain\":\"m1.img.libdd.com\",\"active\":false,\"ip\":\"10.10.5.100\"}]},{\"domain\":\"m2.img.libdd.com\",\"config\":[{\"domain\":\"m2.img.libdd.com\",\"active\":false,\"ip\":\"10.10.5.100\"}]},{\"domain\":\"m3.img.libdd.com\",\"config\":[{\"domain\":\"m3.img.libdd.com\",\"active\":false,\"ip\":\"10.10.5.100\"}]},{\"domain\":\"a.libdd.com\",\"config\":[{\"domain\":\"a.libdd.com\",\"active\":false,\"ip\":\"10.10.5.100\"},{\"domain\":\"a.libdd.com\",\"active\":false,\"ip\":\"10.10.5.100\"}]},{\"domain\":\"asdaaa1231.diandian.com\",\"config\":[{\"domain\":\"asdaaa1231.diandian.com\",\"active\":false,\"ip\":\"10.10.5.11\"}]},{\"domain\":\"testqqtransfer6.diandian.com\",\"config\":[{\"domain\":\"testqqtransfer6.diandian.com\",\"active\":false,\"ip\":\"10.10.5.11\"}]},{\"domain\":\"#testdaily.diandian.com\",\"config\":[{\"domain\":\"#testdaily.diandian.com\",\"active\":false,\"ip\":\"10.10.5.11\"}]},{\"domain\":\"s.libdd.com\",\"config\":[{\"domain\":\"s.libdd.com\",\"active\":false,\"ip\":\"10.10.5.11\"},{\"domain\":\"s.libdd.com\",\"active\":false,\"ip\":\"G10.10.7.38\"}]},{\"domain\":\"ops.d.diandian.com\",\"config\":[{\"domain\":\"ops.d.diandian.com\",\"active\":false,\"ip\":\"10.10.5.11\"}]},{\"domain\":\"www.fashiondes.com\",\"config\":[{\"domain\":\"www.fashiondes.com\",\"active\":false,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"www.diandian.com\",\"config\":[{\"domain\":\"www.diandian.com\",\"active\":false,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"www.ycool.com\",\"config\":[{\"domain\":\"www.ycool.com\",\"active\":false,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"activate.adobe.com\",\"config\":[{\"domain\":\"activate.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"practivate.adobe.com\",\"config\":[{\"domain\":\"practivate.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"ereg.adobe.com\",\"config\":[{\"domain\":\"ereg.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"activate.wip3.adobe.com\",\"config\":[{\"domain\":\"activate.wip3.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"wip3.adobe.com\",\"config\":[{\"domain\":\"wip3.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"3dns-3.adobe.com\",\"config\":[{\"domain\":\"3dns-3.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"3dns-2.adobe.com\",\"config\":[{\"domain\":\"3dns-2.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"adobe-dns.adobe.com\",\"config\":[{\"domain\":\"adobe-dns.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"adobe-dns-2.adobe.com\",\"config\":[{\"domain\":\"adobe-dns-2.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"adobe-dns-3.adobe.com\",\"config\":[{\"domain\":\"adobe-dns-3.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"ereg.wip3.adobe.com\",\"config\":[{\"domain\":\"ereg.wip3.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"activate-sea.adobe.com\",\"config\":[{\"domain\":\"activate-sea.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"wwis-dubc1-vip60.adobe.com\",\"config\":[{\"domain\":\"wwis-dubc1-vip60.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"activate-sjc0.adobe.com\",\"config\":[{\"domain\":\"activate-sjc0.adobe.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"adobe.activate.com\",\"config\":[{\"domain\":\"adobe.activate.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"209.34.83.73:443\",\"config\":[{\"domain\":\"209.34.83.73:443\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"209.34.83.73:43\",\"config\":[{\"domain\":\"209.34.83.73:43\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"209.34.83.73\",\"config\":[{\"domain\":\"209.34.83.73\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"209.34.83.67:443\",\"config\":[{\"domain\":\"209.34.83.67:443\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"209.34.83.67:43\",\"config\":[{\"domain\":\"209.34.83.67:43\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"209.34.83.67\",\"config\":[{\"domain\":\"209.34.83.67\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"ood.opsource.net\",\"config\":[{\"domain\":\"ood.opsource.net\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"CRL.VERISIGN.NET\",\"config\":[{\"domain\":\"CRL.VERISIGN.NET\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"199.7.52.190:80\",\"config\":[{\"domain\":\"199.7.52.190:80\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"199.7.52.190\",\"config\":[{\"domain\":\"199.7.52.190\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"adobeereg.com\",\"config\":[{\"domain\":\"adobeereg.com\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"OCSP.SPO1.VERISIGN.COM\",\"config\":[{\"domain\":\"OCSP.SPO1.VERISIGN.COM\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"199.7.54.72:80\",\"config\":[{\"domain\":\"199.7.54.72:80\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"199.7.54.72\",\"config\":[{\"domain\":\"199.7.54.72\",\"active\":true,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"github.com\",\"config\":[{\"domain\":\"github.com\",\"active\":true,\"ip\":\"207.97.227.239\"},{\"domain\":\"github.com\",\"active\":false,\"ip\":\"127.0.0.1\"}]},{\"domain\":\"nodeload.github.com\",\"config\":[{\"domain\":\"nodeload.github.com\",\"active\":true,\"ip\":\"207.97.227.252\"}]},{\"domain\":\"raw.github.com\",\"config\":[{\"domain\":\"raw.github.com\",\"active\":true,\"ip\":\"207.97.227.243\"}]},{\"domain\":\"documentcloud.github.com\",\"config\":[{\"domain\":\"documentcloud.github.com\",\"active\":true,\"ip\":\"204.232.175.78\"}]},{\"domain\":\"gist.github.com\",\"config\":[{\"domain\":\"gist.github.com\",\"active\":true,\"ip\":\"204.232.175.94\"}]}]");
        String text2 = UserZonesUtils.fromJson(json);
        Assert.assertEquals(text2,"#127.0.0.1\twww.baidu.com\n" +
                "#127.0.0.1\twww.xu.com\n" +
                "192.168.61.91\tctx.lc\n" +
                "127.0.0.1\thyh.local.dp\n" +
                "#10.10.5.100\tm1.img.libdd.com\n" +
                "#10.10.5.100\tm2.img.libdd.com\n" +
                "#10.10.5.100\tm3.img.libdd.com\n" +
                "#10.10.5.100\ta.libdd.com\n" +
                "#10.10.5.100\ta.libdd.com\n" +
                "#10.10.5.11\tasdaaa1231.diandian.com\n" +
                "#10.10.5.11\ttestqqtransfer6.diandian.com\n" +
                "#10.10.5.11\t#testdaily.diandian.com\n" +
                "#10.10.5.11\ts.libdd.com\n" +
                "#G10.10.7.38\ts.libdd.com\n" +
                "#10.10.5.11\tops.d.diandian.com\n" +
                "#127.0.0.1\twww.fashiondes.com\n" +
                "#127.0.0.1\twww.diandian.com\n" +
                "#127.0.0.1\twww.ycool.com\n" +
                "127.0.0.1\tactivate.adobe.com\n" +
                "127.0.0.1\tpractivate.adobe.com\n" +
                "127.0.0.1\tereg.adobe.com\n" +
                "127.0.0.1\tactivate.wip3.adobe.com\n" +
                "127.0.0.1\twip3.adobe.com\n" +
                "127.0.0.1\t3dns-3.adobe.com\n" +
                "127.0.0.1\t3dns-2.adobe.com\n" +
                "127.0.0.1\tadobe-dns.adobe.com\n" +
                "127.0.0.1\tadobe-dns-2.adobe.com\n" +
                "127.0.0.1\tadobe-dns-3.adobe.com\n" +
                "127.0.0.1\tereg.wip3.adobe.com\n" +
                "127.0.0.1\tactivate-sea.adobe.com\n" +
                "127.0.0.1\twwis-dubc1-vip60.adobe.com\n" +
                "127.0.0.1\tactivate-sjc0.adobe.com\n" +
                "127.0.0.1\tadobe.activate.com\n" +
                "127.0.0.1\t209.34.83.73:443\n" +
                "127.0.0.1\t209.34.83.73:43\n" +
                "127.0.0.1\t209.34.83.73\n" +
                "127.0.0.1\t209.34.83.67:443\n" +
                "127.0.0.1\t209.34.83.67:43\n" +
                "127.0.0.1\t209.34.83.67\n" +
                "127.0.0.1\tood.opsource.net\n" +
                "127.0.0.1\tCRL.VERISIGN.NET\n" +
                "127.0.0.1\t199.7.52.190:80\n" +
                "127.0.0.1\t199.7.52.190\n" +
                "127.0.0.1\tadobeereg.com\n" +
                "127.0.0.1\tOCSP.SPO1.VERISIGN.COM\n" +
                "127.0.0.1\t199.7.54.72:80\n" +
                "127.0.0.1\t199.7.54.72\n" +
                "207.97.227.239\tgithub.com\n" +
                "#127.0.0.1\tgithub.com\n" +
                "207.97.227.252\tnodeload.github.com\n" +
                "207.97.227.243\traw.github.com\n" +
                "204.232.175.78\tdocumentcloud.github.com\n" +
                "204.232.175.94\tgist.github.com");
    }

    @Test
    public void testMerge() {
        String textA = "192.168.9.101 www.dianping.com\n" +
                "#192.168.9.102 www.dianping.com\n" +
                "192.168.9.101 www.diandian.com";
        String textB = "127.0.0.1 www.dianping.com www.diandian.com";
        String merge = UserZonesUtils.merge(textA, textB);
        Assert.assertEquals("www.dianping.com\t192.168.9.101\n" +
                "#www.dianping.com\t192.168.9.102\n" +
                "#www.dianping.com\t127.0.0.1\n" +
                "www.diandian.com\t192.168.9.101\n" +
                "#www.diandian.com\t127.0.0.1",merge);
    }
}
