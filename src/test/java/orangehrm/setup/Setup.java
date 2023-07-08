package orangehrm.setup;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class Setup {
    public WebDriver driver;

    public void doScroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        }

    @Parameters({"appUrl","driverPath"})
    @BeforeClass
    public void Setup(String appUrl,String driverPath){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver.manage().window().maximize();
        driver.navigate().to(appUrl);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterClass
    public void TearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
