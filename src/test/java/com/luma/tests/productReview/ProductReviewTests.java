package com.luma.tests.productReview;

import com.luma.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductReviewTests extends BaseTest {

    @Test
    public void createAndSubmitReview(){
        homePage.goToMenJackets();
        productSearchPage.goToProductDetails("Taurus Elements Shell");
        reviewPage.clickAddReview();
       reviewPage.selectRating(3);
        reviewPage.setNickname("TestNickname");
        reviewPage.setSummary("TestSummary");
        reviewPage.setReview("TestReview");
        reviewPage.clickSubmitReview();
        Assert.assertEquals(reviewPage.getConfirmationMessage(), "You submitted your review for moderation.");
    }
}
