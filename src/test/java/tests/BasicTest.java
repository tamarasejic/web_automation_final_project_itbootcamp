package tests;

import data_provider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MessagePopUpPage;
import pages.NavPage;

import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigFileReader config;
    protected NavPage navPage;
    protected LoginPage loginPage;
    protected MessagePopUpPage messagePopUpPage;
    protected String baseUrl;


    @BeforeClass
    public void setup(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
        navPage = new NavPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        messagePopUpPage = new MessagePopUpPage(driver, wait);
        config = new ConfigFileReader();
        baseUrl = config.getBaseUrl();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
