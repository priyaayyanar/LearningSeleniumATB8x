package com.thetestingacademy.ex02_20122024;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium14 {
    @Test
    public void testMethod() throws InterruptedException {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("http://google.com");

        Thread.sleep(5000);

        driver.quit();
        /*These both work
            driver.get("https://sdet.live");
            driver.get("http://sdet.live");
         */

        /*These both will not work
            driver.get("sdet.live");
            diver.get("www.google.com")

         */

        //driver.get("www.google.com");

    }
}
