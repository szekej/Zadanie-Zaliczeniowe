Feature: Mystore addresses

  @registratedUser
  Scenario Outline: Checking the add and delete address function to an already created user account
    Given User is on "https://mystore-testlab.coderslab.pl" page
    When User logs into his account with "<email>" and "<password>"
    And User clicks on address field
    And User clicks on "Create new address" field
    And User fills out the form with "<alias>", "<address>", "<city>", "<zipCode>", "<country>", "<phone>"
    And User checks that the data in the added address is correct
    And User deletes the above address by clicking on "delete"
    Then Address has been removed

    Examples:
      | email              | password                | alias           | address             | city        | zipCode | country        | phone      |
      | adamnowak@test.com | adamnowakrandompassword | My New Address  | 131 Elk Creek Road  | Villa Rica  | 30180   | United Kingdom | 7704596044 |
      | adamnowak@test.com | adamnowakrandompassword | My New Address2 | 188 Elk Random Road | Puerto Rico | 90210   | United Kingdom | 7704596040 |
      | adamnowak@test.com | adamnowakrandompassword | My New Address3 | 190 Elk Test Road   | Test City   | 88900   | United Kingdom | 7704596042 |