package Task2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverClass;
import utilities.MyMethods;

public class Task2 extends DriverClass {

    @Test
    public  void Task2() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.lidl.com/");

        MyMethods.myWait(2);

        WebElement signUpButton = driver.findElement(By.xpath("//a[@id='4JJG9739kpHIbb5soZEqvD']"));
        signUpButton.click();

        try {
            WebElement emailElement = driver.findElement(By.xpath("//input[@id='input2']"));
            emailElement.sendKeys("kosarertugrul20@gmail.com");

            WebElement confirmEmailElement = driver.findElement(By.xpath("//input[@id='input3']"));
            confirmEmailElement.sendKeys("kosarertugrul20@gmail.com");

            if (emailElement.getAttribute("value").equals(confirmEmailElement.getAttribute("value"))) {
                System.out.println("Emails match. Continue registration.");

                WebElement phoneNumberElement = driver.findElement(By.xpath("//input[@id='input5']"));
                phoneNumberElement.sendKeys("6692199288");

                String phoneNumber = phoneNumberElement.getAttribute("value");

                if (isValidPhoneNumber(phoneNumber)) {
                    System.out.println("Registration successful.");
                } else {
                    System.out.println("Invalid phone number. Registration failed.");
                }
            } else {
                System.out.println("Emails do not match. Registration failed.");
            }

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        int expectedLength = 10;
        return phoneNumber.length() == expectedLength;
    }
}