package com.thetestingacademy.ex07_SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Selenium36_Select_Static {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito-");
        options.addArguments("--start-maximized");

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        //select.selectByIndex(2);
        select.selectByVisibleText("Option 2");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
