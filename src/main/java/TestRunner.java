import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "your.package.name",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}
