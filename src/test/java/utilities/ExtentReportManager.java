package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.Baseclass;

public class ExtentReportManager implements ITestListener {
      public ExtentSparkReporter sparkReporter;
      public ExtentReports extent;
      public ExtentTest test;
      
      String repName;
      
      public void onStart(ITestContext testContext)
      {
    	  String timestamp=new SimpleDateFormat ("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
    	  repName="Test-Report"+timestamp +".html";//report name
    	  sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report
    	  
    	  sparkReporter.config().setDocumentTitle("Opencart Automation Report");// title of report
    	  sparkReporter.config().setReportName("Opencart Functional Testing");// name of the report
    	  sparkReporter.config().setTheme(Theme.DARK);
    	  
    	  //report values
    	  extent=new ExtentReports();
    	  extent.attachReporter(sparkReporter);
    	  extent.setSystemInfo("Application", "Opencart");
    	  extent.setSystemInfo("Module", "Admin");
    	  extent.setSystemInfo("Sub Module", "Customer");
    	  extent.setSystemInfo("User Name",System.getProperty("user.name"));
    	  extent.setSystemInfo("Environment", "QA");
    	  
    	  String os=testContext.getCurrentXmlTest().getParameter("os");
    	  extent.setSystemInfo("Operating System", os);// which you passes in xml file that parameter
    	  
    	  String browser=testContext.getCurrentXmlTest().getParameter("browser");
    	  extent.setSystemInfo("Browser", browser);
    	  
    	  //groups name will be captured from xml and display in report
    	  List<String> includeGroups=testContext.getCurrentXmlTest().getIncludedGroups();
    	  //getCurrentXmlTest() fetches the XML test definition currently being executed (from your testng.xml).
    	  //getIncludedGroups() returns a list of all groups that were explicitly included in this test run.
    	  if(!includeGroups.isEmpty())
    		  //This checks whether the list of included groups is empty.If no groups were specified in the XML, the list will be empty, and the block won’t execute.
             //If there are groups, the code inside the block will run.
    	  {
    		  extent.setSystemInfo("Groups", includeGroups.toString());
    	  }
      }
      
    public void onTestSuccess(ITestResult result)  
    {
    	test =extent.createTest(result.getTestClass().getName());//to get the name of the class
    	test.assignCategory(result.getMethod().getGroups()); //to display groups in reports
    	test.log(Status.PASS,result.getName()+"got successfully executed");// added log
    	try {
    		String imgPath=new Baseclass().captureScreen(result.getName());
    		test.addScreenCaptureFromPath(imgPath);
    	}catch(IOException e2)
    	{
    		e2.printStackTrace();
    	}
    }
    
    public void onTestFailure(ITestResult result)  
    {
    	test =extent.createTest(result.getTestClass().getName());//to get the name of the class and creating the test
    	test.assignCategory(result.getMethod().getGroups());// which group the test belongs
    	
    	test.log(Status.FAIL,result.getName()+"got Failed");
    	test.log(Status.INFO,result.getThrowable().getMessage());
    	
    	try {
    		String imgPath=new Baseclass().captureScreen(result.getName());//base class object is created and using capture screen method
    		test.addScreenCaptureFromPath(imgPath);
    	}catch(IOException e1)
    	{
    		e1.printStackTrace();// warning message we will get
    	}
    	
    }
  
    public void onTestSkipped(ITestResult result) 
    {
    	test =extent.createTest(result.getTestClass().getName());// from the result we are getting class and name of the class and creating test class
    	test.assignCategory(result.getMethod().getGroups()); //to display groups in reports
    	test.log(Status.SKIP,result.getName()+"got skipped");
    	test.log(Status.INFO,result.getThrowable().getMessage());
    }
    
    public void onFinish(ITestContext testContext)
    {
    	extent.flush();// finally write everything to the report file
    	//ExtentReports works by collecting all the logs, system info, and test results in memory while your tests are running.
    	
    	//to open the report automatically we have added this generally flush method is enough
    	String pathOfExtentReport =System.getProperty("user.dir")+"\\reports\\"+repName;//reports path
    	File extentReport=new File(pathOfExtentReport);
    	
    	try {
    		Desktop.getDesktop().browse(extentReport.toURI());//to open the report automatically
    	}catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
    
}
