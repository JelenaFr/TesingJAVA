package SeleniumTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class NavigationFirefox {
    static WebDriver driver;
    @Test
    public void WebDriverStart() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Yelena\\Documents\\Diploma\\testingLessons\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.ut.ee/et");
        Assert.assertEquals("Tartu Ülikool", driver.getTitle());
        System.out.println("Page title is : " +driver.getTitle());
    }

    @Test
    public void WebDriverElement() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Yelena\\Documents\\Diploma\\testingLessons\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.ut.ee/et");
        //driver.findElement(By.id("edit-search-block-form--2")).sendKeys("Narva College");
        WebElement textBox =driver.findElement(By.id("edit-search-block-form--2"));
        driver.findElement(By.className("pane-content"));
        textBox.sendKeys("Narva College"+ Keys.ENTER);
    }

}
