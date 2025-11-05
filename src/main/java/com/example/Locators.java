package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        // WebElement staticDropdown =
        // driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        // Select dropdownSelect = new Select(staticDropdown);
        // dropdownSelect.selectByIndex(1);
        // dropdownSelect.selectByVisibleText("AED");
        // System.out.println(dropdownSelect.getFirstSelectedOption().getText());

        // driver.findElement(By.id("divpaxinfo")).click();
        // Thread.sleep(2000);
        // for (int i = 1; i < 5; i++) {
        // driver.findElement(By.id("hrefIncAdt")).click();
        // }
        // driver.findElement(By.id("btnclosepaxoption")).click();

        // System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        // Thread.sleep(2000);

        // dynamic dropdown
        WebElement fromCity = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        fromCity.click();
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        // driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='IXB']")).click();
        //System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getText());
         Thread.sleep(2000);
        driver.quit();
    }

}
