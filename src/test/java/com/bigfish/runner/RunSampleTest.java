package com.bigfish.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

        features={"src/test/resources"},
        glue={"com.bigfish.steps"},
        monochrome=true,
        strict = true,
        // dryRun = false,
        plugin={"pretty",
                "html:target/cucumber-htmlreport",
                "json:target/json-report/cucumber-reportCharityGrants.json"
        },
        //tags = {"(@Nominations or @Recognition or @Announcement or @Campaign or @Discussion or @Events or @Groups)"}
        tags={"@Regression"}


)

public class RunSampleTest {

}
