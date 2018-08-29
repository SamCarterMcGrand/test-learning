package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StepDefs {


    public WebDriver driver;

    /* @Before
    public void envSetup() {

    } */

    @Given("^user is on login page$")
    public void user_is_on_login_page() {
        System.out.println("User is on login page");
        driver = browser.DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/accountmanagement.aspx");
    }

    @When("^user enters correct details$")
    public void user_enters_correct_details() {
        System.out.println("Correct login details enters");
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtUserName\"]")).sendKeys("tim@testemail.com");
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtPassword\"]")).sendKeys("trpass");
        driver.findElement(By.xpath("//*[@id=\"MainContent_btnLogin\"]")).click();
    }

    @Then("^user gets confirmation$")
    public void user_gets_confirmation() {
        System.out.println("Confirmation of login");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"conf_message\"]")).getText().contains("success"));
    }


    // @Given("^user is on login page$")
    @When("^user enters incorrect details$")
    public void user_enters_incorrect_details() {
        System.out.println("Correct login details enters");
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtUserName\"]")).sendKeys("tim@wrongemail.com");
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtPassword\"]")).sendKeys("yeboi");
        driver.findElement(By.xpath("//*[@id=\"MainContent_btnLogin\"]")).click();
    }

    @Then("^user is informed of incorrect details$")
    public void user_is_informed_of_incorrect_details() {
        System.out.println("User informed of incorrect details");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"MainContent_lblTransactionResult\"]")).getText().contains("Invalid"));
    }

    @When("^the user enters email <username>$")
    public void user_enters_username(String username) {
        System.out.println("Testing username");
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtUserName\"]")).sendKeys(username);
    }

    @And("^the user enters password <password>$")
    public void user_enters_password(String password) {
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtPassword\"]")).sendKeys(password);
    }

    @And("^the user clicks login$")
    public void user_clicks_login() {
        driver.findElement(By.xpath("//*[@id=\"MainContent_btnLogin\"]")).click();
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}