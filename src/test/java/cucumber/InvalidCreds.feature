
Feature: Login with Invalid creds

  @Sanity
  Scenario Outline: Invalid test
    Given Navigate to baseUrl 
    When Login with username <name> and password <password> 
    Then verify the url of current page

    Examples: 
      | name  								| password	|
      | dovo5318@em2lab.com 	| QkFOX@123 |
