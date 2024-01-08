import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverClass;

import java.time.Duration;

public class MelikTest extends DriverClass {
    @Test
    public void test() {
        driver.get("https://www.lidl.com/");

        WebElement cancel = driver.findElement(By.xpath("//img[@alt=\"close-white description\"]"));
        cancel.click();

        WebElement myAccount =
                driver.findElement(By.xpath("//span[@class=\"profile-dropdown-button-label \"]"));
        myAccount.click();
        WebElement myAcc = driver.findElement(By.xpath("//div[@class=\"name\"]"));
        myAcc.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("profile"));

        WebElement firstName = driver.findElement(By.id("input19"));
        firstName.sendKeys("melikk");
        WebElement lastName = driver.findElement(By.id("input20"));
        lastName.sendKeys("Keskinerr");

        WebElement save = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        save.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("button[type=\"submit\"]"), "profile updated successfully"));

        WebElement check = driver.findElement(By.xpath("//h3[@class=\"title-3\"]"));

        Assert.assertTrue(check.getText().equals("melikk keskinerr"));

    }
}
