package com.example;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPractise2 {
    @Test(enabled = true)
    public void testMethod2() {
        System.out.println("✅ Test method executed successfully!");
    }

    @Test
    @Parameters({ "URL" })
    public void anotherTestMethod2(@Optional("https://default.com") String url) {
        System.out.println("✅ Another test 2 method executed successfully! " + url);
    }

    @Test(dataProvider = "getData")
    public void dataProviderTest(String username, String password) {
        System.out.println("✅ DataProvider Test executed with Username: " + username + " and Password: " + password);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("✅ Before Method executed successfully!");
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][2];
        data[0][0] = "firstUsername";
        data[0][1] = "firstPassword";
        data[1][0] = "secondUsername";
        data[1][1] = "secondPassword";
        return data;
    }
}
