Feature: Can we exercise outside?
  Everybody wants to know if we can exercise iin the air

  Scenario: The weather is nod convenient for exercising outside
    Given The temperature is 42
    When I ask whether I can exercise outside
    Then I should be told nope
    
  Scenario: The weather is convenient for exercising outside
    Given The temperature is 24
    When I ask whether I can exercise outside
    Then I should be told of course