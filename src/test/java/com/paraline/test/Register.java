package com.paraline.test;

import com.paraline.common.BaseTest;
import com.paraline.common.Data;
import com.paraline.common.DataGenerate;
import com.paraline.common.FrameworkConstants;
import com.paraline.pageObject.RegisterObject;
import com.paraline.pageUI.RegisterPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Register extends BaseTest {
    RegisterObject register;
    @BeforeEach
    public void beforeEach(){
        register = page.GetInstance(RegisterObject.class);
    }

    @Test()
    @Order(1)
    public void TC_01_RegisterEmptyData() {
        register.openPageURL(FrameworkConstants.URL_REGISTER);
        register.inputPersonalDetails("", "", "");
        register.inputCompanyAndPassword("", "");
        register.btnRegister.click();
    }

    @Test()
    public void TC_02_RegisterInvalid() {
        register.navigateUrl(FrameworkConstants.URL_REGISTER);
        register.inputPersonalDetails(DataGenerate.randomFirstName(), DataGenerate.randomLastName(), "abc@");
        register.inputCompanyAndPassword(DataGenerate.randomCompany(), DataGenerate.randomPass());
        page.GetInstance(RegisterPage.class).btnRegister.click();
        register.verifyError(Data.getMessageEmailInvalid);
    }

    @Test()
    public void TC_03_RegisterSuccessData() {
        Data.username = DataGenerate.randomEmail();
        Data.password = DataGenerate.randomPass();

        register.navigateUrl(FrameworkConstants.URL_REGISTER);
        register.inputPersonalDetails(DataGenerate.randomFirstName(), DataGenerate.randomLastName(), Data.username);
        register.inputCompanyAndPassword(DataGenerate.randomCompany(), Data.password);
        page.GetInstance(RegisterPage.class).btnRegister.click();
        register.verifySuccess(Data.getMessageSuccessRegister);
        page.GetInstance(RegisterPage.class).btnRegister.click();
    }

    @Test()
    public void TC_04_RegisterEmailDonExist() {
        register.navigateUrl(FrameworkConstants.URL_REGISTER);
        register.inputPersonalDetails(DataGenerate.randomFirstName(), DataGenerate.randomLastName(), Data.username);
        register.inputCompanyAndPassword(DataGenerate.randomCompany(), DataGenerate.randomPass());
        page.GetInstance(RegisterPage.class).btnRegister.click();
        register.verifyErrorValid(Data.getMessageErrorValidation);
    }

    @Test()
    public void TC_05_RegisterPasswordLessSix() {
        register.navigateUrl(FrameworkConstants.URL_REGISTER);
        register.inputPersonalDetails(DataGenerate.randomFirstName(), DataGenerate.randomLastName(), DataGenerate.randomEmail());
        register.inputCompanyAndPassword(DataGenerate.randomCompany(), String.valueOf(DataGenerate.randomNumber(1, 5)));
        page.GetInstance(RegisterPage.class).btnRegister.click();
        register.verifyError(Data.getMessagePasswordLessSix);
    }

    @Test()
    public void TC_06_RegisterConfirmPasswordDoesNotMatchPassword() {
        register.navigateUrl(FrameworkConstants.URL_REGISTER);
        register.inputPersonalDetails(DataGenerate.randomFirstName(), DataGenerate.randomLastName(), DataGenerate.randomEmail());
        register.inputCompany(DataGenerate.randomCompany());
        register.inputPassword(DataGenerate.randomPass(), DataGenerate.randomPass());
        page.GetInstance(RegisterPage.class).btnRegister.click();
        register.verifyError(Data.getMessageConfirmPassNotPass);
    }

}
