package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class CheckboxFixed {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
            
            // Wait for page to load
            Thread.sleep(3000);
            
            // Method 1: Try clicking the label (most common solution for custom checkboxes)
            boolean clicked = false;
            try {
                WebElement label = driver.findElement(By.xpath("//label[contains(@for,'SeniorCitizen')]"));
                System.out.println("Label found - Displayed: " + label.isDisplayed());
                if (label.isDisplayed()) {
                    label.click();
                    System.out.println("✅ Successfully clicked label");
                    clicked = true;
                }
            } catch (Exception e) {
                System.out.println("❌ Label approach failed: " + e.getMessage());
            }
            
            // Method 2: JavaScript click on checkbox (if label didn't work)
            if (!clicked) {
                try {
                    WebElement checkbox = driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizen')]"));
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    
                    // Check current state
                    boolean isCheckedBefore = (Boolean) js.executeScript("return arguments[0].checked;", checkbox);
                    System.out.println("Checkbox state before: " + isCheckedBefore);
                    
                    // Force click using JavaScript
                    js.executeScript("arguments[0].click();", checkbox);
                    
                    // Check state after
                    Thread.sleep(500);
                    boolean isCheckedAfter = (Boolean) js.executeScript("return arguments[0].checked;", checkbox);
                    System.out.println("Checkbox state after: " + isCheckedAfter);
                    
                    if (isCheckedBefore != isCheckedAfter) {
                        System.out.println("✅ Successfully toggled checkbox using JavaScript");
                        clicked = true;
                    } else {
                        System.out.println("❌ JavaScript click didn't change checkbox state");
                    }
                } catch (Exception e) {
                    System.out.println("❌ JavaScript approach failed: " + e.getMessage());
                }
            }
            
            // Method 3: Try alternative selectors if still not clicked
            if (!clicked) {
                String[] alternativeSelectors = {
                    "//input[@type='checkbox' and contains(@id,'SeniorCitizen')]",
                    "//*[contains(@class,'senior') or contains(@class,'citizen')]",
                    "//span[contains(text(),'Senior Citizen')]/preceding-sibling::input",
                    "//div[contains(@class,'checkbox')]//input[contains(@id,'SeniorCitizen')]"
                };
                
                for (String selector : alternativeSelectors) {
                    try {
                        WebElement element = driver.findElement(By.xpath(selector));
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("arguments[0].click();", element);
                        System.out.println("✅ Successfully clicked using selector: " + selector);
                        clicked = true;
                        break;
                    } catch (Exception e) {
                        System.out.println("❌ Selector failed: " + selector);
                    }
                }
            }
            
            if (!clicked) {
                System.out.println("❌ All methods failed. The element might not be interactable.");
                
                // Debug: Print page source around checkbox
                String pageSource = driver.getPageSource();
                int index = pageSource.toLowerCase().indexOf("senior");
                if (index != -1) {
                    int start = Math.max(0, index - 200);
                    int end = Math.min(pageSource.length(), index + 200);
                    System.out.println("Page source around 'senior':");
                    System.out.println(pageSource.substring(start, end));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}