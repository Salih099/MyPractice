package com.github.us;

import com.github.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US4 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void TC64_AC1(){
        // Expected Page Title: "All - Vehicle Contract - Entities - System - Car - Entities - System"

        driver.get("https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract");

        WebElement userName1 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName1.sendKeys("storemanager56");

        WebElement password1 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password1.sendKeys("UserUser123");

        WebElement login = driver.findElement(By.xpath("//button[@id='_submit']"));
        login.click();

        //WebElement actualTitlePage = driver.findElement(By.xpath("//html[@class='desktop-version']/head/title"));
        String expectedTitle ="All - Vehicle Contract - Entities - System - Car - Entities - System";
        String actualTitlePage = driver.getTitle();

        //System.out.println("actualTitlePage = " + actualTitlePage);
        //System.out.println("expectedTitle = " + expectedTitle);
        //Assert.assertEquals(actualTitlePage, expectedTitle);
        Assert.assertTrue(expectedTitle.contains(actualTitlePage));
        System.out.println("PASSED AC1");
    }

    @Test (priority = 2)
    public void TC64_AC2() {
        //WebElement alertMessage = driver.findElement(By.tagName("//div[.='You do not have permission to perform this action.']"));
        // user7 --- user12 | UserUser123
        // Drivers should NOT able to access the Vehicle contracts page, the app should display, Expected:
        // "You do not have permission to perform this action."
        driver.get("https://qa2.vytrack.com/");

        WebElement userName1 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName1.sendKeys("user10");

        WebElement password1 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password1.sendKeys("UserUser123");

        WebElement login = driver.findElement(By.xpath("//button[@id='_submit']"));
        login.click();

        WebElement fleetClick = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetClick.click();

        // (//div[@class='dropdown-menu-wrapper dropdown-menu-wrapper__placeholder'])[1]/div/ul/li[6]
        WebElement vehicleContract = driver.findElement(By.xpath("(//div[@class='dropdown-menu-wrapper dropdown-menu-wrapper__placeholder'])[1]/div/ul/li[6]"));
        vehicleContract.click();

        WebElement actualAlertMessage = driver.findElement(By.xpath("(//div[@class='alert alert-error fade in top-messages '])[2]//div"));

        String expectedAlertMessage = "You do not have permission to perform this action.";

        Assert.assertTrue( expectedAlertMessage.contains(actualAlertMessage.getText()));
        System.out.println("PASSED AC2");

    }
}
