Feature: Product ordering

  @registratedUser
  Scenario Outline: Going through the product ordering process
    Given User is on the "https://mystore-testlab.coderslab.pl" page
    When User logs into his account with "<email>" and  "<password>"
    And User selects the product "Hummingbird Printed Sweater"
    And User checks if the discount is 20%
    And User selects the "<size>"
    And User selects the "<number>" of pieces
    And User adds products to the cart
    And User proceeds to checkout option
    And User confirms address ("<name>", "<address>", "<city>", "<postalCode>", "<country>")
    And User selects the shipping method
    And User selects the payment method
    And User clicks on "order with an obligation to pay"
    And User takes a screenshot of the order confirmation and the amount.
    And User enters order history and details
    Then User checks if the order is listed with the status "Awaiting check payment" and the same amount as on the order two steps earlier
    Examples:
      | email              | password                | size | number | name       | address        | city        | postalCode | country        |
      | adamnowak@test.com | adamnowakrandompassword | S    | 10     | Adam Nowak | Random Address | Random City | 12345      | United Kingdom |
      | adamnowak@test.com | adamnowakrandompassword | M    | 3      | Adam Nowak | Random Address | Random City | 12345      | United Kingdom |
      | adamnowak@test.com | adamnowakrandompassword | XL   | 15     | Adam Nowak | Random Address | Random City | 12345      | United Kingdom |



