package com.luma.base;

import com.luma.pages.BasePage;
import com.luma.pages.CreateAccountPage;
import com.luma.pages.HomePage;
import com.luma.pages.LoginPage;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected static WebDriver driver;
    protected static BasePage basePage;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static CreateAccountPage createAccountPage;
    protected static String URL = "https://magento.softwaretestingboard.com/";

    @BeforeMethod
    public static void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(chromeOptions);
        driver.get(URL);
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        createAccountPage = new CreateAccountPage(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
