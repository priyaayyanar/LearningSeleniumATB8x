package com.thetestingacademy.ex09_WebTables_Dynamic;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium44_Webtables_Dynamic {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Description("Verify WebTables Dynamic")
    @Test
    public void test_Dynamic_WebTables(){
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);

        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        //rows and columns

        List<WebElement> rows_table = table.findElements(By.tagName("tr"));

        for(int i=0 ; i< rows_table.size(); i++){
            System.out.println(rows_table.get(i).findElement(By.tagName("th")).getText());
            List<WebElement> column = rows_table.get(i).findElements(By.tagName("td"));
            for (WebElement e : column){
                System.out.println(e.getText());
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
