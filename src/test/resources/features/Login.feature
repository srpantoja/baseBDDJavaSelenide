Feature: Login functionality
  As a user
  I want to be able to log in to the system
  So that I can access my account

  Background:
    Given that the user is on the login page

  Scenario Outline: Successful login
    When the user enters a "<email>" and a "<password>"
    And clicks on the login button
    Then the system redirects to the main page
    And displays a welcome message to the user "<name>"

    Examples:
      | email               | password | name      |
      | testejean@gmail.com | jean     | testejean |

  Scenario Outline: Unsuccessfully login
    When the user enters a "<email>" and a "<password>"
    And clicks on the login button
    Then the system displays an error message "<scenario>"
    And remains on the login page

    Examples:
      | scenario                 | email                   | password          |
      | Invalid email            | invalidemail            | jean              |
      | Incomplete email         | invalidemail@           | jean              |
      | Email not registered     | notregistered@gmail.com | jean              |
      | Incorrect password       | testjean@gmail.com      | incorrectpassword |
      | Blank email and password |                         |                   |

