package Academy;

import java.io.EOFException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReportsTestNG;

public class Listeners extends Base implements  ITestListener {
	
	ExtentTest test;
	ExtentReports extent =ExtentReportsTestNG.getReportObject();

	public void onFinish(ITestResult arg0) {
		
		
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestResult result) {
		
		
		// TODO Auto-generated method stub
		//ExtendTest test
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		
			try {
				driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			}
			 catch (Exception e)
				{
			
				}
	
		try {
			getScreenShotPath(testMethodName,driver);
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test passed");
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
