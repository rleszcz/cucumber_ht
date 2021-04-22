Feature: Functional test
  This test checks the main actions that can be done on ebay.com.

  #Scenario Outline: Search for an item, add the first result to cart, check if cart is not empty.
  #  Given User opens home page.
  #  When User searches for '<ItemName>'.
  #  And User picks the first result and navigates to cart.
  #  Then Cart is not empty.
  #  Examples:
  #    | ItemName   |
  #    | Lego 42100 |
  #    | Lego 42099 |

  #Scenario Outline: Checks if recently viewed items are displayed.
  #  Given User opens home page.
  #  When User searches for '<ItemName>'.
  #  And User opens any search results.
  #  Then Recently viewed items are displayed on the home page.
  #  Examples:
  #    | ItemName   |
  #    | Lego 42100 |