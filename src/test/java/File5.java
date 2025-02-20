import org.openqa.selenium.*;
import org.junit.*;

public class File5 extends File1{

    @Test
    public void iFrames() throws InterruptedException {
        // Limited visits for this website
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        // swtich to ID
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Hello from the other side");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void JSExecuter(){
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement btnLogin1 = driver.findElement(By.id("login-button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnLogin1);
        String title = js.executeScript("return document.title;").toString();
        String url = js.executeScript("return document.URL;").toString();

        // Scrolling Page
        js.executeScript("window.scrollBy(0,600)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}

