package stepDefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pageObjects.AddEmployee;
import pageObjects.Loginpage;
import pageObjects.SearchEmployeeUsingName;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;


public class Steps extends BaseClass {

    @Before
    public void setup() {
        configProp = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            configProp.load(fis);
            fis.close();
        } catch (Exception e) {
            logger.error("Failed to load config.properties file: " + e.getMessage());
            throw new RuntimeException("Could not read config.properties", e);
        }

        String browserName = configProp.getProperty("browser","chrome").toLowerCase();
        logger.info("***** Initializing browser: " + browserName + " *****");

        switch (browserName) {
            case "edge":
                driver = new EdgeDriver();
                logger.info("***** Edge Browser Launched *****");
                break;
            case "chrome":
                driver = new ChromeDriver();
                logger.info("***** Chrome Browser Launched *****");
                break;
            default:
                logger.error("Invalid browser specified in config.properties: '" + browserName + "'. Supported values are 'chrome' or 'edge'.");
                throw new IllegalArgumentException("Unsupported browser: '" + browserName + "'. Please enter 'chrome' or 'edge' in config.properties");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("user launch chrome")
    public void user_launch_chrome() {
        lp=new Loginpage(driver);
    }
    @When("user open url {string}")
    public void user_open_url(String url) {
        logger.info("*****************Launching URL************");
        driver.get(url);
        driver.manage().window().maximize();
    }


    @When("user enters username {string} and password as {string}")
    public void userEntersEmailAndPasswordAs(String usrnm, String password) {
        logger.info("*****************PROVIDING USER DETAILS************");
        lp.setUsername(usrnm);
        lp.setPassword(password);

    }
    @When("click on login")
    public void click_on_login() {
        logger.info("*****************CLICKING LOGIN************");
        lp.clickLogIn();

    }

    @Then("page title should be this {string}")
    public void page_title_should_be_this(String expectedTitle) throws InterruptedException {
        // Check if invalid credentials error appears
        Thread.sleep(3000);
        if (lp.isErrorMessageDisplayed()) {
            //String errorMsg = lp.getErrorMessage();
            // Fail the test explicitly with the error message from the UI
            driver.quit();
            logger.info("*****************LOGIN FAILED************");
            Assertions.fail();
        } else {
            // Verify expected title if login succeeded
            logger.info("*****************LOGIN SUCCESS************");
            Assertions.assertEquals(expectedTitle, driver.getTitle());
        }
    }



    @When("user click on log out")
    public void user_click_on_log_out() {
        logger.info("*****************LOGGING OUT************");
        lp.clikprof();
        lp.clickLogOut();
    }

    @Then("close  browser")
    public void close_browser() {
        logger.info("*****************CLOSING BROWSER************");
        driver.quit();
    }

    // Employee adding steps

    @Then("user switches to PIM")
    public void user_switches_to_pim() throws InterruptedException {
        logger.info("*****************CLICKING ON PIM************");
        ae=new AddEmployee(driver);
        ae.clickonpim();
    }

    @Then("click on add employee")
    public void click_on_add_employee() throws InterruptedException {
        logger.info("*****************CLICKING ON EMPLOYEE************");
        Thread.sleep(5000);
        ae.clickonaddemployees();


    }

    @Then("provide FirstName and lastName")
    public void provide_first_name_and_last_name() throws InterruptedException {

        String Frtname=randomString();
        String Lstname=randomString();

        logger.info("*****************PROVIDING EMPLOYEE DATA************");

        ae.txtfirstname(Frtname);
        ae.txtlastname(Lstname);
        Thread.sleep(5000);

    }

    @When("click on save")
    public void click_on_save() throws InterruptedException {
        logger.info("*****************SAVING EMPLOYEE************");
        ae.clickonsave();

    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String expectedMessage) {
        logger.info("*****************CHECKING FOR CONFIRMATION MAESSAGE************");
        String actualMessage = ae.statsuccessmssg();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }


    // steps  to search employee

    @Then("enter employee name {string}")
    public void enter_employee_name(String empname) {
        logger.info("*****************SEARCH EMPLOYEE NAME************");
        se =new SearchEmployeeUsingName(driver);
        se.setName(empname);
    }

    @Then("click on search")
    public void click_on_search() throws InterruptedException {
        logger.info("*****************CLICKING ON SEARCH************");
        se.clickSearch();
        Thread.sleep(3000);
    }

    @Then("employee {string} found in search")
    public void employee_found_in_search(String expname) {
        boolean isFound = se.searchEmployeeByNameInTable(expname);
        if (isFound) {
            logger.info("*****************SEARCH FOUND************");
            Assertions.assertTrue(true);
        } else {
            logger.info("*****************SEARCH FAILED************");
            Assertions.fail("Employee '" + expname + "' was not found in the search results table!");
        }
    }


    @Then("enter employee ID {string}")
    public void enter_employee_id(String empid) {
        logger.info("*****************SEARCH USING ID************");
        se =new SearchEmployeeUsingName(driver);
        se.setId(empid);
    }

    @Then("employee ID {string} found in search")
    public void employee_id_found_in_search(String sempid) {

        boolean isFound = se.searchEmployeeByIDInTable(sempid);
        if (isFound) {
            logger.info("*****************SEARCH FOUND************");
            Assertions.assertTrue(true);
        } else {
            logger.info("*****************SEARCH FAILED************");
            Assertions.fail("Employee '" + sempid + "' was not found in the search results table!");
        }

    }











}
