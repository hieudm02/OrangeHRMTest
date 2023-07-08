package orangehrm.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeeDetailPage {
    @FindBy(className = "oxd-userdropdown-name")
    WebElement dropdownName;
    @FindBy(xpath = "//label[contains(normalize-space(),'Male')]")
    WebElement gender_male;
    @FindBy(className = "//label[contains(normalize-space(),'Female')]")
    WebElement gender_female;
    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> dropdownList;
    @FindBy(xpath = "//button[@type='submit']")
    public List<WebElement> btnSave;
    @FindBy(className = "orangehrm-tabs-wrapper")
    public List<WebElement> tabLis;
    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']")
    public List<WebElement> menu;
    @FindBy(className = "oxd-input")
    public List<WebElement> txtInput;

    public EmployeeDetailPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void chooseGender() throws InterruptedException {
        gender_male.click();
        btnSave.get(0).click();
        Thread.sleep(2000);
    }
    public void chooseBloodType() throws InterruptedException {
        dropdownList.get(2).click();
        Thread.sleep(1000);
        dropdownList.get(2).sendKeys(Keys.ARROW_DOWN);
        dropdownList.get(2).sendKeys(Keys.ARROW_DOWN);
        dropdownList.get(2).sendKeys(Keys.ENTER);
        btnSave.get(1).click();
        Thread.sleep(2000);

    }
    public void setContact(String street, String city, String provide, String zipcode,String home, String mobile,String work
    ,String email,String otherEmail) throws InterruptedException {

        txtInput.get(1).sendKeys(street);
        txtInput.get(2).sendKeys(street);
        txtInput.get(3).sendKeys(city);
        txtInput.get(4).sendKeys(provide);
        txtInput.get(5).sendKeys(zipcode);

        dropdownList.get(0).sendKeys("v"+"v"+"v");
        dropdownList.get(0).sendKeys(Keys.ENTER);
        txtInput.get(6).sendKeys(home);
        txtInput.get(7).sendKeys(mobile);
        txtInput.get(8).sendKeys(work);
        txtInput.get(9).sendKeys(email);
        txtInput.get(10).sendKeys(otherEmail);
        Thread.sleep(3000);
        btnSave.get(0).click();
        Thread.sleep(2000);
    }
}
