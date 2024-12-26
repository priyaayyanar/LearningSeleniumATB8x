package com.thetestingacademy.ex03_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Slenium17_AutomateVWO {
    @Test
    public void testMethod() throws InterruptedException {
        // <input
        // type="email"
        // class="text-input W(100%)"
        // name="username"
        // id="login-username"
        // data-qa="hocewoqisi"
        // fdprocessedid="bybqba"
        // data-gtm-form-interact-field-id="3">

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://app.vwo.com");

        Assert.assertEquals(edgeDriver.getTitle(),"Login - VWO");
        Assert.assertEquals(edgeDriver.getCurrentUrl(),"https://app.vwo.com/#/login");

        //<input type="email"
        // class="text-input W(100%)"
        // name="username"
        // id="login-username"
        // data-qa="hocewoqisi">

        WebElement emailInputBox = edgeDriver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

//        <input type="password"
//          class="text-input W(100%)"
//          name="password"
//          id="login-password"
//          data-qa="jobodapuxe"
//          >
        WebElement passwordInputBox = edgeDriver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("dddadmin");

        //<button type="submit"
        //  id="js-login-btn"
        //  class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)"
        //  onclick="login.login(event)"
        //  data-qa="sibequkica" fdprocessedid="bd1bx6">
        // <span class="icon loader hidden" data-qa="zuyezasugu"></span>
        // <span data-qa="ezazsuguuy">Sign in</span>
        // </button>
        WebElement buttonSubmit = edgeDriver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        Thread.sleep(3000);
        //<div class="notification-box-description"
        // id="js-notification-box-msg"
        // data-qa="rixawilomi">
        // Your email, password, IP address or location did not match
        // </div>
        WebElement errorMessage = edgeDriver.findElement(By.id("js-notification-box-msg"));
        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");

        //assertThat(errorMessage.getText()).isNotEmpty().isNotNull().isEqualTo("Your email, password, IP address or location did not match");

        //Thread.sleep(5000);
        edgeDriver.quit();


    }
}
