package com.thetestingacademy.Tasks.Dec232024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1_AutomateKatalon {
    @Test
    public void testAppointment() throws InterruptedException {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://katalon-demo-cura.herokuapp.com/");

        /* Testing Make Appointment anchor tag
            <a id="btn-make-appointment"
             href="./profile.php#login"
             class="btn btn-dark btn-lg">
             Make Appointment
             </a>
         */
        WebElement make_appointment = edgeDriver.findElement(By.linkText("Make Appointment"));
        make_appointment.click();

        /* Set value to the UserName by locating WebElement
            <input type="text"
             class="form-control"
             id="txt-username"
             name="username"
             placeholder="Username"
             value=""
             autocomplete="off"
             fdprocessedid="93qyd2">
         */
        WebElement username = edgeDriver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        /* Set value to the Password by locating WebElement
            <input type="password"
            class="form-control"
            id="txt-password"
            name="password"
            placeholder="Password"
            value=""
            autocomplete="off"
            fdprocessedid="ioo058">
         */
        WebElement password = edgeDriver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        /* Click on Login Button
            <button id="btn-login"
            type="submit"
            class="btn btn-default"
            fdprocessedid="bet779">
            Login
            </button>
         */
        WebElement login_button = edgeDriver.findElement(By.id("btn-login"));
        login_button.click();

        //To assert that the navigation is working
        Thread.sleep(3000);
        Assert.assertEquals(edgeDriver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        edgeDriver.quit();
    }
}
