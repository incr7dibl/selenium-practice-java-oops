package com.example;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPractise {
    @Test(enabled = true)
    public void testMethod() {
        System.out.println("✅ Test method executed successfully!");
        // Your test code here
    }

    @Test(dependsOnMethods = { "testMethod" })
    public void anotherTestMethod() {
        System.out.println("✅ Another test method executed successfully!");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("✅ Before Suite executed successfully!");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("✅ After Suite executed successfully!");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("✅ Before Method executed successfully!");
    }

}
