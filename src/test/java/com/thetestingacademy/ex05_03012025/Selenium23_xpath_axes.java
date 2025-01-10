package com.thetestingacademy.ex05_03012025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Selenium23_xpath_axes {
    @Test
    public void testMethod() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://cdpn.io/AbdullahSajjad/fullpage/LYGVRgK?anon=true&view=fullpage");

        //iframe concept. Not covered as of now.
        driver.switchTo().frame("result");

        WebElement submit_btn = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submit_btn.click();

        //Since we click the button without any input, we will get error messages
        //To find the error message which is under <small> tag, we have to use xpath-axes
        //WebElement smallErrorMsg = driver.findElement(By.xpath("//input[@id='username']/following-sibling::small"));
        String input_username_path = "//input[@id='username']";
        String small_path = input_username_path+"/following-sibling::small";
        String label_path = input_username_path+"/preceding-sibling::label";

        WebElement smallErrorMsg = driver.findElement(By.xpath(small_path));
        WebElement label_username = driver.findElement(By.xpath(label_path));

        System.out.println(label_username.getText());

        assertThat(smallErrorMsg.getText().equals("Username must be at least" +
                " 3 characters"));

        Thread.sleep(3000);
        driver.quit();
    }
}
