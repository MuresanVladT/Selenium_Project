package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.xpath("//input[@id=\"email\"]");
    private By passwordField = By.xpath("//fieldset[@class=\"fieldset login\"]//input[@id=\"pass\"]");
    private By SignInButton = By.xpath("//button[contains(@class, 'action login primary')]");
    private By errorMessage = By.xpath("//div[@class=\"message-error error message\"]");

    public void setEmail(String email){
        set(emailField, email);
    }

    public void setPassword(String password){
        set(passwordField, password);
    }

    public void clickSignIn(){
        click(SignInButton);
    }

    public String getErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return find(errorMessage).getText();
    }
}
