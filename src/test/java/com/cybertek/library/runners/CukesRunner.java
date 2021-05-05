package com.cybertek.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json",///generates the json type of file to store run code in JSON format
                "rerun:target/rerun.txt"},// running only failed tests, the 2nd runner class,
        features = "src/test/resources/features",
        glue = "com/cybertek/library/step_definitions",
        dryRun = false,
        tags = "@smoke-test"
)

public class CukesRunner {


}
