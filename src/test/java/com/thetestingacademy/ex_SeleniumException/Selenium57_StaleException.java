package com.thetestingacademy.ex_SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium57_StaleException {

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
        String URL = "https://google.com";
        driver.get(URL);
        WebElement search_inputBox = driver.findElement(By.id("APjFqb"));
        driver.navigate().refresh();

        //The moment we do the refresh, the element which we found already was no longer fresh now.

        try {
            search_inputBox.sendKeys("The testing academy"+ Keys.ENTER);
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }
        //Throws StaleElementException as we found the element before the refresh.
        //So adding the action inside try catch block

        //to fic this exception, we have to refind the element after DOM(HTML Page) change
        search_inputBox = driver.findElement(By.id("APjFqb"));
        search_inputBox.click();


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
