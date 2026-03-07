package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReport {


	    public static ExtentReports extent;

	    public static ExtentReports getReportInstance() {

	        if(extent == null) {

	            ExtentSparkReporter reporter =
	                    new ExtentSparkReporter("test-output/ExtentReport.html");

	            reporter.config().setReportName("Bank Automation Report");
	            reporter.config().setDocumentTitle("Test Results");

	            extent = new ExtentReports();
	            extent.attachReporter(reporter);
	        }

	        return extent;
	    }
	}

