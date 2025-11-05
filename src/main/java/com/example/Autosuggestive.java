package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Autosuggestive {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
            driver.manage().window().maximize();
            
            // Type in the input field
            WebElement autoSuggestInput = driver.findElement(By.id("autosuggest"));
            autoSuggestInput.sendKeys("ind");
            
            // Wait a bit for the dropdown to appear
            Thread.sleep(2000);
            
            // Try multiple selectors to find the dropdown options
            List<WebElement> options = null;
            
            // First attempt - original selector
            options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
            System.out.println("Attempt 1 - Options found: " + options.size());
            
            // If empty, try alternative selectors
            if (options.isEmpty()) {
                options = driver.findElements(By.cssSelector(".ui-menu-item a"));
                System.out.println("Attempt 2 - Options found: " + options.size());
            }
            
            if (options.isEmpty()) {
                options = driver.findElements(By.cssSelector("li.ui-menu-item a"));
                System.out.println("Attempt 3 - Options found: " + options.size());
            }
            
            if (options.isEmpty()) {
                options = driver.findElements(By.cssSelector("ul.ui-autocomplete li a"));
                System.out.println("Attempt 4 - Options found: " + options.size());
            }
            
            // Debug: Print page source if still no options found
            if (options.isEmpty()) {
                System.out.println("No options found. Checking page source...");
                String pageSource = driver.getPageSource();
                if (pageSource.contains("ui-menu-item")) {
                    System.out.println("Found ui-menu-item in page source");
                }
                if (pageSource.contains("ui-autocomplete")) {
                    System.out.println("Found ui-autocomplete in page source");
                }
                // Print a snippet around the autocomplete section
                int startIndex = pageSource.indexOf("autosuggest");
                if (startIndex != -1) {
                    int endIndex = Math.min(startIndex + 500, pageSource.length());
                    System.out.println("Page source around autosuggest:");
                    System.out.println(pageSource.substring(startIndex, endIndex));
                }
            }
            
            // Process options if found
            if (!options.isEmpty()) {
                System.out.println("Total options found: " + options.size());
                for (WebElement optionElement : options) {
                    String optionText = optionElement.getText();
                    System.out.println("Option: " + optionText);
                    if (optionText.equalsIgnoreCase("India")) {
                        optionElement.click();
                        System.out.println("Clicked on India");
                        break;
                    }
                }
            } else {
                System.out.println("No dropdown options found!");
            }
            
            Thread.sleep(2000);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
