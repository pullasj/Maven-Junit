import org.openqa.selenium.*;
import org.junit.*;
import org.openqa.selenium.interactions.Actions;
import java.util.Set;

public class File4 extends File1 {

    @Test
    public void ActionClass() {
        // Clear the username field before entering data
        driver.findElement(By.id("user-name")).clear();

        // Using Actions class for advanced user interactions
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("user-name"));

        // Performing a series of actions:
        // 1. Move to the element
        // 2. Click on it
        // 3. Type 'standard_user'
        // 4. Double-click the text
        // 5. Right-click on the element (context click)
        actions.moveToElement(element)
                .click(element)
                .sendKeys("standard_user")
                .doubleClick()
                .contextClick(element)
                .build()
                .perform();
    }

    @Test
    public void UserAlert() {
        // Navigating to a test page that contains alert popups
        driver.navigate().to("https://only-testing-blog.blogspot.com/2014/01/textbox.html?");

        // Finding and clicking the "Show Me Alert" button
        driver.findElement(By.xpath("//input[@value='Show Me Alert']")).isDisplayed();
        driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
        
        // Accepting the alert popup
        driver.switchTo().alert().accept();

        // Finding and clicking the "Show Me Prompt" button
        driver.findElement(By.xpath("//button[text()='Show Me Prompt']")).isDisplayed();
        driver.findElement(By.xpath("//button[text()='Show Me Prompt']")).click();

        // Sending input text into the alert prompt
        driver.switchTo().alert().sendKeys("Surya Test manager");

        // Capturing the alert message
        String Alertmsg = driver.switchTo().alert().getText();
        System.out.println("Alert Message: " + Alertmsg);

        // Dismissing the alert instead of accepting it
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void cookie() {
        // Logging in before handling cookies
        ValidateLogin();

        // Retrieving and printing all cookies stored in the browser
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("All Cookies: " + cookies);

        // Retrieving a specific cookie by name
        Cookie user = driver.manage().getCookieNamed("session-username");
        System.out.println("Session Cookie: " + user);

        // Deleting a specific cookie using object reference
        driver.manage().deleteCookie(user);

        // Deleting a specific cookie by its name
        driver.manage().deleteCookieNamed("session-username");

        // Deleting all cookies stored in the browser
        driver.manage().deleteAllCookies();

        // Creating and adding a custom cookie to the browser
        Cookie custom = new Cookie("password", "pass");
        driver.manage().addCookie(custom);

        // Retrieving and printing the custom cookie
        System.out.println("Custom Cookie: " + driver.manage().getCookieNamed("password"));
    }
}
