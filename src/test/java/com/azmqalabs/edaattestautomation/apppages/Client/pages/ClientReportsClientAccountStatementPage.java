/**
* Test Script Name                      : NA
* Objective                             : Verify to Client Reports ClientAccountStatement Page Functionality.
* Version                               : 1.0
* Author                                : Basavaraj Mudnur
* Created Date                          : 
* Last Updated on                       : N/A
* Updated By   			 			    : Basavaraj Mudnur
* Pre-Conditions					    : N/A
* Epic Details						 	: N/A
* User Story Details				 	: N/A
**/
package com.azmqalabs.edaattestautomation.apppages.Client.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class ClientReportsClientAccountStatementPage extends BasePage {
	public ClientReportsClientAccountStatementPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.ClientAccountStatementtext)
	public WebElement ClientStatement;


	public boolean Exists(){
		return super.Exists(ClientStatement); 
	}


	//Function Summary   : Navigate to "Client Account Statement" Page.
	//Parameter Summary  : N/A
	public void navigateToClientAccountStatement(Log Log) throws InterruptedException
	{
		try {
			WebClickUsingJS(EdaatOR.Client_ClientAccountStatementMenu);	
			Thread.sleep(1000);
			switchToWindow();
			waitForPageToLoad();
			this.takeScreenShot();
			test.log(Status.PASS,"Navigate to Client Account Statement" + driver.getTitle() +" * Navigate to Client Account Statement is Pass * " );
        	Log.ReportEvent("PASS", "Verify Navigate to Client Account Statement Page is successfull");
	
		}
		catch(Exception e){
			this.takeScreenShot();
			test.log(Status.FAIL,"Navigate to Client Account Statement" + driver.getTitle() +" *Navigate to Client Account Statement is FAIL * " );		
		}
	 
	}

	//Function Summary   : Method to Verify  Client Account Statement  Report.
	//Parameter Summary  : BillerName,Invoice Contract,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate,ClientName
	public void VerifyAccountstatement(Map<Object, Object> testdatamap,Log Log) {
		try {
			    selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName, "BillerName");
			    Thread.sleep(1000);
			    WebEdit(EdaatOR.Client_ClientAccountStatement_InvoiceContactfield, testdatamap.get("Invoice Contract").toString());
		        WebClick(EdaatOR.Biller_Dashboard_FromDate);
		        Thread.sleep(1000);
		    	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Fromyear,testdatamap.get("FromYear").toString());
		    	Thread.sleep(1000);
		    	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_FromMonth,testdatamap.get("FromMonth").toString());
		    	Thread.sleep(1000);
	        	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
		    	Thread.sleep(1000);
	        	WebClick(EdaatOR.Client_ClientAccountStatement_TODate);
	        	Thread.sleep(1000);
	        	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Toyear,testdatamap.get("ToYear").toString());
	        	Thread.sleep(1000);
	        	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_ToMonth,testdatamap.get("ToMonth").toString());
	        	Thread.sleep(1000);
	        	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
	        	WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);
	        	switchToWindow();
	        	swithchToFrame(EdaatOR.Client_reportFrame);
	        	VerifyValue1(WebGetText(EdaatOR.Client_ClientAccountStatement_Reportclientname),testdatamap.get("ClientName").toString());
	        	Thread.sleep(2000);
	        	this.takeScreenShot();
				switchBacktoParentwindow();
			    this.takeScreenShot();
			    test.log(Status.PASS,"Exported report for the selected Biller" + driver.getTitle() +" * Exported report for the selected Biller is Pass * " );
	        	Log.ReportEvent("PASS", " Verify the exported report for the selected Biller is successfull");
	
		}
		catch(Exception e){
			this.takeScreenShot();
			test.log(Status.FAIL,"Exported report for the selected Biller" + driver.getTitle() +" *Exported report for the selected Biller is FAIL * " );		
		}
				
	}
	//Function Summary   : Method to Verify  Client Account Statement  Report.
	//Parameter Summary  : BillerName,Invoice Contract,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate,ClientName
		public void VerifySerachFunctionality(Map<Object, Object> testdatamap,Log Log) {
		try {
			    navigateToClientAccountStatement(Log);
			    Thread.sleep(2000);
			    selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName, testdatamap.get("BillerName").toString());
			    Thread.sleep(1000);
			    WebEdit(EdaatOR.Client_ClientAccountStatement_InvoiceContactfield, testdatamap.get("Invoice Contract").toString());
		        WebClick(EdaatOR.Biller_Dashboard_FromDate);
		        Thread.sleep(1000);
		    	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Fromyear,testdatamap.get("FromYear").toString());
		    	Thread.sleep(1000);
		    	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_FromMonth,testdatamap.get("FromMonth").toString());
		    	Thread.sleep(1000);
	        	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
		    	Thread.sleep(1000);
	        	WebClick(EdaatOR.Client_ClientAccountStatement_TODate);
	        	Thread.sleep(1000);
	        	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Toyear,testdatamap.get("ToYear").toString());
	        	Thread.sleep(1000);
	        	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_ToMonth,testdatamap.get("ToMonth").toString());
	        	Thread.sleep(1000);
	        	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
	        	WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);
	        	switchToWindow();
	        	swithchToFrame(EdaatOR.Client_reportFrame);
	        	VerifyValue1(WebGetText(EdaatOR.Client_ClientAccountStatement_Reportclientname),testdatamap.get("ClientName").toString());
	        	Thread.sleep(2000);
	        	this.takeScreenShot();
				switchBacktoParentwindow();
			    this.takeScreenShot();
			    test.log(Status.PASS,"Exported report for the selected Biller" + driver.getTitle() +" * Exported report for the selected Biller is Pass * " );
	        	Log.ReportEvent("PASS", " Verify Account Statement Search is Sucessful");
	
		}
		catch(Exception e){
			this.takeScreenShot();
			test.log(Status.FAIL,"Exported report for the selected Biller" + driver.getTitle() +" *Exported report for the selected Biller is FAIL * " );		
		}
				
	}

		public void Fromdate(Map<Object, Object> testdatamap) throws InterruptedException
		{
			    WebClick(EdaatOR.Biller_Dashboard_FromDate);
		        Thread.sleep(1000);
		    	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Fromyear,testdatamap.get("FromYear").toString());
		    	Thread.sleep(1000);
		    	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_FromMonth,testdatamap.get("FromMonth").toString());
		    	Thread.sleep(1000);
	        	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			
		}
		public void Todate(Map<Object, Object> testdatamap) throws InterruptedException
		{
			WebClick(EdaatOR.Client_ClientAccountStatement_TODate);
        	Thread.sleep(1000);
        	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Toyear,testdatamap.get("ToYear").toString());
        	Thread.sleep(1000);
        	selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_ToMonth,testdatamap.get("ToMonth").toString());
        	Thread.sleep(1000);
        	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			
		}
		//Function Summary   : Method to Verify  Client Account Statement  Report.
		//Parameter Summary  : BillerName,Invoice Contract,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate,ClientName
			public void VerifySerachFunctionalityErrorMsg(Map<Object, Object> testdatamap,Log Log) {
			try {
				    navigateToClientAccountStatement(Log);
				    Thread.sleep(2000);
				    String Error=testdatamap.get("Type").toString();
				    if(Error.equalsIgnoreCase("FromandTo"))
				    {
				    selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName, testdatamap.get("BillerName").toString());
				    Thread.sleep(1000);					     
		        	WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);
		        	verifyElementIsPresent(EdaatOR.Client_ClientAccountStatement_FromerrorMsg);
		        	verifyElementIsPresent(EdaatOR.Client_ClientAccountStatement_ToerrorMsg);	        	
		        	this.takeScreenShot();			
				    test.log(Status.PASS,"Client Account Statement Reports error Msg is pass" + driver.getTitle() +" * Client Account Statement Reports From and To date error Msg is pass * " );
		        	Log.ReportEvent("PASS", " Verify Account Statement Search is Sucessful");

				    }
				    if(Error.equalsIgnoreCase("Todate"))
				    {
				    selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName, testdatamap.get("BillerName").toString());
				    Thread.sleep(1000);	
				    Fromdate(testdatamap);
				    Thread.sleep(1000);	
		        	WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);		        	
		        	verifyElementIsPresent(EdaatOR.Client_ClientAccountStatement_ToerrorMsg);	       	
		        	this.takeScreenShot();			
				    test.log(Status.PASS,"Client Account Statement Reports error Msg is pass" + driver.getTitle() +" * Client Account Statement Reports From date error Msg is pass * " );
				}
				    if(Error.equalsIgnoreCase("Fromdate"))
				    {
				    selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName, testdatamap.get("BillerName").toString());
				    Thread.sleep(1000);	
				    Todate(testdatamap);
				    Thread.sleep(1000);	
		        	WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);		        	
		        	verifyElementIsPresent(EdaatOR.Client_ClientAccountStatement_FromerrorMsg);       	
		        	this.takeScreenShot();			
				    test.log(Status.PASS,"Client Account Statement Reports error Msg is pass" + driver.getTitle() +" * Client Account Statement Reports From date error Msg is pass * " );
				}
				    if(Error.equalsIgnoreCase("BillerName"))
				    {
					selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName, testdatamap.get("BillerName").toString());
				    Fromdate(testdatamap);
				    Thread.sleep(1000);	
				    Todate(testdatamap);
				    Thread.sleep(1000);	
				    Thread.sleep(1000);	
		        	WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);		        	
		        	verifyElementIsPresent(EdaatOR.Client_ClientAccountStatement_BillernameerrorMsg);       	
		        	this.takeScreenShot();			
				    test.log(Status.PASS,"Client Account Statement Reports error Msg is pass" + driver.getTitle() +" * Client Account Statement Reports Biller Name error Msg is pass * " );
				}
			}
			catch(Exception e){
				this.takeScreenShot();
				test.log(Status.FAIL,"Client Account Statement Reports error Msg is Fail" + driver.getTitle() +" *Client Account Statement Reports Biller Name error Msg is FAIL * " );		
			}
					
		}
			//VerifyValue1(WebGetText(EdaatOR.Client_ClientAccountStatement_Reportclientname),testdatamap.get("ClientName").toString());
        //	Thread.sleep(2000);
}