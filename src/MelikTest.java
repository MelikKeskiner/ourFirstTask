import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverClass;
import utilities.MyMethods;

import java.time.Duration;

public class MelikTest extends DriverClass {
    @Test
    public void test(){
        driver.get("https://www.lidl.com/login");

        WebElement joinMyLidl = driver.findElement(By.linkText("join myLidl"));
        joinMyLidl.click();

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Melik");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Keskiner");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("melikkeskiner0@gmail.com");

        WebElement confirm_email = driver.findElement(By.name("confirm_email"));
        confirm_email.sendKeys("melikkeskiner0@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("PassW0rd");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("(111) 123-4321");

        WebElement zip = driver.findElement(By.name("zip"));
        zip.sendKeys("11229");

        WebElement birthday = driver.findElement(By.name("birthday"));
        birthday.sendKeys("01/01/1990");

        WebElement cokieClose = driver.findElement(By.xpath("//button[@aria-label=\"Close\"]"));
        cokieClose.click();

        WebElement joinMyLidlSubmit = driver.findElement(By.xpath("//button[text()=\"join myLidl\"]"));
        joinMyLidlSubmit.click();

        MyMethods.myWait(3);
        driver.quit();
    }

    @Test
    public void test1() {
        MyMethods.myWait(2);
        driver.get("https://www.lidl.com/");

        WebElement bannerClose = driver.findElement(By.xpath("//button[@aria-label=\"okay\"]"));
        bannerClose.click();
        MyMethods.myWait(1);

        WebElement cokieClose = driver.findElement(By.xpath("//button[@aria-label=\"Close\"]"));
        cokieClose.click();

        MyMethods.myWait(2);

        WebElement signInButton = driver.findElement(By.linkText("sign in"));
        signInButton.click();

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("melikkeskiner0@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("PassW0rd");

        WebElement myAccount =
                driver.findElement(By.cssSelector("button[data-test=\"signInButton\"]"));
        myAccount.click();

        WebElement account =
                driver.findElement(By.xpath("//span[@class=\"profile-dropdown-button-label \"]"));
        account.click();

        WebElement name = driver.findElement(By.xpath("//div[@class=\"name\"]"));
        name.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("profile"));
        MyMethods.myWait(2);

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("k");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("r");

        WebElement save = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        save.click();

        MyMethods.myWait(2);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBe(By.cssSelector("button[type=\"submit\"]"), "profile updated successfully"));

        WebElement chec = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        chec.getText().contains("profile updated successfully");

        WebElement check = driver.findElement(By.xpath("//h3[@class=\"title-3\"]"));

        Assert.assertTrue(check.getText().equals("Melikk Keskinerr"));

        waitAndQuit();

    }
}
