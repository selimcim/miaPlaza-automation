package com.Miaplaza.pages;

import com.Miaplaza.utilities.BrowserUtils;
import com.Miaplaza.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class ApplicationPage extends BasePage {
    @FindBy(xpath = "(//*[@id=\"Name-li\"]//input)[2]")
    public WebElement lastName;

    @FindBy(xpath = "(//*[@id=\"Name-li\"]//input)[1]")
    public WebElement firstName;

    @FindBy(id = "Email-arialabel")
    public WebElement email;

    @FindBy(id = "PhoneNumber")
    public WebElement phoneNumber;

    @FindBy(id = "getElement")
    public WebElement date;

    @FindBy(xpath = "//*[@class='select2FormFont']")
    private WebElement dd;

    Select dropDown = new Select(dd);


    private Map<String, String> dataMap;
    private String firstname;
    private String lastname;
    private String emailadd;
    private String phone;

    private String option;

    private List siteList = new ArrayList<>();
    private String startdate;

    public ApplicationPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    public void enterDataForParentApplication() {
        this.dataMap = BrowserUtils.getData("ParentInfo");

        //get all data
        this.firstname = dataMap.get("firstname");
        this.lastname = dataMap.get("lastname");
        this.emailadd = dataMap.get("email");
        this.phone = dataMap.get("phone");
        this.option = dataMap.get("option");
        this.siteList = Arrays.asList(dataMap.get("siteList").split(","));
        this.startdate = dataMap.get("startdate");

        enterUserDetails(firstname, lastname, emailadd, phone, option, siteList, startdate);

    }

    public void enterUserDetails(
            String name, String lastname, String emailaddress, String phone, String yesNO, List<String> siteList, String startDate) {

        firstName.sendKeys(name);
        lastName.sendKeys(lastname);
        email.sendKeys(emailaddress);
        phoneNumber.sendKeys(phone);
        dropDown.selectByVisibleText(yesNO);
        BrowserUtils.selectHear(siteList);
        date.sendKeys(startDate);


    }

}
