import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.junit.*;
import org.openqa.selenium.support.ui.Select;

public class File2 extends File1 {

    // Xpaths (reused from File1 where possible)
    String LoginBtn = "//input[@id='login-button']";

    @Test
    public void ValidateSomeFields() {
        // Validating Font Size
        String fontSize = driver.findElement(By.id("user-name")).getCssValue("font-size");
        System.out.println(fontSize);
        Assert.assertEquals("14px", fontSize);

        // Validating Login Button Text
        String loginWord = driver.findElement(By.xpath(LoginBtn)).getDomAttribute("value");
        System.out.println(loginWord);
        Assert.assertTrue(loginWord.equals("Login"));
    }

    @Test
    public void ValidateWindowSize(){
        // Verifying Windows Size
        Point point = driver.manage().window().getPosition();
        System.out.println(point);
        System.out.println(point.x);
        System.out.println(point.y);

        // Set window size
        Point point1 = new Point(25,20);
        driver.manage().window().setPosition(point1);
    }

    @Test
    // Selecting Dropdown
    public void SelectValues() throws InterruptedException {
        ValidateLogin();
        WebElement element = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(element);
        select.selectByVisibleText("Price (low to high)"); // Searches for exact element
        //select.selectByValue("za"); // za
        //Thread.sleep(200);
        //select.selectByIndex(3); // select forth value

        // Checks the Multiple Drop down or not
        if(select.isMultiple()){
            System.out.println("Is multiple");
        }
        else{
            System.out.println("Not multiple");
        }
    }

    @Test
    public void LoginAndTest() {
        ValidateLogin();  // Call the login function from File1
        System.out.println("Login successful");
    }
}
