package Task1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Task1 extends utilities.DriverClass {
     //  I should be able to click on the "Sign In" button on the homepage.
    // By clicking on the "Join MyLidl" button from the "Don't have an account?" link, I should be redirected to the registration page.
    @Test
    public void signIn(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lidl.com/");

        WebElement signIn = driver.findElement(By.linkText("sign in"));
        signIn.click();
        utilities.MyMethods.myWait(5);


    }


    @Test
    public void join(){
        driver.get("https://www.lidl.com/login");

        utilities.MyMethods.myWait(3);

        WebElement join_myLidl = driver.findElement(By.linkText("join myLidl"));
        join_myLidl.click();
        utilities.MyMethods.myWait(5);
    }


}






