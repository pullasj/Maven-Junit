import org.openqa.selenium.*;
import org.junit.*;
import org.openqa.selenium.interactions.Actions;
import java.util.Set;

public class File4 extends File1 {
    @Test
    public void ActionClass(){
        driver.findElement(By.id("user-name")).clear();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("user-name"));
        actions.moveToElement(element).click(element).sendKeys("standard_user").doubleClick().contextClick(element).build().perform();
    }

    @Test
    public void UserAlert(){
    driver.navigate().to("https://only-testing-blog.blogspot.com/2014/01/textbox.html?");

    driver.findElement(By.xpath("//input[@value='Show Me Alert']")).isDisplayed();
    driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
    // Ok on the alert
    driver.switchTo().alert().accept();

    driver.findElement(By.xpath("//button[text()='Show Me Prompt']")).isDisplayed();
    driver.findElement(By.xpath("//button[text()='Show Me Prompt']")).click();
    // Sending Message
    driver.switchTo().alert().sendKeys("Surya Test manager");
    // Getting Alert into string
    String Alertmsg = driver.switchTo().alert().getText();
    System.out.println(Alertmsg);
    driver.switchTo().alert().dismiss();
    }

    @Test
    public void cookie(){
        ValidateLogin();

        //Storing Cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);

        //TO get Single Cookie
        Cookie user = driver.manage().getCookieNamed("session-username");
        System.out.println(user);

        // Deleting specific Cookie
        driver.manage().deleteCookie(user);
        driver.manage().deleteCookieNamed("session-username");
        // Deleting all the cookies
        driver.manage().deleteAllCookies();

        Cookie custom = new Cookie("password","pass");
        driver.manage().addCookie(custom);
        System.out.println(driver.manage().getCookieNamed("password"));
    }
}
