package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverClass {
    public static WebDriver driver;

    static {
        driver = new ChromeDriver();

        driver.manage().window().maximize(); // Expands the driver to the edges of the screen

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); // Waits for 15 seconds for our computer downloads
        // all the files from the web server.
        // If they are not downloaded in 15 seconds it throws an exception
        // That means there is a problem with the server or with your internet connection

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Waits for 15 seconds to all elements on the page are in HTML code
        // If they are not loaded in 15 seconds it throws an exception
        // That means your application is not compatible with the browser you are using.
    }

    public static void waitAndQuit() {
        MyMethods.myWait(3);
        driver.quit();
    }
}
