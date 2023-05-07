package runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true, plugin = {"pretty", "html:target/cucumber-reports/index.html", "json:target/cucumber-reports/Cucumber.json" }, monochrome = true, features = "src/test/resources/features", glue = {"steps"})
public class RunCucumberTest {
}
