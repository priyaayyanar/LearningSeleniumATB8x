package com.thetestingacademy.ex_DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDrivenTesting_Parallel {

    @DataProvider(name = "LoginData", parallel = true)
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin@gmail.com","admin123"},
                new Object[]{"admin11@gmail.com","admin11"},
                new Object[]{"admin22@gmail.com","admin22"}
        };
    }

    @DataProvider(name = "LoginData2", parallel = true)
    public Object[][] getData2(){
        return new Object[][]{
                new Object[]{"admin@gmail.com","admin"},
                new Object[]{"admin33@gmail.com","admin33"},
                new Object[]{"admin44@gmail.com","admin44"}
        };
    }

    @Test(dataProvider = "LoginData")
    public void test_Login(String email, String pwd){
        System.out.println(email + " | " + pwd);
    }

    @Test(dataProvider = "LoginData2")
    public void test_Login2(String email, String pwd){
        System.out.println(email + " | " + pwd);
    }
}
