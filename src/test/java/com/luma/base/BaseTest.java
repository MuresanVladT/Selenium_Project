package com.luma.base;


import com.luma.pages.BasePage;
import com.luma.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected static WebDriver driver;
    protected static BasePage basePage;
    protected static HomePage homePage;
    protected static String URL = "https://magento.softwaretestingboard.com/";

    @BeforeMethod
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(chromeOptions);
        driver.get(URL);
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}
