package stepDefinitions;


import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddEmployee;
import pageObjects.Loginpage;


import java.time.Duration;

public class Steps extends BaseClass {

    @Given("user launch chrome")
    public void user_launch_chrome() {

        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lp=new Loginpage(driver);

    }
    @When("user open url {string}")
    public void user_open_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }


    @When("user enters username {string} and password as {string}")
    public void userEntersEmailAndPasswordAs(String usrnm, String password) {
        lp.setUsername(usrnm);
        lp.setPassword(password);

    }
    @When("click on login")
    public void click_on_login() {
        lp.clickLogIn();

    }
/*
    @And("check user is on dashboard")
    public boolean check_user_is_on_dashboard() {
        return ae.ds();
    }
 */





    @Then("page title should be this {string}")
    public void page_title_should_be_this(String expectedTitle) throws InterruptedException {
        // Check if invalid credentials error appears
        Thread.sleep(3000);
        if (lp.isErrorMessageDisplayed()) {
            //String errorMsg = lp.getErrorMessage();
            // Fail the test explicitly with the error message from the UI
            driver.quit();
            Assertions.fail();
        } else {
            // Verify expected title if login succeeded
            Assertions.assertEquals(expectedTitle, driver.getTitle());
        }
    }



    @When("user click on log out")
    public void user_click_on_log_out() {
        lp.clikprof();
        lp.clickLogOut();
    }

    @Then("close  browser")
    public void close_browser() {

    driver.quit();
    }

    // Employee adding steps

    @Then("user switches to PIM")
    public void user_switches_to_pim() throws InterruptedException {
        ae=new AddEmployee(driver);

        ae.clickonpim();
    }

    @Then("click on add employee")
    public void click_on_add_employee() throws InterruptedException {
        ae.clickonaddemployees();


    }

    @Then("provide FirstName and lastName")
    public void provide_first_name_and_last_name() throws InterruptedException {

        String Frtname=randomString();
        String Lstname=randomString();

        ae.txtfirstname(Frtname);
        ae.txtlastname(Lstname);

    }

    @When("click on save")
    public void click_on_save() throws InterruptedException {
        ae.clickonsave();

    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String expectedMessage) {
        String actualMessage = ae.statsuccessmssg();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }










}
