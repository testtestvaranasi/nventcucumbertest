package CucumberReport;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options( format = "json:target/Destination/cucumber.json")
public class runTest {

}
