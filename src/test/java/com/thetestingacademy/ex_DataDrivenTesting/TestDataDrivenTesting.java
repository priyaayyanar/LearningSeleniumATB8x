package com.thetestingacademy.ex_DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDrivenTesting {

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin@gmail.com","admin123"},
                new Object[]{"admin11@gmail.com","admin12311"}
        };
    }
    @Test(dataProvider = "getData")
    public void test_Login(String email, String pwd){
        System.out.println(email + " | " + pwd);
    }
}
