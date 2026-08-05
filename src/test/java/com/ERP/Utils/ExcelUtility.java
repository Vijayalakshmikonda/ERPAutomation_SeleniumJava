package com.ERP.Utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtility {


    public static Object[][] getExcelData(String filePath, String sheetName) {

        Object[][] data = null;

        try {

            FileInputStream fis = new FileInputStream(filePath);

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet(sheetName);


            int rows = sheet.getPhysicalNumberOfRows();

            int columns = sheet.getRow(0).getLastCellNum();


            data = new Object[rows - 1][columns];


            for(int i = 1; i < rows; i++) {

                for(int j = 0; j < columns; j++) {

                    data[i-1][j] =
                    sheet.getRow(i)
                    .getCell(j)
                    .toString();

                }
            }


            workbook.close();
            fis.close();

        }
        catch(Exception e) {

            e.printStackTrace();

        }


        return data;

    }

}