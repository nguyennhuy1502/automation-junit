package com.paraline.test;

import com.paraline.common.BaseTest;
import com.paraline.common.Data;
import com.paraline.common.DataGenerate;
import com.paraline.common.FrameworkConstants;
import com.paraline.pageObject.LoginObject;
import com.paraline.pageObject.MyAccountObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyAccount extends BaseTest {
    @Test()
    public void TC_01_CustomerInfo(){
        page.GetInstance(MyAccountObject.class).addCookie();
        page.GetInstance(MyAccountObject.class).navigateUrl(FrameworkConstants.URL_MY_ACCOUNT );
        page.GetInstance(MyAccountObject.class).tickGender();
        page.GetInstance(MyAccountObject.class).inputAddFirstname.clear();
        page.GetInstance(MyAccountObject.class).inputAddFirstname.sendKeys("Jonh");
        page.GetInstance(MyAccountObject.class).inputAddLastname.clear();
        page.GetInstance(MyAccountObject.class).inputAddLastname.sendKeys("Smith");
        page.GetInstance(MyAccountObject.class).inputDate("1");
        page.GetInstance(MyAccountObject.class).inputMonth("January");
        page.GetInstance(MyAccountObject.class).inputYear("1999");
        page.GetInstance(MyAccountObject.class).inputCompany("Garaxy White");
        page.GetInstance(MyAccountObject.class).buttonName("Save").click();
        page.GetInstance(MyAccountObject.class).verifyUpdateSuccess(Data.notificationSuccessCustomer);
    }

    @Test()
    public void TC_02_AddAddress(){
        page.GetInstance(MyAccountObject.class).addCookie();
        page.GetInstance(MyAccountObject.class).navigateUrl(FrameworkConstants.URL_MY_ACCOUNT);
        page.GetInstance(MyAccountObject.class).listBox("Addresses").click();
        page.GetInstance(MyAccountObject.class).buttonAdd.click();
        page.GetInstance(MyAccountObject.class).addProfile("John","Smith","john.smith@gmail.com","Garaxy White");
        page.GetInstance(MyAccountObject.class).addAddress("Viet Nam","Other","Da Nang","123/04 Le Lai","234/ 05 Hai Phong","550000");
        page.GetInstance(MyAccountObject.class).addPhone("0123456789","0987654321");
        page.GetInstance(MyAccountObject.class).buttonName("Save").click();
        page.GetInstance(MyAccountObject.class).verifyUpdateSuccess(Data.notificationSuccessUpdate);
        page.GetInstance(MyAccountObject.class).verifyInfo("John Smith","Email: john.smith@gmail.com","Phone number: 0123456789","Fax number: 0987654321"
                                                        ,"Garaxy White","123/04 Le Lai","234/ 05 Hai Phong","Da Nang, 550000","Viet Nam");
    }
    @Test()
    public void TC_03_ChangePass(){
        page.GetInstance(MyAccountObject.class).addCookie();
        page.GetInstance(MyAccountObject.class).navigateUrl(FrameworkConstants.URL_MY_ACCOUNT);
        page.GetInstance(MyAccountObject.class).listBox("Change password").click();
        page.GetInstance(MyAccountObject.class).changePassword();
        page.GetInstance(MyAccountObject.class).buttonName("Change password").click();
        page.GetInstance(MyAccountObject.class).verifyUpdateSuccess(Data.notificationSuccessChangePass);
        page.GetInstance(LoginObject.class).navigateUrl(FrameworkConstants.URL_LOGIN);
        page.GetInstance(LoginObject.class).inputDataWithLogin(Data.username, Data.password);
        page.GetInstance(LoginObject.class).clickLogin();
    }
    @Test()
    public void TC_04_AddReview(){
        page.GetInstance(MyAccountObject.class).addCookie();
        page.GetInstance(MyAccountObject.class).navigateUrl(FrameworkConstants.URL_ADD_REVIEW);
        page.GetInstance(MyAccountObject.class).productReview("Add your review").click();
        page.GetInstance(MyAccountObject.class).addReview(DataGenerate.randomTitle(),DataGenerate.randomText());
        String getResult = page.GetInstance(MyAccountObject.class).getResult().getText();
        assertEquals(getResult,Data.addReviewSuccess);
    }
}
