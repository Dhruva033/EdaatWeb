/**
*
* Test Script Name                   : N/A
* Objective                          : Admin Login Functionality
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 23/05/2023
* Last Updated on                    : N/A
* Updated By                         : Kalpana I R
* Pre-Conditions                     : Admin login credentials
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;

public class AdminSystemMgmSubBillersPage extends BasePage {

	public AdminSystemMgmSubBillersPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_system_subBlr_verif)
	public WebElement subBiller;

	public boolean Exists() {
		return super.Exists(subBiller);
	}
	//Function Summary  : Method to Navigate Sub biller Management Page
		//Parameter Summary :N/A
		public void NavigateSubBillersManagement(Log Log)
		{
			try {
				WebClickUsingJS(EdaatOR.Admin_system_sublink);
				if(CheckElementExists(EdaatOR.Admin_system_subBlr_header))
				{
					Log.ReportEvent("PASS", "Sub Billers Page is Loaded Successfully");
				}
				else {
					Log.ReportEvent("FAIL", "Sub Billers Page is Not Loaded Successfully");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			catch (Exception e) {
				Log.ReportEvent("FAIL", "Sub Billers Page is Not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();		
			}
		}
		//Function Summary : Method to EnterSearchitem
	//Parameter Summary: MainBiller
	public void EnterSearchitem(Map<Object, Object> testdatamap) throws InterruptedException {
		WebClick(EdaatOR.Admin_system_subBlr_click);
		Thread.sleep(2000);
		WebClickUsingActions("//li[text()='"+testdatamap.get("MainBiller").toString()+"']");
		Thread.sleep(1000);
		
	}
	//Function Summary : Method to selectRadiobtn
	//Parameter Summary: Radiobutton
	public void selectRadiobtn(Map<Object, Object> testdatamap) {
		String ele = testdatamap.get("Radiobutton").toString();
		if(ele.equalsIgnoreCase("individual"))
		{
			WebClick(EdaatOR.Admin_system_subBlr_indiv);
		}
		else
		{
			WebClick(EdaatOR.Admin_system_subBlr_Corp);
		}
	}
	//Function Summary : Method to ClickonSearchBtn
	//Parameter Summary: N/A
	public void ClickonSearchBtn() {
		WebClick(EdaatOR.Admin_system_subBlr_srcbtn);
	}
	//Function Summary : Method to EnterSearchitem
		//Parameter Summary: MainBiller
		public void verifySubBillerSearch(Map<Object, Object> testdatamap,Log Log)
		{
			try {
				WebClick(EdaatOR.Admin_system_subBlr_click);
				Thread.sleep(2000);
				WebClickUsingActions("//li[text()='"+testdatamap.get("MainBiller").toString()+"']");
				Thread.sleep(1000);
				String ele = testdatamap.get("Radiobutton").toString();
				if(ele.equalsIgnoreCase("individual"))
				{
					WebClick(EdaatOR.Admin_system_subBlr_indiv);
				}
				else
				{
					WebClick(EdaatOR.Admin_system_subBlr_Corp);
				}
				WebClick(EdaatOR.Admin_system_subBlr_srcbtn);
				if((getText("//td[text()='"+testdatamap.get("MainBiller").toString()+"']").equals(testdatamap.get("MainBiller").toString())))
				{
					VerifyValue1(getText("//td[text()='"+testdatamap.get("MainBiller").toString()+"']"),testdatamap.get("MainBiller").toString());
					Log.ReportEvent("PASS", "Search Functionality is Successful");
				}
				else {
					Log.ReportEvent("FAIL", "Search Functionality is not Successful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();	
				}
			}
			catch (Exception e) {
				Log.ReportEvent("FAIL", "Search Functionality is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();		
			}
		}
		//Function Summary : Method to SubBillerAccount
		//Parameter Summary: N/A
		public void EditSubBillerAccount(Log Log)
		{
			try {
				Thread.sleep(2000);
				WebClick(EdaatOR.Admin_system_subBlr_Edit);
				switchToWindow();
				if(CheckElementExists(EdaatOR.Admin_system_subBlr_Edit_verif))
				{
					Log.ReportEvent("PASS", "Edit Button for SubBiller Account Functionality is Successful");
				}
				else {
					Log.ReportEvent("FAIL", "Edit Button for SubBiller Account Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "Edit Button for SubBiller Account Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
  //Function Summary  : Method to verify  sub biller management grid view
  	//Parameter Summary : MainBiller
  	public void VerifyGridView(Map<Object,Object> testdatamap,Log Log)
  	{
  		try {
  			if(CheckElementExists(EdaatOR.Admin_system_subBlr_Grid_View))
  			{
  			Log.ReportEvent("PASS", "Grid View Functionality is Successful");
  		}
  			else
  			{
  				Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");
  				this.takeScreenShot();
  				driver.quit();
  				Assert.fail();
  			}
  		}
  		catch(Exception e){
  			Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");
  			this.takeScreenShot();
  			driver.quit();
  			Assert.fail();		
  			
  		}
  } 
}