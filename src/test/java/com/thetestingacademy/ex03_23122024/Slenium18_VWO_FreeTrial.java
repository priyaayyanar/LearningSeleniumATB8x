package com.thetestingacademy.ex03_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Slenium18_VWO_FreeTrial {
    @Test
    public void testMethod() throws InterruptedException {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://app.vwo.com");

//        Assert.assertEquals(edgeDriver.getTitle(),"Login - VWO");
//        Assert.assertEquals(edgeDriver.getCurrentUrl(),"https://app.vwo.com/#/login");

        //<a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        // class="text-link"
        // data-qa="bericafeqo">
        // Start a free trial
        // </a>

//        WebElement link_free_trial = edgeDriver.findElement(By.linkText("Start a free trial"));
//        link_free_trial.click();

        WebElement link_free_trial = edgeDriver.findElement(By.partialLinkText("free trial"));
        link_free_trial.click();

        Thread.sleep(5000);
        edgeDriver.quit();


    }
}
