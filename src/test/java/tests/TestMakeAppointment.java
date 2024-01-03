package tests;

import common.config.DriverFactory;
import loginPage.LoginPage;
import makeAppointmentTests.makeAppointmentTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestMakeAppointment extends DriverFactory {

    public makeAppointmentTests makeAppTests(){
        return new makeAppointmentTests();
    }

    public LoginPage login() {
        return new LoginPage();
    }

    @Test(description = "test login")
    @Parameters({"username", "password", "day", "month", "year", "program", "text", "option"})
    public void verifyLogin(String username, String password, String day, String month, String year, String program, String text, int option) throws InterruptedException {
        login().clickBurger();
        login().clickLoginButtonUpRight();
        login().fillUserName(username);
        login().fillPassword(password);
        login().clickLoginButton();
        Thread.sleep(2000);

        makeAppTests().selectFacility(option);

        makeAppTests().selectHospitalReadmission();

        makeAppTests().selectHealthCareProgram(program);
        Thread.sleep(2000);

        // Perform date picker test immediately after login
        try {
            WebElement datepickerInput = driver.findElement(By.id("txt_visit_date"));

            // Click the input field to open the datepicker
            datepickerInput.click();

            // Select a specific month and year if needed
//            makeAppTests().selectMonthAndYearAbove(driver, month, year);
            int targetYear = Integer.parseInt(year);
            int currentYear = 2024;

            if (targetYear > currentYear) {
                // Target year is greater than 2024, call selectMonthAndYearAbove method
                makeAppTests().selectMonthAndYearAbove(driver, month, year);
            } else if (targetYear < currentYear) {
                // Target year is smaller than 2024, call selectMonthAndYearBelow method (create this method if needed)
                makeAppTests().selectMonthAndYearBellow(driver, month, year);
            } else {
                // Target year is equal to 2024, do nothing or handle as needed
            }

            // Select a date
            makeAppTests().selectDate(driver, day);

            // Your further actions or verifications here

        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(2000);

        makeAppTests().addTextToTextArea(text);
    }
}
