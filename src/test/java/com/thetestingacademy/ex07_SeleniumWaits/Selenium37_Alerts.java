package com.thetestingacademy.ex07_SeleniumWaits;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Selenium37_Alerts {

    public static void main(String[] args) throws InterruptedException {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        //XPath to find the alert button
        //  //button[@onclick="jsAlert()"]
        //  //button[text()='Click for JS Alert']

        WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Alert']")        );
        //WebElement element1 = driver.findElement(By.cssSelector("//button[@onclick='jsConfirm()']"));
       // WebElement element2 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));

        element.click();
        //element1.click();
        //element2.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        //alert.sendKeys("Priya");
        wait = new WebDriverWait(driver, Duration.ofSeconds(3000L));
        //Thread.sleep(3000);
        //wait(3000);
        alert.accept();
        // alert.dismiss();


        String result = driver.findElement(By.id("result")).getText();
        //Assert.assertEquals(result,"You entered: Priya");
        Assert.assertEquals(result,"You successfully clicked an alert");

       //Thread.sleep(3000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3000L));

        driver.quit();
    }
}
