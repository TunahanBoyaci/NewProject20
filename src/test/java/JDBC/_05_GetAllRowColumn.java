package JDBC;

import Utilities.DatabaseUtilities;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _05_GetAllRowColumn extends DatabaseUtilities {

    @Test
    public void test1() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from language");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData(); // stores the names, types and number of columns

        int columnCount = resultSetMetaData.getColumnCount();
//        System.out.println("columnCount = " + columnCount);

        String columnName = resultSetMetaData.getColumnName(2);
//        System.out.println("columnName = " + columnName);

        // Write the code to get name and type of each column
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            columnName = resultSetMetaData.getColumnName(i);
            System.out.println("columnName = " + columnName);

            String columnType = resultSetMetaData.getColumnTypeName(i);
            System.out.println("columnType = " + columnType);
        }

    }

    // Write a code to print language table as it is shown on MySQL Workbench



}
