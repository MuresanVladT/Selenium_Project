package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By productName = By.xpath("//strong[@class='product-item-name']/a");
    private By productQty = By.xpath("//input[@title=\"Qty\"]");
    private By showCartButton = By.xpath("//a[@class=\"action showcart\"]");
    private By editCartButton = By.xpath("//span[normalize-space()=\"View and Edit Cart\"]");

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public String getProductQty(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productQty)).getAttribute("value");
    }

    public void viewCart(){
        wait.until(driver ->{
            String cartCount = find(By.xpath("//span[@class=\"counter-number\"]")).getText();
            return cartCount.length() > 0 && Integer.parseInt(cartCount) > 0;
                });
        click(showCartButton);
        click(editCartButton);
    }
}
