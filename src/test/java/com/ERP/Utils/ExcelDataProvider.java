package com.ERP.Utils;

import org.testng.annotations.DataProvider;


public class ExcelDataProvider {


    @DataProvider(name="supplierData")
    public Object[][] supplierData(){


        return ExcelUtility.getExcelData(
        "./src/test/resources/TestData/ERPDataExcel.xlsx",
        "SuppliersData"
        );

    }



    @DataProvider(name="customerData")
    public Object[][] customerData(){


        return ExcelUtility.getExcelData(
        "./src/test/resources/"
        + "TestData/ERPDataExcel.xlsx",
        "CustomersData"
        );

    }


}