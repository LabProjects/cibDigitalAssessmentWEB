package stepDefinitions;

import io.cucumber.java.en.*;
import static repos.Actions.*;
import static repos.utils.*;
import org.openqa.selenium.By;
import repos.webtablesObj;


// This class will work with almost all the classes Utils, Actions)
// Inside each methods that are in this class will implement a code that will make the step in the Feature file to work
// It's all about BDD

public class StepDefwebtables
{
    @Given("User is currently on webtables site")
    public void userIsCurrentlyOnWebtablesSite()
    {
        try {
            launchSite(xmlReader("browser"), xmlReader("URLweb"));
            checkObjectExists(webtablesObj.lnkaddUser);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @When("User clicks on the Add User link")
    public void userClicksOnTheAddUserLink()
    {
        clickObject(webtablesObj.lnkaddUser);
    }

    @Then("Add User screen pop up")
    public void addUserScreenPopUp()
    {
        checkObjectExists(webtablesObj.txtFirstName);
    }

    @When("User enter FirstName, LastName, UserName, Password {string},{string},{string},{string}")
    public void userEnterFirstNameLastNameUserNamePassword(String Fname, String Lname, String User, String Pass)
    {
     enterText(webtablesObj.txtFirstName,Fname);
     enterText(webtablesObj.txtLastName,Lname);
     enterText(webtablesObj.txtUserName,User);
     enterText(webtablesObj.txtPassword,Pass);
    }

    @And("User check Customer {string}")
    public void userCheckCustomer(String cus)
    {
        if(cus.matches("Company AAA"))
        {
            clickObject(webtablesObj.radCustomerAAA);
        }
        else {
            clickObject(webtablesObj.radCustomerBBB);
        }
    }

    @And("User select Role {string}")
    public void userSelectRole(String role) {
        if(role.matches("Admin"))
        {
            clickObject(webtablesObj.drpAdminRole);
        }
        else {
            clickObject(webtablesObj.drpCustomerRole);
        }
    }

    @When("User provide email {string}")
    public void userProvideEmail(String email)
    {
        enterText(webtablesObj.txtEmail,email);
    }

    @And("User provide Cell phone number {string}")
    public void userProvideCellPhoneNumber(String cellphone)
    {
        enterText(webtablesObj.txtCellPhone,cellphone);
    }

    @Then("All details captured")
    public void allDetailsCaptured()
    {
        checkObjectExists(webtablesObj.lblAddUser);
    }

    @When("User click save to add the record to the table")
    public void userClickSaveToAddTheRecordToTheTable()
    {
        clickObject(webtablesObj.btnSave);
    }

    @Then("User validate if the record was added {string}")
    public void userValidateIfTheRecordWasAdded(String user)
    {
        By checkpoint = By.xpath("//tr/td[text()='"+user+"']");
        checkObjectExists(checkpoint);
    }


}
