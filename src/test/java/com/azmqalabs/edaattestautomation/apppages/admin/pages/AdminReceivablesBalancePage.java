/**
*
* Test Script Name                      : N/A.
* Objective                             : Balance details functionality.
* Version                               : 1.0
* Author                                : Kathirvelu Mohan
* Created Date                          : 08/05/2023
* Last Updated on                       : N/A
* Updated By                            : Dhruva Kumar S
* Pre-Conditions                        : N/A
* Epic Details                          : N/A
* User Story Details                    : N/A
**/

package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Config;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminReceivablesBalancePage extends BasePage
{

	public AdminReceivablesBalancePage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_Receievable_Balance)
	public WebElement Balance;


	public boolean Exists(){
		return super.Exists(Balance); 
	}
	//Function Summary   : Method to navigate on Balance details Page.
	//Parameter Summary :  N/A.
		public void naviagteBalanceDetails(Log Log) {
			WebClickUsingJS(EdaatOR.Admin_Receievable_link);
			WebClickUsingJS(EdaatOR.Admin_BalanceDetailsPage);
        	Log.ReportEvent("PASS", "Verify naviagted Suceessfull to Balance details Page");
			waitForPageToLoad();
			
		}
	//Function Summary:Method to do EnterSearch
	//Function Summary:contract number,SubBillerName
	public void EnterSearch(Map<Object, Object> testdatamap) throws InterruptedException, IOException
	{
		try {
			WebEdit(EdaatOR.Admin_Rcv_balContract,testdatamap.get("contract number").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Rcv_subbiler);
			Thread.sleep(2000);
			WebClickUsingActions("//li[text()='"+testdatamap.get("SubBillerName").toString()+"']");
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Rcv_balSearch);
			Thread.sleep(2000);
 			this.takeScreenShot();	
		    }
	   catch(Exception e){
			e.printStackTrace();
		} 
	   
	}
	
	//Function Summary:To select date from drop down.
	//Function Summary:Fromyear,From month,Toyear,Tomonth,Fromdate and ToDate.
		public void SelectDate(Map<Object, Object> testdatamap)
		{
	     try {
	    	WebClick(EdaatOR.Admin_Rcv_balFromd);
	        Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_Rcv_balFromyear,testdatamap.get("Fromyear").toString());
	        Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Admin_Rcv_balFromon,testdatamap.get("From month").toString());
	        Thread.sleep(1000);
	        WebClickUsingJS("//a[text()='"+testdatamap.get("Fromdate").toString()+"']");
	        Thread.sleep(1000);
	        WebClickUsingJS(EdaatOR.Admin_Rcv_balTod);
	        Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Admin_Rcv_balToyear,testdatamap.get("Toyear").toString());
	        Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Admin_Rcv_balTomon,testdatamap.get("Tomonth").toString());
	        Thread.sleep(1000);
	        WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			test.log(Status.PASS,"Select Date" + driver.getTitle() +" * Select Date is pass* " );
			this.takeScreenShot();

			}
			catch(Exception e){
				test.log(Status.FAIL,"Select Date" + driver.getTitle() +" * Select Date is FAIL* " );
				e.printStackTrace();
			}
		}
	//Function Summary   : Method to verifyViewInvoiceBtn
	//Parameter Summary :  N/A
	public void verifyViewInvoiceBtn(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			
			SelectDate(testdatamap);
			EnterSearch(testdatamap);
			WebClick(EdaatOR.Admin_BalanceDetailsViewBtn);
			waitForPageToLoad();
			switchToWindow();
			verifyElementIsPresent(EdaatOR.Admin_InvoiceDetails);
			if(CheckElementExists(EdaatOR.Admin_InvoiceDetails)==true) {
				test.log(Status.PASS,"Invoice details button is Clickable" + driver.getTitle() +" * Invoice details button is Clickable PASS * " );
	        	Log.ReportEvent("PASS", "Verify Veiw invoice details button is clickable.");
			}else {
			
			test.log(Status.FAIL,"Invoice details button is not Clickable" + driver.getTitle() +" * Invoice details button is not Clickable FAIL* " );
			}
		}
		catch(Exception e){
			test.log(Status.FAIL,"Verify Invoice details  button" + driver.getTitle() +" * Invoice details button is not Clickable FAIL * " );
			this.takeScreenShot();
		}
	}
		//Function Summary : Method to UpdateClientInfo
		//Parameter Summary: WalletName
		public void UpdateClientInfo(Map<Object, Object> testdatamap,Log Log){
			try
			{
				WebClick(EdaatOR.Admin_Update_btn);
				Thread.sleep(1000);
				Thread.sleep(2000);
				WebClearandEdit(EdaatOR.Admin_Wallet_efield,testdatamap.get("WalletName").toString());
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_Wallet_yesbtn);
				Thread.sleep(2000);
				this.takeScreenShot();
				VerifyValue1(getText(EdaatOR.Admin_updated_Wallet),testdatamap.get("WalletName").toString());
				this.takeScreenShot();
				test.log(Status.PASS,"Verify Update Client Information functionality" + driver.getTitle() +" * Update Client Information PASS * " );
	        	Log.ReportEvent("PASS", "Verify update client information is successful");

			}
		catch(Exception e){
			test.log(Status.FAIL,"Verify Update Client Information functionality" + driver.getTitle() +" * Update Client Information FAIL * " );
			this.takeScreenShot();
			}
		}
  public void BalanceSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException, IOException
  {
	  try {
	  naviagteBalanceDetails(Log);
	  Thread.sleep(2000);
	  SelectDate(testdatamap);
	  EnterSearch(testdatamap);
	  Thread.sleep(2000);
	  VerifyValue1(getText(EdaatOR.Admin_RcvBalanceSearch_Verify),testdatamap.get("contract number").toString());
	  this.takeScreenShot();
	  test.log(Status.PASS,"Balance Search functionality" + driver.getTitle() +" * Balance Search functionality PASS * " );
	  Log.ReportEvent("PASS", " Verify Search functionality is Suceessful");


	  }
	  catch(Exception e){
			test.log(Status.FAIL,"Balance Search functionality" + driver.getTitle() +" * Balance Search FAIL * " );
			this.takeScreenShot();
			}
  }
	
}
