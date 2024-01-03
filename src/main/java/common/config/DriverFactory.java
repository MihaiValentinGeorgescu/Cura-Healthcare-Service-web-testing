package common.config;

import java.lang.System;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverFactory {
    public static final String URL = "https://katalon-demo-cura.herokuapp.com/";
    public static WebDriver driver = null;

    @BeforeMethod(alwaysRun = true)
    public static void setUp(ITestContext context) {

        System.setProperty("webdriver.chrome.driver", /*"src/test/resources/drivers/chromedriver.exe"*/ getChromeDriverPath() + "\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(URL);
        context.setAttribute("WebDriver", driver);

    }

    private static String getChromeDriverPath() {
        return System.getProperty("user.dir");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

}
