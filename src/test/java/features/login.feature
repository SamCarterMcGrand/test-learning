Feature: Test login functionality
  Scenario: user should be able to login
    Given user is on login page
    When user enters correct details
    Then user gets confirmation