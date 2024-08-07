package commonKeywords;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener extends keywords implements ITestListener{
	  public  void onTestStart(ITestResult result) {
		    // not implemented
		  }

	  public void onTestSuccess(ITestResult result) {
		    // not implemented
		  }

	  public void onTestFailure(ITestResult result) {
		    // not implemented
		  }

	  public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

	  public void onTestFailedWithTimeout(ITestResult result) {

		    try {
				capturePageScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.setProperty("org.uncommons.reportng.escape-output", "false");
		    Reporter.log("<a href=.\\Screenshots\\test.png\">Test Result <a/>");
		  }

	  public void onStart(ITestContext context) {
		    // not implemented
		  }

	  public void onFinish(ITestContext context) {
		    // not implemented
		  }

}
