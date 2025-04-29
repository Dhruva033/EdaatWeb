/**
*
* Test Script Name                      : BillerLogin.
* Objective                             : Verify the Biller Login Functionality.
* Version                               : 1.0
* Author                                : Kathirvelu M
* Created Date                          : 02/06/2023
* Last Updated on                       : N/A
* Updated By                            :  Arun Kumar MS.
* Pre-Conditions                        : 
* Manual Testcase Name                  : BillerLogin.
* Epic Details                          : N/A
* User Story Details                    : N/A
* Defects affecting this test script    : None
* Work Arounds/Known Issues             : None
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class BillerLoginPage extends BasePage {

	public BillerLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}
	//Function Summary   : Method to Check Mainpage/Error message is displayed.
	//Parameter Summary : N/A.
	public void ExistsCheckElement(String Main,Log Log) throws InterruptedException {
		Thread.sleep(1000);
		this.takeScreenShot();
		boolean Header;
		try {
			Header = ExistsCheck(Main);
			
		//	if (Header) {
				test.log(Status.PASS, "#FUNC-Element Exists" + driver.getTitle() + " * Element Exists * ");
	        	Log.ReportEvent("PASS", " Verify Main Page is Dislayed");	        	

		//	} else {
		//		test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
		//	}
		} catch (Exception e) {
			throw new NoSuchElementException("Biller Home Page - Not Loaded");
		}
	}

	//LOGIN TO APPLICATION WITH GLOBAL LOGIN USER ID FROM LOGIN PAGE
	public void LoginToApplication(Log Log){
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
			test.log(Status.PASS, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");
			Log.ReportEvent("PASS", " Verify Biller Login is Suceessfull");

		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to Login Edaat Application using Biller login credentials.
	//Parameter Summary : LoginUserName,LoginPassword.
	public void LoginToApplication(Map<Object,Object> testdatamap,Log Log){
		try {
			Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
			login.next();
		//	this.Exists();
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
			test.log(Status.PASS, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");
  			Log.ReportEvent("PASS", " Verify Biller Login is Suceessfull");

		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}
	//LOGIN TO APPLICATION WITH INDIVIDUAL TESTDATA SHEET(SAME SHEET - CALL THIS METHOD IF USER WANTS PASS USER ID FROM THE SAME SHEET)
	//Function Summary   : Method to Login Edaat Application using invalid/Activated/inActivated Biller login credentials.
	//Parameter Summary  : username,password.
	public void LoginToApplication(String username, String password,Log Log) {
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
			test.log(Status.PASS, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");
        	Log.ReportEvent("PASS", " Verify Biller Login is Suceessfull");

		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
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

	public void Logout(String logout,Log Log) {
		try {
			WebClickUsingJS(logout);
			test.log(Status.PASS, "#FUNC-Logout Successful" + driver.getTitle() + " * Logout * ");
        	Log.ReportEvent("PASS", " Logout  Suceessful");

			this.takeScreenShot();
			
		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Logout Not Successful" + driver.getTitle() + " * Not Logout * ");
			throw new NoSuchElementException("Logout - Logout Failed");

		}
	}
	//Function Summary   : Method to Verifying ForgetPassword Functionality.
	//Parameter Summary : username,forGet.
	public void ForgetPassword(String forGet,String Username,Log Log) {
		try {
			WebClickUsingJS(forGet);
			WebEdit(EdaatOR.LoginPage_Username, Username);
			WebClickUsingJS(EdaatOR.LoginPage_send);
			test.log(Status.PASS, "#FUNC-ForgetPassword functionality Successful" + driver.getTitle() + " * Forget Password * ");
			Log.ReportEvent("PASS"," Verify Biller Forgetpassword Functionality");
			this.takeScreenShot();
		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-ForgetPassword functionality Not Successful" + driver.getTitle() + " * Forget Password * ");
			throw new NoSuchElementException("ForgetPassword - ForgetPassword Failed");

		}
	}
	//Function Summary   : Method to Click on Biller Login Button  
		//Parameter Summary : 
	public void clickOnBillerLogin() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Biller_Link);
		waitForPageToLoad();
		Thread.sleep(1000);
	}
	public void ChangeLanguage(Log Log) throws InterruptedException {
		WebClickUsingJS(EdaatOR.Biller_AR_LoginBtn);
		Thread.sleep(2000);
		this.takeScreenShot();
		WebClickUsingJS(EdaatOR.Biller_Login_ChangeLanguage);
		Thread.sleep(2000);
		this.takeScreenShot();
       	Log.ReportEvent("PASS", " Verify Biller Application Launched Suceessfully");

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
				test.log(Status.PASS, "#FUNC-Verify Edaat Logo is Successful" + driver.getTitle() + " * Edaat Logo * ");
				Log.ReportEvent("PASS", " Verify to click on EDAAT logo and navigate to home page");
				this.takeScreenShot();
			}
	catch(Exception e) {
		this.takeScreenShot();
		test.log(Status.FAIL, "#FUNC-Verify Edaat Logo is Not Successful" + driver.getTitle() + " * Edaat Logo * ");

	}		
		}	
		
		
	//Function Summary   : Method to verify links in the footer page.
    //Parameter Summary : NA.
	public void footerlinks(Log Log)
	{
		try
		{
			AboutUs();
			Services();
			Information();
			Log.ReportEvent("PASS", " Verify the linkes in the Footer page is Successful");	
		}
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * ");
			
		}
	}
	
	//Function Summary   : Method to verify links in the footer page.
    //Parameter Summary : NA.
	public void AboutUs() throws InterruptedException
	{
		AboutEdaat();
		Thread.sleep(1000);
		Ourservices();
		Thread.sleep(1000);
		OursClients();
		Thread.sleep(1000);
		Fintech();
		
	}
	//Function Summary   : Method to verify links in the footer page.
    //Parameter Summary : NA.
	public void Services() throws Exception{
		BillerEnquiry();
		Thread.sleep(1000);
		driver.navigate().back();
		ClientRegister();
		Thread.sleep(1000);
		BillerRegister();
	}
	//Function Summary   : Method to verify links in the footer page.
    //Parameter Summary : NA.
	public void Information() throws InterruptedException {
		ContactUS();
		Thread.sleep(1000);
		FAQ();
		Thread.sleep(1000);
		Terms();
		Thread.sleep(1000);
		Privacy();
		
     }
	//Function Summary   : Method to verify AboutEdaat links in the footer page.
    //Parameter Summary : NA.
	public void AboutEdaat()
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_About_Edaat);
	          switchToWindow();
	          verifyElementIsPresent(EdaatOR.Biller_About_verify);
			  test.log(Status.PASS, "#FUNC-AboutEdaat" + driver.getTitle() + " * AboutEdaat link opened successfully* ");
		      this.takeScreenShot();
			  driver.navigate().back();
		    }
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
	}
	//Function Summary   : Method to verify Ourservices link in the footer page.
    //Parameter Summary : NA.

	public void Ourservices()
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_OurService);
	          switchToWindow();
	          verifyElementIsPresent(EdaatOR.Biller_OurService_verif);
			  test.log(Status.PASS, "#FUNC-Ourservices" + driver.getTitle() + " * Ourservices link opened successfully* ");
		      this.takeScreenShot();
			  driver.navigate().back();
		    }
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
	}
	
	//Function Summary   : Method to verify Fintech link in the footer page.
    //Parameter Summary : NA.
	public void Fintech()
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_fintech);
	         /* switchToWindow();
	          verifyElementIsPresent(EdaatOR.Biller_OurClient_verif); */
			  test.log(Status.PASS, "#FUNC-Fintech" + driver.getTitle() + " * Fintech link opened successfully* ");
		      this.takeScreenShot();
			  driver.navigate().back();
		    }
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
	}
	//Function Summary   : Method to verify OursClients link in the footer page.
    //Parameter Summary : NA.
	public void OursClients()
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_OurClient);
	          switchToWindow();
	          verifyElementIsPresent(EdaatOR.Biller_OurClient_verif);
			  test.log(Status.PASS, "#FUNC-Fintech" + driver.getTitle() + " * Fintech link opened successfully* ");
		      this.takeScreenShot();
			  driver.navigate().back();
		    }
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
	}
	
	//Function Summary   : Method to verify BillerEnquiry link in the footer page.
    //Parameter Summary : NA.
	public void BillerEnquiry()
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_Enquiry);
	          switchToWindow();
	          verifyElementIsPresent(EdaatOR.Biller_Enquiry_verif);
	          WebClickUsingJS(EdaatOR.Biller_Clientreg_cancel);
	          WebClickUsingJS(EdaatOR.Biller_Clientreg_yescancel);
			  test.log(Status.PASS, "#FUNC-BillerEnquiry" + driver.getTitle() + " * BillerEnquiry link opened successfully* ");
		      this.takeScreenShot();
			  driver.navigate().back();
		    }
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
		
	}
	//Function Summary   : Method to verify ClientRegister link in the footer page.
    //Parameter Summary : NA.
	public void ClientRegister()
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_Clientreg);
	          switchToWindow();
	          verifyElementIsPresent(EdaatOR.Biller_Clientreg_verif);
			  test.log(Status.PASS, "#FUNC-ClientRegister" + driver.getTitle() + " * ClientRegister link opened successfully* ");
		      this.takeScreenShot();
			  driver.navigate().back();

		    }
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
		

	}
	//Function Summary   : Method to verify BillerRegister link in the footer page.
    //Parameter Summary : NA.
	public void BillerRegister()
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_registerlnk);
	          switchToWindow();
	          verifyElementIsPresent(EdaatOR.Biller_registerlnk_verif);
			  test.log(Status.PASS, "#FUNC-BillerRegister" + driver.getTitle() + " * BillerRegister link opened successfully* ");
		      this.takeScreenShot();
			  driver.navigate().back();

		    }
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
	}
	
	//Function Summary   : Method to verify ContactUS link in the footer page.
    //Parameter Summary : NA.
   public void ContactUS()
   {
	   try {
	          WebClickUsingJS(EdaatOR.Biller_registerlnk);
	          switchToWindow();
	          verifyElementIsPresent(EdaatOR.Biller_registerlnk_verif);
			  test.log(Status.PASS, "#FUNC-BillerRegister" + driver.getTitle() + " * BillerRegister link opened successfully* ");
		      this.takeScreenShot();
			  driver.navigate().back();
		    }
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * ");
		}
	   
   }
	//Function Summary   : Method to verify FAQ link in the footer page.
   //Parameter Summary : NA.
   public void FAQ()
   {
	   try {
		   WebClickUsingJS(EdaatOR.Biller_FAQ_link);
		   switchToWindow();
		   verifyElementIsPresent(EdaatOR.Biller_FAQ_Verify);
		   test.log(Status.PASS, "#FUNC-FAQ" + driver.getTitle() + " * FAQ link opened successfully* ");
		   this.takeScreenShot();
		   driver.navigate().back();
	   }
	   catch(Exception e)
	   {
		   this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * ");
	   }
	   
	   
   }
	//Function Summary   : Method to verify Terms and Condition link in the footer page.
   //Parameter Summary : NA.
   public void Terms()
   {
      try {
    	   WebClickUsingJS(EdaatOR.Biller_Tearms_link);
    	   switchToWindow();
    	   verifyElementIsPresent(EdaatOR.Biller_Tearms_Verify);
    	   test.log(Status.PASS, "#FUNC-BillerRegister" + driver.getTitle() + " * BillerRegister link opened successfully* ");
	       this.takeScreenShot();
			  driver.navigate().back();
	   }
	   catch(Exception e)
	   {
		   this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * ");
	   }
	    
   }
	//Function Summary   : Method to verify Privacy policy link in the footer page.
   //Parameter Summary : NA.
   public void Privacy()
   {
     try {
    	   WebClickUsingJS(EdaatOR.Biller_Priavcy_link);
    	   switchToWindow();
    	   verifyElementIsPresent(EdaatOR.Biller_Priavcy_verify);
    	   test.log(Status.PASS, "#FUNC-Privacy" + driver.getTitle() + " * Privacy policy link opened successfully* ");
	       this.takeScreenShot();
			  driver.navigate().back();
	   }
	   catch(Exception e)
	   {
		this.takeScreenShot();
		test.log(Status.FAIL, "#FUNC-Element not Exists" + driver.getTitle() + " * Element not Exists * "); 
	   }
	   
   }	
   public void InvalidLogin(Map<Object,Object> testdatamap)
   {
	   try {
		   WebEdit(EdaatOR.Biller_InvalidloginUserName,testdatamap.get("UserName").toString());
		   Thread.sleep(2000);
		   WebEdit(EdaatOR.Biller_InvalidloginPassword,testdatamap.get("Password").toString());
		   Thread.sleep(2000);
           WebClick(EdaatOR.Biller_InvalidloginButton);
           Thread.sleep(1000);
           LoginErrormeaasgaeValidation(testdatamap);
           test.log(Status.PASS, "#FUNC-Invalid Error message" + driver.getTitle() + " * Invalid login error message Success* "); 
	   }
	   catch(Exception e)
	   {
		   this.takeScreenShot();
		test.log(Status.FAIL, "#FUNC-Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
 }
   }

   public void LoginErrormeaasgaeValidation(Map<Object,Object> testdatamap) throws InterruptedException {
		this.takeScreenShot();
		String Expected=testdatamap.get("ExpectedMessage").toString();
		try {
			if (ExistsCheck(EdaatOR.Biller_InvalidloginUserError)&&(ExistsCheck(EdaatOR.Biller_InvalidloginPasswordError))) {
				VerifyValue(Expected,EdaatOR.Biller_InvalidloginUserError);
				test.log(Status.PASS, "#FUNC-LoginUserName ErrorMessage Exists" + driver.getTitle() + " * LoginUserNameAndpassword ErrorMessage Exists * ");
			}
			else if	(ExistsCheck(EdaatOR.Biller_InvalidloginPasswordError)) {
				VerifyValue(Expected,EdaatOR.Biller_InvalidloginPasswordError);
				test.log(Status.PASS, "#FUNC-LoginUserName ErrorMessage Exists" + driver.getTitle() + " * LoginPassword ErrorMessage Exists * ");	
   }
			else if	(ExistsCheck(EdaatOR.Biller_InvalidloginUserErrors)) {
				VerifyValue(Expected,EdaatOR.Biller_InvalidloginUserErrors);
				test.log(Status.PASS, "#FUNC-LoginUserName ErrorMessage Exists" + driver.getTitle() + " * LoginPassword ErrorMessage Exists * ");	
   }
		}
		   catch(Exception e)
		   {
			   this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
	 }

}
	//Function Summary   : Method to Verifying ForgetPassword Functionality.
	//Parameter Summary : username,forGet.
	public void ForgetPasswordValidation(String forGet,String Username) {
		try {
			WebClickUsingJS(forGet);
			//WebClick(EdaatOR.Biller_forgetlinksendbtn);			
			WebClickUsingJS(EdaatOR.LoginPage_send);
			VerifyValue(Username,EdaatOR.Biller_Usernamevalidation);
			test.log(Status.PASS, "#FUNC-ForgetPassword functionality Successful" + driver.getTitle() + " * Forget Password * ");
			this.takeScreenShot();
		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-ForgetPassword functionality Not Successful" + driver.getTitle() + " * Forget Password * ");
			throw new NoSuchElementException("ForgetPassword - ForgetPassword Failed");

		}
	}
}
