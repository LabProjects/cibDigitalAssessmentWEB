package stepDefinitions;

import driverManager.DriverSetup;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static repos.utils.xmlReader;

// Hooks are there to support execution and to set the report rules
// @AfterStep will work after each and every step in the feature file has been executed by taking a screenshot and adding it to the report
// @Before will work only to manipulate scenario names or just to print them on the console or report and to play a part in controlling the driver
// This class will inherit driver from the driverManager class
// @After will quit the driver when all steps are executed as per scenario

public class Hooks {
    @Before
    public void setup(Scenario scenario) throws IOException, ParserConfigurationException, SAXException {
        System.out.println("Test Case: "+ (scenario.getName()));
        DriverSetup.setDriver(xmlReader("browser"));
        DriverSetup.getDriver().get(xmlReader("URLweb"));
    }
    @AfterStep
    public void captureScreen(Scenario scenario)
    {
        WebDriver driver = DriverSetup.getDriver();
        if(driver instanceof TakesScreenshot && scenario.isFailed()==false)
        {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "screen");
        }

    }
    @After
    public void teardown(Scenario scenario)
    {
        System.out.println("Test Case: "+ scenario.getName());
        DriverSetup.quitDriver();
    }
}