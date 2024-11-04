package com.luma.tests.productReview;

import com.luma.base.BaseTest;
import com.luma.pages.ProductSearchPage;
import com.luma.pages.ReviewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductReviewTests extends BaseTest {

    protected static ProductSearchPage productSearchPage;
    protected static ReviewPage reviewPage;

    @Test

    public void createAndSubmitReview() {
        homePage.goToMenJackets();
        productSearchPage = new ProductSearchPage(driver);
        productSearchPage.goToProductDetails("Taurus Elements Shell");
        reviewPage = new ReviewPage(driver);
        reviewPage.clickAddReview();
        reviewPage.selectRating(3);
        reviewPage.setNickname("TestNickname");
        reviewPage.setSummary("TestSummary");
        reviewPage.setReview("TestReview");
        reviewPage.clickSubmitReview();
        Assert.assertEquals(reviewPage.getConfirmationMessage(), "You submitted your review for moderation.");
    }
}
