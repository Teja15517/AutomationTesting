package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver ldriver;
    public LoginPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//a[@href='https://www.naukrigulf.com/jobseeker/login']")
    WebElement loginEle;

    @FindBy(xpath = "//input[@id='loginModalLoginEmail']")
    WebElement userNameTxt;

    @FindBy(xpath = "//input[@id='loginPassword']")
    WebElement passwordTxt;

    @FindBy(xpath = "//button[@id='loginModalLoginSubmit']")
    WebElement loginBtn;

    public void clickLoginEle(){
        loginEle.click();
    }

    public void setUserName(String uname) {
        userNameTxt.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        passwordTxt.sendKeys(pwd);
    }
    public void clickSubmit() {
        loginBtn.click();
    }
}
