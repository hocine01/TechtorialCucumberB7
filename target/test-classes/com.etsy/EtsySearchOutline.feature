@outline
Feature: Etsy Search With Scenario Outline

  Background:
    Given the user navigate to the "https://www.etsy.com"

  Scenario Outline: Etsy Search Validation
    When  the user search with "<searchValue>"
    Then the user should see the title "<title>"
    Examples:
      | searchValue | title       |
      | Hat         | Hat \| Etsy |
      | Key         | Key \| Etsy |
      | Pin         | Pin \| Etsy |

        # control +alt+ L for windows


