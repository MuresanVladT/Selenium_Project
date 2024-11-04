package com.luma.tests.addToCart;

import com.luma.base.BaseTest;
import com.luma.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderTests extends BaseTest {

    protected static HomePage homePage;
    protected static ProductSearchPage productSearchPage;
    protected static ProductInfoPage productInfoPage;
    protected static CartPage cartPage;
    protected static CheckoutPage checkoutPage;

    // Place an order for a simple product.

    @Test
    public void addToCartAndPlaceOrder() {
        homePage = new HomePage(driver);
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
        cartPage.proceedToCheckout();
        checkoutPage = new CheckoutPage(driver);
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
        homePage = new HomePage(driver);
        homePage.shopNewYoga();
        productSearchPage = new ProductSearchPage(driver);
        productSearchPage.goToProductDetails("Helena Hooded Fleece");
        productInfoPage = new ProductInfoPage(driver);
        productInfoPage.setQty("4");
        productInfoPage.selectSize("M");
        productInfoPage.selectColor("Blue");
        productInfoPage.clickAddToCart();
        cartPage = new CartPage(driver);
        cartPage.viewCart();
        Assert.assertEquals(cartPage.getProductName(), "Helena Hooded Fleece");
        Assert.assertEquals(cartPage.getProductQty(), "4");
        Assert.assertEquals(cartPage.getSize(), "M");
        Assert.assertEquals(cartPage.getColor(), "Blue");
        cartPage.proceedToCheckout();
        checkoutPage = new CheckoutPage(driver);
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
