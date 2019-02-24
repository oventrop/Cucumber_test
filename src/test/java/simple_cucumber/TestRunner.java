package simple_cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features", glue = "simple_cucumber")
public class TestRunner extends AbstractTestNGCucumberTests {
}