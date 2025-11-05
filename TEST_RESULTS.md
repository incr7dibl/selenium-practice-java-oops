# AutomationPractice Test Suite Documentation

## Overview
This comprehensive test suite demonstrates Selenium WebDriver automation testing on the **AutomationPractice** page at: https://rahulshettyacademy.com/AutomationPractice/

## Test Results Summary ✅

### 🔘 Radio Buttons Test
- **Purpose**: Learn how to interact with radio button elements
- **Elements Tested**: 3 radio buttons (radio1, radio2, radio3)
- **Key Learning**: Radio buttons allow single selection from a group
- **Selenium Methods**: `findElements()`, `click()`, `isSelected()`

### ☑️ Checkboxes Test
- **Purpose**: Learn checkbox interaction and validation
- **Elements Tested**: 3 checkboxes (checkBoxOption1, checkBoxOption2, checkBoxOption3)
- **Key Learning**: Checkboxes allow multiple selections and can be checked/unchecked
- **Selenium Methods**: `isSelected()`, `click()`, TestNG assertions

### 📋 Static Dropdown Test
- **Purpose**: Learn static dropdown handling
- **Elements Tested**: Dropdown with 4 options (Select, Option1, Option2, Option3)
- **Key Learning**: Static dropdowns have predefined options
- **Selenium Methods**: `Select` class, `selectByIndex()`, `selectByValue()`, `selectByVisibleText()`

### 🔍 Auto-Suggest Dropdown Test
- **Purpose**: Learn dynamic dropdown handling
- **Elements Tested**: Auto-suggest input field with country suggestions
- **Key Learning**: Dynamic dropdowns load options based on user input
- **Selenium Methods**: `sendKeys()`, dynamic element waiting, list iteration

### 👁️ Hide/Show Elements Test
- **Purpose**: Learn to handle dynamic element visibility
- **Elements Tested**: Text box with hide/show buttons
- **Key Learning**: Elements can be dynamically hidden or shown
- **Selenium Methods**: `isDisplayed()`, element visibility validation

### 🚨 JavaScript Alerts Test
- **Purpose**: Learn alert handling techniques
- **Alerts Tested**: Simple alert and Confirm alert
- **Key Learning**: Different types of alerts require different handling
- **Selenium Methods**: `switchTo().alert()`, `getText()`, `accept()`, `dismiss()`

### 📊 Web Table Test
- **Purpose**: Learn table data extraction and validation
- **Elements Tested**: Course information table with 11 rows
- **Key Learning**: How to navigate and extract data from HTML tables
- **Selenium Methods**: Table traversal, row/column iteration, text extraction

### 🖱️ Mouse Hover Test
- **Purpose**: Learn mouse interaction techniques
- **Elements Tested**: Hover button with dropdown options
- **Key Learning**: How to perform mouse hover actions
- **Selenium Methods**: `Actions` class, `moveToElement()`, `perform()`

### 🖼️ iFrame Test
- **Purpose**: Learn frame switching techniques
- **Elements Tested**: Embedded iframe with course links
- **Key Learning**: How to switch between frames and main content
- **Selenium Methods**: `switchTo().frame()`, `switchTo().defaultContent()`

### 🪟 Window Handling Test
- **Purpose**: Learn multiple window/tab management
- **Elements Tested**: "Open Tab" and "Open Window" buttons
- **Key Learning**: How to handle multiple browser windows/tabs
- **Selenium Methods**: `getWindowHandles()`, `switchTo().window()`, window management

## 📈 Test Execution Results

### ✅ All Tests Passed Successfully!
- **Total Execution Time**: 38.526 seconds
- **Radio Buttons**: 3/3 passed
- **Checkboxes**: 6/6 operations passed (3 check + 3 uncheck)
- **Static Dropdown**: 3/3 selection methods tested
- **Auto-Suggest**: Successfully selected "India" from 3 suggestions
- **Hide/Show**: All visibility operations passed
- **JavaScript Alerts**: Both alert types handled successfully
- **Web Table**: Successfully parsed 10 course records
- **Mouse Hover**: Hover and click operations successful
- **iFrame**: Frame switching and navigation successful
- **Window Handling**: Multiple window operations successful

## 🛠️ Technical Implementation Details

### Dependencies Used
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.38.0</version>
</dependency>
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.11.0</version>
</dependency>
```

### Key Selenium Classes Used
- **WebDriver**: Browser automation interface
- **ChromeDriver**: Chrome browser specific implementation
- **WebDriverWait**: Explicit wait management
- **Actions**: Complex user interactions (mouse, keyboard)
- **JavascriptExecutor**: JavaScript execution in browser
- **Select**: Dropdown handling utility
- **Assert**: TestNG assertion utilities

### Browser Configuration
- **Browser**: Chrome (latest version)
- **Window State**: Maximized
- **Implicit Wait**: 10 seconds
- **Explicit Wait**: 15 seconds
- **Java Version**: 21 (LTS)

## 💡 Learning Outcomes

This test suite demonstrates essential Selenium automation concepts:

1. **Element Identification**: Using various locator strategies (ID, XPath, CSS selectors)
2. **User Interactions**: Clicks, text input, hover actions, selections
3. **Wait Strategies**: Implicit and explicit waits for element availability
4. **Assertions**: Validating expected vs actual results
5. **Exception Handling**: Graceful error management
6. **Browser Management**: Window/tab handling, frame switching
7. **Dynamic Content**: Handling elements that change visibility or content
8. **Complex Interactions**: Multi-step workflows and user scenarios

## 🚀 How to Run

### Prerequisites
- Java 21 (LTS) installed
- Maven 3.x installed
- Chrome browser installed
- All dependencies in pom.xml

### Execution Commands
```bash
# Compile and run using Maven
mvn compile exec:java

# Or run specific class
mvn compile exec:java -Dexec.mainClass="com.example.AutomationPracticeTestSuite"
```

## 📝 Test Code Structure

The test suite follows a clean, modular structure:
- **setUp()**: Browser initialization and configuration
- **runAllTests()**: Main test orchestrator
- **Individual test methods**: Each testing a specific component
- **tearDown()**: Cleanup and browser closure

Each test method includes:
- Clear console output with emojis for readability
- Detailed error handling and reporting
- Comprehensive assertions and validations
- Educational comments explaining techniques

This comprehensive test suite serves as an excellent reference for Selenium WebDriver automation testing patterns and best practices! 🎯