/**
* Test Script Name  				 : BillerDeleteCorporateClient.
* Test Data SheetName				 : BillerDeleteCorporatelClient
* Objective     					 : 1)To Verify Delete Corporate client Functionality.
* 									   2)To Verify Deleted corporate Clients checkbox.
* Version      						 : 1.0
* Author       						 : Kathirvelu M
* Created Date 			      		 : 24/05/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
* Pre-Conditions					 : Biller Login Credentials.  
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.testscripts.biller;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.azmqalabs.edaattestautomation.apppages.collectionofpages.Pages;
import com.azmqalabs.edaattestautomation.common.DBUtil;
import com.azmqalabs.edaattestautomation.common.ExtentManager;
import com.azmqalabs.edaattestautomation.common.InitializeDriver;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.webDriverEventListener;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;

// TEST LISTENER
@Listeners(com.azmqalabs.edaattestautomation.common.TestListener.class)
public class BillerDeleteCorporateClient {
	
	// DECLARATION SECTION
	  static String TestDataTab="BillerDeleteCorporateClient";  
	  
	  private WebDriver driver;
	  private InitializeDriver initializeDriver;
	  private EventFiringWebDriver driverEvent;
	  private webDriverEventListener eventListener;
	  
	  Map<Object, Object> testdatamap;
	  Map<Object, Object> testresultsmap;
	  private String TestScriptID="";
	  static Recordset recTestData;
	  static ArrayList<String> arrListTestDataColumnNames;
	  String sBrowserTestData="";
	  String browserFromXML="";
	  String CorporateName="";
	  String CRNumber="";
	  String PersonName="";
	  String PersonID="";
	  String className="";
	  String ClientRefno="";
	  String MobileNo="";
	  String Email="";
	  String ResonforDelete="";	  
	  ExtentReports extent;
	  ExtentTest test;
	  Pages Pages;
	  Log Log;
	  DBUtil DBUtil;
	  
		// FACTORY - DATA PROVIDER
	    @Factory (dataProvider="TestDataProvider")
	    public BillerDeleteCorporateClient(Map<Object, Object> testdatamap){
	    	this.testdatamap=testdatamap;
	        this.TestScriptID=testdatamap.get("TestScriptID").toString();
	        this.sBrowserTestData=testdatamap.get("Browser").toString();
	        this.CorporateName=testdatamap.get("CorporateName").toString();
	  	    this.CRNumber=testdatamap.get("CRNumber").toString();	
	  	    this.PersonName=testdatamap.get("PersonName").toString();
	  	    this.PersonID=testdatamap.get("PersonID").toString();
	  	    this.CRNumber=testdatamap.get("CRNumber").toString();
	  	    this.MobileNo=testdatamap.get("MobileNo").toString();
	  	    this.Email=testdatamap.get("Email").toString();
	  	    this.ClientRefno=testdatamap.get("ClientRefno").toString();
	  	    this.ResonforDelete=testdatamap.get("ResonforDelete").toString();

	  	  
	    }
	    @Override
	    public String toString(){
	    	return String.format("%S", TestScriptID);
	    }
	    
	    
		// DATA PROVIDER - FOR TEST DATA
	    @DataProvider
	    public static Object[][] TestDataProvider() throws Exception {
	    	Map<String, String> TestDataColNames;
	      	ReadData.retrieveLoginEnvDetails();
	      	arrListTestDataColumnNames=ReadData.readDataTableColumns(TestDataTab);
		  	TestDataColNames=ReadData.mapTestDataTableColumns(arrListTestDataColumnNames);
	      	recTestData=ReadData.readTestData(TestDataTab);
	        int lastRowOfTestData=recTestData.getCount();
	        Object[][] testdataobj = new Object[lastRowOfTestData][1];
	        testdataobj=ReadData.mapTestData(TestDataColNames,recTestData);
	      	return testdataobj;
	    }

		// TEST METHOD
//	    @Parameters({ "username", "password" })
	    @Test
	    public void myTest() throws InterruptedException, Exception{
	        try{
	        	testresultsmap=testdatamap;
	        	testresultsmap.put("BrowserName", browserFromXML);
	        	testresultsmap.put("TestScriptID", TestScriptID);
	        	testresultsmap.put("TestDataName", TestDataTab);
	        	System.out.println(testdatamap.get(TestScriptID));
	        	
	        	Log.ReportEvent("PASS", className+" Execution Started");
	        	Pages.InvokeApplicationPage.launchApplication();	        
	        	Pages.InvokeApplicationPage.Chooseoptions(Log);	
	        	Pages.BillerLoginPage.LoginToApplication(testdatamap,Log);
	        	Pages.BillerCorporatePage.DeleteCorporateClient(CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno,ResonforDelete, Log);
	        	Pages.BillerLoginPage.Logout(EdaatOR.Logout, Log);
	        	Log.PostTestStatus(TestScriptID);
	        	DBUtil.UpdateTestResultInDB(testresultsmap);
	        	driver.quit();
	        }
			  catch (Exception e)
			  {
				  Log.takeScreenShot();
				  Log.PostTestStatus(TestScriptID);
				  Log.ReportEvent("INFO", "TEST EXECUTION INCOMPLETE"+e);
				  DBUtil.UpdateTestResultExceptionInDB(testresultsmap);
				  Log.ReportEvent("FATAL", "<< !!!!!!!!!!!!!!!!!!!!! TEST INCOMPLETE !!!!!!!!!!!!!!!!!!!!! >>"+e);
				  System.out.println("<< FATAL - !!!!!!!!!!!!!!!!!!!!! TEST INCOMPLETE !!!!!!!!!!!!!!!!!!!!! >>"+e);
				  driver.quit();
				  throw new NullPointerException("********FATAL EXCEPTION TRIGGERED********");
			  }
	    }
	    
		// BEFORE CLASS METHOD - BROWSER INITIALIZATION
		   @BeforeClass
		    public void beforeClass() throws Exception {
		        browserFromXML=sBrowserTestData;		        
		        // EXTENT REPORT
		        extent=ExtentManager.CreateExtentReportExtent(browserFromXML);
		    	 className=this.getClass().getSimpleName();
		  	  	test=ExtentManager.CreateExtentReportTest(extent,className,testdatamap.get("TestDescription").toString(), browserFromXML,TestScriptID);
		  	  	// INITIALIZE DRIVER
		  	  	initializeDriver=new InitializeDriver();
		  		driver=initializeDriver.initDriver(browserFromXML);
		  		driverEvent = new EventFiringWebDriver(driver);
//				eventListener = new webDriverEventListener(test);
//				driverEvent.register(eventListener);
//				this.driver=driverEvent;
				// INITIALIZE PAGE FACTORY OBJECT
				Pages=new Pages(driver,test);
			    Log=new Log(driver,test);
				DBUtil=new DBUtil(driver,test);
				// LOG TEST MACHINE/USER DETAILS
				//Log.QAMachineInfo();
		    }
		// AFTER CLASS
	    @AfterClass
	    public void afterClass() {
	        extent.flush();
	    }
	    
		// AFTER TEST - NEED TO USE FOR LOGIN/LOGOUT HANDLING PURPOSE
	    @AfterTest
	    public void afterTest() {
	        System.out.println("After test");
	    }
	    
	    	  
	    
}
