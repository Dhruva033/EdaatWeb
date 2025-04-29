/**
 *
 * Test Script Name                   : N/A
 * Objective                          : Individual Client functionality
 * Version                            : 1.0
 * Author                             : Kathirvelu M
 * Created Date                       : 23/05/2023
 * Last Updated on                    : N/A
 * Updated By                         : Kalpana I R
 * Pre-Conditions                     : N/A
 * Epic Details                       : N/A
 * User Story Details                 : N/A
 **/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.azmqalabs.edaattestautomation.common.Log;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminIndividualClientPage extends BasePage
{

	public AdminIndividualClientPage(WebDriver driver,ExtentTest test)
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

	//Function Summary  : To add individual client
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno.
	public void AddIndividualclient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,Log Log){
		try{
			Addclient(FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno);
			boolean Ele=AdminSearchIndividualclient(NationalID);
			if(Ele==true) {
				
		   test.log(Status.PASS,"Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
			Log.ReportEvent("PASS", " Verify Add Individual Client is Suceessful");
			}
			else
				test.log(Status.FAIL,"Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
		}catch(Exception e){
			test.log(Status.FAIL,"Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary  : Navigate to individual client, search client and view client
	//Parameter Summary : ClientName
	public void TableGridview(String ClientName,Log Log){
		try{Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			Thread.sleep(1000);	    
			if(CheckElementExists(EdaatOR.Admin_Invoice_table)==true) {
				Thread.sleep(2000);
				WebClear(EdaatOR.Admin_Individualclient_SearchByname);
				WebEdit(EdaatOR.Admin_Individualclient_SearchByname,ClientName);        			
				WebClick(EdaatOR.Admin_Individualclient_Search);
				Thread.sleep(2000);
				WebClick("//span[contains(text(),'"+ClientName+"')]");
				//WebClick(EdaatOR.Admin_Corpclient_SearchName);
				Thread.sleep(1000);
				switchTonextwindow();
				scrollDowntillend(driver);
				this.takeScreenShot();
				WebClick(EdaatOR.Admin_Individualclient_Back);
				test.log(Status.PASS,"Individual Client Table Exists" + driver.getTitle() +" * Individual Client Table Exists PASS * " );
				Log.ReportEvent("PASS", " Verify Table view Individual Client is Suceessfull");

			}
			else {
				test.log(Status.FAIL,"Individual Client Table Not Exists" + driver.getTitle() +" * Individual Client Table Not Exists FAIL * " );
			}
		}catch(Exception e){
			test.log(Status.FAIL,"Table View Individual client" + driver.getTitle() +" * Table View Individual client FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to to check "Export to excel" is clickable.  
	//Parameter Summary : N/A.
	public void Export(Log Log){
		try{
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			Thread.sleep(1000);	
			if(CheckElementClickable(EdaatOR.Admin_Individualclient_export)==true) {
				WebClick(EdaatOR.Admin_Individualclient_export);
				Thread.sleep(2000);    			
				test.log(Status.PASS,"Export Individual client Done" + driver.getTitle() +" * Export Individual client Done PASS * " );
	        	Log.ReportEvent("PASS", " Verify Individual Client Export to excel is Suceessfull");

			}
			else {
				test.log(Status.FAIL,"Export Individual client Not Done" + driver.getTitle() +" * Export Individual client Not Done FAIL  * " );
			}
		}catch(Exception e){
			test.log(Status.FAIL," Export Individual client Not Done " + driver.getTitle() +" * Export Individual client Not Done FAIL * " );
			this.takeScreenShot();
		}
	}	

	//Function Summary   : Method to search individual client then activate and deactivate the client. 
	//Parameter Summary : ClientName
	public void ActivateDeactivate(Map<Object, Object>testdatamap,Log Log){
		try{
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
			Thread.sleep(1000);	
			if(CheckElementExists(EdaatOR.Biller_Individualclient_SearchByname)==true) {
			WebEdit(EdaatOR.Biller_Individualclient_SearchByNationalID, testdatamap.get("NationalID").toString());        			
				WebClick(EdaatOR.Biller_Individualclient_SearchBtn);
				Thread.sleep(2000);
//				while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
//					WebClick(EdaatOR.Admin_Invoice_NextPrevLink);}
					Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Admin_Company_Togglebtn);
				WebClickUsingJS(EdaatOR.Admin_Company_Togglebtn);
				Thread.sleep(500);
				takeScreenShot();
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				this.takeScreenShot();
				Thread.sleep(2000);
				takeScreenShot();
				WebClickUsingJS(EdaatOR.Admin_Company_Togglebtn);
				takeScreenShot();			
				//WebClickUsingJS(ErrorFontColorPrefix);
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("InActive").toString());
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				this.takeScreenShot();
				test.log(Status.PASS,"Individual Client Deactivate/Activate Done" + driver.getTitle() +" * Individual Client Deactivate/Activate Done PASS * " );
	        	Log.ReportEvent("PASS", " Verify Activate Deactivate Individual Client is Suceessful");

			}
			else {
				test.log(Status.FAIL,"Individual Client Deactivate/Activate Not Done" + driver.getTitle() +" * Individual Client Deactivate/Activate Not Done FAIL  * " );
			}
		}catch(Exception e){
			test.log(Status.FAIL," Individual Client Deactivate/Activate Not Done " + driver.getTitle() +" * Individual Client Deactivate/Activate Not Done FAIL * " );
			this.takeScreenShot();
		}
	}	
	//Function Summary  : To click on Individual Client Lists and download ID image
	//Parameter Summary : NationalID
	public void Download(Map<Object,Object> testdatamap, Log Log){
		try{
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			Thread.sleep(1000);
			boolean Ele=AdminSearchIndividualclient(testdatamap.get("NationalID").toString());
			if(Ele==true) {
				test.log(Status.PASS,"Download ID " + driver.getTitle() +" * Download ID PASS * " );
				
				WebClickUsingJS(EdaatOR.Admin_InvoiceName);
				switchTonextwindow();
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_Imgdownload);
				Log.ReportEvent("PASS", " Verify Download ID is Suceessfull");

			}else
				test.log(Status.FAIL,"Download ID" + driver.getTitle() +" * Download ID FAIL * " );
		}catch(Exception e){
			test.log(Status.FAIL,"Download ID" + driver.getTitle() +" * Download ID FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary  : To search individual client using national id
	//Parameter Summary : Enter NationalID	
	public boolean AdminSearchIndividualclient(String NationalID){
		boolean existsElement = false;
		try{Thread.sleep(2000);	 
		    WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_Individualclient_IdNumber,NationalID);
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(6000);
			if(CheckElementExists("//td[text()='"+NationalID+"']")==true) {
				existsElement=true;
			}
			this.takeScreenShot();	    	

		}catch(Exception e){
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsElement;
	}

	//Function Summary   : Method to search individual client and verify client is displayed.  
	//Parameter Summary : Client name, National ID and Refno.
	public boolean AdminSearchIndividualclientall(String ClientName,String NationalID,String Refno,Log Log){
		boolean existsElement = false;
		try{
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			Thread.sleep(2000);
			/*WebEdit(EdaatOR.Admin_Individualclient_Name,ClientName);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_IdNumber,NationalID);
			WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
			Thread.sleep(1000);*/
			WebEdit(EdaatOR.Admin_Individualclient_Name,ClientName);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_IdNumber,NationalID);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,Refno);
			Thread.sleep(1000);
			scrollDowntillend(driver);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			scrollDowntillend(driver);
			existsElement=ExistsCheck("//td[text()='"+NationalID+"']");
			Thread.sleep(1000);
			test.log(Status.PASS, "Searched Individual Client is successful"+NationalID);
        	Log.ReportEvent("PASS", " Verify Search Individual Client  Is Suceessful");
			this.takeScreenShot();

		}catch(Exception e){
			//       test.log(Status.FAIL,"Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
			this.takeScreenShot();
		}
		return existsElement;
	}

	//Function Summary  : method to add client details
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno.
	public void Addclient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno){
		try{
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient_Button);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_fname,FullName);
			WebEdit(EdaatOR.Admin_Individualclient_sname,SecondName);
			WebEdit(EdaatOR.Admin_Individualclient_tname,ThirdName);
			WebEdit(EdaatOR.Admin_Individualclient_lname,LastName);
			WebEdit(EdaatOR.Admin_Individualclient_IdNumber,NationalID);
			WebClick(EdaatOR.Admin_Individualclient_DateOfBirth);
			this.takeScreenShot();
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfYear, Year);
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfMonth, Month);
			WebClick("//a[text()='"+Date+"']");
			WebEdit(EdaatOR.Admin_Individualclient_Email,Email);
			WebEdit(EdaatOR.Admin_Individualclient_Refno,Refno);
			Thread.sleep(1000);            	
			WebEdit(EdaatOR.Admin_Individualclient_MobileNo,MobileNo);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Add);
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
			this.takeScreenShot();
		}
	}
	//Function Summary   : method to DeleteIndividualClient
	//Parameter Summary  : NationalID,ResonforDelete
	public void DeleteIndividualClient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ResonforDelete,Log Log){
		try{
			Addclient(FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno);
			AdminSearchIndividualclient(NationalID);
			boolean Ele=DeleteIndClient(NationalID,ResonforDelete);
			if(Ele==true) {
				test.log(Status.PASS,"Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
			 Log.ReportEvent("PASS", " Verify Individual Client Delete is Suceessful");
			}
			else
				test.log(Status.FAIL,"Delete Individual client" + driver.getTitle() +" * Delete Individual client FAIL * " );
		}catch(Exception e){
			test.log(Status.FAIL,"Delete Individual client" + driver.getTitle() +" * Delete Individual client FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : method to  DeleteIndClient
	//Parameter Summary  : NationalID
	public boolean DeleteIndClient(String NationalID,String ResonforDelete){
		boolean existsNID = false;
		try{
			if(getText("//td[text()='"+NationalID+"']").equals(NationalID)){
				selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete,"Delete");
				WebClick(EdaatOR.Admin_Invoice_Reasontxt);
				WebClick("//li[text()='"+ResonforDelete+"']");
				WebClick(EdaatOR.Admin_Invoice_Deletebtn);
				Thread.sleep(2000);
				WebEdit(EdaatOR.Admin_Individualclient_IdNumber,NationalID);
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Invoice_Deletechkbox);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
				waitForElement("//td[text()='"+NationalID+"']");
				Thread.sleep(2000);
				if(CheckElementExists("//td[text()='"+NationalID+"']")==true) {
					existsNID=true;
				}
				this.takeScreenShot();	    	
			}

		}catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}
	//Function Summary  :To update individual Client.
	//Parameter Summary :N/A
	public void UpdateIndividualClient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,Log Log){

		try{
			AdminSearchIndividualclient(NationalID);
			Thread.sleep(2000);
			boolean Ele=UpdateIndClient(FullName, SecondName, ThirdName, LastName, Year, Month,Date, MobileNo, Email,Refno);
			if(Ele==true) {
				test.log(Status.PASS,"Updated  Individual client" + driver.getTitle() +" * Updated Individual client PASS * " );
				Log.ReportEvent("PASS", " Verify Upadate Individual Client is Suceessfull");

			}else
				test.log(Status.FAIL,"Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
		}catch(Exception e){
			test.log(Status.FAIL,"Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
			this.takeScreenShot();
		}
	}


	//Function Summary  : To Edit Individual Client.
	//Parameter Summary : Enter FullName,SecondName,ThirdName,LastName,Year,Month,MobileNo and Email 
	public boolean UpdateIndClient(String FullName,String SecondName,String ThirdName,String LastName,String Year,String Month,String Date,String MobileNo,String Email,String Refno){
		boolean existsNID = false;
		try{
			Thread.sleep(1000);	    	
			selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Edit");
			//WebClick(EdaatOR.Biller_Invoice_Reasontxt);
			switchTonextwindow();
			WebClear(EdaatOR.Admin_Individualclient_fname);
			WebEdit(EdaatOR.Admin_Individualclient_fname,FullName);
			WebClear(EdaatOR.Admin_Individualclient_sname);
			WebEdit(EdaatOR.Admin_Individualclient_sname,SecondName);
			WebClear(EdaatOR.Admin_Individualclient_tname);
			WebEdit(EdaatOR.Admin_Individualclient_tname,ThirdName);
			WebClear(EdaatOR.Admin_Individualclient_lname);
			WebEdit(EdaatOR.Admin_Individualclient_lname,LastName);
			WebClick(EdaatOR.Admin_Individualclient_DateOfBirth);
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfYear, Year);
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfMonth, Month);
			WebClick("//a[text()='"+Date+"']");
			WebClear(EdaatOR.Admin_Individualclient_MobileNo);
			WebEdit(EdaatOR.Admin_Individualclient_MobileNo,MobileNo);
			WebClear(EdaatOR.Admin_Individualclient_Email);
			WebEdit(EdaatOR.Admin_Individualclient_Email,Email);
			//WebClear(EdaatOR.Admin_Individualclient_ClientRefNo);
			WebEdit(EdaatOR.Admin_Individualclient_ClientRefNo,Refno);
			this.takeScreenShot();	
			WebClick(EdaatOR.Admin_Individualclient_Add);
			Thread.sleep(4000);
			if(CheckElementExists("//td[text()='"+MobileNo+"']")==true) {
				existsNID=true;
			}


		}catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}


	public int getInvoiceCountNext() throws Exception {
		int intiCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
			WebClick(EdaatOR.Biller_Invoice_NextBtn);
			Thread.sleep(1000);
			intiCount=intiCount+getInvoiceCount()+10;
			countRow=true;
		}

		if(countRow==false) {
			intiCount=10;
		}
		return intiCount;
	}
	public int getInvoiceCount() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_Count));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}
	public void naviagteCreateInvoicePage() {
		ClickOnExportInvoiceBtn();
		waitForPageToLoad();

	}
	public void ClickOnExportInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Biller_AddInvoice_btn);
		waitForPageToLoad();
	}
	public void enterClientNameOrNationalID(Map<Object,Object> testdatamap) throws Exception {
		String client=testdatamap.get("ClientID").toString();
		if(client.equalsIgnoreCase("Individual")) {
			ClickOnIndividualRadBtn();
		}
		else if(client.equalsIgnoreCase("Corporate")){
			ClickOnCoporateRadBtn();
		}

		SelectCustomerID(testdatamap.get("ClientName").toString());
		String sBill=testdatamap.get("SubBiller").toString();
		if(!sBill.equalsIgnoreCase("")) {
			SelectSubBiller(sBill);
		}

	}
	public void SelectSubBiller(String SubBiller) {
		WebSelect(EdaatOR.Biller_Invoice_SBilIdList,SubBiller);
		waitForPageToLoad();
	}
	public void SelectCustomerID(String Cust) throws Exception {

		WebClick(EdaatOR.Biller_Invoice_CustIDList);
		Thread.sleep(500);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+Cust+"]");
		waitForPageToLoad();
	}
	public void ClickOnCoporateRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_CopoRdv);
		waitForPageToLoad();
	}

	public void ClickOnIndividualRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_IndividualRdv);
		waitForPageToLoad();
	}
	public void selectTemplate(String drop,Map<Object,Object> testdatamap) throws Exception {

		Thread.sleep(500);	
		waitForPageToLoad();

		waitForPageToLoad();
	}
	//Function Summary   : Method to select sub biller 
	//Parameter Summary  :N/A 
	public void selectSubbiller(String drop,Map<Object,Object> testdatamap) throws Exception {
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_SBilIdList);
		Thread.sleep(5000);
		WebClick(EdaatOR.Admin_Invoice_ClientRoleId+"["+drop+"]");
		waitForPageToLoad();
		Thread.sleep(2000);
		//EnterFixedPrice(testdatamap.get("FixedPrice").toString());
		//	EnterPercentage(testdatamap.get("FixedPercentage").toString());

	}
	public void SelectInvoiceTemplate(String sel, String Tem) throws InterruptedException {
		Thread.sleep(500);
		selectDropdownValue_PartialText(sel, Tem);
	}
	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_AddProductBtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to select product name
	//Parameter Summary : product name
	public void SelectProduct(String Cust) {
		WebSelect(EdaatOR.Admin_Invoice_ProductID,Cust);
		waitForPageToLoad();
	}
	public void ClickOnProductAddBtn() {
		WebClick(EdaatOR.Admin_Invoice_AddBtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to enter issue date
	//Parameter Summary  : Issue date
	public void EnterIssuedDate() throws Exception {
		//	scrollDowntillend(driver);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_DateInvoc);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_RegistDate_exprDate);
		Thread.sleep(1000);
	}


	public void SelectDuration(String dur) {
		WebSelect(EdaatOR.Admin_Invoice_DurationID,dur);
		waitForPageToLoad();
	}

	public void EnterMinPrice(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_MinTax,Price);
		waitForPageToLoad();
	}
	public void EnterFixedPrice(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Fixed,Price);
		waitForPageToLoad();
	}


	public void EnterCondition(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_Conditon,Price);
		waitForPageToLoad();
	}
	public void EnterPercentage(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Percentage,Price);
		waitForPageToLoad();
	}
	public void ClickOnCreateInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_CreateReapeat);
		waitForPageToLoad();
	}
	public void EnterDescriptionSaved(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_Descript,Price);
		waitForPageToLoad();
	}

	public void EnterDescriptionOne(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Descript1,Price);
		waitForPageToLoad();
	}
	public void ClickOnExportBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_ExportButton);
		waitForPageToLoad();
	}

	//Function Summary  : Method to click on "Save" button
	//Parameter Summary :N/A
	public void ClickOnSaveBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Create);
		waitForPageToLoad();
	}

	//Function Summary   : Method to add ProductPrice 
	//Parameter Summary :Price
	public void EnterProductPrice(String Price) throws Exception {
		Thread.sleep(1000);
		WebClearUsingKeys(EdaatOR.Admin_Invoice_TaxPric);
		WebEdit(EdaatOR.Admin_Invoice_TaxPric,Price);
		waitForPageToLoad();
	}

	//Function Summary   : Method to add product 
	//Parameter Summary : ProductName, ProductPrice
	public void addProductDetails(Map<Object,Object> testdatamap) throws Exception {
		Thread.sleep(1000);
		ClickOnProductBtn();
		Thread.sleep(1000);
		SelectProduct(testdatamap.get("ProductName").toString());
		Thread.sleep(2000);
		waitForPageToLoad();
		EnterProductPrice(testdatamap.get("ProductPrice").toString());
		ClickOnProductAddBtn();
		Thread.sleep(500);

	}
	//Function Summary   : Method to  click on terms
	//Parameter Summary  : N/A
	public void EnterCondition() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Conditonbtn);
		waitForPageToLoad();
	}

	//Function Summary   : Method to enter issue date and terms
	//Parameter Summary  : Issue date and terms
	public void enterInvoicDetails(Map<Object,Object> testdatamap) throws Exception {
		scrollDowntillend(driver);
		this.takeScreenShot();
		EnterIssuedDate();
		EnterCondition();
		Thread.sleep(1000);
	}
	public int getInvoiceCountNextAfteradd() throws Exception {
		int aftCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextBtn);
			Thread.sleep(1000);
			aftCount=aftCount+getInvoiceCountAdd()+10;
			countRow=true;
		}

		if(countRow==false) {
			aftCount=10;
		}
		return aftCount;
	}
	public void enterInvoiceCaseType(Map<Object,Object> testdatamap) throws Exception {

		//		EnterDescriptionSaved(testdatamap.get("Description").toString());
		//		EnterDescriptionOne(testdatamap.get("Description").toString());
		String iType=testdatamap.get("InvoiceType").toString();
		if(iType.equalsIgnoreCase("Save")) {
			ClickOnSaveBtn();
		}
		else if(iType.equalsIgnoreCase("Export")){
			ClickOnExportBtn();
		}
		Thread.sleep(1000);
	}
	//Function Summary  :Method to get invoice count
	//Parameter Summary :N/A
	public int getInvoiceCountAdd() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_AfteraddInvoice));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}
	//Function Summary  :Method to enter invoice description
	//Parameter Summary :Description
	public void enterInvoiceCaseSaveType(Map<Object,Object> testdatamap) throws Exception {
		EnterDescriptionSaved(testdatamap.get("Description").toString());
		EnterDescriptionOne(testdatamap.get("Description").toString());
		String iType=testdatamap.get("InvoiceType").toString();
		ClickOnSaveBtn();

		Thread.sleep(1000);
	}
	//Function Summary  :Method to click on exported bills
	//Parameter Summary :N/A
	public void ClickOnAdminExportBillLink() {
		WebClickUsingJS(EdaatOR.Admin_ExportBill_Link);
		waitForPageToLoad();
	}

	//Function Summary   :Navigate to individual client, create invoice and verify invoice is created
	//Parameter Summary :TemplateName.
	public void CreateIndividualClientInvoice(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(2000);	
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			Thread.sleep(2000);	    	
			selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete,"Create Invoice");
			switchTonextwindow();
			waitForPageToLoad();
			Thread.sleep(4000);	
			selectSubbiller(EdaatOR.Admin_Invoice_SBilIdList,testdatamap);
			Thread.sleep(1000);
			WebSelect(EdaatOR.Admin_Invoice_TemplateList,testdatamap.get("TemplateName").toString());
			waitForPageToLoad();
			addProductDetails(testdatamap);
			enterInvoicDetails(testdatamap);
			Thread.sleep(800);
			ClickOnSaveBtn();
			Thread.sleep(2000);
			waitForPageToLoad();
			this.takeScreenShot();
			ClickOnAdminExportBillLink();
			Thread.sleep(2000);
			waitForPageToLoad();
			int val=getInvoiceCountAdd();
			if(CheckElementExists(EdaatOR.Admin_Invoice_AfteraddInvoice+"["+val+"]/td[10]")==true){
				test.log(Status.PASS," Create Individual Client Invoice" + driver.getTitle() +" *Create Individual Client Invoice  PASS * " );
	        	Log.ReportEvent("PASS", " Verify Create Individual Client Invoice is Suceessfull");

			}
			else{
				test.log(Status.FAIL," Create Individual Client Invoice" + driver.getTitle() +" * Create Individual Client Invoice FAIL * " );
			}
			this.takeScreenShot();


		}
		catch(Exception e){
			test.log(Status.FAIL,"Create Individual Client Invoice" + driver.getTitle() +" * Create Individual Client Invoice FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary  :Navigate to individual client, search client and view invoice
	//Parameter Summary :ClientName,nationalID,ClientReferenceNumber
	public void ViewIndividualClientInvoice(Map<Object,Object> testdatamap,Log Log) throws Exception {
		boolean existsNID=false;
		try {
			if(testdatamap.get("ClientID").toString().equalsIgnoreCase("Individual")) {
				WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			}if(testdatamap.get("ClientID").toString().equalsIgnoreCase("Corporate")) {
				WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			}
			Thread.sleep(1000);	    	
			WebEdit(EdaatOR.Admin_ClientName,testdatamap.get("ClientName").toString());
			Thread.sleep(1000);	 
			WebEdit(EdaatOR.Admin_IN_nationalID,testdatamap.get("nationalID").toString());
			Thread.sleep(1000);	
			WebEdit(EdaatOR.Admin_IN_ClientRef_Number,testdatamap.get("ClientReferenceNumber").toString());
			Thread.sleep(1000);	
			WebClick(EdaatOR.Admin_ClientSearch_button);
			Thread.sleep(1000);	
			selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete,"View Invoice");
			switchTonextwindow();
			this.takeScreenShot();
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Invoice_view);
			Thread.sleep(2000);
			switchTonextwindow();
			this.takeScreenShot();
			if(ExistsCheck(EdaatOR.Admin_Invoice_form)==true) {
				existsNID=true;
				test.log(Status.PASS,"View Individual Client Invoice " + driver.getTitle() +" * View Individual Client Invoice PASS * " );
	        	Log.ReportEvent("PASS", " Verify View Individual Client Invoice is Suceessfull");

			}
			else {
				test.log(Status.FAIL,"View Individual Client Invoice  " + driver.getTitle() +" *View Individual Client Invoice FAIL * " );
			}
			this.takeScreenShot();	    	
		}catch(Exception e){
			test.log(Status.FAIL,"View Individual Client Invoice" + driver.getTitle() +" *View Individual Client Invoice FAIL * " );
			this.takeScreenShot();
		}}
	//Function Summary  : method to verify Error messages in Add individual client page
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno.
	public void VerifyAddIndClietErrorMsg(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ExpectedResult) throws InterruptedException{
		{

			Addclient(FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno);
			Thread.sleep(50); 
			this.takeScreenShot();
			try {
				if (ExistsCheck(EdaatOR.Admin_AlertMsg)){	
					if(ExistsCheck(EdaatOR.Admin_ClientRefExistsAlertMsg)) {
						VerifyValue1(ExpectedResult,getText(EdaatOR.Admin_ClientRefExistsAlertMsg));				
						test.log(Status.PASS, "Individual Client Reference number Exists alert Message Exists" + driver.getTitle() + " *Client Ref alert Message Exists * ");
					}else if(ExistsCheck(EdaatOR.Admin_NationalIDExistsAlertMsg)) { 
						VerifyValue1(ExpectedResult,getText(EdaatOR.Admin_NationalIDExistsAlertMsg));				
						test.log(Status.PASS, "Individual Client NationalID Exists alert Message Exists" + driver.getTitle() + " *NationalID alert Message Exists * ");
					}
				}
				else if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
					this.takeScreenShot();
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_FirstNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_SecondNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_ThirdNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_LastNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_NationalIDErrorMsg));	
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_MobileNoErrorMsg));	
					test.log(Status.PASS, "Individual Client  ErrorMessage Exists" + driver.getTitle() + " *   ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_FirstNameErrorMsg)) {

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_FirstNameErrorMsg));
					test.log(Status.PASS, "Individual Client FirstName ErrorMessage Exists" + driver.getTitle() + " * FirstName ErrorMessage Exists * ");
				}else if (ExistsCheck(EdaatOR.Admin_SecondNameErrorMsg)) {

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_SecondNameErrorMsg));
					test.log(Status.PASS, "Individual Client SecondName ErrorMessage Exists" + driver.getTitle() + " *SecondName ErrorMessage Exists * ");
				}else if (ExistsCheck(EdaatOR.Admin_ThirdNameErrorMsg)){	

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_ThirdNameErrorMsg));			
					test.log(Status.PASS, "Individual Client ThirdName ErrorMessage Exists" + driver.getTitle() + " *ThirdName ErrorMessage Exists * ");
				}else if (ExistsCheck(EdaatOR.Admin_LastNameErrorMsg)){	

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_LastNameErrorMsg));		
					test.log(Status.PASS, "Individual Client LastName ErrorMessage Exists" + driver.getTitle() + " *LastName ErrorMessage Exists * ");
				}else if (ExistsCheck(EdaatOR.Admin_NationalIDErrorMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_NationalIDErrorMsg));				
					test.log(Status.PASS, "Individual Client NationalID ErrorMessage Exists" + driver.getTitle() + " *NationalID ErrorMessage Exists * ");

				}else if (ExistsCheck(EdaatOR.Admin_MobileNoErrorMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_MobileNoErrorMsg));			
					test.log(Status.PASS, "Individual Client Mobile Number ErrorMessage Exists" + driver.getTitle() + " *Mobile Number  ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_NationalIDStartsError)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_NationalIDStartsError));			
					test.log(Status.PASS, "Individual Client National ID starts with ErrorMessage Exists" + driver.getTitle() + " *National ID  ErrorMessage Exists * ");
				}
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				//test.log(Status.FAIL,ErrorFontColorPrefix + " AdminIndividualClient Page - Add Individual Client failed - unable to Enter" + e+ ErrorFontColorSuffix);
				throw new NoSuchElementException("Add Individual Client "+ "Page - Not Loaded");
			}

		}

	}

	//Function Summary  : method to verify Error messages in Edit individual client page
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno.
	public void VerifyEditIndClietErrorMsg(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ExpectedResult) throws InterruptedException{
		{
			UpdateIndClient( FullName, SecondName, ThirdName, LastName, Year, Month, Date, MobileNo, Email,Refno);
			Thread.sleep(50); 
			this.takeScreenShot();
			try {
				if (ExistsCheck(EdaatOR.Admin_AlertMsg)){	
					if(ExistsCheck(EdaatOR.Admin_ClientRefExistsAlertMsg)) {
						VerifyValue1(ExpectedResult,getText(EdaatOR.Admin_ClientRefExistsAlertMsg));				
						test.log(Status.PASS, "Individual Client Reference number Exists alert Message Exists" + driver.getTitle() + " *Client Ref alert Message Exists * ");
					}else if(ExistsCheck(EdaatOR.Admin_NationalIDExistsAlertMsg)) { 
						VerifyValue1(ExpectedResult,getText(EdaatOR.Admin_NationalIDExistsAlertMsg));				
						test.log(Status.PASS, "Individual Client NationalID Exists alert Message Exists" + driver.getTitle() + " *NationalID alert Message Exists * ");
					}
				}
				else if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
					this.takeScreenShot();
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_FirstNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_SecondNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_ThirdNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_LastNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_MobileNoErrorMsg));	
					test.log(Status.PASS, "Edit Individual Client  ErrorMessage Exists" + driver.getTitle() + " *   ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_FirstNameErrorMsg)) {

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_FirstNameErrorMsg));
					test.log(Status.PASS, "Individual Client FirstName ErrorMessage Exists" + driver.getTitle() + " * FirstName ErrorMessage Exists * ");
				}else if (ExistsCheck(EdaatOR.Admin_SecondNameErrorMsg)) {

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_SecondNameErrorMsg));
					test.log(Status.PASS, "Individual Client SecondName ErrorMessage Exists" + driver.getTitle() + " *SecondName ErrorMessage Exists * ");
				}else if (ExistsCheck(EdaatOR.Admin_ThirdNameErrorMsg)){	

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_ThirdNameErrorMsg));			
					test.log(Status.PASS, "Individual Client ThirdName ErrorMessage Exists" + driver.getTitle() + " *ThirdName ErrorMessage Exists * ");
				}else if (ExistsCheck(EdaatOR.Admin_LastNameErrorMsg)){	

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_LastNameErrorMsg));		
					test.log(Status.PASS, "Individual Client LastName ErrorMessage Exists" + driver.getTitle() + " *LastName ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_MobileNoErrorMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_MobileNoErrorMsg));			
					test.log(Status.PASS, "Individual Client Mobile Number ErrorMessage Exists" + driver.getTitle() + " *Mobile Number  ErrorMessage Exists * ");
				}

				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				//test.log(Status.FAIL,ErrorFontColorPrefix + " AdminIndividualClient Page - Add Individual Client failed - unable to Enter" + e+ ErrorFontColorSuffix);
				throw new NoSuchElementException("Edit Individual Client "+ "Page - Not Loaded");
			}

		}

	}

	//Function Summary  : method to verify Error messages in delete individual client page
	//Parameter Summary : ExpectedResult
	public void VerifyDeleteIndClietErrorMsg(String ExpectedResult) throws InterruptedException{
		{
			try {
				WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
				Thread.sleep(500);
				selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_DeleteFrstRow,"Delete");
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Invoice_Deletebtn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_DeleteClientErrMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_DeleteClientErrMsg));			
					test.log(Status.PASS, "Individual Client delete ErrorMessage Exists" + driver.getTitle() + " *Delete Error Message Exists * ");
				}

				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				//test.log(Status.FAIL,ErrorFontColorPrefix + " AdminIndividualClient Page - Add Individual Client failed - unable to Enter" + e+ ErrorFontColorSuffix);
				throw new NoSuchElementException("Delete Individual Client "+ "Page - Not Loaded");
			}

		}

	}
}