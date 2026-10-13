package stepDefinitions;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddEmployee;
import pageObjects.Loginpage;
import pageObjects.SearchEmployeeUsingName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;


public class BaseClass {

    public WebDriver driver;
    public Loginpage lp;
    public AddEmployee ae;
    public SearchEmployeeUsingName se;
    public static final Logger logger = LogManager.getLogger(BaseClass.class);
    public Properties configProp;

    public static String randomString() {
        String generatedString= RandomStringUtils.insecure().nextAlphabetic(5);
        return generatedString;
    }
}
