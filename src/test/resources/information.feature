Feature: Print personal information
  # in cucumber we have only three annotation for steps which is Given,When,Then
  Scenario: Print info
    Given the user print firstname
    When the user print the lastname
    Then the user should see the fullname
    And the user print city
    And the user print state
    * the user print age
    But the user should see the school name