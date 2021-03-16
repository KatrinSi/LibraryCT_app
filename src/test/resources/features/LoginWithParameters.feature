@smoke-test
Feature: Login with parameters
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: librarian, student

  Background: User is already on the login page
    Given I am on the login page

  @libWithParam
  Scenario: Login as librarian 49
    When I enter username "email_Librarian49"
    And I enter password 'password_Librarian49'
    And click the sign in button
    Then dashboard should be displayed
    #And there should be 2841 users
      #number can be whatever you have there

  @studWithParam
  Scenario: Login as student 52
    When I enter username "email_Student52"
    And I enter password 'password_Student52'
    And click the sign in button
    Then dashboard should be displayed

  @studSameLine
  Scenario: Login as student 50 same line
    When I login using "email_Student50" and "password_Student50"
    Then dashboard should be displayed

