import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

public class File1 {
    WebDriver driver;

    @Before
    public void Setup() {
        // This is for manually specifying the ChromeDriver executable (if needed)
        // System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");

        // Using WebDriverManager to automatically manage the ChromeDriver version
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Navigating to the Swag Labs login page
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void ValidateTitle() {
        // Retrieving the page title
        String Title = driver.getTitle();
        
        // Verifying if the title matches "Swag Labs"
        if (Title.equals("Swag Labs")) {
            System.out.println("Title is correct");
        } else {
            System.out.println("Title is incorrect");
        }

        // Assertion to validate the title
        Assert.assertTrue(Title.equals("Swag Labs"));

        // Verifying if the username input field is present
        driver.findElement(By.id("user-name"));
    }

    @Test
    public void ValidateLogin() {
        // Defining test credentials
        String Username = "standard_user";
        String Password = "secret_sauce";

        // Checking if the username field is displayed and then entering the username
        driver.findElement(By.id("user-name")).isDisplayed();
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(Username);

        // Checking if the password field is displayed and then entering the password
        driver.findElement(By.id("password")).isDisplayed();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(Password);

        // Verifying if the current URL is correct before login
        String GetURL = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/", GetURL);

        // Checking if the login button is displayed and then clicking it
        driver.findElement(By.id("login-button")).isDisplayed();
        driver.findElement(By.id("login-button")).click();

        // Adding a short delay after login (Not recommended, consider using WebDriverWait instead)
        try {
            Thread.sleep(1000); // Pause execution for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void closing() {
        // Closing the browser session after test execution
        driver.close();
    }
}
