package com.ERP.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.testng.Assert;

public class AdminLogin {

    // Declare WebDriver
    WebDriver driver;

    // Explicit wait
    WebDriverWait wait;


    // Locators (converted from Playwright)
    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.id("btnsubmit");


    // Constructor initialization
    public AdminLogin(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    // Method for URL launching
    public void ERPurl(String url) {

        driver.get(url);
        

    }


    // Method for Login
    public void ERPLogin(String user, String pass) {


        wait.until(ExpectedConditions.visibilityOfElementLocated(username))
                .clear();

        driver.findElement(username)
                .sendKeys(user);


        wait.until(ExpectedConditions.visibilityOfElementLocated(password))
                .clear();

        driver.findElement(password)
                .sendKeys(pass);


        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        System.out.println("After Login URL = " + driver.getCurrentUrl());


        // URL validation (Playwright expect equivalent)
        wait.until(ExpectedConditions.urlContains("dashboard.php"));

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard.php"),
                "Login failed - Dashboard page not displayed");

    }

}