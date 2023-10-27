package StepDefinitions;

import Utilities.ExcelUtilities;
import Utilities.ParameterDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    LocalDateTime startTime;
    LocalDateTime endTime;
    String formattedStartTime;
    String formattedEndTime;


    @Before
    public void beforeScenario() {
        startTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        formattedStartTime = startTime.format(formatter);

    }

    @After
    public void afterScenario(Scenario scenario) {
        endTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        formattedEndTime = endTime.format(formatter);

        Duration duration = Duration.between(startTime, endTime);

        if (scenario.isFailed()) {
            final byte[] byteImage = ((TakesScreenshot) ParameterDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(byteImage, "image/png", scenario.getName());
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM_dd_yyyy_hh_mm_ss_SSS");

        ExcelUtilities.writeDataToExcel("src/test/java/ApachePOI/recources/ScenarioResults" + localDateTime.format(dateTimeFormatter) + ".xlsx", scenario, formattedStartTime, formattedEndTime, duration);

        ParameterDriver.quitDriver();
    }
}