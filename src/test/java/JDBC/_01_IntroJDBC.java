package JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_IntroJDBC {

    @Test
    public void test1() throws SQLException {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z"; // '\"-LhCB'.%k[4S]z

        Connection connection = DriverManager.getConnection(url,username,password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from actor");

        resultSet.next();

        String firstName = resultSet.getString(2);
        System.out.println(firstName);

        String lastName = resultSet.getString(3);
        System.out.println(lastName);

        resultSet.next();

        String firstName2 = resultSet.getString(2);
        System.out.println(firstName2);

        String lastName2 = resultSet.getString(3);
        System.out.println(lastName2);

        connection.close();

    }

}
