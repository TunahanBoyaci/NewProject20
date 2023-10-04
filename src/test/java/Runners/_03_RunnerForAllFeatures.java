package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = {"src/test/java/FeatureFiles/_02_Country.feature",
                    "src/test/java/FeatureFiles/_03_Citizenship.feature",
                    "src/test/java/FeatureFiles/_05_FeeFunctionality.feature",
                    "src/test/java/FeatureFiles/_07_EnteranceExam.feature",},
        glue = "StepDefinitions",
        plugin = "html:target/site/cucumber-pretty.html"
)

public class _03_RunnerForAllFeatures extends AbstractTestNGCucumberTests {
}
