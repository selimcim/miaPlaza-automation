package com.Miaplaza.pages;

import com.Miaplaza.utilities.BrowserUtils;
import com.Miaplaza.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "menu-item-2970")
    public WebElement aboutTheCompany;

    @FindBy(id = "menu-item-2972")
    public WebElement missionAndValues;

    @FindBy(id = "menu-item-2971")
    public WebElement curriculum;

    @FindBy(xpath = "//*[@class='wp-block-button']")
    public static WebElement applyToOurSchoolButton;


    public void apply() {
        applyToOurSchoolButton.click();

    }

    public void navigate(String tab) {
        switch (tab) {
            case "About The Company":
                aboutTheCompany.click();
                break;
            case "Mission And Values":
                missionAndValues.click();
                break;
            case "Curriculum":
                curriculum.click();
                break;


        }

    }
}
