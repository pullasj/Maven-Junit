import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.junit.*;
import org.openqa.selenium.support.ui.Select;

public class File2 extends File1 {

    // XPath for the login button (defined for reuse)
    String LoginBtn = "//input[@id='login-button']";

    @Test
    public void ValidateSomeFields() {
        // Validating the font size of the username input field
        String fontSize = driver.findElement(By.id("user-name")).getCssValue("font-size");
        System.out.println("Font Size: " + fontSize);
        Assert.assertEquals("14px", fontSize);  // Expected font size validation

        // Validating the Login button text
        String loginWord = driver.findElement(By.xpath(LoginBtn)).getDomAttribute("value");
        System.out.println("Login Button Text: " + loginWord);
        Assert.assertTrue(loginWord.equals("Login"));  // Checking if button text is "Login"
    }

    @Test
    public void ValidateWindowSize() {
        // Retrieving and printing the current window position
        Point point = driver.manage().window().getPosition();
        System.out.println("Current Window Position: " + point);
        System.out.println("X Position: " + point.x);
        System.out.println("Y Position: " + point.y);

        // Setting the browser window position
        Point point1 = new Point(25, 20);
        driver.manage().window().setPosition(point1);
    }

    @Test
    public void SelectValues() throws InterruptedException {
        // Logging in before interacting with the dropdown
        ValidateLogin();
        
        // Locating the dropdown element
        WebElement element = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(element);

        // Selecting a dropdown option by visible text
        select.selectByVisibleText("Price (low to high)");

        // Uncomment the following lines to select by value or index
        // select.selectByValue("za"); // Selecting by value
        // select.selectByIndex(3); // Selecting the fourth option

        // Checking if the dropdown allows multiple selections
        if (select.isMultiple()) {
            System.out.println("Dropdown supports multiple selections.");
        } else {
            System.out.println("Dropdown does not support multiple selections.");
        }
    }

    @Test
    public void LoginAndTest() {
        // Calling the login function from File1
        ValidateLogin();
        System.out.println("Login successful");
    }
}
