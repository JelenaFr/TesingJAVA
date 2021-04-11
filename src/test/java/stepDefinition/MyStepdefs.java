package stepDefinition;

import CucumberAssignment_7.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Given ("User open Instagram registration page by chrome browser")
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yelena\\Documents\\Diploma\\testingLessons\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.instagram.com/accounts/emailsignup/");
        registrationPage = new RegistrationPage(driver);

    }

    @When("User make registration with valid entries")
    public void createAccountTest() {
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        driver.getCurrentUrl();
        registrationPage.createOrRegisterAccount("jelenafreiberg@hot.ee",
                "Jelena Freiberg", "JFSeleniumTest", "maiuspala", driver, false);
    }

    @When ("User has registration in Instagram")
    public void termsLinkTest() {
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        String loginButton = "[href=\"/accounts/login/?source=auth_switcher\"]";
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.cssSelector(loginButton)));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.instagram.com/accounts/login/?source=auth_switcher"));
    }
    @When("User make registration via the Facebook account")
    public void facebookRegistrationTest() {
        registrationPage.facebookRegistration(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/login.php"));
    }

    @When("User make registration with invalid email")
    public void alertMessagesValidEmailTest(){
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        registrationPage.createOrRegisterAccount("jelenafreiberghot.ee",
                "Jelena Freiberg", "JFSeleniumTest", "maiuspala", driver, true);
        Assert.assertEquals(driver.findElement(By.cssSelector("[role='alert']")).getText(), "Enter a valid email address.");
    }





    @When("User make registration with invalid mobile")
    public void alertMessagesValidPhoneTest(){
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        //driver.getCurrentUrl();
        registrationPage.createOrRegisterAccount("372556847",
                "Jelena Freiberg", "JFSeleniumTest", "maiuspala", driver, true);
        Assert.assertEquals(driver.findElement(By.cssSelector("[role='alert']")).getText(), "Looks like your phone number may be incorrect. Please try entering your full number, including the country code.");
    }

    @When("User try use in fullname incorrect characters")
    //This method always failed. Instagram has not alert for this situation
    public void alertMessagesValidNameTest(){
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        registrationPage.createOrRegisterAccount("jelenafreiberg@hot.ee",
                "**********", "JFSeleniumTest", "maiuspala", driver, true);
        System.out.println(driver.findElement(By.cssSelector("[role='alert']")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("[role='alert']")).getText(), "Usernames can only use letters, numbers, underscores and periods.");
    }

    @When("User try enter not available username")
    public void userTryEnterNotAvailableUsername() {
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        registrationPage.createOrRegisterAccount("jelenafreiberg@hot.ee",
                "Jelena Freiberg", "melaniatrump", "maiuspala", driver, true);
        Assert.assertEquals(driver.findElement(By.cssSelector("[role='alert']")).getText(), "This username isn't available. Please try another.");

    }
    @When("User uses for registration simple password")
    public void alertMessagesPasswordTest(){
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        registrationPage.createOrRegisterAccount("jelenafreiberg@hot.ee",
                "Jelena Freiberg", "JFSeleniumTest", "123456", driver, true);
        Assert.assertEquals(driver.findElement(By.cssSelector("[role='alert']")).getText(), "This password is too easy to guess. Please create a new one.");
    }
    @And("Close browser")
    public void testDown() {
        driver.quit();
    }


}
