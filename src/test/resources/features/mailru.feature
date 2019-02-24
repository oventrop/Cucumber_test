Feature: Could we login to mail.ru with credentials?
  Use credentials for mailbox login

  Background: Close browser after each test
    When I start scenario

  Scenario Outline: Successful login
    Given I open browser <browser>
    When I navigate to mail page
    And I fill in credentials and submit
    Then I should login to mailbox

    Examples:
      | browser |
      | chrome |
      | firefox |