package stepDefinitions;


import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Loginpage;


import java.time.Duration;

public class Steps {

    WebDriver driver;

    public Loginpage lp;

    @Given("user launch chrome")
    public void user_launch_chrome() {

        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lp=new Loginpage(driver);

    }
    @When("user open url {string}")
    public void user_open_url(String url) {
        driver.get(url);
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




}
