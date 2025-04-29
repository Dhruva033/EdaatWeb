/**
 *
 * Test Script Name                   : N/A
 * Objective                          : Corporate client functionality.
 * Version                            : 1.0
 * Author                             : Kathirvelu M
 * Created Date                       : 23/05/2023
 * Last Updated on                    : N/A
 * Updated By                         : Radhika K R
 * Pre-Conditions                     : N/A
 * Epic Details                       : N/A
 * User Story Details                 : N/A
 **/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.List;
import java.util.Map;
import com.azmqalabs.edaattestautomation.common.Log;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminCorporatePage extends BasePage
{

	public AdminCorporatePage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Corporate)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}
	//Function Summary   : Method to  AddCorporateclient
	//Parameter Summary  : N/A

	public void AddCorporateclient(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno,Log Log){
		try{
			AddCorpclient(CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno);
			boolean Ele=BillerSearchCorporateclient(ClientRefno);
			if(Ele==true) {
				test.log(Status.PASS,"Add Corporate client" + driver.getTitle() +" * Add Corporate client PASS * " );
        	Log.ReportEvent("PASS", " Verify Add Corporate Client is Suceessful");
			}
			else
				test.log(Status.FAIL,"Add Corporate client" + driver.getTitle() +" * Add Corporate client FAIL * " );
		}catch(Exception e){
			test.log(Status.FAIL,"Add Corporate client" + driver.getTitle() +" * Add Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to BillerSearchCorporateclient
	//Parameter Summary  : ClientRefno
	public boolean BillerSearchCorporateclient(String ClientRefno){
		boolean existsElement = false;
		try{
			Thread.sleep(3000);
			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,ClientRefno);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(5000);
			waitForPageToLoad();
			if(CheckElementExists("//td[text()='"+ClientRefno+"']")==true) {
				existsElement=true;
			}
			this.takeScreenShot();	    	

		}catch(Exception e){
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsElement;
	}
	//Function Summary  :To search and view corporate Client details in grid.
	//Parameter Summary :CorporateName
	public void TableGridview(String CorporateName,Log Log){
		try{
			Thread.sleep(2000); 
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);    
			if(CheckElementExists(EdaatOR.Admin_Corporateclient_tbl)==true) {
				Thread.sleep(2000);
				WebClear(EdaatOR.Admin_Corporateclient_search);
				WebEdit(EdaatOR.Admin_Corporateclient_search,CorporateName);     
				WebClick(EdaatOR.Admin_Individualclient_Search);
				Thread.sleep(1000);
				WebClick("//span[contains(text(),'"+CorporateName+"')]");
				Thread.sleep(1000);
				switchTonextwindow();
				scrollDowntillend(driver);
				this.takeScreenShot();
				WebClick(EdaatOR.Admin_Individualclient_Back);
				test.log(Status.PASS,"Corporate Client Table Exists" + driver.getTitle() +" * Corporatee Client Table Exists PASS * " );
	        	Log.ReportEvent("PASS", " Verify Corporate Grid view is Suceessful");

			}       		
			else {
				test.log(Status.FAIL,"Corporate Client Table Not Exists" + driver.getTitle() +" * Corporate Client Table Not Exists FAIL * " );
			}
		}catch(Exception e){
			test.log(Status.FAIL,"Table View Corporate client" + driver.getTitle() +" * Table View Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary  : To active and Deactive client.
	//Parameter Summary : CorporateName
	public void ActivateDactivate(String CorporateName, Map<Object, Object>testdatamap,Log Log){
		try{
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);  
			if(CheckElementClickable(EdaatOR.Admin_Corporateclient_search)==true) {
				WebEdit(EdaatOR.Admin_Corporateclient_search,CorporateName); 
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Admin_Company_ToggleBtn);
				WebClickUsingJS(EdaatOR.Admin_Company_ToggleBtn);
				Thread.sleep(500);
				takeScreenShot();
				String actualvalue1=getText(EdaatOR.Admin_Compan_ActivePop);
				if(actualvalue1.equals(testdatamap.get("Active").toString()))
				{
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
				test.log(Status.PASS,"Corporate Client Deactivate/Activate Done" + driver.getTitle() +" * Corporate Client Deactivate/Activate Done PASS * " );
				Log.ReportEvent("PASS", " Verify Corporate Active is Suceessful");

				}
				else {
					test.log(Status.FAIL,"Corporate Client Deactivate/Activate Not Done" + driver.getTitle() +" * Corporate Client Deactivate/Activate Not Done FAIL * " );
				}
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Thread.sleep(2000);
				takeScreenShot();
				WebClickUsingJS(EdaatOR.Admin_Company_ToggleBtn);
				Thread.sleep(500);
				takeScreenShot();
				String actualvalue2=getText(EdaatOR.Admin_Compan_ActivePop);
				if(actualvalue2.equals(testdatamap.get("InActive").toString()))
				{
				  VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("InActive").toString());
				  test.log(Status.PASS,"Corporate Client Deactivate/Activate Done" + driver.getTitle() +" * Corporate Client Deactivate/Activate Done PASS * " );
				  Log.ReportEvent("PASS", " Verify Corporate Deactive is Suceessful");

				}
				else {
					test.log(Status.FAIL,"Corporate Client Deactivate/Activate Not Done" + driver.getTitle() +" * Corporate Client Deactivate/Activate Not Done FAIL * " );
				}
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Thread.sleep(2000);
				
			}	   		
			else {
				test.log(Status.FAIL,"Corporate Client Deactivate/Activate Not Done" + driver.getTitle() +" * Corporate Client Deactivate/Activate Not Done FAIL * " );
			}
		}catch(Exception e){
			test.log(Status.FAIL,"Corporate Client Deactivate/Activate Not Done" + driver.getTitle() +" * Table View Corporate client Not Done * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to Export
	//Parameter Summary  : N/A
	public void Export(Log Log){
		try{
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);  
			if(CheckElementClickable(EdaatOR.Admin_Corporateclient_search)==true) {
				WebClick(EdaatOR.Admin_Individualclient_export);
				Thread.sleep(2000);    
				this.takeScreenShot();
				test.log(Status.PASS,"Export Done" + driver.getTitle() +" * Export Done PASS * " );
	        	Log.ReportEvent("PASS", " Verify Exported to Excel link is  Suceessful");

			}	   		
			else {
				test.log(Status.FAIL,"Export Not Done" + driver.getTitle() +" * Export Not Done FAIL * " );
			}
		}catch(Exception e){
			test.log(Status.FAIL,"Export Not Done" + driver.getTitle() +" * Export Not Done * " );
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to navigate to corporate client, search client and verify client is displayed 
	//Parameter Summary  : CRNumber
	public boolean AdminSearchCorporateclientall(String CRNumber,String CorporateName,String Corporateno,Log Log){
		boolean existsElement = false;
		try{
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Corporateclient_Rno,CRNumber);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_CorporateclientName,CorporateName);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,Corporateno);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			existsElement=ExistsCheck("//td[text()='"+CRNumber+"']");
			if(existsElement==true) {
				test.log(Status.PASS,"Search Corporate client" + driver.getTitle() +" * Search Corporate client PASS * " );
	        	Log.ReportEvent("PASS", " Verify Corporate Client Search is Suceessful");

			}
			else {
				test.log(Status.FAIL,"Search Corporate client" + driver.getTitle() +" * Search Corporate client FAIL * " );
			}
			Thread.sleep(1000);
			this.takeScreenShot();

		}catch(Exception e){
			test.log(Status.FAIL,"Search Corporate client" + driver.getTitle() +" * Search Corporate client FAIL * " );
			this.takeScreenShot();
		}
		return existsElement;
	}
	//Function Summary   : Method to  AddCorpclient
	//Parameter Summary  : CorporateName,CRNumber,PersonName,Email,MobileNo,ClientRefno
	public void AddCorpclient(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno){
		try{
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient_Button);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Corporateclient_name,CorporateName);
			WebEdit(EdaatOR.Admin_Corporateclient_Rno,CRNumber);
			WebClick(EdaatOR.Admin_Corporateclient_lang);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner,PersonName);
			WebEdit(EdaatOR.Admin_Corporateclient_commissionerID,PersonID);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Email,Email);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Mobile,MobileNo);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Crno,ClientRefno);
			this.takeScreenShot();
			WebClick(EdaatOR.Admin_Individualclient_Add);
			Thread.sleep(1000);   

		}catch(Exception e){
			e.printStackTrace();
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to  DeleteCorporateClient
	//Parameter Summary  : N/A
	public void DeleteCorporateClient(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno, String ResonforDelete,Log Log){
		try{
			AddCorpclient(CorporateName, CRNumber, PersonName, PersonID, MobileNo, Email,ClientRefno );
			BillerSearchCorporateclient(ClientRefno);
			boolean Ele=DeleteCorpClient(ClientRefno,ResonforDelete);
			if(Ele==true) {
				test.log(Status.PASS,"Delete Corporate client" + driver.getTitle() +" * Delete Corporate client PASS * " );
				Log.ReportEvent("PASS", " Verify Delete Corporate Client is Suceessfull");

			}else
				test.log(Status.FAIL,"Delete Corporate client" + driver.getTitle() +" * Delete Corporate client FAIL * " );
		}catch(Exception e){
			test.log(Status.FAIL,"Delete Corporate client" + driver.getTitle() +" * Delete Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to  DeleteCorpClient
	//Parameter Summary  : ClientRefno
	public boolean DeleteCorpClient(String ClientRefno,String ResonforDelete){
		boolean existsNID = false;
		try{
			if(getText("//td[text()='"+ClientRefno+"']").equals(ClientRefno)){
				selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete,"Delete");
				WebClick(EdaatOR.Admin_Invoice_Reasontxt);
				Thread.sleep(1000);
				WebClick("//ul/li[contains(text(),'"+ResonforDelete+"')]");
				WebClick(EdaatOR.Admin_Invoice_Deletebtn);
				Thread.sleep(3000);
				WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,ClientRefno);
				Thread.sleep(2000);
				WebClick(EdaatOR.Admin_Invoice_Deletechkbox);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
				Thread.sleep(4000);
				if(CheckElementExists("//td[text()='"+ClientRefno+"']")==true) {
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

	//Function Summary   : Method to update corporate client data
	//Parameter Summary : CorporateName, CRNumber, PersonName, PersonID, ClientRefno,MobileNo, Email
	public void UpdateCorporateClient(String CorporateName,String CRNumber,String PersonName,String PersonID,String ClientRefno,String MobileNo,String Email,Log Log){
		try{
			boolean Ele=UpdateCorpClient(CorporateName, CRNumber, PersonName, PersonID, ClientRefno,MobileNo, Email);
			if(Ele==true) {
				test.log(Status.PASS,"Updated  Corporate client" + driver.getTitle() +" * Updated Corporate client PASS * " );
        	Log.ReportEvent("PASS", " Verify Upadate Corporate Client is successful");
			}
			else
				test.log(Status.FAIL,"Updated Corporate client" + driver.getTitle() +" * Updated Corporate client FAIL * " );
		}catch(Exception e){
			test.log(Status.FAIL,"Updated Corporate client" + driver.getTitle() +" * Updated Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to Navigate to corporate client,edit and save the client details 
	//Parameter Summary : CorporateName, PersonName,PersonID,MobileNo,Email,ClientRefno
	public boolean UpdateCorpClient(String CorporateName,String CRNumber,String PersonName,String PersonID,String ClientRefno,String MobileNo,String Email){
		boolean existsNID = false;
		try{
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);	    	
			selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Edit");
			switchTonextwindow(); 
			WebClear(EdaatOR.Admin_Corporateclient_name);
			WebEdit(EdaatOR.Admin_Corporateclient_name,CorporateName);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner,PersonName);
			WebClear(EdaatOR.Admin_Corporateclient_commissionerID);
			WebEdit(EdaatOR.Admin_Corporateclient_commissionerID,PersonID);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner_Mobile);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Mobile,MobileNo);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner_Email);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Email,Email);
			//WebClear(EdaatOR.Admin_Corporateclient_commissioner_Crno);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Crno,ClientRefno);
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_Corporateclient_Save);
			Thread.sleep(5000);
			if(CheckElementExists("(//span[text()='"+CorporateName+"'])[1]")==true) {
				existsNID=true;
			}


		}catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}
	//Function Summary   : Method to select sub biller 
	//Parameter Summary : SubBiller.
	public void selectSubbiller(Map<Object,Object> testdatamap) throws Exception {
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_SBilIdList);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_ClientRoleId+"["+testdatamap.get("SubBiller").toString()+"]");
		waitForPageToLoad();
		Thread.sleep(1000);
	}
	public void SelectInvoiceTemplate(String sel, String Tem) throws InterruptedException {
		Thread.sleep(500);
		selectDropdownValue_PartialText(sel, Tem);
	}
	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_AddProductBtn);
		waitForPageToLoad();
	}
	public void SelectProduct(String Cust) {	
		WebSelect(EdaatOR.Admin_Invoice_ProductID,Cust);
		waitForPageToLoad();
	}
	//Function Summary   : Method to click on "Add Product" button 
	//Parameter Summary : N/A
	public void ClickOnProductAddBtn() {
		WebClick(EdaatOR.Admin_Invoice_AddBtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to enter issue due date
	//Parameter Summary : Issue due date
	public void EnterIssuedDate() throws Exception {
		Thread.sleep(2000);
		WebClick(EdaatOR.Admin_Invoice_DateInvoc);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_RegistDate_exprDate);
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
	//Function Summary   : Method to click on "Create invoice" button
	//Parameter Summary : N/A.
	public void ClickOnSaveBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Create);
		waitForPageToLoad();
	}
	public void ClickOnExportBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_ExportButton);
		waitForPageToLoad();
	}

	public void EnterCondition(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Conditon,Price);
		waitForPageToLoad();
	}
	public void EnterPercentage(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Percentage,Price);
		waitForPageToLoad();
	}
	public void ClickOnCreateInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_CreateReapeat);
		waitForPageToLoad();
	}
	public void EnterDescriptionSaved(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Descript,Price);
		waitForPageToLoad();
	}

	public void EnterDescriptionOne(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Descript1,Price);
		waitForPageToLoad();
	}
	public void WebSelectByVisibleText(String sEleXpath, String sText) {
		try {
			Select select = new Select(driver.findElement(By.xpath(sEleXpath)));
			select.selectByVisibleText(sText);
		} catch (Exception e) {
			// Code to reset implicit wait and select value and then reset implicit wait
			Select select1 = new Select(driver.findElement(By.xpath(sEleXpath)));
			select1.selectByVisibleText(sText);
			test.log(Status.INFO, "WebSelectByVisibleText - Not Found");
		}
	}
	public void selectTemplate(String drop,Map<Object,Object> testdatamap) throws Exception {

		Thread.sleep(500);	
		waitForPageToLoad();

		waitForPageToLoad();
	}

	//Function Summary   : Method to add ProductPrice  
	//Parameter Summary :  Price
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
	//Function Summary   : Method to click on Terms 
	//Parameter Summary : N/A
	public void EnterCondition() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Conditonbtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to enter Invoice issue due date and terms  
	//Parameter Summary : N/A
	public void enterInvoicDetails(Map<Object,Object> testdatamap) throws Exception {
		scrollDowntillend(driver);
		Thread.sleep(2000);
		EnterIssuedDate();
		EnterCondition();
		Thread.sleep(1000);
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
	//Function Summary  :To get invoice count
	//Parameter Summary :TemplateName.
	public int getInvoiceCountAdd() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_AfteraddInvoice));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}

	//Function Summary   :Navigate to corporate client,create and verify invoice for the Corporate client 
	//Parameter Summary :TemplateName.
	public void CreateCorporateClientInvoice(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(1000);	  
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(2000);	    	
			selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete,"Create Invoice");
			switchTonextwindow();
			selectSubbiller(testdatamap);
			Thread.sleep(2000);
			WebSelect(EdaatOR.Admin_Invoice_TemplateList,testdatamap.get("TemplateName").toString());
			waitForPageToLoad();
			addProductDetails(testdatamap);
			enterInvoicDetails(testdatamap);
			Thread.sleep(800);
			ClickOnSaveBtn();
			Thread.sleep(2000);
			waitForPageToLoad();
			int val=getInvoiceCountAdd();
			if(CheckElementExists(EdaatOR.Admin_Invoice_AfteraddInvoice+"["+val+"]/td[10]")==true){
				test.log(Status.PASS," Create Corporate Client Invoice" + driver.getTitle() +" * Create Corporate Client Invoice PASS * " );
	        	Log.ReportEvent("PASS", " Verify Create Corporate Client Invoice is Suceessfull");

			}
			else{
				test.log(Status.FAIL," Create Corporate Client Invoice" + driver.getTitle() +" *Create Corporate Client Invoice FAIL * " );
			}
			this.takeScreenShot();


		}
		catch(Exception e){
			test.log(Status.FAIL,"Create Corporate Client Invoice" + driver.getTitle() +" * Create Corporate Client Invoice FAIL * " );
			this.takeScreenShot();
		}
	}

	public void ViewCorporateClientInvoice(Map<Object,Object> testdatamap,Log Log) throws Exception {
		boolean existsNID=false;
		try {
			if(testdatamap.get("ClientID").toString().equalsIgnoreCase("Individual")) {
				Thread.sleep(2000);	
				WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			}if(testdatamap.get("ClientID").toString().equalsIgnoreCase("Corporate")) {
				Thread.sleep(2000);	
				WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			}
			Thread.sleep(1000);	    	
			WebEdit(EdaatOR.Admin_CorporateName,testdatamap.get("CorporateName").toString());
			Thread.sleep(1000);	 
			WebEdit(EdaatOR.Admin_CR_Number,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);	
			WebEdit(EdaatOR.Admin_ClientRef_Number,testdatamap.get("ClientReferenceNumber").toString());
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
				test.log(Status.PASS,"View Corporate Client Invoice " + driver.getTitle() +" * View Corporate Client Invoice PASS * " );
	        	Log.ReportEvent("PASS", " Verify View Individual Client Invoice is Suceessfull");

			}
			else {
				test.log(Status.FAIL,"View Corporate Client Invoice  " + driver.getTitle() +" *View Corporate Client Invoice FAIL * " );
			}
			this.takeScreenShot();	    	
		}catch(Exception e){
			test.log(Status.FAIL,"View Corporate Client Invoice" + driver.getTitle() +" *View Corporate Client Invoice FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary  : method to verify Error messages in Add Corporate client page
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno.
	public void VerifyAddCorpClietErrorMsg(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno,String ExpectedResult) throws InterruptedException{
		{

			AddCorpclient( CorporateName, CRNumber, PersonName, PersonID, MobileNo, Email, ClientRefno);					
			Thread.sleep(50); 
			this.takeScreenShot();
			try {
				if(ExistsCheck(EdaatOR.Admin_ClientRefExistsAlertMsg)) {
					VerifyValue1(ExpectedResult,getText(EdaatOR.Admin_ClientRefExistsAlertMsg));				
					test.log(Status.PASS, "Corporate Client Reference number Exists alert Message Exists" + driver.getTitle() + " *Client Ref alert Message Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_RequiredFieldsErrMsg)){	
					this.takeScreenShot();
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredCorpNameErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredCRNoErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthNameErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthIDErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthMobileNoErrMsg));	
					test.log(Status.PASS, "Corporate Client Required field ErrorMessage Exists" + driver.getTitle() + " *   Error Message Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_RequiredCRNoErrMsg)) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredCRNoErrMsg));
					test.log(Status.PASS, "Corporate Client CR Number ErrorMessage Exists" + driver.getTitle() + " *CR Number ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_RequiredAuthIDErrMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthIDErrMsg));			
					test.log(Status.PASS, "Corporate Client Authorized person ID ErrorMessage Exists" + driver.getTitle() + " *Authorized person ID ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_RequiredAuthMobileNoErrMsg)){	

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthMobileNoErrMsg));		
					test.log(Status.PASS, "Corporate Client Mobile No ErrorMessage Exists" + driver.getTitle() + " *Mobile No ErrorMessage Exists * ");
				}

				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Add Corporate Client "+ "Page - Not Loaded");
			}

		}

	}

	//Function Summary  : method to verify Error messages in Add Corporate client page
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno.
	public void VerifyEditCorpClietErrorMsg(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno,String ExpectedResult) throws InterruptedException{
		{
			UpdateCorpClient( CorporateName, CRNumber, PersonName, PersonID, ClientRefno, MobileNo, Email);										Thread.sleep(50); 
			this.takeScreenShot();
			try {
				if(ExistsCheck(EdaatOR.Admin_ClientRefExistsAlertMsg)) {
					VerifyValue1(ExpectedResult,getText(EdaatOR.Admin_ClientRefExistsAlertMsg));				
					test.log(Status.PASS, "Corporate Client Reference number Exists alert Message Exists" + driver.getTitle() + " *Client Ref alert Message Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_RequiredFieldsErrMsg)){	
					this.takeScreenShot();
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredCorpNameErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthNameErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthIDErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthMobileNoErrMsg));	
					test.log(Status.PASS, "Corporate Client Required field ErrorMessage Exists" + driver.getTitle() + " *   Error Message Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_RequiredAuthIDErrMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthIDErrMsg));			
					test.log(Status.PASS, "Corporate Client Authorized person ID ErrorMessage Exists" + driver.getTitle() + " *Authorized person ID ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Admin_RequiredAuthMobileNoErrMsg)){	

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthMobileNoErrMsg));		
					test.log(Status.PASS, "Corporate Client Mobile No ErrorMessage Exists" + driver.getTitle() + " *Mobile No ErrorMessage Exists * ");
				}

				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				//test.log(Status.FAIL,ErrorFontColorPrefix + " AdminIndividualClient Page - Add Individual Client failed - unable to Enter" + e+ ErrorFontColorSuffix);
				throw new NoSuchElementException("Add Corporate Client "+ "Page - Not Loaded");
			}

		}

	}				

	//Function Summary  : method to verify Error messages in delete Corporate client page
	//Parameter Summary : ExpectedResult
	public void VerifyDeleteCorpClietErrorMsg(String ExpectedResult) throws InterruptedException{
		{
			try {
				WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);	
				Thread.sleep(500);
				selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete,"Delete");
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Invoice_Deletebtn); 
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_DeleteClientErrMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_DeleteClientErrMsg));			
					test.log(Status.PASS, "Corporate Client delete ErrorMessage Exists" + driver.getTitle() + " *Delete Error Message Exists * ");
				}

				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				//test.log(Status.FAIL,ErrorFontColorPrefix + " AdminIndividualClient Page - Add Individual Client failed - unable to Enter" + e+ ErrorFontColorSuffix);
				throw new NoSuchElementException("Delete Corporate Client "+ "Page - Not Loaded");
			}

		}

	}

}
