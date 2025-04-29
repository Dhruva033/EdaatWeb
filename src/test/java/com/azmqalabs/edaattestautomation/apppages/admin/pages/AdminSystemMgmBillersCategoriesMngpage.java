/**
*
* Test Script Name                   : N/A
* Objective                          : Admin Login functionality
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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class AdminSystemMgmBillersCategoriesMngpage extends BasePage {

	public AdminSystemMgmBillersCategoriesMngpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_BillerCategory)
	public WebElement BillerCategory;

	public boolean Exists() {
		return super.Exists(BillerCategory);
		
	}
	//Function Summary  : Method to NavigateBillerCategoriesManagement
	//Parameter Summary : N/A
	public void NavigateBillerCategoriesManagement(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Admin_SystmMng_BillerCategory);
		if (CheckElementExists(EdaatOR.Admin_BillerCategory)) {
			Log.ReportEvent("PASS", "Biller Category Page is Loaded Successfully");		
		} else {
			Log.ReportEvent("FAIL", "Biller Category Page is not Loaded Successfully");		
			this.takeScreenShot();
			 driver.quit();
			Assert.fail();
		}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Biller Category Page is not Loaded Successfully");		
			this.takeScreenShot();
			e.printStackTrace();
			 driver.quit();
			Assert.fail();
		}
	}
	
	 //Function Summary  : Method to EnterSearchItem
	 //Parameter Summary : BillerCategoryName
		public void EnterSearchItem(String BillerCategoryName) throws InterruptedException
		{
			WebEdit(EdaatOR.Admin_SystmMng_BillerCategorysrcfield,BillerCategoryName);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_SystmMng_BillerCategorysrcbtn);
			Thread.sleep(1000);
		}
	//Function Summary  : Method to AddBillerCategory
	//Parameter Summary : BillerCategoryNameAR,BillerCategoryNameEN
	public void AddBillerCategory(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
			try
			{
			WebClick(EdaatOR.Admin_SystmMng_BillerCategoryaddbtn);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_SystmMng_BillerCategoryARfield,testdatamap.get("BillerCategoryNameAR").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_SystmMng_BillerCategoryENfield,testdatamap.get("BillerCategoryNameEN").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_SystmMng_BillerCategorySavebtn);
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Admin_SystmMng_BillerCategoryARErrorMsg) || 
				CheckElementExists(EdaatOR.Admin_SystmMng_BillerCategoryEngErrorMsg)) {	
		     	Log.ReportEvent("FAIL", "Add Biller Category Functionality is UnSucessful");
		     	  this.takeScreenShot();
		     	 driver.quit();
		     	  Assert.fail();
			}
			else {
				WebEdit(EdaatOR.Admin_SystmMng_BillerCategorysrcfield,testdatamap.get("BillerCategoryName").toString());
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_SystmMng_BillerCategorysrcbtn);
				Thread.sleep(1000);	
				VerifyValue1(getText("//td[text()='"+testdatamap.get("BillerCategoryName").toString()+"']"),testdatamap.get("BillerCategoryName").toString());
		     	Log.ReportEvent("PASS", "Add Biller Category Functionality is Successful");
			}
		}
			catch (Exception e) {
			  	Log.ReportEvent("FAIL", "Add Biller Category Functionality is UnSuccessful");
		     	this.takeScreenShot();
		  		e.printStackTrace();
		  		 driver.quit();
		     	Assert.fail();			
			}

		}
	//Function Summary  : Method to VerifytheBillerCategorySearch
	//Parameter Summary : BillerCategoryName
	public void VerifytheBillerCategorySearch(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{			
			WebEdit(EdaatOR.Admin_SystmMng_BillerCategorysrcfield,testdatamap.get("BillerCategoryName").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_SystmMng_BillerCategorysrcbtn);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_SystmMng_BillerCategoryNodata))
			{
				AddBillerCategory(testdatamap,Log);
				Log.ReportEvent("PASS","Search Biller Category Functionality is Successful");
			}
			else if (getText("//td[text()='"+testdatamap.get("BillerCategoryName").toString()+"']").equals(testdatamap.get("BillerCategoryName").toString())) {
				VerifyValue1(getText("//td[text()='"+testdatamap.get("BillerCategoryName").toString()+"']"),testdatamap.get("BillerCategoryName").toString());
		     	Log.ReportEvent("PASS","Search Biller Category Functionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL","Search Biller Category Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL","Search Biller Category Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			 driver.quit();
			Assert.fail();
		}
	}
	//Function Summary  : Method to View Biller Category
	//Parameter Summary : BillerCategoryNameEN
	public void VerifytheBillerCategoryView(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{
			VerifytheBillerCategorySearch(testdatamap,Log);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR. Admin_BillerCategoryViewBTN);
			Thread.sleep(2000);	
			if (CheckElementExists("//input[@value='"+testdatamap.get("BillerCategoryNameEN").toString()+"']")) {
				verifyElementIsPresent("//input[@value='"+testdatamap.get("BillerCategoryNameEN").toString()+"']");
	        	Log.ReportEvent("PASS", "View Biller Category Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "View Biller Category Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();	
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "View Biller Category Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary  : Method to VerifytheBillerCategorySearch
		//Parameter Summary : BillerCategoryName
		public void VerifyBillerCategoryAddSearch(Map<Object, Object> testdatamap,Log Log)
		{
			try
			{
				AddBillerCategory(testdatamap,Log);
			}
			catch (Exception e) {
				Log.ReportEvent("FAIL", "Add Biller Category Functionality is UnSuccessful");
		     	this.takeScreenShot();
		  		e.printStackTrace();
		  		driver.quit();
		     	Assert.fail();
			}
		}
		//Function Summary :Method to Verify grid view of Biller Categories Management module. 
		//Parameter Summary: N/A.				  
		public void VerifyBillerCategoryGridView(Map<Object, Object> testdatamap,Log Log) {

			try {
				if (CheckElementExists(EdaatOR.Admin_SystmMng_BillerCategoryGrid)) {
					WebEdit(EdaatOR.Admin_SystmMng_BillerCategorysrcfield,testdatamap.get("BillerCategoryName").toString());
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_SystmMng_BillerCategorysrcbtn);
					Thread.sleep(1000);
					if (getText("//td[text()='"+testdatamap.get("BillerCategoryName").toString()+"']").equals(testdatamap.get("BillerCategoryName").toString())) {
						VerifyValue1(getText("//td[text()='"+testdatamap.get("BillerCategoryName").toString()+"']"),testdatamap.get("BillerCategoryName").toString());
						Log.ReportEvent("PASS", "Grid View Details Functionality is Successful");				
					} else {
						Log.ReportEvent("FAIL", "Grid View Details Functionality is UnSuccessful");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();
					}
				} else {
					Log.ReportEvent("FAIL", "Grid View Details Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
				catch(Exception e){
					Log.ReportEvent("FAIL", "Grid View Details Functionality is UnSuccessful");
					this.takeScreenShot();
					e.printStackTrace();
					driver.quit();
					Assert.fail();
				}				
	}

					//Function Summary  : Method to Verify the Biller Category Edit 
					//Parameter Summary : BillerCategoryName,BillerCategoryName,BillerCategoryNameAREdit,BillerCategoryNameENEdit
					public void verifyEditBillerCategory(Map<Object, Object> testdatamap,Log Log) {
						try
						{
							VerifytheBillerCategorySearch(testdatamap, Log);
							WebClick(EdaatOR.Admin_SystmMng_BillerCategoryEditBtn);
							Thread.sleep(1000);
							WebEdit(EdaatOR.Admin_SystmMng_BillerEditCategoryARfield,testdatamap.get("BillerCategoryNameAREdit").toString());
							Thread.sleep(1000);
							WebEdit(EdaatOR.Admin_SystmMng_BillerEditCategoryENfield,testdatamap.get("BillerCategoryNameENEdit").toString());
							Thread.sleep(1000);
							WebClick(EdaatOR.Admin_SystmMng_BillerEditCategorySaveBtn);
							Thread.sleep(1000);
							if (CheckElementExists(EdaatOR.Admin_SystmMng_BillerCategoryARErrorMsg) || 
									CheckElementExists(EdaatOR.Admin_SystmMng_BillerCategoryEngErrorMsg)) {	
							     	Log.ReportEvent("FAIL", "Edit Biller Category Functionality is UnSuccessful");
							     	this.takeScreenShot();
							     	driver.quit();
							     	Assert.fail();
								}
							else {
								EnterSearchItem(testdatamap.get("BillerCategoryNameENEdit").toString());
								Thread.sleep(1000);
								VerifyValue1(getText("//td[text()='"+testdatamap.get("BillerCategoryNameENEdit").toString()+"']"),testdatamap.get("BillerCategoryNameENEdit").toString());
								Thread.sleep(1000);	
								Log.ReportEvent("PASS", "Edit Biller Category Functionality is Successful"); 
							}	
						}
						catch (Exception e) {
						   	Log.ReportEvent("FAIL", "Edit Biller Category Functionality is UnSuccessful");
					     	this.takeScreenShot();
					     	e.printStackTrace();
					     	driver.quit();
					     	Assert.fail();
						}
						
					}
		//Function Summary  : Method to VerifyBillerCategoryAddErrorMsg
		//Parameter Summary : Expected		
		public void VerifyBillerCategoryAddErrorMsg(Map<Object, Object> testdatamap,Log Log) {			
			try
			{
				String Expected = testdatamap.get("Expected").toString(); 
				WebClick(EdaatOR.Admin_SystmMng_BillerCategoryaddbtn);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_SystmMng_BillerCategoryARfield,testdatamap.get("BillerCategoryNameAR").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_SystmMng_BillerCategoryENfield,testdatamap.get("BillerCategoryNameEN").toString());
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_SystmMng_BillerCategorySavebtn);
				Thread.sleep(1000);
				if(getText(EdaatOR.Admin_SystmMng_BillerCategoryARErrorMsg).equals(Expected)&&
						getText(EdaatOR.Admin_SystmMng_BillerCategoryEngErrorMsg).equals(Expected))
				{
					Log.ReportEvent("PASS", "Verify Error Message for All the Required Fields is Successful");	
				}
				else if (getText(EdaatOR.Admin_SystmMng_BillerCategoryARErrorMsg).equals(Expected)) {
					Log.ReportEvent("PASS", "Verify Error Message for Invalid 'Biller Category Name AR' is Successful");	
			    }
				else {
					Log.ReportEvent("FAIL", "Verify Add Biller Category Error Message is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail(); 				}
			}
			catch (Exception e) {		
				Log.ReportEvent("FAIL", "Verify Add Biller Category Error Message is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail(); 				
			}	
		
		}
					
					
}