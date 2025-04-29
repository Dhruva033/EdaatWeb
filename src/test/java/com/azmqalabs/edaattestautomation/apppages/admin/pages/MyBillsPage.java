/**
* Test Script Name                   : N/A
* Objective                          : My Bills related functions
* Version                            : 1.0
* Author                             : Kathirvelu Mohan
* Created Date                       : 05/06/2023
* Last Updated on                    : N/A
* Updated By                         : Dhruva Kumar S
* Pre-Conditions                     : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class MyBillsPage extends BasePage {

	public MyBillsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}
	
	//Function Summary   : Method to  clickOnMyBillMenu
	//Parameter Summary  : N/A
	public void clickOnMyBillMenu(Log Log) throws InterruptedException {
		try {
			WebClick(EdaatOR.Admin_MyBill_Button);
			if (CheckElementExists(EdaatOR.Admin_MyBill_DetailsHeader)) {				
		       	Log.ReportEvent("PASS", "Invoice Details Page is Loaded Successfully");	
			} else {
				Log.ReportEvent("FAIL", "Invoice Details Page is not Loaded Successfully");	
				this.takeScreenShot();
				 driver.quit();
				Assert.fail();
			}	
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Invoice Details Page is not Loaded Successfully");	
			this.takeScreenShot();
			e.printStackTrace();
			 driver.quit();
			Assert.fail();
			
		}
		
		
	}
	//Function Summary   : Method to  enterMyBillsDetails
	//Parameter Summary  : N/A
	
	public void enterMyBillsDetails(String ID) {
		WebEdit(EdaatOR.Admin_MyBill_BillNumberField, ID);
	}
	//Function Summary   : Method to  clickOnMyBillViewButton
	//Parameter Summary  : N/A	
	
	public void clickOnMyBillViewButton() {
		WebClick(EdaatOR.Admin_MyBill_ViewButton);
	}
	
	//Function Summary   : Method to verifyInvalidBillNumberMessage
	//Parameter Summary  : InvalidBillNumber
	public void verifyInvalidBillNumberMessage(Map<Object,Object> testdatamap,Log Log) throws IOException, InterruptedException {
		try {
			enterMyBillsDetails(testdatamap.get("InvalidBillNumber").toString());
			clickOnMyBillViewButton();
			Thread.sleep(2000);
			if (getText(EdaatOR.Admin_MyBill_InvalidNumber).equals( "Invalid invoice number")) {
				VerifyValue1(getText(EdaatOR.Admin_MyBill_InvalidNumber), "Invalid invoice number");
		       	Log.ReportEvent("PASS", "Enter Invalid Invoice Number Functionality is Successful");

			} else {
		       	Log.ReportEvent("FAIL", "Enter Invalid Invoice Number Functionality is UnSuccessful");
		       	this.takeScreenShot();
		        driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Enter Invalid Invoice Number Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			 driver.quit();
			Assert.fail();
		}
	}
	
	//Function Summary   : Method to  clickOnMyBillMenu	
	//Parameter Summary  : InvoiceID,Invoice Status,Invoice Details
	public void verifyValidBillNumberMessage(Map<Object,Object> testdatamap,Log Log) throws IOException, Exception {
		try {
			enterMyBillsDetails(testdatamap.get("InvoiceID").toString());
			clickOnMyBillViewButton();
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.MyBills_Invalid)) {
				Log.ReportEvent("FAIL", "Enter valid Invoice Number Functionality is UnSuccessful");
		       	this.takeScreenShot();
		        driver.quit();
				Assert.fail();
			}
			else if(getText(EdaatOR.Admin_MyBill_BillNumber).equals(testdatamap.get("InvoiceID").toString())) {
				VerifyValue1(getText(EdaatOR.Admin_MyBill_BillNumber), testdatamap.get("InvoiceID").toString());
				verifyElementIsPresent(EdaatOR.Admin_MyBill_BillStatus, "Invoice Status");
				verifyElementIsPresent(EdaatOR.Admin_MyBill_DetailsHeader, "Invoice Details");
		       	Log.ReportEvent("PASS", "Enter Valid Invoice Number Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Enter Valid Invoice Number Functionality is UnSuccessful");
		       	this.takeScreenShot();
		        driver.quit();
				Assert.fail();
			}		
		} catch (Exception e) {
	       	Log.ReportEvent("FAIL", "Enter Valid Invoice Number Functionality is UnSuccessful");
	       	this.takeScreenShot();
			e.printStackTrace();
			 driver.quit();
			Assert.fail();
			
		}
	}
	
	//Function Summary   : Method to  clickOnPayNowButton
	//Parameter Summary  : N/A
	public void clickOnPayNowButton() {
		WebClickUsingJS(EdaatOR.MyBills_Paybtn);
	}
	
	//Function Summary   : Method to  clickLoginButton
	//Parameter Summary  : N/A
	public void clickLoginButton() {
		WebClickUsingJS(EdaatOR.MyBills_Clientpopup_LoginBtn);
	}
	//Function Summary   : Method to  VerifyAvailablePaymentMethodAssignedToBillerAccount
	//Parameter Summary  : ContractNumber
	public void VerifyAvailablePaymentMethodAssignedToBillerAccount(Map<Object, Object> testdatamap, Log Log) {
		try {
			enterMyBillsDetails(testdatamap.get("ContractNumber").toString());
			clickOnMyBillViewButton();
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.MyBills_Paybtn)) {
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(EdaatOR.MyBills_Paybtn))).build().perform();
			if (CheckElementExists(EdaatOR.MyBills_Sadad_PaymentMethod) &&
				CheckElementExists(EdaatOR.MyBills_Mada_PaymentMethod) &&
				CheckElementExists(EdaatOR.MyBills_Visa_PaymentMethod) &&
				CheckElementExists(EdaatOR.MyBills_MasterCard_PaymentMethod)) {
				verifyElementIsPresent(EdaatOR.MyBills_Sadad_PaymentMethod);
				verifyElementIsPresent(EdaatOR.MyBills_Mada_PaymentMethod);
				verifyElementIsPresent(EdaatOR.MyBills_Visa_PaymentMethod);
				verifyElementIsPresent(EdaatOR.MyBills_MasterCard_PaymentMethod);	
		    	Log.ReportEvent("PASS", "Available Payment Method on My Bills Page is the Same one Assigned in the Biller's Account Functionality is Successful");	
			} else {
		    	Log.ReportEvent("FAIL", "Available Payment Method on My Bills Page is the Same one Assigned in the Biller's Account Functionality is UnSuccessful");	
		    	this.takeScreenShot();
		    	driver.quit();
				Assert.fail();
			}	    
	}
			else
			{
				Log.ReportEvent("FAIL", "Available Payment Method on My Bills Page is the Same one Assigned in the Biller's Account Functionality is UnSuccessful");	
		    	this.takeScreenShot();
		    	driver.quit();
				Assert.fail();
			}
		  }
	     catch (Exception e) {
				Log.ReportEvent("FAIL", "Available payment method on my bills page is the same one assigned in the biller's account Functionality is UnSuccessful");	
				this.takeScreenShot();
				e.printStackTrace();
				driver.quit();
				Assert.fail();
		}
	}
	
	//Function Summary   : Method to  enterTheContractNumberAndClickOnPayNowButton
	//Parameter Summary  : ContractNumber,ClientPopupHeader
	public void enterTheContractNumberAndClickOnPayNowButton(Map<Object, Object> testdatamap, Log Log) throws IOException, InterruptedException {
		try {
		enterMyBillsDetails(testdatamap.get("ContractNumber").toString());
		clickOnMyBillViewButton();
		clickOnPayNowButton();
		Thread.sleep(2000);
		if (CheckElementExists(EdaatOR.MyBills_Clientpopup_Header)) {
			VerifyValue1(getText(EdaatOR.MyBills_Clientpopup_Header),testdatamap.get("ClientPopupHeader").toString());
			clickLoginButton();
	    	Log.ReportEvent("PASS", "Login as a client pop-up Functionality is Successful");	
		}
		else {
	    	Log.ReportEvent("FAIL", "Login as a client pop-up Functionality is UnSuccessful");	
	    	this.takeScreenShot();
	    	 driver.quit();
			Assert.fail();
		}
		}
		catch (Exception e) {
	    	Log.ReportEvent("FAIL", "Login as a client pop-up Functionality is UnSuccessful");	
	    	this.takeScreenShot();
			e.printStackTrace();
			 driver.quit();
			Assert.fail();	
		}
	}
	
	//Function Summary   : Method to  validateTheClientPopupAppears
	//Parameter Summary  : ContractNumber,ClientPopupHeader
	public void validateTheClientPopupAppears(Map<Object, Object> testdatamap, Log Log) throws IOException, InterruptedException {
		try {
		enterMyBillsDetails(testdatamap.get("ContractNumber").toString());
		WebClick(EdaatOR.Admin_MyBill_ViewButton);
		if (CheckElementExists(EdaatOR.MyBills_Invalid)) {
	    	Log.ReportEvent("FAIL", "When Clicking on Inquire About Invoice Button After Entering the Contract Number Redirects to Login to the Client Account Functionality is UnSuccessful");		
	    	this.takeScreenShot();
	    	Assert.fail();
		} else {
			WebClickUsingJS(EdaatOR.MyBills_Paybtn);
			Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.MyBills_Clientpopup_Header)) {
				VerifyValue1(getText(EdaatOR.MyBills_Clientpopup_Header),testdatamap.get("ClientPopupHeader").toString());
				verifyElementIsPresent(EdaatOR.MyBills_Clientpopup_LoginBtn);
		    	Log.ReportEvent("PASS", "When Clicking on Inquire About Invoice Button After Entering the Contract Number Redirects to Login to the Client Account Functionality is Successful");	
			}
			else {
		    	Log.ReportEvent("FAIL", "When Clicking on Inquire About Invoice Button After Entering the Contract Number Redirects to Login to the Client Account Functionality is UnSuccessful");
		    	this.takeScreenShot();
		    	 driver.quit();
		    	Assert.fail();
			}
	}
		}
			catch (Exception e) {
		    	Log.ReportEvent("FAIL", "When Clicking on Inquire About Invoice Button After Entering the Contract Number Redirects to Login to the Client Account Functionality is UnSuccessful");	
		    	this.takeScreenShot();
				e.printStackTrace();
				 driver.quit();
				Assert.fail();
			}

	}
	public void ExistsCheckElement(String Main) throws InterruptedException {
		Thread.sleep(1000);
		this.takeScreenShot();
		boolean Header;
		try {
			Header = ExistsCheck(Main);
			
			if (Header) {
				test.log(Status.PASS, "Element Exists" + driver.getTitle() + " * Element Exists * ");

			} else {
				test.log(Status.FAIL, "Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
			}
		} catch (Exception e) {
			throw new NoSuchElementException("Biller Home Page - Not Loaded");
		}
	}

	//LOGIN TO APPLICATION WITH GLOBAL LOGIN USER ID FROM LOGIN PAGE
	public void LoginToApplication(){
		try {
			
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginPassword"));
				Thread.sleep(2000);
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			test.log(Status.PASS, "LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");
		    this.takeScreenShot();

		} catch (Exception e) {
			test.log(Status.FAIL, "LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}

	//LOGIN TO APPLICATION WITH INDIVIDUAL TESTDATA SHEET(SAME SHEET - CALL THIS METHOD IF USER WANTS PASS USER ID FROM THE SAME SHEET)
	public void LoginToApplication(String username, String password) {
		try {
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username, username);
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password, password);
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			test.log(Status.PASS, "LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");

		} catch (Exception e) {
			test.log(Status.FAIL, "LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}
	public void loginToApplication(String Username) {
		try {
			if (Username.equalsIgnoreCase("")) {
				Username = GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName").toString();
			}

			WebEdit(EdaatOR.LoginPage_Username, Username);
			WebEdit(EdaatOR.LoginPage_Password, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginPassword").toString());
			WebClick(EdaatOR.LoginPage_LogIn);

		} catch (Exception e) {
			throw new NoSuchElementException("loginToApplication - Login Failed");
		}
	}

	public void Wait() throws Exception {
		int i = 0;
		while (i < 10) {
			SetExecutionDelay();
			i = i + 1;
		}
	}

	public void Logout(String logout) {
		try {
			WebClickUsingJS(logout);
			test.log(Status.PASS, "Logout Successful" + driver.getTitle() + " * Logout * ");
			this.takeScreenShot();
		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "Logout Not Successful" + driver.getTitle() + " * Not Logout * ");
			throw new NoSuchElementException("Logout - Logout Failed");

		}
	}
	
	public void ForgetPassword(String forGet,String Username) {
		try {
			WebClickUsingJS(forGet);
			WebEdit(EdaatOR.LoginPage_Username, Username);
			WebClickUsingJS(EdaatOR.LoginPage_send);
			test.log(Status.PASS, "ForgetPassword functionality Successful" + driver.getTitle() + " * Forget Password * ");
			this.takeScreenShot();
		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "ForgetPassword functionality Not Successful" + driver.getTitle() + " * Forget Password * ");
			throw new NoSuchElementException("ForgetPassword - ForgetPassword Failed");

		}
	}
	
	public void clickOnBillerLogin() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Biller_Link);
		waitForPageToLoad();
		Thread.sleep(1000);
	}
	
	public void LoginToApplication(Map<Object,Object> testdatamap){
		try {
			Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
			login.next();
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  login.getField("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  login.getField("LoginPassword"));
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, login.getField("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			test.log(Status.PASS, "LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");

		} catch (Exception e) {
			test.log(Status.FAIL, "LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to verify Redirects To The Client Login Page,When user click on pay button
	//Parameter Summary  : ContractNumber
	public void verifyRedirectsToTheLoginClientPage (Map<Object,Object> testdatamap,Log Log) throws IOException, InterruptedException {
		try {
			enterMyBillsDetails(testdatamap.get("ContractNumber").toString());
			clickOnMyBillViewButton();
			clickOnPayNowButton();
			Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.MyBills_Clientpopup_Header)) {
				VerifyValue1(getText(EdaatOR.MyBills_Clientpopup_Header),testdatamap.get("ClientPopupHeader").toString());
				clickLoginButton();
		    	Log.ReportEvent("PASS", "Login as a client pop-up Functionality is Successful");	
			}
			else {
		    	Log.ReportEvent("FAIL", "Login as a client pop-up Functionality is UnSuccessful");	
		    	this.takeScreenShot();
		    	 driver.quit();
				Assert.fail();
			}
		if (getText(EdaatOR.MyBills_ClientRegistrationPage).equals("New Client Registration")) {
	    	Log.ReportEvent("PASS", "Clicking on Inquire About Invoice Button Redirects to the Login Client Page Functionality is Successful");
	
		} else {
	    	Log.ReportEvent("FAIL", "Clicking on Inquire About Invoice Button Redirects to the Login Client Page Functionality is UnSuccessful");
	    	this.takeScreenShot();
	    	driver.quit();
			Assert.fail();
		}
	}
		catch(Exception e) {
		   	Log.ReportEvent("FAIL", "Clicking on Inquire About Invoice Button Redirects to the Login Client Page Functionality is UnSuccessful");
	    	this.takeScreenShot();
	    	e.printStackTrace();
	    	driver.quit();
			Assert.fail();
		}

	}	
}
