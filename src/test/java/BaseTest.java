import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

// removed @Test annotation.
public class BaseTest {
    public static WebDriver driver = null;

    @BeforeSuite
    static void setupClass() { WebDriverManager.chromedriver().setup(); }

    @BeforeMethod
    public void setUpBrowser () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    public static void openLoginURL() {
        String url = "https://bbb.testpro.io";
        driver.get(url);
    }

    public void provideEmail (String email) {
        WebElement emailField = driver.findElement (By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword (String password) {
        WebElement passwordField = driver.findElement (By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(3000);
    }

}

