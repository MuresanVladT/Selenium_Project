package com.luma.tests.login;

import com.luma.base.BaseTest;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);

    //Negative test:

    @Test
    public void testLoginErrorMessage() {
        homePage.clickSignIn();
        loginPage.setEmail("invalid@mail.com");
        loginPage.setPassword("invalidPassword");
        loginPage.clickSignIn();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("The account sign-in was incorrect"));
    }

    //Positive test:

    @Test
    public void successfulLogin(){
        homePage.clickSignIn();
        loginPage.setEmail("test.mail.Test@mail.com");
        loginPage.setPassword("Password1");
        loginPage.clickSignIn();
        String actualMessage = homePage.getLoginMessage();
        Assert.assertTrue(actualMessage.contains("Welcome"));
    }
}
