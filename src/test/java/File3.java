import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.junit.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class File3 extends File1 {
    @Test
    public void XpathMore(){
        // It finds the ID with User  Example: if ID contains 'User-name' it finds
        driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("standard_user");
        // Clear
        driver.findElement(By.xpath("//input[contains(@id,'user')]")).clear();
        // It find the element with Starts with
        driver.findElement(By.xpath("//input[starts-with(@id,'user')]")).sendKeys("standard_user");
        // OR method Either this or this must be true
        driver.findElement(By.xpath("//input[@id='user-name'  or @name='user']")).sendKeys("standard_user");
        // AND Method Both must be true
        driver.findElement(By.xpath("//input[@id='user-name'  and @name='user-name']")).sendKeys("standard_user");
        // Text Method
        driver.findElement(By.xpath("//div[text()='standard_user']")).isDisplayed();

        // Implicit Time Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }
}
