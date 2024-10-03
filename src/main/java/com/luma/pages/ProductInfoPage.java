package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInfoPage extends BasePage{
    public ProductInfoPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartButton = By.xpath("//button[@id=\"product-addtocart-button\"]");
    private By qtyField = By.xpath("//input[@id=\"qty\"]");

    public void clickAddToCart(){
        click(addToCartButton);
    }

    public void setQty(String qty){
        set(qtyField, qty);
    }
}
