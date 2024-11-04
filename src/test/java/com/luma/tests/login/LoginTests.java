package com.luma.tests.login;

import com.luma.base.BaseTest;
import com.luma.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    protected static LoginPage loginPage;

    //Negative test:

    @Test
    public void testLoginErrorMessage() {
        homePage.clickSignIn();
        loginPage = new LoginPage(driver);
        loginPage.setEmail("invalid@mail.com");
        loginPage.setPassword("invalidPassword");
        loginPage.clickSignIn();
        Assert.assertTrue(loginPage.getErrorMessage().contains("The account sign-in was incorrect"));
    }

    //Positive test:

    @Test
    public void successfulLogin(){
        homePage.clickSignIn();
        loginPage = new LoginPage(driver);
        loginPage.setEmail("test.mail.Test@mail.com");
        loginPage.setPassword("Password1");
        loginPage.clickSignIn();
        Assert.assertTrue(homePage.getLoginMessage().contains("Welcome"));
    }
}
