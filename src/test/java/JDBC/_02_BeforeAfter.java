package JDBC;

import org.testng.annotations.*;

import java.sql.*;

public class _02_BeforeAfter {

    private Connection connection;
    private Statement statement;

    @BeforeMethod
    public void DBConnection() throws SQLException {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z"; // '\"-LhCB'.%k[4S]z

        connection = DriverManager.getConnection(url,username,password);

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

    }

    @AfterMethod
    public void DBConnectionClose() throws SQLException {
        connection.close();
    }

    @Test
    public void test1() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from language");
        resultSet.next();
        String language = resultSet.getString("name");
        System.out.println(language);
    }

    @Test
    public void test2() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from language");
        resultSet.next();
        String language = resultSet.getString("name");
        System.out.println("1st language" + language);

        resultSet.next();
        language = resultSet.getString("name");
        System.out.println("2nd language" + language);

        resultSet.previous();
        language = resultSet.getString("name");
        System.out.println("1st language" + language);



    }

}
