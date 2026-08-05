package com.ERP.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ERP.Base.BaseTest;


public class LoginTest extends BaseTest {


    @Test
    public void adminLoginTest() {


        String currentURL = driver.getCurrentUrl();

        System.out.println("After Login URL = " + currentURL);


        Assert.assertTrue(
                currentURL.contains("dashboard.php"),
                "Login failed - Dashboard page not displayed"
        );

    }

}