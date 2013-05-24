package us.codecraft.blackhole.suite.init;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * User: cairne
 * Date: 13-5-11
 * Time: 上午7:32
 */
public class SqliteDao {

    private DataSource dataSource;

    public SqliteDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void excute(String query) throws SQLException {
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
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                e.printStackTrace();
            }
        }
    }
}
