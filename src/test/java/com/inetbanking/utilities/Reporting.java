package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.reporters.TestHTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	 public Html htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());

		String repName = "Test-Report-" + timeStamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);
		htmlreporterloadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "jyothi");

		htmlReporter.config().setDocumentTitle("InetBanking Test project");
		htmlReporter.config().setReportName("Finctional Test report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOp);
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	}

	public void onTestSkip(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE) );
		
		String screenShotpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f= new File(screenShotpath);
		if(f.exists()) {
			try {
				logger.fail("screenshot is below:"+logger.addScreenCaptureFromPath(screenShotpath));
			}
			catch(IOException e) {
				e.printStackTrace();
				
	}
			public void onFinish(ITestContext textContext) {
				extent.flush();
				
			}
	
	
	}
	
	
	
	
		
		
	}
}
