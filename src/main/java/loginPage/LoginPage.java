package loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.base.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Username']")
    private WebElement demoUserName;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Password']")
    private WebElement demoPassword;

    @FindBy(xpath = "//div[@class='col-sm-8']//input[@id='txt-username']")
    private WebElement userName;
    @FindBy(xpath = "//div[@class='col-sm-8']//input[@id='txt-password']")
    private WebElement notDemoPassword;

    @FindBy(xpath = "//div[@class='col-sm-offset-4 col-sm-8']//button[@id='btn-login']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//a[@id='btn-make-appointment']")
    private WebElement makeAppointmentButton;

    @FindBy(xpath = "//a[@id='menu-toggle']")
    private WebElement burger;

    @FindBy(xpath = "//a[@href='profile.php#login']")
    private WebElement loginButtonFromUpRight;

    public void fillUserName(String username){
        click(userName);
        addText(username, userName);
    }

    public void fillPassword(String password){
        click(notDemoPassword);
        addText(password, notDemoPassword);
    }

    public void clickBurger(){
        click(burger);
    }

    public void clickLoginButtonUpRight(){
        click(loginButtonFromUpRight);
    }

    public void clickLoginButton(){
        click(buttonLogin);
    }

}
