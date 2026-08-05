# ERP Automation Selenium Java Framework

## Repository 
 
GitHub: https://github.com/Vijayalakshmikonda/ERPAutomation_SeleniumJava 
 

## Project Overview
 
This project is an end-to-end Selenium Automation Framework developed using Java, Selenium   WebDriver, TestNG, and Maven.

The framework follows the Page Object Model (POM) design pattern and supports data-driven testing using Excel files. 

The automation covers ERP application modules like Login, Supplier Management, and Customer Management.

# Modules Covered

✔ Login Test

✔ Supplier Creation Test

✔ Customer Creation Test
 
# Technologies Used

- Java 21

- Selenium WebDriver 4.29.0

- TestNG 7.11.0

- Maven

- Page Object Model (POM)

- Apache POI (Excel Data Handling)

- Extent Reports

- Log4j2 Logging

- Git & GitHub

- Jenkins (CI/CD Integration)

# Framework Features

✔ Page Object Model Framework

✔ TestNG Test Execution

✔ Maven Build Management

✔ Data Driven Testing using Excel

✔ Config File Management

✔ Extent HTML Reports

✔ Screenshot Capture on Test Failure

✔ Log4j2 Application Logging

✔ Reusable Page Classes

✔ Cross Browser Execution Support


# Project Structure

```text
ERPAutomation_SeleniumJava
│
├── src
│   ├── main
│   │   └── java
│   │
│   └── test
│       ├── java
│       │
│       └── com
│           └── ERP
│               ├── Base
│               │   └── BaseTest.java
│               │
│               ├── Pages
│               │   ├── AdminLogin.java
│               │   ├── AddCustomers.java
│               │   ├── AddSuppliers.java
│               │   └── AdminLogout.java
│               │
│               ├── Tests
│               │   ├── LoginTest.java
│               │   ├── SupplierTest.java
│               │   └── CustomerTest.java
│               │
│               ├── Listeners
│               │   └── TestListener.java
│               │
│               └── Utils
│                   ├── ConfigReader.java
│                   ├── ExcelUtility.java
│                   ├── ExcelDataProvider.java
│                   ├── ExtentManager.java
│                   └── ScreenshotUtility.java
│
├── src
│   └── test
│       └── resources
│           ├── TestData
│           │   └── ERPDataExcel.xlsx
│           │
│           ├── config.properties
│           └── Log4j2.properties
│
├── pom.xml
├── testng.xml
├── README.md
└── .gitignore
```

# Test Execution Result

Latest Execution:

✔ Total Tests Run: 7

✔ Passed: 7

✔ Failed: 0

✔ Skipped: 0
 
# How to Run Tests 

## Prerequisites 

Install:
 
- Java JDK 21 
- Maven 
- Eclipse / IntelliJ IDEA 
- Chrome Browser

# How to Run Tests

## Prerequisites

Install:

- Java JDK 21
- Maven
- Eclipse / IntelliJ IDEA
- Chrome Browser


## Run Using Maven

Execute the following command from project root:

```bash
mvn clean test
```

## Run Using TestNG

Right click on:

```text
testng.xml
```

Select:

```text
Run As → TestNG Suite
```


# Author

Naga Vijayalakshmi Konda

QA Automation Test Engineer

Skills:

Java | Selenium | TestNG | Maven | Playwright | Jenkins