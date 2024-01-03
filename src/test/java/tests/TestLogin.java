package tests;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.config.DriverFactory;
import loginPage.LoginPage;


public class TestLogin extends DriverFactory {
    public LoginPage login() {
        return new LoginPage();
    }

    @Test(description = "test login")
    @Parameters({"username", "password"})
    public void verifyLogin(String username, String password) {
        login().clickBurger();
        login().clickLoginButtonUpRight();
        login().fillUserName(username);
        login().fillPassword(password);
        login().clickLoginButton();
    }

}
