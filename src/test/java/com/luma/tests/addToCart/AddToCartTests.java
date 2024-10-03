package com.luma.tests.addToCart;

import com.luma.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseTest {

    @Test
    public void addProductToCart() throws InterruptedException {
        homePage.shopNewYoga();
        productSearchPage.goToProductDetails("Overnight Duffle");
        productInfoPage.setQty("20");
        productInfoPage.clickAddToCart();
        cartPage.viewCart();
        String actualProductName = cartPage.getProductName();
        Assert.assertEquals(actualProductName,"Overnight Duffle");
        String actualProductQty = cartPage.getProductQty();
        Assert.assertEquals(actualProductQty, "20");
    }
}
