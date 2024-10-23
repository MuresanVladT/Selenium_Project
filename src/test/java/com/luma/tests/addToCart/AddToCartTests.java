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

    @Test
    public void addToCartAndPlaceOrder(){
        homePage.shopNewYoga();
        productSearchPage.goToProductDetails("Overnight Duffle");
        productInfoPage.setQty("20");
        productInfoPage.clickAddToCart();
        cartPage.viewCart();
        String actualProductName = cartPage.getProductName();
        Assert.assertEquals(actualProductName,"Overnight Duffle");
        String actualProductQty = cartPage.getProductQty();
        Assert.assertEquals(actualProductQty, "20");
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
        String actualTitle = checkoutPage.getTitle();
        Assert.assertEquals(actualTitle, "Thank you for your purchase!");
    }
}
