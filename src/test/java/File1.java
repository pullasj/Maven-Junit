import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

public class File1 {
    WebDriver driver;
    @Before
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void ValidateTitle(){
        String Title = driver.getTitle();
        if(Title.equals("Swag Labs")){
            System.out.println("Title is correct");
        }
        else {
            System.out.println("Title is incorrect");
        }
        Assert.assertTrue(Title.equals("Swag Labs"));
        driver.findElement(By.id("user-name"));
    }
    @Test
    public void ValidateLogin(){

        // UserName
        String Username = "standard_user";
        driver.findElement(By.id("user-name")).isDisplayed();
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(Username);

        // Password
        String Password = "secret_sauce";
        driver.findElement(By.id("password")).isDisplayed();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(Password);

        //Verifying URL
        String GetURL = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/",GetURL);

        // Button
        driver.findElement(By.id("login-button")).isDisplayed();
        driver.findElement(By.id("login-button")).click();
        try {
            Thread.sleep(1000); // Pause execution for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void closing(){
        driver.close();
    }

}
