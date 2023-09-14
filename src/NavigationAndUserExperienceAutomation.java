import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationAndUserExperienceAutomation {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable (You need to download and set up ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Test Case 1: Navigation Test
        // Navigate to the home page
        driver.get("https://facegenie-ams-school.web.app/home");

        // Click on a link that navigates to another page (e.g., About Us)
        WebElement aboutUsLink = driver.findElement(By.linkText("About Us"));
        aboutUsLink.click();

        // Verify that we are on the About Us page
        if (driver.getCurrentUrl().equals("https://facegenie-ams-school.web.app/dashboard/")) {
            System.out.println("Test Case 1: Navigation Test - PASS");
        } else {
            System.out.println("Test Case 1: Navigation Test - FAIL");
        }

        // Test Case 2: Page Loading Speed Test
        // Record the start time
        long startTime = System.currentTimeMillis();

        // Navigate to a page with potentially slow loading (e.g., a large report page)
        driver.get("https://facegenie-ams-school.web.app/dashboard/AnalyticsReports");

        // Record the end time after the page is fully loaded
        long endTime = System.currentTimeMillis();

        // Calculate page loading time
        long pageLoadTime = endTime - startTime;

        // Set a threshold for acceptable loading time (e.g., 5000 milliseconds or 5 seconds)
        long acceptableLoadTime = 5000;

        // Verify that the page loaded within an acceptable time
        if (pageLoadTime <= acceptableLoadTime) {
            System.out.println("Test Case 2: Page Loading Speed Test - PASS");
        } else {
            System.out.println("Test Case 2: Page Loading Speed Test - FAIL");
        }

        // Test Case 3: User Experience Test
        // Simulate user interactions (e.g., clicking buttons, filling forms)
        WebElement button = driver.findElement(By.id("example_button"));
        button.click();

        // Verify that the expected result or action occurred (e.g., an alert message is displayed)
        if (driver.switchTo().alert().getText().equals("Button clicked!")) {
            System.out.println("Test Case 3: User Experience Test - PASS");
        } else {
            System.out.println("Test Case 3: User Experience Test - FAIL");
        }

        // Close the browser
        driver.quit();
    }
}
