package SeleniumTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NavigationChrome {
    private WebDriver driver;
    //private SomePage somePage;


    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yelena\\Documents\\Diploma\\testingLessons\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        //somePage = new SomePage();
    }

    @Test
    public void WebDriverStart() {
        Assert.assertEquals("HTML Tables", driver.getTitle());
        System.out.println("Page title is : " + driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }

    @Test
    public void TableTestByElementText() {
        //driver.findElement(By.id("edit-search-block-form--2")).sendKeys("Narva College");
        WebElement tableElement = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[3]/td[1]"));
        Assert.assertEquals("Centro comercial Moctezuma", tableElement.getText());
        System.out.println("Info : " + tableElement.getText());
        driver.quit();

    }

    @Test
    public void NextButtonTest() {
        //driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/a[2]"));
        Assert.assertTrue(button.getText().contains("Next"));
        button.click();
        Assert.assertEquals("HTML Lists", driver.getTitle());
        String url = driver.getCurrentUrl();
        System.out.println(driver.getTitle());
        Assert.assertEquals("https://www.w3schools.com/html/html_lists.asp", url);
    }


    @Test
    public void TableTestByPosition() {
        WebElement tableElement = driver.findElement(By.xpath("//*[@id=\"customers\"]"));
        Table table = new Table(tableElement, driver);
        Assert.assertEquals("Austria", table.getValueFromCell(3, 3));
        System.out.println("Info : " + table.getValueFromCell(3, 3));
        Assert.assertEquals("Francisco Chang", table.getValueFromCell(2, "Contact"));
        System.out.println("Info : " + table.getValueFromCell(2, "Contact"));

    }

    @After
    public void testDown() {
        driver.quit();
    }

}
