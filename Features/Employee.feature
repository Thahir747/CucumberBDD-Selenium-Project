Feature: Adding Employee

  Background: common steps for every scenarios
    Given user launch chrome
    When user open url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And user enters username "Admin" and password as "admin123"
    And click on login
    Then user switches to PIM

  @sanity
  Scenario: Add new Employee
    And click on add employee
    And provide FirstName and lastName
    When click on save
    Then User can view confirmation message "Success"
    And close  browser

  @regression
  Scenario: Search Employee by Name
    Then enter employee name "femtha"
    And click on search
    Then employee "femtha" found in search
    And close  browser

    #77066
  @regression
  Scenario: Search Employee by ID
    Then enter employee ID "77066"
    And click on search
    Then employee ID "77066" found in search
    And close  browser
