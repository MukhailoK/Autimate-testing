package com.ait.qa28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW3 {
    private static final String SEPARATOR = "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().
                window().
                maximize();
        driver.manage().
                timeouts().
                implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void findElementByCssTest() {
        WebElement element = driver.findElement(By.cssSelector(".count"));
        System.out.println(element.isEnabled());
        System.out.println(SEPARATOR);

        element = driver.findElement(By.cssSelector(".search-box"));
        System.out.println(element.isDisplayed());
        System.out.println(SEPARATOR);

        element = driver.findElement(By.cssSelector("#flyout-cart"));
        System.out.println(element.isEnabled());
        System.out.println(SEPARATOR);

        element = driver.findElement(By.cssSelector(".header-selectors-wrapper"));
        System.out.println(element.isEnabled());
        System.out.println(SEPARATOR);

        element = driver.findElement(By.cssSelector(".header-menu"));
        System.out.println(element.getText());
        System.out.println(SEPARATOR);


        element = driver.findElement(By.cssSelector("h2"));
        System.out.println(element.getText());
        System.out.println(SEPARATOR);

        element = driver.findElement(By.cssSelector(".prices"));
        System.out.println(element.getText());
        System.out.println(SEPARATOR);

        element = driver.findElement(By.cssSelector(".item-box"));
        System.out.println(element.getText());
        System.out.println(SEPARATOR);

        element = driver.findElement(By.cssSelector("#ui-id-1"));
        System.out.println(element.isEnabled());
        System.out.println(SEPARATOR);

        element = driver.findElement(By.cssSelector(".header-logo"));
        System.out.println(element.isDisplayed());
        System.out.println(SEPARATOR);
    }

    @Test
    public void findElementByXpath() {
        driver.findElement(By.xpath("//div"));

        driver.findElement(By.xpath("//div[@id='dialog-notifications-success']"));

        driver.findElement(By.xpath("//div[@id='bar-notification']"));

        driver.findElement(By.xpath("//div[@id='newsletter-subscribe-block']"));

        driver.findElement(By.xpath("//input[@id='pollanswers-1']"));

        driver.findElement(By.xpath("//label[contains(.,'Excellent')]"));

        driver.findElement(By.xpath("//input[@id='pollanswers-3']"));

        driver.findElement(By.xpath("//a[contains(.,'Prev')]"));

        driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));

        driver.findElement(By.xpath(
                "//div[contains(text(),'$25 Gift Card." +
                        " Gift Cards must be redeemed through')]"));
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
