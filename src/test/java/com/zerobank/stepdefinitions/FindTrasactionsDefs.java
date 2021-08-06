package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

public class FindTrasactionsDefs{
    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new LoginPage().login();
        new AccountSummaryPage().accountActivity.click();
        new AccountActivityPage().findTransations.click();



    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        new FindTransactionsPage().fromDate.sendKeys(fromDate);
        new FindTransactionsPage().toDate.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        new FindTransactionsPage().search.click();
        new FindTransactionsPage().fromDate.clear();
        new FindTransactionsPage().toDate.clear();
        new FindTransactionsPage().description.clear();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        for (String str : BrowserUtils.getElementsText(new FindTransactionsPage().dateColumnData) ) {
            Assert.assertTrue(str.compareTo(fromDate)>=0 & str.compareTo(toDate)<=0);
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        List<String> actualelementsText =BrowserUtils.getElementsText(new FindTransactionsPage().dateColumnData);
        List<String> expectedelementsText =BrowserUtils.getElementsText(new FindTransactionsPage().dateColumnData);

        Collections.sort(expectedelementsText);
        Collections.reverse(expectedelementsText);

        Assert.assertEquals(expectedelementsText,actualelementsText);

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String notInside) {
        List<String> elementsText = BrowserUtils.getElementsText(new FindTransactionsPage().dateColumnData);
        //assert elementsText.contains(notInside);
        Assert.assertFalse(elementsText.contains(notInside));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {

        new FindTransactionsPage().description.sendKeys(string.toUpperCase());

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        for (String str : BrowserUtils.getElementsText(new FindTransactionsPage().descriptionColumnData)) {
            Assert.assertTrue(str.contains(string));

        }

    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {

        for (String str : BrowserUtils.getElementsText(new FindTransactionsPage().descriptionColumnData)) {
            Assert.assertFalse(str.contains(string));

        }
    }
    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {

    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        Select select = new Select(new FindTransactionsPage().typeDropDown);
        select.selectByValue(string);

    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {

    }

}
