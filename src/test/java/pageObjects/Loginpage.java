package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage {


    public WebDriver driver;

    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//input[@placeholder='Username']")
    WebElement txtusername;

    @FindBy(xpath="//input[@placeholder='Password']")
    WebElement txtpassword;

    @FindBy(xpath="//button[normalize-space()='Login']")
    WebElement cliclogin;

    @FindBy(xpath="//p[@class='oxd-userdropdown-name']")
    WebElement clicalexMorgan;

    @FindBy(xpath="//a[normalize-space()='Logout']")
    WebElement cliclogout;

    @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidCredentials;



    public void setUsername(String username) {
        txtusername.clear();
        txtusername.sendKeys(username);
    }

    public void setPassword(String pwd) {
        txtpassword.clear();
        txtpassword.sendKeys(pwd);
    }


    public void  clickLogIn() {
        cliclogin.click();
    }


    public void clikprof(){
        clicalexMorgan.click();
    }

    public void clickLogOut() {
        cliclogout.click();
    }


    // Check if the "Invalid credentials" error appears within 5 seconds
    public boolean isErrorMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(invalidCredentials));
            return invalidCredentials.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
/*
    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(invalidCredentials));
        return invalidCredentials.getText();
    }
*/





}
