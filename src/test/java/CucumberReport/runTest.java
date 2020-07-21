package CucumberReport;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty" ,"json:target/Destination/cucumber.json"})
//@Cucumber.Options( format = "json:target/Destination/cucumber.json")
public class runTest {

}
