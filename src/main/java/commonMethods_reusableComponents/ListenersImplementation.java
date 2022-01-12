package commonMethods_reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import testBase.ObjectsRepo;

public class ListenersImplementation extends ObjectsRepo implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// before each test cases
	
		// test = extent.createTest("Test case name");
		// Will give the actual test case name - result.getMethod().getMethodName()
				
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test case:" + result.getMethod().getMethodName()+ "is Passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, "Test case:" + result.getMethod().getMethodName()+ "is Failed.");
		// below statement will get the exceptions
		test.log(Status.FAIL, result.getThrowable());
		// add screen shot for failed tests
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		String screenshotPath = System.getProperty("user.dir")+"/Reports/Screenshots"+actualDate+".jpeg";
		File dest = new File(screenshotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
	}

	@Override
	public void onStart(ITestContext context) {
		// setup method call
		// setupextentReport method returns the object of extent.
	extent = ExtentSetup.setupExtentReport();	
	}

	@Override
	public void onFinish(ITestContext context) {
		// close extent
		// this flush method will collect the staticstics, generate the report close the report
		extent.flush();
		
	}
	
}
