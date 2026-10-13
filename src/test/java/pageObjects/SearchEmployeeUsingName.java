package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitHelper;

import java.time.Duration;
import java.util.List;

public class SearchEmployeeUsingName {

    public WebDriver driver;
    WaitHelper hp;


    public SearchEmployeeUsingName(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        hp=new WaitHelper(driver);
    }

    @FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement txtname;

    @FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement employeeId;

    @FindBy(xpath="//button[normalize-space()='Search']")
    WebElement search;

    @FindBy(xpath = "//div[@class='oxd-table-body']")
    WebElement tableBody;

    //By autoDropdownOption = By.xpath("//div[@role='listbox']//span");


    By rowCards = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']");


    public void setName(String name) {

        hp.WaitForElement(txtname,10);
        txtname.clear();
        txtname.sendKeys(name);
    }


    public void setId(String id) {

        hp.WaitForElement(employeeId,10);
        employeeId.clear();
        employeeId.sendKeys(id);
    }

    public void clickSearch() {
        hp.WaitForElement(search,10);
        search.click();
    }

    public boolean searchEmployeeByNameInTable(String expectedName) {
        hp.WaitForElement(tableBody, 10);

        // Get all matching rows in the table body
        List<WebElement> rows = driver.findElements(rowCards);

        // If no records found card is shown or list is empty
        if (rows.isEmpty()) {
            return false;
        }

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//div[@role='cell']"));
            // Column 3 contains First & Middle Name
            if (cells.size() >= 3) {
                String actualName = cells.get(2).getText().trim().toLowerCase();
                if (actualName.contains(expectedName.trim().toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }



    public boolean searchEmployeeByIDInTable(String expid) {
        hp.WaitForElement(tableBody, 10);

        // Get all matching rows in the table body
        List<WebElement> rows = driver.findElements(rowCards);

        // If no records found card is shown or list is empty
        if (rows.isEmpty()) {
            return false;
        }

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//div[@role='cell']"));
            // Column 3 contains First & Middle Name
            if (cells.size() >= 2) {
                String actualId = cells.get(1).getText().trim();
                if (actualId.equalsIgnoreCase(expid.trim())) {
                    return true;
                }
            }
        }
        return false;
    }


}
