package com.thetestingacademy.Tasks.Dec302024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task1_idrive360 {
    @Test
    public void testMethod() throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(options);
        driver.get("https://www.idrive360.com/enterprise/login");

        Thread.sleep(5000);//Since the site is very slow to handle the input, we are making it to sleep for few seconds

        //<input _ngcontent-uex-c4=""
        // autofocus=""
        // class="id-form-ctrl ng-pristine ng-valid ng-touched"
        // id="username"
        // name="username"
        // type="email"
        // fdprocessedid="7ks2x">
        WebElement input_email = driver.findElement(By.xpath("//input[@id='username']"));
        input_email.sendKeys("augtest_040823@idrive.com");

        //<input _ngcontent-sgl-c4=""
        // class="id-form-ctrl ng-pristine ng-valid ng-touched"
        // id="password"
        // maxlength="20"
        // name="password"
        // tabindex="0"
        // type="password"
        // fdprocessedid="un2tkn">
        WebElement input_password = driver.findElement(By.xpath("//input[@id='password']"));
        input_password.sendKeys("123456");

        //<button _ngcontent-hxm-c4=""
        // class="id-btn id-info-btn-frm"
        // id="frm-btn"
        // type="submit"
        // fdprocessedid="2mmpxj">
        // Sign in
        // </button>
        WebElement btn_signIn = driver.findElement(By.xpath("//button[@id='frm-btn']"));
        btn_signIn.click();

        Thread.sleep(10000);
        assertThat(driver.getCurrentUrl().equals("https://www.idrive360.com/enterprise/account?upgradenow=true"));

        //Error Message
        //<h5 _ngcontent-bey-c10=""
        // class="id-card-title">
        // Your free trial has expired
        // </h5>
        WebElement error_message = driver.findElement(By.xpath("//h5[contains(text(),'Your free trial has expired')]"));
        assertThat(error_message.getText()).isEqualTo("Your free trial has expired");

        Thread.sleep(3000);
        driver.quit();

    }
}
