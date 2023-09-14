import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LicenseAndPhoneAutomation {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable (You need to download and set up ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the license and phone number management system
        driver.get("https://facegenie-ams-school.web.app/dashboard/managelicenses");

        // Test Case 1: Add License
        WebElement addLicenseButton = driver.findElement(By.id("add_license_button"));
        addLicenseButton.click();

        // Fill in license information (assuming form elements with IDs or names)
        WebElement licenseKeyField = driver.findElement(By.id("license_key"));
        WebElement expirationDateField = driver.findElement(By.id("expiration_date"));
        WebElement addLicenseSubmitButton = driver.findElement(By.id("add_license_submit_button"));

        licenseKeyField.sendKeys("ABCD-1234-EFGH-5678");
        expirationDateField.sendKeys("2023-12-31");
        addLicenseSubmitButton.click();

        // Verify that the license has been added (e.g., check for the license key in the license list)
        WebElement licenseList = driver.findElement(By.id("license_list"));
        if (licenseList.getText().contains("ABCD-1234-EFGH-5678")) {
            System.out.println("Test Case 1: Add License - PASS");
        } else {
            System.out.println("Test Case 1: Add License - FAIL");
        }

        // Test Case 2: Update License (Assuming you have an Edit button to click)
        WebElement editLicenseButton = driver.findElement(By.id("edit_license_button"));
        editLicenseButton.click();

        // Update license information
        WebElement updatedExpirationDateField = driver.findElement(By.id("expiration_date"));
        updatedExpirationDateField.clear();
        updatedExpirationDateField.sendKeys("2024-12-31");

        WebElement saveLicenseButton = driver.findElement(By.id("save_license_button"));
        saveLicenseButton.click();

        // Verify that the license has been updated
        if (licenseList.getText().contains("ABCD-1234-EFGH-5678 (2024-12-31)")) {
            System.out.println("Test Case 2: Update License - PASS");
        } else {
            System.out.println("Test Case 2: Update License - FAIL");
        }

        // Test Case 3: Delete License (Assuming you have a Delete button to click)
        WebElement deleteLicenseButton = driver.findElement(By.id("delete_license_button"));
        deleteLicenseButton.click();

        // Verify that the license has been deleted (e.g., check if the license key is no longer present)
        if (!licenseList.getText().contains("ABCD-1234-EFGH-5678")) {
            System.out.println("Test Case 3: Delete License - PASS");
        } else {
            System.out.println("Test Case 3: Delete License - FAIL");
        }

        // Similar test cases can be implemented for managing phone numbers

        // Close the browser
        driver.quit();
    }
}