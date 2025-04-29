/**
*
* Test Script Name                   :NA
* Objective                          :AdminSystemManagement Functionality
* Version                            :1.0
* Author                             :Kathirvelu M
* Created Date                       :8/09/2023
* Last Updated on                    :N/A
* Updated By                         :Basavaraj Mudnur
* Pre-Conditions                     :N/A
* Epic Details                       :N/A
* User Story Details                 :N/A

**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class AdminSystemMangementContactsPage extends BasePage {

	public AdminSystemMangementContactsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Systemmgmt_Menu)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}

	//Function Summary  : Method to Navigate Menu
	//Parameter Summary :N/A
	public void navigateContactsManagement(Log Log)
	{
		try {
			WebClick(EdaatOR.Systemmgmt_Menu);
			WebClickUsingJS(EdaatOR.Admin_ContactsManagement);
			if (CheckElementExists(EdaatOR.Admin_ContactsManagement_Header)) {
				
		    	Log.ReportEvent("PASS", "Contacts Management Page is Loaded Successfully");
				
			} else {
		    	Log.ReportEvent("FAIL", "Contacts Management Page is not Loaded Successfully");
		    	this.takeScreenShot();
		    	driver.quit();
		    	Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Contacts Management Page is not Loaded Successfully");
	    	this.takeScreenShot();
	    	e.printStackTrace();
	    	driver.quit();
	    	Assert.fail();
		}
		
    	
	}
	//Function Summary  : Method to Select Subject DropDown
	//Parameter Summary :N/A

	public void SelectSubject(String Subject)
	{
		WebClick(EdaatOR.Admin_ContactsMGM_SubjectDrop);
		WebSelect(EdaatOR.Admin_ContactsMGM_SubjectDrop, Subject);
	}
	
	//Function Summary  : Method to Select Status DropDown
   //Parameter Summary :N/A
	public void SelectStatus(String Status)
	{
		WebClick(EdaatOR.Admin_ContactsMGM_StatusDrop);
		WebSelect(EdaatOR.Admin_ContactsMGM_StatusDrop, Status);
	}
	//Function Summary  : Method to Select SenderType DropDown
   //Parameter Summary :N/A
	public void SelectSenderType(String Sender)
	{
		WebClick(EdaatOR.Admin_ContactsMGM_SenderTypeDrop);
		WebSelect(EdaatOR.Admin_ContactsMGM_SenderTypeDrop, Sender);
	}
	//Function Summary  : Method to Search Contacts
   //Parameter Summary :Name,Subject,Staus,SenderType
	public void verifySearchFunctionality(Map<Object, Object> testdatamap,Log Log)
	{
		try{
			WebEdit(EdaatOR.Admin_ContactsMGM_SenderName,testdatamap.get("Name").toString());
			SelectSubject(testdatamap.get("Subject").toString());
			Thread.sleep(1000);
			SelectStatus(testdatamap.get("Staus").toString());
       	    Thread.sleep(1000);
       	    SelectSenderType(testdatamap.get("SenderType").toString());
       	    Thread.sleep(1000);
        	WebClick(EdaatOR.Admin_ContactsMGM_SearchButton);
       	    Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.Admin_ContactsManagement_NoData)) {	
	        	Log.ReportEvent("FAIL", "Search Functionality is UnSuccessful");
	        	this.takeScreenShot();
	        	driver.quit();
	        	Assert.fail();
			} else {
	       	    VerifyValue1(getText("//td[text()='"+testdatamap.get("Name").toString()+"']"), testdatamap.get("Name").toString());
	       		Thread.sleep(2000);
	        	Log.ReportEvent("PASS", "Search Functionality is Successful");
			}
		}catch(Exception e){
			Log.ReportEvent("FAIL", "Search Functionality is UnSuccessful");
        	this.takeScreenShot();
        	e.printStackTrace();
        	driver.quit();
        	Assert.fail();
    }
}    
	//Function Summary  : Method to verifyMessageDetailsandClose
	//Parameter Summary :Name,Subject,Staus,SenderType
	public void verifyMessageDetailsandClose(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{
			verifySearchFunctionality(testdatamap, Log);
			if (CheckElementExists("//td[text()='"+testdatamap.get("Name").toString()+"']/ancestor::tr//a")) {
		  	    WebClickUsingJS("//td[text()='"+testdatamap.get("Name").toString()+"']/ancestor::tr//a");
	       	    Thread.sleep(2000);
	       	    verifyElementIsPresent(EdaatOR.Admin_ContactsMGM_MsgDetails_verify);
	       	    Thread.sleep(1000);
	       	    WebClick(EdaatOR.Admin_ContactsMGM_MsgDetails_Closebtn);
	       	    Thread.sleep(1000);
	        	Log.ReportEvent("PASS","Message Details & Close Functionality is Successful");	
				
			} else {
	            Log.ReportEvent("FAIL","Message Details & Close Functionality is UnSuccessful");	
        	    this.takeScreenShot();
        	    driver.quit();
        	    Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL","Message Details & Close Functionality is UnSuccessful");	
     	    this.takeScreenShot();
     	    e.printStackTrace();
     	   driver.quit();
     	    Assert.fail();
		}
	}
//Function Summary  : Message Reply Details
//Parameter Summary :Name,Subject,Staus,SenderType
	public void MessageReplyDetails(Map<Object, Object> testdatamap,Log Log)
	{
		try {
		      verifySearchFunctionality(testdatamap,Log);
	       	  Thread.sleep(1000);
	       	  if (CheckElementExists("//td[text()='"+testdatamap.get("Name").toString()+"']//ancestor::tr//a")) {
       		  WebClickUsingJS("//td[text()='"+testdatamap.get("Name").toString()+"']//ancestor::tr//a");
        	  Thread.sleep(1000);
		      WebClick(EdaatOR.Admin_ContactsMGM_Replybtn);
	       	  Thread.sleep(1000);
		      WebClear(EdaatOR.Admin_ContactsMGM_TextMsg);
	       	  Thread.sleep(1000);
		      WebEdit(EdaatOR.Admin_ContactsMGM_TextMsg,testdatamap.get("Description").toString());
	       	  Thread.sleep(1000);
		      WebClickUsingJS(EdaatOR.Admin_ContactsMGM_SendReply);
	       	  Thread.sleep(1000); 
			  Log.ReportEvent("PASS", "Message Details and Reply Functionality is Successful");	       	  
			} else {			
			  Log.ReportEvent("FAIL", "Message Details and Reply Functionality is UnSuccessful");
			  this.takeScreenShot();
			  driver.quit();
			  Assert.fail();
			}			  
		}
		catch(Exception e){
			  Log.ReportEvent("FAIL", "Message Details and Reply Functionality is UnSuccessful");
			  this.takeScreenShot();
			  e.printStackTrace();
			  driver.quit();
			  Assert.fail();
		    }
	} 
	//Function Summary  : Method to verify contacts Status
	//Parameter Summary : Status
	public void contactsStatus(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			WebClick(EdaatOR.Admin_ContactsMGM_StatusDrop);
			WebSelect(EdaatOR.Admin_ContactsMGM_StatusDrop, testdatamap.get("Status").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ContactsMGM_SearchButton);
       	    Thread.sleep(2000);
       	 if (CheckElementExists(EdaatOR.Admin_ContactsManagement_NoData)) {					
         	Log.ReportEvent("FAIL", "Search Based on Status [Seen,Replied,Not Seen] Functionality is UnSuccessful");
         	 this.takeScreenShot();
         	driver.quit();
         	 Assert.fail();
			} else {
			VerifyValue1(WebGetText("(//tr/td[.='"+testdatamap.get("Status").toString()+"'])[1]"),testdatamap.get("Status").toString());	
			Thread.sleep(1000);
	        Log.ReportEvent("PASS", "Search Based on Status [Seen,Replied,Not Seen] Functionality is Successful");
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Search Based on Status [Seen,Replied,Not Seen] Functionality is UnSuccessful");
        	 this.takeScreenShot();
        	 e.printStackTrace();
        	 driver.quit();
        	 Assert.fail();
		}
		
	}
	//Function Summary  : Method to view Contacts in System Management.
	//Parameter Summary : N/A.
	public void VerifyContactsGridView(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{
			if (CheckElementExists(EdaatOR.Admin_SymCorptable)) {
				verifySearchFunctionality(testdatamap, Log);
				Log.ReportEvent("PASS", "Grid View Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
			     Assert.fail();				
			}        	
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
		    Assert.fail();		
		}
	
	
	}
	//Function Summary  : Method to VerifyStatusToggle
    //Parameter Summary :N/A
		public void VerifyStatusToggle(Map<Object, Object> testdatamap,Log Log)
		{
			try
			{
				verifySearchFunctionality(testdatamap, Log);
				Thread.sleep(1000);
				if (CheckElementExists(EdaatOR.Admin_ContactsMGMToggle)) {
					WebClick(EdaatOR.Admin_ContactsMGMToggle);
				    Thread.sleep(1000);
					WebClick(EdaatOR.Admin_ContactsMGMToggle);
		        	Log.ReportEvent("PASS", "Status Toggle Functionality Is Successful");
				} else {
		        	Log.ReportEvent("FAIL", "Status Toggle Functionality Is UnSuccessful");
		        	this.takeScreenShot();
		        	driver.quit();
		            Assert.fail();
				}		
			}
			catch (Exception e) {
				Log.ReportEvent("FAIL", "Status Toggle Functionality Is UnSuccessful");
	        	this.takeScreenShot();
	        	e.printStackTrace();
	        	driver.quit();
	            Assert.fail();
			}
		
		
		}
	
}


	

