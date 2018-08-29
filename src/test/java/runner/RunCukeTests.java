package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.java.After;
import org.junit.runner.RunWith;
import stepdefs.StepDefs;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test",glue = "stepdefs")


public class RunCukeTests {



}
