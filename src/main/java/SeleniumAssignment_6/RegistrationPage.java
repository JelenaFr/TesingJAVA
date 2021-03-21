package SeleniumAssignment_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
    }

    private By facebookLinkField = By.xpath("//*[@id=\"react-root\"]/section/main/div/div/div[1]/div/form/div[1]/button");
    private By mobileOrEmailField = By.cssSelector("[aria-label='Mobile Number or Email']");
    private By fullnameField = By.cssSelector("[aria-label='Full Name']");
    private By userNameField = By.cssSelector("[aria-label='Username']");
    private By passwordField = By.cssSelector("[aria-label='Password']");
    private By nextButtonField = By.cssSelector("[type='submit']");
    private By alertAccept = By.xpath("[class*=bIiDR]");



    public RegistrationPage createOrRegisterAccount(String mobileOrEmail, String fullname, String userName, String password, WebDriver driver, Boolean register) {
        driver.findElement(mobileOrEmailField).sendKeys(mobileOrEmail);
        driver.findElement(fullnameField).sendKeys(fullname);
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
        if (register) {
            driver.findElement(nextButtonField).click();
        } else {
            driver.findElement(nextButtonField).isEnabled();
        }
        return new RegistrationPage(driver);
    }

    public void facebookRegistration(WebDriver driver) {
        driver.findElement(By.cssSelector("[class*=bIiDR]")).click();
        driver.findElement(facebookLinkField).click();

    }
}
