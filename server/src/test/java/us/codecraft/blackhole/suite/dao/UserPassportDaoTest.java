package us.codecraft.blackhole.suite.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.codecraft.blackhole.suite.model.UserPassport;

import javax.annotation.Resource;

/**
 * User: cairne
 * Date: 13-5-13
 * Time: 下午8:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-*.xml"})
public class UserPassportDaoTest {
    @Resource
    private UserPassportDAO userPassportDAO;

    @Ignore
    @Test
    public void test() {
        UserPassport userPassport = new UserPassport("admin", "admin123", "123", "12345161");
        try {
            int insert = userPassportDAO.insert(userPassport);
            System.out.println(insert);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserPassport byTicket = userPassportDAO.getByTicket("123456");
        System.out.println(byTicket);
        UserPassport cairne = userPassportDAO.getByUsername("cairne");
        System.out.println(cairne);
    }
}
