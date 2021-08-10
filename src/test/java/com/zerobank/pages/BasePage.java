package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//a[text()='Account Summary']")
    public WebElement accountSummary;
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//a[text()='Account Activity']")
    public WebElement accountActivity;
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//a[text()='Transfer Funds']")
    public WebElement transferfunds;
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//a[text()='Pay Bills']")
    public WebElement payBills;
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//a[text()='My Money Map']")
    public WebElement myMoneyMap;
    @FindBy(xpath = "//ul[@class='nav nav-tabs']//a[text()='Online Statements']")
    public WebElement onlineStatements;

    @FindBy(xpath = "(//li[@class='dropdown'])[2]")
    public WebElement userName;

    @FindBy(xpath = "(//li[@class='dropdown'])[1]")
    public WebElement settings;

    @FindBy(css = "#logout_link")
    public WebElement logOutLink;

    @FindBy(css = "#searchTerm")
    public WebElement searchBox;



    public String getUserName(){
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }

    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }
    public void search(String item){
        searchBox.sendKeys(item+ Keys.ENTER);
    }

    public void navigate(String tab){
        switch (tab){
            case "Account Activity":
                new AccountSummaryPage().accountActivity.click();
                break;
            case "Account Summary":
                new AccountSummaryPage().accountSummary.click();
                break;
            case "Transfer Funds":
                new AccountSummaryPage().transferfunds.click();
                break;
            case "Pay Bills":
                new AccountSummaryPage().payBills.click();
                break;
            case "My Money Map":
                new AccountSummaryPage().myMoneyMap.click();
                break;
            case "Online Statements":
                new AccountSummaryPage().onlineStatements.click();
                break;

        }

    }
}
