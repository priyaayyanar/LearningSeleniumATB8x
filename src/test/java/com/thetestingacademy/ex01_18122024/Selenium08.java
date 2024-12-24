package com.thetestingacademy.ex01_18122024;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium08 {
    @Test
    public void test_EdgeOptions(){
        EdgeOptions edgeOptions = new EdgeOptions();
        //edgeOptions.addArguments("--start--maximized");
        edgeOptions.addArguments("--window-size=1920,1080");
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--headless");


        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://google.com");
        System.out.println(edgeDriver.getTitle());
    }
}
