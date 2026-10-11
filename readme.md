# OrangeHRM BDD Automation Testing Framework

A test automation framework built using **Selenium WebDriver**, **Cucumber BDD**, and **JUnit 5 (JUnit Platform Engine)** with the **Page Object Model (POM)** design pattern. The suite validates core workflows of the OrangeHRM web application, including authentication, user management, and dynamic data tables.

---

## 🛠️ Tech Stack & Dependencies

- **Language:** Java 25
- **Automation Tool:** Selenium WebDriver (`4.50.0`)
- **BDD Framework:** Cucumber Java (`8.0.4`)
- **Test Runner:** JUnit 5 Platform Suite Engine (`6.1.3`)
- **Design Pattern:** Page Object Model (POM)
- **Utilities:** Apache Commons Lang3 (`3.17.0`), Jackson Databind (`2.18.2`)
- **Build Management:** Maven

---

## 📁 Project Structure

```text
Project_cucumber/
├── Features/
│   ├── Login.feature               # Valid and data-driven authentication scenarios
│   └── Employee.feature            # PIM module: Add and search employee scenarios
├── src/
│   └── test/
│       └── java/
│           ├── pageObjects/
│           │   ├── Loginpage.java                  # Authentication page objects & actions
│           │   ├── AddEmployee.java                # Add employee form & toast validation
│           │   └── SearchEmployeeUsingName.java    # Dynamic table search & validation
│           ├── stepDefinitions/
│           │   ├── BaseClass.java                  # Driver instances & random data helpers
│           │   └── Steps.java                      # Gherkin step bindings & assertions
│           ├── testRunner/
│           │   └── Testrunner.java                 # JUnit 5 suite runner configuration
│           └── utilities/
│               └── WaitHelper.java                 # Explicit synchronization wrappers
├── test-output/                            # HTML reports
└── pom.xml                                 # Project dependencies and plugins