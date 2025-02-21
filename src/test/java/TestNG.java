import org.testng.annotations.Test;

public class TestNG extends File1{

    @Test(priority = 0 )
    public void validateLogin(){
        ValidateTitle();
    }

    @Test(priority = 1 )
    public void Login(){
        ValidateLogin();
    }

    @Test(priority = 2 )
    public void TT(){
    }

    @Test
    public void Te1(){
    }

    @Test(dependsOnMethods = {"Te1"})
    public void Te2(){
    }
}
