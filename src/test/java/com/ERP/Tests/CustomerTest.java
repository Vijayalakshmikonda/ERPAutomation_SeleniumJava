package com.ERP.Tests;

import com.ERP.Listeners.TestListener;
import org.testng.annotations.Test;

import com.ERP.Base.BaseTest;
import com.ERP.Pages.AddCustomers;
import com.ERP.Utils.ExcelDataProvider;


public class CustomerTest extends BaseTest {


@Test(dataProvider="customerData",
      dataProviderClass=ExcelDataProvider.class)

public void addCustomerTest(
String customerName,
String address,
String city,
String country,
String contactPerson,
String phone,
String email,
String mobile,
String notes) {

	TestListener.test.info("Starting Add Customer Test");
    AddCustomers customer =
    new AddCustomers(driver);

    System.out.println("Customer: " + customerName);
    
    customer.addCustomerDetails(
            customerName,
            address,
            city,
            country,
            contactPerson,
            phone,
            email,
            mobile,
            notes
    );

    TestListener.test.pass("Customer added successfully");
}


}