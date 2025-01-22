package com.thetestingacademy.ex06_SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Selenium30_ImplicitWait_eBay {

    @Test
    public void test_ImplicitWait(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--start-Maximized");

        EdgeDriver driver = new EdgeDriver(options);
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement input_searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        input_searchBox.sendKeys("macmini");

        WebElement input_searchButton = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
        input_searchButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
