package ExpediaTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class Expedia {


    private WebDriver driver;
    private String browserType = "chrome";
    private String city = "Chicago";
    private String cityAndState = "Chicago, Illinois";
    private String checkIn = "10/10/2018";
    private String checkOut = "10/17/2018";
    private String numOfRooms = "1";
    private String numOfGuests = "2";
    private String numOfChildren = "0";



    @Test
    public void hotelReservation() {

        // 1. Search
        driver.findElement(By.xpath("//*[@id=\"tab-hotel-tab-hp\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"hotel-destination-hp-hotel\"]")).sendKeys(cityAndState);
        driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
        driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);

        new Select(driver.findElement(By.id("hotel-rooms-hp-hotel"))).selectByValue(numOfRooms);
        new Select(driver.findElement(By.id("hotel-1-adults-hp-hotel"))).selectByValue(numOfGuests);
        new Select(driver.findElement(By.id("hotel-1-children-hp-hotel"))).selectByValue(numOfChildren);


        driver.findElement(By.cssSelector("button[type='submit'][data-gcw-change-submit-text='Search']")).click();


        // 2. Modify search results page by giving criteria
        String displayResults = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();

        boolean dispResultsTruth = true;

        if (displayResults.contains(city)) {
            dispResultsTruth = true;
        } else if (!displayResults.contains(city)) {
            dispResultsTruth = false;
        }
        System.out.println(displayResults);


        Assert.assertTrue(dispResultsTruth);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).isDisplayed());


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[name='star'][id='star4']")).click();
        // driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[3]/div[2]/div/a")).click();

        // 3. Analyze results and make selection

        // 4. Book reservation

        // 5. Fill out information

        // 6. Get confirmation
    }

    @BeforeMethod
    public void setUp() {
        driver = browser.DriverFactory.open(browserType);
        driver.get("https://www.expedia.co.uk");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        // driver.quit();
    }
}
