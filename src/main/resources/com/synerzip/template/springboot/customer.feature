Feature: First Scenario

  Scenario: Storing and Retrieving Customer
  	Given App is running on http://app:8080/
    When I store a new Customer[firstname="Rohit",lastname="Ghatol"
    Then I expect to see Customer[firstname="Rohit",lastname="Ghatol" in List of Customers
