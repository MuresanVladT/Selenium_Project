package com.luma.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        goToElement(locator);
        find(locator).click();
    }

    public String uniqueEmail() {
        long currentTimeMillis = System.currentTimeMillis();
        return STR."\{currentTimeMillis}@mail.com";
    }

    public String uniqueName() {
        long currentTimeMillis = System.currentTimeMillis();
        return STR."user\{currentTimeMillis}";
    }

    public String uniquePassword() {
        long currentTimeMillis = System.currentTimeMillis();
        return STR."Password\{currentTimeMillis}";
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void goToElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}