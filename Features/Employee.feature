Feature: Adding Employee

  Scenario: Add new Employee

    Given user launch chrome
    When user open url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And user enters username "Admin" and password as "admin123"
    And click on login


    Then user switches to PIM
    And click on add employee
    And provide FirstName and lastName
    When click on save
    Then User can view confirmation message "Success"
    And close  browser

