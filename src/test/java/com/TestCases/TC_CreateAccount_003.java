package com.TestCases;

import com.PageObjects.CreateNewUserPage;
import com.PageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

import java.io.IOException;

public class TC_CreateAccount_003 extends BaseClass {

    public void createAccount() throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("username entered");
        lp.setPassword(password);
        logger.info("password entered");
        lp.clickSubmit();

        Thread.sleep(3000);
        CreateNewUserPage createAccount = new CreateNewUserPage(driver);
        createAccount.ClickCreateAccountLink();
        createAccount.SetFirstName("teja");
        createAccount.SetLastName("kiran");

        String email = randomString()+"gmail.com";
        createAccount.SetEmail(email);
        createAccount.SetPassword("Teja@15517");
        createAccount.SetConfirmPassword("Teja@15517");
        logger.info("entered all the user details");
        createAccount.ClickCreateAccount();

        Thread.sleep(5000);
        boolean result =driver.getPageSource().contains("Account created Successfully");
        if(result==true){
            Assert.assertTrue(true);
            logger.info("test passed");
        }
        else {
            captureScreenshot(driver, "CreateNewAccount");
            logger.info("screenshot taken");
            Assert.assertTrue(false);
            logger.info("test failed");
        }
    }

}
