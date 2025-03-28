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


public class Selenium51_FileUpload {

    ChromeDriver driver;
    ChromeOptions options;

    @BeforeTest
    public void openBrowser(){
        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--incognito");
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Description("Verify File Upload")
    @Test
    public void test_FileUpload(){

        String URL = "https://awesomeqa.com/selenium/upload.html";
        driver.get(URL);

        //Find the WebElement to upload the file
        WebElement fileUpload = driver.findElement(By.id("fileToUpload"));
        //fileUpload.click();

        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        // C:\Users\Praneesh\IdeaProjects\LearningSeleniumATB8x/src/test/java/com/thetestingacademy/ex_SeleniumAction_Windows_IFrame/FileUploadTest.txt
        fileUpload.sendKeys(dir + "/src/test/java/com/thetestingacademy/ex_SeleniumAction_Windows_IFrame/FileUploadTest.txt");
        driver.findElement(By.name("submit")).click();
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
