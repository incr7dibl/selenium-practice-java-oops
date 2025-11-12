package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Runnable examples showing XPath traversal patterns (parent->child, child->child,
 * child->parent and siblings) against the AutomationPractice table at:
 * https://rahulshettyacademy.com/AutomationPractice/
 *
 * Notes:
 * - Requires ChromeDriver on PATH (or configured via system property).
 * - This prints example outputs; adjust XPath strings if the page markup changes.
 */
public class TablesExample2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String url = "https://rahulshettyacademy.com/AutomationPractice/";

        try {
            driver.manage().window().maximize();
            driver.get(url);

            // wait for the table to appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@name='courses']")));

            WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));

            // 1) Parent -> Child (direct child): use single slash or './' from context element
            // Get tbody rows (direct child rows). If tbody exists, use ./tbody/tr otherwise ./tr
            List<WebElement> bodyRows = table.findElements(By.xpath("./tbody/tr"));
            if (bodyRows.isEmpty()) {
                // fallback when tbody is not present in markup
                bodyRows = table.findElements(By.xpath("./tr"));
            }
            System.out.println("Direct child rows (./tr or ./tbody/tr): " + bodyRows.size());

            // 2) Descendant (anywhere under the table) vs scoped descendant
            List<WebElement> allRowsDocScope = driver.findElements(By.xpath("//table[@name='courses']//tr"));
            List<WebElement> allRowsScoped = table.findElements(By.xpath(".//tr"));
            System.out.println("Rows found with document-scope //table...//tr: " + allRowsDocScope.size());
            System.out.println("Rows found with element-scoped .//tr: " + allRowsScoped.size());

            // 3) Child -> Child: from a specific row to its cells
            if (!allRowsScoped.isEmpty()) {
                WebElement firstRow = allRowsScoped.get(0);
                List<WebElement> cols = firstRow.findElements(By.xpath("./td"));
                System.out.println("Columns in first row (./td): " + cols.size());
                for (int i = 0; i < cols.size(); i++) {
                    System.out.println("  col[" + i + "] text = '" + cols.get(i).getText().trim() + "'");
                }
            }

            // 4) Child -> Parent: from a known cell find its parent row
            // Example: find a cell that contains a known course name then go up to its row
            WebElement cellWithCourse = table.findElement(By.xpath(".//td[contains(normalize-space(.), 'Selenium Webdriver')]"));
            WebElement parentRow = cellWithCourse.findElement(By.xpath("ancestor::tr"));
            System.out.println("Parent row text for Selenium Webdriver row: '" + parentRow.getText().trim() + "'");

            // 5) Sibling traversal: from a cell get the next sibling cell (e.g., price column)
            WebElement priceCell = cellWithCourse.findElement(By.xpath("following-sibling::td[1]"));
            System.out.println("Sibling (price) cell text: '" + priceCell.getText().trim() + "'");

            // 6) Complex: find the price for a course by matching course name then selecting column
            // This is common interview ask: "Find price for course with name X"
            String courseName = "Selenium Webdriver"; // example; change as needed
            List<WebElement> priceForCourse = table.findElements(By.xpath(
                    ".//tr[.//td[contains(normalize-space(.), '" + courseName + "')]]/td[2]"
            ));
            if (!priceForCourse.isEmpty()) {
                System.out.println("Price for '" + courseName + "' = " + priceForCourse.get(0).getText().trim());
            } else {
                System.out.println("Couldn't find price for '" + courseName + "' with the example XPath.");
            }

            // 7) Action in same row (click button/link in the matched row)
            // Example XPath to locate a 'Buy' or 'Enroll' button in the same row as the course
            List<WebElement> actionButtons = table.findElements(By.xpath(
                    ".//tr[.//td[contains(normalize-space(.), '" + courseName + "')]]//a | .//tr[.//td[contains(normalize-space(.), '" + courseName + "')]]//button"
            ));
            if (!actionButtons.isEmpty()) {
                System.out.println("Found action element for '" + courseName + "': " + actionButtons.get(0).getText());
                // actionButtons.get(0).click(); // uncomment to perform click
            } else {
                System.out.println("No action button found for '" + courseName + "' (example only).");
            }

            // 8) Useful XPath helpers often asked in interviews
            System.out.println("Example XPath helpers shown in comments inside the code (contains(), starts-with(), normalize-space(), position(), last()).");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
