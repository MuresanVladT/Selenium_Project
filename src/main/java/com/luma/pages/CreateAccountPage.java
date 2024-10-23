package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountPage extends BasePage{
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameField = By.xpath("//input[@id=\"firstname\"]");
    private final By lastNameField = By.xpath("//input[@id=\"lastname\"]");
    private final By emailField = By.xpath("//input[@id=\"email_address\"]");
    private final By passwordField = By.xpath("//input[@id=\"password\"]");
    private final By confirmPasswordField = By.xpath("//input[@id=\"password-confirmation\"]");
    private final By createAccountButton = By.xpath("//button[contains(@title, \"Create an Account\")]");
    private final By successMessage = By.xpath("//div[@class=\"message-success success message\"]");
    private final By emailErrorMessage = By.xpath("//div[@id=\"email_address-error\"]");
    private final By passwordConfirmationError = By.xpath("//div[@id=\"password-confirmation-error\"]");

    public void setFirstName(String firstName){
        set(firstNameField, firstName);
    }

    public void setLastName(String lastName){
        set(lastNameField, lastName);
    }

    public void setEmail(String email){
        set(emailField, email);
    }

    public void setPassword(String password){
        set(passwordField, password);
    }

    public void confirmPassword(String password){
        set(confirmPasswordField, password);
    }

    public void setPasswordAndConfirm(String password){
        set(passwordField, password);
        set(confirmPasswordField, password);
    }

    public void clickCreateAccount(){
        click(createAccountButton);
    }

    public String getSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return find(successMessage).getText();
    }

    public String getEmailError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailErrorMessage));
        return find(emailErrorMessage).getText();
    }

    public String getPasswordError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordConfirmationError));
        return find(passwordConfirmationError).getText();
    }
}
