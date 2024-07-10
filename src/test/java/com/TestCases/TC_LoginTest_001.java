package com.TestCases;

import com.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {
    @Test
    public void loginTest(){
        driver.get(baseURL);
        LoginPage lp = new LoginPage(driver);
        lp.clickLoginEle();
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickSubmit();
        if(driver.getTitle().equals("Naukrigulf")){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }

}
