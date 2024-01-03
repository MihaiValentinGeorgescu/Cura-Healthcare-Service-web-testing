package makeAppointmentTests;

import common.base.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.AssertJUnit.fail;

public class makeAppointmentTests extends CommonMethods {

    @FindBy(xpath = "//div[@class='input-group date']//span[@class='glyphicon glyphicon-calendar']")
    private WebElement chalendar;

    @FindBy(xpath = "//div[@data-provide='datepicker']")
    private WebElement calendar;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Username']")
    private WebElement demoUserName;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Password']")
    private WebElement demoPassword;

    @FindBy(xpath = "//div[@class='col-sm-offset-5 col-sm-4']//button[@id='btn-book-appointment']")
    private WebElement buttonBookAppointment;

    @FindBy(xpath = "//div[@class='col-sm-4']//label[@class='radio-inline']//input[@name='programs']")
    private List<WebElement> healthCareProgramCheckboxes;

    @FindBy(xpath = "//div[@class='col-sm-4']//select[@id='combo_facility']")
    private Select facilityDropDown;

    @FindBy(xpath = "//div[@class='col-sm-4']//select[@id='combo_facility']//option[@value='Tokyo CURA Healthcare Center']")
    private WebElement opetionOneFacility;

    @FindBy(xpath = "//div[@class='col-sm-4']//select[@id='combo_facility']//option[@value='Hongkong CURA Healthcare Center']")
    private WebElement opetionTwoFacility;

    @FindBy(xpath = "//div[@class='col-sm-4']//select[@id='combo_facility']//option[@value='Seoul CURA Healthcare Center']")
    private WebElement opetionThreeFacility;

    @FindBy(xpath = "//div[@class='col-sm-offset-5 col-sm-4']//label[@for='chk_hospotal_readmission']")
    private WebElement hospitalReadmissionCheckButton;

    @FindBy(xpath = "//div[@class='col-sm-4']//textarea[@id='txt_comment']")
    private WebElement commentTextArea;

    public void fillUserName(String username) {
        click(demoUserName);
        addText(username, demoUserName);
    }

    public void fillPassword(String password) {
        click(demoPassword);
        addText(password, demoPassword);
    }

    public static void selectMonthAndYearAbove(WebDriver driver, String month, String year) {
        // Locate the next and previous buttons for navigating through months
        WebElement nextButton = driver.findElement(By.xpath("//th[@class='next']"));
        WebElement prevButton = driver.findElement(By.xpath("//th[@class='prev']"));

        // Keep clicking the next button until the desired month and year are reached
        while (true) {
            WebElement currentMonthYearElement = driver.findElement(By.xpath("//th[@class='datepicker-switch']"));
            String currentMonthYear = currentMonthYearElement.getText();

            if (currentMonthYear.equals(month + " " + year)) {
                break;
            }
            nextButton.click();
        }
    }

    public static void selectMonthAndYearBellow(WebDriver driver, String month, String year) {
        // Locate the next and previous buttons for navigating through months
        WebElement nextButton = driver.findElement(By.xpath("//th[@class='next']"));
        WebElement prevButton = driver.findElement(By.xpath("//th[@class='prev']"));

        // Keep clicking the next button until the desired month and year are reached
        while (true) {
            WebElement currentMonthYearElement = driver.findElement(By.xpath("//th[@class='datepicker-switch']"));
            String currentMonthYear = currentMonthYearElement.getText();

            if (currentMonthYear.equals(month + " " + year)) {
                break;
            }
            prevButton.click();
        }
    }

    public static void selectDate(WebDriver driver, String day) {
        // Locate the date element based on the day
        WebElement dateToSelect = driver.findElement(By.xpath("//td[text()='" + day + "']"));
        dateToSelect.click();
    }

    public void selectHealthCareProgram(String program) {
        for (WebElement checkbox : healthCareProgramCheckboxes) {
            if (checkbox.getAttribute("value").equalsIgnoreCase(program)) {
                checkbox.click();
                break; // Stop iterating once the correct checkbox is found and clicked
            }
        }
    }

    public void selectHospitalReadmission() {
        click(hospitalReadmissionCheckButton);
    }

    public void addTextToTextArea(String text) {
        addText(text, commentTextArea);
    }

    public void selectFacility(int option) {
        if (option == 1) {
            click(opetionOneFacility);
        } else {
            if (option == 2) {
                click(opetionTwoFacility);
            } else {
                click(opetionThreeFacility);
            }
        }
    }

}
