package com.luma.tests.addToCart;

import com.luma.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderTests extends BaseTest {

    // Place an order for a simple product.

    @Test
    public void addToCartAndPlaceOrder() {
        homePage.shopNewYoga();
        productSearchPage.goToProductDetails("Overnight Duffle");
        productInfoPage.setQty("20");
        productInfoPage.clickAddToCart();
        cartPage.viewCart();
        Assert.assertEquals(cartPage.getProductName(), "Overnight Duffle");
        Assert.assertEquals(cartPage.getProductQty(), "20");
        cartPage.proceedToCheckout();
        checkoutPage.setEmail("test@mail.com");
        checkoutPage.setFirstName("test");
        checkoutPage.setLastName("name");
        checkoutPage.setStreet("test street 8");
        checkoutPage.setCity("TestCity");
        checkoutPage.selectState("Arizona");
        checkoutPage.setZip("12345-6789");
        checkoutPage.setPhoneNumber("0712345678");
        checkoutPage.setShipping(1);
        checkoutPage.clickNext();
        checkoutPage.clickPlaceOrder();
        Assert.assertEquals(checkoutPage.getTitle(), "Thank you for your purchase!");
    }

    // Place an order for a complex product.

    @Test
    public void addToCartPlaceOrder() {
        homePage.shopNewYoga();
        productSearchPage.goToProductDetails("Helena Hooded Fleece");
        productInfoPage.setQty("4");
        productInfoPage.selectSize("M");
        productInfoPage.selectColor("Blue");
        productInfoPage.clickAddToCart();
        cartPage.viewCart();
        Assert.assertEquals(cartPage.getProductName(), "Helena Hooded Fleece");
        Assert.assertEquals(cartPage.getProductQty(), "4");
        Assert.assertEquals(cartPage.getSize(), "M");
        Assert.assertEquals(cartPage.getColor(), "Blue");
        cartPage.proceedToCheckout();
        checkoutPage.setEmail("test@mail.com");
        checkoutPage.setFirstName("test");
        checkoutPage.setLastName("name");
        checkoutPage.setStreet("test street 8");
        checkoutPage.setCity("TestCity");
        checkoutPage.selectState("Arizona");
        checkoutPage.setZip("12345-6789");
        checkoutPage.setPhoneNumber("0712345678");
        checkoutPage.setShipping(2);
        checkoutPage.clickNext();
        checkoutPage.clickPlaceOrder();
        Assert.assertEquals(checkoutPage.getTitle(), "Thank you for your purchase!");
    }
}
