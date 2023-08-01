package test_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LandingPage;
import page_objects.AssertionsPage;

public class HouseCallPro extends DriverWrapper {


    @Test
    public void verifyInvalidLogin() throws InterruptedException {
        LandingPage landingPage = new LandingPage();
        AssertionsPage assertionsPage = new AssertionsPage();
        String unitPrice = "$9500.00";
        landingPage.enterEmailValue(email);
        landingPage.enterPasswordValue(password);
        landingPage.clickSignINBtn();
        landingPage.click_NEW_BTN();
        landingPage.click_NEWJOB_BTN();
        landingPage.createNewCustomer();
        landingPage.customerDetails("michael", "smith", "mike LLC", "mike123@gmail.com", "9295004112", "admin");
        landingPage.clickCreateNewCustomerBtn();
        landingPage.enterLineItems("new Job", unitPrice);
        landingPage.addPrivateNote("privateNote");
        landingPage.clickSaveJob_Btn();

        // Assertions to validate the new created invoice number and the unit price number on the new invoice
        System.out.println("Text= " + assertionsPage.getInvoiceDetails());
        System.out.println("new invoice number = " + assertionsPage.getNewInvoiceNumber());

        Assert.assertTrue(assertionsPage.getInvoiceDetails().contains("Job created as Invoice " + assertionsPage.getNewInvoiceNumber() + " total = " + unitPrice));


    }


}
