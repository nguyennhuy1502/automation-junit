package com.paraline.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasePage extends Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    public void openPageURL(String url) {
        driver.get(url);
    }

    public void navigateUrl(String url) {
        driver.navigate().to(url);
    }

    @FindBy(css = GlobalConstants.INPUT_EMAIL)
    public WebElement inputEmail;
    @FindBy(css = GlobalConstants.INPUT_PASSWORD)
    public WebElement inputPassword;
    @FindBy(xpath = GlobalConstants.TITLE_PAGE)
    public WebElement titlePage;

    @FindBy(xpath = GlobalConstants.TITLE)
    public WebElement title;

    @FindBy(css = GlobalConstants.EMAIL_ERROR)
    public WebElement messageToEmailError;

    public WebElement buttonName(String name) {
        return driver.findElement(By.xpath(String.format(GlobalConstants.BTN_NAME, name)));
    }

    @FindBy(xpath = GlobalConstants.INPUT_GENDER_MALE)
    public WebElement tickGenderToMale;

    @FindBy(xpath = GlobalConstants.INPUT_GENDER_FEMALE)
    public WebElement tickGenderToFemale;
    @FindBy(css = GlobalConstants.INPUT_COMPANY)
    public WebElement inputCompany;

    public WebElement selectDate(int number) {
        return driver.findElement(By.xpath(String.format(GlobalConstants.SELECT_DATE, number)));
    }

    @FindBy(xpath = GlobalConstants.VALID_ERROR)
    public WebElement messageErrorValidation;

    public void verifyError(String messageError) {
        String getError = messageToEmailError.getText();
        assertEquals(getError, messageError);
    }

    public void verifyErrorValid(String messageError) {
        String getError = messageErrorValidation.getText();
        assertEquals(getError, messageError);
    }

    public void inputDate(String date) {
        Select select = new Select(selectDate(1));
        select.selectByVisibleText(date);
    }

    public void inputMonth(String month) {
        Select select = new Select(selectDate(2));
        select.selectByVisibleText(month);
    }

    public void inputYear(String year) {
        Select select = new Select(selectDate(3));
        select.selectByVisibleText(year);
    }

    public void inputCompany(String company) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", inputCompany);
        inputCompany.clear();
        inputCompany.sendKeys(company);
    }
    public void tickGender(){
        String male = tickGenderToMale.getText();
        String female = tickGenderToFemale.getText();
        String[] gender = {male,female};
        Random random = new Random();
        int randomIndex = random.nextInt(gender.length);
        String randomGender = gender[randomIndex];
        if (randomGender == male){
            tickGenderToMale.click();
        }else {
            tickGenderToFemale.click();
        }
    }
}
