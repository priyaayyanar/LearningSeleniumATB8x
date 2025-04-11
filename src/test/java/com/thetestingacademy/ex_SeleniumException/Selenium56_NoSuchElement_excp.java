package com.thetestingacademy.ex_SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium56_NoSuchElement_excp {

    EdgeDriver driver;
    EdgeOptions options;
    @BeforeTest
    public void openBrowser(){
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
    }

    @Description("Verify NoSuchElement Exception")
    @Test
    public void test_NoSuchElementException(){
        String URL = "https://app.vwo.com/";
        driver.get(URL);
        try {
            driver.findElement(By.id("priya"));
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
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
