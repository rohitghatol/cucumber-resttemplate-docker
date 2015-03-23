Feature: Second Scenario

  Scenario: Storing and Retrieving Customer
    Given App is running on http://localhost:8080/
    When I store a new Customer[firstname="Dipesh",lastname="Rane"
    Then I expect to see Customer[firstname="Dipesh",lastname="Rane" in List of Customers
