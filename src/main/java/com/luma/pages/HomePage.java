package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By greetWelcome = By.xpath("div[class=\"panel header\"] li[class=\"greet welcome\"]");
    private By signInLink = By.xpath("//div[@class=\"panel header\"]//a[contains(text(),\"Sign In\")]");
    private By createAccountLink = By.xpath("//div[@class=\"panel header\"]//a[normalize-space()=\"Create an Account\"]");

    public boolean isGreetWelcomeTextDisplayed() {
        return find(greetWelcome).isDisplayed();
    }

    public void clickSignIn() {
        click(signInLink);
    }

    public void clickCreateAccount() {
        click(createAccountLink);
    }
}
