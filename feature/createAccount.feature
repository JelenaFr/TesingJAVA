# Created by Yelena at 3/29/2021
Feature: New user registration.


  Scenario: Successful registration with valid entries
    Given User open Instagram registration page by chrome browser
    When User make registration with valid entries
    And Close browser

  Scenario: User has registration in Instagram
    Given User open Instagram registration page by chrome browser
    When User has registration in Instagram
    And Close browser

  Scenario: User make registration via the Facebook account
    Given User open Instagram registration page by chrome browser
    When User make registration via the Facebook account
    And  Close browser


  Scenario: Unsuccessful registration with invalid email
    Given User open Instagram registration page by chrome browser
    When User make registration with invalid email
    And  Close browser

  Scenario: Unsuccessful registration with invalid mobile
    Given User open Instagram registration page by chrome browser
    When User make registration with invalid mobile
    And  Close browser



#  Scenario: Unsuccessful registration with incorrect characters in fullname
#    Given User open Instagram registration page by chrome browser
#    When User try use in fullname incorrect characters
#    And  Close browser

  Scenario: Unsuccessful registration with not available username
    Given User open Instagram registration page by chrome browser
    When User try enter not available username
    And  Close browser

  Scenario: Unsuccessful registration with simple password
    Given User open Instagram registration page by chrome browser
    When User uses for registration simple password
    And  Close browser

