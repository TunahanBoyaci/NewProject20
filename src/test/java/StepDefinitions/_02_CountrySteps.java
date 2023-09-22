package StepDefinitions;

import PageObjectModels.DialogContent;
import PageObjectModels.LeftNavBar;
import Utilities.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class _02_CountrySteps {
    LeftNavBar leftNavBar = new LeftNavBar();
    DialogContent dialogContent = new DialogContent();

    @And("Navigate to Country page")
    public void navigateToCountryPage() {
        leftNavBar.clickMethod(leftNavBar.setupButton);
        leftNavBar.clickMethod(leftNavBar.parametersButton);
        leftNavBar.clickMethod(leftNavBar.countriesButton);
    }

    @When("Create a new country")
    public void createANewCountry() {
        dialogContent.clickMethod(dialogContent.addButton);
        dialogContent.sendKeysMethod(dialogContent.nameInbox,"12dwqd");
        dialogContent.sendKeysMethod(dialogContent.codeInbox,"121swq");
        dialogContent.clickMethod(dialogContent.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dialogContent.assertText(dialogContent.successMessage,"successfully");
    }

    @And("Click on add Button")
    public void clickOnAddButton() {
        dialogContent.clickMethod(dialogContent.addButton);
    }

    @And("Enter {string} as country name and {string} as country code")
    public void enterAsCountryNameAndAsCountryCode(String countryName, String countryCode) {
        dialogContent.sendKeysMethod(dialogContent.nameInbox,countryName);
        dialogContent.sendKeysMethod(dialogContent.codeInbox,countryCode);
    }

    @When("Click on save button")
    public void clickOnSaveButton() {
        dialogContent.clickMethod(dialogContent.saveButton);
    }


}
