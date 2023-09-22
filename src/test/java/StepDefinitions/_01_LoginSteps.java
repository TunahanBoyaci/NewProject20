package StepDefinitions;

import PageObjectModels.DialogContent;
import Utilities.BaseDriver;
import Utilities.ParameterDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _01_LoginSteps {
    DialogContent dialogContent = new DialogContent();

    @Given("Navigate to Campus")
    public void navigate_to_campus() {
        ParameterDriver.getDriver().get("https://test.mersys.io/");
    }

    @Given("Enter username and password")
    public void enter_username_and_password() {
        dialogContent.sendKeysMethod(dialogContent.usernameInbox,"turkeyts");
        dialogContent.sendKeysMethod(dialogContent.passwordInbox,"TechnoStudy123");
    }

    @When("Click on login Button")
    public void click_on_login_button() {
        dialogContent.loginButton.click();
    }

    @Then("User should be loged in successfully")
    public void user_should_be_loged_in_successfully() {
        dialogContent.assertText(dialogContent.dashboardButton, "Dashboard");
    }
}
