package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountActivityPage extends BasePage{
    @FindBy(xpath = "//select[@name='accountId']")
    public WebElement accountDropdown;
    @FindBy(xpath = "//a[text()='Show Transactions']")
    public WebElement showTransations;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    public WebElement findTransations;

}
