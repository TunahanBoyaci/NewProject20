package StepDefinitions;

import PageObjectModels.DialogContent;
import PageObjectModels.LeftNavBar;
import Utilities.ParameterDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _03_CitizenshipSteps {
    LeftNavBar leftNavBar = new LeftNavBar();
    DialogContent dialogContent = new DialogContent();

    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {
        leftNavBar.clickMethod(leftNavBar.setupButton);
        leftNavBar.clickMethod(leftNavBar.parametersButton);
        leftNavBar.clickMethod(leftNavBar.citizenshipButton);
    }

    @Then("Enter {string} as citizenship name and {string} as short name")
    public void enterAsCitizenshipNameAndAsShortName(String citizenshipName, String citizenshipShortName) {
        dialogContent.sendKeysMethod(dialogContent.nameInboxSearchInboxAdd2, citizenshipName);
        dialogContent.sendKeysMethod(dialogContent.shortNameAdd2, citizenshipShortName);
    }

    @And("Search for {string} as citizenship name and {string} as short name")
    public void searchForAsCitizenshipNameAndAsShortName(String citizenshipName, String citizenshipShortName) {
        dialogContent.sendKeysMethod(dialogContent.nameInboxSearchInboxSearch1, citizenshipName);
        dialogContent.sendKeysMethod(dialogContent.shortNameSearchInboxSearch1, citizenshipShortName);
        dialogContent.clickMethod(dialogContent.searchButton);
    }

    @And("Search for {string} as country name and {string} as code")
    public void searchForAsCountryNameAndAsCode(String name, String code) {
        dialogContent.sendKeysMethod(dialogContent.nameInboxSearchInboxSearch1, name);
        dialogContent.sendKeysMethod(dialogContent.codeInboxSearchInboxSearch, code);
        dialogContent.clickMethod(dialogContent.searchButton);
    }

    @When("Click on Delete and Confirm")
    public void clickOnDeleteAndConfirm() {
        dialogContent.clickMethod(dialogContent.deleteButton);
        dialogContent.clickMethod(dialogContent.deleteConfirmButton);
    }


}
