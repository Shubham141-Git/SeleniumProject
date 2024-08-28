   package TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumFramework.resources.ExtentReport;
import abstractComponent.AbstractComponents;

public class Listeners extends BaseTest implements ITestListener {
	
	WebDriver driver;
	

	ThreadLocal <ExtentTest>th = new ThreadLocal <ExtentTest>(); //avoid the test execution overriding
	
	ExtentTest test;
	ExtentReports extent =ExtentReport.getReportObject();
	
	  public  void onTestStart(ITestResult result) {
		  
		test=  extent.createTest(result.getMethod().getMethodName());
		    // not implemented
		
	  
	  th.set(test);}

		  /**
		   * Invoked each time a test succeeds.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SUCCESS
		   */
		  public void onTestSuccess(ITestResult result) {
		    // not implemented
			  
			  test.log(Status.PASS, "Test Pass");
		  }

		  /**
		   * Invoked each time a test fails.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#FAILURE
		   */
		  public void onTestFailure(ITestResult result) {
		    // not implemented
			  String path=null;
			  test.fail(result.getThrowable());
			  
			  
			  
			  try {
				driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			  
			  try {
				
				  
				  path =getScreenShot(result.getMethod().getMethodName() , driver );
			
			  
			  } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  test.addScreenCaptureFromBase64String(path, result.getMethod().getMethodName());
			  
		  }

		  /**
		   * Invoked each time a test is skipped.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SKIP
		   */
		  public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

		  /**
		   * Invoked each time a method fails but has been annotated with successPercentage and this failure
		   * still keeps it within the success percentage requested.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
		   */
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

		  /**
		   * Invoked each time a test fails due to a timeout.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   */
		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		  /**
		   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
		   * tag and calling all their Configuration methods.
		   *
		   * @param context The test context
		   */
		  public void onStart(ITestContext context) {
		    // not implemented
		  }

		  /**
		   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
		   * run and all their Configuration methods have been called.
		   *
		   * @param context The test context
		   */
		  public void onFinish(ITestContext context) {
			  
			  extent.flush();
		    // not implemented
		  } 

}
