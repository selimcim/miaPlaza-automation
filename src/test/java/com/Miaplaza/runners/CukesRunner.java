package com.Miaplaza.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "me.jvt.cucumber.report.PrettyReports:target",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/Miaplaza/stepdefinitions",
        tags = "@wip",
        dryRun = false

)
public class CukesRunner {
}