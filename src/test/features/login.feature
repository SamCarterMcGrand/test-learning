Feature: Test login functionality
  Scenario: user should be able to login
    Given user is on login page
    When user enters correct details
    Then user gets confirmation

  Scenario: user fails login
    Given user is on login page
    When user enters incorrect details
    Then user is informed of incorrect details




  Scenario Outline: the user should be able to login
    Given user is on login page
    When the user enters email <username>
    And the user enters password <password>
    And the user clicks login
    Then user gets confirmation

    Examples:
    | username          | password |
    | tim@testemail.com | trpass   |
    | rw@testemail.com  | rwpass   |
    | jv@testemail.com  | jvpass   |



