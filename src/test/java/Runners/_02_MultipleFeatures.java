package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "src/test/java/FeatureFiles/_01_Login.feature",
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/site/cucmber-pretty", "json:target/cucumber/cucumber.json"}
)

public class _02_MultipleFeatures extends AbstractTestNGCucumberTests {
}

