Feature: Search functionality on the Users page
  As a user, I should be able to login as librarian. When I go to Users page, table should see following columns:
  • Actions
  • UserID
  • Full Name
  • Email
  • Group
  • Status

  Background: User is already on the login page
    Given I am on the login page

  @tableColumnsNames
  Scenario: Table columns names
    And I login as a librarian
    And I click on "Users" link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |