@wip
Feature: Navigating to Apply to Our School Page

  Background:
    Given  The user open the Basepage through the link

  Scenario: Testing the parent information page
    Given  The user navigates to MOHS Initial Application
    Then The user fills the form Parent Information
    And The user navigates to the student information page