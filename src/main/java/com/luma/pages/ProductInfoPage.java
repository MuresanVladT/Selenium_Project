package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductInfoPage extends BasePage{
    public ProductInfoPage(WebDriver driver) {
        super(driver);
    }

    private final By addToCartButton = By.xpath("//button[@id=\"product-addtocart-button\"]");
    private final By qtyField = By.xpath("//input[@id=\"qty\"]");
    private final By addToCompareButton = By.xpath("//a[@class='action tocompare']");

    public void clickAddToCart(){
        click(addToCartButton);
    }

    public void setQty(String qty){
        set(qtyField, qty);
    }

    public void selectSize(String sizeNumber) {
        WebElement sizeButton = driver.findElement(By.xpath("//div[@option-tooltip-value=\"" + sizeNumber + "\"]"));
        sizeButton.click();
    }

    public void selectColor(String colorName) {
        WebElement colorButton = driver.findElement(By.xpath("//div[contains(@aria-label, \"" + colorName + "\")]"));
        colorButton.click();
    }

    public void addToCompare(){
        find(addToCompareButton).click();
    }

}
