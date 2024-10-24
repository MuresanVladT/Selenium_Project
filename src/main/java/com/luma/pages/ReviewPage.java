package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReviewPage extends BasePage {
    public ReviewPage(WebDriver driver) {
        super(driver);
    }

    private final By addReviewButton = By.xpath("//a[normalize-space()=\"Add Your Review\"]");
    private final By nicknameField = By.xpath("//*[@id='nickname_field']");
    private final By summaryField = By.xpath("//*[@id='summary_field']");
    private final By reviewField = By.xpath("//*[@id='review_field']");
    private final By submitReviewButton = By.xpath("//button[contains(@class, 'submit')]");
    private final By confirmationMessage = By.xpath("//div[@class=\"message-success success message\"]");


    public void clickAddReview() {
        click(addReviewButton);
    }

    public void selectRating(int stars) {
        WebElement ratingButton = driver.findElement(By.xpath("//*[@id='Rating_" + stars + "']"));
        forceClick(ratingButton);
    }

    public void setNickname(String nickname) {
        set(nicknameField, nickname);
    }

    public void setSummary(String summary) {
        set(summaryField, summary);
    }

    public void setReview(String review) {
        set(reviewField, review);
    }

    public void clickSubmitReview() {
        find(submitReviewButton).click();
    }

    public String getConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
    }
}
