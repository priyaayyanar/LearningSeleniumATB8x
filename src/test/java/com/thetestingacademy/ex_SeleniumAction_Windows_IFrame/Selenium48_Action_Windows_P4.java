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

import java.util.Set;

public class Selenium48_Action_Windows_P4 {

    ChromeDriver driver;
    ChromeOptions options;

    @BeforeTest
    public void openBrowser(){
        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

    }

    @Description("Verify Parent Window")
    @Test
    public void test_parent_windows() throws InterruptedException {

        String URL = "https://the-internet.herokuapp.com/windows";
        driver = new ChromeDriver(options);
        driver.get(URL);

        String parent_Window = driver.getWindowHandle();
        System.out.println("Parent Window Handle"+parent_Window);

        //driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Number of Window Handles : " + windowHandles);

        for(String handle : windowHandles){
            driver.switchTo().window(handle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Case Passed");
                break;
            }
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
