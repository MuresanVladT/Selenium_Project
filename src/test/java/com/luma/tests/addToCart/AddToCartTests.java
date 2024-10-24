package com.luma.tests.addToCart;

import com.luma.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseTest {

    // Add simple product to cart.

    @Test
    public void addProductToCart() {
        homePage.shopNewYoga();
        productSearchPage.goToProductDetails("Overnight Duffle");
        productInfoPage.setQty("20");
        productInfoPage.clickAddToCart();
        cartPage.viewCart();
        Assert.assertEquals(cartPage.getProductName(), "Overnight Duffle");
        Assert.assertEquals(cartPage.getProductQty(), "20");
    }

   // Add to cart. Specific tab product.

    @Test
    public void addToCartMenJacket(){
        homePage.goToMenJackets();
        productSearchPage.goToProductDetails("Taurus Elements Shell");
        productInfoPage.setQty("2");
        productInfoPage.selectSize("L");
        productInfoPage.selectColor("White");
        productInfoPage.clickAddToCart();
        cartPage.viewCart();
        Assert.assertEquals(cartPage.getProductName(), "Taurus Elements Shell");
        Assert.assertEquals(cartPage.getProductQty(), "2");
        Assert.assertEquals(cartPage.getSize(), "L");
        Assert.assertEquals(cartPage.getColor(), "White");
    }
}
