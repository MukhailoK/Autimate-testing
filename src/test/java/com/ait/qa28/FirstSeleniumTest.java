package com.ait.qa28;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver chromeDriver;

    @BeforeMethod
    public void setUp() {
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com");

    }

    @Test
   public void openGoogleTest(){
        System.out.println("Site opened!!");

    }

    @AfterMethod(enabled = false)
    public void tearDown() {
//        chromeDriver.quit();
        chromeDriver.close();
    }
}
