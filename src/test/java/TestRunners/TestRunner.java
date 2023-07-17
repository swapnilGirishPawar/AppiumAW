package TestRunners;
import io.cucumber.testng.*;



@CucumberOptions(

        features = {"src/test/resources/Features"},

        glue = {"StepDefinations"},

        monochrome = true,

        dryRun = false

        ,tags = "@Test"

        ,plugin = {"pretty", "html:test-output/OtherReports/jsonReports.html",
                   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class TestRunner extends AbstractTestNGCucumberTests{

}
