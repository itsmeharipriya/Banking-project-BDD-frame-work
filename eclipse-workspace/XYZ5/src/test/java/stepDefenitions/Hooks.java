package stepDefenitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import factory.DriverFactory;

import com.aventstack.extentreports.*;
import utils.ExtentReport;
import utils.ScreenshotUtil;

public class Hooks {

    static ExtentReports extent = ExtentReport.getReportInstance();
    static ExtentTest test;

    @Before
    public void setup(Scenario scenario) {

        DriverFactory.initDriver();

        test = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            String screenshotPath = ScreenshotUtil.captureScreenshot(scenario.getName());

            test.fail("Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        else {
            test.pass("Test Passed");
        }

        DriverFactory.quitDriver();

        extent.flush();
    }
}