
package com.azmqalabs.edaattestautomation.apppages.Client.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.google.sitebricks.routing.Action;



public class ClientSignUpPage extends BasePage
{

	public ClientSignUpPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Client)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}

	

	//Function Summary   : Method to click on "Client Login" in Home page.
	//Parameter Summary  : N/A
	public void ClickOnClientLogin() {
		WebClickUsingJS(EdaatOR.Client_Link);
		waitForPageToLoad();
	}

	//Function Summary   : Method to click on "New client" in client Login page.
	//Parameter Summary  : N/A
	public void ClickOnClientSignUpBtn() {
		WebClickUsingJS(EdaatOR.Client_SignUp_Btn);
		waitForPageToLoad();
	}
	
	
	
		//Function Summary   : Method to Enter client FirstName.
		//Parameter Summary  : FirstName.
		public void EnterClientFirstName(Map<Object,Object>testdatmap) {
			WebEdit(EdaatOR.Client_FirstName_eField,testdatmap.get("FirstName").toString());
		}

		//Function Summary   : Method to Enter client SecondNmae.
		//Parameter Summary  : SecondName.
		public void EnterClientSurName(Map<Object,Object>testdatmap) {
			WebEdit(EdaatOR.Client_SecName_eField,testdatmap.get("SecondName").toString());
		}
		//Function Summary   : Method to Enter client ThirdName.
		//Parameter Summary  : ThirdName.
		public void EnterClientGradFatherName(Map<Object,Object>testdatmap) {
			WebEdit(EdaatOR.Client_ThriName_eField,testdatmap.get("ThirdName").toString());
		}
		//Function Summary   : Method to Enter client LastName.
		//Parameter Summary  : LastName.
		public void EnterClientLastName(Map<Object,Object>testdatmap) {
			WebEdit(EdaatOR.Client_LastName_eField,testdatmap.get("LastName").toString());
		}
	
		//Function Summary   : Method to Enter Client National ID.
		//Parameter Summary  : NationalID_.	
		public void EnterClientNationalID(Map<Object,Object>testdatmap) {
			WebEdit(EdaatOR.Client_NationalID_eField,testdatmap.get("National ID").toString());
		}
		
	//Function Summary   : Method to Enter DateOfBirthHijri.
	//Parameter Summary  : N/A
	public void EnterClientRegistDate() throws Exception {
		WebClick(EdaatOR.Client_DateOfBirthHijri_eField);
		Thread.sleep(800);
		WebClick(EdaatOR.Client_RegistDate_Issuedate);
	}
	
	//Function Summary   : Method to Enter Client DateofBirth Date.
	//Parameter Summary  : N/A
	public void EnterClientExperyDate() throws InterruptedException {
		//WebEdit(EdaatOR.Biller_ExperyDate_eField,ExperyDate);
		WebClick(EdaatOR.Client_ExperyDate_eField);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Client_RegistDate_exprDate);
	}

	//Function Summary   : Method to Upload attachment path.
	//Parameter Summary  : N/A.	
	public void  getAutoItImagePathFile() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//EdaatLogo.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(800);
	}

	//Function Summary   : Method to Upload Client ID attachment.
	//Parameter Summary  : N/A.	
	public void UploadClientAttachment() throws Exception   {
		WebClickUsingActions(EdaatOR.Client_IDAttachment_eField);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}
	

	
	
	//Function Summary   : Method to Enter Client Mobile Number.
	//Parameter Summary  : MobileNo.	
	public void EnterClientPhNo(Map<Object,Object>testdatmap) {
		WebEdit(EdaatOR.Client_PhNo_eField,testdatmap.get("MobileNo").toString());
	}
	
	//Function Summary   : Method to Enter Client EmailID.
	//Parameter Summary  : Email.
	public void EnterClientEmailID(Map<Object,Object>testdatmap) {
		WebEdit(EdaatOR.Client_EmailID_eField,testdatmap.get("Email").toString());
	}
	
	//Function Summary   : Method to Enter Client Password.
	//Parameter Summary  : Password.
	public void EnterClientPassword(Map<Object,Object>testdatmap) {
		WebEdit(EdaatOR.Client_Password_eField,testdatmap.get("Password").toString());
	}
	
	//Function Summary   : Method to Enter Client Confirm Password.
	//Parameter Summary  : ConfirmPassword.
	public void EnterClientConfPawd(Map<Object,Object>testdatmap) {
		WebEdit(EdaatOR.Client_ConfPawd_eField,testdatmap.get("ConfirmPassword").toString());
	}
	
	 //Function Summary   : Method to Click on Terms and Condition Checkbox.
	//Parameter Summary  : N/A.
	public void ClickOnClientConfirmation() {
		WebClickUsingJS(EdaatOR.Client_Terms_CheckBox);
		
	}
	
     //Function Summary   : Method to Click on Register Button.
	 //Parameter Summary  : N/A.
	public void ClickOnRegisterBtn() {
		WebClickUsingJS(EdaatOR.Client_Registration_btn);
	}
	
	  //Function Summary   : Method to RegisterClient and Email confirmation.
	 //Parameter Summary  : N/A.
	public void ClientRegister(Map<Object, Object> testdatamap,Log Log) {
		try {
			ClickOnClientLogin();
			ClickOnClientSignUpBtn();
			EnterClientFirstName(testdatamap);
			EnterClientSurName(testdatamap);
			EnterClientGradFatherName(testdatamap);
			EnterClientLastName(testdatamap);
			EnterClientNationalID(testdatamap);
			//EnterClientRegistDate();
			EnterClientExperyDate();
			UploadClientAttachment();
			EnterClientPhNo(testdatamap);
			EnterClientEmailID(testdatamap);
			EnterClientPassword(testdatamap);
			EnterClientConfPawd(testdatamap);
			ClickOnClientConfirmation();
			ClickOnRegisterBtn();
			Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.Client_FirstName_eField_error) || 
				CheckElementExists(EdaatOR.Client_SecName_eField_error) || 
				CheckElementExists(EdaatOR.Client_ThriName_eField_error) ||
				CheckElementExists(EdaatOR.Client_LastName_eField_error) ||
				CheckElementExists(EdaatOR.Client_NationalID_eField_error) ||
				CheckElementExists(EdaatOR.Client_ExperyDate_eField_error) ||
				CheckElementExists(EdaatOR.Client_DateOfBirthHijri_eField_error) ||
				CheckElementExists(EdaatOR.Client_PhNo_eField_error) ||
				CheckElementExists(EdaatOR.Client_EmailID_eField_error) ||
				CheckElementExists(EdaatOR.Client_Password_eField_error) ||
				CheckElementExists(EdaatOR.Client_ConfPawd_eField_error)||
				CheckElementExists(EdaatOR.Client_EmailValidatonMessage)) {
				Log.ReportEvent("FAIL", "Client Registration is UnSuccessful");
				this.takeScreenShot();
				Assert.fail();
				
			} else {
				verifyElementIsPresent(EdaatOR.Client_Registrationconfmmsg,testdatamap.get("ConfirmRegistration").toString());
				Thread.sleep(2000);
	            VerifyValue1(WebGetText("//h6[contains(text(),'Email is sent to "+testdatamap.get("Email").toString()+", please activate your account')]"),"Email is sent to "+testdatamap.get("Email").toString()+", please activate your account");
				Log.ReportEvent("PASS", "Client Registration is Successful");
			}
			}
		catch(Exception e){		
			Log.ReportEvent("FAIL", "Client Registration is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			Assert.fail();
		}
	}

	//Function Summary   : Method to RegisterClient with Invalid Data
	//Parameter Summary  : 
	public void ClientRegisterwithInvalidData(Map<Object, Object> testdatamap,Log Log) {
		try {
			ClickOnClientLogin();
			ClickOnClientSignUpBtn();
			EnterClientFirstName(testdatamap);
			EnterClientSurName(testdatamap);
			EnterClientGradFatherName(testdatamap);
			EnterClientLastName(testdatamap);
			EnterClientNationalID(testdatamap);
			//EnterClientRegistDate();
			EnterClientExperyDate();
			UploadClientAttachment();
			EnterClientPhNo(testdatamap);
			EnterClientEmailID(testdatamap);
			EnterClientPassword(testdatamap);
			EnterClientConfPawd(testdatamap);
			ClickOnClientConfirmation();
			ClickOnRegisterBtn();
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Client_EmailValidatonMessage,testdatamap.get("EmailValidation").toString());
			Thread.sleep(2000);	
			test.log(Status.PASS,"Client Registration" + driver.getTitle() +" * Client Registration Pass * " );
        	Log.ReportEvent("PASS", "Verify Validation Message with Negative Scenario is  Sucessful");
        	this.takeScreenShot();
			}
		catch(Exception e){			
			test.log(Status.FAIL,"Client Registration" + driver.getTitle() +" *Client Registration FAIL * " );		
			this.takeScreenShot();
		}
	}
	
	
	
//Function Summary   : Method for Client registration 
//Parameter Summary  : N/A.
	public void ClientRegistration(Map<Object, Object> testdatamap) throws Exception {
	
			ClickOnClientLogin();
			Thread.sleep(500);
			ClickOnClientSignUpBtn();
			Thread.sleep(500);
			EnterClientFirstName(testdatamap);
			Thread.sleep(500);
			EnterClientSurName(testdatamap);
			Thread.sleep(500);
			EnterClientGradFatherName(testdatamap);
			Thread.sleep(500);
			EnterClientLastName(testdatamap);
			Thread.sleep(500);
			EnterClientNationalID(testdatamap);
			Thread.sleep(500);
			EnterClientRegistDate();
			Thread.sleep(500);
			EnterClientPhNo(testdatamap);
			Thread.sleep(500);
			EnterClientEmailID(testdatamap);
			Thread.sleep(500);
			EnterClientPassword(testdatamap);
			Thread.sleep(500);
			EnterClientConfPawd(testdatamap);
			Thread.sleep(500);
			ClickOnClientConfirmation();
			Thread.sleep(500);
			ClickOnRegisterBtn();
			Thread.sleep(500);
	}
	
	//Function Summary   : Method to  verify Error messages in Client registration page
	//Parameter Summary  : N/A.	
	public void ClientRegistrationErrormessageValidation(Map<Object, Object> testdatamap) throws Exception {
		ClientRegistration(testdatamap);
		
		String Expected=testdatamap.get("ExpectedResult").toString();
		try {
			 if (ExistsCheck(EdaatOR.Admin_RequiredFieldsErrMsg)){	
				
				VerifyValue1(Expected, getText(EdaatOR.Admin_FirstNameErrorMsg));
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Client_SecondNameErrorMsg));
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Client_ThirdNameErrorMsg));
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Admin_LastNameErrorMsg));
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Client_NationalIDErrMsg));
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Client_DOBErrMsg));
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Admin_MobileNoErrorMsg));
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Client_EmailErrorMsg));	
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Client_PasswordErrMsg));	
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Client_ConfirmPasswordErrMsg));	
				test.log(Status.PASS, "Client signup Required field ErrorMessage Exists" + driver.getTitle() + " *   Error Message Exists * ");
			}
			else if (ExistsCheck(EdaatOR.Client_FullNameErrMsg)){	
				VerifyValue1(Expected, getText(EdaatOR.Admin_FirstNameErrorMsg));
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Client_SecondNameErrorMsg));
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Client_ThirdNameErrorMsg));
				Thread.sleep(500);
				VerifyValue1(Expected, getText(EdaatOR.Admin_LastNameErrorMsg));			

				test.log(Status.PASS, "FullName Error Message Exists" + driver.getTitle() + " *FullName ErrorMessage Exists * ");
			}
			
			else if (ExistsCheck(EdaatOR.Client_NationalIDErrMsg) ){	
								
				if(ExistsCheck(EdaatOR.Client_NationaIDStartsErrMsg)) {
					VerifyValue(Expected,EdaatOR.Client_NationaIDStartsErrMsg);				
					test.log(Status.PASS, "Nationa ID Error Message Exists" + driver.getTitle() + " *Error Message Exists * ");
				}else if(ExistsCheck(EdaatOR.Client_NationaIDDigitErrMsg)) { 
					VerifyValue(Expected,EdaatOR.Client_NationaIDDigitErrMsg);				
					test.log(Status.PASS, "Nationa ID Error Message Exists" + driver.getTitle() + " *Error Message Exists * ");
				}

			}
			else if(ExistsCheck(EdaatOR.Client_NationaIDExistsErrMsg)) { 
				VerifyValue(Expected,EdaatOR.Client_NationaIDExistsErrMsg);				
				test.log(Status.PASS, " NationalID Exists alert Message Exists" + driver.getTitle() + " *NationalID alert Message Exists * ");
			}
			else if (ExistsCheck(EdaatOR.Admin_MobileNoErrorMsg) ){	
				VerifyValue(Expected,EdaatOR.Admin_MobileNoErrorMsg);				

				test.log(Status.PASS, "Mobile number Error Message Exists" + driver.getTitle() + " *Mobile number ErrorMessage Exists * ");
			}						
			else if (ExistsCheck(EdaatOR.Client_EmailErrorMsg) ){	
				VerifyValue(Expected,EdaatOR.Client_EmailErrorMsg);				

				test.log(Status.PASS, "Email Error Message Exists" + driver.getTitle() + " *Mobile number ErrorMessage Exists * ");
			}	
			else if (ExistsCheck(EdaatOR.Client_EmailExistsErrMsg) ){	
				VerifyValue(Expected,EdaatOR.Client_EmailExistsErrMsg);				

				test.log(Status.PASS, "Email Error Message Exists" + driver.getTitle() + " *Mobile number ErrorMessage Exists * ");
			}	
			else if (ExistsCheck(EdaatOR.Client_PasswordErrMsg) ){	
				VerifyValue(Expected,EdaatOR.Client_PasswordErrMsg);				

				test.log(Status.PASS, "Password Error Message Exists" + driver.getTitle() + " *Mobile number ErrorMessage Exists * ");
			}
			else if (ExistsCheck(EdaatOR.Client_ConfirmPasswordErrMsg) ){	
				VerifyValue(Expected,EdaatOR.Client_ConfirmPasswordErrMsg);				

				test.log(Status.PASS, "Confirm password Error Message Exists" + driver.getTitle() + " *Mobile number ErrorMessage Exists * ");
			}			 
        	else {
				test.log(Status.FAIL, "Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
			}
		} catch (Exception e) {
			throw new NoSuchElementException("Client Registration Page - Not Loaded");

		}
		
	}	
}






