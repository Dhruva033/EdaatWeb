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
 * Manual Testcase Name               : N/A
 * Epic Details                       : N/A
 * User Story Details                 : N/A
 * Defects affecting this test script : None
 * Work Arounds/Known Issues          : None
 **/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;

public class AdminLoginPage extends BasePage {

	public AdminLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}
	//Function Summary  : To check Homepage is displayed
	//Parameter Summary : N/A
	public void ExistsCheckElement(String Main, Log Log) throws InterruptedException {
		Thread.sleep(1000);
		this.takeScreenShot();
		boolean Header;
		try {
			Header = ExistsCheck(Main);

			if (Header) {
				test.log(Status.PASS, "Element Exists" + driver.getTitle() + " * Element Exists * ");
				Log.ReportEvent("PASS", " Verify Main Page is Dislayed");	
				this.takeScreenShot();

			} else {
				test.log(Status.FAIL, "Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
				this.takeScreenShot();
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
				this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
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
	public void InvalidAdminlogin(Map<Object,Object> testdatamap,Log Log){
		try {
			Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
			login.next();
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  login.getField("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  login.getField("LoginPassword"));
				Thread.sleep(2000);
				//this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.LoginPage_Invalid_LogIn);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, login.getField("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);
			}
			test.log(Status.PASS, "LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");
			Log.ReportEvent("PASS", "Verify Admin Login is UnSuceessfull");
			this.takeScreenShot();
		} catch (Exception e) {
			test.log(Status.FAIL, "LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}

	public void Wait() throws Exception {
		int i = 0;
		while (i < 10) {
			SetExecutionDelay();
			i = i + 1;
		}
	}
	//Function Summary   : Method to  Logout
	//Parameter Summary  : N/A
	public void Logout(String logout,Log Log) {
//		try {
//			Thread.sleep(2000);
			WebClickUsingJS(logout);
//			if(CheckElementExists(EdaatOR.Biller_loginverify)) {
//        	Log.ReportEvent("PASS", " Logout is Successful");
//			}
//			else {
//	        	Log.ReportEvent("FAIL", " Logout is not Successful");
//	        this.takeScreenShot();
//			}
//		} catch (Exception e) {
//        	Log.ReportEvent("FAIL", " Logout is not Successful");
//        this.takeScreenShot();
//			throw new NoSuchElementException("Logout - Logout Failed");
// 
//		}
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
	//Function Summary   : Method to clickOnBillerLogin
	//Parameter Summary  : N/A
	public void clickOnBillerLogin() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Biller_Link);
		waitForPageToLoad();
		Thread.sleep(1000);
	}
	//Function Summary   : Method to Login to the application
	//Parameter Summary  : LoginUserName,LoginPassword
	 public void LoginToApplication(Map<Object,Object> testdatamap,Log Log){
		try {
			Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
			login.next();
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  login.getField("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  login.getField("LoginPassword"));
				Thread.sleep(2000);
				
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, login.getField("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);
 
			}
			if(CheckElementExists(EdaatOR.LoginPage_Invalid_LogIn)) {
				Log.ReportEvent("FAIL", "Admin Login is not Successful");
				this.takeScreenShot();		
				}
			else {
				Log.ReportEvent("PASS", "Admin Login is Successful");
			}
 
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Admin Login is not Successful");
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to VerifyForgotPassword
	//Parameter Summary : UserName
	public void VerifyForgotPassword(Map<Object, Object> testdatamap,Log Log) {

		try {
			WebClick(EdaatOR.Admin_forgotpwd_Btn);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Admin_forgotpwd_verify);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Username_efield,testdatamap.get("UserName").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Username_sendbtn);
			this.takeScreenShot();
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_Username_confirm_verify)==true)
			{
				test.log(Status.PASS, "Forgot Password functionality Successful" + driver.getTitle() + " * Forget Password PASS * ");
				Log.ReportEvent("PASS", " Verify Forgot Password functionality is Successful");			
				this.takeScreenShot();
			}	
			else
			{
				test.log(Status.FAIL, "Forgot Password functionality Not Successful" + driver.getTitle() + " * Forget Password FAIL * ");
				this.takeScreenShot();
			}
			this.takeScreenShot();
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Username_close);
		}
		catch (Exception e) {
			test.log(Status.FAIL, "ForgetPassword functionality Not Successful" + driver.getTitle() + " * Forget Password FAIL * ");
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to verify links in the footer page.
	//Parameter Summary : NA.
	public void footerlinks(Log Log)
	{
		try
		{
			AboutUs(Log);
			Services(Log);
			Information(Log);
		}
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * ");

		}
	}

	//Function Summary   : Method to verify links in the footer page.
	//Parameter Summary : NA.
	public void AboutUs(Log Log) throws InterruptedException
	{
		AboutEdaat(Log);
		Thread.sleep(1000);
		Ourservices(Log);
		Thread.sleep(1000);
		OursClients(Log);
		Thread.sleep(1000);
		Fintech(Log);

	}
	//Function Summary   : Method to verify links in the footer page.
	//Parameter Summary : NA.
	public void Services(Log Log) throws Exception{
		BillerEnquiry(Log);
		Thread.sleep(1000);
		driver.navigate().back();
		ClientRegister(Log);
		Thread.sleep(1000);
		BillerRegister(Log);
	}
	//Function Summary   : Method to verify links in the footer page.
	//Parameter Summary : NA.
	public void Information(Log Log) throws InterruptedException {
		ContactUS(Log);
		Thread.sleep(1000);
		FAQ(Log);
		Thread.sleep(1000);
		Terms(Log);
		Thread.sleep(1000);
		Privacy(Log);

	}
	//Function Summary   : Method to verify About Edaat links in the footer page.
	//Parameter Summary : NA.
	public void AboutEdaat(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_About_Edaat);
			switchToWindow();
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_About_verify);
			this.takeScreenShot();
			test.log(Status.PASS, "AboutEdaat" + driver.getTitle() + " * AboutEdaat link opened successfully* ");
			Log.ReportEvent("PASS", " Verify About Edaat link in the footer page is Successfull");
			this.takeScreenShot();
			driver.navigate().back();
		}
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
	}
	//Function Summary   : Method to verify Ourservices link in the footer page.
	//Parameter Summary : NA.

	public void Ourservices(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_OurService);
			switchToWindow();
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_OurService_verif);
			this.takeScreenShot();
			test.log(Status.PASS, "Ourservices" + driver.getTitle() + " * Ourservices link opened successfully* ");
			Log.ReportEvent("PASS", " Verify Ourservices link in the footer page is Successfull");
			driver.navigate().back();
		}
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
	}

	//Function Summary   : Method to verify Fintech link in the footer page.
	//Parameter Summary : NA.
	public void Fintech(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_fintech);
			/* switchToWindow();
	          verifyElementIsPresent(EdaatOR.Biller_OurClient_verif); */
			test.log(Status.PASS, "Fintech" + driver.getTitle() + " * Fintech link opened successfully* ");
			// this.takeScreenShot();
			Log.ReportEvent("PASS", " Verify Fintech link in the footer page is Successfull");
			driver.navigate().back();
		}
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
	}
	//Function Summary   : Method to verify OursClients link in the footer page.
	//Parameter Summary : NA.
	public void OursClients(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_OurClient);
			switchToWindow();
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_OurClient_verif);
			this.takeScreenShot();
			test.log(Status.PASS, "Fintech" + driver.getTitle() + " * Fintech link opened successfully* ");
			Log.ReportEvent("PASS", " Verify OursClients link in the footer page is Successfull");
			driver.navigate().back();
		}
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
	}

	//Function Summary   : Method to verify BillerEnquiry link in the footer page.
	//Parameter Summary : NA.
	public void BillerEnquiry(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_Enquiry);
			switchToWindow();
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_Enquiry_verif);
			WebClickUsingJS(EdaatOR.Biller_Clientreg_cancel);
			WebClickUsingJS(EdaatOR.Biller_Clientreg_yescancel);
			test.log(Status.PASS, "BillerEnquiry" + driver.getTitle() + " * BillerEnquiry link opened successfully* ");
			Log.ReportEvent("PASS", " Verify BillerEnquiry link in the footer page is Successfull");
			this.takeScreenShot();
			driver.navigate().back();
		}
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * ");
			this.takeScreenShot();
		}

	}
	//Function Summary   : Method to verify ClientRegister link in the footer page.
	//Parameter Summary : NA.
	public void ClientRegister(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_Clientreg);
			switchToWindow();
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_Clientreg_verif);
			this.takeScreenShot();
			test.log(Status.PASS, "ClientRegister" + driver.getTitle() + " * ClientRegister link opened successfully* ");
			Log.ReportEvent("PASS", " Verify ClientRegister link in the footer page is Successfull");
			driver.navigate().back();
			this.takeScreenShot();
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * ");
			this.takeScreenShot();
		}


	}
	//Function Summary   : Method to verify BillerRegister link in the footer page.
	//Parameter Summary : NA.
	public void BillerRegister(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_registerlnk);
			switchToWindow();
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_registerlnk_verif);
			this.takeScreenShot();
			test.log(Status.PASS, "BillerRegister" + driver.getTitle() + " * BillerRegister link opened successfully* ");
			Log.ReportEvent("PASS", "Verify BillerRegister link in the footer page is Successfull");
			driver.navigate().back();

		}
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
	}

	//Function Summary   : Method to verify ContactUS link in the footer page.
	//Parameter Summary : NA.
	public void ContactUS(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_registerlnk);
			switchToWindow();
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_registerlnk_verif);
			this.takeScreenShot();
			test.log(Status.PASS, "BillerRegister" + driver.getTitle() + " * BillerRegister link opened successfully* ");
			Log.ReportEvent("PASS", " Verify ContactUS link in the footer page is Successfull");
			this.takeScreenShot();
			driver.navigate().back();
		}
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}

	}
	//Function Summary   : Method to verify FAQ link in the footer page.
	//Parameter Summary : NA.
	public void FAQ(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_FAQ_link);
			switchToWindow();
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_FAQ_Verify);
			this.takeScreenShot();
			test.log(Status.PASS, "FAQ" + driver.getTitle() + " * FAQ link opened successfully* ");
			Log.ReportEvent("PASS", " Verify FAQ link in the footer page is Successfull");
			this.takeScreenShot();
			driver.navigate().back();
		}
		catch(Exception e)
		{
			this.takeScreenShot();
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}


	}
	//Function Summary   : Method to verify Terms and Condition link in the footer page.
	//Parameter Summary : NA.
	public void Terms(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_Tearms_link);
			switchToWindow();
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_Tearms_Verify);
			test.log(Status.PASS, "BillerRegister" + driver.getTitle() + " * BillerRegister link opened successfully* ");
			Log.ReportEvent("PASS", " Verify Terms and Condition link in the footer page is Successfull");
			this.takeScreenShot();
			driver.navigate().back();
		}
		catch(Exception e)
		{
			this.takeScreenShot();
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}

	}
	//Function Summary   : Method to verify Privacy policy link in the footer page.
	//Parameter Summary : NA.
	public void Privacy(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_Priavcy_link);
			switchToWindow();
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_Priavcy_verify);
			this.takeScreenShot();
			test.log(Status.PASS, "Privacy" + driver.getTitle() + " * Privacy policy link opened successfully* ");
			Log.ReportEvent("PASS", " Verify Privacy policy link in the footer page is Successfull");
			this.takeScreenShot();
			driver.navigate().back();
		}
		catch(Exception e)
		{
			this.takeScreenShot();
			test.log(Status.FAIL, "Element not Exists" + driver.getTitle() + " * Element not Exists * "); 
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
			Log.ReportEvent("PASS", " Verify to click on EDAAT logo and navigate to home page is Successful");
			this.takeScreenShot();
		}
		catch(Exception e) {
			test.log(Status.FAIL, "Verify Edaat Logo is Not Successful" + driver.getTitle() + " * Edaat Logo * ");
			this.takeScreenShot();
		}		
	}	
	//Function Summary   : Method to verify Admin login Error Message and Forgot Password
	//Parameter Summary : N/A
	public void AdminLoginErrorValidation(Map<Object,Object> testdatamap)
	{
		try {
			Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
			login.next();
			String ErrotType = testdatamap.get("Type").toString();
			if(ErrotType.equalsIgnoreCase("Both"))
			{
				WebClickUsingJS(EdaatOR.LoginPage_LogIn);
				VerifyValue1(getText(EdaatOR.Admin_UserNameError),testdatamap.get("Expected").toString());
				test.log(Status.PASS, "Verify Edaat Username error is Successful" + driver.getTitle() + " * Username error * ");
				VerifyValue1(getText(EdaatOR.Admin_PassError),testdatamap.get("Expected").toString());
				test.log(Status.PASS, "Verify Edaat password text field error is Successful" + driver.getTitle() + " * Password error * ");
				this.takeScreenShot();
			}
			else if(ErrotType.equalsIgnoreCase("UserNameText"))
			{
				WebEdit(EdaatOR.LoginPage_Username,login.getField("LoginUserName"));
				WebClickUsingJS(EdaatOR.LoginPage_LogIn);
				VerifyValue1(getText(EdaatOR.Admin_PassError),testdatamap.get("Expected").toString());
				this.takeScreenShot();
				test.log(Status.PASS, "Verify Edaat password text field error is Successful" + driver.getTitle() + " * Password error * ");
				Thread.sleep(2000);
			}
			else if(ErrotType.equalsIgnoreCase("PasswordText"))
			{
				WebEdit(EdaatOR.LoginPage_Password,  login.getField("LoginPassword"));
				//  WebEdit(EdaatOR.LoginPage_Password,GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginPassword"));
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.LoginPage_LogIn);
				VerifyValue1(getText(EdaatOR.Admin_UserNameError),testdatamap.get("Expected").toString());
				this.takeScreenShot();
				test.log(Status.PASS, "Verify Edaat Username error is Successful" + driver.getTitle() + " * Username error * ");
			}  
			else 
			{
				WebClickUsingJS(EdaatOR.Admin_forgotpasslink);
				WebClickUsingJS(EdaatOR.Admin_forgotSendbtn);
				VerifyValue1(getText(EdaatOR.Admin_forgotError),testdatamap.get("Expected").toString());
				test.log(Status.PASS, "Verify Edaat Forgot password error is Successful" + driver.getTitle() + " * Forgot password error * ");
				this.takeScreenShot();

			}
		}

		catch(Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "Verify Edaat Logo is Not Successful" + driver.getTitle() + " * Edaat Logo * ");

		}	

	}
}
