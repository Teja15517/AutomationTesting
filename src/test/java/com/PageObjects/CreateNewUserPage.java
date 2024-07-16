package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUserPage {
    WebDriver ldriver;
    public CreateNewUserPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @CacheLookup
    @FindBy(how = How.XPATH, using = "//a[@href='https://magento.softwaretestingboard.com/customer/account/create/' and text()='Create an Account']")
    WebElement createAccountLnk;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@id='firstname']")
    WebElement firstNameTxt;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@id='lastname']")
    WebElement lastNameTxt;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@id='email_address']")
    WebElement emailTxt;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    WebElement passwordTxt;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@id='Confirm Password']")
    WebElement confirmPasswordTxt;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//button[@title='Create an Account']")
    WebElement createAccountBtn;

    public void ClickCreateAccountLink() {
        createAccountLnk.click();
    }
    public void SetFirstName(String fname) {
        firstNameTxt.sendKeys(fname);
    }
    public void SetLastName(String lname) {
        lastNameTxt.sendKeys(lname);
    }
    public void SetEmail(String email) {
        emailTxt.sendKeys(email);
    }
    public void SetPassword(String password) {
        emailTxt.sendKeys(password);
    }
    public void SetConfirmPassword(String password) {
        confirmPasswordTxt.sendKeys(password);
    }
    public void ClickCreateAccount() {
        createAccountBtn.click();
    }
    }
