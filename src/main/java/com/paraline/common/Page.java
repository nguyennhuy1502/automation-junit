package com.paraline.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public WebDriver driver;

    //Constructor
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public <TPage extends BasePage> TPage GetInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
