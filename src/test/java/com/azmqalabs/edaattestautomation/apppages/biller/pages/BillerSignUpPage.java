/**
* Test Script Name                      : N/A
* Objective                             : Verify to New Biller Registration functionality.
* Version                               : 1.0
* Author                                : Kathirvelu M
* Created Date                          : 02/06/2023
* Last Updated on                       : N/A
* Updated By                            : Basavaraj Mudnur.
* Pre-Conditions                        : N/A
* Epic Details                          : N/A
* User Story Details                    : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.google.sitebricks.routing.Action;



public class BillerSignUpPage extends BasePage
{

	public BillerSignUpPage(WebDriver driver,ExtentTest test)
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


	public void ClickOnBillerLogin() {
		WebClickUsingJS(EdaatOR.Biller_Link);
		waitForPageToLoad();
	}


	public void ClickOnBillerSignUpBtn() {
		WebClickUsingJS(EdaatOR.Biller_SignUp_Btn);
		waitForPageToLoad();
	}

//Function Summary   : Method to Enter Company Name in Signup page.
	//Parameter Summary  : CompName.
	public void EnterBillerCompanyName(String CompName) {
		WebEdit(EdaatOR.Biller_CompanyName_eField,CompName);
	}

	//Function Summary   : Method to Select Economy Sector in Signup page.
	//Parameter Summary  : EconomySector.
	public void SelectBillerEconomySector(String EconomySector) {
		WebSelect1(EdaatOR.Biller_EconomySector_List,EconomySector);
	}
	//Function Summary   : Method to Select Biller Country in Signup page.
	//Parameter Summary  : Country.
	public void SelectBillerCountry(String Country) {
		WebSelect1(EdaatOR.Biller_Country_List,Country);
	}
	//Function Summary   : Method to Select Biller City in Signup page .
	//Parameter Summary  : City.
	public void SelectBillerCity(String City) {
		WebSelect1(EdaatOR.Biller_City_List,City);
	}
	public void SelectBillerCity1(String City) {
		WebSelect1(EdaatOR.Biller_City_List,City);
	}
	//Function Summary   : Method to Enter Biller District name in Signup page.
	//Parameter Summary  : District.
	public void EnterBillerDistrict(String District) {
		WebEdit(EdaatOR.Biller_District_eField,District);
	}
	//Function Summary   : Method to Enter Biller Street name in Signup page.
	//Parameter Summary  : Street.
	public void EnterBillerStreet(String Street) {
		WebEdit(EdaatOR.Biller_Street_eField,Street);
	}
	//Function Summary   : Method to Enter Biller BuildingNo in Signup page.
	//Parameter Summary  : BuildNo.
	public void EnterBillerBuildNo(String BuildNo) {
		WebEdit(EdaatOR.Biller_BuildNo_eField,BuildNo);
	}
	//Function Summary   : Method to Enter Biller ZipCode in Signup page.
	//Parameter Summary  : PostalCode.
	public void EnterBillerPostalCode(String PostalCode) {
		WebEdit(EdaatOR.Biller_PostalCode_eField,PostalCode);
	}
	//Function Summary   : Method to Enter Employee Email in Signup page.
	//Parameter Summary  : MailBox.
	public void EnterBillerMailBox(String MailBox) {
		WebEdit(EdaatOR.Biller_MailBox_eField,MailBox);
	}
	//Function Summary   : Method to Enter Biller OfficNo.
	//Parameter Summary  : OfficNo.
	public void EnterBillerOfficNo(String OfficNo) {
		WebEdit(EdaatOR.Biller_OfficNo_eField,OfficNo);
	}
	//Function Summary   : Method to Enter Biller Employee Name in signup page.
	//Parameter Summary  : EmplyName.
	public void EnterBillerEmplyName(String EmplyName) {
		WebEdit(EdaatOR.Biller_EmplyName_eField,EmplyName);
	}
	//Function Summary   : Method to Enter Biller Employee Position in signup page.
	//Parameter Summary  : EmplyJobTitle.
	public void EnterBillerEmplyJobTitle(String EmplyJobTitle) {
		WebEdit(EdaatOR.Biller_EmplyJobTitle_eField,EmplyJobTitle);
	}
	//Function Summary   : Method to Enter Biller Employee Mobile Number in signup page.
	//Parameter Summary  : EmplyMob.
	public void EnterBillerEmplyMobileNum(String EmplyMob) {
		WebEdit(EdaatOR.Biller_EmplyMobileNumber_eField,EmplyMob);
	}
	//Function Summary   : Method to Enter Biller Employee Email in signup page.
	//Parameter Summary  : EmplyEmail.
	public void EnterBillerEmplyEmail(String EmplyEmail) {
		WebEdit(EdaatOR.Biller_EmplyEmail_eField,EmplyEmail);
	}

	//Function Summary   : Method to Enter Biller Client Support Phone Number.
	//Parameter Summary  : CustomerSupPhNo.
	public void EnterBillerCustomerSupPhNo(String CustomerSupPhNo) {
		WebEdit(EdaatOR.Biller_CustomerSupPhNo_eField,CustomerSupPhNo);
	}
	//Function Summary   : Method to Enter Biller IBAN Number.
	//Parameter Summary  :IBANum.
	public void EnterBillerIBANum(String IBANum) {
		WebEdit(EdaatOR.Biller_IBANum_eField,IBANum);
	}
	//Function Summary   : Method to upload Biller IBANImage.
	//Parameter Summary  :N/A.
	public void EnterBillerIBANAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_IBANAttmnt_eField);
		getAutoItImagePathFile();
	}
	//Function Summary   : Method to Select Biller Bank Account Type.
	//Parameter Summary  : BankCountry.

	public void SelectBillerBankCountry(String BankCountry) {
		WebSelect(EdaatOR.Biller_BankCountryType_List,BankCountry);
	}
	//Function Summary   : Method to upload Biller BankCertificate.
    //Parameter Summary  :N/A.
	public void EnterBillerBankCertPath() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_BankCertAttmnt_eField);
		getAutoItImagePathFile();
	}
	//Function Summary   : Method to Select Biller CR Number.
    //Parameter Summary  : CRNumber.
	public void SelectBillerCRNumber(String CRNumber) {
		WebSelect(EdaatOR.Biller_CRNumber_eField,CRNumber);
		//WebEdit(EdaatOR.Biller_CRNumber_eField,CRNumber);
	}
	//Function Summary   : Method to upload Biller Registration Certificate.
    //Parameter Summary  :N/A.

	public void EnterBillerRegiAttachment() throws Exception {
		WebClickUsingJS(EdaatOR.Biller_RegiAttachment_eField);
		getAutoItImagePathFile();
	}
	public void EnterSubBillerName(Map<Object,Object>testdatamap) throws InterruptedException {
		WebEdit(EdaatOR.Biller_SubName,testdatamap.get("SubName").toString());
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_confirmCheckbox);
		Thread.sleep(1000);

}
	//Function Summary   : Method to Enter Biller CR Issue Date.
	//Parameter Summary  : RegistDate.
	public void EnterBillerRegistDate(String RegistDate) throws Exception {
		//WebEdit(EdaatOR.Biller_RegistDate_eField,RegistDate);
		WebClick(EdaatOR.Biller_RegistDate_eField);
		//WebClickUsingJS(EdaatOR.Biller_RegistDate_eField);
		Thread.sleep(800);
		WebClick(EdaatOR.Biller_RegistDate_Issuedate);
	}
	//Function Summary   : Method to Enter Biller CR Expiery Date.
	//Parameter Summary  : ExperyDate.
	public void EnterBillerExperyDate(String ExperyDate) throws InterruptedException {
		//WebEdit(EdaatOR.Biller_ExperyDate_eField,ExperyDate);
		WebClick(EdaatOR.Biller_ExperyDate_eField);
		Thread.sleep(800);
	 WebClickUsingJS(EdaatOR.Biller_RegistDate_exprDate);	}
	//Function Summary   : Method to Enter Biller Tax Numbe.
	//Parameter Summary  : Taxno.

	public void EnterBillerTaxno(String Taxno) {
		WebEdit(EdaatOR.Biller_Taxno_eField,Taxno);
	}
	//Function Summary   : Method to check Taxable Radio button.
	//Parameter Summary  : N/A.
	public void ClickOnIsTaxableRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_IsTaxable_RadBtn);
	}
	//Function Summary   : Method to check Non-Taxable Radio button.
	//Parameter Summary  : N/A.
	public void ClickOnNoTaxableRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_NoTaxable_RadBtn);
	}
	//Function Summary   : Method to upload Biller Tax Registration Certificate.
    //Parameter Summary  :N/A.
	public void EnterTaxRegisAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_TaxRegisAttmnt_eField);
		getAutoItImagePathFile();
	}
	//Function Summary   : Method to Enter Biller FirstName.
	//Parameter Summary  : FirstName.
	public void EnterBillerFirstName(String FirstName) {
		WebEdit(EdaatOR.Biller_FirstName_eField,FirstName);
	}

	//Function Summary   : Method to Enter Biller SecondNmae.
	//Parameter Summary  : SurName.
	public void EnterBillerSurName(String SurName) {
		WebEdit(EdaatOR.Biller_SurName_eField,SurName);
	}
	//Function Summary   : Method to Enter Biller ThirdName.
	//Parameter Summary  : GradFatherName.
	public void EnterBillerGradFatherName(String GradFatherName) {
		WebEdit(EdaatOR.Biller_GradFatherName_eField,GradFatherName);
	}
	//Function Summary   : Method to Enter Biller LastName.
	//Parameter Summary  : LastName.
	public void EnterBillerLastName(String LastName) {
		WebEdit(EdaatOR.Biller_LastName_eField,LastName);
	}
	//Function Summary   : Method to Enter Biller Authorized Person ID.
	//Parameter Summary  : NationalID_.	
	public void EnterBillerNationalID(String NationalID_) {
		WebEdit(EdaatOR.Biller_NationalID_eField,NationalID_);
	}
	//Function Summary   : Method to Enter Biller AuthorizedID attachment.
	//Parameter Summary  : N/A.	
	public void EnterBillerCommisionIdentyAtt() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_CommisionIdentyAttmnt_eField);
		getAutoItImagePathFile();
	}
	//Function Summary   : Method to Enter Biller Association attachment.
	//Parameter Summary  : N/A.	

	public void EnterBillerMemDumAssoAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_MemDumAssoAttmnt_eField);
		getAutoItImagePathFile();
	}
	//Function Summary   : Method to Enter Biller AuthorizedID attachment.
	//Parameter Summary  :AuthLterTemltAttmnt.	
	public void EnterBillerAuthLterTemltAttmnt(String AuthLterTemltAttmnt) {
		WebEdit(EdaatOR.Biller_AuthLterTemltAttmnt_eField, AuthLterTemltAttmnt);
	}
	//Function Summary   : Method to Enter Biller Authorized Letter.
	//Parameter Summary  :AuthLterTemltAttmnt.
	public void EnterBillerAuthLterTemltAttmnt() {
		//WebClick(EdaatOR.Biller_AuthLterTemltAttmnt_eField);
		WebClickUsingActions(EdaatOR.Biller_AuthLterTemltAttmnt_eField);
	}
	//Function Summary   : Method to Enter Biller Mobile Number.
	//Parameter Summary  : CommisionPhNo.	
	public void EnterBillerCommisionPhNo(String CommisionPhNo) {
		WebEdit(EdaatOR.Biller_CommisionPhNo_eField,CommisionPhNo);
	}
	//Function Summary   : Method to Enter Biller Email.
	//Parameter Summary  : CommisionEmail.
	public void EnterBillerCommisionEmail(String CommisionEmail) {
		WebEdit(EdaatOR.Biller_CommisionEmail_eField,CommisionEmail);
	}
	//Function Summary   : Method to Enter Biller User Name.
	//Parameter Summary  : UserID.
	public void EnterBillerUserID(String UserID) {
		WebEdit(EdaatOR.Biller_UserID_eField,UserID);
	}
	//Function Summary   : Method to Enter Biller Password.
	//Parameter Summary  : Password.

	public void EnterBillerPassword(String Password) {
		WebEdit(EdaatOR.Biller_Password_eField,Password);
	}
	//Function Summary   : Method to Enter Biller Conform Password.
	//Parameter Summary  : ConfPawd.
	public void EnterBillerConfPawd(String ConfPawd) {
		WebEdit(EdaatOR.Biller_ConfPawd_eField,ConfPawd);
	}
	 //Function Summary   : Method to Click on Terms and Condition Checkbox.
	//Parameter Summary  : N/A.
	public void ClickOnBillerConfirmation() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Biller_Confirmation_CheckBox);
		takeScreenShot();
		Thread.sleep(2000);
	}

	public void ClickOnBillerCatchBox() throws Exception {
		swithchToFrame(EdaatOR.Biller_ReCatchBox_eField);
		WebClickUsingJS(EdaatOR.Biller_CatchBox_eField);
		driver.switchTo().defaultContent();
	}
	     //Function Summary   : Method to Click on Register Button.
		//Parameter Summary  : N/A.

	public void ClickOnRegisterBtn() {
		WebClick(EdaatOR.Biller_SignUp_btn);
	}
	  //Function Summary   : Method to Click on Close button.
	 //Parameter Summary  : N/A.

	public void ClickOnCloseBtn() {
		WebClickUsingJS(EdaatOR.Biller_Close_btn);
	}
	//Function Summary   : Method to Enter Company Name.
	//Parameter Summary  : CompanyName.
	public void enterCompanyName(Map<Object,Object> testdatamap) throws InterruptedException {
		EnterBillerCompanyName(testdatamap.get("CompanyName").toString());
		takeScreenShot();
		Thread.sleep(1000);
	}
	//Function Summary   : Method to Enter EconomySector Details.
	//Parameter Summary  : EmpySector.
	public void enterEconomySectorDetails(Map<Object,Object> testdatamap) throws InterruptedException {
		SelectBillerEconomySector(testdatamap.get("EmpySector").toString());
		Thread.sleep(2000);
		takeScreenShot();
	}
//Function Summary   : Method to EnterNationalAddressAttmnt
		//Parameter Summary  : N/A
		public void EnterNationalAddressAttmnt() throws Exception {
		   WebClickUsingActions(EdaatOR.Biller_NationalAttmnt_eField);
		   Thread.sleep(1000);
		   getAutoItImagePathFile();
		}
	    //Function Summary   : Method to Enter BillerCounty Details.
		//Parameter Summary  : BCounty,BCity,BDistric,Street,BuildNum,ZipCode,AdditionalNum,UnitNum.
	public void enterBillerCountyDetails(Map<Object,Object> testdatamap) throws Exception {
		SelectBillerCountry(testdatamap.get("BCounty").toString());
		SelectBillerCity(testdatamap.get("BCity").toString());
			EnterNationalAddressAttmnt();
	//		EnterBillerDistrict(testdatamap.get("BDistric").toString());
//		EnterBillerStreet(testdatamap.get("Street").toString());
//		EnterBillerBuildNo(testdatamap.get("BuildNum").toString());
//		EnterBillerPostalCode(testdatamap.get("ZipCode").toString());
//		EnterBillerMailBox(testdatamap.get("AdditionalNum").toString());
//		EnterBillerOfficNo(testdatamap.get("UnitNum").toString());
		Thread.sleep(2000);
	}
	 //Function Summary   : Method to Enter ContactInfo Details.
	  //Parameter Summary  : EmployeeName,EmployeePosition,EmployeeMobNumber.

	public void enterContactInfo(Map<Object,Object> testdatamap) throws InterruptedException {
		EnterBillerEmplyName(testdatamap.get("EmployeeName").toString());
		EnterBillerEmplyJobTitle(testdatamap.get("EmployeePosition").toString());
		EnterBillerEmplyMobileNum(testdatamap.get("EmployeeMobNumber").toString());
		EnterBillerEmplyEmail(testdatamap.get("EmployeeEmailID").toString());
		EnterBillerCustomerSupPhNo(testdatamap.get("ClientSupPhNum").toString());
		Thread.sleep(1000);
		takeScreenShot();
	}

	public String  getPathFile() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//edaat.jpg");
		String sFilename = app.toString();
		return sFilename;
	}

	public void  getAutoItImagePathFile() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//PdfUpload.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(800);
	}


	public String  getAuthPathFile() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//AuthorizationLetterTemplateAttachment.docx)");
		String sFilename = app.toString();
		return sFilename;
	}
	  //Function Summary   : Method to enterBank Details.
	  //Parameter Summary  : IBANNumber,BankAccountType.

	public void enterBankDetails(Map<Object,Object> testdatamap) throws Exception {
		EnterBillerIBANum(testdatamap.get("IBANNumber").toString());
		EnterBillerIBANAttmnt();
		Thread.sleep(2000);
		SelectBillerBankCountry(testdatamap.get("BankAccountType").toString());
		EnterBillerBankCertPath();
		Thread.sleep(2000);
		//verifyElementIsPresent(EdaatOR.Biller_AttachetedImage_Link);
		takeScreenShot();
	}
	 //Function Summary   : Method to Enter RegistrationInfo Details.
	 //Parameter Summary  : CRNumber,CRIssueDate,CRExpieryDate,IsTaxable,TaxNumber.

	public void enterRegistrationInfo(Map<Object,Object> testdatamap) throws Exception {
		SelectBillerCRNumber(testdatamap.get("CRNumber").toString());
		EnterBillerRegiAttachment();
		Thread.sleep(2000);
		EnterSubBillerName(testdatamap);
		Thread.sleep(2000);
		EnterBillerRegistDate(testdatamap.get("CRIssueDate").toString());
		Thread.sleep(2000);
		EnterBillerExperyDate(testdatamap.get("CRExpieryDate").toString());
		Thread.sleep(1000);
		String taxable=testdatamap.get("IsTaxable").toString();
		if(taxable.equalsIgnoreCase("Yes")) {
			ClickOnIsTaxableRadBtn();
			Thread.sleep(1000);
			EnterBillerTaxno(testdatamap.get("TaxNumber").toString());
		}else {
			ClickOnNoTaxableRadBtn();
		}

		EnterTaxRegisAttmnt();
		Thread.sleep(2000);
		takeScreenShot();
	}
	public void enterRegistrationInfoerror(Map<Object,Object> testdatamap) throws Exception {SelectBillerCRNumber(testdatamap.get("CRNumber").toString());
	EnterBillerRegiAttachment();
	Thread.sleep(2000);
	String Samecr = testdatamap.get("CRNumber").toString();
	if( Samecr.equalsIgnoreCase("1111111111"))
	{	
	EnterSubBillerName(testdatamap);
	Thread.sleep(2000);
	}

	EnterBillerRegistDate(testdatamap.get("CRIssueDate").toString());
	Thread.sleep(2000);
	EnterBillerExperyDate(testdatamap.get("CRExpieryDate").toString());
	Thread.sleep(1000);
	String taxable=testdatamap.get("IsTaxable").toString();
	if(taxable.equalsIgnoreCase("Yes")) {
		ClickOnIsTaxableRadBtn();
		Thread.sleep(1000);
		EnterBillerTaxno(testdatamap.get("TaxNumber").toString());
	}else {
		ClickOnNoTaxableRadBtn();
	}

	EnterTaxRegisAttmnt();
	Thread.sleep(2000);
	takeScreenShot();
}
	     //Function Summary   : Method to Enter Authorized Person Information Details.
		 //Parameter Summary  : FirstName,Surname,ThirdName,LastName,AuthorizedPersonID,MobileNo,Email.

	public void enterAuthorizedPersonInformation(Map<Object,Object> testdatamap) throws Exception {
		EnterBillerFirstName(testdatamap.get("FirstName").toString());
		EnterBillerSurName(testdatamap.get("Surname").toString());
		EnterBillerGradFatherName(testdatamap.get("ThirdName").toString());
		EnterBillerLastName(testdatamap.get("LastName").toString());
		EnterBillerNationalID(testdatamap.get("AuthorizedPersonID").toString());
		EnterBillerCommisionIdentyAtt();
		Thread.sleep(2000);
		EnterBillerMemDumAssoAttmnt();
		Thread.sleep(2000);
		//EnterBillerAuthLterTemltAttmnt(getAuthPathFile());
		EnterBillerAuthLterTemltAttmnt();
		Thread.sleep(2000);
		File classpathRoot = new File(System.getProperty("user.dir")); 
		File app = new File(classpathRoot.getAbsolutePath() +"//SeleniumGrid//attachment//PdfUpload.exe"); 
		String sFilename = app.toString(); 
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(2000);
		EnterBillerCommisionPhNo(testdatamap.get("MobileNo").toString());
		EnterBillerCommisionEmail(testdatamap.get("Email").toString());
		Thread.sleep(1000);
		takeScreenShot();
	}
	    //Function Summary   : Method to Enter LoginInfo Details. 
		//Parameter Summary  : UserID,Password,ConPassword.

	public void enterLoginInfo(Map<Object,Object> testdatamap) {
		EnterBillerUserID(testdatamap.get("UserID").toString());
		EnterBillerPassword(testdatamap.get("Password").toString());
		EnterBillerConfPawd(testdatamap.get("ConPassword").toString());
		takeScreenShot();
	}
	//Function Summary   : Method to Register new Biller.
	//Parameter Summary  : SignUpDate.
	public void BillerRegisterWithNewUserID(Map<Object,Object> testdatamap,Log Log) {
		try {
			//ClickOnBillerLogin();
			if(testdatamap.get("SignUpDate").toString().equalsIgnoreCase("valid")) {
				ClickOnBillerSignUpBtn();
				
				enterCompanyName(testdatamap);
				enterEconomySectorDetails(testdatamap);
				enterBillerCountyDetails(testdatamap);
				enterContactInfo(testdatamap);
				enterBankDetails(testdatamap);
				enterRegistrationInfo(testdatamap);
				enterAuthorizedPersonInformation(testdatamap);
				enterLoginInfo(testdatamap);
				ClickOnBillerConfirmation();
			//	ClickOnBillerCatchBox();
				ClickOnRegisterBtn();	
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Biller_RegisterComp_btn);
	//verifyElementIsPresent(EdaatOR.Biller_RegisterComp_btn);
				test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
				takeScreenShot();
	        	Log.ReportEvent("PASS", " Verify User Able to Register or Sign Up Successfully");

			}
			else if(testdatamap.get("SignUpDate").toString().equalsIgnoreCase("Invalid")) {
				ClickOnBillerSignUpBtn();
				enterCompanyName(testdatamap);
				enterEconomySectorDetails(testdatamap);
				enterBillerCountyDetails(testdatamap);
				enterContactInfo(testdatamap);
				enterBankDetails(testdatamap);
				enterRegistrationInfo(testdatamap);
				enterAuthorizedPersonInformation(testdatamap);
				enterLoginInfo(testdatamap);
				ClickOnBillerConfirmation();
			//	ClickOnBillerCatchBox();
				ClickOnRegisterBtn();	
				Thread.sleep(2000);
				String ActuvalValue = getText(EdaatOR.Biller_confirmpassoword);
				VerifyValue1(ActuvalValue,testdatamap.get("ConfirmPasswordmsg").toString() );
			//	verifyElementIsPresent(EdaatOR.Biller_RegisterComp_btn);
				test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
				takeScreenShot();
			}
			else {
				test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
			}
			this.takeScreenShot();
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
		}
	}


	public void BillerRegisterNotBooked(Map<Object,Object> testdatamap) {
		try {
			//ClickOnBillerLogin();
			if(testdatamap.get("SignUpDate").toString().equalsIgnoreCase("Invalid")) {
				ClickOnBillerSignUpBtn();
				enterCompanyName(testdatamap);
				enterEconomySectorDetails(testdatamap);
				enterBillerCountyDetails(testdatamap);
				enterContactInfo(testdatamap);
				enterBankDetails(testdatamap);
				enterRegistrationInfo(testdatamap);
				enterLoginInfo(testdatamap);
				ClickOnBillerConfirmation();
				ClickOnBillerCatchBox();
				ClickOnRegisterBtn();	
				verifyElementIsNotPresent(EdaatOR.Biller_RegisterComp_btn);;
				test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
			}
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to Register new Biller.
	//Parameter Summary  : SignUpDate.
	public void BillerRegisterWithNewUserIDErrorMessage(Map<Object,Object> testdatamap) {
		try {
			//ClickOnBillerLogin();
			if(testdatamap.get("SignUpDate").toString().equalsIgnoreCase("valid")) {
				ClickOnBillerSignUpBtn();
				
				enterCompanyName(testdatamap);
				enterEconomySectorDetails(testdatamap);
				enterBillerCountyDetails(testdatamap);
				enterContactInfo(testdatamap);
				enterBankDetails(testdatamap);
				enterRegistrationInfoerror(testdatamap);
				enterAuthorizedPersonInformation(testdatamap);
				enterLoginInfo(testdatamap);
				ClickOnBillerConfirmation();
			//	ClickOnBillerCatchBox();
				ClickOnRegisterBtn();	
				Thread.sleep(2000);
			//	verifyElementIsPresent(EdaatOR.Biller_RegisterComp_btn);
	//verifyElementIsPresent(EdaatOR.Biller_RegisterComp_btn);
				test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
				takeScreenShot();
			}
			else if(testdatamap.get("SignUpDate").toString().equalsIgnoreCase("Invalid")) {
				ClickOnBillerSignUpBtn();
				enterCompanyName(testdatamap);
				enterEconomySectorDetails(testdatamap);
				enterBillerCountyDetails(testdatamap);
				enterContactInfo(testdatamap);
				enterBankDetails(testdatamap);
				enterRegistrationInfo(testdatamap);
				enterAuthorizedPersonInformation(testdatamap);
				enterLoginInfo(testdatamap);
				ClickOnBillerConfirmation();
			//	ClickOnBillerCatchBox();
				ClickOnRegisterBtn();	
				Thread.sleep(2000);
				String ActuvalValue = getText(EdaatOR.Biller_confirmpassoword);
				VerifyValue1(ActuvalValue,testdatamap.get("ConfirmPasswordmsg").toString() );
				test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
				takeScreenShot();
			}
			else {
				test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
			}
			this.takeScreenShot();
		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
		}
	}

	//Function Summary   : Method to Verify Biller registration page  fields validation.
	//Parameter Summary  : ExpectedResult.

	public void BillerRegistrationErrormessageValidation(Map<Object, Object> testdatamap) {
		BillerRegisterWithNewUserIDErrorMessage(testdatamap);
		this.takeScreenShot();
		String Expected=testdatamap.get("ExpectedResult").toString();
		try {
			if (ExistsCheck(EdaatOR.RegistrationPage_CorporateNameError)&& ExistsCheck(EdaatOR.RegistrationPage_CityError) && ExistsCheck(EdaatOR.RegistrationPage_DistrictNameError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_CorporateNameError);
				VerifyValue(Expected,EdaatOR.RegistrationPage_CityError);
				VerifyValue(Expected,EdaatOR.RegistrationPage_DistrictNameError);				

				test.log(Status.PASS, "#FUNC-CorporateName,City and District  ErrorMessage Exists" + driver.getTitle() + " * CorporateName,City and District ErrorMessage Exists * ");
			}
			
			else if (ExistsCheck(EdaatOR.RegistrationPage_StreetError) && ExistsCheck(EdaatOR.RegistrationPage_BuildingNoError) && ExistsCheck(EdaatOR.RegistrationPage_ZipCodeError) && ExistsCheck(EdaatOR.RegistrationPage_AdditionalNumberError) && ExistsCheck(EdaatOR.RegistrationPage_UnitNumberError)){	
				VerifyValue(Expected,EdaatOR.RegistrationPage_StreetError);				
				test.log(Status.PASS, "#FUNC-Street,BuildingNo,ZipCode,AdditionalNumber and UnitNumber  ErrorMessage Exists" + driver.getTitle() + " *Street,BuildingNo,ZipCode,AdditionalNumber and UnitNumber  ErrorMessage Exists * ");
			}
	
			
			else if (ExistsCheck(EdaatOR.RegistrationPage_EmployeeNameError) && ExistsCheck(EdaatOR.RegistrationPage_EmployeePositionError) && ExistsCheck(EdaatOR.RegistrationPage_EmployeeMobileNumberError) && ExistsCheck(EdaatOR.RegistrationPage_EmployeeEmailError) && ExistsCheck(EdaatOR.RegistrationPage_ClientSupportPhoneNumberError) ){	
				VerifyValue(Expected,EdaatOR.RegistrationPage_EmployeeNameError);
				VerifyValue(Expected,EdaatOR.RegistrationPage_EmployeeMobileNumberError);	
				VerifyValue(Expected,EdaatOR.RegistrationPage_EmployeeEmailError);	
				VerifyValue(Expected,EdaatOR.RegistrationPage_ClientSupportPhoneNumberError);				
				VerifyValue(Expected,EdaatOR.RegistrationPage_EmployeePositionError);				
				test.log(Status.PASS, "#FUNC-EmployeeName,EmployeePosition,EmployeeMobileNumber,EmployeeEmail and ClientSupportPhoneNumber ErrorMessage Exists" + driver.getTitle() + " *EmployeeName,EmployeePosition,EmployeeMobileNumber,EmployeeEmail and ClientSupportPhoneNumber ErrorMessage Exists * ");
			}
		
			else if (ExistsCheck(EdaatOR.RegistrationPage_IBANNumberError)&& ExistsCheck(EdaatOR.RegistrationPage_BankAccountTypeError)){	
				VerifyValue(Expected,EdaatOR.RegistrationPage_IBANNumberError);
				VerifyValue(Expected,EdaatOR.RegistrationPage_BankAccountTypeError);				

				test.log(Status.PASS, "#FUNC-IBANNumber and BankAccountType ErrorMessage Exists" + driver.getTitle() + " *IBANNumber and BankAccountType ErrorMessage Exists * ");
			}
			
			else if (ExistsCheck(EdaatOR.RegistrationPage_CRNumberError) && ExistsCheck(EdaatOR.RegistrationPage_TaxNumberError) ){	
				VerifyValue(Expected,EdaatOR.RegistrationPage_CRNumberError);				
				VerifyValue(Expected,EdaatOR.RegistrationPage_TaxNumberError);				
		

				test.log(Status.PASS, "#FUNC-CRNumber and TaxNumber ErrorMessage Exists" + driver.getTitle() + " *CRNumber and TaxNumber ErrorMessage Exists * ");
			}
						
			else if (ExistsCheck(EdaatOR.RegistrationPage_AuthorizedPersonFirstNameError) && ExistsCheck(EdaatOR.RegistrationPage_AuthorizedPersonSecondNameError) && ExistsCheck(EdaatOR.RegistrationPage_AuthorizedPersonThirdNameError) && ExistsCheck(EdaatOR.RegistrationPage_AuthorizedPersonLastNameError) && ExistsCheck(EdaatOR.RegistrationPage_AuthorizedPersonIDError)  ){	
				VerifyValue(Expected,EdaatOR.RegistrationPage_AuthorizedPersonFirstNameError);				
				VerifyValue(Expected,EdaatOR.RegistrationPage_AuthorizedPersonSecondNameError);				
				VerifyValue(Expected,EdaatOR.RegistrationPage_AuthorizedPersonThirdNameError);				
				VerifyValue(Expected,EdaatOR.RegistrationPage_AuthorizedPersonLastNameError);				
				VerifyValue(Expected,EdaatOR.RegistrationPage_AuthorizedPersonIDError);				

				test.log(Status.PASS, "#FUNC-AuthorizedPersonName and AuthorizedPersonID ErrorMessage Exists" + driver.getTitle() + " *AuthorizedPersonName and AuthorizedPersonID ErrorMessage Exists * ");
			}
							
			else if (ExistsCheck(EdaatOR.RegistrationPage_MobileNoError) && ExistsCheck(EdaatOR.RegistrationPage_EmailError) && ExistsCheck(EdaatOR.RegistrationPage_UserNameError) && ExistsCheck(EdaatOR.RegistrationPage_PasswordError) && ExistsCheck(EdaatOR.RegistrationPage_ConfirmPasswordError)  ){	
				VerifyValue(Expected,EdaatOR.RegistrationPage_MobileNoError);				
				VerifyValue(Expected,EdaatOR.RegistrationPage_EmailError);				
				VerifyValue(Expected,EdaatOR.RegistrationPage_UserNameError);				
				VerifyValue(Expected,EdaatOR.RegistrationPage_PasswordError);				
				VerifyValue(Expected,EdaatOR.RegistrationPage_ConfirmPasswordError);				

				test.log(Status.PASS, "#FUNC-MobileNo,Email,UserName,Password and ConfirmPassword ErrorMessage Exists" + driver.getTitle() + " *MobileNo,Email,UserName,Password and ConfirmPassword ErrorMessage Exists * ");
			}
			else if(ExistsCheck(EdaatOR.RegistrationPage_CorporateNameInvalidError)&& ExistsCheck(EdaatOR.RegistrationPage_DistrictNameInvalidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_CorporateNameInvalidError);
				VerifyValue(Expected,EdaatOR.RegistrationPage_DistrictNameInvalidError);
				test.log(Status.PASS, "#FUNC-CorporateName and District invalid data ErrorMessage Exists" + driver.getTitle() + " *CorporateName and District invalid data ErrorMessage Exists * ");
			}
			else if(ExistsCheck(EdaatOR.RegistrationPage_StreetInvaidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_StreetInvaidError);
				test.log(Status.PASS, "#FUNC-Street invalid data ErrorMessage Exists" + driver.getTitle() + " *Street invalid data ErrorMessage Exists * ");
			}
			else if(ExistsCheck(EdaatOR.RegistrationPage_EmployeeNameInvaidError) && ExistsCheck(EdaatOR.RegistrationPage_EmployeePositionInvaidError)) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_StreetInvaidError);
				VerifyValue(Expected,EdaatOR.RegistrationPage_EmployeePositionInvaidError);
				test.log(Status.PASS, "#FUNC-EmployeeName and EmployeePosition invalid data ErrorMessage Exists" + driver.getTitle() + " *EmployeeName and EmployeePosition invalid data ErrorMessage Exists * ");
			}
			else if(ExistsCheck(EdaatOR.RegistrationPage_EmployeeMobileNumberInvaidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_EmployeeMobileNumberInvaidError);
				test.log(Status.PASS, "#FUNC-EmployeeMobileNumber invalid data ErrorMessage Exists" + driver.getTitle() + " *EmployeeMobileNumber invalid data ErrorMessage Exists * ");
			}
			else if(ExistsCheck(EdaatOR.RegistrationPage_EmployeeEmailInvaidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_EmployeeEmailInvaidError);
				test.log(Status.PASS, "#FUNC-EmployeeEmail invalid data ErrorMessage Exists" + driver.getTitle() + " *EmployeeEmail invalid data ErrorMessage Exists * ");
			}
			else if(ExistsCheck(EdaatOR.RegistrationPage_ClientSupportPhoneNumberInvalidError) ) {
					VerifyValue(Expected,EdaatOR.RegistrationPage_ClientSupportPhoneNumberInvalidError);
					test.log(Status.PASS, "#FUNC-ClientSupportPhoneNumber invalid data ErrorMessage Exists" + driver.getTitle() + " *ClientSupportPhoneNumber invalid data ErrorMessage Exists * ");
				}
			else if(ExistsCheck(EdaatOR.RegistrationPage_IBANNumberInvalidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_IBANNumberInvalidError);
				test.log(Status.PASS, "#FUNC-IBANNumber invalid data ErrorMessage Exists" + driver.getTitle() + " *IBANNumber invalid data ErrorMessage Exists * ");
			}	
			else if(ExistsCheck(EdaatOR.RegistrationPage_CRNumberInvalidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_CRNumberInvalidError);
				test.log(Status.PASS, "#FUNC-CRNumber  invalid data ErrorMessage Exists" + driver.getTitle() + " *CRNumber invalid data ErrorMessage Exists * ");
			}
			else if(ExistsCheck(EdaatOR.RegistrationPage_TaxNumberInvalidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_TaxNumberInvalidError);
				test.log(Status.PASS, "#FUNC-TaxNumber  invalid data ErrorMessage Exists" + driver.getTitle() + " *TaxNumber invalid data ErrorMessage Exists * ");
			}
			else if(ExistsCheck(EdaatOR.RegistrationPage_AuthorizedPersonFirstNameInvalidError) && ExistsCheck(EdaatOR.RegistrationPage_AuthorizedPersonSecondNameInvalidError) && ExistsCheck(EdaatOR.RegistrationPage_AuthorizedPersonThirdNameInvalidError) && ExistsCheck(EdaatOR.RegistrationPage_AuthorizedPersonLastNameInvalidError)) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_AuthorizedPersonFirstNameInvalidError);
				VerifyValue(Expected,EdaatOR.RegistrationPage_AuthorizedPersonSecondNameInvalidError);
				VerifyValue(Expected,EdaatOR.RegistrationPage_AuthorizedPersonThirdNameInvalidError);
				VerifyValue(Expected,EdaatOR.RegistrationPage_AuthorizedPersonLastNameInvalidError);
				test.log(Status.PASS, "#FUNC-AuthorizedPersonName  invalid data ErrorMessage Exists" + driver.getTitle() + " *AuthorizedPersonName invalid data ErrorMessage Exists * ");
			}
			else if(ExistsCheck(EdaatOR.RegistrationPage_MobileNoInvalidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_MobileNoInvalidError);
				test.log(Status.PASS, "#FUNC-MobileNo  invalid data ErrorMessage Exists" + driver.getTitle() + " *MobileNo invalid data ErrorMessage Exists * ");
			}
			
			else if(ExistsCheck(EdaatOR.RegistrationPage_EmailInvalidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_EmailInvalidError);
				test.log(Status.PASS, "#FUNC-Email  invalid data ErrorMessage Exists" + driver.getTitle() + " *Email invalid data ErrorMessage Exists * ");
			}
			
			else if(ExistsCheck(EdaatOR.RegistrationPage_UserNameInvalidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_UserNameInvalidError);
				test.log(Status.PASS, "#FUNC-UserName  invalid data ErrorMessage Exists" + driver.getTitle() + " *UserName invalid data ErrorMessage Exists * ");
			}
			
			else if(ExistsCheck(EdaatOR.RegistrationPage_PasswordInvalidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_PasswordInvalidError);
				test.log(Status.PASS, "#FUNC-Password  invalid data ErrorMessage Exists" + driver.getTitle() + " *Password invalid data ErrorMessage Exists * ");
			}
			
			else if(ExistsCheck(EdaatOR.RegistrationPage_ConfirmPasswordInvalidError) ) {
				VerifyValue(Expected,EdaatOR.RegistrationPage_ConfirmPasswordInvalidError);
				test.log(Status.PASS, "#FUNC-ConfirmPassword  invalid data ErrorMessage Exists" + driver.getTitle() + " *ConfirmPassword invalid data ErrorMessage Exists * ");
			}
			else {
				test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
			}
		} catch (Exception e) {
			throw new NoSuchElementException("Biller Home Page - Not Loaded");

		}
		
	}

}




