package page_objects;

import org.openqa.selenium.By;

public class LandingPage extends BasePage {

    //Locators
    private By SIGNIN_BTN = By.xpath("//span[text()='Sign in']");
    private By FIRSTNAME_TEXTFIELD = By.xpath("//input[@name='firstname']");
    private By LASTNAME_TEXTFIELD = By.xpath("//input[@name='lastname']");
    private By PHONENUMBER_TEXTFIELD = By.xpath("//input[@name='phone']");
    private By EMAIL_TEXTFIELD = By.xpath("//input[@id='email']");
    private By PASSWORD_TEXTFIELD = By.xpath("//input[@id='password']");
    private By NEW_BTN = By.xpath("//span[@class='MuiButton-label-1800']");
    private By NEWJOB_BTN = By.xpath("//li[@data-dd-action-name='navbar-new-job-button']");
    private By NEWCUSTOMER_BTN = By.xpath("//span[contains(text(),'customer')]");
    private By FIRSTNAME_CUSTOMER_TXTFIELD = By.xpath("//input[@name='first_name']");
    private By LAST_NAME_CUSTOMER_TXTFIELD = By.xpath("//input[@name='last_name']");
    private By COMPANY_TXTFIELD = By.xpath("//input[@name='company']");
    private By COMPANY_EMAIL_TXTFIELD = By.xpath("//input[@name='email']");
    private By COMPANY_MOBILE_PHONE_TXTFIELD = By.xpath("//input[@name='mobile_number']");
    private By COMPANY_ROLE_TXTFIELD = By.xpath("//input[@name='job_title']");
    private By CREATE_NEW_CUSTOMER_BTN = By.xpath("//span[contains(text(),'create')]");
    private By ITEM_NAME_TXTFIELD = By.xpath("//input[@data-testid='line-item-name']");
    private By INPUTPRICE_TXTFIELD = By.xpath("//input[@id='unit-price']");
    private By PRIVATENOTES_BTN = By.xpath("//p[contains(text(),'Private notes')]");
    private By PRIVATENOTES_TXTFIELD = By.xpath("//textarea[@data-testid='private-notes-textfield']");
    private By SAVEJOB_BTN = By.xpath("//span[contains(text(),'Save job')]");
    private By CONTINUE_BTN = By.xpath("//button[@type='submit']");
    private By COMPANYNAME_TXTFIELD = By.xpath("//input[@name='company']");
    private By STREET_TXTFIELD = By.xpath("//input[@name='street']");
    private By COMPANYPHONENUMBER_TXTFIELD = By.xpath("//input[@name='phone']");
    private String email = "shadidultests@gmail.com";
    private String password = "Test123!!";

    public void clickSaveJob_Btn() {
        explicitFunction(SAVEJOB_BTN).click();
    }


    public void addPrivateNote(String value) {
        explicitFunction(PRIVATENOTES_BTN).click();
        setValue(PRIVATENOTES_TXTFIELD, value);
    }


    public void enterLineItems(String itemName, String unitPrice) throws InterruptedException {

        explicitFunction(ITEM_NAME_TXTFIELD).click();
        setValue(ITEM_NAME_TXTFIELD, itemName);
        clickOn(INPUTPRICE_TXTFIELD);
        explicitFunction(INPUTPRICE_TXTFIELD).click();
        deleteTextField(INPUTPRICE_TXTFIELD);
        explicitFunction(INPUTPRICE_TXTFIELD).click();
        setValue(INPUTPRICE_TXTFIELD, unitPrice);


    }


    public void clickCreateNewCustomerBtn() {
        clickOn(CREATE_NEW_CUSTOMER_BTN);
    }


    public void customerDetails(String firstName, String lastName, String companyName, String companyEmail, String mobileNum, String role) {
        setValue(FIRSTNAME_CUSTOMER_TXTFIELD, firstName);
        setValue(LAST_NAME_CUSTOMER_TXTFIELD, lastName);
        setValue(COMPANY_TXTFIELD, companyName);
        setValue(COMPANY_EMAIL_TXTFIELD, companyEmail);
        setValue(COMPANY_MOBILE_PHONE_TXTFIELD, mobileNum);
        setValue(COMPANY_ROLE_TXTFIELD, role);

    }


    public void createNewCustomer() {
        clickOn(NEWCUSTOMER_BTN);
    }


    public void click_NEW_BTN() {
        clickOn(NEW_BTN);
    }

    public void click_NEWJOB_BTN() {
        clickOn(NEWJOB_BTN);
    }


    public void clickSignINBtn() {
        clickOn(SIGNIN_BTN);
    }

    public void enterEmailValue(String value) {
        setValue(EMAIL_TEXTFIELD, value);
    }

    public void enterPasswordValue(String value) {
        setValue(PASSWORD_TEXTFIELD, value);
    }


}
