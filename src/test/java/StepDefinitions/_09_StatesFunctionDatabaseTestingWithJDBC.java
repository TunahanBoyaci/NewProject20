package StepDefinitions;

import PageObjectModels.DialogContent;
import PageObjectModels.LeftNavBar;
import Utilities.DatabaseUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class _09_StatesFunctionDatabaseTestingWithJDBC {
    LeftNavBar leftNavBar = new LeftNavBar();
    DialogContent dialogContent = new DialogContent();

    @Given("Navigate to States page")
    public void navigateToStatesPage() {
        leftNavBar.clickMethod(leftNavBar.setupButton);
        leftNavBar.clickMethod(leftNavBar.parametersButton);
        leftNavBar.clickMethod(leftNavBar.statesButton);
    }

    List<List<String>> dataFromDatabase;

    @When("Send the query {string}")
    public void sendTheQuery(String query) {
        dataFromDatabase = DatabaseUtilities.getData(query);
    }

    @Then("Check if they match with the names on the UI")
    public void checkIfTheyMatchWithTheNamesOnTheUI() {
        List<WebElement> statesListFromUI = dialogContent.statesList;
        for (int i = 0; i < statesListFromUI.size(); i++) {
            Assert.assertEquals(dataFromDatabase.get(i).get(0), statesListFromUI.get(i).getText());
        }
    }
}
