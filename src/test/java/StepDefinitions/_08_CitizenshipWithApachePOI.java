package StepDefinitions;

import PageObjectModels.DialogContent;
import Utilities.ExcelUtilities;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class _08_CitizenshipWithApachePOI {
    @And("Create a citizenship with Apache POI")
    public void createACitizenshipWithApachePOI() {
        List<List<String>> citizenshipData = ExcelUtilities.getDataFromExcel("src/test/java/ApachePOI/recources/ApacheExcel3.xlsx","testCitizen",2);

        DialogContent dialogContent = new DialogContent();

        for (int i = 0; i < citizenshipData.size(); i++) {
            dialogContent.clickMethod(dialogContent.addButton);
            dialogContent.sendKeysMethod(dialogContent.nameInboxSearchInboxAdd2, citizenshipData.get(i).get(0));
            dialogContent.sendKeysMethod(dialogContent.shortNameAdd2, citizenshipData.get(i).get(1));
            dialogContent.clickMethod(dialogContent.saveButton);
            dialogContent.assertText(dialogContent.successMessage,"successfully");
            dialogContent.wait.until(ExpectedConditions.invisibilityOf(dialogContent.successMessage));
        }
    }
}
