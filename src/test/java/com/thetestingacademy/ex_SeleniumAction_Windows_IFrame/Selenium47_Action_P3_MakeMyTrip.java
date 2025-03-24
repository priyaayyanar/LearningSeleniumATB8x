package com.thetestingacademy.ex_SeleniumAction_Windows_IFrame;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Selenium47_Action_P3_MakeMyTrip {

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

    @Description("Verify Actions - MakeMyTrip")
    @Test
    public void test_Action_MakeMyTrip() throws InterruptedException {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);

        //Wait for the popup should be open and close it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Wait until the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();

        WebElement fromCity = driver.findElement(By.id("fromCity"));

        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("BLR").build().perform();

        actions.moveToElement(fromCity).contextClick();  //RightClick

        Thread.sleep(3000);

        List<WebElement> list_of_cities = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));

        for (WebElement e : list_of_cities){
            if(e.getText().contains("Chennai")){
                e.click();
                break;
            }
        }

        Thread.sleep(5000);

        actions.moveToElement(fromCity).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();

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
