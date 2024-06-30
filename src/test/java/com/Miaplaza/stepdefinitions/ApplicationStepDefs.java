package com.Miaplaza.stepdefinitions;


import com.Miaplaza.pages.ApplicationPage;
import com.Miaplaza.pages.HomePage;
import io.cucumber.java.en.*;


public class ApplicationStepDefs {

    ApplicationPage application = new ApplicationPage();


    @Given("The user navigates to MOHS Initial Application")
    public void theUserNavigatesToMOHSInitialApplication() {
        application.apply();
    }

    @Given("The user open the Basepage through the link")
    public void theUserOpenTheBasepageThroughTheLink() {
        new HomePage().navigateToOnline();
    }

    @Then("The user fills the form Parent Information")
    public void theUserFillsTheFormParentInformation() {
        application.enterDataForParentApplication();
    }
}
