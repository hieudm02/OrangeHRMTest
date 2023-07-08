package orangehrm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages{
    @FindBy(name = "username")
    WebElement txtUsername;
    @FindBy(name = "password")
    WebElement txtPassword;
    @FindBy(css = "button[type='submit']")
    WebElement btnLogin;
    @FindBy(tagName = "p")
    WebElement invalidCred;
    public LoginPages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void Login(String username, String password){
        txtUsername.sendKeys(Keys.CONTROL+"a");
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(Keys.CONTROL+"a");
        txtPassword.sendKeys(password);
        btnLogin.click();
    }
    public String checkLoginInvalidCred(String username, String password){
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
        return invalidCred.getText();
    }
}
