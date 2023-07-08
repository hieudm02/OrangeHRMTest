package orangehrm.testcase;

import orangehrm.pages.DashboardPage;
import orangehrm.pages.EmployeeDetailPage;
import orangehrm.pages.LoginPages;
import orangehrm.setup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeDetailTest extends Setup {
    EmployeeDetailPage employeeDetailPage;
    LoginPages loginPages;
    DashboardPage dashboardPage;

    @Test
        public void Login() throws InterruptedException {
            loginPages = new LoginPages(driver);
            loginPages.Login("songoku","Password1");
            WebElement header_title = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']"));
            Assert.assertTrue(header_title.getText().contains("Dashboard"),"Login fail");
            Thread.sleep(1000);
    }
    @Test(priority = 1,description = "Personal Detail")
        public void personalDetailTest() throws InterruptedException {
        employeeDetailPage = new EmployeeDetailPage(driver);
        employeeDetailPage.menu.get(2).click();
        Thread.sleep(1000);
        employeeDetailPage.chooseGender();
        doScroll();
        employeeDetailPage.chooseBloodType();
        driver.navigate().refresh();
        Thread.sleep(1000);
        employeeDetailPage.tabLis.get(1).click();
        Thread.sleep(2000);
        employeeDetailPage.setContact("Le Thi Nho","TP HCM","TP HCM","101010101","09999999","0888888","0666666","cterminhieu@gmail.com","nyet@gmail.com");
        WebElement title = driver.findElement(By.xpath("//h6[normalize-space()='PIM']"));
        String actual_title = title.getText();
        String expected_title = "PIM";
        Assert.assertTrue(actual_title.equals(expected_title));
        Thread.sleep(1000);
    }
    @Test(priority = 2)
    public void Logout(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.Logout();
    }
}
