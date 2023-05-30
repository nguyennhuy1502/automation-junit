package com.paraline.pageObject;

import com.paraline.common.DataGenerate;
import com.paraline.pageUI.RegisterPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterObject extends RegisterPage {
    public RegisterObject(WebDriver driver) {
        super(driver);
    }


    public void inputPassword(String password, String confirmPassword){
        inputPassword.sendKeys(password);
        inputConfirmPassword.sendKeys(confirmPassword);
    }
    public void inputPersonalDetails(String firstName, String lastName, String email){
        tickGender();
        inputFirstname.sendKeys(firstName);
        inputLastname.sendKeys(lastName);
        inputDate(String.valueOf(DataGenerate.randomNumber(1,31)));
        inputMonth(DataGenerate.randomMonth());
        inputYear(String.valueOf(DataGenerate.randomNumber(1993,2023)));
        inputEmail.sendKeys(email);
    }
    public void inputCompany(String company) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", inputCompany);
        inputCompany.clear();
        inputCompany.sendKeys(company);
    }
    public void inputCompanyAndPassword(String company, String password){
        inputCompany(company);
        inputPassword(password,password);
    }
    public void verifySuccess(String messageSuccessFull){
        String getSuccess = messageSuccess.getText();
        assertEquals(getSuccess,messageSuccessFull);
    }

}
