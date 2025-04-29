
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.google.sitebricks.routing.Action;

public class AdminSignUpPage extends BasePage
{

	public AdminSignUpPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_Client)
	public WebElement Client;
	
	public boolean Exists(){
		return super.Exists(Client); 
	}
	//Function Summary   : Method to  ClickOnAdminLogin
	//Parameter Summary  : N/A

	public void ClickOnAdminLogin() {
		WebClickUsingJS(EdaatOR.Admin_Link);
		waitForPageToLoad();
	}

	//Function Summary   : Method to ClickOnAdminSignUpBtn
	//Parameter Summary  : N/A
	public void ClickOnAdminSignUpBtn() {
		WebClickUsingJS(EdaatOR.Admin_SignUp_Btn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to EnterAdminCompanyName
	//Parameter Summary  : CompName
	public void EnterAdminCompanyName(String CompName) {
		WebEdit(EdaatOR.Admin_CompanyName_eField,CompName);
	}


	//Function Summary   : Method to SelectAdminEconomySector
	//Parameter Summary  : EconomySector
	public void SelectAdminEconomySector(String EconomySector) {
		WebSelect1(EdaatOR.Admin_EconomySector_List,EconomySector);
	}

	//Function Summary   : Method to SelectAdminCountry
	//Parameter Summary  : Country
	public void SelectAdminCountry(String Country) {
		WebSelect1(EdaatOR.Admin_Country_List,Country);
	}
	//Function Summary   : Method to SelectAdminCity
	//Parameter Summary  : City
	public void SelectAdminCity(String City) {
		WebSelect1(EdaatOR.Admin_City_List,City);
	}
	//Function Summary   : Method to SelectAdminCity
	//Parameter Summary  : City
	public void EnterAdminDistrict(String District) {
		WebEdit(EdaatOR.Admin_District_eField,District);
	}
	//Function Summary   : Method to EnterAdminStreet
	//Parameter Summary  : Street
	public void EnterAdminStreet(String Street) {
		WebEdit(EdaatOR.Admin_Street_eField,Street);
	}
	//Function Summary   : Method to EnterAdminBuildNo
	//Parameter Summary  : BuildNo
	public void EnterAdminBuildNo(String BuildNo) {
		WebEdit(EdaatOR.Admin_BuildNo_eField,BuildNo);
	}
	//Function Summary   : Method to EnterAdminPostalCode
	//Parameter Summary  : PostalCode
	public void EnterAdminPostalCode(String PostalCode) {
		WebEdit(EdaatOR.Admin_PostalCode_eField,PostalCode);
	}
	//Function Summary   : Method to  EnterAdminMailBox
	//Parameter Summary  : MailBox
	public void EnterAdminMailBox(String MailBox) {
		WebEdit(EdaatOR.Admin_MailBox_eField,MailBox);
	}
	//Function Summary   : Method to  EnterAdminOfficNo
	//Parameter Summary  : OfficNo
	public void EnterAdminOfficNo(String OfficNo) {
		WebEdit(EdaatOR.Admin_OfficNo_eField,OfficNo);
	}
	//Function Summary   : EnterAdminEmplyName
	//Parameter Summary  : EmplyName
	public void EnterAdminEmplyName(String EmplyName) {
		WebEdit(EdaatOR.Admin_EmplyName_eField,EmplyName);
	}
	//Function Summary   : EnterAdminEmplyJobTitle
	//Parameter Summary  : EmplyJobTitle
	public void EnterAdminEmplyJobTitle(String EmplyJobTitle) {
		WebEdit(EdaatOR.Admin_EmplyJobTitle_eField,EmplyJobTitle);
	}
	//Function Summary   : Method to EnterAdminEmplyMobileNum
	//Parameter Summary  : EmplyMob
	public void EnterAdminEmplyMobileNum(String EmplyMob) {
		WebEdit(EdaatOR.Admin_EmplyMobileNumber_eField,EmplyMob);
	}
	//Function Summary   : Method to EnterAdminEmplyEmail
	//Parameter Summary  : EmplyEmail
	public void EnterAdminEmplyEmail(String EmplyEmail) {
		WebEdit(EdaatOR.Admin_EmplyEmail_eField,EmplyEmail);
	}

	//Function Summary   : Method to EnterAdminCustomerSupPhNo
	//Parameter Summary  : CustomerSupPhNo
	public void EnterAdminCustomerSupPhNo(String CustomerSupPhNo) {
		WebEdit(EdaatOR.Admin_CustomerSupPhNo_eField,CustomerSupPhNo);
	}
	//Function Summary   : Method to EnterAdminIBANum
	//Parameter Summary  : IBANum
	public void EnterAdminIBANum(String IBANum) {
		WebEdit(EdaatOR.Admin_IBANum_eField,IBANum);
	}
	//Function Summary   : EnterAdminIBANAttmnt
	//Parameter Summary  : N/A
	public void EnterAdminIBANAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_IBANAttmnt_eField);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}
	//Function Summary   : Method to SelectAdminBankCountry
	//Parameter Summary  : BankCountry

	public void SelectAdminBankCountry(String BankCountry) {
		WebSelect(EdaatOR.Admin_BankCountryType_List,BankCountry);
	}
	//Function Summary   : Method to EnterAdminBankCertPath
	//Parameter Summary  : N/A

	public void EnterAdminBankCertPath() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_BankCertAttmnt_eField);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}
	//Function Summary   : Method to SelectAdminCRNumber
	//Parameter Summary  : N/A
	public void SelectAdminCRNumber(String CRNumber) {
		WebSelect(EdaatOR.Admin_CRNumber_eField,CRNumber);
	}
	//Function Summary   : Method to EnterAdminRegiAttachment
	//Parameter Summary  : N/A

	public void EnterAdminRegiAttachment() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_RegiAttachment_eField);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}
	//Function Summary   : Method to EnterAdminRegistDate
	//Parameter Summary  : N/A
	public void EnterAdminRegistDate(String RegistDate) throws Exception {
		//WebEdit(EdaatOR.Admin_RegistDate_eField,RegistDate);
		WebClick(EdaatOR.Admin_RegistDate_eField);
		//WebClickUsingJS(EdaatOR.Admin_RegistDate_eField);
		Thread.sleep(800);
		WebClick(EdaatOR.Admin_RegistDate_Issuedate);
	}
	//Function Summary   : Method to EnterAdminExperyDate
	//Parameter Summary  : N/A
	public void EnterAdminExperyDate(String ExperyDate) throws InterruptedException {
		//WebEdit(EdaatOR.Admin_ExperyDate_eField,ExperyDate);
		WebClick(EdaatOR.Admin_ExperyDate_eField);
		Thread.sleep(800);
		WebClick(EdaatOR.Admin_RegistDate_exprDate);
	}
	//Function Summary   : Method to EnterAdminTaxno
	//Parameter Summary  : Taxno

	public void EnterAdminTaxno(String Taxno) {
		WebEdit(EdaatOR.Admin_Taxno_eField,Taxno);
	}
	//Function Summary   : ClickOnIsTaxableRadBtn
	//Parameter Summary  : N/A
	public void ClickOnIsTaxableRadBtn() {
		WebClickUsingJS(EdaatOR.Admin_IsTaxable_RadBtn);
	}
	//Function Summary   : Method to ClickOnNoTaxableRadBtn
	//Parameter Summary  : N/A
	public void ClickOnNoTaxableRadBtn() {
		WebClickUsingJS(EdaatOR.Admin_NoTaxable_RadBtn);
	}
	//Function Summary   : Method to EnterTaxRegisAttmnt
	//Parameter Summary  : N/A
	public void EnterTaxRegisAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_TaxRegisAttmnt_eField);
		Thread.sleep(1000);
		getAutoItImagePathFile();
	}
	//Function Summary   : Method to EnterNationalAddressAttmnt
	//Parameter Summary  : N/A
	public void EnterNationalAddressAttmnt() throws Exception {
	   WebClickUsingActions(EdaatOR.Admin_NationalAttmnt_eField);
	   Thread.sleep(1000);
	   getAutoItImagePathFile();
	}
	//Function Summary   : Method to EnterAdminFirstName
	//Parameter Summary  : FirstName
	public void EnterAdminFirstName(String FirstName) {
		WebEdit(EdaatOR.Admin_FirstName_eField,FirstName);
	}
	//Function Summary   : Method to EnterAdminSurName
	//Parameter Summary  : Surname

	public void EnterAdminSurName(String SurName) {
		WebEdit(EdaatOR.Admin_SurName_eField,SurName);
	}
	//Function Summary   : Method to EnterAdminGradFatherName
	//Parameter Summary  : GradFatherName
	public void EnterAdminGradFatherName(String GradFatherName) {
		WebEdit(EdaatOR.Admin_GradFatherName_eField,GradFatherName);
	}
	//Function Summary   : Method to EnterAdminLastName
	//Parameter Summary  : LastName
	public void EnterAdminLastName(String LastName) {
		WebEdit(EdaatOR.Admin_LastName_eField,LastName);
	}
	//Function Summary   : Method to EnterAdminNationalID
	//Parameter Summary  : LastName
	public void EnterAdminNationalID(String NationalID_) {
		WebEdit(EdaatOR.Admin_NationalID_eField,NationalID_);
	}
	//Function Summary   : Method to EnterAdminCommisionIdentyAtt
	//Parameter Summary  : N/A
	public void EnterAdminCommisionIdentyAtt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_CommisionIdentyAttmnt_eField);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}
	//Function Summary   : Method to EnterAdminMemDumAssoAttmnt
	//Parameter Summary  : N/A
	public void EnterAdminMemDumAssoAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_MemDumAssoAttmnt_eField);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}
	//Function Summary   : Method to EnterAdminAuthLterTemltAttmnt
	//Parameter Summary  : AuthLterTemltAttmnt
	public void EnterAdminAuthLterTemltAttmnt(String AuthLterTemltAttmnt) {
		WebEdit(EdaatOR.Admin_AuthLterTemltAttmnt_eField, AuthLterTemltAttmnt);
	}
	//Function Summary   : Method to EnterAdminAuthLterTemltAttmnt
	//Parameter Summary  : N/A
	public void EnterAdminAuthLterTemltAttmnt() {
		//WebClick(EdaatOR.Admin_AuthLterTemltAttmnt_eField);
		WebClickUsingActions(EdaatOR.Admin_AuthLterTemltAttmnt_eField);
	}
	//Function Summary   : Method to EnterAdminCommisionPhNo
	//Parameter Summary  : CommisionPhNo
	public void EnterAdminCommisionPhNo(String CommisionPhNo) {
		WebEdit(EdaatOR.Admin_CommisionPhNo_eField,CommisionPhNo);
	}
	//Function Summary   : Method to EnterAdminCommisionEmail
	//Parameter Summary  : CommisionEmail
	public void EnterAdminCommisionEmail(String CommisionEmail) {
		WebEdit(EdaatOR.Admin_CommisionEmail_eField,CommisionEmail);
	}
	//Function Summary   : Method to EnterAdminUserID
	//Parameter Summary  : UserID
	public void EnterAdminUserID(String UserID) {
		WebEdit(EdaatOR.Admin_UserID_eField,UserID);
	}
	//Function Summary   : EnterAdminPassword
	//Parameter Summary  : Password

	public void EnterAdminPassword(String Password) {
		WebEdit(EdaatOR.Admin_Password_eField,Password);
	}
	//Function Summary   : EnterAdminConfPawd
	//Parameter Summary  : ConfPawd
	public void EnterAdminConfPawd(String ConfPawd) {
		WebEdit(EdaatOR.Admin_ConfPawd_eField,ConfPawd);
	}
	//Function Summary   : ClickOnAdminConfirmation
	//Parameter Summary  : N/A
	public void ClickOnAdminConfirmation() {
		WebClickUsingJS(EdaatOR.Admin_Confirmation_CheckBox);
		
	}
	//Function Summary   : ClickOnAdminCatchBox
	//Parameter Summary  : N/A
	public void ClickOnAdminCatchBox() throws Exception {
		swithchToFrame(EdaatOR.Admin_ReCatchBox_eField);
		WebClickUsingJS(EdaatOR.Admin_CatchBox_eField);
		driver.switchTo().defaultContent();
	}

	//Function Summary   : Method to ClickOnRegisterBtn
	//Parameter Summary  : N/A
	public void ClickOnRegisterBtn() {
		WebClickUsingJS(EdaatOR.Admin_SignUp_btn);
	}

	public void ClickOnCloseBtn() {
		WebClickUsingJS(EdaatOR.Admin_Close_btn);
	}
	//Function Summary   : Method to enterCompanyName
	//Parameter Summary  : CompanyName
	public void enterCompanyName(Map<Object,Object> testdatamap) {
		EnterAdminCompanyName(testdatamap.get("CompanyName").toString());
		
	}
	//Function Summary   : Method to enterEconomySectorDetails
	//Parameter Summary  : EmpySector
	public void enterEconomySectorDetails(Map<Object,Object> testdatamap) {
		SelectAdminEconomySector(testdatamap.get("EmpySector").toString());
		
	}
	//Function Summary   : Method to enterAdminCountyDetails
	//Parameter Summary  : BCounty,BCity,BDistric,Street,BuildNum,ZipCode,AdditionalNum,UnitNum
	public void enterAdminCountyDetails(Map<Object,Object> testdatamap) throws Exception {
		SelectAdminCountry(testdatamap.get("BCounty").toString());
		SelectAdminCity(testdatamap.get("BCity").toString());
		EnterNationalAddressAttmnt();
//		EnterAdminDistrict(testdatamap.get("BDistric").toString());
//		EnterAdminStreet(testdatamap.get("Street").toString());
//		EnterAdminBuildNo(testdatamap.get("BuildNum").toString());
//		EnterAdminPostalCode(testdatamap.get("ZipCode").toString());
//		EnterAdminMailBox(testdatamap.get("AdditionalNum").toString());
//		EnterAdminOfficNo(testdatamap.get("UnitNum").toString());
	}
	//Function Summary   : Method to enterContactInfo
	//Parameter Summary  : EmployeeName,EmployeePosition,EmployeeMobNumber,EmployeeEmailID,ClientSupPhNum
	public void enterContactInfo(Map<Object,Object> testdatamap) {
		EnterAdminEmplyName(testdatamap.get("EmployeeName").toString());
		EnterAdminEmplyJobTitle(testdatamap.get("EmployeePosition").toString());
		EnterAdminEmplyMobileNum(testdatamap.get("EmployeeMobNumber").toString());
		EnterAdminEmplyEmail(testdatamap.get("EmployeeEmailID").toString());
		EnterAdminCustomerSupPhNo(testdatamap.get("ClientSupPhNum").toString());
		
	}

	public String  getPathFile() throws InterruptedException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(1000);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//edaat.jpg");
		Thread.sleep(1000);
		String sFilename = app.toString();
		Thread.sleep(1000);
		return sFilename;
	}

	public void  getAutoItImagePathFile() throws Exception {
		Thread.sleep(1000);
		File classpathRoot = new File(System.getProperty("user.dir"));
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//PdfUpload.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(1000);
	}	
	public String  getAuthPathFile() throws InterruptedException {
		Thread.sleep(1000);
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(1000);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//AuthorizationLetterTemplateAttachment.docx)");
		String sFilename = app.toString();
		Thread.sleep(1000);
		return sFilename;
	}
	//Function Summary   : Method to enterBankDetails
	//Parameter Summary  : IBANNumber,BankAccountType
	public void enterBankDetails(Map<Object,Object> testdatamap) throws Exception {
		EnterAdminIBANum(testdatamap.get("IBANNumber").toString());
		//EnterAdminIBANAttmnt();
		Thread.sleep(2000);
		SelectAdminBankCountry(testdatamap.get("BankAccountType").toString());
		EnterAdminBankCertPath();
		Thread.sleep(2000);
		//verifyElementIsPresent(EdaatOR.Admin_AttachetedImage_Link);
		
	}
	//Function Summary   : Method to enterRegistrationInfo
	//Parameter Summary  : CRNumber,CRIssueDate,CRExpieryDate,IsTaxable,TaxNumber
	public void enterRegistrationInfo(Map<Object,Object> testdatamap) throws Exception {
		SelectAdminCRNumber(testdatamap.get("CRNumber").toString());
		EnterAdminRegiAttachment();
		Thread.sleep(2000);
		EnterAdminRegistDate(testdatamap.get("CRIssueDate").toString());
		Thread.sleep(2000);
		EnterAdminExperyDate(testdatamap.get("CRExpieryDate").toString());
		Thread.sleep(1000);
		String taxable=testdatamap.get("IsTaxable").toString();
		if(taxable.equalsIgnoreCase("Yes")) {
			ClickOnIsTaxableRadBtn();
			EnterAdminTaxno(testdatamap.get("TaxNumber").toString());
		}else {
			ClickOnNoTaxableRadBtn();
		}

		EnterTaxRegisAttmnt();
		Thread.sleep(2000);
		
	}

	//Function Summary   : Method to enterAuthorizedPersonInformation
	//Parameter Summary  : FirstName,Surname,ThirdName,LastName,AuthorizedPersonID,Email,MobileNo
	public void enterAuthorizedPersonInformation(Map<Object,Object> testdatamap) throws Exception {
		EnterAdminFirstName(testdatamap.get("FirstName").toString());
		EnterAdminSurName(testdatamap.get("Surname").toString());
		EnterAdminGradFatherName(testdatamap.get("ThirdName").toString());
		EnterAdminLastName(testdatamap.get("LastName").toString());
		EnterAdminNationalID(testdatamap.get("AuthorizedPersonID").toString());
		EnterAdminCommisionIdentyAtt();
		Thread.sleep(2000);
		EnterAdminMemDumAssoAttmnt();
		Thread.sleep(2000);
		//EnterAdminAuthLterTemltAttmnt(getAuthPathFile());
		EnterAdminAuthLterTemltAttmnt();
		Thread.sleep(1000);
		File classpathRoot = new File(System.getProperty("user.dir")); 
		Thread.sleep(1000);
		File app = new File(classpathRoot.getAbsolutePath() +"//SeleniumGrid//attachment//PdfUpload.exe"); 
		Thread.sleep(1000);
		String sFilename = app.toString(); 
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(1000);
		EnterAdminCommisionPhNo(testdatamap.get("MobileNo").toString());
		EnterAdminCommisionEmail(testdatamap.get("Email").toString());
		
	}
	//Function Summary   : Method to enterLoginInfo
	//Parameter Summary  : UserID,Password,ConPassword
	public void enterLoginInfo(Map<Object,Object> testdatamap) {
		EnterAdminUserID(testdatamap.get("UserID").toString());
		EnterAdminPassword(testdatamap.get("Password").toString());
		EnterAdminConfPawd(testdatamap.get("ConPassword").toString());
		
	}
	//Function Summary   : Method to AdminRegisterWithNewUserID
	//Parameter Summary  : N/A
	public void AdminRegisterWithNewUserID(Map<Object,Object> testdatamap,Log Log) {
		try {
				//ClickOnAdminLogin();			
				ClickOnAdminSignUpBtn();				
				enterCompanyName(testdatamap);
				enterEconomySectorDetails(testdatamap);
				enterAdminCountyDetails(testdatamap);
				enterContactInfo(testdatamap);
				enterBankDetails(testdatamap);
				enterRegistrationInfo(testdatamap);
				enterAuthorizedPersonInformation(testdatamap);
				enterLoginInfo(testdatamap);
				ClickOnAdminConfirmation();
			//	ClickOnAdminCatchBox();
				ClickOnRegisterBtn();
				if (CheckElementExists(EdaatOR.Admin_CompanyName_eField_error) ||
						CheckElementExists(EdaatOR.Admin_EconomySector_List_error) ||
						CheckElementExists(EdaatOR.Admin_City_List_error) ||
						CheckElementExists(EdaatOR.Admin_EmplyName_eField_error) ||
						CheckElementExists(EdaatOR.Admin_EmplyJobTitle_eField_error) ||
						CheckElementExists(EdaatOR.Admin_EmplyMobileNumber_eField_error) ||
						CheckElementExists(EdaatOR.Admin_EmplyEmail_eField_error) ||
						CheckElementExists(EdaatOR.Admin_CustomerSupPhNo_eField_errror) ||
						CheckElementExists(EdaatOR.Admin_IBANum_eField_error) ||
						CheckElementExists(EdaatOR.Admin_BankCountryType_List_error) ||
						CheckElementExists(EdaatOR.Admin_CRNumber_eField_error) ||
						CheckElementExists(EdaatOR.Admin_RegistDate_eField_error) ||
						CheckElementExists(EdaatOR.Admin_ExperyDate_eField_error) ||
						CheckElementExists(EdaatOR.Admin_Taxno_eField_error) ||
						CheckElementExists(EdaatOR.Admin_FirstName_eField_error) ||
						CheckElementExists(EdaatOR.Admin_SurName_eField_error) ||
						CheckElementExists(EdaatOR.Admin_GradFatherName_eField_error) ||
						CheckElementExists(EdaatOR.Admin_LastName_eField_error) ||
						CheckElementExists(EdaatOR.Admin_CommisionPhNo_eField_error) ||
						CheckElementExists(EdaatOR.Admin_CommisionEmail_eField_error)  ||
						CheckElementExists(EdaatOR.Admin_UserID_eField_error) ||
						CheckElementExists(EdaatOR.Admin_Password_eField_error) ||
						CheckElementExists(EdaatOR.Admin_ConfPawd_eField_error) ||
						CheckElementExists(EdaatOR.Admin_NationalID_eField_error)) {
					    Log.ReportEvent("FAIL", "Biller Registration is UnSuccessful");	
					    this.takeScreenShot();
					    driver.quit();
					    Assert.fail();
					
				} else {
					Thread.sleep(5000);
					verifyElementIsPresent(EdaatOR.Admin_RegisterComp_btn);
				    Log.ReportEvent("PASS", "Biller Registration is Successful");	
				}
		}
		catch(Exception e){
			   Log.ReportEvent("FAIL", "Biller Registration is UnSuccessful");	
			    this.takeScreenShot();
			    e.printStackTrace();
			    driver.quit();
			    Assert.fail();			
		}
	}
}




