package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployee {


    public WebDriver driver;

    public AddEmployee(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // By dashboard =By.xpath("//h6[normalize-space()='Dashboard']");
    By pIM = By.xpath("//span[normalize-space()='PIM']");
    By addEmployees = By.xpath("//a[normalize-space()='Add Employee']");
    By firstName = By.xpath("//input[@placeholder='First Name']");
    By lastName = By.xpath("//input[@placeholder='Last Name']");
    By save = By.xpath("//button[normalize-space()='Save']");
    By successmssg = By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast oxd-toast-list-enter-active oxd-toast-list-enter-to']");


    //Action methods

    public void clickonpim() {
        driver.findElement(pIM).click();
    }

    public void clickonaddemployees() {
        driver.findElement(addEmployees).click();
    }

    public void txtfirstname(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void txtlastname(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void clickonsave() {
        driver.findElement(save).click();
    }

    public String statsuccessmssg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successmssg));
        return toastElement.getText();
    }


}
