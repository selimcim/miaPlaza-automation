package com.Miaplaza.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/failed-html-reports",
                "rerun:target/rerun.txt"},
        features = "@target/rerun.txt",
        glue = "com/Miaplaza/stepdefinitions",
        tags = "@wip"
)
public class FailedTestRunner {

}
