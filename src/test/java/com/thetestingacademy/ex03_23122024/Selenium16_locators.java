package com.thetestingacademy.ex03_23122024;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium16_locators {
    @Test
    public void testMethod(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://katalon-demo-cura.herokuapp.com/");

        edgeDriver.quit();
    }
}
