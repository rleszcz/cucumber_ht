Feature: Captcha test
  This test checks if CAPTCHA verification was added.

  Scenario: Log-in attempt with automated software.
    Given User opens home page.
    When User navigates to login page.
    Then Captcha message is displayed.

  Scenario Outline: Save search attempt with automated software.
    Given User opens home page.
    When User searches for '<ItemName>'.
    And User saves his search.
    Then Captcha message is displayed.
    Examples:
      | ItemName   |
      | Lego 75300 |