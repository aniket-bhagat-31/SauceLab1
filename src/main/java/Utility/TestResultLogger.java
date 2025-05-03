package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;

public class TestResultLogger implements ITestListener {

	FileWriter passedWriter;
	FileWriter failedWriter;

	@Override
	public void onStart(ITestContext context) {
		try {
			passedWriter = new FileWriter("passed_tests.txt");
			failedWriter = new FileWriter("failed_tests.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			passedWriter.write(result.getName() + " - PASSED\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			failedWriter.write(result.getName() + " - FAILED\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		try {
			if (passedWriter != null)
				passedWriter.close();
			if (failedWriter != null)
				failedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Other methods can be overridden if needed, e.g., onTestSkipped
}


