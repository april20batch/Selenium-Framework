Feature: E2E Test case
  
  Background:
  Given Navigate to baseUrl 
  
  @Regression
  Scenario Outline: Positive E2E test scenario
    Given Login with username <name> and password <password> 
    When added product <product> to cart and checkout
    Then verify the details "***"

    Examples: 
      | name  								| password	| product  	 |
      | kidovo5318@em2lab.com | QAFOX@123 | Nikon D300 |
     

