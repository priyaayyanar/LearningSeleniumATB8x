package com.thetestingacademy.Tasks.Dec232024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Task2_Automate_AwesomeQA {
    @Test
    public void testAwesomeQA(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://awesomeqa.com/practice.html");

        /* Set First Name by locating WebElement
        <input name="firstname"
        style="-webkit-appearance: none; appearance: none; background-color: #fcfcfc; border-color: rgba(173, 176, 182, 0.3); border-radius: 0px; border-style: solid; border-width: 1px; color: #787d85; font-family: verdana, helvetica, arial, verdana, sans-serif; font-size: 13px; height: 38px; line-height: 22px; margin: 0px; outline: 0px; padding: 5px 15px; vertical-align: baseline;"
        type="text"
        fdprocessedid="02ocet">
         */
        WebElement firstName = edgeDriver.findElement(By.name("firstname"));
        firstName.sendKeys("Priya");

        /* Set Last Name by locating WebElement
        <input name="lastname"
        style="-webkit-appearance: none; appearance: none; background-color: #fcfcfc; border-color: rgba(173, 176, 182, 0.3); border-radius: 0px; border-style: solid; border-width: 1px; color: #787d85; font-family: verdana, helvetica, arial, verdana, sans-serif; font-size: 13px; height: 38px; line-height: 22px; margin: 0px; outline: 0px; padding: 5px 15px; vertical-align: baseline;"
        type="text"
        fdprocessedid="uqcwxp">
         */
        WebElement lastName = edgeDriver.findElement(By.name("lastname"));
        lastName.sendKeys("Ayyanar");

        /* Check Gender column to Female
        <input id="sex-1"
        name="sex"
        style="font-size: 14px; margin-left: 0px; margin-right: 0px; margin-top: 0px; padding: 0px; vertical-align: baseline;"
        type="radio"
        value="Female">
         */
        WebElement gender = edgeDriver.findElement(By.id("sex-1"));
        gender.click();

        /* Check Years of Experience
        <input id="exp-5"
        name="exp"
        style="font-size: 14px; margin-left: 0px; margin-right: 0px; margin-top: 0px; padding: 0px; vertical-align: baseline;"
        type="radio"
        value="6">
         */
        WebElement experience = edgeDriver.findElement(By.id("exp-5"));
        experience.click();

        /* Set Date
        <input id="datepicker"
        style="-webkit-appearance: none; appearance: none; background-color: #fcfcfc; border-color: rgba(173, 176, 182, 0.3); border-radius: 0px; border-style: solid; border-width: 1px; color: #787d85; font-family: verdana, helvetica, arial, verdana, sans-serif; font-size: 13px; height: 38px; line-height: 22px; margin: 0px; outline: 0px; padding: 5px 15px; vertical-align: baseline;"
        type="text"
        fdprocessedid="8tc9lb">
         */
        WebElement setDate = edgeDriver.findElement(By.id("datepicker"));
        setDate.sendKeys("23122024");

        /* Select Profession
        <input id="profession-1"
        name="profession"
        style="font-size: 14px; margin: 0px; padding: 0px; vertical-align: baseline;"
        type="checkbox"
        value="Automation Tester">
         */
        WebElement profession = edgeDriver.findElement(By.id("profession-1"));
        profession.click();

        /* Set Automation Tool
        <input id="tool-2"
        name="tool"
        style="font-size: 14px; margin: 0px; padding: 0px; vertical-align: baseline;"
        type="checkbox"
        value="Selenium Webdriver">
         */
        WebElement tool = edgeDriver.findElement(By.id("tool-2"));
        tool.click();

        /* Click Button
        <button class="btn btn-info"
        id="submit"
        name="submit"
        style="-webkit-appearance: none; appearance: none; cursor: pointer; font-size: 14px; margin: 0px; outline: 0px; padding: 0px; vertical-align: baseline;"
        fdprocessedid="dbj9k">
        Button
        </button>
         */
        WebElement submit = edgeDriver.findElement(By.id("submit"));
        submit.click();
    }
}
