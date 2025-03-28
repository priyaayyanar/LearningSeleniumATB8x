package com.thetestingacademy.ex_SeleniumAction_Windows_IFrame;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium55_RL_JS_FormValidation {

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

    @Description("Verify AQI.IN")
    @Test
    public void test_aqi() throws InterruptedException {

        String URL = "https://codepen.io/AbdullahSajjad/full/LYGVRgK";
        driver.get(URL);

        //Switch to IFrame
        driver.switchTo().frame("result");

        WebElement submit = driver.findElement(By.xpath("//form[@id='form']/button"));
        submit.click();

        WebElement element = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement error_element = driver.findElement(with(By.tagName("small")).below(element));

        String error_message = error_element.getText();

        //Assertion
        Assert.assertTrue(error_element.isDisplayed());
        Assert.assertEquals(error_message,"Username must be at least 3 characters");

        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
