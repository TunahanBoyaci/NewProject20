package Runners;

import Utilities.ParameterDriver;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions (
        features = {"src/test/java/FeatureFiles/_01_Login.feature",
        "src/test/java/FeatureFiles/_08_CitizenshipWithApachePOI.feature"},
        glue = "StepDefinitions",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)

public class _08_RunnerForParallelTest extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters (value = "browser")
    public void beforeClass(String browserName){
        ParameterDriver.setThreadDriverName(browserName);
    }

    @AfterClass
    public void writeOnExtentReport(){
        ExtentService.getInstance().setSystemInfo("Windows User Name",System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone",System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("Tester Name","Tunahan Boyaci");
        ExtentService.getInstance().setSystemInfo("Application Name","Campus");
        ExtentService.getInstance().setSystemInfo("Operating System",System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department","QA");
    }

}