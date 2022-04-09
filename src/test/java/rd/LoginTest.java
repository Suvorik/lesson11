package rd;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static String url = "https://www.bbc.com";
    public static String name = "turlotv@mail.ru";
    public static String password = "TTV161090";
    public final String CHECK_BTN = "Your account";

    @BeforeClass
    public static void openLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\НовыйЯ\\Desktop\\lesson10\\test\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void wikiLoginTest() {
        mainPage.signIn();
        loginPage.inputName(name);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();

        Assert.assertEquals(CHECK_BTN, mainPage.getUserName());
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}