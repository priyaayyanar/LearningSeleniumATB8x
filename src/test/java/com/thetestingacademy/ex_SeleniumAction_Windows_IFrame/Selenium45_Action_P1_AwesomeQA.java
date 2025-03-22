package com.thetestingacademy.ex_SeleniumAction_Windows_IFrame;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium45_Action_P1_AwesomeQA {

    ChromeDriver driver;
    ChromeOptions options;

    @BeforeTest
    public void openBrowser(){
        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Description("Verify Action")
    @Test
    public void test_Actions() throws InterruptedException {
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);

        WebElement firstName = driver.findElement(By.name("firstname"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(firstName, "the testing academy")
                .keyUp(Keys.SHIFT).build().perform();
        Thread.sleep(3000);

    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
