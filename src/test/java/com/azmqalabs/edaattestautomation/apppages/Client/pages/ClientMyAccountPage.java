/**
*
* Test Script Name                      : NA.
* Objective                             : Verify to update client Profile Functionality.
* Version                               : 1.0
* Author                                : Kalpana I R
* Created Date                          : 
* Last Updated on                       : N/A
* Updated By                            : 
* Pre-Conditions                        : 1)Client Login Credentials.
* Epic Details                          : N/A
* User Story Details                    : N/A
* 
**/
package com.azmqalabs.edaattestautomation.apppages.Client.pages;

import java.io.IOException;
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
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;

public class ClientMyAccountPage extends BasePage {

	public ClientMyAccountPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}


	@FindBy(xpath = EdaatOR.ClientMyAccountMenu)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}
	//Function summary:Verify Update Client Profile and Save.
	//Function Parameters:SecondName,ThirdName,LastName and MobileNumber.
	public void UpdateClientProfileSave(Map<Object,Object>testdatamap,Log Log) throws InterruptedException
	{
		try {
			
			WebClickUsingJS(EdaatOR.ClientMyAccUpdateProfileMenu);
			Thread.sleep(1500);
			WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileSecondName, testdatamap.get("SecondName").toString());
		    Thread.sleep(1500);
		    WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileThirdName, testdatamap.get("ThirdName").toString());
		    Thread.sleep(1500);
		    WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileLastName, testdatamap.get("LastName").toString());
		    Thread.sleep(1500);
		    WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileMobNumber, testdatamap.get("MobileNumber").toString());
		    Thread.sleep(1500);
		    WebClick(EdaatOR.ClientMyAccUpdateProfileSaveChangesBTN);
			Thread.sleep(1500);	
			test.log(Status.PASS,"Verify Update and save Profile " + driver.getTitle() +" * Update Client Profile and Save is Pass * " );
		  	Log.ReportEvent("PASS", "Verify Update Client Profile Sucessful");
			}
			catch (Exception e) {
				this.takeScreenShot();
				test.log(Status.FAIL,"Verify Update and save Profile " + driver.getTitle() +" * Update Client Profile and Save is Fail * " );
			}		
	}
//Function summary:Verify Update Client Profile and Close
//Function Parameters:SecondName,ThirdName,LastName and MobileNumber.
	public void UpdateClientProfileClose(Map<Object,Object>testdatamap,Log Log)
	{
      try {	
			WebClickUsingJS(EdaatOR.ClientMyAccUpdateProfileMenu);
			Thread.sleep(1500);
			WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileSecondName, testdatamap.get("SecondName").toString());
		    Thread.sleep(1500);
		    WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileThirdName, testdatamap.get("ThirdName").toString());
		    Thread.sleep(1500);
		    WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileLastName, testdatamap.get("LastName").toString());
		    Thread.sleep(1500);
		    WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileMobNumber, testdatamap.get("MobileNumber").toString());
		    Thread.sleep(1500);
		    WebClick(EdaatOR.ClientMyAccUpdateProfileCancelbtn);
			Thread.sleep(1500);
			test.log(Status.PASS,"Verify Update Client Profile Close" + driver.getTitle() +" * Update Client Profile Close is Pass * " );
		  	Log.ReportEvent("PASS", "Verify to update client Profile & Close");
            this.takeScreenShot();
			}
			catch (Exception e) {
				this.takeScreenShot();
				test.log(Status.FAIL,"Verify Update and save Profile " + driver.getTitle() +" * Update Client Profile and Save is Fail * " );
			}		
	}
	//Function summary:Verify Update Client Login info and close.
	//Function Parameters:New Password,Old Password,Confirm Password
		public void UpdateClientLoginInfoClose(Map<Object,Object>testdatamap,Log Log)
		{
	      try {	
	            WebClickUsingJS(EdaatOR.ClientMyAccUpdateLoginInfo);
	            Thread.sleep(800);
				this.takeScreenShot();
                WebEdit(EdaatOR.ClientLogininfoOldPassword, testdatamap.get("Old Password").toString());
	            Thread.sleep(800);
                WebEdit(EdaatOR.ClientLogininfoNewPassword, testdatamap.get("New Password").toString());
	            Thread.sleep(800);
	            WebEdit(EdaatOR.ClientLogininfoConfirmPassword, testdatamap.get("Confirm Password").toString());
	            Thread.sleep(800);
			    WebClick(EdaatOR.ClientMyAccUpdateProfileCancelbtn);
				Thread.sleep(800);
				this.takeScreenShot();
				test.log(Status.PASS,"Verify Update Client Profile Close" + driver.getTitle() +" * Update Client Profile Close is Pass * " );
	        	Log.ReportEvent("PASS", " verify update client login information");
	
	      }
				catch (Exception e) {
					this.takeScreenShot();
					test.log(Status.FAIL,"Verify Update and save Profile " + driver.getTitle() +" * Update Client Profile and Save is Fail * " );
				}		
	
		}	
	
		
		    
    //Function summary:Method to Verify NavigatetoUpdateClientLoginInfo
	//Function Parameters:N/A
	public void NavigatetoUpdateClientLoginInfo(Log Log) throws InterruptedException
	{
		WebClickUsingJS(EdaatOR.ClientMyAccUpdateClientLogininfo);
		this.takeScreenShot();
		Thread.sleep(1000);
    	Log.ReportEvent("PASS", "Navigate to Update Client Login ifo");

	}
	//Function summary	 :Method to Verify VerifyNewPwdNotMatchconfirmPwd
	//Function Parameters:OldPassword,NewPassword,ConfirmPassword,VerifyMessage
	public void VerifyNewPwdNotMatchconfirmPwd(Map<Object, Object> testdatamap,Log Log)
	{
		try
		{
		WebEdit(EdaatOR.ClientMyAccUpdateClientLogin_oldpwd,testdatamap.get("OldPassword").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.ClientMyAccUpdateClientLogin_newpwd,testdatamap.get("NewPassword").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.ClientMyAccUpdateClientLogin_confirmpwd,testdatamap.get("ConfirmPassword").toString());
		Thread.sleep(2000);
		WebClick(EdaatOR.ClientMyAccUpdateClientLogin_savebtn);
		Thread.sleep(3000);
		this.takeScreenShot();
		VerifyValue1(getText("//span[text()='"+testdatamap.get("VerifyMessage").toString()+"']"),testdatamap.get("VerifyMessage").toString());
		Thread.sleep(2000);
		this.takeScreenShot();
		test.log(Status.PASS,"Verify Incase New Password not match Confirm Password" + driver.getTitle() +" * New Password not match Confirm Password is Pass * " );
    	Log.ReportEvent("PASS", " Verify Incase New Password not match Confirm Password is successfull ");

		}
		catch (Exception e) {
			
		test.log(Status.FAIL,"Verify Incase New Password not match Confirm Password" + driver.getTitle() +" *  New Password not match Confirm Password is Fail * " );
		this.takeScreenShot();
		}

	}
	//Function summary	 :Method to UpdateClientLoginInfoSave
	//Function Parameters:OldPassword,NewPassword,ConfirmPassword
	public void UpdateClientLoginInfoSave(Map<Object,Object>testdatamap,Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.ClientMyAccUpdateLoginInfo);
		    Thread.sleep(1500);
			WebEdit(EdaatOR.ClientLogininfoOldPassword, testdatamap.get("Old Password").toString());
		    Thread.sleep(1500);
			WebEdit(EdaatOR.ClientLogininfoNewPassword, testdatamap.get("New Password").toString());
		    Thread.sleep(1500);
			WebEdit(EdaatOR.ClientLogininfoConfirmPassword, testdatamap.get("Confirm Password").toString());
		    Thread.sleep(1500);
			WebClickUsingJS(EdaatOR.ClientLogininfoSaveBtn);
		    Thread.sleep(1500);
			if(CheckElementExists(EdaatOR.ClientLogininfoSave_Verify)==true)
			{
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.ClientLogininfoyesbtn);
			test.log(Status.PASS,"Verify Update Client Login Info Save" + driver.getTitle() +" * Update Client Login Info Save is Pass * " );
			this.takeScreenShot();
        	Log.ReportEvent("PASS", "Verify to update client Login Info & Save is Successful");
			}
		}
		catch(Exception e)
		{
			this.takeScreenShot();
			test.log(Status.FAIL,"Verify Update Client Login Info Save" + driver.getTitle() +" * Update Client Login Info Save is Pass * " );
		}
		
	
	}
	//Function summary	 :Method to UpdateClientLoginInfoError
	//Function Parameters:OldPassword,NewPassword,ConfirmPassword
	public void UpdateClientLoginInfoError(Map<Object, Object> testdatamap) {
		try {
			WebClickUsingJS(EdaatOR.ClientMyAccUpdateLoginInfo);
		    Thread.sleep(1500);
			WebEdit(EdaatOR.ClientLogininfoOldPassword, testdatamap.get("Old Password").toString());
		    Thread.sleep(1500);
			WebEdit(EdaatOR.ClientLogininfoNewPassword, testdatamap.get("New Password").toString());
		    Thread.sleep(1500);
			WebEdit(EdaatOR.ClientLogininfoConfirmPassword, testdatamap.get("Confirm Password").toString());
		    Thread.sleep(1500);
			WebClickUsingJS(EdaatOR.ClientLogininfoSaveBtn);
		    Thread.sleep(1500);
			if(ExistsCheck(EdaatOR.ClientLogininfoOldPasswordError)&&ExistsCheck(EdaatOR.ClientLogininfoNewPasswordError)&&
			ExistsCheck(EdaatOR.ClientLogininfoConfiPasswordError))
			{
				VerifyValue(testdatamap.get("Expected").toString(), EdaatOR.ClientLogininfoOldPasswordError);
				VerifyValue(testdatamap.get("Expected").toString(), EdaatOR.ClientLogininfoNewPasswordError);
				VerifyValue(testdatamap.get("Expected").toString(), EdaatOR.ClientLogininfoConfiPasswordError);				
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "Client old Password,New Password and Confirm Password ErrorMessage Exists" + driver.getTitle() + " * Client oldpassword,Newpasswors and Confirm Password ErrorMessage Exists * ");
			}
			else if (ExistsCheck(EdaatOR.ClientLogininfoNewPasswordError)) {
				
				VerifyValue(testdatamap.get("Expected").toString(), EdaatOR.ClientLogininfoNewPasswordError);
				test.log(Status.PASS, "Client Invalid New Password  ErrorMessage Exists" + driver.getTitle() + " * Client Invalid Newpassword Error Message Exists * ");
				this.takeScreenShot();
				Thread.sleep(1000);
			}
			else if (ExistsCheck(EdaatOR.ClientLogininfoConfiPasswordError)) {
				
				VerifyValue(testdatamap.get("Expected").toString(), EdaatOR.ClientLogininfoConfiPasswordError);
				test.log(Status.PASS, "Client Invalid Confirm Password  ErrorMessage Exists" + driver.getTitle() + " * Client Invalid Confirmpassword Error Message Exists * ");
				this.takeScreenShot();
				Thread.sleep(1000);
			}
			else if (ExistsCheck(EdaatOR.ClientLogininfoOldPasswordInvalid)) {
				
				VerifyValue(testdatamap.get("Expected").toString(), EdaatOR.ClientLogininfoOldPasswordInvalid);
				test.log(Status.PASS, "Client Invalid old Password  ErrorMessage Exists" + driver.getTitle() + " * Client Invalid OldPassword Error Message Exists * ");
				this.takeScreenShot();
				Thread.sleep(1000);
			}
			else
			{
				test.log(Status.FAIL, "Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
			}
		}
		catch(Exception e)
		{
			this.takeScreenShot();
			test.log(Status.FAIL,"Verify Update Client Login Info Error Message validation" + driver.getTitle() +" * Update Client Login Info  Error Message validation is Pass * " );
		}	
		
	}
	public void UpdateClientProfile(Map<Object,Object>testdatamap) throws InterruptedException
	{
	try {
		String BirthDate = testdatamap.get("Birthdate").toString();
		WebClickUsingJS(EdaatOR.ClientMyAccUpdateProfileMenu);
		WebClearandEdit(EdaatOR.ClientMyaccount_Firstname,testdatamap.get("FirstName").toString());
	    Thread.sleep(1500);
		WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileSecondName, testdatamap.get("SecondName").toString());
	    Thread.sleep(1500);
	    WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileThirdName, testdatamap.get("ThirdName").toString());
	    Thread.sleep(1500);
	    WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileLastName, testdatamap.get("LastName").toString());
	    Thread.sleep(1500);
	    if(BirthDate.equalsIgnoreCase("No"))
	    {
	   // WebClearandEdit(EdaatOR.ClientMyaccount_Dateofbirth, testdatamap.get("Date of Birth").toString());
	    WebClear(EdaatOR.ClientMyaccount_Dateofbirth);
	    Thread.sleep(1500);
	    WebClear(EdaatOR.ClientMyaccount_DateofbirthHijiri);
	    Thread.sleep(1500);
	    }
	    WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileMobNumber, testdatamap.get("MobileNumber").toString());
	    Thread.sleep(1500);
	    WebClick(EdaatOR.ClientMyAccUpdateProfileSaveChangesBTN);
	    this.takeScreenShot();
	    UpdateClientProfileAllfieldsError(testdatamap);
	}
		catch(Exception e)
		{
			this.takeScreenShot();
			test.log(Status.FAIL,"Verify Update Client Login Info Save" + driver.getTitle() +" * Update Client Login Info Save is Pass * " );
		}
	}
	
	public void UpdateClientProfileAllfieldsError(Map<Object,Object>testdatamap) throws Exception
	{
	 try {
		String Field = testdatamap.get("TextField").toString();
		if(Field.equalsIgnoreCase("All"))
		{
	    VerifyValue1(getText(EdaatOR.ClientMyaccount_FirstnameError),testdatamap.get("Expected1").toString());
		test.log(Status.PASS,"Verify Update Client Profile First Name text field Error Message" + driver.getTitle() +" * Update Client Profile First Name text field Error Message is Pass * " );
	    Thread.sleep(1500);
	    VerifyValue1(getText(EdaatOR.ClientMyaccount_SecondnameError),testdatamap.get("Expected1").toString());
		test.log(Status.PASS,"Verify Update Client Profile Second Name text field Error Message" + driver.getTitle() +" *Update Client Profile Second Name text field Error Message is Pass  * " );
	    Thread.sleep(1500);
	    VerifyValue1(getText(EdaatOR.ClientMyaccount_thirdnameError),testdatamap.get("Expected1").toString());
		test.log(Status.PASS,"Verify Update Client Profile Third Name text field Error Message" + driver.getTitle() +" * Update Client Profile third Name text field Error Message is Pass  * " );
	    Thread.sleep(1500);
	    VerifyValue1(getText(EdaatOR.ClientMyaccount_lastnameError),testdatamap.get("Expected1").toString());
		test.log(Status.PASS,"Verify Update Client Profile last Name text field Error Message" + driver.getTitle() +" * Update Client Profile last Name text field Error Message is Pass * " );
	    Thread.sleep(1500);
	    VerifyValue1(getText(EdaatOR.ClientMyaccount_DateofbirthError),testdatamap.get("Expected1").toString());
		test.log(Status.PASS,"Verify Update Client Profile Date of birth text field Error Message" + driver.getTitle() +" * Update Client Profile Date of birth text field Error Message is Pass * " );
	    Thread.sleep(1500);
	    VerifyValue1(getText(EdaatOR.ClientMyaccount_DateofbirthHijiriError),testdatamap.get("Expected1").toString());
		test.log(Status.PASS,"Verify Update Client Profile Date of birth hijiri text field Error Message" + driver.getTitle() +" * Update Client Profile Date of birth hijiri text field Error Message is Pass* " );
	    Thread.sleep(1500);
	    VerifyValue1(getText(EdaatOR.ClientMyaccount_MobilenumError),testdatamap.get("Expected1").toString());
		test.log(Status.PASS,"Verify Update Client Profile Mobile number text field Error Message" + driver.getTitle() +" * Update Client Profile Mobile Number text field Error Message is Pass* " );
	   }
		else {
			
			if(CheckElementExists(EdaatOR.ClientMyaccount_FirstnameError))
			{
		       VerifyValue1(getText(EdaatOR.ClientMyaccount_FirstnameError),testdatamap.get("Expected2").toString());
			   test.log(Status.PASS,"Verify Update Client Profile First Name text field Error Message" + driver.getTitle() +" * Update Client Profile First Name text field Error Message is Pass * " );
			   this.takeScreenShot();
			}
			else if(CheckElementExists(EdaatOR.ClientMyaccount_SecondnameError))
			{
		       VerifyValue1(getText(EdaatOR.ClientMyaccount_SecondnameError),testdatamap.get("Expected2").toString());
				test.log(Status.PASS,"Verify Update Client Profile Second Name text field Error Message" + driver.getTitle() +" *Update Client Profile Second Name text field Error Message is Pass  * " );
			   this.takeScreenShot();
			}
			else if(CheckElementExists(EdaatOR.ClientMyaccount_thirdnameError))
			{
		       VerifyValue1(getText(EdaatOR.ClientMyaccount_thirdnameError),testdatamap.get("Expected2").toString());
				test.log(Status.PASS,"Verify Update Client Profile Third Name text field Error Message" + driver.getTitle() +" * Update Client Profile third Name text field Error Message is Pass  * " );
			   this.takeScreenShot();
			}
			else if(CheckElementExists(EdaatOR.ClientMyaccount_lastnameError))
			{
		       VerifyValue1(getText(EdaatOR.ClientMyaccount_lastnameError),testdatamap.get("Expected2").toString());
				test.log(Status.PASS,"Verify Update Client Profile last Name text field Error Message" + driver.getTitle() +" * Update Client Profile last Name text field Error Message is Pass * " );
			   this.takeScreenShot();
			}
			else if(CheckElementExists(EdaatOR.ClientMyaccount_DateofbirthError)&&CheckElementExists(EdaatOR.ClientMyaccount_DateofbirthHijiriError))
			{
		       VerifyValue1(getText(EdaatOR.ClientMyaccount_DateofbirthError),testdatamap.get("Expected1").toString());
		       VerifyValue1(getText(EdaatOR.ClientMyaccount_DateofbirthHijiriError),testdatamap.get("Expected1").toString());
		       test.log(Status.PASS,"Verify Update Client Profile date of birth and date of birth hijiri text field Error Message" + driver.getTitle() +" * Update Client Profile date of birth and date of birth hijiri text field Error Message is Pass * " );
			   this.takeScreenShot();
			}
			else if(CheckElementExists(EdaatOR.ClientMyaccount_MobilenumError))
			{
		       VerifyValue1(getText(EdaatOR.ClientMyaccount_MobilenumError),testdatamap.get("Expected1").toString());
				test.log(Status.PASS,"Verify Update Client Profile Mobile number text field Error Message" + driver.getTitle() +" * Update Client Profile Mobile Number text field Error Message is Pass* " );
			   this.takeScreenShot();
			}
		}
	 }
	 catch(Exception e)
		{
			this.takeScreenShot();
			test.log(Status.FAIL,"Verify Update Client Profile text fields" + driver.getTitle() +" * Update Client Profile text fields are Fail * " );
		}
	}		
}


