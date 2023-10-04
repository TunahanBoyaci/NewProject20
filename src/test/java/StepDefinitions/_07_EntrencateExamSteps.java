package StepDefinitions;

import PageObjectModels.DialogContent;
import PageObjectModels.LeftNavBar;
import Utilities.BaseDriver;
import Utilities.ParameterDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class _07_EntrencateExamSteps {
    LeftNavBar leftNavBar = new LeftNavBar();
    DialogContent dialogContent = new DialogContent();

    @And("Go to Entrance Exams Page")
    public void goToEntranceExamsPage() {
        leftNavBar.clickMethod(leftNavBar.entranceExamsButton);
        leftNavBar.clickMethod(leftNavBar.entranceExamsSetupButton);
        leftNavBar.clickMethod(leftNavBar.entranceExams2Button);
    }

    @And("Fill the Create Exam Form")
    public void fillTheCreateExamForm(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        dialogContent.sendKeysMethod(dialogContent.createExamName, dataList.get(0));
        dialogContent.clickMethod(dialogContent.academicPeriod);
        dialogContent.clickMethod(dialogContent.academicPeriodOption);
        dialogContent.clickMethod(dialogContent.gradeLevel);
        dialogContent.clickMethod(dialogContent.gradeLevelOption);
    }

    @And("Create a description")
    public void createADescription(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        dialogContent.clickMethod(dialogContent.examDescription);
        dialogContent.wait.until(ExpectedConditions.visibilityOf(dialogContent.iFrame));
        ParameterDriver.getDriver().switchTo().frame(0);
        dialogContent.sendKeysMethod(dialogContent.descriptionAndNotesText, dataList.get(0));
        ParameterDriver.getDriver().switchTo().parentFrame();
    }

    @And("Create a note")
    public void createANote(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        dialogContent.clickMethod(dialogContent.examNotes);
        dialogContent.wait.until(ExpectedConditions.visibilityOf(dialogContent.iFrame));
        ParameterDriver.getDriver().switchTo().frame(0);
        dialogContent.sendKeysMethod(dialogContent.descriptionAndNotesText, dataList.get(0));
        ParameterDriver.getDriver().switchTo().parentFrame();
    }

    @And("Search for {string}")
    public void searchFor(String examName) {
        dialogContent.sendKeysMethod(dialogContent.nameInboxSearchInboxSearch1, examName);
        dialogContent.clickMethod(dialogContent.searchButton);
    }
}
