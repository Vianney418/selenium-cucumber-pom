Feature: Add Address

  @TEST1
  Scenario: Add the address for purchase deliveries
    Given login to the jumbo website "https://www.jumbo.cl/"
    When Click on: Select a delivery method
    And Click on: Create an address
    And Write address "Bombero Guillermo Grebe 355, Llanquihue, Puerto Montt, Chile"
    And Write house number "355"
    And White name the address "My Home"
    And White additional instructions "gray gate"
    And Click on: Add Address button
    And Select Added Address
    And Click on: the confirm button
    Then validate that the address is on the button "Bombero Guillermo Greb..."
