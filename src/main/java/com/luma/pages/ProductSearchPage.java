package com.luma.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductSearchPage extends BasePage {
    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

    private By productItems = By.className("product-item-info");
    private By productLink = By.className("product-item-link");
    private By nextPageButton = By.xpath("(//a[contains(@title,'Next')])[2]");
    private By productList = By.xpath("//ol[@class='products list items product-items']");

    public WebElement nextPageButton() {
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(nextPageButton));
        return find(nextPageButton);
    }

    public List<WebElement> getCardItems() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productItems));
    }

    public boolean isNextProductsPageDisplayed() {
        try {
            return nextPageButton().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void goToProductDetails(String productName) {
        boolean isFound = false;

        while (!isFound) {
            waitForPageToLoad();
            List<WebElement> products = getCardItems();

            for (WebElement product : products) {
                WebElement productNameElement = product.findElement(productLink);
                String crtProductName = productNameElement.getText().trim();
                if (crtProductName.equals(productName)) {
                    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
                    wait.until(ExpectedConditions.elementToBeClickable(productNameElement));
                    productNameElement.click();
                    isFound = true;
                    break;
                }
            }
            if (!isFound && !isNextProductsPageDisplayed()) {
                break;
            }
            if (!isFound && isNextProductsPageDisplayed()) {
                click(nextPageButton);
                waitForPageToLoad();
            }
        }
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productList));
    }
}
