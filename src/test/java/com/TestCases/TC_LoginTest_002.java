package com.TestCases;

import com.PageObjects.LoginPage;
import com.Utilities.XLUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_002 extends BaseClass{
    @Test(dataProvider = "LoginData")
    public void LoginDDT(String user, String pwd){
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(user);
        lp.setPassword(pwd);
        lp.clickSubmit();

        if (isAlertPresent()==true){
            driver.switchTo().alert().accept(); //close alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warning("login failed");
        }
        else {
            Assert.assertTrue(true);
            logger.info("Login passed");
            lp.clickLogout();
            driver.switchTo().alert().accept();  //close logout alert
            driver.switchTo().defaultContent();
        }
    }

    public boolean isAlertPresent(){  //user defined method
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e){
            return false;
        }
    }

    @DataProvider(name="LoginData")
    String [][] getData() throws IOException {
      String path = System.getProperty("user.dir")+"/src/test/java/com/TestData/AutoTestData.xlsx";
      int rownum = XLUtils.getRowCount(path, "Sheet1");
      int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

      String logindata[][] = new String[rownum][colcount];

      for (int i=1;i<=rownum;i++){
          for (int j=0;j<colcount;j++){
              logindata[i-1][j] = XLUtils.getCellData(path,"sheet1",i,j);
          }
      }
      return logindata;
    }
}