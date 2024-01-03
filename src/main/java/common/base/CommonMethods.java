package common.base;

import common.config.DriverFactory;
import common.constants.CommonConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

    protected WebDriver driver;
    public CommonMethods()  {
        driver = DriverFactory.driver;
        PageFactory.initElements(driver, this);
    }
    protected void click(WebElement locator) {
        clickAble(locator).click();
    }

    private WebDriverWait waitPage() {
        return new WebDriverWait(driver, CommonConstants.WEB_DRIVER_WAIT_DURATION);
    }
    private WebElement clickAble(WebElement locator) {
        waitPage().until(ExpectedConditions.elementToBeClickable(locator));
        return locator;
    }

    protected void addText(String inputText, WebElement locator) {
        locator.sendKeys(inputText);
    }

    protected String getUrl(){
        return driver.getCurrentUrl();
    }

}
