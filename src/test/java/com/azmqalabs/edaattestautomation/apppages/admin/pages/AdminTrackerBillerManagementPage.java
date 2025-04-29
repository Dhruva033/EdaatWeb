/**
 * Test Script Name                   : N/A
 * Objective                          : Admin Tracked Biller Management related functions
 * Version                            : 1.0
 * Author                             : Kathirvelu M
 * Created Date                       : 5/07/2023
 * Last Updated on                    : N/A
 * Updated By                         : Dhruva Kumar S
 * Pre-Conditions                     : N/A
 * Epic Details                       : N/A
 * User Story Details                 : N/A
 **/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
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
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminNotApprovedMgmCloseBiller;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminTrackerMgmGridView;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminTrackerMgmToggleStatus;

public class AdminTrackerBillerManagementPage extends BasePage {

	public AdminTrackerBillerManagementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_SystemMgm_SearchItem)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}

	//Function Summary   : Method to enterOnSearchItem
	//Parameter Summary  : searchItem
	public void enterOnSearchItem(String searchItem) throws Exception {

		WebEdit(EdaatOR.Admin_SystemMgm_SearchItem, searchItem);
	}

	//Function Summary   : Method to clickOnSearchBtn
	//Parameter Summary  : N/A


	public void clickOnSearchBtn()  throws Exception{

		WebClick(EdaatOR.Admin_SystemMgm_Searchbtn);
	}


	//Function Summary   : Method to searchNotApprovedBillerMgm
	//Parameter Summary  : Search
	public void searchNotApprovedBillerMgm(String Search) throws Exception {
		enterOnSearchItem(Search);
		clickOnSearchBtn();
		waitForPageToLoad();
		Thread.sleep(1000);
	}


	//Function Summary   : Method to verifySearchTrackerBiller
	//Parameter Summary  : CompanyName
	public void verifySearchTrackerBiller(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			enterOnSearchItem(testdatamap.get("CompanyName").toString());
			clickOnSearchBtn();
			if (getText("//td[text()='"+testdatamap.get("CompanyName").toString()+"']").equals(testdatamap.get("CompanyName").toString())) {
				Log.ReportEvent("PASS", "Search Functionality is Successful");	
			} else {
				Log.ReportEvent("FAIL", "Search Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}				
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Search Functionality is UnSuccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();	
		}
	}

	public void VerifyGridViewTrackerManagement(Map<Object, Object> testdatamap,Log Log) throws Exception {

		try {
			enterOnSearchItem(testdatamap.get("CompanyName").toString());
			clickOnSearchBtn();
			Thread.sleep(5000);
			if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)) {
				AdminTrackerMgmGridView.record=false;
			}
			else if(getText("//td[text()='"+testdatamap.get("CompanyName").toString()+"']").equals(testdatamap.get("CompanyName").toString())) {				
				VerifyValue1(EdaatOR.Admin_TrackerBillerMangm_CorpName,testdatamap.get("CompanyName").toString());
				VerifyValue1(EdaatOR.Admin_TrackerBillerMangm_CorpType,"Corporate");
				VerifyValue1(EdaatOR.Admin_TrackerBillerMangm_EmailConf,"No");
				verifyElementIsPresent(EdaatOR.Admin_TrackerBillerMangm_ToggleBtn);
				verifyElementIsPresent(EdaatOR.Admin_TrackerBillerMangm_EyeIcon);
				AdminTrackerMgmGridView.record=true;		
				Log.ReportEvent("PASS", "Grid View Details Functionality is Successful");	
			}
			else {
				Log.ReportEvent("FAIL", "Grid View Details Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}		
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Grid View Details Functionality is UnSuccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary   : Method to verifyTrackerBillerMgmToggle
	//Parameter Summary  : CompanyName,InActive,Active
	public void verifyTrackerBillerMgmToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			enterOnSearchItem(testdatamap.get("CompanyName").toString());
			clickOnSearchBtn();
			if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)) {
				AdminTrackerMgmToggleStatus.record=false;
			}
			else if(getText("//td[text()='"+testdatamap.get("CompanyName").toString()+"']").equals(testdatamap.get("CompanyName").toString())) {				
				VerifyValue1(EdaatOR.Admin_TrackerBillerMangm_CorpName,testdatamap.get("CompanyName").toString());	
				Log.ReportEvent("PASS", "Search Functionality is Successful");	
				if (CheckElementExists(EdaatOR.Admin_ApproveMgn_ToggleBtn)) {
					verifyElementIsPresent(EdaatOR.Admin_ApproveMgn_ToggleBtn);
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Admin_ApproveMgn_ToggleBtn);
					Thread.sleep(2000);
					VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("InActive").toString());
					WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Admin_ApproveMgn_ToggleBtn);
					VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
					Thread.sleep(2000);
					AdminTrackerMgmToggleStatus.record=true;
					Log.ReportEvent("PASS", "Status Toggle and Activate Biller / Corporate button Functionality is Successful");
				}
				else {				
					Log.ReportEvent("FAIL", "Status Toggle and Activate Biller / Corporate button Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}		
			else {	
				Log.ReportEvent("FAIL", "Search Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Status Toggle and Activate Biller / Corporate button Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	public void clickOnApproval()  throws Exception {

		WebClick(EdaatOR.Admin_SystemMgm_ApprovalBtn);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_SystemMgm_ApprovalYesBtn);
		Thread.sleep(1000);
		waitForPageToLoad();
	}

	public void clickOnActivateLink()  throws Exception{
		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
	}

	//Function Summary   : Method to verifyIndividualClientIDClickable
	//Parameter Summary  : N/A	
	public void verifyIndividualClientIDClickable(Log Log) throws Exception {
		try {
			String clientID=getText(EdaatOR.Admin_TrackerBillerMangm_IndiviClenteID);
			WebClick(EdaatOR.Admin_TrackerBillerMangm_IndiviClenteID);
			waitForPageToLoad();
			switchToWindow();
			String row=getrowcount();
			if (clientID.equals(row)) {
				VerifyValue1(clientID, row);
				Log.ReportEvent("PASS", "Total Individual Clients is Clickable Functionality is Successful");	
			} else {
				Log.ReportEvent("FAIL", "Total Individual Clients is Clickable Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Total Individual Clients is Clickable Functionality is UnSuccessful");	
			this.takeScreenShot();
			driver.quit();
			e.printStackTrace();
			Assert.fail();
		}

	}
	public String getrowcount() {
		List<WebElement> allrows = driver.findElements(By.xpath(EdaatOR.Admin_IndividualClient_RowCount));
		waitForPageToLoad();
		int row_count = allrows.size();
		String rowcount = Integer.toString(row_count);
		return rowcount;
	}
	//Function Summary   : Method to click on and verify "Total corporate clients"
	//Parameter Summary :N/A
	public void verifyCorporateClientIDClickable(Log Log) throws Exception {
		try {
			String clientID=getText(EdaatOR.Admin_TrackerBillerMangm_CopoClientID);
			WebClick(EdaatOR.Admin_TrackerBillerMangm_CopoClientID);
			waitForPageToLoad();
			switchToWindow();
			Thread.sleep(2000);
			String rowCount=getRowCounts() ;
			if (clientID.equals(rowCount)) {
				VerifyValue1(clientID, rowCount);
				Log.ReportEvent("PASS", "Total Corporate Clients is Clickable Functionality is Successful");	
			} else {
				Log.ReportEvent("FAIL", "Total Corporate Clients is Clickable Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {	
			Log.ReportEvent("FAIL", "Total Corporate Clients is Clickable Functionality is UnSuccessful");	
			this.takeScreenShot();
			driver.quit();
			e.printStackTrace();
			Assert.fail();
		}		
	}
	//Function Summary   : Method to count "Total corporate clients"
	//Parameter Summary :N/A
	public String getRowCounts() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Admin_IndividualClient_RowCount));
		waitForPageToLoad();
		int Rcount =invoice.size();
		String rowCount=Integer.toString(Rcount);
		return rowCount;
	}
}
