package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "src/test/java/FeatureFiles/_01_Login.feature",
        glue = "StepDefinitions",
        plugin = "html:target/site/cucumber-pretty.html"
)

public class _05_RunnerWithPlugIn extends AbstractTestNGCucumberTests {
}
