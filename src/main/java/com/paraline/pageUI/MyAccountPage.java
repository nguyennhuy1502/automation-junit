package com.paraline.pageUI;

import com.paraline.common.BasePage;
import com.paraline.common.GlobalConstants;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement listBox(String name) {
        return driver.findElement(By.xpath(String.format(GlobalConstants.LIST_BOX, name)));
    }
    @FindBy(css = GlobalConstants.INPUT_ADD_FIRSTNAME)
    public WebElement inputAddFirstname;
    @FindBy(css = GlobalConstants.INPUT_ADD_LASTNAME)
    public WebElement inputAddLastname;
    @FindBy(css = GlobalConstants.INPUT_ADD_EMAIL)
    public WebElement inputAddEmail;
    @FindBy(css = GlobalConstants.INPUT_ADD_COMPANY)
    public WebElement inputAddCompany;
    @FindBy(css = GlobalConstants.INPUT_ADD_CITY)
    public WebElement inputAddCity;
    @FindBy(css = GlobalConstants.INPUT_ADD_ADDRESS1)
    public WebElement inputAddAddress1;
    @FindBy(css = GlobalConstants.INPUT_ADD_ADDRESS2)
    public WebElement inputAddAddress2;
    @FindBy(css = GlobalConstants.INPUT_ADD_ZIP)
    public WebElement inputZip;
    @FindBy(css = GlobalConstants.INPUT_ADD_PHONE)
    public WebElement inputAddPhone;
    @FindBy(css = GlobalConstants.INPUT_ADD_FAX)
    public WebElement inputAddFax;
    @FindBy(css = GlobalConstants.INPUT_OLD_PASSWORD)
    public WebElement inputOldPass;
    @FindBy(css = GlobalConstants.INPUT_NEW_PASSWORD)
    public WebElement inputNewPass;
    @FindBy(css = GlobalConstants.INPUT_CONFIRM_NEW_PASSWORD)
    public WebElement inputConfirmNewPass;
    @FindBy(css = GlobalConstants.INPUT_ADD_REVIEW_TITLE)
    public WebElement inputReviewTitle;
    @FindBy(css = GlobalConstants.INPUT_ADD_REVIEW_TEXT)
    public WebElement inputReviewText;
    @FindBy(css = GlobalConstants.BUTTON_ADD)
    public WebElement buttonAdd;
    public WebElement notificationSuccess() {
        return driver.findElement(By.xpath(GlobalConstants.NOTIFICATION_SUCCESS));
    }

    public WebElement selectData(String name) {
        return driver.findElement(By.xpath(String.format(GlobalConstants.SELECT_DATA, name)));
    }

    public WebElement info(String name) {
        return driver.findElement(By.xpath(String.format(GlobalConstants.INFO, name)));
    }

    public WebElement productReview(String name) {
        return driver.findElement(By.xpath(String.format(GlobalConstants.PRODUCT_REVIEW, name)));
    }

    public WebElement setRating(int number) {
        return driver.findElement(By.xpath(String.format(GlobalConstants.RATING, number)));
    }
    public WebElement getResult(){
        return driver.findElement(By.xpath(String.format(GlobalConstants.RESULT)));
    }
}
