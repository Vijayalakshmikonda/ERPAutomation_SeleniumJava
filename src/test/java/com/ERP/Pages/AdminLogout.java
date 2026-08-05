package com.ERP.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AdminLogout {

    WebDriver driver;
    WebDriverWait wait;


    // Locator
    By logoutButton = By.id("logout");


    // Constructor
    public AdminLogout(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    // Logout method
    public void ERPLogout() {

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));

        driver.findElement(logoutButton).click();

    }

}