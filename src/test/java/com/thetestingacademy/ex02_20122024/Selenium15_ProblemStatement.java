package com.thetestingacademy.ex02_20122024;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;


public class Selenium15_ProblemStatement {

    @Test
    public void testMethod() throws Exception {

        // Open the https://katalon-demo-cura.herokuapp.com/
        // Verify the title and search a string in pageSource
        // Add assertion that the Cura heatlh care Service is visible in the page source.

        /* Another way of using options
         driver.manage().window().maximize();
         */
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //driver.manage().window().maximize();

        //TestNG Assertion
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");

        //AssertJ Assertion
        assertThat(driver.getTitle()).isNotNull().isNotEmpty().isEqualTo("CURA Healthcare Service");
        assertThat(driver.getCurrentUrl()).isEqualTo("https://katalon-demo-cura.herokuapp.com/");

        if(driver.getPageSource().contains("CURA Healthcare Service")){
            Assert.assertTrue(true);
        }else {
            throw new Exception("Heading Not Found");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
