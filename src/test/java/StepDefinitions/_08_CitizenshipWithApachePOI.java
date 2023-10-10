package StepDefinitions;

import PageObjectModels.DialogContent;
import Utilities.ExcelUtilities;
import Utilities.MyMethods2;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class _08_CitizenshipWithApachePOI {
    List<List<String>> citizenshipData = ExcelUtilities.getDataFromExcel("src/test/java/ApachePOI/recources/ApacheExcel3.xlsx","testCitizen",2);

    DialogContent dialogContent = new DialogContent();

    @And("Create a citizenship with Apache POI")
    public void createACitizenshipWithApachePOI() {
        for (int i = 0; i < citizenshipData.size(); i++) {
            dialogContent.clickMethod(dialogContent.addButton);
            dialogContent.sendKeysMethod(dialogContent.nameInboxSearchInboxAdd2, citizenshipData.get(i).get(0));
            dialogContent.sendKeysMethod(dialogContent.shortNameAdd2, citizenshipData.get(i).get(1));
            dialogContent.clickMethod(dialogContent.saveButton);
            dialogContent.assertText(dialogContent.successMessage,"successfully");
            dialogContent.wait.until(ExpectedConditions.invisibilityOf(dialogContent.successMessage));
        }
    }

    @And("Delete a citizenship with Apache POI")
    public void deleteACitizenshipWithApachePOI() {
        for (int i = 0; i < citizenshipData.size(); i++){
            dialogContent.sendKeysMethod(dialogContent.shortNameSearchInboxSearch1,citizenshipData.get(i).get(1));
            dialogContent.clickMethod(dialogContent.searchButton);
            MyMethods2.myWait(1);
            dialogContent.clickMethod(dialogContent.deleteButton);
            dialogContent.clickMethod(dialogContent.deleteConfirmButton);
            dialogContent.assertText(dialogContent.successMessage,"successfully");
            dialogContent.wait.until(ExpectedConditions.invisibilityOf(dialogContent.successMessage));
        }
    }
}
