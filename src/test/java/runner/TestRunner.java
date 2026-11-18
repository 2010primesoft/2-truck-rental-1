/**
 * Generated automation config — TestRunner.java.
 *
 * The Jenkins/CI entrypoint: `mvn test` runs this class (see pom.xml's
 * surefire <includes>), which hands off to the Cucumber JUnit Platform
 * engine to discover and run every .feature file under
 * src/test/resources/features, wired to the step definitions in
 * stepdefinitions and the login/driver hooks in hooks (two separate
 * top-level packages, both listed in glue — there is no shared wrapping
 * package to scan instead).
 */
package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdefinitions,hooks")
public class TestRunner {
}
