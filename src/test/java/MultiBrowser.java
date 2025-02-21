import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {
    public WebDriver driver;

    // Accepts a browser parameter from testng.xml to determine which browser to launch
    @Parameters("Browser")
    @BeforeClass
    public void setUp(String Browser) {
        // Checking the passed browser parameter and initializing the respective WebDriver
        if (Browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup(); // Sets up ChromeDriver using WebDriverManager
            driver = new ChromeDriver(); // Launches Chrome browser
        } else if (Browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup(); // Sets up FirefoxDriver using WebDriverManager
            driver = new FirefoxDriver(); // Launches Firefox browser
        } else {
            WebDriverManager.edgedriver().setup(); // Sets up EdgeDriver using WebDriverManager
            driver = new EdgeDriver(); // Launches Edge browser
        }
    }

    // Closes the browser after test execution
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Closes all browser windows and ends the WebDriver session
        }
    }

    // Smoke test case executed when running on Chrome
    @Test(groups = {"smoke"})
    public void test1() {
        System.out.println("Executing test1 on Chrome");
        // Add your test code here
    }

    // Another smoke test case executed when running on Chrome
    @Test(groups = {"smoke"})
    public void test2() {
        System.out.println("Executing test2 on Chrome");
        // Add your test code here
    }

    // Regression test case executed when running on Edge
    @Test(groups = {"regression"})
    public void test3() {
        System.out.println("Executing test3 on Edge");
        // Add your test code here
    }
}
