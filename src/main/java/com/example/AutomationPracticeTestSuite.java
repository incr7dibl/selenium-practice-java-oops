package com.example;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Comprehensive Test Suite for AutomationPractice Page
 * URL: https://rahulshettyacademy.com/AutomationPractice/
 * 
 * This class demonstrates testing of various web elements:
 * 1. Radio Buttons
 * 2. Checkboxes  
 * 3. Dropdown (Static)
 * 4. Auto-suggest Dropdown
 * 5. Hide/Show Elements
 * 6. Alerts (Simple, Confirm, Prompt)
 * 7. Tables
 * 8. Mouse Hover
 * 9. iFrames
 * 10. Window Handling (New Tab/Window)
 * 11. Web Table Sorting
 */
public class AutomationPracticeTestSuite {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor js;
    
    public static void main(String[] args) {
        AutomationPracticeTestSuite testSuite = new AutomationPracticeTestSuite();
        testSuite.runAllTests();
    }
    
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        
        // Navigate to the practice page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("🌐 Navigated to AutomationPractice page");
        System.out.println("📄 Page Title: " + driver.getTitle());
    }
    
    public void runAllTests() {
        setUp();
        
        try {
            // Test all components
            testRadioButtons();
            testCheckboxes();
            testStaticDropdown();
            testAutoSuggestDropdown();
            testHideShowElements();
            testAlerts();
            testWebTable();
            testMouseHover();
            testIFrame();
            testWindowHandling();
            
            System.out.println("\n🎉 All tests completed successfully!");
            
        } catch (Exception e) {
            System.err.println("❌ Test failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            tearDown();
        }
    }
    
    /**
     * Test Radio Buttons
     * Learning: Radio buttons allow single selection from a group
     */
    public void testRadioButtons() {
        System.out.println("\n🔘 Testing Radio Buttons");
        
        try {
            // Find all radio buttons
            List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
            System.out.println("   Total radio buttons found: " + radioButtons.size());
            
            // Test each radio button
            for (int i = 0; i < radioButtons.size(); i++) {
                WebElement radio = radioButtons.get(i);
                String value = radio.getAttribute("value");
                
                // Click the radio button
                radio.click();
                Thread.sleep(500);
                
                // Verify it's selected
                Assert.assertTrue(radio.isSelected(), "Radio button " + value + " should be selected");
                System.out.println("   ✅ Radio button '" + value + "' selected successfully");
            }
            
        } catch (Exception e) {
            System.out.println("   ❌ Radio button test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test Checkboxes
     * Learning: Checkboxes allow multiple selections
     */
    public void testCheckboxes() {
        System.out.println("\n☑️  Testing Checkboxes");
        
        try {
            // Find all checkboxes
            List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
            System.out.println("   Total checkboxes found: " + checkboxes.size());
            
            // Test checking and unchecking each checkbox
            for (int i = 0; i < checkboxes.size(); i++) {
                WebElement checkbox = checkboxes.get(i);
                String id = checkbox.getAttribute("id");
                
                // Check the checkbox
                if (!checkbox.isSelected()) {
                    checkbox.click();
                    Assert.assertTrue(checkbox.isSelected(), "Checkbox should be checked");
                    System.out.println("   ✅ Checkbox '" + id + "' checked successfully");
                }
                
                Thread.sleep(300);
                
                // Uncheck the checkbox
                if (checkbox.isSelected()) {
                    checkbox.click();
                    Assert.assertFalse(checkbox.isSelected(), "Checkbox should be unchecked");
                    System.out.println("   ✅ Checkbox '" + id + "' unchecked successfully");
                }
            }
            
        } catch (Exception e) {
            System.out.println("   ❌ Checkbox test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test Static Dropdown
     * Learning: Static dropdowns have predefined options
     */
    public void testStaticDropdown() {
        System.out.println("\n📋 Testing Static Dropdown");
        
        try {
            // Find the dropdown element
            WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));
            Select dropdown = new Select(dropdownElement);
            
            // Get all options
            List<WebElement> options = dropdown.getOptions();
            System.out.println("   Total dropdown options: " + options.size());
            
            // Test selecting by index, value, and visible text
            dropdown.selectByIndex(1);
            System.out.println("   ✅ Selected by index: " + dropdown.getFirstSelectedOption().getText());
            
            dropdown.selectByValue("option2");
            System.out.println("   ✅ Selected by value: " + dropdown.getFirstSelectedOption().getText());
            
            dropdown.selectByVisibleText("Option3");
            System.out.println("   ✅ Selected by visible text: " + dropdown.getFirstSelectedOption().getText());
            
            // Print all options
            System.out.println("   Available options:");
            for (WebElement option : options) {
                System.out.println("     - " + option.getText());
            }
            
        } catch (Exception e) {
            System.out.println("   ❌ Static dropdown test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test Auto-Suggest Dropdown
     * Learning: Dynamic dropdowns load options based on user input
     */
    public void testAutoSuggestDropdown() {
        System.out.println("\n🔍 Testing Auto-Suggest Dropdown");
        
        try {
            // Find the auto-suggest input
            WebElement autoSuggestInput = driver.findElement(By.id("autocomplete"));
            autoSuggestInput.clear();
            autoSuggestInput.sendKeys("Ind");
            
            // Wait for suggestions to appear
            Thread.sleep(2000);
            
            // Find suggestion list
            List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
            System.out.println("   Auto-suggest options found: " + suggestions.size());
            
            // Print all suggestions
            for (WebElement suggestion : suggestions) {
                System.out.println("     - " + suggestion.getText());
            }
            
            // Select "India" if available
            for (WebElement suggestion : suggestions) {
                if (suggestion.getText().equals("India")) {
                    suggestion.click();
                    System.out.println("   ✅ Selected 'India' from auto-suggest");
                    break;
                }
            }
            
            // Verify selection
            String selectedValue = autoSuggestInput.getAttribute("value");
            System.out.println("   Selected value: " + selectedValue);
            
        } catch (Exception e) {
            System.out.println("   ❌ Auto-suggest test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test Hide/Show Elements
     * Learning: Elements can be dynamically hidden or shown
     */
    public void testHideShowElements() {
        System.out.println("\n👁️  Testing Hide/Show Elements");
        
        try {
            // Find the textbox and buttons
            WebElement textBox = driver.findElement(By.id("displayed-text"));
            WebElement hideButton = driver.findElement(By.id("hide-textbox"));
            WebElement showButton = driver.findElement(By.id("show-textbox"));
            
            // Verify element is initially visible
            Assert.assertTrue(textBox.isDisplayed(), "Text box should be visible initially");
            System.out.println("   ✅ Text box is initially visible");
            
            // Hide the element
            hideButton.click();
            Thread.sleep(1000);
            Assert.assertFalse(textBox.isDisplayed(), "Text box should be hidden");
            System.out.println("   ✅ Text box hidden successfully");
            
            // Show the element
            showButton.click();
            Thread.sleep(1000);
            Assert.assertTrue(textBox.isDisplayed(), "Text box should be visible again");
            System.out.println("   ✅ Text box shown successfully");
            
        } catch (Exception e) {
            System.out.println("   ❌ Hide/Show test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test JavaScript Alerts
     * Learning: Different types of alerts - simple, confirm, prompt
     */
    public void testAlerts() {
        System.out.println("\n🚨 Testing JavaScript Alerts");
        
        try {
            // Test Simple Alert
            WebElement alertButton = driver.findElement(By.id("alertbtn"));
            alertButton.click();
            Thread.sleep(1000);
            
            String alertText = driver.switchTo().alert().getText();
            System.out.println("   Simple Alert text: " + alertText);
            driver.switchTo().alert().accept();
            System.out.println("   ✅ Simple alert handled");
            
            // Test Confirm Alert
            WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
            confirmButton.click();
            Thread.sleep(1000);
            
            String confirmText = driver.switchTo().alert().getText();
            System.out.println("   Confirm Alert text: " + confirmText);
            driver.switchTo().alert().dismiss(); // Click Cancel
            System.out.println("   ✅ Confirm alert dismissed");
            
        } catch (Exception e) {
            System.out.println("   ❌ Alert test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test Web Table
     * Learning: How to interact with HTML tables
     */
    public void testWebTable() {
        System.out.println("\n📊 Testing Web Table");
        
        try {
            // Find the table
            WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));
            
            // Get all rows
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            System.out.println("   Total rows in table: " + rows.size());
            
            // Get headers
            List<WebElement> headers = rows.get(0).findElements(By.tagName("th"));
            System.out.print("   Table Headers: ");
            for (WebElement header : headers) {
                System.out.print(header.getText() + " | ");
            }
            System.out.println();
            
            // Print table data
            System.out.println("   Table Data:");
            for (int i = 1; i < rows.size(); i++) {
                List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
                System.out.print("   Row " + i + ": ");
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + " | ");
                }
                System.out.println();
            }
            
            // Search for specific data (e.g., find price of WebServices course)
            for (int i = 1; i < rows.size(); i++) {
                List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
                if (cells.size() > 0 && cells.get(0).getText().contains("WebServices")) {
                    System.out.println("   ✅ Found WebServices course, Price: " + cells.get(1).getText());
                    break;
                }
            }
            
        } catch (Exception e) {
            System.out.println("   ❌ Web table test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test Mouse Hover
     * Learning: How to perform mouse hover actions
     */
    public void testMouseHover() {
        System.out.println("\n🖱️  Testing Mouse Hover");
        
        try {
            // Find the hover button
            WebElement hoverButton = driver.findElement(By.id("mousehover"));
            
            // Scroll to element if needed
            js.executeScript("arguments[0].scrollIntoView(true);", hoverButton);
            Thread.sleep(1000);
            
            // Perform hover action
            actions.moveToElement(hoverButton).perform();
            Thread.sleep(1000);
            
            // Find and click on hover options
            WebElement topLink = driver.findElement(By.linkText("Top"));
            WebElement reloadLink = driver.findElement(By.linkText("Reload"));
            
            System.out.println("   ✅ Mouse hover performed successfully");
            System.out.println("   Available hover options: Top, Reload");
            
            // Click on Top link
            topLink.click();
            Thread.sleep(1000);
            System.out.println("   ✅ Clicked 'Top' link from hover menu");
            
        } catch (Exception e) {
            System.out.println("   ❌ Mouse hover test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test iFrame
     * Learning: How to switch between frames
     */
    public void testIFrame() {
        System.out.println("\n🖼️  Testing iFrame");
        
        try {
            // Scroll to iframe
            WebElement iframe = driver.findElement(By.id("courses-iframe"));
            js.executeScript("arguments[0].scrollIntoView(true);", iframe);
            Thread.sleep(1000);
            
            // Switch to iframe
            driver.switchTo().frame(iframe);
            System.out.println("   ✅ Switched to iframe");
            
            // Interact with elements inside iframe
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("   Links found in iframe: " + links.size());
            
            // Try to find and click a course link
            try {
                WebElement courseLink = driver.findElement(By.linkText("Courses"));
                courseLink.click();
                System.out.println("   ✅ Clicked 'Courses' link in iframe");
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("   ⚠️  'Courses' link not found in iframe");
            }
            
            // Switch back to main frame
            driver.switchTo().defaultContent();
            System.out.println("   ✅ Switched back to main frame");
            
        } catch (Exception e) {
            System.out.println("   ❌ iFrame test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test Window Handling
     * Learning: How to handle multiple browser windows/tabs
     */
    public void testWindowHandling() {
        System.out.println("\n🪟 Testing Window Handling");
        
        try {
            // Store the original window handle
            String originalWindow = driver.getWindowHandle();
            System.out.println("   Original window handle: " + originalWindow);
            
            // Find and click the "Open Tab" button
            WebElement openTabButton = driver.findElement(By.id("opentab"));
            openTabButton.click();
            Thread.sleep(2000);
            
            // Get all window handles
            Set<String> allWindows = driver.getWindowHandles();
            System.out.println("   Total windows open: " + allWindows.size());
            
            // Switch to the new window
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    System.out.println("   ✅ Switched to new tab");
                    System.out.println("   New tab title: " + driver.getTitle());
                    System.out.println("   New tab URL: " + driver.getCurrentUrl());
                    
                    // Close the new tab
                    driver.close();
                    System.out.println("   ✅ Closed new tab");
                    break;
                }
            }
            
            // Switch back to original window
            driver.switchTo().window(originalWindow);
            System.out.println("   ✅ Switched back to original window");
            
            // Test "Open Window" button
            WebElement openWindowButton = driver.findElement(By.id("openwindow"));
            openWindowButton.click();
            Thread.sleep(2000);
            
            // Handle the new window
            allWindows = driver.getWindowHandles();
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    System.out.println("   ✅ Switched to new window");
                    System.out.println("   New window title: " + driver.getTitle());
                    driver.close();
                    System.out.println("   ✅ Closed new window");
                    break;
                }
            }
            
            // Switch back to original window
            driver.switchTo().window(originalWindow);
            
        } catch (Exception e) {
            System.out.println("   ❌ Window handling test failed: " + e.getMessage());
        }
    }
    
    /**
     * Get Page Source and Save to File
     * Learning: How to capture page source for debugging
     */
    public void getPageSource() {
        System.out.println("\n📄 Getting Page Source");
        
        try {
            String pageSource = driver.getPageSource();
            System.out.println("   Page source length: " + pageSource.length() + " characters");
            
            // You can save to file if needed
            // Files.write(Paths.get("page_source.html"), pageSource.getBytes());
            // System.out.println("   ✅ Page source saved to file");
            
        } catch (Exception e) {
            System.out.println("   ❌ Failed to get page source: " + e.getMessage());
        }
    }
    
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("\n🔚 Browser closed");
        }
    }
}