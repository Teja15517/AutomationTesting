package com.TestCases;

import com.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {
    @Test
    public void loginTest() throws IOException {

        LoginPage lp = new LoginPage(driver);
        lp.clickSigninBtn();
        lp.setUserName(username);
        logger.info("entered username");
        lp.setPassword(password);
        logger.info("entered password");
        lp.clickSubmit();
        if(driver.getTitle().equals("Home Page")){
            Assert.assertTrue(true);
            logger.info("test passed");
        }
        else {
            captureScreenshot(driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("test failed");
        }
    }

}
