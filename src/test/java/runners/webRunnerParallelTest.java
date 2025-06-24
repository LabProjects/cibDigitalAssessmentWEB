package runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        tags = "@Parallel",
        features = {"src/test/resources/Features"},
        glue = {"stepDefinitions"},
        plugin = {"rerun:target/rerunFails.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class webRunnerParallelTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}