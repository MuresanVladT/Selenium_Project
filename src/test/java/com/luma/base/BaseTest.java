package com.luma.base;

import com.luma.pages.*;
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
    protected static LoginPage loginPage;
    protected static ProductSearchPage productSearchPage;
    protected static CreateAccountPage createAccountPage;
    protected static ProductInfoPage productInfoPage;
    protected static CartPage cartPage;
    protected static CheckoutPage checkoutPage;
    protected static ReviewPage reviewPage;
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
        productSearchPage = new ProductSearchPage(driver);
        productInfoPage = new ProductInfoPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        reviewPage = new ReviewPage(driver);
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}
