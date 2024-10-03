package com.luma.tests.createAccount;

import com.luma.base.BaseTest;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends BaseTest {

    //Positive test:

    @Test
    public void createNewAccount(){
        homePage.clickCreateAccount();
        createAccountPage.setFirstName(basePage.uniqueName());
        createAccountPage.setLastName(basePage.uniqueName());
        createAccountPage.setEmail(basePage.uniqueEmail());
        createAccountPage.setPasswordAndConfirm(basePage.uniquePassword());
        createAccountPage.clickCreateAccount();
        String actualMessage = createAccountPage.getSuccessMessage();
        Assert.assertTrue(actualMessage.contains("Thank you for registering"));
    }

    //Negative tests:

    //Invalid Email Address:

    @Test
    public void createNewAccountInvalidEmail(){
        homePage.clickCreateAccount();
        createAccountPage.setFirstName(basePage.uniqueName());
        createAccountPage.setLastName(basePage.uniqueName());
        createAccountPage.setEmail("EmailAddress");
        createAccountPage.setPasswordAndConfirm(basePage.uniquePassword());
        createAccountPage.clickCreateAccount();
        String actualMessage = createAccountPage.getEmailError();
        Assert.assertTrue(actualMessage.contains("Please enter a valid email address"));
    }

    //Incorrect password confirmation:

    @Test
    public void createNewAccountWrongConfirmation(){
        homePage.clickCreateAccount();
        createAccountPage.setFirstName(basePage.uniqueName());
        createAccountPage.setLastName(basePage.uniqueName());
        createAccountPage.setEmail(basePage.uniqueEmail());
        createAccountPage.setPassword("Password1");
        createAccountPage.confirmPassword("Password");
        createAccountPage.clickCreateAccount();
        String actualMessage = createAccountPage.getPasswordError();
        Assert.assertTrue(actualMessage.contains("Please enter the same value"));
    }
}
