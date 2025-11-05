# 🎯 Selenium Practice & Java OOPs Learning Repository

A comprehensive learning repository containing **Selenium WebDriver automation tests** and **Java Object-Oriented Programming concepts** with practical examples and interview preparation materials.

## 📋 Repository Contents

### 🔧 **Selenium WebDriver Automation**
- **Comprehensive Test Suite** for AutomationPractice page
- **Real-world examples** of web element interactions
- **Best practices** for Selenium automation
- **Troubleshooting guides** for common issues

### ☕ **Java OOPs Concepts & Interview Prep**
- **Complete OOP implementation** (Encapsulation, Inheritance, Polymorphism, Abstraction)
- **Exception handling** mastery (try-catch-finally scenarios)
- **Tricky interview questions** with detailed explanations
- **Advanced Java topics** (Collections, Strings, Static concepts)

## 🚀 Quick Start

### Prerequisites
- **Java 21 LTS** installed
- **Maven 3.x** installed
- **Chrome browser** for Selenium tests
- **Git** for version control

### Setup & Execution

```bash
# Clone the repository
git clone <your-repo-url>
cd seleniumpractise

# Compile the project
mvn compile

# Run Selenium automation tests
mvn exec:java -Dexec.mainClass="com.example.AutomationPracticeTestSuite"

# Run Java OOPs demonstration
mvn exec:java -Dexec.mainClass="com.example.Oops"
```

## 📁 Project Structure

```
seleniumpractise/
├── src/main/java/com/example/
│   ├── AutomationPracticeTestSuite.java    # Comprehensive Selenium tests
│   ├── Oops.java                           # Complete OOPs concepts demo
│   ├── CheckboxFixed.java                  # Checkbox automation solutions
│   ├── Autosuggestive.java                 # Dropdown handling examples
│   └── Main.java                           # Basic Selenium setup
├── docs/
│   ├── JAVA_OOPS_GUIDE.md                  # Complete Java OOPs guide
│   └── TEST_RESULTS.md                     # Selenium test documentation
├── pom.xml                                 # Maven configuration
├── .gitignore                              # Git ignore rules
└── README.md                               # This file
```

## 🎯 **Selenium Test Suite Features**

### ✅ **Web Elements Covered**
- **🔘 Radio Buttons** - Single selection validation
- **☑️ Checkboxes** - Multiple selection handling
- **📋 Static Dropdowns** - Select class usage
- **🔍 Auto-suggest Dropdowns** - Dynamic content handling
- **👁️ Hide/Show Elements** - Visibility state management
- **🚨 JavaScript Alerts** - Alert, Confirm, Prompt handling
- **📊 Web Tables** - Data extraction and validation
- **🖱️ Mouse Hover** - Advanced user interactions
- **🖼️ iFrames** - Frame switching techniques
- **🪟 Window Handling** - Multiple tabs/windows

### 🎪 **Demo Page**
Tests are designed for: **https://rahulshettyacademy.com/AutomationPractice/**

### 📊 **Test Results**
```
✅ Radio Buttons: 3/3 passed
✅ Checkboxes: 6/6 operations successful  
✅ Dropdowns: Both static and dynamic working
✅ Alerts: All alert types handled correctly
✅ Tables: Successfully parsed all data
✅ Advanced Features: Hover, frames, windows working
```

## ☕ **Java OOPs Concepts**

### 🏗️ **Core OOP Principles**

#### **1. 🔒 Encapsulation**
- **BankAccount class** with private fields and public methods
- **Data validation** and security implementation
- **Getter/Setter** best practices

#### **2. 🌳 Inheritance**
- **Animal hierarchy** (Dog, Cat extending Animal)
- **Method overriding** examples
- **Super keyword** usage
- **Polymorphic behavior** demonstration

#### **3. 🎭 Polymorphism**
- **Method overloading** (compile-time)
- **Method overriding** (runtime) 
- **Dynamic method dispatch**
- **Interface implementation**

#### **4. 🎨 Abstraction**
- **Abstract classes** vs **Interfaces**
- **Real-world implementations** (Vehicle hierarchy)
- **When to use which** approach

### ⚠️ **Exception Handling Mastery**

#### **🔥 Tricky Scenarios Covered**
```java
// 1. Finally vs Return
try { return 1; } 
finally { return 2; }  // Returns 2!

// 2. Exception Suppression
try { throw new Exception("First"); }
finally { return "Done"; }  // Exception suppressed!

// 3. Multiple Exceptions  
try { throw new Exception("First"); }
finally { throw new Exception("Second"); }  // First lost!
```

#### **📚 Exception Types Demonstrated**
- **ArithmeticException** - Division by zero
- **NullPointerException** - Null reference access
- **ArrayIndexOutOfBoundsException** - Array bounds
- **Custom Exceptions** - User-defined exceptions
- **Try-with-resources** - Automatic resource management

### 🧩 **Interview Question Bank**

#### **🔥 Most Asked Questions**
1. **String Immutability** - String pool vs heap behavior
2. **Static vs Instance** - Method hiding vs overriding  
3. **Autoboxing Tricks** - Integer caching (-128 to 127)
4. **Constructor Chaining** - Super() call behavior
5. **Collection Performance** - ArrayList vs LinkedList

#### **💡 Tricky Code Examples**
```java
// String Pool Behavior
String s1 = "Hello";           // Pool
String s2 = "Hello";           // Same reference  
String s3 = new String("Hello"); // New object
s1 == s2  // true
s1 == s3  // false

// Integer Caching
Integer a = 127, b = 127;  // a == b → true (cached)
Integer c = 128, d = 128;  // c == d → false (not cached)
```

## 🛠️ **Dependencies**

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.38.0</version>
    </dependency>
    
    <!-- TestNG for assertions -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.11.0</version>
    </dependency>
</dependencies>
```

## 📈 **Learning Path**

### **For Selenium Automation**
1. **Start with**: `Main.java` - Basic WebDriver setup
2. **Progress to**: `CheckboxFixed.java` - Element interaction techniques
3. **Advanced**: `AutomationPracticeTestSuite.java` - Comprehensive testing

### **For Java Interview Prep**
1. **Core OOPs**: Run `Oops.java` and study output
2. **Exception Handling**: Focus on try-catch-finally scenarios
3. **Tricky Questions**: Review `JAVA_OOPS_GUIDE.md`
4. **Practice**: Implement similar examples

## 🎓 **Best Practices Demonstrated**

### **Selenium Automation**
- ✅ **Explicit waits** over implicit waits
- ✅ **Page Object Model** structure hints
- ✅ **Robust element selection** strategies
- ✅ **Exception handling** in automation
- ✅ **Clean, readable code** with comments

### **Java Development**
- ✅ **Proper encapsulation** techniques
- ✅ **Effective exception handling**
- ✅ **Memory-efficient** string operations
- ✅ **Collection framework** optimization
- ✅ **Interview-ready** code examples

## 🚀 **Execution Examples**

### **Run Selenium Tests**
```bash
mvn compile exec:java -Dexec.mainClass="com.example.AutomationPracticeTestSuite"
```

**Expected Output:**
```
🌐 Navigated to AutomationPractice page
📄 Page Title: Practice Page

🔘 Testing Radio Buttons
   ✅ Radio button 'radio1' selected successfully
   ✅ Radio button 'radio2' selected successfully
   ✅ Radio button 'radio3' selected successfully

🎉 All tests completed successfully!
```

### **Run Java OOPs Demo**
```bash
mvn compile exec:java -Dexec.mainClass="com.example.Oops"
```

**Expected Output:**
```
🎯 Java OOPs Concepts and Tricky Questions Demo
🔒 ENCAPSULATION DEMO ✅
🌳 INHERITANCE DEMO ✅
🎭 POLYMORPHISM DEMO ✅
🎨 ABSTRACTION DEMO ✅
⚠️ EXCEPTION HANDLING DEMO ✅
```

## 📊 **Repository Statistics**

- **📁 Total Files**: 15+
- **💻 Lines of Code**: 2000+
- **🎯 Test Cases**: 50+
- **☕ Java Classes**: 25+
- **📖 Documentation**: Complete guides
- **🎓 Interview Questions**: 30+

## 🤝 **Contributing**

Feel free to contribute by:
- 🐛 **Reporting bugs** in automation scripts
- ✨ **Adding new test scenarios**
- 📚 **Improving documentation**
- 🎯 **Adding more interview questions**

## 📜 **License**

This project is for **educational purposes** and interview preparation.

## 🔗 **Useful Links**

- **Selenium Documentation**: https://selenium-python.readthedocs.io/
- **TestNG Guide**: https://testng.org/doc/documentation-main.html
- **Java OOPs Tutorial**: https://docs.oracle.com/javase/tutorial/java/concepts/
- **Practice Page**: https://rahulshettyacademy.com/AutomationPractice/

---

### 🎯 **Perfect for:**
- 📚 **Learning Selenium automation**
- ☕ **Java interview preparation** 
- 🎓 **OOPs concept revision**
- 💼 **Professional skill development**

**Happy Learning! 🚀✨**