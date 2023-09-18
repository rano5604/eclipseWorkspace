package TestRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;
import cucumber.api.testng.*;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",glue={"StepDefinition"})	
public class Runner {

}
