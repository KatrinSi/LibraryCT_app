@smoke-test
Feature: Login feature
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: librarian, student

  Background: User is already on the login page
    Given I am on the login page

@librarian
  Scenario: Login as a librarian
    When I login as a librarian
    Then dashboard should be displayed

@student
  Scenario: Login as a student
    When I login as a student
    Then dashboard should be displayed
