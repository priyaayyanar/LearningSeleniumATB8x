package com.thetestingacademy.ex_SeleniumAction_Windows_IFrame;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium53_RelativeLocators {

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

    @Description("Verify Relative Locators")
    @Test
    public void test_RelativeLocators(){

        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);

        WebElement span_YOE = driver.findElement(By.xpath("//span[normalize-space()='Years of Experience']"));
        driver.findElement(with(By.id("exp-2")).toRightOf(span_YOE)).click();
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

