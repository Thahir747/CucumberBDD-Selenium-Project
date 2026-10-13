package testRunner;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;


@Suite
@IncludeEngines("cucumber")
//@SelectFile("Features/Login.feature") // to run particular file
// @SelectClasspathResource("Features")  //to run All test cases in feature directory if it is inside src/test/resources/Features
@SelectDirectories("Features")  // If your Features directory sits at the project root

@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepDefinitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,summary,html:test-output/cucumber-report.html")


// Filter scenarios by tag
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@sanity")

@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
//@ConfigurationParameter(key = ANSI_COLORS_DISABLED_PROPERTY_NAME, value = "true")

public class Testrunner {
}
