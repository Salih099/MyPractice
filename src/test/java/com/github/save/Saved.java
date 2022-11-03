package com.github.save;

import com.github.utilities.ConfigurationReader;
import com.github.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Saved {

    /** How to use DataProvider way
     * @DataProvider(name = "data-provider")
     *     public Object[][] dataProviderMethod() {
     *         return new Object[][]{
     *                 {"driver_username", "driver_password", new ArrayList<>(Arrays.asList(
     *                         "Fleet", "Customers", "Activities", "System"))},
     *                 {"sales_manager_username", "sales_manager_password", new ArrayList<>(Arrays.asList(
     *                         "Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"))},
     *                 {"store_manager_username", "store_manager_password", new ArrayList<>(Arrays.asList(
     *                         "Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"))}
     *         };
     *     }
     *
     *     @Test(dataProvider = "data-provider")
     *     public void verifying_modules(String username, String password, ArrayList<String> expectedModuleTexts)  {
     *         Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
     *         VyTrackUtils.login(username, password);
     *         List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
     *         List<String> actualModuleTexts = new ArrayList<>();
     *
     *         for (WebElement moduleElement : moduleElements) {
     *             String moduleElementText = moduleElement.getText();
     *             actualModuleTexts.add(moduleElementText);
     *         }
     *         assertEquals(actualModuleTexts, expectedModuleTexts);
     *         Driver.closeDriver();
     *     }
     */

    /** How to use DataProvider way
     * @BeforeMethod
     *     public void setUp() {
     *         WebDriverManager.chromedriver().setup();
     *         driver = new ChromeDriver();
     *         driver.manage().window().maximize();
     *     }
     *
     *     @AfterMethod
     *     public void tearDown() {
     *         driver.quit();
     *     }
     *
     *     @Test
     *     public void googleTest1()   {
     *         driver.get("https://google.com");
     *         driver.findElement(By.name("q")).sendKeys("test" + Keys.ENTER);
     *         assertTrue(driver.getTitle().contains("test"));
     *     }
     *     @Test
     *     public void googleTest2()   {
     *         driver.get("https://google.com");
     *         driver.findElement(By.name("q")).sendKeys("Cydeo" + Keys.ENTER);
     *         assertTrue(driver.getTitle().contains("Cydeo"));
     *     }
     *     @Test
     *     public void googleTest3()   {
     *         driver.get("https://google.com");
     *         driver.findElement(By.name("q")).sendKeys("Canada" + Keys.ENTER);
     *         assertTrue(driver.getTitle().contains("Canada"));
     *     }
     *     @Test
     *     public void googleTest4()   {
     *         driver.get("https://google.com");
     *         driver.findElement(By.name("q")).sendKeys("USA" + Keys.ENTER);
     *         assertTrue(driver.getTitle().contains("USA"));
     *     }
     *
     *     @DataProvider(name = "searchData")
     *     public Object[][] GoogleSearch() {
     *         Object[][] data = {
     *                 {"test", "test - Google"},
     *                 {"Cydeo", "Cydeo - Google"},
     *                 {"Canada", "Canada - Google"},
     *                 {"USA", "USA - Google"}
     *         };
     *         return data;
     *     }
     *
     *     @Test(dataProvider = "searchData")
     *     public void test(String searchWord, String title)  {
     *         driver.get("https://google.com");
     *         driver.findElement(By.name("q")).sendKeys(searchWord + Keys.ENTER);
     *         assertTrue(driver.getTitle().contains(title));
     *     }
     */

}
