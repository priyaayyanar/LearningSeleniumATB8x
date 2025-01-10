package com.thetestingacademy.ex06_6Jan2025.RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium28_CodePen {

    @Test
    public void test_UserName() throws InterruptedException {

        String URL = "https://codepen.io/AbdullahSajjad/full/LYGVRgK";
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        // iframe
        driver.switchTo().frame("result");

        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitBtn.click();

        WebElement input_userName = driver.findElement(By.xpath("//input[@id='username']"));

        WebElement error_userName = driver.findElement(with(By.tagName("small")).below(input_userName));

        String errorText = error_userName.getText();
        assertThat(errorText.equals("Username must be at least 3 characters"));

        Thread.sleep(3000);
        driver.quit();

    }


}
