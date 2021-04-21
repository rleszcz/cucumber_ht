Feature: Smoke test
  This smoke test contains 8 scenarios for ebay.com website.

  #Scenario: Selects a Polish site of ebay.com.
  #  Given User opens home page.
  #  When User selects Poland out of collapsible list.
  #  Then User is redirected to Polish site.

  #Scenario: Checks if all elements of "My eBay" menu are visible.
  #  Given User opens home page.
  #  When User hovers the mouse cursor over My eBay menu button.
  #  Then All required sections are visible.

  #Scenario: Log-in attempt, directly with login page URL.
  #  Given User opens home page directly.
  #  Then Captcha message is displayed.

  #Scenario: Checks if cart is empty when no additional actions were taken.
  #  Given User opens home page.
  #  When User navigates to cart.
  #  Then Cart is empty.

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