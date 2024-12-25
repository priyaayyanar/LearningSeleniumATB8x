package com.thetestingacademy.ex02_20122024;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium13 {

    @Test
    public void testMethod(){
        EdgeDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://sdet.live");

        edgeDriver.navigate().to("https://thetestingacademy.com");
        edgeDriver.navigate().back();
        edgeDriver.navigate().forward();
        System.out.println(edgeDriver.getTitle());

    }



}
