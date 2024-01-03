package tests;

import common.base.CommonMethods;
import common.config.DriverFactory;
import homeButtonTests.homeButtonTests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestHomeButton extends DriverFactory {

    public homeButtonTests butonMeniuHome() {
        return new homeButtonTests();
    }

    @Test(description = "test home button")
    public void homeButtonsTest() {
        butonMeniuHome().clickBurger();
        butonMeniuHome().clickHomeButton();
        boolean homeTextIsDisplayed = butonMeniuHome().isTextDisplayed();
        Assert.assertTrue(homeTextIsDisplayed,"gasit");
    }
}
