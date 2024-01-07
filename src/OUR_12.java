import Utilities.DriverClass;
import Utilities.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OUR_12 extends DriverClass {
    /*
    I should be able to go to the "Account Management" page and see the "Delete Account" button.
    I should be able to click on the "Delete Account" button and see the message "Are you sure you want to delete your
    account? You will lose access to rewards, exclusive coupons, personalized grocery lists, information about your
    store’s stock levels and more (yes, there’s more)."
    I should be able to start the account deletion process by clicking the "Delete Account" button.
    In the confirmation dialog, I should see the message "Are you sure you want to delete your account? Think it over long and hard!"
    After confirming the deletion, I should receive a notification that my account has been successfully deleted.
    I should assert that my account has been successfully deleted and automatically logged out.
    */
    @Test
    public void registration_our12() {

        //-----------------------------------Registration for testing account deletion----------------------------------
        driver.get("https://www.lidl.com/login");
        
        WebElement joinMyLidl = driver.findElement(By.linkText("join myLidl"));
        joinMyLidl.click();
        
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Bakhodur");
        
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Takhirov");
        
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("takhirovb111@gmail.com");
        
        WebElement confirm_email = driver.findElement(By.name("confirm_email"));
        confirm_email.sendKeys("takhirovb111@gmail.com");
        
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
        waitAndQuit();
    }
    
    @Test
    public void deletion_our12() {
        //-------------------------Deleting account---------------------------------------------------------------------
        driver.get("https://www.lidl.com/login");
        
        WebElement bannerClose = driver.findElement(By.xpath("//button[@aria-label=\"okay\"]"));
        bannerClose.click();
        
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("takhirovb111@gmail.com");
        
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("PassW0rd");
        
        WebElement signInButton = driver.findElement(By.cssSelector("button[data-test=\"signInButton\"]"));
        signInButton.click();
        
        WebElement cokieClose = driver.findElement(By.xpath("//button[@aria-label=\"Close\"]"));
        cokieClose.click();
        
        WebElement myAccountDropdown = driver.findElement(By.xpath("//span[text()=\"my account\"]"));
        myAccountDropdown.click();
        
        WebElement accountName = driver.findElement(By.className("name"));
        accountName.click();
        
        WebElement accountManagement = driver.findElement(By.linkText("account management"));
        accountManagement.click();
        
        //I should be able to go to the "Account Management" page and see the "Delete Account" button.
        WebElement deleteAccount = driver.findElement(By.xpath("//button[text()=\"delete account\"]"));
        Assert.assertTrue(deleteAccount.isDisplayed());
        
        //I should be able to click on the "Delete Account" button and see the message "Are you sure you want to delete your
        //account? You will lose access to rewards, exclusive coupons, personalized grocery lists, information about your
        //store’s stock levels and more (yes, there’s more)."
        WebElement accountDeletionContent = driver.findElement(By.xpath("//p[@class=\"account-deletion-content\"]"));
        
        Assert.assertTrue(accountDeletionContent.getText().equals("Are you sure you want to delete your account? You will lose " +
                "access to rewards, exclusive coupons, personalized grocery lists, information about your store’s stock" +
                " levels and more (yes, there’s more)."));
        
        //I should be able to start the account deletion process by clicking the "Delete Account" button.
        deleteAccount.click();
        
        //In the confirmation dialog, I should see the message "Are you sure you want to delete your account?
        // Think it over long and hard!"
        WebElement accountDeletionDialog = driver.findElement(By.xpath("//div[@class=\"dialog-content\"]"));
        Assert.assertTrue(accountDeletionDialog.getText().equals("Are you sure you want to delete your account? Think it over " +
                "long and hard!"));
        
        //After confirming the deletion, I should receive a notification that my account has been successfully deleted.
        //I should assert that my account has been successfully deleted and automatically logged out.
        WebElement deleteAccountConfirmation = driver.findElement(By.xpath("(//button[text()=\"delete account\"])[1]"));
        deleteAccountConfirmation.click();
        
        WebElement signInButtonAfterDeletion = driver.findElement(By.cssSelector("a[data-test=\"signIn\"]"));
        Assert.assertTrue(signInButtonAfterDeletion.isDisplayed());
        
        MyMethods.myWait(3);
        waitAndQuit();
    }
}
