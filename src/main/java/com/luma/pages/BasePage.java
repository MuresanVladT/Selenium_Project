package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void set(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator){
        find(locator).click();
    }

    public String uniqueEmail(){
        long currentTimeMillis = System.currentTimeMillis();
        return STR."\{currentTimeMillis}@mail.com";
    }

    public String uniqueName(){
        long currentTimeMillis = System.currentTimeMillis();
        return STR."user\{currentTimeMillis}";
    }

    public String uniquePassword(){
        long currentTimeMillis = System.currentTimeMillis();
        return STR."Password\{currentTimeMillis}";
    }
}
