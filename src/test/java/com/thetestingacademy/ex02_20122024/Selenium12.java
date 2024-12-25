package com.thetestingacademy.ex02_20122024;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium12 {
    @Test
    public void testMethod(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");

    }
}
