package com.paraline.pageUI;

import com.paraline.common.BasePage;
import com.paraline.common.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = GlobalConstants.INPUT_FIRSTNAME)
    public WebElement inputFirstname;
    @FindBy(css = GlobalConstants.INPUT_LASTNAME)
    public WebElement inputLastname;
    @FindBy(css = GlobalConstants.INPUT_CONFIRM_PASSWORD)
    public WebElement inputConfirmPassword;
    @FindBy(xpath = GlobalConstants.MESS_SUCCESS)
    public WebElement messageSuccess;
    @FindBy(xpath = GlobalConstants.BUTTON_REGISTER)
    public WebElement btnRegister;

}
