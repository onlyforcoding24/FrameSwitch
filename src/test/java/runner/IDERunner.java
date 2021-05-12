package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * IDE runner class. Place any tag name in tags and it will run the specific tag
 * through IDE . Can be used to debug code as well.
 * Only designed to open chrome browser by default
 *
 * @author jitendra.pisal
 */


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"setup", "com.automation.rop.steps", "com.automation.rei.govgrantsSteps", "com.testingblaze.actionsfactory.gherkin", "com.testingblaze.register"},
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber-report/cucumber.json","html:target/cucumber-html","com.testingblaze.controller.ReportingLogsPlugin"},
        tags = {"@verify-landing-page-elemnts"},
        monochrome = true
)

public class IDERunner {
}

