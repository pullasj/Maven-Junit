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

    @Parameters("Browser")
    @BeforeClass
    public void setUp(String Browser) {
        if (Browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (Browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(groups = {"smoke"})
    public void test1() {
        System.out.println("From Chrome");
        // Add your test code here
    }

    @Test(groups = {"smoke"})
    public void test2() {
        System.out.println("From Chrome");
        // Add your test code here
    }

    @Test(groups = {"regression"})
    public void test3() {
        System.out.println("From Edge");
        // Add your test code here
    }
}
