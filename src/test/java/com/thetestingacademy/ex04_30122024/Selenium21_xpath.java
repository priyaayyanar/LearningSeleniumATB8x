package com.thetestingacademy.ex04_30122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium21_xpath {
    @Test
    public void testMethod01() throws Exception {


        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");

        Thread.sleep(10000);

        WebElement username_input_xpath = driver.findElement(By.xpath("//input[@id='username']"));

        username_input_xpath.sendKeys("augtest_040823@idrive.com");

        Thread.sleep(3000);

        driver.quit();




    }
}
