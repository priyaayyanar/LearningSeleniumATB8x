package com.thetestingacademy.Tasks;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTables {
    ChromeDriver driver;
    ChromeOptions options;

    @BeforeTest
    public void openBrowser(){
        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Description("WebTables of Orange HRM")
    @Test
    public void test_OrangeHRM_WebTables() throws InterruptedException {
        String URL = "https://awesomeqa.com/hr/web/index.php/auth/login";
        driver.get(URL);

        JavascriptExecutor js = (JavascriptExecutor)driver;

        //UserName : admin
        //Password : Hacker@4321

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,1000)");

        //Thread.sleep(10000);

        /*
        //div[@role='table']
        //div[@role='row']
        //column
        Find Following Parent , child to find the element which is terminated and click on the delete button

        //div[contains(@class,'oxd-table-cell')][9]
         */

        driver.findElement(By.xpath("//div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-paper-container']/div[@class='orangehrm-container']/div[@class='oxd-table orangehrm-employee-list']/div[@class='oxd-table-body oxd-card-table-body']/div[@class='oxd-table-card --mobile'][17]/div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[@class='card-center']/div[@class='card-header-slot']/div[@class='card-item card-header-slot-content --right']/div[@class='oxd-table-cell']/div[@class='oxd-table-cell-actions']/button[@class='oxd-icon-button oxd-table-cell-action-space']")).click();

        
    }


}
