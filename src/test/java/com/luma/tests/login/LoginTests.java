package com.luma.tests.login;

import com.luma.base.BaseTest;
import org.junit.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

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
}
