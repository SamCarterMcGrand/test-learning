package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver open(String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/samuelmcgrand/Downloads/chromedriver");
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/samuelmcgrand/Downloads/geckodriver");
            return new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "/Users/samuelmcgrand/Downloads/chromedriver");
            return new ChromeDriver();
        }

    }
}

