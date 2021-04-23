Feature: Localization test
  This test navigates to a different sites of ebay.com.

  Scenario: Selects Polish site of ebay.com.
    Given User opens home page.
    When User selects Poland out of collapsible list.
    Then User is redirected to Polish site.

  Scenario: Selects UK site of ebay.com.
    Given User opens home page.
    When User selects United Kingdom out of collapsible list.
    Then User is redirected to UK site.