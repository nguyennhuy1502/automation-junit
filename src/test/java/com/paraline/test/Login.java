package com.paraline.test;

import com.paraline.common.BaseTest;
import com.paraline.common.Data;
import com.paraline.common.DataGenerate;
import com.paraline.common.FrameworkConstants;
import com.paraline.pageObject.LoginObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Login extends BaseTest {
    LoginObject login;
    @BeforeEach
    public void beforeEach(){
        login = page.GetInstance(LoginObject.class);
    }

    @Test()
    @Order(1)
    public void TC_01_LoginEmptyData() {
        login.openPageURL(FrameworkConstants.URL_LOGIN);
        login.inputDataWithLogin("", "");
        login.clickLogin();
        login.verifyError(Data.getMessageEmailEmpty);
    }

    @Test()
    @Order(2)
    public void TC_02_LoginInvalidData() {
        login.navigateUrl(FrameworkConstants.URL_LOGIN);
        login.inputDataWithLogin("abc@", "");
        login.clickLogin();
        login.verifyError(Data.getMessageEmailInvalid);
    }

    @Test()
    @Order(3)
    public void TC_03_LoginEmailDataFail() {
        login.navigateUrl(FrameworkConstants.URL_LOGIN);
        login.inputDataWithLogin("admin@gmail.com", "123456");
        login.clickLogin();
        login.verifyErrorValid(Data.getMessageEmailError);
    }
    @Test()
    @Order(4)
    public void TC_04_loginSuccess(){
        login.navigateUrl(FrameworkConstants.URL_LOGIN);
        login.inputDataWithLogin(Data.username, Data.password);
        login.clickLogin();
        login.getCookie();
        System.out.println(Data.cookieValue);
    }

    @Test()
    @Order(5)
    public void TC_05_LoginPasswordNull() {
        login.navigateUrl(FrameworkConstants.URL_LOGIN);
        login.inputDataWithLogin(Data.username, "");
        login.clickLogin();
        login.verifyErrorValid(Data.getMessageEmptyPassword);
    }

    @Test()
    @Order(6)
    public void TC_06_LoginPasswordFail() {
        login.navigateUrl(FrameworkConstants.URL_LOGIN);
        login.inputDataWithLogin(Data.username, DataGenerate.randomPass());
        login.clickLogin();
        login.verifyErrorValid(Data.getMessageEmptyPassword);
    }

}
