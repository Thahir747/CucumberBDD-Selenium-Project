Feature: Login

  Scenario: Successful login with valid credentials

    Given user launch chrome
    When user open url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And user enters username "Admin" and password as "admin123"
    And click on login

    Then page title should be this "OrangeHRM"
    When user click on log out
    Then page title should be this "OrangeHRM"
    And close  browser

  Scenario Outline: Login Data Driven

    Given user launch chrome
    When user open url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And user enters username "<username>" and password as "<password>"
    And click on login

    Then page title should be this "OrangeHRM"
    When user click on log out
    Then page title should be this "OrangeHRM"
    And close  browser

    Examples:

      | username | password |
      | Admin | admin123 |
      | admin1@yourstore.com | admin1234 |



