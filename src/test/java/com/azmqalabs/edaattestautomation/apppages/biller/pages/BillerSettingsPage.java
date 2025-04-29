/**
*
* Test Script Name  				 : N/A
* Objective     					 : Biller settings page Functionalities.
* Version      						 : 1.0
* Author       						 : Kathirvelu M
* Created Date 			      		 : 23/05/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Obalanayak M S
* Pre-Conditions					 : N/A 
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;


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



public class BillerSettingsPage extends BasePage
{

	public BillerSettingsPage(WebDriver driver,ExtentTest test)
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

	//Function Summary : Method to create Invoice Template
	//Parameter Summary:TemplateArabic,TemplateEnglish,TemplateDescription,TemplateReferancecode,Recurring,InvoiceType
	public void AddInvoicetemplate(String TemplateArabic,String TemplateEnglish,String InvoiceType,String TemplateReferancecode,String TemplateDescription,Log Log){
		try{
			WebClickUsingJS(EdaatOR.Biller_Settings);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Add_Invoice_template);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Add_Invoice_Button);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_Invoice_TemplateArabic,TemplateArabic);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Invoice_TemplateEng,TemplateEnglish);  
			Thread.sleep(1000);
			
			//i added these three
			WebEdit(EdaatOR.Biller_Invoice_TemplateDisc,TemplateDescription);  
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Invoice_TemplateRefcode,TemplateReferancecode);  
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Invoice_Templateactideacti);  
			Thread.sleep(1000);
	
		//	i added these two
			WebClickUsingJS(EdaatOR.Biller_Invoice_TemplateBillpay);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Invoice_TemplateVeriable);
			Thread.sleep(2000);
			WebClick(EdaatOR.Biller_Invoice_Add);
			if(InvoiceType.equalsIgnoreCase("Recurring"))
				WebClickUsingJS(EdaatOR.Biller_Invoice_Templatetype);
			else
				WebClickUsingJS(EdaatOR.Biller_Invoice_Templatetype_One);              	
			Thread.sleep(2000);
			     WebClickUsingJS(EdaatOR.Biller_Individualclient_togle );
					Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Invoice_Add);
			boolean Ele=BillerSearchtemplate(TemplateEnglish);
			if(Ele==true) {
				test.log(Status.PASS,"#FUNC-Search Template" + driver.getTitle() +" * Search Template PASS * " );

			}else
				test.log(Status.FAIL,"#FUNC-Search Template" + driver.getTitle() +" * Search Template FAIL * " );
			this.takeScreenShot();

			Thread.sleep(1000);
			
		test.log(Status.PASS,"#FUNC-Add New Template client" + driver.getTitle() +" *Add New Template PASS * " );
    	Log.ReportEvent("PASS", " Verify Add Invoice Template is Suceessful");

		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add New Template client" + driver.getTitle() +" * Add New Template client FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary : Method to Search Invoice Template
	//Parameter Summary: InvoiceType
	public boolean BillerSearchtemplate(String InvoiceType){
		boolean existsElement = false;
		try{

			WebEdit(EdaatOR.Biller_Individualclient_Name,InvoiceType);
			WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
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
		//Function Summary   : Method to add product in Product management Section.
		//Parameter Summary : ProdArabic,ProdEnglish,Category,BasicPrice.

	public void AddProduct(String ProdArabic,String ProdEnglish,String Category,String BasicPrice,String ReferenceCode){
		try{
			WebClickUsingJS(EdaatOR.Biller_Settings);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Add_Product);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Prod_Addbutton);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_Prod_NameArabic,ProdArabic);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Invoice_TemplateEng,ProdEnglish);  
			Thread.sleep(1000);
			WebSelect1(EdaatOR.Biller_Invoice_Select,Category);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_ProdReferenceCode, ReferenceCode);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Prod_Price,BasicPrice);  
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Biller_Invoice_Add);
			test.log(Status.PASS,"#FUNC-Add Product Successful" + driver.getTitle() +" * Add Product Successful PASS * " );
		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add Product Not Successful" + driver.getTitle() +" * Add Product Successful FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to Navigate invoice template in settings module.
	//Parameter Summary : N/A.
	public void navigateTemplate(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(200);
		WebClickUsingJS(EdaatOR.Biller_Add_Invoice_template);
		Thread.sleep(2000);
    	Log.ReportEvent("PASS", " Verify Invoice Template Page Is Displayed Successfully");


	}

	//Function Summary   : Method to Verify Invoice template fields in Invoice Template Popup.
	//Parameter Summary : AddTemplateHeadr.
	public void verfiyInvoiceTemplateVariables(Map<Object,Object>testdatamap,Log Log) throws Exception {
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Add_Invoice_Button);
		Thread.sleep(2000);
		VerifyValue1(getText(EdaatOR.Biller_Tamplate_AddTitleHdr), testdatamap.get("AddTemplateHeadr").toString());
		Thread.sleep(2000);
		verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddTemplNameArbicHdr);
		verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddTemplNameEngHdr);
		verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddRefercodeHdr);
		verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddActDdeacHdr);
		verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddBillPaymentyHdr);
		Thread.sleep(2000);
    	Log.ReportEvent("PASS", " Verify Invoice Template is Variable Suceessfull");

	}


	public void verfiyViewInvoiceTemplate(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Tamplate_Table+"[1]"+EdaatOR.Biller_Tamplate_UpdateBtn);
			Thread.sleep(2000);
			ValidateTwoValue(getText(EdaatOR.Biller_Tamplate_UpdateTitleHdr), testdatamap.get("VeiwTempleteHeader").toString());
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_UpdateDesHdr);
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_UpdateInVTyeHdr);
			test.log(Status.PASS,"#FUNC-View Invoice Template" + driver.getTitle() +" * Add Individual client PASS * " );
        	Log.ReportEvent("PASS", " Verify Invoice Template is Variable Suceessfull");

		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-View Invoice Template" + driver.getTitle() +" * Add Individual client FAIL * " );
			this.takeScreenShot();
		}
	}

	//Function Summary   : Method to Verify Delete Invoice template button in Grid View.
	//Parameter Summary : DeleteConfirmMes.
	public void verfiyDeleteInvoiceTemplate(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Tamplate_Table+"[1]"+EdaatOR.Biller_Tamplate_DeleteBtn);
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_Tamplate_DeletePop), testdatamap.get("DeleteConfirmMes").toString());
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_DeleteConfBtn);
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_DeleteNoBtn);
			test.log(Status.PASS,"#FUNC-Delete Invoice Template" + driver.getTitle() +" * Add Individual client PASS * " );
        	Log.ReportEvent("PASS", " Verify Invoice Template is Deleted Suceessfull");

		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Delete Invoice Template" + driver.getTitle() +" * Add Individual client FAIL * " );
			this.takeScreenShot();
		}
	}

	public void verifyInvoiceTemplateDetails(Map<Object,Object>testdatamap,Log Log) throws Exception {
		String TemName=testdatamap.get("ActionTemplate").toString();
		switch(TemName) {

		case "Template":
			verfiyInvoiceTemplateVariables(testdatamap,Log);
			break;

		case "View":
			verfiyViewInvoiceTemplate(testdatamap,Log);
			break;

		case "Delete":
			verfiyDeleteInvoiceTemplate(testdatamap,Log);
			break;
		}

	}
	//Function Summary   : Method to Navigate Product management section in Settings Module.
	//Parameter Summary : Create Invoice,TemplateName.
	public void navigateProduct(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Add_Product);
		Thread.sleep(2000);
    	Log.ReportEvent("PASS", " Verify Product Management is Page dispayed Suceessfull");

	}

	public void EnterProductInputBox(String pname) {
		if(!pname.equalsIgnoreCase(""))
			WebEdit(EdaatOR.Biller_Product_NameInput, pname);
	}

	public void SelectIdProductListBox(String lstname) {
		if(!lstname.equalsIgnoreCase(""))
			WebSelect1(EdaatOR.Biller_Product_SearchIDlist, lstname);
	}

	public void ClickOnSearchBtn() {
		WebClick(EdaatOR.Biller_Product_SeachBtn);
	}
	//Function Summary   : Method to Add product,Search product by Name and Category and active product.
	//Parameter Summary : ProdArabic,ProdEnglish,Category,Active.

	public void verifyActiveProductFunctionality(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
		try {
			AddProduct(testdatamap.get("ProdArabic").toString(),testdatamap.get("ProdEnglish").toString(),testdatamap.get("Category").toString(),testdatamap.get("BasicPrice").toString(),testdatamap.get("ReferenceCode").toString());
	//		verifyElementIsPresent(EdaatOR.Biller_Product_ToggleBtn);
			String pName=testdatamap.get("SearchProdName").toString();
			String pCate=testdatamap.get("SearchProdCateg").toString();
			Thread.sleep(2000);
			EnterProductInputBox(pName);
			SelectIdProductListBox(pCate);
			ClickOnSearchBtn();
			Thread.sleep(5000);
			WebClickUsingJS(EdaatOR.Biller_Product_ToggleBtn);
			Thread.sleep(5000);
			VerifyValue1(getText(EdaatOR.Biller_Product_ActivePop), testdatamap.get("Active").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Product_ActiveConfbtn);
			Thread.sleep(2000);
			takeScreenShot();
			test.log(Status.PASS,"#FUNC-Add product and active Template" + driver.getTitle() +" * Product Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify Product Management Active/Deactivate functionality Is Suceessfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add product and active Template" + driver.getTitle() +" * Product Management FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to Add product,Search product by Name and Category and deactive product.
	//Parameter Summary : ProdArabic,ProdEnglish,Category,Active,Deactive.
	
	public void verifyDeActiveProductFunctionality(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
		try {
			AddProduct(testdatamap.get("ProdArabic").toString(),testdatamap.get("ProdEnglish").toString(),testdatamap.get("Category").toString(),testdatamap.get("BasicPrice").toString(),testdatamap.get("ReferenceCode").toString());
		//	verifyElementIsPresent(EdaatOR.Biller_Product_ToggleBtn);
				String pName=testdatamap.get("SearchProdName").toString();
			String pCate=testdatamap.get("SearchProdCateg").toString();
			EnterProductInputBox(pName);
			SelectIdProductListBox(pCate);
			ClickOnSearchBtn();
			Thread.sleep(5000);
			WebClickUsingJS(EdaatOR.Biller_Product_ToggleBtn);
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_Product_ActivePop), testdatamap.get("Active").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Product_ActiveConfbtn);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Product_ToggleBtn);
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_Product_ActivePop), testdatamap.get("Deactive").toString());
			WebClickUsingJS(EdaatOR.Biller_Product_ActiveConfbtn);
			test.log(Status.PASS,"#FUNC-Add product and De-active Template" + driver.getTitle() +" * Product Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify Product Management Active/Deactivate functionality Is Suceessfull");

		}


		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add product and De-active Template" + driver.getTitle() +" * Product Management FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to Search product by Name and Category if it's not present add product.
	//Parameter Summary : SearchProdName,SearchProdCateg,ProdArabic,pName,pCate,BasicPrice.

	public void verifySearchFunctionality(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
		try {
			String pName=testdatamap.get("SearchProdName").toString();
			String pCate=testdatamap.get("SearchProdCateg").toString();
			EnterProductInputBox(pName);
			SelectIdProductListBox(pCate);
			ClickOnSearchBtn();
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Biller_Product_NoData)==true) {
				AddProduct(testdatamap.get("ProdArabic").toString(),pName,pCate,testdatamap.get("BasicPrice").toString(),testdatamap.get("ReferenceCode").toString());
				EnterProductInputBox(pName);
				SelectIdProductListBox(pCate);
				ClickOnSearchBtn();
			}

//			List<WebElement> listTable=driver.findElements(By.xpath(EdaatOR.Biller_Product_Table));
//			for(int i=0;i<listTable.size();i++) {
//				int j=i+0;
//				if(!pName.equalsIgnoreCase("")) {
					Thread.sleep(3000);
					VerifyValue1(getText(EdaatOR.Biller_Product_Table+"[1]/td[3]"), pName);
//				}else if(!pCate.equalsIgnoreCase("")) {
//					VerifyValue1(getText(EdaatOR.Biller_Product_Table+"["+j+"]/td[4]"), pCate);
//				}
//			}

			test.log(Status.PASS,"#FUNC-Search Product Template" + driver.getTitle() +" * Product Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify Product Management Deleted and Active/Deactivate functionality Is Suceessfull");

		}
		catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Search Product Template" + driver.getTitle() +" * Product Management FAIL * " );
			this.takeScreenShot();
		}
	}
	
	//Function Summary   : Method to Attach Excel.
	//Parameter Summary  : N/A.	
	public void  getAutoItImagePathFile() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//Upload Bills cancellation.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(800);
	}
	
//Function Summary  : Method to upload Bulk data for bills cancellation.
//Parameter Summary : N/A

		public void VerifyUploadBulkData(Log Log) throws IOException, Exception {
			try {
				WebClickUsingJS(EdaatOR.Biller_Settings);
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Biller_BillsCancellation);
				Thread.sleep(800);
				WebClickUsingActions(EdaatOR.Biller_AttachExcel);
				Thread.sleep(800);
				getAutoItImagePathFile();
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Biller_ProcessBtn);
				Thread.sleep(800);
				takeScreenShot();
				verifyElementIsPresent(EdaatOR.Biller_SuccessfulMsg);
				test.log(Status.PASS,"#FUNC-Upload Bulk data for bills Cancel " + driver.getTitle() +" * Upload bulk data PASS * " );	
				Log.ReportEvent("PASS", " Verify  Upload bulk data for bills cancellation is Sucessfull");
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Upload bulk data " + driver.getTitle() +" * Upload bulk data FAIL * " );
				this.takeScreenShot();
			}
		}
		//Function Summary  : Method to Navigate to Settings Content Management
	//Parameter Summary : N/A
		public void NavigatetoSettingsContentManagement(Log Log) throws InterruptedException
		{
			WebClickUsingJS(EdaatOR.Biller_Settings);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Settings_contentMng);
			Thread.sleep(1000);
  			Log.ReportEvent("PASS", " Verify Navigate to Settings Content Management is Suceessfull");

		}
	//Function Summary  : Method to gettheAutoItFilepath
	//Parameter Summary : N/A
		public void gettheAutoItFilepath() throws IOException, InterruptedException {
			File classpathRoot = new File(System.getProperty("user.dir"));
			Thread.sleep(800);
			File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//BillerSettingsContentManagement.exe");
			String sFilename = app.toString();
			Thread.sleep(1000);
			Runtime.getRuntime().exec(sFilename);
			Thread.sleep(800);		
		}
		//Function Summary  : Method to VerifyToUploadBulkData
		//Parameter Summary : N/A
		public void VerifyToUploadBulkData(Map<Object, Object> testdatamap,Log Log) throws InterruptedException
			{
				try
				{
					WebClickUsingActions(EdaatOR.Biller_AttachExcel);
					Thread.sleep(800);
					gettheAutoItFilepath();
					Thread.sleep(2000);
					WebClick(EdaatOR.Biller_Settings_Content_src);
					Thread.sleep(2000);
					VerifyValue1(getText("//span[text()='"+testdatamap.get("Upload").toString()+"']"),testdatamap.get("Upload").toString());
					this.takeScreenShot();
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
					Thread.sleep(2000);
					WebEdit(EdaatOR.Biller_Individualclient_IdNumber,testdatamap.get("NationalID").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Biller_Individualclient_CustomerRefNumber,testdatamap.get("ClientReferenceNumber").toString());
		        	Thread.sleep(1000);
		        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
		        	Thread.sleep(5000);
		        	this.takeScreenShot();
		        	VerifyValue1(getText(EdaatOR.Biller_SettingContentMngVerifyNationalid),testdatamap.get("NationalID").toString());
		        	Thread.sleep(5000);
		        	this.takeScreenShot();
		        	VerifyValue1(getText(EdaatOR.Biller_SettingContentMngVerifyRefnoid),testdatamap.get("ClientReferenceNumber").toString());
		        	Thread.sleep(2000);
		        	WebClickUsingJS(EdaatOR.Biller_Add_Product);
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Product_NameInput, testdatamap.get("ProductName").toString());
		        	Thread.sleep(1000);
		        	//WebSelect1(EdaatOR.Biller_Product_SearchIDlist,testdatamap.get("Category").toString());
		        	Thread.sleep(1000);
		        	WebClick(EdaatOR.Biller_Product_SeachBtn);
		        	Thread.sleep(1000);
		        	this.takeScreenShot();
		        	VerifyValue1(getText("//td[text()='"+testdatamap.get("ProductName").toString()+"']"),testdatamap.get("ProductName").toString());
		        	Thread.sleep(1000);
		        	this.takeScreenShot();
					test.log(Status.PASS,"#FUNC-Verify to upload Bulk data " + driver.getTitle() +" * Content Management PASS * " );	
		  			Log.ReportEvent("PASS", " Verify to upload Bulk data is Suceessfull");

				}
				catch (Exception e) {
				
					test.log(Status.FAIL,"#FUNC-Verify to upload Bulk data " + driver.getTitle() +" * Content Management FAIL * " );	
				}
			}

		//Function Summary  : Method to Verify Add Product Error Msg
		//Parameter Summary : ExpectedResult
		public void AddProductErrorMessageValidation(Map<Object,Object>testdatamap) throws IOException, Exception {
			AddProduct(testdatamap.get("ProdArabic").toString(),testdatamap.get("ProdEnglish").toString(),testdatamap.get("Category").toString(),testdatamap.get("BasicPrice").toString(),testdatamap.get("ReferenceCode").toString());
			String Expected=testdatamap.get("ExpectedResult").toString();
			try {
				    if(ExistsCheck(EdaatOR.Biller_Settings_ProArabicNameError)) {
					VerifyValue(Expected,EdaatOR.Biller_Settings_ProArabicNameError);
					test.log(Status.PASS, "#FUNC-Product Management Product Name Error Message Exists" + driver.getTitle() + " * Product Management Product Name Error Message Exists * ");	    	
			     }
				else if(ExistsCheck(EdaatOR.Biller_Settings_ProEngNameError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_ProEngNameError);
					test.log(Status.PASS, "#FUNC-Product Management Product Name Error Message Exists" + driver.getTitle() + " * Product Management Product Name Error Message Exists * ");
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_ProductCategoryError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_ProductCategoryError);
					test.log(Status.PASS, "#FUNC-Product Management Product Category Error Message Exists" + driver.getTitle() + " * Product Management Product Category Error Message Exists * ");
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_ProductBasePriceError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_ProductBasePriceError);
					test.log(Status.PASS, "#FUNC-Product Management Product BasePrice Error Message Exists" + driver.getTitle() + " * Product Management Product BasePrice Error Message Exists * ");
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_ProArabicNameError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_ProArabicNameError);
					test.log(Status.PASS, "#FUNC-Product Management Product Name Error Message Exists" + driver.getTitle() + " * Product Management Product BasePrice Error Message Exists * ");
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_ProductReferenceCodeError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_ProductReferenceCodeError);
					test.log(Status.PASS, "#FUNC-Product Management Product ReferenceCode Error Message Exists" + driver.getTitle() + " * Product Management Product ReferenceCode Error Message Exists * ");
				}
				else {

					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
					  }
			}


			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Add product and De-active Template" + driver.getTitle() +" * Product Management FAIL * " );
				this.takeScreenShot();
			}
		}
		//Function Summary  : Method to Upload Invalid BulkData
		//Parameter Summary : FileType,Invalid

		public void ContentMgmUploadBulkData(Map<Object, Object> testdatamap) throws InterruptedException
		{
			try
			{
				String File = testdatamap.get("FileType").toString();
				if(File.equalsIgnoreCase("Invalid")) {
					WebClickUsingActions(EdaatOR.Biller_AttachExcel);
					Thread.sleep(800);
					getAutoItImagePathFile1();
				}
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Settings_Content_src);
				Thread.sleep(2000);
				this.takeScreenShot();
				Thread.sleep(2000);
				test.log(Status.PASS,"#FUNC-Verify to upload Bulk data " + driver.getTitle() +" * Content Management PASS * " );	
			}
			catch (Exception e) {
			
				test.log(Status.FAIL,"#FUNC-Verify to upload Bulk data " + driver.getTitle() +" * Content Management FAIL * " );	
			}
		}
		public void  getAutoItImagePathFile1() throws Exception {
			File classpathRoot = new File(System.getProperty("user.dir"));
			Thread.sleep(800);
			File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//ImageUpload.exe");
			String sFilename = app.toString();
			Thread.sleep(1000);
			Runtime.getRuntime().exec(sFilename);
			Thread.sleep(800);
		}
		//Function Summary  : Method to Verify ContentMgmErrorMessage
		//Parameter Summary : ExpectedResult
		public void ContentMgmErrorMessageValidation(Map<Object, Object> testdatamap) throws InterruptedException
		{
			ContentMgmUploadBulkData(testdatamap);
			String Expected=testdatamap.get("ExpectedResult").toString();
			try
			{
				if(ExistsCheck(EdaatOR.Biller_Settings_ContentMgmSelectFileError)) {
					VerifyValue(Expected,EdaatOR.Biller_Settings_ContentMgmSelectFileError);
					test.log(Status.PASS, "#FUNC-Content Management Product Upload BulkData Error Message Exists" + driver.getTitle() + " * Content Management Product Upload BulkData Error Message Exists * ");	    	
			     }
				else if(ExistsCheck(EdaatOR.Biller_Settings_ContentMgmInvalidFileError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_ContentMgmInvalidFileError);
					test.log(Status.PASS, "#FUNC-Content Management Product Upload BulkData Error Message Exists" + driver.getTitle() + " * Content Management Product Upload BulkData Error Message Exists * ");
				}	
				else {

					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
					  }
			}
			catch (Exception e) {
			
				test.log(Status.FAIL,"#FUNC-Content Management Verify to upload Bulk data " + driver.getTitle() +" * Content Management Verify to upload Bulk data FAIL * " );	
			}
		

	
}
		//Function Summary  : Method to Upload Invalid BulkData
		//Parameter Summary : FileType,Invalid
		public void BillsCancelationUploadBulkData(Map<Object, Object> testdatamap) throws InterruptedException
		{
			try
			{
				WebClickUsingJS(EdaatOR.Biller_Settings);
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Biller_BillsCancellation);
				Thread.sleep(800);
				String File = testdatamap.get("FileType").toString();
				if(File.equalsIgnoreCase("Invalid")) {
					WebClickUsingActions(EdaatOR.Biller_AttachExcel);
					Thread.sleep(800);
					getAutoItImagePathFile1();
				}
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_ProcessBtn);
				Thread.sleep(2000);
				this.takeScreenShot();
				Thread.sleep(2000);
				test.log(Status.PASS,"#FUNC-Verify to upload Bulk data " + driver.getTitle() +" * Content Management PASS * " );	
			}
			catch (Exception e) {
			
				test.log(Status.FAIL,"#FUNC-Verify to upload Bulk data " + driver.getTitle() +" * Content Management FAIL * " );	
			}
		}
		//Function Summary  : Method to Verify BillsCancelationErrorMessage
		//Parameter Summary : Expected
		public void BillsCancelationErrorMessageValidation(Map<Object, Object> testdatamap) throws InterruptedException
		{
			BillsCancelationUploadBulkData(testdatamap);
			String Expected=testdatamap.get("ExpectedResult").toString();
			try
			{
				if(ExistsCheck(EdaatOR.Biller_Settings_BillsCancelationSelectFileError)) {
					VerifyValue(Expected,EdaatOR.Biller_Settings_BillsCancelationSelectFileError);
					test.log(Status.PASS, "#FUNC-Bills Cancelation Upload BulkData Error Message Exists" + driver.getTitle() + " * Bills Cancelation  Upload BulkData Error Message Exists * ");	    	
			     }
				else if(ExistsCheck(EdaatOR.Biller_Settings_BillsCancelationInvalidFileError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_BillsCancelationInvalidFileError);
					test.log(Status.PASS, "#FUNC-Bills Cancelation Product Upload BulkData Error Message Exists" + driver.getTitle() + " * Bills Cancelation Upload BulkData Error Message Exists * ");
				}	
				else {

					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
					  }
			}
			catch (Exception e) {
			
				test.log(Status.FAIL,"#FUNC-Bills Cancelation Verify to upload Bulk data " + driver.getTitle() +" * Bills Cancelation Verify to upload Bulk data FAIL * " );	
			}
}
		//Function Summary  : Method to Verify Add Invoice Template
		//Parameter Summary : TemplateArabic,TemplateEnglish,TemplateDescription,TemplateReferancecode
		public void AddInvoicetemplateUI(Map<Object, Object> testdatamap){
			try{
				WebClickUsingJS(EdaatOR.Biller_Settings);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Add_Invoice_template);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Add_Invoice_Button);
				Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_Invoice_TemplateArabic,testdatamap.get("TemplateArabic").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Invoice_TemplateEng,testdatamap.get("TemplateEnglish").toString());  
				Thread.sleep(1000);
				
				//i added these three
				WebEdit(EdaatOR.Biller_Invoice_TemplateDisc,testdatamap.get("TemplateDescription").toString());  
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Invoice_TemplateRefcode,testdatamap.get("TemplateReferancecode").toString());  
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Invoice_Templateactideacti);  
				Thread.sleep(1000);
		
			//	i added these two
				WebClickUsingJS(EdaatOR.Biller_Invoice_TemplateBillpay);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Invoice_TemplateVeriable);
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Invoice_Add);
				String Invoice = testdatamap.get("InvoiceType").toString();
				if(Invoice.equalsIgnoreCase("Recurring")) 
					WebClickUsingJS(EdaatOR.Biller_Invoice_Templatetype);
				//else
			    //WebClickUsingJS(EdaatOR.Biller_Invoice_Templatetype_One);
				
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS,"#FUNC-Add New Template client" + driver.getTitle() +" *Add New Template PASS * " );
			}catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Add New Template client" + driver.getTitle() +" * Add New Template client FAIL * " );
				this.takeScreenShot();
			}
		}
		
		//Function Summary  : Method to Verify AddInvoiceTemplateErrorMessage
		//Parameter Summary : Expected
		public void AddInvoiceTemplateErrorMessageValidation(Map<Object, Object> testdatamap) throws InterruptedException
		{
			
			try
			{
				AddInvoicetemplateUI(testdatamap);
				String Expected=testdatamap.get("ExpectedResult").toString();
				if(ExistsCheck(EdaatOR.Biller_Settings_TemplateArabicNameError)) {
					VerifyValue(Expected,EdaatOR.Biller_Settings_TemplateArabicNameError);
					test.log(Status.PASS, "#FUNC-Settings Add Template Error Message Exists" + driver.getTitle() + " * Settings Add Template Upload BulkData Error Message Exists * ");	    	
			     }
				else if(ExistsCheck(EdaatOR.Biller_Settings_TemplateEngNameError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_TemplateEngNameError);
					test.log(Status.PASS, "#FUNC-Settings Add Template Error Message Exists" + driver.getTitle() + " * Settings Add Template Error Message Exists * ");
				}	
				else if(ExistsCheck(EdaatOR.Biller_Settings_TemplateInvoiceTypeError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_TemplateInvoiceTypeError);
					test.log(Status.PASS, "#FUNC-Settings Add Template Error Message Exists" + driver.getTitle() + " * Settings Add Template Error Message Exists * ");
				}	
				else {

					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
					  }
			}
			catch (Exception e) {
			
				test.log(Status.FAIL,"#FUNC-Settings Verify to Add Template " + driver.getTitle() +" * Settings  Verify to Add Template FAIL * " );	
			}
}
}