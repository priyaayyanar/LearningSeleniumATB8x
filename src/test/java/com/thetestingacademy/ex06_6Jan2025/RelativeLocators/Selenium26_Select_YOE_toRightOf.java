package com.thetestingacademy.ex06_6Jan2025.RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium26_Select_YOE_toRightOf {

    @Test
    public void test_awesomeQA() throws InterruptedException {

        String URL = "https://awesomeqa.com/practice.html";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        WebElement span_YOE = driver.findElement(By.xpath("//span[normalize-space()='Years of Experience']"));
        driver.findElement(with(By.id("exp-2")).toRightOf(span_YOE)).click();

        Thread.sleep(3000);
        driver.quit();

    }
}
