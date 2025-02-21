import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.junit.*;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class File3 extends File1 {

    @Test
    public void XpathMore() {
        // Using XPath contains() to find an element where the ID contains 'user'
        driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("standard_user");

        // Clearing the input field after entering text
        driver.findElement(By.xpath("//input[contains(@id,'user')]")).clear();

        // Using XPath starts-with() to find an element where the ID starts with 'user'
        driver.findElement(By.xpath("//input[starts-with(@id,'user')]")).sendKeys("standard_user");

        // Using OR condition in XPath: Element is found if either condition is true
        driver.findElement(By.xpath("//input[@id='user-name' or @name='user']")).sendKeys("standard_user");

        // Using AND condition in XPath: Element is found only if both conditions are true
        driver.findElement(By.xpath("//input[@id='user-name' and @name='user-name']")).sendKeys("standard_user");

        // Using text() method in XPath to locate an element with exact text match
        driver.findElement(By.xpath("//div[text()='standard_user']")).isDisplayed();

        // Implicit wait to handle loading times (not recommended, consider using explicit waits)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }
}
