/**
 * 
 */

package com.synerzip.template.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author rohitghatol
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty",
		  "html:target/test-report",
			"json:target/test-report.json",
			"junit:target/test-report.xml"})
public class RunCukesTest {
	
}