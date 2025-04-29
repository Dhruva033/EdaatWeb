/**
*
* Test Script Name                   :N/A
* Objective                          : Admin Settings functionality.
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 23/05/2023
* Last Updated on                    : N/A
* Updated By                         : Kalpana I R
* Pre-Conditions                     : N/A
* Manual Testcase Name               : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
* Defects affecting this test script : None
* Work Arounds/Known Issues          : None
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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



public class AdminSettingsPage extends BasePage
{

	public AdminSettingsPage(WebDriver driver,ExtentTest test)
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
	
	public int getInvoiceCountNext() throws Exception {
		int intiCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Admin_Invoice_NextPrevLink);
			Thread.sleep(1000);
			intiCount=intiCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
			countRow=true;
		}
		if(countRow==false) {
			intiCount=10;
		}
		return intiCount;
	}
	
	public int getInvoiceCount() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Admin_Invoice_Count));
		waitForPageToLoad();
		int count =invoice.size();
		System.out.println(count);
		return count;
	}
	public int getInvoiceCountNextAfteradd() throws Exception {
		int aftCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Admin_Invoice_NextPrevLink);
			Thread.sleep(1000);
			aftCount=aftCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
			countRow=true;
		}
		if(countRow==false) {
			aftCount=10;
		}
		return aftCount;
	}
//Function Summary  :To add recurring invoice template
//Parameter Summary : Enter TemplateArabic,TemplateEnglish and InvoiceType.
	public void AddInvoicetemplate(String TemplateArabic,String TemplateEnglish,String InvoiceType,Log Log){
		try{
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Settings);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Add_Invoice_template);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Add_Invoice_Button);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_Invoice_TemplateArabic,TemplateArabic);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Invoice_TemplateEng,TemplateEnglish);  
			Thread.sleep(1000);
			if(InvoiceType.equalsIgnoreCase("Recurring"))
			WebClickUsingJS(EdaatOR.Admin_Invoice_Templatetype);
		else
			WebClickUsingJS(EdaatOR.Admin_Invoice_Templatetype_One);              	
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_Invoice_Add);

		boolean Ele=AdminSearchtemplate(TemplateEnglish);
		if(Ele==true) {
			test.log(Status.PASS,"Admin Search Invoice Template" + driver.getTitle() +" * Admin Search Invoice Template PASS * " );
        	Log.ReportEvent("PASS", " Verify Search Invoice Template is Suceessful");

		}else
			test.log(Status.FAIL,"Admin Search Invoice Template" + driver.getTitle() +" * Admin Search Invoice Template FAIL * " );
		this.takeScreenShot();

		Thread.sleep(1000);
		test.log(Status.PASS,"Admin Add New Template client" + driver.getTitle() +" *Admin Add New Template PASS * " );
	}catch(Exception e){
		test.log(Status.FAIL,"Admin Add New Template client" + driver.getTitle() +" * Admin Add New Template client FAIL * " );
		this.takeScreenShot();
	}
}
	//Function Summary   : Method to UpadateProduct
	//Parameter Summary  : ProdEnglish,UpdateProdArabicUpdate,ProdEnglishCategory,ReferenceCode,TestDescription,BasicPrice,MinPriceSAR,MaxPriceSAR
	public void UpadateProduct(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
		String priceList;
		try { 
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("ProdEnglish").toString());
			Thread.sleep(500);
			WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Product_EditLink);
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_NameArabic);
			WebEdit(EdaatOR.Admin_Prod_NameArabic,testdatamap.get("UpdateProdArabic").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Invoice_TemplateEng);
			WebEdit(EdaatOR.Admin_Invoice_TemplateEng,testdatamap.get("UpdateProdEnglish").toString());  
			Thread.sleep(1000);
			WebSelect1(EdaatOR.Admin_Invoice_Select,testdatamap.get("Category").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_Ref);
			WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("ReferenceCode").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_Description);
			WebEdit(EdaatOR.Admin_Prod_Description,testdatamap.get("TestDescription").toString());
			Thread.sleep(1000);		
			WebClear(EdaatOR.Admin_Prod_Price);
			WebEdit(EdaatOR.Admin_Prod_Price,testdatamap.get("BasicPrice").toString());  
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_MinPrice);
			WebEdit(EdaatOR.Admin_Prod_MinPrice,testdatamap.get("MinPriceSAR").toString());  
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_MaxPrice);
			WebEdit(EdaatOR.Admin_Prod_MaxPrice,testdatamap.get("MaxPriceSAR").toString());  
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Prod_Pricelist);
			Thread.sleep(1000);
			waitForPageToLoad();
			priceList=testdatamap.get("PriceList").toString();
			WebClickUsingJS("//li[contains(text(),'"+priceList+"')]"); 
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_Update);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("UpdateProdEnglish").toString());
			WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
			this.takeScreenShot();
			Thread.sleep(1000);
			test.log(Status.PASS,"Update Product Successful" + driver.getTitle() +" * Update Product Successful PASS * " );
        	Log.ReportEvent("PASS", " Verify Product Management Active/Deactivate functionality Is Suceessful");

		}catch(Exception e){
			test.log(Status.FAIL,"Update product  is not Successful" + driver.getTitle() +" * Update product  is not Successful FAIL * " );
			this.takeScreenShot();
		}
	}
public boolean AdminSearchtemplate(String InvoiceType){
	boolean existsElement = false;
	try{
		
		WebEdit(EdaatOR.Admin_Individualclient_Name,InvoiceType);
		WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
		Thread.sleep(1000);
		if(CheckElementExists("//td[text()='"+InvoiceType+"']")==true) {
			existsElement=true;
		}
		this.takeScreenShot();	    	

	}catch(Exception e){
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsElement;
}
public void addProduct(Map<Object,Object>testdatamap) throws InterruptedException {
	WebClickUsingJS(EdaatOR.Admin_Prod_Addbutton);
	Thread.sleep(2000);
	WebEdit(EdaatOR.Admin_Prod_NameArabic,testdatamap.get("ProdArabic").toString());
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Invoice_TemplateEng,testdatamap.get("ProdEnglish").toString());  
	Thread.sleep(500);
	WebSelect1(EdaatOR.Admin_Invoice_Select,testdatamap.get("Category").toString());
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("ReferenceCode").toString());
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Prod_Description,testdatamap.get("TestDescription").toString());
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Prod_Price,testdatamap.get("BasicPrice").toString());  
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Prod_MinPrice,testdatamap.get("MinPriceSAR").toString());  
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Prod_MaxPrice,testdatamap.get("MaxPriceSAR").toString());  
	Thread.sleep(500);
	this.takeScreenShot();
	WebClick(EdaatOR.Admin_Invoice_Add);
}
//Function Summary   : Method to AddProduct
//Parameter Summary  : ProdArabic,ProdEnglish,Category,ReferenceCode,TestDescription,BasicPrice,MinPriceSAR,MaxPriceSAR
public void AddProduct(Map<Object,Object>testdatamap){
	String priceList;
	try{
		WebClickUsingJS(EdaatOR.Admin_Prod_Addbutton);
		Thread.sleep(2000);
		WebEdit(EdaatOR.Admin_Prod_NameArabic,testdatamap.get("ProdArabic").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Invoice_TemplateEng,testdatamap.get("ProdEnglish").toString());  
		Thread.sleep(1000);
		WebSelect1(EdaatOR.Admin_Invoice_Select,testdatamap.get("Category").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("ReferenceCode").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Prod_Description,testdatamap.get("ProductDescription").toString());
		Thread.sleep(1000);		
		WebEdit(EdaatOR.Admin_Prod_Price,testdatamap.get("BasicPrice").toString());  
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Prod_MinPrice,testdatamap.get("MinPriceSAR").toString());  
		Thread.sleep(500);
		WebEdit(EdaatOR.Admin_Prod_MaxPrice,testdatamap.get("MaxPriceSAR").toString());  
		Thread.sleep(1000);
		/*WebClickUsingJS(EdaatOR.Admin_Prod_Pricelist);
		Thread.sleep(2000);
		priceList=testdatamap.get("PriceList").toString();
		scrollDowntillend(driver);
		Thread.sleep(2000);
		WebClickUsingJS("//li[contains(text(),'"+priceList+"')]"); 
		Thread.sleep(2000);*/
		this.takeScreenShot();
		WebClickUsingJS(EdaatOR.Admin_Invoice_Add);
		test.log(Status.PASS,"Add Product Successful" + driver.getTitle() +" * Add Product Successful PASS * " );
	}catch(Exception e){
		test.log(Status.FAIL,"Add Product Not Successful" + driver.getTitle() +" * Add Product Successful FAIL * " );
		this.takeScreenShot();
	}
}

//Function Summary   : Method to navigate to Invoice templates 
//Parameter Summary : N/A
public void navigateTemplate(Log Log) throws Exception {
	Thread.sleep(2000);
	WebClickUsingJS(EdaatOR.Admin_Settings);
	Thread.sleep(2000);
	WebClickUsingJS(EdaatOR.Admin_Add_Invoice_template);
	Thread.sleep(2000);
	Log.ReportEvent("PASS", " Verify Invoice Template Page Is Displayed Successfully");


}
//Function Summary   : Method to verifyInvoiceTemplateVariables
//Parameter Summary  : AddTemplateHeadr
public void verifyInvoiceTemplateVariables(Map<Object,Object>testdatamap,Log Log) throws Exception {
	Thread.sleep(2000);
	WebClickUsingJS(EdaatOR.Admin_Add_Invoice_Button);
	Thread.sleep(2000);
	VerifyValue1(getText(EdaatOR.Admin_Tamplate_AddTitleHdr), testdatamap.get("AddTemplateHeadr").toString());
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_AddTemplNameArbicHdr);
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_AddTemplNameEngHdr);
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_AddRefercodeHdr);
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_AddActDdeacHdr);
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_AddBillPaymentyHdr);
    	Log.ReportEvent("PASS", " Verify Admin Invoice Template  Variable is displayed Suceessful");

	}

public boolean Grid(String view,String table) {
	boolean existsNID = false;
	try {
		this.takeScreenShot();
		WebClickUsingJS(view);
		Thread.sleep(1000);
		this.takeScreenShot();
		if (ExistsCheck(table) == true) {
			existsNID = true;
		}
		
	}

	catch (Exception e) {
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsNID;
}

//Function Summary   : Method to view Table in invoice template
//Parameter Summary : N/A
public void GridView(String view,String table,Log Log) throws Exception {
	try {
		
		boolean Ele = Grid(view,table);
		if (Ele == true) {
			test.log(Status.PASS,"Grid View" + driver.getTitle() + " * Grid View PASS * ");
    	Log.ReportEvent("PASS", " Verify Admin Invoice Template  Variable is displayed Suceessful");

		}else
			test.log(Status.FAIL,"Grid View" + driver.getTitle() + " * Grid View FAIL * ");
	} catch (Exception e) {
		test.log(Status.FAIL, "Grid View" + driver.getTitle() + " * Grid View FAIL * ");
		this.takeScreenShot();
	}
}


//Function Summary   : Method to  view and verify invoice templates 
//Parameter Summary : N/A
public void verfiyViewInvoiceTemplate(Map<Object,Object>testdatamap,Log Log) throws Exception {
	try {
		Thread.sleep(2000);
	WebClickUsingJS(EdaatOR.Admin_Tamplate_Table+"[1]"+EdaatOR.Admin_Tamplate_UpdateBtn);
	Thread.sleep(4000);
	ValidateTwoValue(getText(EdaatOR.Admin_Tamplate_UpdateTitleHdr), testdatamap.get("VeiwTempleteHeader").toString());
	Thread.sleep(4000);
	verifyElementIsPresent(EdaatOR.Admin_Tamplate_UpdateDesHdr);
	Thread.sleep(2000);
	verifyElementIsPresent(EdaatOR.Biller_Tamplate_UpdateInVTyeHdr);
	this.takeScreenShot();
	test.log(Status.PASS,"View Invoice Template" + driver.getTitle() +" * Add Individual client PASS * " );
	Log.ReportEvent("PASS", " Verify Invoice Template is Veiwed Suceessfull");

	}catch(Exception e){
	test.log(Status.FAIL,"View Invoice Template" + driver.getTitle() +" * Add Individual client FAIL * " );
		this.takeScreenShot();
	}
}

//Function Summary   : Method to delete the invoice template displayed first in invoice templates grid
//Parameter Summary : N/A
	public void verfiyDeleteInvoiceTemplate(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
			while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextPrevLink);}
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Tamplate_Table+"[1]"+EdaatOR.Admin_Tamplate_DeleteBtn);
		Thread.sleep(2000);
		VerifyValue1(getText(EdaatOR.Admin_Tamplate_DeletePop), testdatamap.get("DeleteConfirmMes").toString());
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_DeleteConfBtn);
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_DeleteNoBtn);
		test.log(Status.PASS,"Delete Invoice Template" + driver.getTitle() +" * Add Individual client PASS * " );
    	Log.ReportEvent("PASS", " Verify Invoice Template is Deleted Suceessful");

		}catch(Exception e){
		test.log(Status.FAIL,"Delete Invoice Template" + driver.getTitle() +" * Add Individual client FAIL * " );
		this.takeScreenShot();
	}
}

public void verifyInvoiceTemplateDetails(Map<Object,Object>testdatamap,Log Log) throws Exception {
	String TemName=testdatamap.get("ActionTemplate").toString();
	switch(TemName) {

	case "Template":
		verifyInvoiceTemplateVariables(testdatamap,Log);
		break;

	case "View":
		verfiyViewInvoiceTemplate(testdatamap,Log);
		break;

	case "Delete":
		verfiyDeleteInvoiceTemplate(testdatamap,Log);
		break;
	}

}

//Function Summary  :Navigate to Settings and Products Management
//Parameter Summary : N/A
public void navigateProduct(Log Log) throws Exception {
	Thread.sleep(2000);
	WebClickUsingJS(EdaatOR.Admin_Settings);
	Thread.sleep(1000);
	WebClickUsingJS(EdaatOR.Admin_Add_Product);
	Thread.sleep(1000);
	Log.ReportEvent("PASS", " Verify Product Management is Page dispayed Suceessful");

}
//Function Summary  : //To enter product name.
//Parameter Summary : SearchProdName.
public void EnterProductInputBox(String pname) {
	if(!pname.equalsIgnoreCase(""))
		WebEdit(EdaatOR.Biller_Product_NameInput, pname);
}
//Function Summary  : //to select category from dropdown.
//Parameter Summary : SearchProdCateg
public void SelectIdProductListBox(String lstname) {
	if(!lstname.equalsIgnoreCase(""))
		WebSelect1(EdaatOR.Biller_Product_SearchIDlist, lstname);
}
public void SearchProduct(Map<Object,Object>testdatamap) throws InterruptedException {
	WebEdit(EdaatOR.Biller_Product_NameInput, testdatamap.get("ProdEnglish").toString());
	Thread.sleep(500);
	WebSelect1(EdaatOR.Biller_Product_SearchIDlist, testdatamap.get("Category").toString());
	Thread.sleep(500);
	WebClick(EdaatOR.Biller_Product_SeachBtn);
	Thread.sleep(500);
}
//Function Summary  : To click on search button
//Parameter Summary : N/A
public void ClickOnSearchBtn() {
	WebClick(EdaatOR.Biller_Product_SeachBtn);
}

//Function Summary  : verify Activate Product Functionality.
//Parameter Summary : ProdEnglish.
public void verifyActivateProductFunctionality(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
	try {
		AddProduct(testdatamap);
		Thread.sleep(4000);
		WebClearandEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("ProdEnglish").toString());
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
		Thread.sleep(3000);
		//verifyElementIsPresent(EdaatOR.Admin_Product_ToggleBtn);
		WebClickUsingJS(EdaatOR.Admin_Product_ToggleBtn);
		Thread.sleep(500);
		VerifyValue1(getText(EdaatOR.Admin_Product_ActivePop), testdatamap.get("Active").toString());
		WebClick(EdaatOR.Admin_Product_ActiveConfbtn);
		Thread.sleep(2000);
		takeScreenShot();
		test.log(Status.PASS,"Add product and active Template" + driver.getTitle() +" * Product Management PASS * " );	
    	Log.ReportEvent("PASS", " Verify Product Management Active/Deactivate functionality Is Suceessfull");

	}
	catch(Exception e){
		test.log(Status.FAIL,"Add product and active Template" + driver.getTitle() +" * Product Management FAIL * " );
		this.takeScreenShot();
	}
}
//Function Summary   : Method to verifyDeActiveProductFunctionality
//Parameter Summary  : ProdEnglish,Active,Deactive
public void verifyDeActiveProductFunctionality(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
	try {
		AddProduct(testdatamap);
		Thread.sleep(5000);
		WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("ProdEnglish").toString());
		Thread.sleep(500);
		WebClick(EdaatOR.Admin_Invoice_Search);
		Thread.sleep(5000);
		verifyElementIsPresent(EdaatOR.Admin_Product_ToggleBtn);
		WebClickUsingJS(EdaatOR.Admin_Product_ToggleBtn);
		Thread.sleep(2000);
		VerifyValue1(getText(EdaatOR.Admin_Product_ActivePop), testdatamap.get("Active").toString());
		WebClickUsingJS(EdaatOR.Admin_Product_ActiveConfbtn);
		Thread.sleep(3000);
		WebClickUsingJS(EdaatOR.Admin_Product_ToggleBtn);
		Thread.sleep(2000);
		//VerifyValue1(getText(EdaatOR.Admin_Product_ActivePop), testdatamap.get("Deactive").toString());
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Product_ActiveConfbtn);
		test.log(Status.PASS,"Add product and De-active Template" + driver.getTitle() +" * Product Management PASS * " );	
    	Log.ReportEvent("PASS", " Verify Product Management Active/Deactivate functionality Is Suceessfull");

	}


	catch(Exception e){
		test.log(Status.FAIL,"Add product and De-active Template" + driver.getTitle() +" * Product Management FAIL * " );
		this.takeScreenShot();
	}
}
//Function Summary  : To Search a Product
//Parameter Summary : SearchProdName and SearchProdCateg
public void verifySearchFunctionality(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
	try {
		SearchProduct(testdatamap);
		Thread.sleep(2000);
		if(CheckElementExists(EdaatOR.Biller_Product_NoData)==true) {
			AddProduct(testdatamap);
			SearchProduct(testdatamap);
		}
String Pname=testdatamap.get("ProdEnglish").toString();
String pCate=testdatamap.get("Category").toString();
		List<WebElement> listTable=driver.findElements(By.xpath(EdaatOR.Biller_Product_Table));
		for(int i=0;i<listTable.size();i++) {
			int j=i+1;
			if(!Pname.equalsIgnoreCase("")) {
				VerifyValue1(getText(EdaatOR.Biller_Product_Table+"["+j+"]/td[3]"), Pname);
			}else if(!pCate.equalsIgnoreCase("")) {
				VerifyValue1(getText(EdaatOR.Biller_Product_Table+"["+j+"]/td[4]"), pCate);
			}
		}

		test.log(Status.PASS,"Search Product Template" + driver.getTitle() +" * Product Management PASS * " );	
    	Log.ReportEvent("PASS", " Verify Product Management Deleted and Active/Deactivate functionality Is Suceessfull");   	

	}
	catch(Exception e){
		test.log(Status.FAIL,"Search Product Template" + driver.getTitle() +" * Product Management FAIL * " );
			this.takeScreenShot();
		}
	}
    	//Function Summary   : Method to Attach Excel.
		//Parameter Summary  : N/A.	
		public void  getAutoItImagePathFile() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//AdminSettingsBillsCancellation.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(800);
		}
		//Function Summary   : Method to Attach Excel.
		//Parameter Summary  : N/A.	
		public void  getAutoItImagePathFilePaidOutEdaat() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//AdminSettingsPaidOutsideEdaatBills.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(800);
		}
	
		//Function Summary  : Method to upload Bulk data for bills cancellation.
		//Parameter Summary : N/A
		public void VerifyUploadBulkData(Log Log) throws IOException, Exception {
			try {
				WebClickUsingJS(EdaatOR.Admin_Settings);
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Admin_BillsCancellation);
				Thread.sleep(800);
				WebClickUsingActions(EdaatOR.Admin_AttachExcel);
				Thread.sleep(800);
				getAutoItImagePathFile();
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Admin_ProcessBtn);
				Thread.sleep(800);
				takeScreenShot();
				verifyElementIsPresent(EdaatOR.Admin_SuccessfulMsg);
				test.log(Status.PASS,"Upload Bulk data for bills Cancel " + driver.getTitle() +" * Upload bulk data PASS * " );	
       	       	Log.ReportEvent("PASS", " Verify to Upload bulk data for bills cancellation is Sucessfull");}
			catch(Exception e){
				test.log(Status.FAIL,"Upload Bulk data for bills Cancel  " + driver.getTitle() +" * Upload bulk data FAIL * " );
				this.takeScreenShot();
			}
		}
		//Function Summary  : Method to upload Bulk data for Paid Outside EDAAT Bills.
		//Parameter Summary : N/A
		public void VerifyUploadBulkDataForPaidOutEdaatBills(Log Log) throws IOException, Exception {
			try {
				WebClickUsingJS(EdaatOR.Admin_Settings);
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Admin_PaidOutsideEdaatBills);
				Thread.sleep(800);
				WebClickUsingActions(EdaatOR.Admin_AttachExcel);
				Thread.sleep(800);
				getAutoItImagePathFilePaidOutEdaat();
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Admin_ProcessBtn);
				Thread.sleep(800);
				takeScreenShot();
				verifyElementIsPresent(EdaatOR.Admin_SuccessfulMsg);
				test.log(Status.PASS,"Upload Bulk data for bills Cancel " + driver.getTitle() +" * Upload bulk data PASS * " );	
       	       	Log.ReportEvent("PASS", " Verify to Upload bulk data for bills cancellation is Sucessfull");

			}
			catch(Exception e){
				test.log(Status.FAIL,"Upload Bulk data for bills Cancel  " + driver.getTitle() +" * Upload bulk data FAIL * " );
				this.takeScreenShot();
			}
		}

		//Function Summary  : Method to add new invoice template.
		//Parameter Summary : TemplateArabic, TemplateEnglish,	InvoiceType	
		public void AddInvoiceTemplate(String TemplateArabic,String TemplateEnglish,String InvoiceType) throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_Settings);
			Thread.sleep(500);
			WebClickUsingJS(EdaatOR.Admin_Add_Invoice_template);
			Thread.sleep(500);
			WebClickUsingJS(EdaatOR.Admin_Add_Invoice_Button);
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_Invoice_TemplateArabic,TemplateArabic);
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_Invoice_TemplateEng,TemplateEnglish);  
			Thread.sleep(500);
			if(InvoiceType.equalsIgnoreCase("Recurring")) 
			{
			WebClickUsingJS(EdaatOR.Admin_Invoice_Templatetype);}
		   else if(InvoiceType.equalsIgnoreCase("One Time"))  {
			WebClickUsingJS(EdaatOR.Admin_Invoice_Templatetype_One); 
			}            	
	    	Thread.sleep(500);
		    WebClickUsingJS(EdaatOR.Admin_Invoice_Add);

		}
		
		//Function Summary  : method to verify Error messages in Add invoice template page
		//Parameter Summary : ExpectedResult, TemplateArabic, TemplateEnglish,	InvoiceType	
		public void VerifyAddInvoiceTemplateErrorMsg(String TemplateArabic,String TemplateEnglish,String InvoiceType,String ExpectedResult) throws InterruptedException{
			{
		try {
			AddInvoiceTemplate(TemplateArabic, TemplateEnglish, InvoiceType);
			Thread.sleep(500);
			this.takeScreenShot();
			if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
				if(TemplateArabic.equals("")) {
				VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTemplateArNameErrMsg));
				Thread.sleep(500);
				VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTemplateEnNameErrMsg));
				}
				else {
				VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTypeErrMsg));
				test.log(Status.PASS, "Add invoice template ErrorMessage Exists" + driver.getTitle() + " *Invoice template Error Message Exists * ");
			        }
			        }
			else if (ExistsCheck(EdaatOR.Admin_InvoiceTemplateArNameErrMsg)) {
				VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTemplateArNameErrMsg));
				test.log(Status.PASS, "invoice template Arabic name ErrorMessage Exists" + driver.getTitle() + " *template Arabic name ErrorMessage Exists * ");
			}
   
			else {
				test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
			}

		} catch (Exception e) {
			throw new NoSuchElementException("Delete Individual Client "+ "Page - Not Loaded");
		}

	}
				
	}
	

		//Function Summary  : method to verify Error messages in Add product page
		//Parameter Summary : ExpectedResult
		public void VerifyAddProductErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
			{
				try {
					navigateProduct(Log);
					Thread.sleep(500);
					addProduct(testdatamap);
					Thread.sleep(500);
					this.takeScreenShot();
					if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
					
							VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ProductNameArErrorMsg));
							Thread.sleep(500);
							VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ProductNameEnErrorMsg));
							//Thread.sleep(500);
							//VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ProductCategoryErrorMsg));
							Thread.sleep(500);
							VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ProductPriceErrorMsg));
						
							test.log(Status.PASS, "Add Product ErrorMessage Exists" + driver.getTitle() + " *Product Error Message Exists * ");
										}
					else if (ExistsCheck(EdaatOR.Admin_ProductNameArErrorMsg)) {
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ProductNameArErrorMsg));
						test.log(Status.PASS, "Product  Arabic name ErrorMessage Exists" + driver.getTitle() + " *Product Arabic name ErrorMessage Exists * ");
					}
					else if (ExistsCheck(EdaatOR.Admin_RefCodeErrorMsg)) {
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_RefCodeErrorMsg));
						test.log(Status.PASS, "Reference code exists ErrorMessage Exists" + driver.getTitle() + " *Reference code ErrorMessage Exists * ");
					}
					else {
						test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
					}

				} catch (Exception e) {
					throw new NoSuchElementException("Add Product "+ "Page - Not Loaded");
				}

			}
		}
		
		public void navigateToPaidOutsideBillsPage() throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_Settings);
			Thread.sleep(500);
			WebClickUsingJS(EdaatOR.Admin_settings_PaidOutsideEdaatPage);
			

		}
		public void navigateToBillsCancellationPage() throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_Settings);
			Thread.sleep(800);
			WebClickUsingJS(EdaatOR.Admin_BillsCancellation);
		}
		//Function Summary  : method to verify Error messages in Paid Outside Edaat bills page
		//Parameter Summary : ExpectedResult
		public void VerifyPaidOutsideEdaatBillsErrorMsg(Map<Object,Object>testdatamap) throws InterruptedException{
			{
				try {
					navigateToPaidOutsideBillsPage() ;
					Thread.sleep(500);
					WebClickUsingJS(EdaatOR.Admin_settings_PaidOusideBillsAttach_process);
					this.takeScreenShot();
					if (ExistsCheck(EdaatOR.Admin_settings_ContentAttachErrorMsg)){	

						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_settings_ContentAttachErrorMsg));
					   test.log(Status.PASS, "Paid outside bills ErrorMessage Exists" + driver.getTitle() + " *Paid outside bills Error Message Exists * ");
					}
					else {
						test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
					}

				} catch (Exception e) {
					throw new NoSuchElementException("Paid outside Edaat bills "+ "Page - Not Loaded");
				}

			}
		}			
		
		//Function Summary  : method to verify Error messages in Bills cancellation page
		//Parameter Summary : ExpectedResult
		public void VerifyBillsCancelationErrorMsg(Map<Object,Object>testdatamap) throws InterruptedException{
			{
				try {
					navigateToBillsCancellationPage() ;
					Thread.sleep(500);
					WebClickUsingJS(EdaatOR.Admin_settings_PaidOusideBillsAttach_process);
					this.takeScreenShot();
					if (ExistsCheck(EdaatOR.Admin_settings_ContentAttachErrorMsg)){	

						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_settings_ContentAttachErrorMsg));
					   test.log(Status.PASS, "Bills Cancellation ErrorMessage Exists" + driver.getTitle() + " *Bills Cancellation  Error Message Exists * ");
					}
					else {
						test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
					}

				} catch (Exception e) {
					throw new NoSuchElementException("Bills Cancellation  "+ "Page - Not Loaded");
				}

			}
		}		
		
}