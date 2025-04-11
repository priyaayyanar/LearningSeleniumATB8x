package com.thetestingacademy.ex06_6Jan2025.RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium27_AQI_locations {
    @Test
    public void test_aqi_India() throws InterruptedException {

        String URL = "https://www.aqi.in/real-time-most-polluted-city-ranking";
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        List<WebElement> searchBox = driver.findElements(By.xpath("//input[@type='search']"));
        searchBox.get(1).sendKeys("India"+ Keys.ENTER);

        Thread.sleep(3000);

        List<WebElement> locations = driver.findElements(By.cssSelector("div.location-name>p")); //inside the div tag of p tag
        for (WebElement e : locations){
            String s1 = driver.findElement(with(By.tagName("p")).toLeftOf(e)).getText();

            String s2 = driver.findElement(with(By.tagName("span")).toRightOf(e)).getText();

            String s3 = driver.findElement(with(By.tagName("p")).above(e)).getText();

            String s4 = driver.findElement(with(By.tagName("p")).below(e)).getText();

            System.out.println("Rank : "+s1+" | Location : "+e.getText()+"| AQI Pollution : "+s2+ " | "+s3+ " | "+s4);
        }
        Thread.sleep(3000);
        driver.quit();
      }
     }

