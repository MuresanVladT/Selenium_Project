package com.luma.tests.compareProducts;

import com.luma.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareProductsTests extends BaseTest {


    @Test
    public void compare2ProductsTest(){

        homePage.goToWatches();
        productSearchPage.goToProductDetails("Summit Watch");
        productInfoPage.addToCompare();
        homePage.goToWatches();
        productSearchPage.goToProductDetails("Dash Digital Watch");
        productInfoPage.addToCompare();
        compareProductsPage.clickCompareProducts();
        Assert.assertEquals(compareProductsPage.getFirstProductName(), "Summit Watch");
        Assert.assertEquals(compareProductsPage.getSecondProductName(), "Dash Digital Watch");
    }
}
