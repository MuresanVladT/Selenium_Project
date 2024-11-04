package com.luma.tests.addToCart;

import com.luma.base.BaseTest;
import com.luma.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseTest {

    protected static ProductSearchPage productSearchPage;
    protected static ProductInfoPage productInfoPage;
    protected static CartPage cartPage;

    // Add simple product to cart.

    @Test
    public void addProductToCart() {
        homePage.shopNewYoga();
        productSearchPage = new ProductSearchPage(driver);
        productSearchPage.goToProductDetails("Overnight Duffle");
        productInfoPage = new ProductInfoPage(driver);
        productInfoPage.setQty("20");
        productInfoPage.clickAddToCart();
        cartPage = new CartPage(driver);
        cartPage.viewCart();
        Assert.assertEquals(cartPage.getProductName(), "Overnight Duffle");
        Assert.assertEquals(cartPage.getProductQty(), "20");
    }

   // Add to cart. Specific tab product.

    @Test
    public void addToCartMenJacket(){
        homePage.goToMenJackets();
        productSearchPage = new ProductSearchPage(driver);
        productSearchPage.goToProductDetails("Taurus Elements Shell");
        productInfoPage = new ProductInfoPage(driver);
        productInfoPage.setQty("2");
        productInfoPage.selectSize("L");
        productInfoPage.selectColor("White");
        productInfoPage.clickAddToCart();
        cartPage = new CartPage(driver);
        cartPage.viewCart();
        Assert.assertEquals(cartPage.getProductName(), "Taurus Elements Shell");
        Assert.assertEquals(cartPage.getProductQty(), "2");
        Assert.assertEquals(cartPage.getSize(), "L");
        Assert.assertEquals(cartPage.getColor(), "White");
    }
}
