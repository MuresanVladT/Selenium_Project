package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By signInLink = By.xpath("//div[@class=\"panel header\"]//a[contains(text(),\"Sign In\")]");
    private final By createAccountLink = By.xpath("//div[@class=\"panel header\"]//a[normalize-space()=\"Create an Account\"]");
    private final By greetWelcome = By.cssSelector("div[class=\"panel header\"] span[class=\"logged-in\"]");
    private final By shopYogaButton = By.xpath("//span[@class=\"action more button\"]");
    private final By menTab = By.xpath("//*[@id='ui-id-5']");
    private final By menTops = By.xpath("//*[@id='ui-id-17']");
    private final By menJackets = By.xpath("//*[@id='ui-id-19']");
    private final By whatsNewTab = By.cssSelector("#ui-id-3");
    private final By gearTab = By.cssSelector("#ui-id-6");
    private final By watchesTab = By.cssSelector("#ui-id-27");

    public boolean isGreetWelcomeTextDisplayed() {
        return find(greetWelcome).isDisplayed();
    }

    public void clickSignIn() {
        click(signInLink);
    }

    public void clickCreateAccount() {
        click(createAccountLink);
    }

    public String getLoginMessage(){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(greetWelcome,"Welcome, "));
        return find(greetWelcome).getText();
    }

    public void shopNewYoga(){
        click(shopYogaButton);
    }

    public void goToMenTops(){
        hooverOverElement(menTab);
        hooverOverElement(menTops);
    }

    public void goToMenJackets(){
        goToMenTops();
        find(menJackets).click();
    }

    public void clickWhatsNew(){
        find(whatsNewTab).click();
    }

    public void goToWatches(){
        hooverOverElement(gearTab);
        find(watchesTab).click();
    }
}
