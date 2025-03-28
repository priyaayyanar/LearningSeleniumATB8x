package com.thetestingacademy.ex_SeleniumAction_Windows_IFrame;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium52_FileUpload_DragAndDrop {

    ChromeDriver driver;
    ChromeOptions options;

    @BeforeTest
    public void openBrowser(){
        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("guest");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Description("Verify Drag and Drop File Upload")
    @Test
    public void test_FileUpload_Herokuapp(){

        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);

        Actions actions = new Actions(driver);

       // WebElement from = driver.findElement(By.id("column-a"));
        //WebElement to = driver.findElement(By.id("column-b"));
        WebElement from = driver.findElement(By.cssSelector("[id='column-a']"));
        WebElement to = driver.findElement(By.cssSelector("[id='column-b']"));

        // actions.dragAndDrop(from,to).build().perform();

        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();


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
