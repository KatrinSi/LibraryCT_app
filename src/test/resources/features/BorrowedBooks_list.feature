Feature: Borrowed books list feature
  As a student I should be able to see my list of borrowed books

  Background: User is already on the login page
    Given User is on the login page

  @1
  Scenario Outline: User can see the list all borrowed books
    When User logs in using "<email>" and "<password>"
    And User goes to the Borrowing Book page
    And User's name is "<name>"
    Then User can see the list of his borrowed books

    @students
    Examples:
      | email             | password | name            |
      | student50@library | doN2rYs3 | Test Student 50 |
      | student51@library | Hab4pCHI | Test Student 51 |
      | student52@library | l43OOwss | Test Student 52 |







