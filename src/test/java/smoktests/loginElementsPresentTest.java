package smoktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginElementsPresentTest {

    public WebDriver driver = browser.DriverFactory.open("chrome");
    @Test
    public void loginElementsTest() {


        driver.get("http://sdettraining.com/trguitransactions/accountmanagement.aspx");
        boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
        boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
        Assert.assertTrue(loginEmailBox);
        Assert.assertTrue(!passwordBox);


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
