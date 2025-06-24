package repos;

import org.openqa.selenium.By;

// All objects/elements that are stored inside here are for easy maintenance and they can be called under step def class
public class webtablesObj
{
    public static By lnkaddUser = By.xpath("//button[@type='add']"),
      txtFirstName = By.name("FirstName"),
      txtLastName = By.name("LastName"),
      txtUserName = By.name("UserName"),
      txtPassword = By.name("Password"),
      radCustomerAAA = By.xpath("//input[@value='15']"),
      radCustomerBBB = By.xpath("//input[@value='16']"),
      drpCustomerRole = By.xpath("//select/option[text()='Customer']"),
      drpAdminRole = By.xpath("//select/option[text()='Admin']"),
      txtEmail = By.name("Email"),
      txtCellPhone = By.name("Mobilephone"),
    lblAddUser = By.xpath("//h3[text()='Add User']"),
      btnSave = By.xpath("//button[text()='Save'][@class='btn btn-success']");

}
