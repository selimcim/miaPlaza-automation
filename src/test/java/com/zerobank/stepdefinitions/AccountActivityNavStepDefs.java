package com.zerobank.stepdefinitions;


import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AccountActivityNavStepDefs {
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountLabel) {

        switch (accountLabel){
            case "Savings":
                new AccountSummaryPage().savings.click();
                break;
            case "Brokerage":
                new AccountSummaryPage().brokerage.click();
                break;
            case "Checking":
                new AccountSummaryPage().checking.click();
                break;
            case "Credit Card":
                new AccountSummaryPage().creditCard.click();
                break;
            case "Loan":
                new AccountSummaryPage().loan.click();
                break;
        }

    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        Assert.assertTrue(Driver.get().getTitle().contains("Account Activity"));

    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String dropDownExpected) {
        Select select = new Select(new AccountActivityPage().accountDropdown);
        Assert.assertEquals(dropDownExpected, select.getFirstSelectedOption().getText());

    }
    @When("the user navigates to {string} Page")
    public void the_user_navigates_to_Page(String expectedTitle) {
        new AccountSummaryPage().navigate(expectedTitle);

    }
    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> expected){
        Select select= new Select(new AccountActivityPage().accountDropdown);
        Assert.assertTrue(BrowserUtils.getElementsText(select.getOptions()).containsAll(expected));

    }
    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> expectedColumns) {
        Assert.assertEquals(expectedColumns,BrowserUtils.getElementsText(new AccountActivityPage().transactionsColumns));
    }





}
