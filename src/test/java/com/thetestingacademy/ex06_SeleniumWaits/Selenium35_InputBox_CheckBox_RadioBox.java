package com.thetestingacademy.ex06_SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class Selenium35_InputBox_CheckBox_RadioBox {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://awesomeqa.com/practice.html");

        //InputBox
        driver.findElement(By.name("firstname")).sendKeys("The Testing Academy");

        //RadioBox
        driver.findElement(By.id("sex-1")).click();

        //CheckBox
        driver.findElement(By.id("profession-1")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
