package us.codecraft.blackhole.suite.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * User: cairne
 * Date: 13-5-13
 * Time: 下午10:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-*.xml"})
public class ZonesDaoTest {

    @Resource
    private ZonesFileDao zonesFileDao;

    @Ignore
    @Test
    public void test(){
        System.out.println(zonesFileDao.findPublic());
        System.out.println(zonesFileDao.load(1));
    }
}
