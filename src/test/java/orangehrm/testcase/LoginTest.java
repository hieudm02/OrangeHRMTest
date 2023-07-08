package orangehrm.testcase;

import orangehrm.pages.LoginPages;
import orangehrm.setup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Setup {
    LoginPages loginPages;
    @Test(priority = 1)
    public void checkLogin(){
        loginPages = new LoginPages(driver);
        String message = "Invalid credentials";
        String message_actual = loginPages.checkLoginInvalidCred("Admin","wrongpass");
        Assert.assertTrue(message_actual.contains(message),"Wrong password");
    }
    @Test(priority = 2)
    public void Login(){
        loginPages = new LoginPages(driver);
        loginPages.Login("Admin","admin123");
        WebElement header_title = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']"));
        Assert.assertTrue(header_title.getText().contains("Dashboard"),"Login fail");
    }
}