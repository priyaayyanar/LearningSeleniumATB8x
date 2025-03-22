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

public class Selenium46_Action_P2_SpiceJet {

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

    @Description("Verify Actions in SpiceJet")
    @Test
    public void test_Actions_P2(){

        String URL = "https://www.spicejet.com/";
        driver.get(URL);

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        WebElement from_source = driver.findElement(By.xpath("//div[@data-testid='search-source-code']"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(from_source).click();

        WebElement source = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));
        Actions actions = new Actions(driver);
//        actions.moveToElement(source).click().build().perform();
        actions.moveToElement(source).click().sendKeys("BLR").build().perform();
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
