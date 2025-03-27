package com.thetestingacademy.ex_SeleniumAction_Windows_IFrame;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Selenium49_Action_Window_IFrame_P5 {

    EdgeDriver driver;
    EdgeOptions options;

    @BeforeTest
    public void openBrowser(){
        options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--incognito");
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
    }

    @Description("Verify HeatMap(app.vwo.com)")
    @Test
    public void test_Heatmap_ClickButton() throws InterruptedException {
        String URL = "https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1";
        driver = new EdgeDriver(options);
        driver.get(URL);

        Thread.sleep(5000);

        String parent_window = driver.getWindowHandle();
        System.out.println("Parent Window : " + parent_window);

//        List<WebElement> heat_maps = driver.findElements(By.xpath("//div[@data-qa='voferojeve']"));
//
//        Actions actions = new Actions(driver);
//        actions.moveToElement(heat_maps.get(1)).click().build().perform();

        Thread.sleep(5000);
        List<WebElement> list_heatmaps = driver.findElements(By.cssSelector("[data-qa='yedexafobi']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(list_heatmaps.get(1)).click().build().perform();

        Thread.sleep(13000);

        Set<String> all_window_handles = driver.getWindowHandles();
        System.out.println("All Window Handles : " + all_window_handles);

        for (String handle : all_window_handles){
            if(!handle.equals(parent_window)){
                driver.switchTo().window(handle);
                System.out.println("Child Window Handle : "+ driver.getTitle());
                driver.switchTo().frame("heatmap-iframe");
                WebElement clickMap = driver.findElement(By.cssSelector("[data-qa='liqokuxuba']"));
                clickMap.click();
            }
        }
        driver.switchTo().window(parent_window);
    }

    @AfterTest
    public void close_Browser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
