import org.testng.annotations.Test;

public class TestNG extends File1 {

    // This test is executed first due to priority = 0
    @Test(priority = 0)
    public void validateLogin() {
        // This method validates the page title by calling the ValidateTitle method from File1
        ValidateTitle();
    }

    // This test is executed second due to priority = 1
    @Test(priority = 1)
    public void Login() {
        // This method validates login credentials by calling the ValidateLogin method from File1
        ValidateLogin();
    }

    // Test with no implementation yet (executed after Login due to default priority)
    @Test(priority = 2)
    public void TT() {
        // Add test code here
    }

    // Another test with no implementation yet
    @Test
    public void Te1() {
        // Add test code here
    }

    // This test depends on the successful execution of Te1
    @Test(dependsOnMethods = {"Te1"})
    public void Te2() {
        // This test will only run if Te1 is successful
        // Add test code here
    }
}
