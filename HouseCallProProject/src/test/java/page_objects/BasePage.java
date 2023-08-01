package page_objects;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import test_scripts.DriverWrapper;

import java.util.concurrent.TimeUnit;

public class BasePage {

    // This is the most common wait function used in selenium
    public static WebElement webAction(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverWrapper.getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotFoundException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    public static WebElement explicitFunction(By locator) {

        WebDriverWait wait = new WebDriverWait(DriverWrapper.getDriver(), 15);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));


        return element;

    }


    public void JSstuff(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) DriverWrapper.getDriver();
        js.executeScript("arguments[0].value = '';", locator);


    }


    public void deleteTextField(By locator) {
        for (int i = 0; i < 3; i++)
            webAction(locator).sendKeys(Keys.BACK_SPACE);
    }


    public void clickOn(By locator) {
        webAction(locator).click();
    }

    public void setValue(By locator, String value) {
        webAction(locator).sendKeys(value);
    }

    public String getValueFromElement(By locator) {
        return webAction(locator).getText();
    }

    public boolean isElementDisplayed(By locator) {
        boolean isDisplayed;
        try {
            isDisplayed = webAction(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public boolean isElementSelected(By locator) {
        return DriverWrapper.getDriver().findElement(locator).isSelected();
    }

    public boolean isElementEnabled(By locator) {
        return DriverWrapper.getDriver().findElement(locator).isEnabled();
    }

    public void selectByTextFromDropDown(By locator, String text) {
        WebElement dropDownElement = DriverWrapper.getDriver().findElement(locator);
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By locator, String value) {
        WebElement dropDownElement = DriverWrapper.getDriver().findElement(locator);
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByValue(value);
    }

    public void selectByIndexFromDropDown(By locator, int index) {
        WebElement dropDownElement = DriverWrapper.getDriver().findElement(locator);
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByIndex(index);
    }

}

