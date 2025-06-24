package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// This will only run if there were tests failed based on LOC 15 on webRunner class

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"@target/rerunFails.txt"},
        glue = {"stepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true)

public class RunnerFailsTest {
}
