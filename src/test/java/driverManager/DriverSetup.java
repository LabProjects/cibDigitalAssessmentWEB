package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

// This class support the browser engine based on request and all of these are driven by drivermanager dependency

public class DriverSetup {
    //    public static WebDriver driver=null;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver()
    {
        return driver.get();
    }
    public static void setDriver(String browser)
    {
        WebDriver driverInstance = null;
        switch (browser.toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driverInstance = new ChromeDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--guest");
                driverInstance = new EdgeDriver(options);
                driverInstance.manage().deleteAllCookies();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driverInstance = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser.toUpperCase());
        }
        driverInstance.manage().window().maximize();
        driver.set(driverInstance);
    }

    public static void quitDriver() {
        WebDriver driverinstance = getDriver();
        if(driverinstance != null)
        {
            driverinstance.quit();
            driver.remove();;
        }
    }
}
