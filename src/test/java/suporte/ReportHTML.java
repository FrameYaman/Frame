package suporte;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportHTML {
	
	ExtentReports reports;
	ExtentTest testeInfo;
	ExtentHtmlReporter htmlReporter;
	
	@BeforeTest
	public void setup() {
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/AutomacaoReport.html"));
		htmlReporter.loadXMLConfig(new  File(System.getProperty("user.dir")+"/extent-config.xml"));
		reports = new ExtentReports();
		reports.setSystemInfo("Environment", "QA");
		reports.attachReporter(htmlReporter);
	}
	
	@Test
	public void methodOne() {
	Assert.assertTrue(true);	
	testeInfo.log(Status.INFO,"Exemplo methodOne");
	}
	
	@Test
	public void methodTwo() {
	Assert.assertTrue(false);	
	testeInfo.log(Status.INFO,"Exemplo methodTwo");
	}
	
	@BeforeMethod
	public void register(Method method) {
		String testName = method.getName();
		testeInfo = reports.createTest(testName);
	}
	
	@AfterMethod
	public void captureStatus(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			testeInfo.log(Status.PASS, "O metodo do teste nomeado é:"+ result.getName() + " passou!" );
		}else if(result.getStatus() == ITestResult.FAILURE) {
			testeInfo.log(Status.PASS, "O metodo do teste nomeado é:"+ result.getName() + " falhou!" );
			testeInfo.log(Status.FAIL, "O teste falhou: " + result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP) {
			testeInfo.log(Status.PASS, "O metodo do teste nomeado é:"+ result.getName() + " passou!" );
		}
	}
	
	@AfterTest
	public void cleanUp() {
		reports.flush();
	}
}












