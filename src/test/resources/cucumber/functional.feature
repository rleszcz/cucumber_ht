Feature: Functional test
  This test checks the main actions that can be done on ebay.com.

  Scenario: Checks if cart is empty when no additional actions were taken.
    Given User opens home page.
    When User navigates to cart.
    Then Cart is empty.

  Scenario Outline: Search for an item, add the first result to cart, check if cart is not empty.
    Given User opens home page.
    When User searches for '<ItemName>'.
    And User picks the first result and navigates to cart.
    Then Cart is not empty.
    Examples:
      | ItemName   |
      | Lego 75301 |

  Scenario Outline: Checks if recently viewed items are displayed.
    Given User opens home page.
    When User searches for '<ItemName>'.
    And User opens any search results.
    Then Recently viewed items are displayed on the home page.
    Examples:
      | ItemName   |
      | Lego 75301 |

  Scenario Outline: Checks that a negative number of items cannot be added to the cart.
    Given User opens home page.
    When User searches for '<ItemName>'.
    And User opens any search results.
    And User enters a negative number of '<Quantity>'.
    Then Error message is displayed.
    Examples:
      | ItemName   | Quantity |
      | Lego 75301 | -5       |
      | Lego 75301 | -9999    |

  Scenario Outline: Search for an item, add it and then remove it from cart, check if cart is empty.
    Given User opens home page.
    When User searches for '<ItemName>'.
    And User picks the first result and navigates to cart.
    And User removes the only item from cart.
    Then Cart is empty.
    Examples:
      | ItemName   |
      | Lego 75301 |