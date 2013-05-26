package us.codecraft.blackhole.suite.init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.blackhole.suite.dao.ZonesFileDAO;
import us.codecraft.blackhole.suite.exception.RegisterException;
import us.codecraft.blackhole.suite.model.ZonesFile;
import us.codecraft.blackhole.suite.service.UserPassportSerivce;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * User: cairne
 * Date: 13-5-19
 * Time: 下午6:02
 */
public class InitData {

    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        SqliteDao sqliteDao = new SqliteDao(dataSource);
        sqliteDao.excute("CREATE TABLE User_Passport (\n" +
                "  `id` INTEGER primary key AUTOINCREMENT,\n" +
                "  `username` text UNIQUE,\n" +
                "  `passwordSalt` string,\n" +
                "  `salt` string,\n" +
                "  `ticket` text UNIQUE,\n" +
                "  `zones` string default \"\"\n" +
                ");");
        sqliteDao.excute("CREATE TABLE ZonesFile (\n" +
                "  `id` INTEGER primary key AUTOINCREMENT,\n" +
                "  `type` INTEGER,\n" +
                "  `name` string,\n" +
                "  `text` string,\n" +
                "  `user` string\n" +
                ");");
        UserPassportSerivce userPassportSerivce = applicationContext.getBean(UserPassportSerivce.class);
        try {
            userPassportSerivce.addUserPassport("admin","admin123");
        } catch (RegisterException e) {
        }
        ZonesFileDAO zonesFileDAO = applicationContext.getBean(ZonesFileDAO.class);
        zonesFileDAO.add(new ZonesFile().setName("sample").setText("127.0.0.1 localhost\n" +
                "69.171.229.25 *.facebook.com").setType(1).setUser("admin"));
    }
}
