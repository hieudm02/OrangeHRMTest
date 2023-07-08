package orangehrm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {
    @FindBy(className = "oxd-input")
    public List<WebElement> txtInput;
    @FindBy(className = "oxd-switch-wrapper")
    WebElement btnSwitchLoginDetail;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSave;
    @FindBy(tagName = "button")
    public List<WebElement> btn;
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement btnCancel;
    @FindBy(className = "oxd-table-card")
    public List<WebElement> employ_list;


    public PIMPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void createEmployeeWithOutUserName(String firstName, String lastName, String  employeeID, String password,String cofirmPassword) throws InterruptedException {
        txtInput.get(1).sendKeys(firstName);
        txtInput.get(3).sendKeys(lastName);

        WebElement emID = txtInput.get(4);
        emID.clear();
        emID.sendKeys(Keys.CONTROL+"a");
        emID.sendKeys(employeeID);

        btnSwitchLoginDetail.click();
        Thread.sleep(1000);
        txtInput.get(6).sendKeys(password);
        txtInput.get(7).sendKeys(cofirmPassword);
        btnSave.click();
        Thread.sleep(1500);

    }
    public void createEmployee(String firstName, String lastName, String  employeeID,String username, String password,String cofirmPassword) throws InterruptedException {
        txtInput.get(1).sendKeys(firstName);
        txtInput.get(3).sendKeys(lastName);

        WebElement emID = txtInput.get(4);
        emID.clear();
        emID.sendKeys(Keys.CONTROL+"a");
        emID.sendKeys(employeeID);

        btnSwitchLoginDetail.click();
        txtInput.get(5).sendKeys(username);
        txtInput.get(6).sendKeys(password);
        txtInput.get(7).sendKeys(cofirmPassword);
        btnSave.click();
        Thread.sleep(2000);
    }
    public void searchEmployee (String employeeID) throws InterruptedException {
        txtInput.get(1).sendKeys(employeeID);
        btnSave.click();//Click Search
    }
    public void updateEmployee(String employeeID) throws InterruptedException {
        txtInput.get(5).sendKeys(Keys.CONTROL+"a");
        txtInput.get(5).sendKeys(employeeID);
        Thread.sleep(2000);
        btn.get(2).click();
        Thread.sleep(3000);
    }

}
