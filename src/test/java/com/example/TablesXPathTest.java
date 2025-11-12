package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TablesXPathTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@name='courses']")));
    }

    @Test
    public void scopedVsDocumentScopeRowCounts() {
        WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));

        // document-scope descendant (global) — will search whole document
        List<WebElement> docScopeRows = driver.findElements(By.xpath("//table[@name='courses']//tr"));

        // element-scoped descendant — scoped to the table element
        List<WebElement> scopedRows = table.findElements(By.xpath(".//tr"));

        System.out.println("docScopeRows=" + docScopeRows.size() + " scopedRows=" + scopedRows.size());

        // Basic assertions that illustrate correct behavior without assuming fixed counts
        Assert.assertTrue(scopedRows.size() > 0, "Scoped rows should be > 0");
        Assert.assertTrue(docScopeRows.size() >= scopedRows.size(), "Document-scope should be >= scoped-scope");
    }

    @Test(dependsOnMethods = "scopedVsDocumentScopeRowCounts")
    public void findPriceForCourse() {
        WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));
        String courseName = "Selenium Webdriver"; // adjust if page changes

        // XPath technique: find tr that contains a td matching the courseName, then get the 2nd td (price)
        List<WebElement> priceEls = table.findElements(By.xpath(
                ".//tr[.//td[contains(normalize-space(.), '" + courseName + "')]]/td[2]"
        ));

        if (priceEls.isEmpty()) {
            // If not found, fail with helpful message
            Assert.fail("Price for course '" + courseName + "' not found — page structure may have changed.");
        }

        String price = priceEls.get(0).getText().trim();
        System.out.println("Price for '" + courseName + "' = " + price);
        Assert.assertFalse(price.isEmpty(), "Price should not be empty");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
