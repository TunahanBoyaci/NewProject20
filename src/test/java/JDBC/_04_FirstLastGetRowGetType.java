package JDBC;

import Utilities.DatabaseUtilities;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_FirstLastGetRowGetType extends DatabaseUtilities {

    @Test
    public void test1() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select city_id, city, country_id from city");

        resultSet.last();

        String cityName = resultSet.getString("city");
        System.out.println("city name from the last row = " + cityName);

        int cityId = resultSet.getInt("city_id");
        System.out.println("cityId as an int = " + cityId);

        String cityIdStr = resultSet.getString("city_id");
        System.out.println("cityId as a String = " + cityIdStr);

        resultSet.absolute(123);
        int currentRowNumber = resultSet.getRow(); // Gives the number of the current row, not id of the row
        System.out.println("currentRowNumber = " + currentRowNumber);

        resultSet.last();
        int numberOfTheLastRow = resultSet.getRow();
        System.out.println("numberOfRows = " + numberOfTheLastRow);

        resultSet.first();
        cityName = resultSet.getString("city");
        System.out.println("cityName from the first row = " + cityName);


    }

}
