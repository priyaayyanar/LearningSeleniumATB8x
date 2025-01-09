package com.thetestingacademy.Tasks.Dec302024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Task2 {
    @Test
    public void testMethod() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

        WebElement input_searchBox = edgeDriver.findElement(By.xpath("//input[@id='gh-ac']"));
        input_searchBox.sendKeys("macmini");

        WebElement input_searchButton = edgeDriver.findElement(By.xpath("//input[@value='Search']"));
        input_searchButton.click();

        List<WebElement> searchTitle = edgeDriver.findElements(By.xpath("//div[@class='s-item__title']"));

        List<WebElement> searchPrice = edgeDriver.findElements(By.xpath("//span[@class='s-item__price']"));

        int size = Math.min(searchTitle.size(),searchPrice.size());

        for (int i= 0 ; i <size; i++) {
            if (searchTitle.get(i).getText() == "" && searchPrice.get(i).getText() == ""){
                continue;
            }else {
                System.out.println("Title : " + searchTitle.get(i).getText() + "||" + " Price : " + searchPrice.get(i).getText());
            }
        }
        Thread.sleep(3000);
        edgeDriver.quit();
    }
}
