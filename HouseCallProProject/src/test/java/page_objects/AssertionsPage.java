package page_objects;

import org.openqa.selenium.By;

public class AssertionsPage extends BasePage {

    //Locators

    private By jobCreatedMsg = By.xpath("//p[contains(text(),'Job created as Invoice')]");
    private By newInvoiceNumber = By.xpath("//h3[contains(text(),'#')]");

    public String getNewInvoiceNumber() {
        explicitFunction(jobCreatedMsg).click();
        return getValueFromElement(newInvoiceNumber);
    }

    public String getInvoiceDetails() {
        explicitFunction(jobCreatedMsg).click();
        return getValueFromElement(jobCreatedMsg);
    }


}
