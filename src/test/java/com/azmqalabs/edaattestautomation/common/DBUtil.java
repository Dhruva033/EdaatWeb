package com.azmqalabs.edaattestautomation.common;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;

public class DBUtil {

	private WebDriver driver;
	private ExtentTest test;
	
	public DBUtil(WebDriver driver,ExtentTest testReport)
	{
		 this.driver=driver;
		 this.test=testReport;
	}
	
	public void UpdateTestResultInDB(Map<Object, Object> testresultsmap) throws ClassNotFoundException, SQLException
	{
		LogTestStep("", "");
		ResultUpdateIntoDB(testresultsmap);
	}
	
	public void UpdateTestResultExceptionInDB(Map<Object, Object> testresultsmap) throws ClassNotFoundException, SQLException
	{
		ResultUpdateIntoDB(testresultsmap);
	}
    public void ResultUpdateIntoDB(Map<Object, Object> testresultsmap) throws SQLException, ClassNotFoundException {
    	try{
    	String sTestResultsDB=Config.Get("TEST.RESULTS.DB");
    	//String dbUrl = "jdbc:mysql://localhost:3306/testautomation";		
    	String dbUrl ="jdbc:mysql://"+sTestResultsDB+"/cutestdb"; //"jdbc:mysql://"+sTestResultsDB+"/testautomation";		
    	String username ="cutest"; //"root";	
    	String password ="cutest"; //"anil";				
    	
    	Status testingStatus=test.getStatus();
    	//String sTabName=RecTestStatus.TestDataTabName;
    	//testFinalStatus=testingStatus.toString();
    	
    	
    	Class.forName("com.mysql.jdbc.Driver");	
    	Connection con = DriverManager.getConnection(dbUrl,username,password);
    	Statement stmt = con.createStatement();	
    	
    	String testexecutedby="";
    	testexecutedby=System.getProperty("user.name");
    	String testmachine="";
    	testmachine=InetAddress.getLocalHost().getHostName();
    	String testcyclename="";
    	testcyclename=Config.GetProperty("TESTCYCLE.NAME");
    	String projectname="";
    	projectname=Config.GetProperty("PROJECT.NAME");
    	String bankname="";
    	bankname=Config.GetProperty("BANK.NAME");
    	String appname="";
    	appname=Config.GetProperty("AUT.NAME");
    	String datafilename="";
    	datafilename=Config.GetProperty("TESTDATA.LOCATION");
    	
    	System.out.println("URL and Login Details:  "+GlobalConstant.GLOBALTESTDATALOGINMAP);

    	String lastexecuteddate="";
    	lastexecuteddate=""+System.nanoTime()+"";
    	
    	String 	strQueryUpdExecStatus="INSERT INTO testresults (testid,teststatus,testexecutedby,testmachine,testcyclename,projectname,bankname,appname,lastexecuteddate, testdatatabname,testdataused,testdatafilename,testenv) VALUES ('"+testresultsmap.get("TestScriptID").toString()+"','"+testingStatus+"','"+testexecutedby+"','"+testmachine+"','"+testcyclename+"','"+projectname+"','"+bankname+"','"+appname+"','"+lastexecuteddate+"','"+testresultsmap.get("TestDataName").toString()+"','"+testresultsmap+"','"+datafilename+"','"+GlobalConstant.GLOBALTESTDATALOGINMAP+"')";
    	
    	stmt.executeUpdate(strQueryUpdExecStatus);

    	con.close();
    	}
    	catch(Exception e)
    	{}
    }
	
	
	public void LogTestStep(String sStatus, String sDescription)
	{
		if (sStatus.equalsIgnoreCase("fail"))
			test.log(Status.FAIL,sDescription);
		else if (sStatus.equalsIgnoreCase("fail"))
			test.log(Status.FAIL,sDescription);
		else if (sStatus.equalsIgnoreCase("pass"))
			test.log(Status.PASS,sDescription);
		else if (sStatus.equalsIgnoreCase("info"))
			test.log(Status.INFO,sDescription);
	}
	
}
