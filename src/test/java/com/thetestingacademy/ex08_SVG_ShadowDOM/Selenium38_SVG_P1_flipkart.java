package com.thetestingacademy.ex08_SVG_ShadowDOM;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium38_SVG_P1_flipkart {

    FirefoxDriver driver;

    @BeforeTest
    public void openBrowser(){
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new FirefoxDriver(options);
    }
    @Test
    public void test_flipkart_search(){
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        // Step 1 : Enter the macmini in the inputBox
        //driver.findElement(By.name("q")).sendKeys("macmini");
        driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("macmini");
        // Step 2 : Click on the SVG element
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));
        svgElements.get(0).click();

        List<WebElement> titlesResults = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
        for(WebElement title : titlesResults){
            System.out.println(title.getText());
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
