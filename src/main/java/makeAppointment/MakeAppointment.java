package makeAppointment;

import common.base.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MakeAppointment extends CommonMethods{

    @FindBy(xpath = "//a[@id='btn-make-appointment']")
    private WebElement makeAppointmentButton;

    @FindBy(xpath = "//div[@class='col-sm-12 text-center']//p[@class='lead']")
    private WebElement loginText;

    @FindBy(xpath = "//form[@class='form-horizontal']")
    private WebElement formular;

    public void pressMakeAppointmentButton(){
        click(makeAppointmentButton);
    }

    public boolean isFormulaDisplayed() {
        return formular.isDisplayed();
    }


}
