package com.thetestingacademy.ex06_SeleniumWaits;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium32_MakeMyTrip {
    @Description("Verify MakeMyTrip")
    @Test
    public void test_MakeMyTrip(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.navigate().to("https://www.makemytrip.com/");
        System.out.println(edgeDriver.getTitle());

        WebDriverWait wait = new WebDriverWait(edgeDriver, Duration.ofSeconds(1)); // 3000 MilliSeconds/ 1000 = 3 Sec
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        WebElement close_PopUp = edgeDriver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        close_PopUp.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        edgeDriver.quit();

    }
}
