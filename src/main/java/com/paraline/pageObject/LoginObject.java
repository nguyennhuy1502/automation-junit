package com.paraline.pageObject;

import com.paraline.common.Data;
import com.paraline.pageUI.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginObject extends LoginPage {
    public LoginObject(WebDriver driver) {
        super(driver);
    }

    public void inputDataWithLogin(String username, String password) {
        inputEmail.clear();
        inputEmail.sendKeys(username);
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }
    public void clickLogin(){
        textRemember.isDisplayed();
        checkBoxRemember.click();
        btnLogin.click();
    }
    public void getCookie(){
        Data.cookieValue = driver.manage().getCookies();
    }
}
