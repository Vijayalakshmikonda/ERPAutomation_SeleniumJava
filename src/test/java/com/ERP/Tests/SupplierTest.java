package com.ERP.Tests;

import org.testng.annotations.Test;
import com.ERP.Base.BaseTest;
import com.ERP.Pages.AddSuppliers;
import com.ERP.Utils.ExcelDataProvider;
import com.ERP.Listeners.TestListener;

public class SupplierTest extends BaseTest {


@Test(dataProvider="supplierData",
      dataProviderClass=ExcelDataProvider.class)

public void addSupplierTest(
String supplierName,
String address,
String city,
String country,
String contactPerson,
String phone,
String email,
String mobile,
String notes) {

    System.out.println("Supplier: " + supplierName);

    if(TestListener.test != null) {
        TestListener.test.info("Starting Add Supplier Test");
    }
    
    AddSuppliers supplier =
    new AddSuppliers(driver);
    
    supplier.addSupplierDetails(
            supplierName,
            address,
            city,
            country,
            contactPerson,
            phone,
            email,
            mobile,
            notes
    );
    
    if(TestListener.test != null) {
        TestListener.test.pass("Supplier added successfully");
    }
}

}