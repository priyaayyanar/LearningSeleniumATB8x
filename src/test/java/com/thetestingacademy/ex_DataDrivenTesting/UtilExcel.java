package com.thetestingacademy.ex_DataDrivenTesting;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {

    /* Perform the following steps to read the file (Apache POI)
     -> Create work book
     -> Sheet
     -> Row and Cell
     -> 2D Object - getData() - to read the file
    * */

    static Workbook workbook;
    static Sheet sheet;

    public static String SHEET_PATH = System.getProperty("user.dir")+"src/test/Resources/TestData.xlsx";

    public static Object[][] getTestDataFromExcel(String sheetName) throws IOException {

        FileInputStream file = null;
        file = new FileInputStream(SHEET_PATH);

        workbook = WorkbookFactory.create(file);
        sheet = workbook.getSheet(sheetName);


        return null;
    }

//    public static Object[][] getTestDataFromSQL(String sheetName){
//
//        return null;
//    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return getTestDataFromExcel("Sheet1");
        //return getTestDataFromSQL("Sheet1");
    }
}
