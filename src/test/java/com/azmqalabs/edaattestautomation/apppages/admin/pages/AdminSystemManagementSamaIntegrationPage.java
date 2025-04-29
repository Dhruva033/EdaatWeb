/**
*
* Test Script Name                   :N/A
* Objective                          :Admin SystemManagement functionality
* Version                            :1.0
* Author                             :Kathirvelu Mohan
* Created Date                       :8/09/2023
* Last Updated on                    :N/A
* Updated By                         :Dhruva Kumar S
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

public class AdminSystemManagementSamaIntegrationPage extends BasePage {

	public AdminSystemManagementSamaIntegrationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Systemmgmt_Menu)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}
	//Function Summary  : Method to navigateSamaIntegration
	//Parameter Summary : N/A
	public void navigateSamaIntegration(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_SystemMng_SamaIntegration);
		Thread.sleep(2000);
    	Log.ReportEvent("PASS", " Navigate to SAMA Integration");
    	this.takeScreenShot();
	}
	//Function Summary  : Method to navigateSamaIntegration
			//Parameter Summary : N/A
			public void navigateSamaIntegrationAndHistoryOfPaymentsReturns(Log Log) throws Exception {
				try {
					WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Admin_SystemMng_SamaIntegration);
					if(CheckElementExists(EdaatOR.Admin_SystemMng_SamaIntegration_history))
					{
						WebClickUsingJS(EdaatOR.Admin_SystemMng_SamaIntegration_history);
						Log.ReportEvent("PASS", "History Of Payments Returns Page is Loaded Successfully");
					}
					else {
						Log.ReportEvent("FAIL", "History Of Payments Returns Page is Not Loaded Successfully");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();
					}
				}
				catch (Exception e) {
					Log.ReportEvent("FAIL", "History Of Payments Returns Page is Not Loaded Successfully");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();		
					
				}
			}
			//Function Summary  : Method to VerifyHistoryofDataSentToSama
			//Parameter Summary : N/A
			public void VerifyHistoryofPaymentReturns(Map<Object, Object> testdatamap,Log Log) throws Exception {
				try {
					selectDropdownValue_PartialText(EdaatOR.Admin_SystemMng_SamaIntegration_historytype,testdatamap.get("HistoryType").toString());
					Thread.sleep(2000);
					WebClick(EdaatOR.Admin_SystemMng_SamaIntegrationFromdate);
					Thread.sleep(1000);
					selectDropdownValue_PartialText(EdaatOR.Admin_SystemMng_SamaIntegrationFromYear,testdatamap.get("FromYear").toString());
					Thread.sleep(1000);
					selectDropdownValue_PartialText(EdaatOR.Admin_SystemMng_SamaIntegrationFromMonth,testdatamap.get("FromMonth").toString());
					Thread.sleep(1000);
					WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_SystemMng_SamaIntegrationTodate);
					Thread.sleep(1000);
					selectDropdownValue_PartialText(EdaatOR.Admin_SystemMng_SamaIntegrationToyear,testdatamap.get("ToYear").toString());
					Thread.sleep(1000);
					selectDropdownValue_PartialText(EdaatOR.Admin_SystemMng_SamaIntegrationToMonth,testdatamap.get("ToMonth").toString());
					Thread.sleep(1000);
					WebClick("(//a[text()='"+testdatamap.get("ToDate").toString()+"'])");	
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_SystemMng_SamaIntegrationsrcbtn);
					Thread.sleep(1000);
					if(getText("//td[text()='"+testdatamap.get("UserName").toString()+"']").equals(testdatamap.get("UserName").toString()))
					{
						VerifyValue1(getText("//td[text()='"+testdatamap.get("UserName").toString()+"']"),testdatamap.get("UserName").toString());
						Thread.sleep(1000);
						Log.ReportEvent("PASS", "History Of  Precautionary Data Sent to SAMA Functionality is Successful");
					}
					else {
						Log.ReportEvent("FAIL", "History Of  Precautionary Data Sent to SAMA Functionality Is UnSuccessful");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();
					}
				}
				catch (Exception e) {
					Log.ReportEvent("FAIL", "History Of  Precautionary Data Sent to SAMA Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();		}
			}
}
