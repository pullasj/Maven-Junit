import org.openqa.selenium.*;
import org.junit.*;

public class File5 extends File1 {

    @Test
    public void iFrames() throws InterruptedException {
        // Navigate to a webpage containing an iframe
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        // Switching to the iframe using its ID
        driver.switchTo().frame("mce_0_ifr");

        // Finding the text editor body inside the iframe and typing a message
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Hello from the other side");

        // Adding a short delay to observe the interaction (not recommended for production tests)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Switching back to the main page from the iframe
        driver.switchTo().defaultContent();
    }

    @Test
    public void JSExecuter() {
        // Locating web elements for username, password, and login button
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement btnLogin1 = driver.findElement(By.id("login-button"));

        // Creating a JavaScriptExecutor instance
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Clicking the login button using JavaScript (bypassing Selenium's standard click method)
        js.executeScript("arguments[0].click();", btnLogin1);

        // Retrieving and printing the page title using JavaScript
        String title = js.executeScript("return document.title;").toString();
        System.out.println("Page Title: " + title);

        // Retrieving and printing the page URL using JavaScript
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("Current URL: " + url);

        // Scrolling down the page by 600 pixels using JavaScript
        js.executeScript("window.scrollBy(0,600)");

        // Adding a short delay to observe the scrolling effect
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
