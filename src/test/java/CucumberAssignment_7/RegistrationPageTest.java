package CucumberAssignment_7;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationPageTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yelena\\Documents\\Diploma\\testingLessons\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.instagram.com/accounts/emailsignup/");
        registrationPage = new RegistrationPage(driver);

    }



    @Test

    public void facebookRegistrationTest() {
        registrationPage.facebookRegistration(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/login.php"));

    }

    @Test

   public void createAccountTest() {
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        driver.getCurrentUrl();
        registrationPage.createOrRegisterAccount("jelenafreiberg@hot.ee",
                "Jelena Freiberg", "JFSeleniumTest", "maiuspala", driver, false);
    }

    @Test

    public void termsLinkTest() {
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        String loginButton = "[href=\"/accounts/login/?source=auth_switcher\"]";
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.cssSelector(loginButton)));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.instagram.com/accounts/login/?source=auth_switcher"));
    }

    @Test

    public void alertMessagesValidEmailTest(){
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        registrationPage.createOrRegisterAccount("jelenafreiberghot.ee",
                "Jelena Freiberg", "JFSeleniumTest", "maiuspala", driver, true);
        Assert.assertEquals(driver.findElement(By.cssSelector("[role='alert']")).getText(), "Enter a valid email address.");
    }

    @Test

    public void alertMessagesValidPhoneTest(){
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        //driver.getCurrentUrl();
        registrationPage.createOrRegisterAccount("372556847",
                "Jelena Freiberg", "JFSeleniumTest", "maiuspala", driver, true);
        Assert.assertEquals(driver.findElement(By.cssSelector("[role='alert']")).getText(), "Looks like your phone number may be incorrect. Please try entering your full number, including the country code.");


    }

    @Test

    //This method always failed. Instagram has not alert for this situation
    public void alertMessagesValidNameTest(){
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        registrationPage.createOrRegisterAccount("jelenafreiberg@hot.ee",
                "**********", "JFSeleniumTest", "maiuspala", driver, true);
        System.out.println(driver.findElement(By.cssSelector("[role='alert']")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("[role='alert']")).getText(), "Usernames can only use letters, numbers, underscores and periods.");
    }
    @Test

    public void alertMessagesUniqueNameTest(){
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        registrationPage.createOrRegisterAccount("jelenafreiberg@hot.ee",
                "Jelena Freiberg", "melaniatrump", "maiuspala", driver, true);
        Assert.assertEquals(driver.findElement(By.cssSelector("[role='alert']")).getText(), "This username isn't available. Please try another.");
    }

    @Test

    public void alertMessagesPasswordTest(){
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        registrationPage.createOrRegisterAccount("jelenafreiberg@hot.ee",
                "Jelena Freiberg", "JFSeleniumTest", "123456", driver, true);
        Assert.assertEquals(driver.findElement(By.cssSelector("[role='alert']")).getText(), "This password is too easy to guess. Please create a new one.");
    }

    @After
    public void testDown() {
        driver.quit();
    }

}

