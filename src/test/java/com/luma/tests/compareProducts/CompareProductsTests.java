package com.luma.tests.compareProducts;

import com.luma.base.BaseTest;
import com.luma.pages.CompareProductsPage;
import com.luma.pages.HomePage;
import com.luma.pages.ProductInfoPage;
import com.luma.pages.ProductSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareProductsTests extends BaseTest {

    protected static ProductSearchPage productSearchPage;
    protected static ProductInfoPage productInfoPage;
    protected static CompareProductsPage compareProductsPage;

    @Test
    public void compare2ProductsTest(){
        homePage.goToWatches();
        productSearchPage = new ProductSearchPage(driver);
        productSearchPage.goToProductDetails("Summit Watch");
        productInfoPage = new ProductInfoPage(driver);
        productInfoPage.addToCompare();
        homePage.goToWatches();
        productSearchPage.goToProductDetails("Dash Digital Watch");
        productInfoPage.addToCompare();
        compareProductsPage = new CompareProductsPage(driver);
        compareProductsPage.clickCompareProducts();
        Assert.assertEquals(compareProductsPage.getFirstProductName(), "Summit Watch");
        Assert.assertEquals(compareProductsPage.getSecondProductName(), "Dash Digital Watch");
    }
}
