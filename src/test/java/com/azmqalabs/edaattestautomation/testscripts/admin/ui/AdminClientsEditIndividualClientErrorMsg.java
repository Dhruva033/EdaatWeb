/**
*
* Test Script Name                   : AdminClientsEditIndividualClientErrorMsg 
* TestData Sheet Name                : AdminEditIndividualClientErrMg 
* Objective                          : Verify Edit Individual Client error message
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 17/10/2023
* Last Updated on                    : N/A
* Updated By                         : Radhika K R
* Pre-Conditions                     : 1)Admin Logged in with valid Credentials. 
                                       2)Individual Client  should be present.
* Epic Details                       : N/A
* User Story Details                 : N/A
**/

package com.azmqalabs.edaattestautomation.testscripts.admin.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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
public class AdminClientsEditIndividualClientErrorMsg {

	// DECLARATION SECTION
	static String TestDataTab="AdminEditIndividualClientErrMg";  

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
	String Username="";
	String FullName="";
	String SecondName="";
	String ThirdName="";
	String LastName="";
	String NationalID="";
	String Year="";
	String Month="";
	String Date="";
	String Password="";
	String MobileNo="";
	String Email="";
	String Refno="";
	String ExpectedResult="";
	ExtentReports extent;
	ExtentTest test;
	Pages Pages;
	Log Log;
	DBUtil DBUtil;

	// FACTORY - DATA PROVIDER
	@Factory (dataProvider="TestDataProvider")
	public AdminClientsEditIndividualClientErrorMsg(Map<Object, Object> testdatamap){
		this.testdatamap=testdatamap;
		this.TestScriptID=testdatamap.get("TestScriptID").toString();
		this.sBrowserTestData=testdatamap.get("Browser").toString();
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
			FullName=testdatamap.get("FullName").toString();
			SecondName=testdatamap.get("SecondName").toString();
			ThirdName=testdatamap.get("ThirdName").toString();
			LastName=testdatamap.get("LastName").toString();
			this.NationalID=testdatamap.get("NationalID").toString();
			this.Year=testdatamap.get("Year").toString();
			this.Month=testdatamap.get("Month").toString();
			this.Date=testdatamap.get("Date").toString();
			this.MobileNo=testdatamap.get("MobileNo").toString();
			this.Email=testdatamap.get("Email").toString();
			this.Refno=testdatamap.get("Refno").toString();
			this.ExpectedResult=testdatamap.get("ExpectedResult").toString();

			Log.ReportEvent("INFO", "Step1 : Verify Biller Application Launched Suceessfully");
			Pages.InvokeApplicationPage.launchApplication();	        
			Pages.InvokeApplicationPage.Chooseoptions(Log);	

			Log.ReportEvent("INFO", "Step2 : Verify Biller Login is Suceessful");
			Pages.AdminLoginPage.LoginToApplication(testdatamap,Log);

			Log.ReportEvent("INFO", "Step3 : Verify Error message in Edit Individual Client is Suceessful");
			Pages.AdminIndividualClientPage.VerifyEditIndClietErrorMsg(FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno,ExpectedResult);

			Log.ReportEvent("INFO", "Step4 : Logout  Suceessful");
			Pages.AdminLoginPage.Logout(EdaatOR.Logout,Log);

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
		String className=this.getClass().getSimpleName();
        test=ExtentManager.CreateExtentReportTest(extent,className,testdatamap.get("TestDescription").toString(), browserFromXML,TestScriptID);
		// INITIALIZE DRIVER
		initializeDriver=new InitializeDriver();
		driver=initializeDriver.initDriver(browserFromXML);
		driverEvent = new EventFiringWebDriver(driver);
		eventListener = new webDriverEventListener(test);
		driverEvent.register(eventListener);
		this.sBrowserTestData=browserFromXML;
		this.driver=driverEvent;
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
