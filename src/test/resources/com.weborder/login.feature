
@login
Feature: Login Functionality for webOrder Page
  @tc5 @regression
  Scenario: validation of webOrder login positive scenario
    Given the user navigate to the webOrder
    When the user provides the credentials
    Then the user is on the home page
