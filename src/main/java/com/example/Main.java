package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Since Selenium Manager is being used, no need to set the driver path manually
        // System.setProperty("webdriver.chrome.driver",
        // "C:\\Users\\admin\\.cache\\selenium\\chromedriver\\win64\\142.0.7444.59\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com");
        String parentWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();

    }
}