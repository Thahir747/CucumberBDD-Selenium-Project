package stepDefinitions;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddEmployee;
import pageObjects.Loginpage;


public class BaseClass {

    public WebDriver driver;
    public Loginpage lp;
    public AddEmployee ae;

    public static String randomString() {
        String generatedString= RandomStringUtils.insecure().nextAlphabetic(5);
        return generatedString;
    }
}
