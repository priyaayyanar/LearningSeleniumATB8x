package com.thetestingacademy.ex06_6Jan2025.JSExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium25_JSExecutor {
    @Test
    public void test_selectorHub() throws InterruptedException {

        String URL = "https://selectorshub.com/xpath-practice-page/";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        WebElement div_to_scroll = driver.findElement(By.xpath("//div[@id='userName']"));
        //jse.executeScript("arguments[0].scrollIntoView(true);",div_to_scroll);

        //WebElement userName = driver.findElement(By.xpath(""));

        String html = jse.executeScript("return arguments[0].style.display",div_to_scroll).toString();
        System.out.println(html);

        Thread.sleep(3000);
        driver.quit();

    }

}
