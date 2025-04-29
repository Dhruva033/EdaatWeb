/**
* Test Script Name  				 : N/A
* Objective                          : Verify the Dashboard Functionality.
* Version      						 : 1.0
* Author       						 : Arun Kumar MS
* Created Date 			      		 : 11/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : 
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;



public class BillerDashboardPages extends BasePage
{

	public BillerDashboardPages(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Dashboard)
	public WebElement Dashboard;
		
	    
	    public boolean Exists(){
	    	return super.Exists(Dashboard); 
		}
	  //Function Summary : Method to Search TrackedBillerName. 
	//Parameter Summary: TrackedBillerName,FromYear,FromMonth,ToYear,ToMonth.
	    public void TrackerBillerSearch(Map<Object, Object> testdatamap,Log Log)
	    {
	    	try {
		        WebClick(EdaatOR.Biller_Dashboardmenu);
		        Thread.sleep(1000);
		        WebClick(EdaatOR.Biller_TrackerName);
		        Thread.sleep(2000);
		        WebClickUsingActions("//li[text()='"+testdatamap.get("TrackedBillerName").toString()+"']");
		        Thread.sleep(1000);
		        WebClick(EdaatOR.Biller_Dashboard_FromDate);
		        Thread.sleep(1000);
		    	selectDropdownValue_PartialText(EdaatOR.Biller_Dashboard_Fromyear,testdatamap.get("FromYear").toString());
		    	Thread.sleep(1000);
		    	selectDropdownValue_PartialText(EdaatOR.Biller_Dashboard_FromMonth,testdatamap.get("FromMonth").toString());
		    	Thread.sleep(1000);
	        	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
	        	Thread.sleep(1000);
	        	WebClick(EdaatOR.Biller_Dashboard_TODate);
	        	Thread.sleep(1000);
	        	selectDropdownValue_PartialText(EdaatOR.Biller_Dashboard_Toyear,testdatamap.get("ToYear").toString());
	        	Thread.sleep(1000);
	        	selectDropdownValue_PartialText(EdaatOR.Biller_Dashboard_ToMonth,testdatamap.get("ToMonth").toString());
	        	Thread.sleep(1000);
	        	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
	        	Thread.sleep(5000);
	        	WebClick(EdaatOR.Biller_DashboardSearchBtn);
	        	Thread.sleep(10000);
	        	ValidateTwoValue(getText(EdaatOR.Biller_AttachetedImage_Link1), testdatamap.get("Value").toString());	
	        	this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Search TrackedBillerName is successful" + driver.getTitle() +" * DashBoard PASS * " );	
				Log.ReportEvent("PASS", "Verify Tracker Biller search is Suceessfull");
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Search TrackedBillerName is Failed" + driver.getTitle() +" * DashBoard FAIL * " );
				this.takeScreenShot();
			}

	    	
	    	
	    }
 //Function Summary : Method to Click on Dashboards. 
		//Parameter Summary: N/A
		public void BillerDashboardclick(Map<Object, Object> testdatamap,Log Log) {

	    	try {
		        WebClick(EdaatOR.Biller_Dashboardmenu);
		        Thread.sleep(1000);
	        	this.takeScreenShot();
		        WebClick(EdaatOR.Biller_Total_no_bills);
	        	verifyElementIsPresent(EdaatOR.Biller_BillsList_page);
		        Thread.sleep(2000);
	        	this.takeScreenShot();
	        	driver.navigate().back();
		        WebClick(EdaatOR.Biller_MyBalance);
	        	verifyElementIsPresent(EdaatOR.Biller_Warningmsg_BalanceDetails);
	        	Thread.sleep(2000);
	        	this.takeScreenShot();
	        	driver.navigate().back();
		        WebClick(EdaatOR.Biller_Totalamt_Transfer);
	        	verifyElementIsPresent(EdaatOR.Biller_TotalamtPaid_text);
	        	Thread.sleep(2000);
	        	this.takeScreenShot();
	        	driver.navigate().back();
		        WebClick(EdaatOR.Biller_InvoicesVolumeStatus);
	        	verifyElementIsPresent(EdaatOR.Biller_BillsList_page);
	        	Thread.sleep(2000);
	        	this.takeScreenShot();
	        	driver.navigate().back();
		        WebClick(EdaatOR.Biller_InvoicesValueStatus);
	        	verifyElementIsPresent(EdaatOR.Biller_BillsList_page);
	        	Thread.sleep(2000);
	        	this.takeScreenShot();
	        	driver.navigate().back();
				Thread.sleep(2000);
	        	this.takeScreenShot();
	        	test.log(Status.PASS,"#FUNC-Dashboards clickable" + driver.getTitle() +" * Dashboards clickable is PASS * " );
	        	Log.ReportEvent("PASS", "Verify Dashboards clickable is Successful");
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Dashboards clickable" + driver.getTitle() +" * Dashboards clickable is FAIL * " );
				this.takeScreenShot();
			}

	    	
	    	
	    
			
		}

}