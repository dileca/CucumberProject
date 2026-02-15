package Basics;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features",
        glue = "StepDefinitions",
      //  tag = "@Smoke",
        monochrome = true,
        plugin = {"pretty"})

public class Runner {
}
