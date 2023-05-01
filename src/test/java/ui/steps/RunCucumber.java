package ui.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/test.feature"},tags = "@smoke"
)
public class RunCucumber {
}
