package com.ERP.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class AddSuppliers {

    WebDriver driver;
    WebDriverWait wait;


    
    private static final Logger logger=LogManager.getLogger(AddSuppliers.class);
 // Constructor
    public AddSuppliers(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    // Locators

    By clickSuppliers = By.xpath("//li[@id='mi_a_suppliers']/a");


    By clickAddIcon = By.xpath(
            "//div[@class='panel-heading ewGridUpperPanel']//span[@data-caption='Add']"
    );


    By supplierNumber = By.xpath("//input[@id='x_Supplier_Number']");


    By supplierName = By.xpath("//input[@id='x_Supplier_Name']");


    By address = By.xpath("//textarea[@id='x_Address']");


    By city = By.xpath("//input[@id='x_City']");


    By country = By.xpath("//input[@id='x_Country']");


    By contactPerson = By.xpath("//input[@id='x_Contact_Person']");


    By phoneNumber = By.xpath("//input[@id='x_Phone_Number']");


    By email = By.xpath("//input[@id='x__Email']");


    By mobileNumber = By.xpath("//input[@id='x_Mobile_Number']");


    By notes = By.xpath("//textarea[@id='x_Notes']");



    By confirmOK = By.xpath(
            "//div[contains(@class,'ajs-dialog')]//button[text()='OK!']"
    );

    By alertOK = By.xpath(
            "//div[contains(@class,'ajs-dialog')]//button[contains(@class,'ajs-button') and contains(@class,'btn-primary')]"
    );
    
    By searchPanel = By.xpath("//span[@data-phrase='SearchBtn']");

    By searchTextBox = By.xpath("//input[@id='psearch']");

    By searchButton = By.xpath("//button[@id='btnsubmit']");

    // Supplier table locator

    By supplierTable = By.xpath(
            "//table[contains(@class,'ewTable')]//span[contains(@class,'a_suppliers_Supplier_Number')]"
    );
   
    // Add Supplier Method

    public void addSupplierDetails(
            String sname,
            String Address,
            String cityName,
            String countryName,
            String contactPersonName,
            String phone,
            String emailId,
            String mobile,
            String notesText) {

        // Click Suppliers menu

        wait.until(ExpectedConditions.elementToBeClickable(clickSuppliers))
                .click();

        // Click Add icon

        wait.until(ExpectedConditions.elementToBeClickable(clickAddIcon))
                .click();
        logger.info("Add Supplier button clicked");
        
        // Get generated supplier number

        wait.until(ExpectedConditions.visibilityOfElementLocated(supplierNumber));

        String expectedNumber =
                driver.findElement(supplierNumber)
                        .getAttribute("value");

        // Enter supplier details

        driver.findElement(supplierName)
                .sendKeys(sname);

        driver.findElement(address)
                .sendKeys(Address);

        driver.findElement(city)
                .sendKeys(cityName);

        driver.findElement(country)
                .sendKeys(countryName);

        driver.findElement(contactPerson)
                .sendKeys(contactPersonName);

        driver.findElement(phoneNumber)
                .sendKeys(phone);

        driver.findElement(email)
                .sendKeys(emailId);

        driver.findElement(mobileNumber)
                .sendKeys(mobile);

        driver.findElement(notes)
                .sendKeys(notesText);

        // Save Supplier

        WebElement addButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[@id='btnAction' and normalize-space(text())='Add']")
                )
        );

        ((JavascriptExecutor)driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        addButton
                );


        ((JavascriptExecutor)driver)
                .executeScript(
                        "arguments[0].click();",
                        addButton
                );

        // Confirmation popup
        wait.until(ExpectedConditions.elementToBeClickable(confirmOK))
        .click();

        wait.until(ExpectedConditions.elementToBeClickable(alertOK))
        .click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
        By.xpath("//div[contains(@class,'ajs-dialog') and contains(@class,'ajs-visible')]")
        		));

        logger.info("Supplier confirmation popup closed successfully");
     

     // Wait until Search panel becomes clickable

        wait.until(ExpectedConditions.elementToBeClickable(searchPanel));

        WebElement search =
                wait.until(ExpectedConditions.visibilityOfElementLocated(searchPanel));

        ((JavascriptExecutor)driver)
                .executeScript("arguments[0].scrollIntoView(true);", search);
        
        if(driver.findElements(searchTextBox).isEmpty() ||
        		   !driver.findElement(searchTextBox).isDisplayed()) {

        		    WebElement searchIcon = wait.until(
        		            ExpectedConditions.elementToBeClickable(searchPanel));

        		    ((JavascriptExecutor)driver)
        		            .executeScript("arguments[0].click();", searchIcon);
        		}

     wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox));


     driver.findElement(searchTextBox)
             .clear();


     driver.findElement(searchTextBox)
             .sendKeys(expectedNumber);

     // Wait for search button and click using JS

     WebElement searchBtn = wait.until(
    	        ExpectedConditions.elementToBeClickable(searchButton)
    	);

     ((JavascriptExecutor)driver)
             .executeScript(
                     "arguments[0].click();",
                     searchBtn
             );

        // Wait for search loading completed

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(@class,'ewGridMiddlePanel')]//div[contains(@class,'loading')]")
        ));

        // Wait supplier result

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table[contains(@class,'ewTable')]//span[contains(@class,'a_suppliers_Supplier_Number')]")
        ));

        System.out.println("Supplier added successfully");

        // Validation

        String actualNumber =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(supplierTable)
                )
                .getText();

        System.out.println("Expected Supplier Number: " + expectedNumber);

        System.out.println("Actual Supplier Number: " + actualNumber);

        Assert.assertTrue(
                actualNumber.contains(expectedNumber),
                "Supplier number not found. Expected: "
                        + expectedNumber
                        + " Actual: "
                        + actualNumber
        );

    }


}