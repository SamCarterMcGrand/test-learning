package smoktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ATagsTest {

    private WebDriver driver = browser.DriverFactory.open("chrome");
    boolean createAccountPresent;
    boolean forgotPWPresent;


    @Test
    public void loginElementsTest() { // Testing presence of <a> tags

        driver.get("http://sdettraining.com/trguitransactions/accountmanagement.aspx");
        List <WebElement> aElements = driver.findElements(By.tagName("a")); // Defines list with elements of data type WebElement
        int numberOfAElements = aElements.size();
        System.out.println(numberOfAElements + " <a> elements on the page:");
        for (WebElement aElement : aElements) {
            System.out.println(aElement.getText());
            if (aElement.getText().equals("CREATE ACCOUNT")) {
                createAccountPresent = true;
                break;
            } else if (aElement.getText().equals("FORGOT PASSWORD?")) {
               forgotPWPresent = true;
                break;
            }

        }

        Assert.assertTrue(createAccountPresent);
        Assert.assertTrue(forgotPWPresent);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
