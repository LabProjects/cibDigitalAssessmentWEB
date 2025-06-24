package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@webdetail",
        features = {"src/test/resources/Features"},
        glue = {"stepDefinitions"},
        plugin = {"rerun:target/rerunFails.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class webRunnerTest {
}
