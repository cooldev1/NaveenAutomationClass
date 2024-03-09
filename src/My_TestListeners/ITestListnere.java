package My_TestListeners;
import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListnere extends Base_Class implements ITestListener {
	

public void onTestStart(ITestResult result)  {
	
	System.out.println("on Start method Started...." + result.getName());
	
	}

public void onFinish(ITestResult result) {
	
	System.out.println("on Finished method Finished....");
}

public void onTestFailure(ITestResult result) {
	
	System.out.println("on Failure method...."+ result.getName());
	try {
		screenshots(result.getMethod().getMethodName());
	} catch(IOException e) {
		e.printStackTrace();
	}
}

public void onTestSkipped(ITestResult result) {
	
	System.out.println("on Skipped method...."+ result.getName());
}

public void onTestSuccess(ITestResult result) {
	
	System.out.println("on Success Executed method...."+ result.getName());
	try {
		screenshots(result.getMethod().getMethodName());
	} catch(IOException e) {
		e.printStackTrace();
	}
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	System.out.println("onTestFailedbutwithinSuccesspercentage...."+ result.getName());
}

}
