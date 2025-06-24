package repos;

import driverManager.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.time.Duration;

// These are just reusable actions from webDriver, In short anything to do with the driver
public class Actions extends DriverSetup
{

    public static boolean checkObjectExists(By element){
        WebDriver driver = DriverSetup.getDriver();
        boolean exists=false;
        try{
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            if(driver.findElement(element).isDisplayed())
            {
                exists=true;
            } else {
                System.out.println("The element is not visible.");
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return exists;
    }
    public static void clickObject(By element){
        WebDriver driver = DriverSetup.getDriver();
        checkObjectExists(element);
        driver.findElement(element).click();
    }
    public static void enterText(By element, String text){
        WebDriver driver = DriverSetup.getDriver();
        checkObjectExists(element);
        driver.findElement(element).sendKeys(text);
    }
     public static void launchSite(String browser, String URL){
         WebDriver driver = DriverSetup.getDriver();
//        driver = getDriver(browser);
        driver.navigate().to(URL);
    }

}
