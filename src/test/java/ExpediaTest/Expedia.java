package ExpediaTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class Expedia {

    WebDriver driver;
    String browserType = "chrome";
    String city = "Chicago, Illinois";
    String checkIn = "10/10/2018";
    String checkOut = "10/17/2018";
    String numOfGuests = "2";


    @Test
    public void hotelReservation() {

        // 1. Search
        driver.findElement(By.xpath("//*[@id=\"tab-hotel-tab-hp\"]")).click();
        driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
        driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
        driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
        driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button")).click();
        driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div/div[2]/div[4]/button")).click();
        // driver.findElement(By.xpath("//*[@id=\"hotel-business-travel-radio-no-hp-hotel\"]")).click();
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        // 2. Modify search results page by giving criteria
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[name='star'][id='star4']")).click();

        // 3. Analyze results and make selection

        // 4. Book reservation

        // 5. Fill out information

        // 6. Get confirmation
    }

    @BeforeMethod
    public void setUp() {
        driver = browser.DriverFactory.open(browserType);
        driver.get("https://www.expedia.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        // driver.quit();
    }
}
