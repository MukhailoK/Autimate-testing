package com.ait.qa28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTest {
    private static final String SEPARATOR = "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app/login");
        driver.manage().
                window().
                maximize();
        driver.manage().
                timeouts().
                implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTegTest() {
        WebElement element = driver.findElement(By.tagName("h1"));
        if (element.isDisplayed()) {
            System.out.println(element.getText());
        }
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
        elements.stream().map(WebElement::getText).forEach(System.out::println);
    }

    @Test
    public void findElementTest() {
        WebElement element = driver.findElement(By.id("root"));
        System.out.println(element.getText());
        System.out.println(SEPARATOR);

        element = driver.findElement(By.className("login_login__3EHKB"));
        System.out.println(element.getText());
        System.out.println(SEPARATOR);

        element = driver.findElement(By.name("email"));
        System.out.println(element.getAttribute("name"));
        System.out.println(SEPARATOR);

        driver.findElement(By.linkText("LOGIN"));

        driver.findElement(By.partialLinkText("LOG"));


    }

    @Test
    public void findElementByCssTest() {
        //by tag -> tag
        WebElement element = driver.findElement(By.cssSelector("h1"));
        System.out.println(element.getText());

        //by id -> #id
        element = driver.findElement(By.cssSelector("#root"));
        System.out.println(element.getText());
        System.out.println(SEPARATOR);

        //by class -> .className
        element = driver.findElement(By.cssSelector(".login_login__3EHKB"));
        System.out.println(element.getText());
        System.out.println(SEPARATOR);

        //[attribute='value']
        element = driver.findElement(By.name("[name='email']"));
        System.out.println(element.getAttribute("name"));
        System.out.println(SEPARATOR);

        //[placeholder*='ssw'] * it mean that some contains

        driver.findElement(By.cssSelector("[placeholder*='ssw']"));

        // start with -> ^
        driver.findElement(By.cssSelector("[placeholder^='ssw']"));

        //end to -> $
        driver.findElement(By.cssSelector("[placeholder$='ssw']"));

        driver.findElement(By.partialLinkText("LOG"));
        driver.findElement(By.linkText("LOGIN"));
    }

    @Test
    public void findElementByXpath() {
        //xpath -> //*[@attribute='value']
        driver.findElement(By.xpath("//h1"));

        //id -> //*[@id='value']
        driver.findElement(By.xpath("//div[@id='root']"));

        //
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
