package tests;

import common.base.CommonMethods;
import common.config.DriverFactory;
import makeAppointment.MakeAppointment;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMakeAppointmentButton extends DriverFactory {

    public MakeAppointment makeAppointmentButton() {
        return new MakeAppointment();
    }

    @Test(description = "test Make Appointment button")
    public void makeAppointmentButtonTest() {
        makeAppointmentButton().pressMakeAppointmentButton();
        boolean isFormDisplayed = makeAppointmentButton().isFormulaDisplayed();
        Assert.assertTrue(isFormDisplayed,"form is not displayed");
    }
}
