package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "src/test/java/FeatureFiles/_03_Citizenship.feature",
        glue = "StepDefinitions",
        tags = "Regression",
        plugin = {"pretty", "html:target/site/cucmber-pretty", "json:target/cucumber/cucumber.json"}
)

public class _01_RunnersIntro extends AbstractTestNGCucumberTests {

}
