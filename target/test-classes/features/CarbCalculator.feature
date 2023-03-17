Feature: feature to verify that the carbohydrate calculator generates a correct output
  Scenario: with Mifflin-St Jeor selected and all fields having valid values, the output should be correct
    Given browser is open
    And user has navigated to carbohydrate calculator website
    When user enters 20 in the Age field
    And user selects Male in the Gender options
    And user enters 6 in Height field's feet text box
    And user enters 2 in Height field's inches text box
    And user enters 190 in Weight field
    And user selects 'Moderate: exercise 4-5 times/week' as activity level
    And user clicks on Calculate button
    And user opens the settings block
    And user selects Mifflin St Jeor as the BMR estimation formula
    Then user is shown results for their input
    And the daily calorie allowance for weight maintenance is "2,844 Calories"
    And the daily calorie allowance for losing 1 pound per week is "2,344 Calories"
    And the daily calorie allowance for losing 2 pounds per week is "1,844 Calories"
    And the daily calorie allowance for gaining 1 pound per week is "3,344 Calories"
    And the daily calorie allowance for gaining 2 pounds per week is "3,844 Calories"
    And successfully close the browser
