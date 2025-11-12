package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TablesExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("TablesExample main method executed");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");

        WebElement coursesTable = driver.findElement(By.xpath("//table[@name='courses']"));
        // System.out.println((coursesTable.findElements(By.xpath(".//tr"))).size());
        List<WebElement> rows = coursesTable.findElements(By.xpath(".//tr"));
        List<WebElement> firstColumn = coursesTable.findElements(By.xpath(".//tr/td[1]"));
        List<WebElement> secondColumn = coursesTable.findElements(By.xpath(".//tr/td[2]"));
        List<WebElement> thirdColumn = coursesTable.findElements(By.xpath(".//tr/td[3]"));

        // for (WebElement row : rows) {
        // List<WebElement> cells = row.findElements(By.xpath(".//td"));

        // for (WebElement cell : cells) {
        // System.out.print(cell.getText() + " | ");
        // }
        // System.out.println();

        // }
        // printData(driver, firstColumn);
        // printData(driver, secondColumn);
        // printData(driver, thirdColumn);

        WebElement secondTable = driver.findElement(By.xpath("//div[@class='tableFixHead']/table"));
        List<WebElement> anotherRows = secondTable.findElements(By.xpath(".//tr"));
        System.out.println(anotherRows.size());

        List<WebElement> amountColumn = secondTable.findElements(By.xpath(".//tr/td[4]"));

        int totalAmount = 0;

        for (WebElement amountElement : amountColumn) {
            System.out.println(amountElement.getText());
            totalAmount += Integer.parseInt(amountElement.getText());
        }
        System.out.println("Total Amount: " + totalAmount);
        int actualAmount = Integer
                .parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());

                Assert.assertNotEquals(actualAmount, totalAmount);
        driver.quit();

    }

    public static void printData(WebDriver driver, List<WebElement> list) {
        for (WebElement element : list) {
            System.out.println(element.getText());
        }
    }
}
