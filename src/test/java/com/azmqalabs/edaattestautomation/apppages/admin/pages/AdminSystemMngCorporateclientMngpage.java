/**
 *
 * Test Script Name                   :NA
 * Objective                          :AdminSystemManagement functionality
 * Version                            :1.0
 * Author                             :Kathirvelu M
 * Created Date                       :8/09/2023
 * Last Updated on                    :N/A
 * Updated By                         :Kalpana I R
 * Pre-Conditions                     :N/A
 * Epic Details                       :N/A
 * User Story Details                 :N/A
 **/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.EOFException;
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

public class AdminSystemMngCorporateclientMngpage extends BasePage {

	public AdminSystemMngCorporateclientMngpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Systemmgmt_Menu)
	public WebElement Client;
	private Map<Object, Object> testdatamap;

	public boolean Exists() {
		return super.Exists(Client);
	}

	//Function Summary  : Method to NavigatetoCorporateClientsMng
	//Parameter Summary : N/A

	public void NavigatetoCorporateClientsMng(Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_SysMgmClient_CorpoclientMgmMenu);
			if (CheckElementExists(EdaatOR.Admin_CorporateClient_Header)) {
				Log.ReportEvent("PASS", "Corporate Clients Page is Loaded Successfully");	
			} else {
				Log.ReportEvent("FAIL", "Corporate Clients Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {		
			Log.ReportEvent("FAIL", "Corporate Clients Page is not Loaded Successfully");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary  : Method to Entersearchitem
	//Parameter Summary : Corporatename,crnumber
	public void Entersearchitem(Map<Object, Object> testdatamap) throws InterruptedException {

		WebEdit(EdaatOR.Admin_Corporatename_efield,testdatamap.get("Corporatename").toString());
		WebEdit(EdaatOR.Admin_CorporateClient_crefield,testdatamap.get("crnumber").toString());
		Thread.sleep(1000);
		SelectClientDropdown(testdatamap);
		WebClick(EdaatOR.Admin_Corporateclient_srchbtn);
		Thread.sleep(1000);
		takeScreenShot();
	}
	//Function Summary  : Method to VerifyCorporatenameClick
	//Parameter Summary : Corporatename
	public void VerifyCorporateNameClick(Map<Object, Object> testdatamap,Log Log) {
		try {
			carporateClientSearch(testdatamap, Log);
			WebClick("//a[text()='"+testdatamap.get("Corporatename").toString()+"']");
			switchToWindow();
			if (getText("//h6[text()='"+testdatamap.get("Corporatename").toString()+"']").equals(testdatamap.get("Corporatename").toString())) {
				VerifyValue1(getText("//h6[text()='"+testdatamap.get("Corporatename").toString()+"']"),testdatamap.get("Corporatename").toString());	
				Log.ReportEvent("PASS", "Corporate name Click Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Corporate name Click Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Corporate name Click Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary  : Method to select client status dropdown
	//Parameter Summary : Client Status
	public void SelectClientDropdown(Map<Object, Object> testdatamap)
	{
		WebClick(EdaatOR.Admin_SymCorpoClientstatus);
		WebClick("//option[text()='"+testdatamap.get("Client Status").toString()+"']");
	}
	//Function Summary  : Method to Verify Request Record Button
	//Parameter Summary : HistoryPopup
	public void VerifyRequestRecordButton(Map<Object, Object> testdatamap,Log Log) {

		try {	
			WebClick(EdaatOR.Admin_Corporateclient_RecordBtn);
			Thread.sleep(2000);
			if (getText(EdaatOR.Admin_Corporateclient_HistoryPopup).equals(testdatamap.get("HistoryPopup").toString())) {
				VerifyValue1(getText(EdaatOR.Admin_Corporateclient_HistoryPopup),testdatamap.get("HistoryPopup").toString());			
				Log.ReportEvent("PASS", "Request Record Button Clickable Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Request Record Button Clickable Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}       	
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Request Record Button Clickable Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}			
	}
	//Function Summary  : Method to Verify Management Search 
	//Parameter Summary : ClientStatus
	public void carporateClientSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException
	{
		try {
			WebEdit(EdaatOR.Admin_SymCorpoName,testdatamap.get("Corporatename").toString());
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_SymCorpoCrNumber,testdatamap.get("crnumber").toString());
			Thread.sleep(2000);
			SelectClientDropdown(testdatamap);
			WebClick(EdaatOR.Admin_Corporateclient_srchbtn);
			Thread.sleep(2000);
			if (getText("//a[text()='"+testdatamap.get("Corporatename").toString()+"']/ancestor::tr//td[4]").equals(testdatamap.get("crnumber").toString())) {
				VerifyValue1(getText("//a[text()='"+testdatamap.get("Corporatename").toString()+"']/ancestor::tr//td[4]"),testdatamap.get("crnumber").toString());
				Log.ReportEvent("PASS", "Search Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Search Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Search Functionality is UnSuccessful");	    
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();	    	
			Assert.fail();
		}			
	}
	//Function Summary  : Method to VerifyCorporateClientStatustoggel
	//Parameter Summary : Corporatename,crnumber,Active,CorporateName,InActive
	public void VerifyCorporateClientStatustoggel(Map<Object, Object> testdatamap,Log Log) {	
		try
		{
			if(CheckElementExists("//h5[text()='"+testdatamap.get("Active").toString()+"']"))
			{
				VerifyValue1(getText("//h5[text()='"+testdatamap.get("Active").toString()+"']"),testdatamap.get("Active").toString());
				Thread.sleep(2000);
				WebEdit(EdaatOR.Admin_Symstatustoggletextarea,testdatamap.get("Textarea").toString());
				Thread.sleep(2000);
				WebClick(EdaatOR.Admin_Symstatustoggleyesbtn);
				WebClick("//a[text()='"+testdatamap.get("Corporatename").toString()+"']//ancestor::tr//label[1]");
				Thread.sleep(2000); 
				VerifyValue1(getText("//h5[text()='"+testdatamap.get("InActive").toString()+"']"),testdatamap.get("InActive").toString());
				WebEdit(EdaatOR.Admin_Symstatustoggletextarea,testdatamap.get("Textarea").toString());
				Thread.sleep(2000);
				WebClick(EdaatOR.Admin_Symstatustoggleconformactivation);
				Thread.sleep(2000);	
				Log.ReportEvent("PASS", "Status Toggle Functionality is Successful");
			}
			else if(getText("//h5[text()='"+testdatamap.get("InActive").toString()+"']").equals(testdatamap.get("InActive").toString()))
			{
				VerifyValue1(getText("//h5[text()='"+testdatamap.get("InActive").toString()+"']"),testdatamap.get("InActive").toString());
				Thread.sleep(2000);
				WebEdit(EdaatOR.Admin_Symstatustoggletextarea,testdatamap.get("Textarea").toString());
				Thread.sleep(2000);
				WebClick(EdaatOR.Admin_Symstatustoggleyesbtn);
				Thread.sleep(1000);
				WebClick("//a[text()='"+testdatamap.get("Corporatename").toString()+"']//ancestor::tr//label[1]");
				Thread.sleep(2000);
				VerifyValue1(getText("//h5[text()='"+testdatamap.get("Active").toString()+"']"),testdatamap.get("Active").toString());
				WebEdit(EdaatOR.Admin_Symstatustoggletextarea,testdatamap.get("Textarea").toString());
				Thread.sleep(2000);	
				WebClick(EdaatOR.Admin_Symstatustoggleconformactivation);
				Thread.sleep(2000);	
				Log.ReportEvent("PASS", "Status Toggle Functionality is Successful");
			}
			else {				
				Log.ReportEvent("FAIL", "Status Toggle Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();	 
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Status Toggle Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();	 
			Assert.fail();


		}
	}
	//Function Summary  : Method to Verify Statustoggle
	//Parameter Summary : Corporatename,crnumber
	public void CorporateClientStatustoggle(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			Thread.sleep(3000);
			WebClick("//a[text()='"+testdatamap.get("Corporatename").toString()+"']//ancestor::tr//label[1]");
			VerifyCorporateClientStatustoggel(testdatamap,Log);
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Status Toggle Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();	 
			Assert.fail();
		}
	}

	//Function Summary  : Method to Verify Management Search based on Registered,added and Approved
	//Parameter Summary : ClientStatus
	public void CorporateClientManagementSearchBasedOnClientStatus(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			String clientstatus = testdatamap.get("ClientStatus").toString();
			if(clientstatus.equalsIgnoreCase("registered")||clientstatus.equalsIgnoreCase("approved"))
			{
				selectDropdownValue_PartialText(EdaatOR.AdminSystem_Corporate_Clientstatus,clientstatus);
				Thread.sleep(2000);
				WebClick(EdaatOR.AdminSystem_Corporate_Searchbtn);
				Thread.sleep(2000);  
				if (getText(EdaatOR.Admin_Sys_CorpVerify).equals("Yes")){
					VerifyValue1(getText(EdaatOR.Admin_Sys_CorpVerify),"Yes");
					Log.ReportEvent("PASS", "Search Based on the Client Status [Registered,Added,Approved] Functionality is Successful");
				} else {
					Log.ReportEvent("FAIL", "Search Based on the Client Status [Registered,Added,Approved] Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}			       
			}
			else {
				selectDropdownValue_PartialText(EdaatOR.AdminSystem_Corporate_Clientstatus,clientstatus);
				Thread.sleep(2000);
				WebClick(EdaatOR.AdminSystem_Corporate_Searchbtn);
				Thread.sleep(2000);
				if (getText(EdaatOR.Admin_Sys_CorpVerify).equals("No")){
					VerifyValue1(getText(EdaatOR.Admin_Sys_CorpVerify),"No");
					Log.ReportEvent("PASS", "Search Based on the Client Status [Registered,Added,Approved] Functionality is Successful");
				} else {
					Log.ReportEvent("FAIL", "Search Based on the Client Status [Registered,Added,Approved] Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();	 
					Assert.fail();
				}		
			}   
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Search Based on the Client Status [Registered,Added,Approved] Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();	 
			Assert.fail(); 
		}        

	}
	//Function Summary  : Method to Verify CorporateClient Management GridView
	//Parameter Summary : N/A
	public void CorporateclientMgmGridView(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			if (CheckElementExists(EdaatOR.Admin_SysMgm_CorpoclientDetails)) {
				carporateClientSearch(testdatamap, Log);
				Log.ReportEvent("PASS", "Grid view Details Functionality is Successful");	
			} else {
				Log.ReportEvent("FAIL", "Grid view Details Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();	 
				Assert.fail();
			}
		} 
		catch (Exception e) {			
			Log.ReportEvent("FAIL", "Grid view Details Functionality is UnSuccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();	 
			Assert.fail();
		}
	}
	//Function Summary  : Method to VerifyCorporatenameClick
	//Parameter Summary : Corporatename
	public void SuspendAccount(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			WebClick(EdaatOR.Admin_CorpMGMSettingBtn);
			Thread.sleep(1000);
			String client=testdatamap.get("AccountStatus").toString();
			if(client.equalsIgnoreCase("Suspended")) {
				WebClickUsingJS(EdaatOR.Admin_CorpMGMSuspendBtn);
				Thread.sleep(1000);
			}
			else{
				WebClickUsingJS(EdaatOR.Admin_CorpMGMSuspendPermanentyBtn);
				Thread.sleep(1000);
			}
			WebClick(EdaatOR.Admin_CorpMGMSuspendReasonDrop);
			Thread.sleep(800);
			WebClickUsingActions("//li[normalize-space(text())='"+testdatamap.get("AccountSuspendedReasons").toString()+"']");
			WebClick(EdaatOR.Admin_CorpMGMSuspendYesBtn);
			Thread.sleep(800);			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	//Function Summary  : Method to Search corporate client
	//Parameter Summary : CompanyName
	public void SearchcorpClient(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			WebEdit(EdaatOR.Admin_SymCorpoName,testdatamap.get("CompanyName").toString());
			Thread.sleep(1000);
			SelectClientDropdown(testdatamap);
			WebClick(EdaatOR.Admin_Corporateclient_srchbtn);		
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}


	//Function Summary  : Method to verify settings button
	//Parameter Summary : AccountStatus
	public void CorporateClientSettingsBtn(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			SearchcorpClient(testdatamap,Log);
			Thread.sleep(800);
			SuspendAccount(testdatamap,Log);
			if (CheckElementExists(EdaatOR.AdminSystem_Coporate_SuspendReason_Error)) {
				Log.ReportEvent("FAIL", "Account Setting Button Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			} else {
				SearchcorpClient(testdatamap,Log);
				Thread.sleep(800);	
				if (CheckElementExists("//td[contains(text(),'"+testdatamap.get("AccountStatus").toString()+"')]")) {
					verifyElementIsPresent("//td[contains(text(),'"+testdatamap.get("AccountStatus").toString()+"')]");		
					Log.ReportEvent("PASS", "Account Setting button Functionality is Successful");					
				} else {
					Log.ReportEvent("FAIL", "Account Setting Button Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();	 
					Assert.fail();				
				}	        	
			}		
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Account Setting Button Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();	 
			Assert.fail();			
		}
	}

	public void CorporateClientSettingsBtnErrorMsg(Map<Object, Object> testdatamap,Log Log) {

		try {
			String client=testdatamap.get("AccountStatus").toString();
			String Expected = testdatamap.get("Expected").toString(); 
			SearchcorpClient(testdatamap,Log);
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_CorpMGMSettingBtn);
			Thread.sleep(1000);
			if(client.equalsIgnoreCase("Suspended Permanently")) {
				WebClickUsingJS(EdaatOR.Admin_CorpMGMSuspendBtn);
				Thread.sleep(1000);
			}
			else if(client.equalsIgnoreCase("Suspended")){
				WebClickUsingJS(EdaatOR.Admin_CorpMGMSuspendPermanentyBtn);
				Thread.sleep(1000);
			}
			WebClickUsingJS(EdaatOR.Admin_CorpMGMSuspendYesBtn);
			Thread.sleep(2000); 
			if(getText(EdaatOR.AdminSystem_Corporate_Accountstatuserrormsg).equals(Expected))
			{
			 Log.ReportEvent("PASS", "Verify 'Please choose a proper action' Error Message is Successful");
			}
			else if(getText(EdaatOR.AdminSystem_Corporate_SuspendReasonerrormsg).equals(Expected)){
				Log.ReportEvent("PASS", "Verify 'Please state the reasons for the suspension' Error Message is Successful");			
			}
			else
			{
				Log.ReportEvent("FAIL", "Verify Error Message for Corporate Client Account Setting Button is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();     
			}
			WebClick(EdaatOR.AdminSystem_Corporate_cancelbtn);			
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Error Message for Corporate Client Account Setting Button is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();     
		}
	}

}
