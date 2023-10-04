package StepDefinitions;

import PageObjectModels.DialogContent;
import PageObjectModels.LeftNavBar;
import Utilities.BaseDriver;
import Utilities.ParameterDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.ht.Le;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _05_FeeFunctionality {
    LeftNavBar leftNavBar = new LeftNavBar();
    DialogContent dialogContent = new DialogContent();

    @And("Navigate to Fees page")
    public void navigateToFeesPage() {
        leftNavBar.clickMethod(leftNavBar.setupButton);
        leftNavBar.clickMethod(leftNavBar.parametersButton);
        leftNavBar.clickMethod(leftNavBar.feesButton);
    }

    @And("Fill the add fee form")
    public void fillTheAddFeeForm(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);

        dialogContent.sendKeysMethod(dialogContent.nameFeeType, dataList.get(0));
        dialogContent.sendKeysMethod(dialogContent.codeInbox, dataList.get(1));
        dialogContent.sendKeysMethod(dialogContent.IntegrationFeeType, dataList.get(2));
        dialogContent.sendKeysMethod(dialogContent.prioirityFeeType, dataList.get(3));

        Actions actions = new Actions(ParameterDriver.getDriver());
        Action action = actions.sendKeys(Keys.TAB).build();
        action.perform();
    }

    @And("Search for {string} as code")
    public void searchForAsCode(String code) {
        dialogContent.sendKeysMethod(dialogContent.codeInboxSearchInboxSearch, code);
        dialogContent.clickMethod(dialogContent.searchButton);
    }

    @When("Click on save and new button")
    public void clickOnSaveAndNewButton() {
        dialogContent.clickMethod(dialogContent.saveAndNewButton);
    }
}
