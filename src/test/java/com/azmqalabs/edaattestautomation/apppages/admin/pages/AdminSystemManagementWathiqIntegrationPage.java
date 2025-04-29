/**
* Test Script Name                   : NA
* TestData Sheet Name                : NA
* Objective                          : Wathiq Integration Functionality.
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 14/06/2023
* Last Updated on                    : N/A
* Updated By                         : Kalpana I R
* Pre-Conditions                     : NA
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class AdminSystemManagementWathiqIntegrationPage extends BasePage {

	public AdminSystemManagementWathiqIntegrationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_SystemMgm_Wathiqlink)
	public WebElement Wathiq;


	public boolean Exists(){
		return super.Exists(Wathiq); 
	}
//Function summary:Verify to Navigate Wathiq Integration
//Parameter summary: NA
	public void NavigateWathiqIntegration(Log Log) throws InterruptedException
	{ 
		WebClickUsingJS(EdaatOR.Admin_SystemMgm_lnk);
		WebClickUsingJS(EdaatOR.Admin_SystemMgm_Wathiqlink);
		Thread.sleep(1000);
		
	}
	//Function summary:Verify to Navigate Wathiq Integration
	//Parameter summary: NA
	public void NavigateWathiqIntegrationHistory(Log Log) throws InterruptedException
	{ 
		try {
			WebClickUsingJS(EdaatOR.Admin_SystemMgm_lnk);
			WebClickUsingJS(EdaatOR.Admin_SystemMgm_Wathiqlink);
			WebClickUsingJS(EdaatOR.Admin_SystemMgm_Wathiq_Historylnk);
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Admin_SystemMgm_Wathiq_History_Header)) {
				Log.ReportEvent("PASS", "Wathiq Integration CR Number Search History Page is Loaded Successfully");
			} else {
				Log.ReportEvent("FAIL", "Wathiq Integration CR Number Search History Page is Not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Wathiq Integration CR Number Search History Page is Not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}	
	}
	//Function summary:Verify to Navigate Wathiq Integration
	//Parameter summary: NA
	public void NavigateWathiqIntegrationCRCheck(Log Log) throws InterruptedException
	{ 
		try {
			WebClickUsingJS(EdaatOR.Admin_SystemMgm_lnk);
			WebClickUsingJS(EdaatOR.Admin_SystemMgm_Wathiqlink);
			WebClickUsingJS(EdaatOR.Admin_SystemMgm_Wathiq_CRCheck);
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Admin_SystemMgm_Wathiq_CR_Header)) {
				Log.ReportEvent("PASS", "Wathiq Integration CR Check Page is Loaded Successfully");
			} else {
				Log.ReportEvent("FAIL", "Wathiq Integration CR Check Page is Not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Wathiq Integration CR Check Page is Not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}	
	}
	//Function summary:Verify to  Wathiq Integration  CR Check
		//Parameter summary: CRNumber
		public void WathiqIntegrationCRCheck(Map<Object, Object> testdatamap ,Log Log) {
			try {
				WebEdit(EdaatOR.Admin_SystemMgm_Wathiq_CRCheck_CRnumber,testdatamap.get("CRNumber").toString());
				WebClickUsingJS(EdaatOR.Admin_SystemMgm_Wathiq_CRCheck_search);
				if(CheckElementExists("//div[contains(text(),'"+testdatamap.get("CRNumber").toString()+"')]"))
				{
					Log.ReportEvent("PASS", "CR Check Functionality is Successful");
				}
				else {
					Log.ReportEvent("FAIL", "CR Check Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				Log.ReportEvent("FAIL", "CR Check Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();		
			}
		}
	//Function summary:Verify to  Wathiq Integration  History details
		//Parameter summary: CRNumber
		public void WathiqIntegrationHistoryDetails(Map<Object, Object> testdatamap,Log Log) throws InterruptedException, IOException
		{
			try {
				WebEdit(EdaatOR.Admin_SystemMgm_Wathiq_CRCheck_CRnumber,testdatamap.get("CRNumber").toString());
				WebClick(EdaatOR.Admin_SystemMgm_Wathiq_History_Fromdate);
				selectDropdownValue_PartialText(EdaatOR.Admin_SystemMgm_Wathiq_History_Fromyear,testdatamap.get("FromYear").toString());
				selectDropdownValue_PartialText(EdaatOR.Admin_SystemMgm_Wathiq_History_FromMon, testdatamap.get("FromMonth").toString());
				WebClickUsingJS("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
				WebClick(EdaatOR.Admin_SystemMgm_Wathiq_History_Todate);
				selectDropdownValue_PartialText(EdaatOR.Admin_SystemMgm_Wathiq_History_Toyear, testdatamap.get("ToYear").toString());
				selectDropdownValue_PartialText(EdaatOR.Admin_SystemMgm_Wathiq_History_Tomon, testdatamap.get("ToMonth").toString());
				WebClickUsingJS("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
				WebClickUsingJS(EdaatOR.Admin_SystemMgm_Wathiq_History_search);
				Thread.sleep(1500);
				if(CheckElementExists(("//tr[1]//td[text()='"+testdatamap.get("CRNumber").toString()+"']")))
				{
				verifyElementIsPresent(("//tr[1]//td[text()='"+testdatamap.get("CRNumber").toString()+"']"));
				Log.ReportEvent("PASS", "Verify History Details Functionality is Successful");
				}
				else {
					Log.ReportEvent("FAIL", "Verify History Details Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();	
				}
			}
			catch(Exception e)
			{
				Log.ReportEvent("FAIL", "Verify History details Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();	
			}
		}

}
