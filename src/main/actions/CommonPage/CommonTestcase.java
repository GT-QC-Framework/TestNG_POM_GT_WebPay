package CommonPage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.gson.Gson;

import ObjectPageJson.JsonData;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class CommonTestcase {
	WebDriver driver;

	ExtentHtmlReporter htmlReport;
	ExtentReports extent;
	ExtentTest test;

	public WebDriver openMultiBrowser(String browser, String version, String url) {
		if (browser.equals("ie")) {
			InternetExplorerDriverManager.getInstance().version(version).setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equals("chrome")) {
			ChromeDriverManager.getInstance().version(version).setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extendsions");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public String randomEmail() {
		Random rand = new Random();
		int n = rand.nextInt(9999999);
		return String.valueOf(n);
	}

	public void CloseBrowser() {
		driver.quit();
	}

	public void verifyEqual(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}

	public JsonData getDataJson(String JsonFile) {
		String json = readFile(JsonFile);
		return new Gson().fromJson(json, JsonData.class);
	}

	public String readFile(String filename) {
		String result = "";
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// In report
	public void inititalReport(String report) {
		htmlReport = new ExtentHtmlReporter(
				System.getProperty("user.dir").concat("/test-output/ExtendReport/" + report));
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		htmlReport.config().setReportName("Regression Testing");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setTestViewChartLocation(ChartLocation.TOP);
	}

	public void logTestCase(String name) {
		test = extent.createTest(name);
	}

	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed is " + result.getName());
			test.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed is " + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skipped is " + result.getName());
		}
	}

	public void exportReport() {
		extent.flush();
		extent.close();
	}

}
