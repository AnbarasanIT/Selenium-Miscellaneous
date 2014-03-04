package com.example.tests;

import java.io.FileInputStream;
import jxl.Workbook;
import jxl.Sheet;
import jxl.Cell;
import java.io.File;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;



public class ExcelSheetReader {
FileInputStream file = new FileInputStream(newFile("C:/Users/admin/workspace/login.xls"));

    //Get the workbook instance for XLS file 
    HSSFWorkbook workbook = new HSSFWorkbook(file);

    //Get first sheet from the workbook
    HSSFSheet sheet = workbook.getSheetAt(0);

    //Iterate through each rows from first sheet
    Iterator<Row> rowIterator = sheet.iterator();


    while(rowIterator.hasNext()) {

        Row row = rowIterator.next();

        //For each row, iterate through each columns
        Iterator<Cell> cellIterator = row.cellIterator();
        while(cellIterator.hasNext()) {        

            Cell cell = cellIterator.next();
            if(cell.getColumnIndex() == 0){
                     driver.findElement(By.name("UserName")).sendKeys(cell.getStringCellValue());
            }
            else
                driver.findElement(By.name("Password")).sendKeys(cell.getStringCellValue());


        }
        }