package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ReporterNG.ExtentReportNG;
import pages.CommonActions;

public class Listeners  implements ITestListener{

	ExtentReports extent =ExtentReportNG.getReportObject();
	ExtentTest test ;
	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			test.addScreenCaptureFromPath(CommonActions.getScreenshotPath(result.getMethod().getMethodName()), result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
     extent.flush();
	}
	
	
	}  


