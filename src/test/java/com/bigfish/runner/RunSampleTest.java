package com.bigfish.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

        features={"src/test/resources/com/bigfish/Nomination/Nominations.feature"},
        glue={"com.bigfish.steps"},
        monochrome=true,
        plugin={"pretty",
                "html:target/cucumber-htmlreport",
                "json:target/json-report/cucumber-reportCharityGrants.json"
        }
        //,tags = {"@mdRegression"}


)

public class RunSampleTest {
}
