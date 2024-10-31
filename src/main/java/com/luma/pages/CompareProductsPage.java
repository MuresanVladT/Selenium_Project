package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompareProductsPage extends BasePage{
    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By compareProductsLink = By.xpath("//a[@title='Compare Products']");
    private final By firstItemName = By.xpath("(//strong[@class='product-item-name']/a)[1]");
    private final By secondItemName = By.xpath("(//strong[@class='product-item-name']/a)[2]");

    public void clickCompareProducts(){
        find(compareProductsLink).click();
    }

    public String getFirstProductName(){
        goToElement(firstItemName);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemName)).getText();
    }

    public String getSecondProductName(){
        goToElement(secondItemName);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(secondItemName)).getText();
    }
}
