package com.thetestingacademy.ex08_SVG_ShadowDOM;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium43_WebTables_Static {
    ChromeDriver driver;
    ChromeOptions options = new ChromeOptions();

    @BeforeTest
    public void openBrowser(){
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Description("Verify WebTables")
    @Test
    public void test_webTables(){
        String URL = "https://awesomeqa.com/webtable.html";
        driver.get(URL);

        // To find Row - //table[@id='customers']/tbody/tr
        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        System.out.println(row);
        // To find Column - //table[@id='customers]/tbody/tr[2]/td
        int column = driver.findElements(By.xpath("//table[@id='customers]/tbody/tr[2]/td//table[@id='customers']/tbody/tr[2]/td")).size();
        System.out.println(column);

        // Logic
        // - > //table[@id='customers']/tbody/tr[2...7]/td[1,2,3]

        /*
        Part 1:
            //table[@id='customers']/tbody/tr[
        Part 2:
            i
        Part 3:
            ]/td[
        Part 4:
            ]
         */
        String firstPart = "//table[@id='customers']/tbody/tr[";
        String secondPart = "]/td[";
        String thirdPart = "]";

        for (int i=2; i<=row; i++){
            for (int j=1; j<=column; j++){
                String dynamic_xPath = firstPart + i + secondPart + j + thirdPart ;
                String data = driver.findElement(By.xpath(dynamic_xPath)).getText();
                System.out.println(data);
            }
        }



    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
