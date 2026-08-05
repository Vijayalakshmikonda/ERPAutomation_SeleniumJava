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


public class AddCustomers {

    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(AddCustomers.class);

    // Constructor

    public AddCustomers(WebDriver driver) {
    	
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }


    // Locators

    By clickCustomers = By.xpath("//li[@id='mi_a_customers']/a");

    By clickAddIcon = By.xpath("//div[@class='panel-heading ewGridUpperPanel']//span[@data-caption='Add']");

    By customerNumber = By.xpath("//input[@id='x_Customer_Number']");

    By customerName = By.xpath("//input[@id='x_Customer_Name']");

    By address = By.xpath("//textarea[@id='x_Address']");

    By city = By.xpath("//input[@id='x_City']");

    By country = By.xpath("//input[@id='x_Country']");

    By contactPerson = By.xpath("//input[@id='x_Contact_Person']");

    By phoneNumber = By.xpath("//input[@id='x_Phone_Number']");

    By email = By.xpath("//input[@id='x__Email']");

    By mobileNumber = By.xpath("//input[@id='x_Mobile_Number']");

    By notes = By.xpath("//input[@id='x_Notes']");


    By addButton = By.xpath("//button[@type='submit']");


    By confirmOK = By.xpath("//button[text()='OK!']");


    By alertOK = By.xpath("//button[contains(@class,'ajs-button') and contains(@class,'btn-primary')]");


    By searchPanel = By.cssSelector(
            ".glyphicon.glyphicon-search.ewIcon");

    By searchTextBox = By.xpath("//input[@id='psearch']");


    By searchButton = By.xpath("//button[@id='btnsubmit']");


    // Customer table locator
    // Difference from Supplier: td:nth-child(5)

    By customerTable = By.xpath(
            "//table[contains(@class,'ewTable')]//span[contains(@class,'a_customers_Customer_Number')]"
    );

    // Add Customer Method

    public void addCustomerDetails(
            String cname,
            String Address,
            String cityName,
            String countryName,
            String contactPersonName,
            String phone,
            String emailId,
            String mobile,
            String notesText) {

    	   logger.info("Starting Add Customer process");

        // Click Customers menu

        wait.until(ExpectedConditions.elementToBeClickable(clickCustomers))
                .click();



        // Click Add icon

        wait.until(ExpectedConditions.elementToBeClickable(clickAddIcon))
                .click();



        // Get generated customer number

        wait.until(ExpectedConditions.visibilityOfElementLocated(customerNumber));


        String expectedNumber =
                driver.findElement(customerNumber)
                .getAttribute("value");



        // Enter customer details

        driver.findElement(customerName)
                .sendKeys(cname);
        logger.info("Customer name entered: " + cname);

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



        // Save customer

        //driver.findElement(addButton).click();
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

        logger.info("Add Customer button clicked");

     // Confirmation popup

        wait.until(ExpectedConditions.elementToBeClickable(confirmOK))
                .click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(alertOK));


        wait.until(ExpectedConditions.elementToBeClickable(alertOK))
                .click();


        // Wait until popup overlay disappears

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".ajs-dialog")
        ));


        // Search customer

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchPanel));


        if(!driver.findElement(searchTextBox).isDisplayed()) {

            driver.findElement(searchPanel).click();

        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox));

        driver.findElement(searchTextBox).clear();

        driver.findElement(searchTextBox)
                .sendKeys(expectedNumber);


        // Click search button safely for Jenkins execution

        WebElement searchBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(searchButton)
        );


        ((JavascriptExecutor)driver)
                .executeScript(
                        "arguments[0].click();",
                        searchBtn
                );

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
        By.xpath("//div[contains(@class,'ewGridMiddlePanel')]//div[contains(@class,'loading')]")
        		));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//table[contains(@class,'ewTable')]//span[contains(@class,'a_customers_Customer_Number')]")
        		));
        System.out.println("Customer added successfully");
        // Validation

        String actualNumber =
                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(customerTable)
                ).getText();

        System.out.println("Expected Customer Number: " + expectedNumber);
        System.out.println("Actual Customer Number: " + actualNumber);

        logger.info("Validating Customer Number");
       // Assert.assertEquals(actualNumber, "Customer-00000000000");
        Assert.assertTrue(
                actualNumber.contains(expectedNumber),
                "Customer number not found. Expected: "
                + expectedNumber
                + " Actual: "
                + actualNumber
        );
        logger.info("Customer added successfully: " + actualNumber);

    }

}