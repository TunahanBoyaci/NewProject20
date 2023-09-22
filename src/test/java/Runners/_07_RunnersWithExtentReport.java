package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "src/test/java/FeatureFiles/_01_Login.feature",
        glue = "StepDefinitions",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)

public class _07_RunnersWithExtentReport extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void writeOnExtentReport(){
        ExtentService.getInstance().setSystemInfo("Windows User Name",System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone",System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("Tester Name","Tunahan Boyaci");
        ExtentService.getInstance().setSystemInfo("Application Name","Campus");
        ExtentService.getInstance().setSystemInfo("Operating System",System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department","QA");
    }
}