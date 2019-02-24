Feature: Could we login to mail.ru with credentials?
  Use credentials for mailbox login

  Scenario: Successful login
    Given I navigate to mail page
    When I fill in credentials and submit
    Then I should login to mailbox