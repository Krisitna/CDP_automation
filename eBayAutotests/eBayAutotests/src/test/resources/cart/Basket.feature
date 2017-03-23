Feature: Shopping Cart Functionality Feature

  Scenario: The customer will be able to add product to cart
    Given The homepage is loaded
    When I quick seacrch for "5D Diamond Embroidery Painting Owl"
    And I click on the product link
    And I add the item to my cart
    Then The added product is displayed in my cart

  Scenario: The customer to be able to add several the same products to the cart
    Given The homepage is loaded
    When I quick seacrch for "5D Diamond Embroidery Painting Owl"
    And I click on the product link
    And I set the quantity of item is 2
    And I add the item to my cart
    Then The quantity of product is 2 in my cart

  Scenario: The customer to be able to remove product from the cart
    Given The homepage is loaded
    When I quick seacrch for "5D Diamond Embroidery Painting Owl"
    And I click on the product link
    And I add the item to my cart
    And I click on the remove button on cart
    Then The product is not displayed in my cart

  Scenario: Customer should be taken to previous listing page when he clicks Continue Shopping
    Given The homepage is loaded
    When I quick seacrch for "5D Diamond Embroidery Painting Owl"
    And I click on the product link
    And I add the item to my cart
    And I click on the continue shopping button on the cart page
    Then The previous listing page is dispplayed

  Scenario Outline: Customer should be taken to product detailed page form the cart page
    Given The homepage is loaded
    When I quick seacrch for "5D Diamond Embroidery Painting Owl"
    And I click on the product link
    And I add the item to my cart
    And I click on "<product element>" on the cart page
    Then The product detailed page is displayed
   
    Examples: 
      | product element |
      | product image   |
      | product name    |
