package com.paraline.pageObject;

import com.paraline.common.Data;
import com.paraline.common.DataGenerate;
import com.paraline.common.FrameworkConstants;
import com.paraline.pageUI.MyAccountPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyAccountObject extends MyAccountPage {
    Select select;
    public MyAccountObject(WebDriver driver) {
        super(driver);
    }

    public void addCookie(){
        navigateUrl(FrameworkConstants.URL_HOME);
        for (Cookie cookie : Data.cookieValue) {
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
    }
    public void verifyUpdateSuccess(String message) {
        String getMessage = notificationSuccess().getText();
        assertEquals(getMessage, message);
    }
    public void addProfile(String firstName, String lastName, String email, String company){
        inputAddFirstname.clear();
        inputAddFirstname.sendKeys(firstName);
        inputAddLastname.clear();
        inputAddLastname.sendKeys(lastName);
        inputAddEmail.clear();
        inputAddEmail.sendKeys(email);
        inputAddCompany.clear();
        inputAddCompany.sendKeys(company);
    }
    public void addAddress(String country, String state, String city, String address1, String address2, String zip){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", selectData("Address_CountryId"));
        select = new Select(selectData("Address_CountryId"));
        select.selectByVisibleText(country);
//        select = new Select(selectData("Address_StateProvinceId"));
//        select.selectByVisibleText(state);
        inputAddCity.clear();
        inputAddCity.sendKeys(city);
        inputAddAddress1.clear();
        inputAddAddress1.sendKeys(address1);
        inputAddAddress2.clear();
        inputAddAddress2.sendKeys(address2);
        inputZip.clear();
        inputZip.sendKeys(zip);
    }
    public void addPhone(String phone, String fax){
        inputAddPhone.clear();
        inputAddPhone.sendKeys(phone);
        inputAddFax.clear();
        inputAddFax.sendKeys(fax);
    }

    public void verifyInfo(String name, String email, String phone,
                           String fax, String company, String address1,
                           String address2, String city, String country){
        assertEquals(info("name").getText(),name);
        assertEquals(info("email").getText(),email);
        assertEquals(info("phone").getText(),phone);
        assertEquals(info("fax").getText(),fax);
        assertEquals(info("company").getText(),company);
        assertEquals(info("address1").getText(),address1);
        assertEquals(info("address2").getText(),address2);
        assertEquals(info("city-state-zip").getText(),city);
        assertEquals(info("country").getText(),country);
    }
    public void changePassword(){
        inputOldPass.sendKeys(Data.password);
        Data.password = DataGenerate.randomPass();
        inputNewPass.sendKeys(Data.password);
        inputConfirmNewPass.sendKeys(Data.password);
    }
    public void addReview(String reviewTitle, String reviewTex){
        inputReviewTitle.sendKeys(reviewTitle);
        inputReviewText.sendKeys(reviewTex);
        setRating(DataGenerate.randomNumber(2,6)).click();
        buttonName("Submit review").click();
    }
}
