/**
* Test Script Name                   : N/A
* Objective                          : Admin Approved Billers Management related functions
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 05/06/2023
* Last Updated on                    : N/A
* Updated By                         : Dhruva Kumar S
* Pre-Conditions                     : N/A
* Manual Testcase Name               : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
* Defects affecting this test script : None
* Work Arounds/Known Issues          : None
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminNotApprovedMgmCloseBiller;

public class AdminReceivablesPaidOutsideEdaatPage extends BasePage {

	public AdminReceivablesPaidOutsideEdaatPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_SystemMgm_SearchItem)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}
	public void NavigatetoPaidOutsideEdaat() throws InterruptedException
	{
		WebClickUsingJS(EdaatOR.Admin_Receivable_Link);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_ReceviablesPaidOutsideEddatLink);
	}
	
	//Function Summary  : Method to Verify Grid View Details
	//Parameter Summary : ActivationMsg
	public void GridView(Map<Object,Object> testdatamap,Log Log) {
	
		try {
			  NavigatetoPaidOutsideEdaat();
			  Thread.sleep(2000);
			  verifyElementIsPresent(EdaatOR.Admin_ReceviablesPaidOutsideEddatGridView);
			  Thread.sleep(2000);
			  this.takeScreenShot();
			  test.log(Status.PASS,"Save Revieviable Paid OutSide Edaat GridView " + driver.getTitle() +" * SRevieviable Paid OutSide Edaat GridView PASS * " );
	          Log.ReportEvent("PASS", "Verify Paid OutSideEdaat GridView is Suceessful");
		}
		catch(Exception e){
			test.log(Status.FAIL,"Revieviable Paid OutSide Edaat GridView" + driver.getTitle() +" * Revieviable Paid OutSide Edaat GridView FAIL * " );
			this.takeScreenShot();
		}
		
	}
	
	//Function Summary   : Method to  Navigate to "Paid outside Edaat" Page
		//Parameter Summary  : N/A
		public void navigatetoReceivablesPaidOutsideEdaat() throws InterruptedException {
		WebClick(EdaatOR.Admin_Receivables_Menu);
		clickOnPaidOutsideEdaatManu();
		Thread.sleep(2000);
		}
		
		//Function Summary   : Method to  click on "Paid outside Edaat" Menu
		//Parameter Summary  : N/A
		private void clickOnPaidOutsideEdaatManu() {
			WebClickUsingJS(EdaatOR.Admin_Receivables_PaidoutsideMenu);
			waitForPageToLoad();
		}
	    //Function Summary   : Method to "Paid outside Edaat" Search
		//Parameter Summary  : BillNumber,DocumentNo
		public void paidOutsideEdaatSearch(Map<Object, Object> testdatamap,Log Log) {
			try {
					navigatetoReceivablesPaidOutsideEdaat();
					WebEdit(EdaatOR.Admin_PaidoutsideEdaat_BillNo,testdatamap.get("BillNumber").toString());
					Thread.sleep(2000);
					WebEdit(EdaatOR.Admin_PaidOutsideEdaat_DocumentNo, testdatamap.get("DocumentNo").toString());
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_PaidoutsideEdaat_SubBillerName);
					WebClick("//li[text()='"+testdatamap.get("SubBillerName").toString()+"']");
					Thread.sleep(1000);
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_PaidoutsideEdaat_Searchbtn);
					Thread.sleep(1000);
					VerifyValue1(WebGetText("//tr/td[text()='"+testdatamap.get("BillNumber").toString()+"']"), testdatamap.get("BillNumber").toString());
					this.takeScreenShot();
					test.log(Status.PASS,"Verify PaidOutsideEdaat Search" + driver.getTitle() +" * PaidOutsideEdaat Search is PASS * " );
		        	Log.ReportEvent("PASS", "Verify PaidOutSide Edaat Search functionality is Successfull");	        	

			}
			
			catch(Exception e){
				test.log(Status.FAIL,"Verify PaidOutsideEdaat Search" + driver.getTitle() +" * PaidOutsideEdaat Search is FAIL * " );
				this.takeScreenShot();
			}
	
		}
	}
