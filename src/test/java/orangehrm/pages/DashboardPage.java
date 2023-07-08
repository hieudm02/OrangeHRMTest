package orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']")
    public List<WebElement> menu;
    @FindBy(className = "oxd-userdropdown")
    WebElement dropdown;
    @FindBy(xpath = "//a[contains(.,'Logout')]")
    WebElement logout;
    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item']")
    public List<WebElement> topBarItem;

    public DashboardPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void Logout(){
        dropdown.click();
        logout.click();
    }

}
