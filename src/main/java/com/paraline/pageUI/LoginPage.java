package com.paraline.pageUI;

import com.paraline.common.BasePage;
import com.paraline.common.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = GlobalConstants.TEXT_REMEMBER_ME)
    public WebElement textRemember;

    @FindBy(css = GlobalConstants.CHECK_BOX)
    public WebElement checkBoxRemember;

    @FindBy(xpath = GlobalConstants.BUTTON_LOGIN)
    public WebElement btnLogin;
}
