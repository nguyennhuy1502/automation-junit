package com.paraline.common;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public Page page;

    @BeforeAll
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        page = new Page(driver);
    }

    @AfterAll
    public void closeDriver() {
        driver.quit();
    }

}
