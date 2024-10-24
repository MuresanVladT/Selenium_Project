package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.xpath("//td//div[contains(@class, 'product-item-details')]//strong");
    private final By productQty = By.xpath("//input[@title=\"Qty\"]");
    private final By showCartButton = By.xpath("//a[@class=\"action showcart\"]");
    private final By editCartButton = By.xpath("//span[normalize-space()=\"View and Edit Cart\"]");
    private final By checkoutButton = By.xpath("//button[@data-role='proceed-to-checkout']");
    private final By sizeElement = By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td/div/dl/dd[1]");
    private final By colorElement = By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td/div/dl/dd[2]");

    public String getProductName() {
        goToElement(productName);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public String getProductQty() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productQty)).getAttribute("value");
    }

    public String getSize() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sizeElement)).getText();
    }

    public String getColor() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(colorElement)).getText();
    }

    public void viewCart() {
        wait.until(driver -> {
            String cartCount = find(By.xpath("//span[@class=\"counter-number\"]")).getText();
            return cartCount.length() > 0 && Integer.parseInt(cartCount) > 0;
        });
        click(showCartButton);
        click(editCartButton);
    }

    public void proceedToCheckout() {
        click(checkoutButton);
    }

}
