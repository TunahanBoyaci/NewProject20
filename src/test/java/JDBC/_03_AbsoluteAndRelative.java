package JDBC;

import Utilities.DatabaseUtilities;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteAndRelative extends DatabaseUtilities {

    @Test
    public void test1() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from film");
        resultSet.absolute(10);

        String title;

        resultSet.absolute(3);
        title = resultSet.getString("title");
        System.out.println("title from the 3rd row = " + title);

        resultSet.relative(20);
        title = resultSet.getString("title");
        System.out.println("title from the 23rd row = " + title);

        resultSet.relative(-14);
        title = resultSet.getString("title");
        System.out.println("title from the 9th row = " + title);


    }

}
