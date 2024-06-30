package com.Miaplaza.pages;

import com.Miaplaza.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(css = ".mia-announcementText a")
    public static WebElement onlineHighSchool;

    @FindBy(xpath = "//*[@class='mia-link0']")
    public static WebElement childLogin;

    @FindBy(xpath = "//*[@class='mia-link1']")
    public static WebElement parentLogin;
    @FindBy(xpath = "//*[@class='mia-motto']")
    public static WebElement header;


    public void navigateToOnline() {
        String expected = "Learning, Fun & Friends for Kids!";
        String actual = BrowserUtils.getText(header);
        Assert.assertEquals(expected, actual);
        onlineHighSchool.click();

    }


}


