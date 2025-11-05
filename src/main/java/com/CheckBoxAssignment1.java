package com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class CheckBoxAssignment1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);
        WebElement firstChecElement = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
        Thread.sleep(2000);
        firstChecElement.click();
        Assert.assertTrue(firstChecElement.isSelected());
        firstChecElement.click();
        Assert.assertFalse(firstChecElement.isSelected());
        Thread.sleep(2000);

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        System.out.println("Total checkboxes: " + checkboxes.size());
        driver.quit();
    }
}
