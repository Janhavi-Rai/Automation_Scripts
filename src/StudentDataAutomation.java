import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentDataAutomation {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable (You need to download and set up ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the student management system
        driver.get("https://facegenie-ams-school.web.app/dashboard/managestudent/");

        // Test Case 1: Add Student
        WebElement addStudentButton = driver.findElement(By.id("add_student_button"));
        addStudentButton.click();

        // Fill in student information (assuming form elements with IDs or names)
        WebElement firstNameField = driver.findElement(By.id("first_name"));
        WebElement lastNameField = driver.findElement(By.id("last_name"));
        WebElement studentIdField = driver.findElement(By.id("student_id"));
        WebElement addButton = driver.findElement(By.id("add_button"));

        firstNameField.sendKeys("John");
        lastNameField.sendKeys("Doe");
        studentIdField.sendKeys("123456");
        addButton.click();

        // Verify that the student has been added (e.g., check for the student's name in the student list)
        WebElement studentList = driver.findElement(By.id("student_list"));
        if (studentList.getText().contains("John Doe")) {
            System.out.println("Test Case 1: Add Student - PASS");
        } else {
            System.out.println("Test Case 1: Add Student - FAIL");
        }

        // Test Case 2: Read Student Data (Assuming you have a specific student ID or name to search for)
        WebElement searchField = driver.findElement(By.id("search_field"));
        WebElement searchButton = driver.findElement(By.id("search_button"));

        searchField.sendKeys("John Doe");
        searchButton.click();

        // Verify that the student's data is displayed
        WebElement studentData = driver.findElement(By.id("student_data"));
        if (studentData.getText().contains("John Doe")) {
            System.out.println("Test Case 2: Read Student Data - PASS");
        } else {
            System.out.println("Test Case 2: Read Student Data - FAIL");
        }

        // Test Case 3: Update Student Data (Assuming you have an Edit button to click)
        WebElement editButton = driver.findElement(By.id("edit_button"));
        editButton.click();

        // Update student information
        WebElement updatedLastNameField = driver.findElement(By.id("last_name"));
        updatedLastNameField.clear();
        updatedLastNameField.sendKeys("Smith");

        WebElement saveButton = driver.findElement(By.id("save_button"));
        saveButton.click();

        // Verify that the student's data has been updated
        if (studentData.getText().contains("John Smith")) {
            System.out.println("Test Case 3: Update Student Data - PASS");
        } else {
            System.out.println("Test Case 3: Update Student Data - FAIL");
        }

        // Test Case 4: Delete Student (Assuming you have a Delete button to click)
        WebElement deleteButton = driver.findElement(By.id("delete_button"));
        deleteButton.click();

        // Verify that the student has been deleted (e.g., check if the student's data is no longer present)
        if (!studentData.getText().contains("John Smith")) {
            System.out.println("Test Case 4: Delete Student - PASS");
        } else {
            System.out.println("Test Case 4: Delete Student - FAIL");
        }

        // Close the browser
        driver.quit();
    }
}