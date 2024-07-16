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

    @FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']")
    WebElement SigninBtn;
    @FindBy(xpath = "//input[@id='email']")
    WebElement userNameTxt;
    @FindBy(xpath = "//input[@name='login[password]']")
    WebElement passwordTxt;
    @FindBy(xpath = "(//button[@id='send2'])[1]")
    WebElement loginBtn;
    @FindBy(xpath = "")
    WebElement logoutBtn;

    public void clickSigninBtn(){
        SigninBtn.click();
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
    public void clickLogout(){
        loginBtn.click();
    }
}
