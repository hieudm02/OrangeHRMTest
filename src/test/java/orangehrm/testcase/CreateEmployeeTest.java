package orangehrm.testcase;

import orangehrm.pages.DashboardPage;
import orangehrm.pages.LoginPages;
import orangehrm.pages.PIMPage;
import orangehrm.setup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateEmployeeTest extends Setup {
    PIMPage pimPage;
    DashboardPage dashboardPage;
    LoginPages loginPages;
    @Test
    public void Login() throws InterruptedException {
        loginPages = new LoginPages(driver);
        loginPages.Login("Admin","admin123");
        WebElement header_title = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']"));
        Assert.assertTrue(header_title.getText().contains("Dashboard"),"Login fail");
        Thread.sleep(1000);
    }

    @Test(priority = 1,description = "Create new employee without username")
    public void CreateEmployeeWithOutUserNameTest() throws InterruptedException {
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);

        dashboardPage.menu.get(1).click();//click Pimpage
        WebElement pimE = driver.findElement(By.xpath("//h6[normalize-space()='PIM']"));
        String pim_header = "PIM";
        Assert.assertTrue(pimE.getText().contains(pim_header));//Check PIMpage is displayed
        dashboardPage.topBarItem.get(1).click();//click add employee
        String firstName = "Duong";
        String lastName= "Hieu";
        String  employeeID = "3030";
        String password = "Password1";
        String cofirmPassword = password;

        pimPage.createEmployeeWithOutUserName(firstName,lastName,employeeID,password,cofirmPassword);
        //check required
        WebElement required = driver.findElement(By.xpath("//span[normalize-space()='Required']"));
        Assert.assertTrue(required.getText().contains("Required"));
        Thread.sleep(1000);
        driver.navigate().refresh();
    }
    @Test(priority = 2, description = "Create Employee 1")
    public void createEmployee() throws InterruptedException {
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);

        String firstName = "Son";
        String lastName= "Goku";
        String  employeeID = "3031";
        String username = "songoku";
        String password = "Password1";
        String cofirmPassword = password;
        pimPage.createEmployee(firstName,lastName,employeeID,username,password,cofirmPassword);
        //check header title
        WebElement header_title = driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']"));
        String header_expected = "Personal Details";
        Assert.assertTrue(header_title.getText().contains(header_expected));
        dashboardPage.topBarItem.get(1).click();
        Thread.sleep(1000);
    }
    @Test(priority = 3,description = "Create Employee 2 ")
    public void CreateEmployee2() throws InterruptedException {
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);

        String firstName = "Forrest";
        String lastName= "Gump";
        String  employeeID = "3032";
        String username = "fgumb";
        String password = "Password1";
        String cofirmPassword = password;
        pimPage.createEmployee(firstName,lastName,employeeID,username,password,cofirmPassword);
        //check header title
        WebElement header_title = driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']"));
        String header_expected = "Personal Details";
        Assert.assertTrue(header_title.getText().contains(header_expected));
        dashboardPage.menu.get(1).click();
        Thread.sleep(2000);
    }
    @Test(priority = 4, description = "Search Employee")
    public void searchEmployee() throws InterruptedException {
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);

        pimPage.searchEmployee("3032");
        WebElement emplist = pimPage.employ_list.get(0);
//        doScroll(emplist);
        emplist.click();
        Thread.sleep(2000);
        //Assert user found
        String empID = pimPage.txtInput.get(5).getAttribute("value");
        String emID_expected = "3032";
        Assert.assertTrue(empID.equals(emID_expected));
    }
    @Test(priority = 5,description = "Update Employee")
    public void updateEmployee() throws InterruptedException {
        pimPage = new PIMPage(driver);
        dashboardPage = new DashboardPage(driver);

        pimPage.updateEmployee("3033");
        dashboardPage.menu.get(1).click();//click PIM page
    }
    @Test(priority = 6,description = "Search Employee ID")
    public void searchEmpID() throws InterruptedException {
        pimPage = new PIMPage(driver);

        pimPage.searchEmployee("3033");
        Thread.sleep(1500);
        String record_actual = driver.findElements(By.className("oxd-text--span")).get(11).getText();
        String record_expected = "Record Found";
        System.out.println(record_actual);
        Assert.assertTrue(record_actual.contains(record_expected));
    }
    @Test(priority = 7,description = "Logout ")
    public void doLogout(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.Logout();
    }
}
