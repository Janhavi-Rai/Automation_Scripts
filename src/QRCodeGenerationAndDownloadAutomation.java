import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class QRCodeGenerationAndDownloadAutomation {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable (You need to download and set up ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the web application with QR code generation and download functionality
        driver.get("https://facegenie-ams-school.web.app/dashboard/managestudent");
       
        // Test Case 1: QR Code Generation
        // Fill in the data to be encoded in the QR code (assuming a text input field)
        WebElement dataInputField = driver.findElement(By.id("data_input"));
        WebElement generateQRButton = driver.findElement(By.id("generate_qr_button"));

        dataInputField.sendKeys("Sample QR Code Data");
        generateQRButton.click();

        // Wait for the QR code image to load (assuming an image element with an ID)
        WebElement qrCodeImage = driver.findElement(By.id("qr_code_image"));

        // Verify that the QR code image is displayed (e.g., check its dimensions)
        int imageWidth = qrCodeImage.getSize().getWidth();
        int imageHeight = qrCodeImage.getSize().getHeight();

        if (imageWidth > 0 && imageHeight > 0) {
            System.out.println("Test Case 1: QR Code Generation - PASS");
        } else {
            System.out.println("Test Case 1: QR Code Generation - FAIL");
        }

        // Test Case 2: Download QR Code
        // Click a button to download the QR code image (assuming a "Download" button)
        WebElement downloadButton = driver.findElement(By.id("download_button"));
        downloadButton.click();
         // You can add verification steps here to check if the download completed successfully
        // (e.g., checking the presence of a downloaded file in a specified directory)

        // Optional: Save the QR code image locally for further analysis
        try {
            BufferedImage qrCodeBufferedImage = ImageIO.read(qrCodeImage.getScreenshotAs(org.openqa.selenium.OutputType.FILE));
            File outputImageFile = new File("qr_code.png");
            ImageIO.write(qrCodeBufferedImage, "png", outputImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}

