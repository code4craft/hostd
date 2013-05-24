package us.codecraft.blackhole.suite.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * User: cairne
 * Date: 13-5-11
 * Time: 上午7:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-*.xml"})
public class SqliteDaoTest {

    @Autowired
    private DataSource dataSource;

    @Ignore
    @Test
    public void test() throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            // create a database connection
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("create table person (id integer, name string) if not exists person");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            ResultSet rs = statement.executeQuery("select * from person");
            while (rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }

    @Ignore
    @Test
    public void createTable() throws SQLException {
        excute("drop table if exists User_Passport");
//        excute("CREATE TABLE ZonesFile (\n" +
//                "  `id` INTEGER primary key AUTOINCREMENT,\n" +
//                "  `type` INTEGER,\n" +
//                "  `name` string,\n" +
//                "  `text` string,\n" +
//                "  `user` string\n" +
//                ");\n");
        excute("CREATE TABLE User_Passport (\n" +
                "  `id` INTEGER primary key AUTOINCREMENT,\n" +
                "  `username` text UNIQUE,\n" +
                "  `passwordSalt` string,\n" +
                "  `salt` string,\n" +
                "  `ticket` text UNIQUE\n" +
                ");");
    }

    @Ignore
    @Test
    public void insert() throws SQLException {
        excute("insert into ZonesFile (`type`,`name`,`user`,`text`) values(1,'dev','public','127.0.0.1 i*.static.dp\n" +
                "127.0.0.1 *.local.dp')");
        excute("insert into ZonesFile (`type`,`name`,`user`,`text`) values(1,'none','public','')");
    }

    private void excute(String query) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            // create a database connection
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate(query);
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}
