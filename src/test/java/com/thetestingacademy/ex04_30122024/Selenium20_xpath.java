package com.thetestingacademy.ex04_30122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium20_xpath {
    @Test
    public void testMethod() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://www.idrive360.com/enterprise/login");

        //<input _ngcontent-uey-c4=""
        // autofocus=""
        // class="id-form-ctrl ng-pristine ng-valid ng-touched"
        // id="username"
        // name="username"
        // type="email"
        // fdprocessedid="8i88na">
        //WebElement xpath
        //WebElement username_input_id = edgeDriver.findElement(By.id("username"));
        //WebElement username_input_name = edgeDriver.findElement(By.name("username"));
        //WebElement username_input_xpath = edgeDriver.findElement(By.xpath("//input[@id='username']"));
        //WebElement username_input_xpath = edgeDriver.findElement(By.xpath("//input[@id='username']"));
        //WebElement abc_input_xpath = edgeDriver.findElement(By.xpath("//input[@abc='xyz']"));
        //WebElement dataqa_input_xpath = edgeDriver.findElement(By.xpath("//input[@data_qa='unique']"));
        //username_input_xpath.sendKeys("augtest_040823@idrive.com");

        //*[@id="expiredmsg"]/div/h5
        // /html/body/app-root/app-layout/div[2]/div[2]/app-account/section/div[2]/div[2]/div[2]/div[2]/div[2]/form/div/div/fieldset[1]/div[1]/div/h5
        // /html/body/header/div/a

        //a[contains(text(),"Make")] - Full visible text - Text matching
        //a[contains(text(),"Make")] - Partial text Matching

       // Thread.sleep(3000);
       // edgeDriver.quit();


    }
}
