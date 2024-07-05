package com.Miaplaza.utilities;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrowserUtils {

    private org.apache.poi.ss.usermodel.Sheet workSheet;
    private Workbook workBook;
    private String path;

    public BrowserUtils(String sheetName) {
        this.path = ConfigurationReader.get("excelPath");
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(ConfigurationReader.get("excelPath"));
            // Access the required test data sheet
            workBook = WorkbookFactory.create(ExcelFile);
            workSheet = workBook.getSheet(sheetName);
            // check if sheet is null or not. null means  sheetname was wrong
            Assert.assertNotNull("Sheet: \"" + sheetName + "\" does not exist\n", workSheet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static String getText(WebElement element) {
        String VisibleText = "";

        VisibleText = element.getText();

        return VisibleText;
    }


    public static Map<String, String> getData(String sheetName) {
        return new BrowserUtils(sheetName).getDataList().stream().findFirst().get();
    }

    public List<Map<String, String>> getDataList() {
        // get all columns
        List<String> columns = getColumnsNames();
        // this will be returned
        List<Map<String, String>> data = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            // get each row
            Row row = workSheet.getRow(i);
            // create map of the row using the column and value
            // column map key, cell value --> map bvalue
            Map<String, String> rowMap = new HashMap<String, String>();
            try {
                for (Cell cell : row) {
                    try {
                        int columnIndex = cell.getColumnIndex();
                        rowMap.put(columns.get(columnIndex), cell.toString());

                    } catch (IndexOutOfBoundsException e) {

                    }
                }
            } catch (NullPointerException n) {
                return data;
            }
            data.add(rowMap);
        }
        return data;
    }

    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

    public static void selectHear(List<String> sites) {
        for (String site : sites) {
            System.out.println("role = " + site);
            Driver.get().findElement(By.xpath("//em[.='" + site + "']")).click();
        }
    }

    public static void selectDropDownByText(WebElement element, String text) {

        Select elementToBeSelected = new Select(element);
        elementToBeSelected.selectByVisibleText(text);
    }


}
