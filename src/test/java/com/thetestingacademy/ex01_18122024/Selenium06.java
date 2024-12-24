package com.thetestingacademy.ex01_18122024;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium06 {

    public static void main(String[] args) {
        WebDriver webDriver = new EdgeDriver();
        webDriver.get("https://sdet.live");
    }

}
