package StepDefinations;
import io.cucumber.testng.*;



@CucumberOptions(features = "src/test/resources/Features", glue = {"StepDefinations"},
        monochrome = true,
        dryRun = false
        ,plugin = {"pretty", "html:target/jsonReports.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner extends AbstractTestNGCucumberTests{

}
