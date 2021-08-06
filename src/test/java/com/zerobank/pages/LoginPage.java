package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.tools.JavaCompiler;

public class LoginPage {
    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signinButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement userLoginBox;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement userPasswordBox;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submitButton;

    @FindBy(xpath ="//a[@id='proceed-link']" )
    public WebElement proceedLink;

    @FindBy(xpath ="//button[@id='details-button']" )
    public WebElement advancedButton;




    public LoginPage() {
        PageFactory.initElements(Driver.get(),this);
    }
    public void login(){

        signinButton.click();
        userLoginBox.sendKeys(ConfigurationReader.get("username"));
        userPasswordBox.sendKeys(ConfigurationReader.get("password"));

        submitButton.click();
        advancedButton.click();
        proceedLink.click();
    }
}
