/**
* Test Script Name  				    : N/A
* Objective     					    : Verify ClientLogin Functionality
* Version                               : 1.0
* Author                                : Basavaraj Mudnur
* Created Date                          : 
* Last Updated on                       : N/A
* Updated By   			 			    : Basavaraj Mudnur
* Pre-Conditions					    : N/A
* Epic Details						 	: N/A
* User Story Details				 	: N/A
**/
package com.azmqalabs.edaattestautomation.apppages.Client.pages;

import java.io.IOException;
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

public class ClientLoginPage extends BasePage {

	public ClientLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}
	//Function Summary   : Method to ClickonClientLogin
	//Parameter Summary  : N/A
	public void ClickonClientLogin(Map<Object, Object> testdatamap) {		
		WebClickUsingJS(EdaatOR.Client_Link);
		this.takeScreenShot();
		waitForPageToLoad();
	}
	//Function Summary   : Method to Check Mainpage/Error message is displayed.
	//Parameter Summary : N/A.
	public void ExistsCheckElement(Log Log) throws InterruptedException {
		Thread.sleep(1000);
		this.takeScreenShot();
		boolean Header;
		try {
			Header = ExistsCheck(EdaatOR.Client_HelloClient_Main);
			
			if (Header) {
				test.log(Status.PASS, "Element Exists" + driver.getTitle() + " * Element Exists * ");
	        	Log.ReportEvent("PASS", " Verify Main Page is Dislayed");	        	
	        	this.takeScreenShot();
			} else {
				test.log(Status.FAIL, "Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
				this.takeScreenShot();
			}
		} catch (Exception e) {
			this.takeScreenShot();
			throw new NoSuchElementException("Client Home Page - Not Loaded");
		}
	}
	//Function Summary   : Method to LoginToClientApplication
	//Parameter Summary  : username,password
	public void LoginToApplication(String username, String password,Log Log) {
		try {
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username, username);
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password, password);
				Thread.sleep(2000);
				WebClick(EdaatOR.LoginPage_LogIn);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			test.log(Status.PASS, "LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");
        	Log.ReportEvent("PASS", " Verify Client Login is successfull");
        	this.takeScreenShot();
		} catch (Exception e) {
			test.log(Status.FAIL, "LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to Login Edaat Application using Client login credentials.
	//Parameter Summary : LoginUserName,LoginPassword.
	public void LoginToApplication(Map<Object,Object> testdatamap,Log Log){
		try {
			Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
			login.next();
			this.Exists();
			if (ExistsCheck(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  login.getField("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  login.getField("LoginPassword"));
				Thread.sleep(2000);
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(3000);
				Log.ReportEvent("PASS", "Client Login Is Successful");
			
			} else {
				Log.ReportEvent("FAIL", "Client Login Is UnSuccessful");
				this.takeScreenShot();
				Assert.fail();
			}
       
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Login Is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			Assert.fail();
		}
	}
	public void Logout(Log Log) {
		try {
			WebClickUsingJS(EdaatOR.Logout);
//			test.log(Status.PASS, "Logout Successful" + driver.getTitle() + " * Logout * ");
//        	Log.ReportEvent("PASS", "Client Logout  Suceessful");
//        	this.takeScreenShot();
		} catch (Exception e) {
//			test.log(Status.FAIL, "Logout Not Successful" + driver.getTitle() + " * Not Logout * ");
//			this.takeScreenShot();
//			throw new NoSuchElementException("Logout - Logout Failed");

		}
	}
	//Function Summary   : Method to verify Edaat logo
	//Parameter Summary : N/A
	public void VerifyEdaatLogo(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.EdaatLogo);
			waitForPageToLoad();
			switchTonextwindow();
			verifyElementIsPresent(EdaatOR.HomePage);
			test.log(Status.PASS, "Verify Edaat Logo is Successful" + driver.getTitle() + " * Edaat Logo * ");
        	Log.ReportEvent("PASS", " Verify User Able to Register or Sign Up  and Verify to Activate the account through email Successfully");
        	this.takeScreenShot();
		}
catch(Exception e) {
	test.log(Status.FAIL, "Verify Edaat Logo is Not Successful" + driver.getTitle() + " * Edaat Logo * ");
	this.takeScreenShot();
}		
	}	
	
	//Function Summary   : Method to Login Edaat Application using Client login credentials.
	//Parameter Summary : LoginUserName,LoginPassword.
	public void InvalidLogin(Map<Object,Object> testdatamap,Log Log){
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
				verifyElementIsPresent(EdaatOR.LoginPage_Invalid_LogIn);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, login.getField("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			test.log(Status.PASS, "LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");
        	Log.ReportEvent("PASS", " Verify User Able to Register or Sign Up  and Verify to Activate the account through email Successfully");

		} catch (Exception e) {
			test.log(Status.FAIL, "LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}


	//Function Summary : Method to Verify About Edaat Link
	//Parameter Summary: N/A
	public void ClickOnAboutEdaatLink() throws Exception
	{
		WebClick(EdaatOR.ClientLoginAboutEdaatLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginAboutEdaatText);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	//Function Summary : Method to Verify OurServices Link
	//Parameter Summary: N/A
	public void ClickOnOurServicesLink() throws Exception
	{
		WebClick(EdaatOR.ClientLoginOurServicesLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginOurServicesEdaatFeaturesTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}
		
	//Function Summary : Method to Verify Our Clients Link
	//Parameter Summary: N/A
	public void ClickOnOurClientsLink() throws Exception
	{
		WebClick(EdaatOR.ClientLoginOurClientsLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginOurClientsTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}
	//Function Summary : Method to Verify About AZM Fintech Link
	//Parameter Summary: N/A
	public void ClickOnAboutAzmFintechLink() throws Exception
	{
		WebClick(EdaatOR.ClientLoginAZMFintechLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		//verifyElementIsPresent(EdaatOR.ClientLoginOurClientsTXT);
		//Thread.sleep(2000);
		driver.navigate().back();
	}
	//Function Summary : Method to Verify Bill Inquiry Link
	//Parameter Summary: N/A
	public void ClickOnBillInquiryLink() throws Exception
	{
		WebClick(EdaatOR.ClientLoginBillInquiryLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginEnterInvoiceNumTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}
	//Function Summary : Method to Verify Client Registration Link
	//Parameter Summary: N/A
	public void ClickOnClientRegistrationLink() throws Exception
	{
		WebClick(EdaatOR.ClientLoginClientRegistrationLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginNewClientRegistrationTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}
	//Function Summary : Method to Verify Biller Registration Link
	//Parameter Summary: N/A
	public void ClickOnBillerRegistrationLink() throws Exception
	{
		WebClick(EdaatOR.ClientLoginBillerRegistrationLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginNewBillerRegistrationTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}
	//Function Summary : Method to Verify Contact Us Link
	//Parameter Summary: N/A
	public void ClickOnContactUsLink() throws Exception
	{
		WebClick(EdaatOR.ClientLoginContactUSLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginContactusTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}
	//Function Summary : Method to Verify FAQ Link
	//Parameter Summary: N/A
	public void ClickOnFAQLink() throws Exception
	{
		WebClick(EdaatOR.ClientLoginFAQLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginFAQ_TXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}
	//Function Summary : Method to Verify Terms and Conditions Link
	//Parameter Summary: N/A
	public void ClickOnTermsandConditionsLink() throws Exception
	{
		WebClick(EdaatOR.ClientLoginTermsandConditionLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginTermsandConditionTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}
	//Function Summary : Method to Verify Privacy and Policy Link
	//Parameter Summary: N/A
	public void ClickOnPrivacyandPolicyLink() throws Exception
	{
		WebClick(EdaatOR.ClientLoginPrivacyandPolicyLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginPrivacyandPolicyTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}
	//Function Summary : Method to Verify Links in the Footer Page
	//Parameter Summary: N/A
	public void VerifyLinksinFooterppage(Log Log) {
		try {
			ClickOnAboutEdaatLink();
			Thread.sleep(1000);
			ClickOnOurServicesLink();
			Thread.sleep(1000);
			ClickOnOurClientsLink();
			Thread.sleep(1000);
			ClickOnAboutAzmFintechLink();
			Thread.sleep(1000);
			ClickOnBillInquiryLink();
			Thread.sleep(1000);
			ClickOnClientRegistrationLink();
			Thread.sleep(1000);
			ClickOnBillerRegistrationLink();
			Thread.sleep(1000);
			ClickOnContactUsLink();
			Thread.sleep(1000);
			ClickOnFAQLink();
			Thread.sleep(1000);
			ClickOnTermsandConditionsLink();
			Thread.sleep(1000);
			ClickOnPrivacyandPolicyLink();
			test.log(Status.PASS, "Verify Links in the Footer Page is  Successful" + driver.getTitle() + " *Verify Links in the Footer Page is PASS * ");
        	Log.ReportEvent("PASS", " Verify Biller Application Launched Suceessfully");
        	this.takeScreenShot();
		} catch (Exception e) {
			test.log(Status.FAIL, "Verify Links in the Footer Page is Successful" + driver.getTitle() + " * Verify Links in the Footer Page is FAIL * ");
			this.takeScreenShot();

		}
	}
		public void ChangeLanguage(Map<Object, Object> testdatamap,Log Log) {
		try {
			WebClickUsingJS(EdaatOR.Changelanguagebtn);
			VerifyValue1(getText(EdaatOR.Clientloginbtn),testdatamap.get("Change").toString());			
			test.log(Status.PASS, "Verification Language Change is Successfull" + driver.getTitle() + " * Successfull * ");
        	Log.ReportEvent("PASS", " verify that client login page Language had been changed");
        	this.takeScreenShot();
		} catch (Exception e) {
			test.log(Status.FAIL, "Verification Language Change is not Successfull" + driver.getTitle() + " * Not Successfull * ");
			this.takeScreenShot();

		}
	
	}
		
		//Function Summary   : Method to VerifyForgotPassword
		//Parameter Summary : LoginUserName,LoginPassword.
		public void VerifyForgotPassword(Map<Object, Object> testdatamap,Log Log) {
			
			try {
				WebClick(EdaatOR.Client_forgotpwd_Btn);
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Client_forgotpwd_verify);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Client_Username_efield,testdatamap.get("UserName").toString());
				Thread.sleep(1000);
				WebClick(EdaatOR.Client_Username_sendbtn);
				Thread.sleep(1000);
				if(CheckElementExists(EdaatOR.Client_Username_confirm_verify)==true)
				{
				test.log(Status.PASS, "ForgetPassword functionality Successful" + driver.getTitle() + " * Forget Password PASS * ");
	        	Log.ReportEvent("PASS", " Verify Forget Password link on the login page is successfull");
	        	this.takeScreenShot();
				}
				else
				{
				test.log(Status.FAIL, "ForgetPassword functionality Not Successful" + driver.getTitle() + " * Forget Password FAIL * ");

				}
				this.takeScreenShot();
				Thread.sleep(1000);
				WebClick(EdaatOR.Client_Username_close);
			}
			catch (Exception e) {
				
				test.log(Status.FAIL, "ForgetPassword functionality Not Successful" + driver.getTitle() + " * Forget Password FAIL * ");
				this.takeScreenShot();
			}
		}

		//Function Summary   : Method to enter invalid Client login credentials.
		//Parameter Summary : LoginUserName,LoginPassword.
		public void InvalidLoginError(Map<Object,Object> testdatamap){
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
				this.takeScreenShot();
			} catch (Exception e) {
				test.log(Status.FAIL, "LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
				this.takeScreenShot();
			}
		}
		
		//Function Summary   : Method to Verify Client login page fields validation
		//Parameter Summary : LoginUserName,LoginPassword.
		 public void LoginErrormessageValidation(Map<Object,Object> testdatamap) throws InterruptedException {
			 InvalidLoginError(testdatamap);	
			 this.takeScreenShot();
				String Expected=testdatamap.get("ExpectedResult").toString();
				try {
					if (ExistsCheck(EdaatOR.ClientLoginPage_EmailError)) {
						VerifyValue(Expected,EdaatOR.ClientLoginPage_EmailError);
						test.log(Status.PASS, "LoginEmail ErrorMessage Exists" + driver.getTitle() + " * LoginEmail ErrorMessage Exists * ");
					}else if (ExistsCheck(EdaatOR.ClientLoginPage_PasswordError)) {
						VerifyValue(Expected,EdaatOR.ClientLoginPage_PasswordError);
						test.log(Status.PASS, "LoginPassword ErrorMessage Exists" + driver.getTitle() + " *LoginPassword ErrorMessage Exists * ");
					}else if (ExistsCheck(EdaatOR.ClientLoginPage_EmailError) && ExistsCheck(EdaatOR.ClientLoginPage_PasswordError) ){	
						VerifyValue(Expected,EdaatOR.ClientLoginPage_EmailError);				
						VerifyValue(Expected,EdaatOR.ClientLoginPage_PasswordError);				
						test.log(Status.PASS, "Login UserName and Password ErrorMessage Exists" + driver.getTitle() + " *Login UserName and Password ErrorMessage Exists * ");
					}else {
						test.log(Status.FAIL, "Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
					}
				} catch (Exception e) {
					throw new NoSuchElementException("Biller Home Page - Not Loaded");

				}

			}
		 
		 
		 	//Function Summary   : Method to VerifyForgotPassword
			//Parameter Summary : LoginUserName,LoginPassword.
			public void VerifyForgotPasswordError(Map<Object, Object> testdatamap) {
				
				try {
					WebClick(EdaatOR.Client_forgotpwd_Btn);
					Thread.sleep(2000);
					verifyElementIsPresent(EdaatOR.Client_forgotpwd_verify);
					Thread.sleep(1000);
					WebEdit(EdaatOR.Client_Username_efield,testdatamap.get("UserName").toString());
					Thread.sleep(1000);
					WebClick(EdaatOR.Client_Username_sendbtn);
					this.takeScreenShot();
					Thread.sleep(1000);
					
				}
				catch (Exception e) {
					
					test.log(Status.FAIL, "ForgetPassword functionality Not Successful" + driver.getTitle() + " * Forget Password FAIL * ");
				}
			}
			
			//Function Summary   : Method to Verify Forgot password fields validation
			//Parameter Summary : LoginUserName,LoginPassword.
			 public void forgotPasswordErrormessageValidation(Map<Object,Object> testdatamap) throws InterruptedException {
				 VerifyForgotPasswordError(testdatamap);
				 this.takeScreenShot();
					String Expected=testdatamap.get("ExpectedResult").toString();
					try {
						if (ExistsCheck(EdaatOR.ForgotPasswordPage_EmailError)) {
							VerifyValue(Expected,EdaatOR.ForgotPasswordPage_EmailError);
							test.log(Status.PASS, "ResetYourPassword Page Email ErrorMessage Exists" + driver.getTitle() + " * ResetYourPassword Page Email ErrorMessage Exists * ");
						}else if (ExistsCheck(EdaatOR.ForgotPasswordPage_invalidEmailError)) {
							VerifyValue(Expected,EdaatOR.ForgotPasswordPage_invalidEmailError);
							test.log(Status.PASS, "ResetYourPassword Page Email for invalid input  ErrorMessage Exists" + driver.getTitle() + " * ResetYourPassword Page Email for invalid input ErrorMessage Exists * ");
						}else {
							test.log(Status.FAIL, "Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
						}
					} catch (Exception e) {
						throw new NoSuchElementException("Biller Home Page - Not Loaded");

					}

				}
			 
				//Function Summary   : Method to  validateCorrectClientIsLoginToTheClientAccount
				//Parameter Summary  : ClientName
				public void validateCorrectClientIsLoginToTheClientAccount(Map<Object, Object> testdatamap, Log Log) throws IOException {
					try {
					if (CheckElementExists(EdaatOR.MyBills_Client_ClientName)) {
						verifyElementIsPresent(EdaatOR.MyBills_Client_ClientName);
						Log.ReportEvent("PASS", "When entering the contract number and redirecting to login as client then log by the correct client Functionality is Successful");	

					} else {
						Log.ReportEvent("FAIL", "When entering the contract number and redirecting to login as client then log by the correct client Functionality is UnSuccessful");	
						this.takeScreenShot();
						Assert.fail();
					}
					}
					catch (Exception e) {
						Log.ReportEvent("FAIL", "When entering the contract number and redirecting to login as client then log by the correct client Functionality is UnSuccessful");	
						this.takeScreenShot();
						e.printStackTrace();
						Assert.fail();
					}
				}
}



