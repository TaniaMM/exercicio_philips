package ExerciseEmail;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.BaseTest;

public class TestListeners implements ITestListener {

	static SimpleDateFormat TIMESTAMP = new SimpleDateFormat("yyyyMMdd_HHmmss");

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		System.err.println("O teste " + result.getName() + " resultou em erro!");
		Object currentClass = result.getInstance();
		WebDriver driver = ((BaseTest) currentClass).getDriver();
		Properties prop = ((BaseTest) currentClass).getProperties();

		System.out.println(result.getStatus());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File(prop.getProperty("error.screenshots.folder") + "/" + prop.getProperty("browser") + "-"
							+ result.getName() + "-" + Arrays.toString(result.getParameters()) + "_"
							+ TIMESTAMP.format(new Date()) + ".jpg"));
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
		System.out.println("O teste " + result.getName() + " iniciou");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("O teste " + result.getName() + " passou com sucesso");
	}

}
