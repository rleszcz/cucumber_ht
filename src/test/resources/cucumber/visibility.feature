Feature: Visibility test
  This test checks if all required components are present.

  Scenario: Checks if all elements of "My eBay" menu are visible.
    Given User opens home page.
    When User hovers the mouse cursor over My eBay menu button.
    Then All required sections are visible.

    Scenario: Checks if "Advanced" search button is present.
      Given User opens home page.
      Then Advanced search button is present.