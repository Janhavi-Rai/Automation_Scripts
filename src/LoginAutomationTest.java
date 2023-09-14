import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomationTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable (You need to download and set up ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://facegenie-ams-school.web.app/");

        // Test Case 1: Successful Login
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_button"));

        usernameField.sendKeys("your_username");
        passwordField.sendKeys("your_password");
        loginButton.click();

        WebElement dashboardElement = driver.findElement(By.id("dashboard_element"));

        if (dashboardElement.isDisplayed()) {
            System.out.println("Test Case 1: Successful Login - PASS");
        } else {
            System.out.println("Test Case 1: Successful Login - FAIL");
        }

        // Test Case 2: Invalid Credentials
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys("invalid_username");
        passwordField.sendKeys("invalid_password");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));

        if (errorMessage.getText().contains("Invalid credentials")) {
            System.out.println("Test Case 2: Invalid Credentials - PASS");
        } else {
            System.out.println("Test Case 2: Invalid Credentials - FAIL");
        }

        // Close the browser
        driver.quit();
    }
}