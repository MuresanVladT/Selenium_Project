package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By emailField = By.xpath("//div[@class='control _with-tooltip']//input[@id='customer-email']");
    private final By firstNameField = By.xpath("//input[contains(@name, \"firstname\")]");
    private final By lastNameField = By.xpath("//input[contains(@name, \"lastname\")]");
    private final By streetField = By.xpath("//*[contains(@name, \"street[0]\")]");
    private final By cityField = By.xpath("//input[contains(@name, \"city\")]");
    private final By stateField = By.xpath("//select[contains(@name, \"region_id\")]");
    private final By zipField = By.xpath("//input[contains(@name, \"postcode\")]");
    private final By phoneNumberField = By.xpath("//input[contains(@name, \"telephone\")]");
    private final By shippingOption1 = By.cssSelector("input[value='tablerate_bestway']");
    private final By shippingOption2 = By.cssSelector("input[value='flatrate_flatrate']");
    private final By nextButton = By.xpath("//button[@class='button action continue primary']");
    private final By placeOrderButton = By.cssSelector("button[title='Place Order']");
    private final By confirmationTitle = By.xpath("//h1[@class='page-title']");
    private final By continueShoppingButton = By.cssSelector("a[class='action primary continue'] span");

    public void setEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        set(emailField, email);
    }

    public void setFirstName(String firstName) {
        set(firstNameField, firstName);
    }

    public void setLastName(String lastName) {
        set(lastNameField, lastName);
    }

    public void setStreet(String street) {
        set(streetField, street);
    }

    public void setCity(String city) {
        set(cityField, city);
    }

    public void selectState(String stateName) {
        WebElement selectField = find(stateField);
        Select dropdown = new Select(selectField);
        dropdown.selectByVisibleText(stateName);
    }

    public void setZip(String zip) {
        set(zipField, zip);
    }

    public void setPhoneNumber(String phoneNumber) {
        set(phoneNumberField, phoneNumber);
    }

    public void setShipping(int option){
        switch (option){
            case 1:
                find(shippingOption1).click();
                break;
            case 2:
                find(shippingOption2).click();
                break;
        }
    }

    public void clickNext(){
        click(nextButton);
    }

    public void clickPlaceOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        click(placeOrderButton);
    }

    public String getTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationTitle)).getText();
    }
}
