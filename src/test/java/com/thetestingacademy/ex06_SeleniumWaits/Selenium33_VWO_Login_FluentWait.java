package com.thetestingacademy.ex06_SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Selenium33_VWO_Login_FluentWait {
    @Test
    public void test_VWO_Login(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://app.vwo.com");

        Assert.assertEquals(edgeDriver.getTitle(),"Login - VWO");
        Assert.assertEquals(edgeDriver.getCurrentUrl(),"https://app.vwo.com/#/login");

        WebElement emailInputBox = edgeDriver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = edgeDriver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("dddadmin");

        WebElement buttonSubmit = edgeDriver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        //Error should be thrown after 3 seconds
        // Based on condition
        //Until the error message is not visible, we will not do the assertion

        //WebElement errorMessage = edgeDriver.findElement(By.id("js-notification-box-msg"));

//        WebDriverWait wait1 = new WebDriverWait(edgeDriver, Duration.ofSeconds(1)); // 3000 MilliSeconds/ 1000 = 3 Sec
//        wait1.until(ExpectedConditions.visibilityOf(errorMessage));
//
//        WebDriverWait wait2 = new WebDriverWait(edgeDriver, Duration.ofSeconds(1)); // 3000 MilliSeconds/ 1000 = 3 Sec
//        wait2.until(ExpectedConditions.textToBePresentInElement(errorMessage,"Your email, password, IP address or location did not match"));

        FluentWait<EdgeDriver> wait = new FluentWait<>(edgeDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement errorMessage = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return edgeDriver.findElement(By.id("js-notification-box-msg"));
            }
        });

        /* Reusing the wait object

        WebDriverWait wait = new WebDriverWait(edgeDriver, Duration.ofSeconds(1)); // 3000 MilliSeconds/ 1000 = 3 Sec
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        wait.until(ExpectedConditions.textToBePresentInElement(errorMessage,"Your email, password, IP address or location did not match"));

         */

        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        edgeDriver.quit();
    }
}
