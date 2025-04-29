/**
 *
 * Test Script Name                   :N/A
 * Objective                          :Admin SystemManagement Functionality
 * Version                            :1.0
 * Author                             :Kathirvelu Mohan
 * Created Date                       :8/09/2023
 * Last Updated on                    :N/A
 * Updated By                         :Dhruva Kumar S
 * Pre-Conditions                     :N/A
 * Epic Details                       :N/A
 * User Story Details                 :N/A
 **/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class AdminSystemMangement extends BasePage {

	public AdminSystemMangement(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Systemmgmt_Menu)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}
	//Function Summary  :To search tax and verify it on grid view.
	//Parameter Summary : Category.	
	public void TableGridviewTax(String taxName,Log Log){
		try{
			if(CheckElementExists(EdaatOR.Admin_taxTable)) {
				Thread.sleep(2000);
				WebClear(EdaatOR.Admin_TaxSearch);
				WebEdit(EdaatOR.Admin_TaxSearch,taxName);        			
				WebClick(EdaatOR.Admin_SearchCat);
				if(getText("//td[text()='"+taxName+"']").equals(taxName)) {
					Log.ReportEvent("PASS", "Grid View Functionality is Successful");
				}
				else {
					Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");   
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			else {
				Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");   
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");       	
			this.takeScreenShot();	
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to navigate to product category 
	//Parameter Summary  : N/A
	public void navigateSystemMangementProductCategory(Log Log) throws Exception {
		try {
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Prod_Category);
			Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.Admin_Prod_Category_header)) {
				Log.ReportEvent("PASS", "Products Categories Page is Loaded Successfully");	
			}
			else {
				Log.ReportEvent("FAIL", "Products Categories Page is Not Loaded Successfully");
				this.takeScreenShot();	
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Products Categories Page is Not Loaded Successfully");
			this.takeScreenShot();	
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to navigate to Tax management page 
	//Parameter Summary : N/A
	public void navigateSystemMangementTax(Log Log) throws Exception {

		try {
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Tax_Mgmt);
			if(CheckElementExists(EdaatOR.Admin_Sytemmanagement_tax)) {
				Log.ReportEvent("PASS", "Taxes Management Page is Loaded Successfully");			
			}
			else {
				Log.ReportEvent("FAIL", "Taxes Management Page is Not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Taxes Management Page is Not Loaded Successfully");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary  : //To Search a Tax, activate and deactivate toggle
	//Parameter Summary : Enter TaxEnglish and searchstr.
	public void ActivateDactivate(Map<Object, Object>testdatamap,Log Log){
		try{	
			String searchstr=testdatamap.get("TaxEnglish").toString();
			WebEdit(EdaatOR.Admin_TaxEng,searchstr);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Tax_Search);
			if(getText("//td[text()='"+searchstr+"']").equals(searchstr)) {
				ExistsCheck("//td[text()='"+searchstr+"']");
				verifyElementIsPresent(EdaatOR.Admin_Tax_ToggleBtn);
				WebClickUsingJS(EdaatOR.Admin_Tax_ToggleBtn);
				Thread.sleep(1000);	
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Tax_ToggleBtn);
				Thread.sleep(1000);
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("InActive").toString());
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Thread.sleep(2000);		
				Log.ReportEvent("PASS", "Activate/De-Activate Functionality Is Successful");	
			}
			else {
				Log.ReportEvent("FAIL", "Activate/De-Activate Functionality Is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		}catch(Exception e){
			Log.ReportEvent("FAIL", "Activate/De-Activate Functionality Is UnSuccessful");	
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to TableGridview
	//Parameter Summary  : Category
	public void productCategoryTableGridview(String Category,Log Log){
		try{
			if(CheckElementExists(EdaatOR.Admin_CatTable)) {
				WebClear(EdaatOR.Admin_UpdateSearch);
				WebEdit(EdaatOR.Admin_UpdateSearch,Category);        			
				WebClick(EdaatOR.Admin_SearchCat);
				if(getText("//td[text()='"+Category+"']").equals(Category)) {
					Log.ReportEvent("PASS", "Grid View Functionality is Successful");
				}
				else {
					Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");   
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			else {
				Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");   
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");       	
			this.takeScreenShot();	
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary  : To add and update category.
	//Parameter Summary : Enter ProdEnglish,UpdateProdEnglish,UpdateProdArabic and UpdateProdEnglish
	public void EditProductCategory(Map<Object,Object> testdatamap,Log Log){
		try{
			Addcat(testdatamap);
			if(CheckElementExists(EdaatOR.Admin_Prod_CatEngError) ||
					CheckElementExists(EdaatOR.Admin_Prod_CatArError) ) {
				Log.ReportEvent("FAIL", "Add Product Category Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			else {
				WebEdit(EdaatOR.Admin_UpdateSearch,testdatamap.get("ProdEnglish").toString());
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_Search);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_Updatebtn);	
				Thread.sleep(1000);
				WebClear(EdaatOR.Admin_Prod_CatEng);
				WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("UpdateProdEnglish").toString());
				Thread.sleep(1000);
				WebClear(EdaatOR.Admin_Prod_CatArabic);
				WebEdit(EdaatOR.Admin_Prod_CatArabic,testdatamap.get("UpdateProdArabic").toString());
				WebClickUsingJS(EdaatOR.Admin_UpdateCat);
				if (CheckElementExists(EdaatOR.Admin_Prod_CatEngError) ||
						CheckElementExists(EdaatOR.Admin_Prod_CatArError)) {
					Log.ReportEvent("FAIL", "Edit Product Category Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				else {				
					WebEdit(EdaatOR.Admin_UpdateSearch,testdatamap.get("UpdateProdEnglish").toString());
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Admin_Search);
					VerifyValue1(getText("//td[text()='"+testdatamap.get("UpdateProdEnglish").toString()+"']"),testdatamap.get("UpdateProdEnglish").toString());
					Log.ReportEvent("PASS", "Edit Product Category Functionality is Successful");					
				}
			}		
		}catch (Exception e) {
			Log.ReportEvent("FAIL", "Edit Product Category Functionality is UnSuccessful");		
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary  : Method to click on Add category
	//Parameter Summary : N/A
	public void addCategoryDetails() throws Exception {
		ClickOnProductBtn();
		Thread.sleep(500);
	}
	//Function Summary  : To click on add button.
	//Parameter Summary : N/A.
	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Admin_Cat_Addbtn);
		waitForPageToLoad();
	}
	//Function Summary   :To click on Add tax button
	//Parameter Summary  :N/A
	public void addTaxdeatails() throws Exception {
		ClickOnTaxBtn();
		Thread.sleep(500);
	}
	public void ClickOnTaxBtn() {
		WebClickUsingJS(EdaatOR.Admin_Tax_Addbtn);
		waitForPageToLoad();
	}

	//Function Summary  : Method to Add product category
	//Parameter Summary : Product name
	public void Addcat(Map<Object,Object> testdatamap){
		try{
			addCategoryDetails();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("ProdEnglish").toString());  
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_CatArabic,testdatamap.get("ProdArabic").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Add_Cat);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Function Summary   : To Add a tax
	//Parameter Summary  :Enter TaxEnglish,TaxArabic,RefCode and Percentage
	public void AddTax(Map<Object,Object> testdatamap,Log Log){

		try{
			addTaxdeatails();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("TaxEnglish").toString());  
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_taxArabic,testdatamap.get("TaxArabic").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("RefCode").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_PercentageValue,testdatamap.get("Percentage").toString());
			Thread.sleep(1000);
			if(testdatamap.get("Activate").toString().equalsIgnoreCase("yes")) {
				WebClickUsingJS(EdaatOR.Admin_Status);
			}
			WebClickUsingJS(EdaatOR.Admin_Add_tax);
			if (CheckElementExists(EdaatOR.Admin_Add_TaxErrorMsg) 
					|| CheckElementExists(EdaatOR.Admin_Add_TaxErrorMsgArabic) || 
					CheckElementExists(EdaatOR.Admin_TaxMngRefrenceCodeError) ||
					CheckElementExists(EdaatOR.Admin_TaxMngRefrenceCodeUseError) || 
					CheckElementExists(EdaatOR.Admin_TaxMngPercentageError) ) {				
				Log.ReportEvent("FAIL", "Add Tax Functionality Is UnSuccessful"); 
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			} else {
				WebEdit(EdaatOR.Admin_TaxEng,testdatamap.get("TaxEnglish").toString());
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_Tax_Search);
				Thread.sleep(1000);
				VerifyValue1(getText("//td[text()='"+testdatamap.get("TaxEnglish").toString()+"']"),testdatamap.get("TaxEnglish").toString());
				Thread.sleep(1000);
				Log.ReportEvent("PASS", "Add Tax Functionality Is Successful"); 
			} 	
		}catch (Exception e) {
			Log.ReportEvent("FAIL", "Add Tax Functionality Is UnSuccessful"); 
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();

		}
	}
	//Function Summary  : To add category
	//Parameter Summary : NA.
	public void AddCategory(Map<Object,Object> testdatamap,Log Log){
		try{
			Addcat(testdatamap);
			if(CheckElementExists(EdaatOR.Admin_Prod_CatEngError) ||
					CheckElementExists(EdaatOR.Admin_Prod_CatArError) ) {
				Log.ReportEvent("FAIL", "Add Product Category Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}else {
				WebEdit(EdaatOR.Admin_Prod_CatEnglish,testdatamap.get("ProdEnglish").toString());
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
				VerifyValue1(getText("//td[text()='"+testdatamap.get("ProdEnglish").toString()+"']"),testdatamap.get("ProdEnglish").toString());
				Log.ReportEvent("PASS", "Add Product Category Functionality Is Successful");
			}
		}catch(Exception e){
			Log.ReportEvent("FAIL", "Add Product Category Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary  : Method to Search product category and verify it exists
	//Parameter Summary : Product category
	public void SearchCategory(Map<Object,Object> testdatamap,Log Log){
		try{
			String searchstr=testdatamap.get("ProdEnglish").toString();
			WebEdit(EdaatOR.Admin_Prod_CatEnglish,searchstr);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Prod_CatSrch);	
			if (CheckElementExists(EdaatOR.Admin_Prod_Nodata)) {	
				Log.ReportEvent("FAIL", "Search Product Category Functionality Is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			} else {
				VerifyValue1(getText("//td[text()='"+searchstr+"']"),searchstr);
				Log.ReportEvent("PASS", "Search Product Category Functionality Is Successful");
			}	
		}catch(Exception e){
			Log.ReportEvent("FAIL", "Search Product Category Functionality Is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary   : Method to navigate  to "Not approved billers management"
	//Parameter Summary : N/A
	public void navigateBillersUnderActivation(Log Log) throws Exception {

		try {
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement_Billers_Management);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_NoAppBillerMangm);
			Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.Admin_NoAppBillerMangm_Header)) {				
				Log.ReportEvent("PASS", "Billers Under Activation Page is Loaded Successfully");
			} else {
				Log.ReportEvent("FAIL", "Billers Under Activation Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}				
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Billers Under Activation Page is not Loaded Successfully");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}	
	}

	//Function Summary   : Method to navigateApprovedBillerManagement
	//Parameter Summary  : N/A
	public void navigateApprovedBillerManagement(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_ApproveBillerMangm);
			Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.Admin_ApproveBillerMangm_Header)) {					
				Log.ReportEvent("PASS","Approved Billers Page is Loaded Successfully");
			} else {
				Log.ReportEvent("FAIL","Approved Billers Page is Not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}				
		} catch (Exception e) {
			Log.ReportEvent("FAIL","Approved Billers Page is Not Loaded Successfully");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to searchforapprbiller
	//Parameter Summary  : CompanyName
	public void searchforapprbiller(Map<Object, Object> testdatamap,Log Log) throws InterruptedException 
	{
		try {
			enterOnSearchItem(testdatamap.get("CompanyName").toString());
			clickOnSearchBtn();
			waitForPageToLoad();
			Thread.sleep(3000);
			if (getText("//td[text()='"+testdatamap.get("CompanyName").toString()+"']").equals(testdatamap.get("CompanyName").toString())) {
				Log.ReportEvent("PASS", "Approved Billers Search Functionality is Successful");	
			} else {
				Log.ReportEvent("FAIL", "Approved Billers Search Functionality is UnSuccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Approved Billers Search Functionality is UnSuccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to clickOnSearchBtn
	//Parameter Summary  : N/A
	public void clickOnSearchBtn() {
		WebClick(EdaatOR.Admin_SystemMgm_Searchbtn);
	}
	//Function Summary   : Method to enterOnSearchItem
	//Parameter Summary  : searchItem
	public void enterOnSearchItem(String searchItem) {
		WebEdit(EdaatOR.Admin_SystemMgm_SearchItem, searchItem);
	}

	//Function Summary   : Method to  navigateTrackerBillerManagement
	//Parameter Summary  : N/A
	public void navigateTrackerBillerManagement(Log Log) throws Exception {

		try {
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_TrackerBillerMangm);
			Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.Admin_TrackerBillerMangm_Header)) {
				Log.ReportEvent("PASS", "Tracked Billers Page is Loaded Successfully");	

			} else {
				Log.ReportEvent("FAIL", "Tracked Billers Page is Not Loaded Successfully");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Tracked Billers Page is Not Loaded Successfully");	
			this.takeScreenShot();
			e.printStackTrace();	
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary   : Method to search tax and verify tax is displayed
	//Parameter Summary  : TaxEnglish.
	public void SearchTaxes(Map<Object,Object> testdatamap,Log Log){
		String searchstr=testdatamap.get("TaxEnglish").toString();
		try{
			WebEdit(EdaatOR.Admin_TaxEng,searchstr);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Tax_Search);
			if (getText("//td[text()='"+testdatamap.get("TaxEnglish").toString()+"']").equals(searchstr)) {
				Log.ReportEvent("PASS", "Search Functionality Is Successful");
			} else {
				Log.ReportEvent("FAIL", "Search Functionality Is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}catch(Exception e){
			Log.ReportEvent("FAIL", "Search Functionality Is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();	
			driver.quit();
			Assert.fail();
		}

	}
	//Function Summary   : Method to search tax and verify tax is displayed
	//Parameter Summary : Expected
	public void AddTaxErrorMsg(Map<Object, Object> testdatamap,Log Log) {

		try {
			addTaxdeatails();
			Thread.sleep(1000);
			String Expected = testdatamap.get("Expected").toString();
			WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("TaxEnglish").toString());  
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_taxArabic,testdatamap.get("TaxArabic").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("RefCode").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_PercentageValue,testdatamap.get("Percentage").toString());
			Thread.sleep(1000);
			if(testdatamap.get("Activate").toString().equalsIgnoreCase("yes")) {
				WebClickUsingJS(EdaatOR.Admin_Status);
			}
			WebClickUsingJS(EdaatOR.Admin_Add_tax);
			if(getText(EdaatOR.Admin_Tax_TaxEngError).equals(Expected)&&getText(EdaatOR.Admin_Tax_TaxArbError).equals(Expected)
					&&getText(EdaatOR.Admin_Tax_RefcodeError).equals(Expected)&&getText(EdaatOR.Admin_Tax_PercenError).equals(Expected))
			{				
				Log.ReportEvent("PASS", "Verify the Error Message for all the Required Fields is Successful");
			}
			else if (getText(EdaatOR.Admin_Tax_RefcodeExistsError).equals(Expected)) {			
				Log.ReportEvent("PASS", "Verify the Error Message for Existing Reference Code is Successful");
			}
			else if (getText(EdaatOR.Admin_Tax_TaxArbError).equals(Expected)) {			
				Log.ReportEvent("PASS", "Verify the Error Message for Invalid Tax Name in Arabic is Successful");
			}
			else if(getText(EdaatOR.Admin_Tax_PercenError).equals(Expected)) {			
				Log.ReportEvent("PASS", "Verify the Error Message for Percentage Field is Successful");
			}
			else
			{
				Log.ReportEvent("FAIL", "Verify Add Tax Error Message is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();	
			}			
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Add Tax Error Message is UnSuccessful");
			e.printStackTrace();
			takeScreenShot();
			driver.quit();
			Assert.fail();	

		}
	}
	//Function Summary  : Method to AddCategoryErrorMsg
	//Parameter Summary : Expected
	public void AddCategoryErrorMsg(Map<Object, Object> testdatamap,Log Log) {
		try {
			Addcat(testdatamap);
			String Expected = testdatamap.get("Expected").toString();
			if(getText(EdaatOR.Admin_Prod_CatArInvalidError).equals(Expected)){
				Log.ReportEvent("PASS", "Verify Error Message for Invalid Category Name in Arabic Field is Successful");
			}
			else if(getText(EdaatOR.Admin_Prod_CatEngError).equals(Expected)&&
					getText(EdaatOR.Admin_Prod_CatArError).equals(Expected)) {		
				Log.ReportEvent("PASS", "Verify the Error Message for all the Required Fields is Successful");
			}
			else {
				
				Log.ReportEvent("FAIL", "Verify Add Product Error Message is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();	
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Add Product Error Message is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();	
		}
	}

	//Function Summary  : Method to navigatePaymentProviderManagement
	//Parameter Summary : N/A
	public void navigatePaymentProviderManagement(Log Log) {
		try {	
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement_PaymentProviders_Management);
			if(CheckElementExists(EdaatOR.Admin_SystemMng_PaymentProviderMng_Page)) {
				Log.ReportEvent("PASS", "Payment Provider Management Page is Loaded Successfully");
			}
			else {
				Log.ReportEvent("Fail", "Payment Provider Management Page is Not Loaded Successfully");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("Fail", "Payment Provider Management Page is Not Loaded Successfully");
			e.printStackTrace();
			takeScreenShot();
			driver.quit();
			Assert.fail();			
		}
	}

	//Function Summary   : Method to ActivatePayment Methods Free activation status toggle
	//Parameter Summary  : PaymentsMethods
	public void VerifyActivatePaymentMethodFreeActivationStatusToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			WebClick("//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']//parent::td//parent::tr//td[9]//label");
			if (getText(EdaatOR.Admin_PaymentMng_ConfirmationPopupMessage).equals(testdatamap.get("Active").toString())){		
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_FreeActivationYesBtn);
				Log.ReportEvent("PASS","Fees Activation status Toggel is Active State");	
			} else if(getText(EdaatOR.Admin_PaymentMng_CancelPopupMessage).equals(testdatamap.get("InActive").toString())) {
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_FreeActivationNoBtn);
				Log.ReportEvent("PASS","Fees Activation Status Toggel is Active State");	
			}
			else {
				Log.ReportEvent("FAIL","Fees Activation Status Toggel is In-Active State");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();

			}
		}catch(Exception e)	{				
			Log.ReportEvent("FAIL","Fees Activation Status Toggel is In-Active State");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary  : Method to verifyPaymentProviderPageIsDisplayed
	//Parameter Summary : Expected
	public void verifyPaymentProviderManagementPageIsDisplayed(Map<Object, Object> testdatamap, Log Log) {
		try {
			String ActualValue=getText(EdaatOR.Admin_SystemMng_PaymentProviderMng_Page);				
			if(ActualValue.equals(testdatamap.get("Expected").toString())) {					
				Log.ReportEvent("PASS", "Verify New 'Payment Provider Management' Page is Added Functionality is Successful");
			}
			else {
				Log.ReportEvent("Fail", "Verify New 'Payment Provider Management' Page is Added Functionality is UnSuccessful" );
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("Fail", "Verify New 'Payment Provider Management' Page is Added Functionality is UnSuccessful" );
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}	
	}
	//Function Summary  : Method to navigatePaymentMethodManagement
	//Parameter Summary : N/A
	public void navigatePaymentMethodManagement(Log Log) {
		try {	
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng);
			if(CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodPage_Header))		
			{
				Log.ReportEvent("PASS", "Payment Method Management Page is Loaded Successfully");
			}
			else {
				Log.ReportEvent("FAIL", "Payment Method Management Page is Not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Payment Method Management Page is Not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary  : Method to click on edit button
	//Parameter Summary : PaymentMethod
	public void clickOnEditIconInPaymentMethodMgm(Map<Object, Object> testdatamap) throws InterruptedException {
		Thread.sleep(1000);
		WebClickUsingJS("(//td/a[text()='"+testdatamap.get("PaymentMethod").toString()+"']/../following::td/a[contains(@href,'EditPaymentMethod')])[1]");

	}
	//Function Summary  : Method to verifyPaymentMethodManagementGridViewDetails
	//Parameter Summary : EnglishColumn,ArabicColumn,StartDateColumn,EndDateColumn,FeesColumn,StatusColumn,FeesActivationColumn,PaymentProviderColumn,EditPaymentMethodColumn
	public void verifyPaymentMethodManagementGridViewDetails(Map<Object, Object> testdatamap, Log Log) {
		try {
			if(CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodPage_Header))
			{
				VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_EnglishName_Column),testdatamap.get("EnglishColumn").toString());
				VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_ArabicName_Column),testdatamap.get("ArabicColumn").toString());
				VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_StartDate_Column),testdatamap.get("StartDateColumn").toString());
				VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_EndDate_Column),testdatamap.get("EndDateColumn").toString());
				VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_Fees_Column),testdatamap.get("FeesColumn").toString());
				VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_Status_Column),testdatamap.get("StatusColumn").toString());
				VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesActivation_Column),testdatamap.get("FeesActivationColumn").toString());
				VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_PaymentProvider_Column),testdatamap.get("PaymentProviderColumn").toString());
				VerifyValue1(getText(EdaatOR.Admin_SystemMng_PaymentMethodMng_EditPaymentMethod_Column),testdatamap.get("EditPaymentMethodColumn").toString());
				Log.ReportEvent("PASS", "Verify the Grid View Details Functionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "Verify the Grid View Details Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify the Grid View Details Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();		}	
	}

	//Function Summary  : Method to click on save button
	//Parameter Summary : 
	public void clickOnSaveButtonInPaymentMethodMgm() throws InterruptedException {
		Thread.sleep(500);
		WebClick(EdaatOR.Admin_PaymentMethodMngEditFeesSaveButton);
	}

	//Function Summary  : Method to enterThePaymentProviderName
	//Parameter Summary : paymentProviderName
	public void enterThePaymentProviderName(String paymentProviderName) {
		WebEdit(EdaatOR.Admin_SystemMng_PaymentProvidersMng_PaymentProvider_efield, paymentProviderName);
	}
	//Function Summary  : Method to verify Edit Fees In Payment Method Page
	//Parameter Summary :PaymentMethod,FixedValue,Percentage
	public void verifyEditFeesInPaymentMethodPage(Map<Object, Object> testdatamap,Log Log) {
		try {	
			clickOnEditIconInPaymentMethodMgm(testdatamap);
			WebEdit(EdaatOR.Admin_PaymentMethodMngEditFeesEnglishName,testdatamap.get("EnglishName").toString());
			clickOnSaveButtonInPaymentMethodMgm();
			if (WebGetTextAttribute(EdaatOR.Admin_PaymentMethodMngEditFeesEnglishName).equals(testdatamap.get("EnglishName").toString())) {					
				Log.ReportEvent("PASS", "Edit Fees in Payment Method Page Functionality is Successful");
			} else {

				Log.ReportEvent("FAIL", "Edit Fees in Payment Method Page Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Edit Fees in Payment Method Page Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary  : Method to enterTheCrnumber
	//Parameter Summary : crNumber
	public void enterTheCrnumber(String crNumber) {
		WebEdit(EdaatOR.Admin_SystemMng_PaymentProvidersMng_Crnumber_efield, crNumber);
	}

	//Function Summary  : Method to enterCode
	//Parameter Summary : code
	public void enterCode(String code) {
		WebEdit(EdaatOR.Admin_SystemMng_PaymentProvidersMng_Code_efield, code);
	}

	//Function Summary  : Method to enterCode
	//Parameter Summary : code
	public void clickOnSearchButton() {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentProvidersMng_Search_btn);
	}

	//Function Summary  : Method to enterCode
	//Parameter Summary : code
	public void searchPaymentProvider(Map<Object, Object> testdatamap,Log Log) {
		try {
			enterThePaymentProviderName(testdatamap.get("PaymentProviderName").toString());
			enterTheCrnumber(testdatamap.get("CRNumber").toString());
			enterCode(testdatamap.get("Code").toString());
			clickOnSearchButton();
			Thread.sleep(3000);
			if (getText(EdaatOR.Admin_SystemMng_PaymentProvidersMng_paymentproviderName).equals(testdatamap.get("PaymentProviderName").toString())) {
				Log.ReportEvent("PASS", "Search Functionality is Successful");	
			} else {
				Log.ReportEvent("FAIL", "Search Functionality is UnSuccessful");	
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {			 
			Log.ReportEvent("FAIL", "Search Functionality is UnSuccessful");	
			e.printStackTrace();
			takeScreenShot();
			driver.quit();
			Assert.fail();	
		}
	}
	//Function Summary  : Method to verifyPaymentProvidersManagementGridViewDetails
	//Parameter Summary : EnglishColumn,ArabicColumn,ContactColumn,CRNumberColumn,CodeColumn
	public void verifyPaymentProvidersManagementGridViewDetails(Map<Object, Object> testdatamap, Log Log) {
		try {
			searchPaymentProvider(testdatamap,Log);
			Thread.sleep(3000);
			String actualEngNameHDR=getText(EdaatOR.Admin_SystemMng_PaymentProvidersMng_EnglishName_Column);
			String expEngNameHDR=testdatamap.get("EnglishColumn").toString();
			String actualARNameHDR=getText(EdaatOR.Admin_SystemMng_PaymentProvidersMng_ArabicName_Column);
			String expARNameHDR=testdatamap.get("ArabicColumn").toString();
			String actualConClmHDR=getText(EdaatOR.Admin_SystemMng_PaymentProvidersMng_Contact_Column);
			String expConClmHDR=testdatamap.get("ContactColumn").toString();
			String actualCRNoClm=getText(EdaatOR.Admin_SystemMng_PaymentProvidersMng_CrNumber_Column);
			String expCRNoClm=testdatamap.get("CRNumberColumn").toString();
			String actCodeClm=getText(EdaatOR.Admin_SystemMng_PaymentProvidersMng_Code_Column);
			String ExpCodeClm=testdatamap.get("CodeColumn").toString();
			if(actualEngNameHDR.equals(expEngNameHDR)&&actualARNameHDR.equals(expARNameHDR)&&
					actualConClmHDR.equals(actualConClmHDR)&&actualCRNoClm.equals(expCRNoClm)&&actCodeClm.equals(ExpCodeClm)) {					
				Log.ReportEvent("PASS", "Verify the Grid View for the Payment Providers Management Page Functionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "Verify the Grid View for the Payment Providers Management Page Functionality is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify the Grid View for the Payment Providers Management Page Functionality is UnSuccessful");
			e.printStackTrace();
			takeScreenShot();
			driver.quit();
			Assert.fail();		
		}
	}

	//Function Summary  : Method to clickOnEditPaymentMethod
	//Parameter Summary : PaymentMethodName
	public void clickOnEditPaymentMethod(Map<Object, Object> testdatamap) {
		WebClickUsingJS("//a[text()='"+testdatamap.get("PaymentMethodName").toString()+"']/parent::td/parent::tr//a[contains(@href,'EditPaymentMethod')]");

	}

	//Function Summary  : Method to clickOnAddInvoicebtn
	//Parameter Summary : N/A
	public void clickOnAddInvoicebtn() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_AddInvoicebtn);
		Thread.sleep(2000);

	}
	//Function Summary  : Method to clickOnAddTransactionbtn
	//Parameter Summary : N/A
	public void clickOnAddTransactionbtn() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_AddTransactionbtn);
		Thread.sleep(2000);

	}
	//Function Summary  : Method to EnterFromAmount
	//Parameter Summary : fromAmount
	public void EnterFromAmount(String fromAmount) throws InterruptedException {
		Thread.sleep(2000);
		WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_FromAmnt,fromAmount);
	}

	//Function Summary  : Method to EnterFromTransaction
	//Parameter Summary : fromTransaction
	public void EnterFromTransaction(String fromTransaction) throws InterruptedException {
		Thread.sleep(2000);
		WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_Fromtrans,fromTransaction);
	}

	//Function Summary  : Method to EnterToAmount
	//Parameter Summary : toAmount
	public void EnterToAmount(String toAmount) throws InterruptedException {
		Thread.sleep(2000);
		WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_ToAmnt,toAmount);
	}

	//Function Summary  : Method to EnterToTransaction
	//Parameter Summary : toTransaction
	public void EnterToTransaction(String toTransaction) throws InterruptedException {
		Thread.sleep(2000);
		WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_Totrans,toTransaction);
	}
	//Function Summary  : Method to clickOnInvoiceFeesFixedValueCheckboxAndEnterValue
	//Parameter Summary : fixedValue
	public void clickOnInvoiceFeesFixedValueCheckboxAndEnterValue(String fixedValue) throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_FixedFeesCheckbox);
		Thread.sleep(2000);
		WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_FixedFees_efield,fixedValue);
	}

	//Function Summary  : Method to clickOnTransFeesFixedValueCheckboxAndEnterValue
	//Parameter Summary : transFixedValue
	public void clickOnTransFeesFixedValueCheckboxAndEnterValue(String transFixedValue) throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_FixedFeesCheckbox);
		Thread.sleep(2000);
		WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_FixedFees_efield,transFixedValue);
	}

	//Function Summary  : Method to clickOnInvoiceFeesPercentageCheckboxAndEnterValue
	//Parameter Summary : percentage
	public void clickOnInvoiceFeesPercentageCheckboxAndEnterValue(String percentage) throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_PercentageFeesCheckbox);
		Thread.sleep(2000);
		WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_PercentageFees_efield,percentage);
	}
	//Function Summary  : Method to clickOnTransFeesPercentageCheckboxAndEnterValue
	//Parameter Summary : transPercentage
	public void clickOnTransFeesPercentageCheckboxAndEnterValue(String transPercentage) throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_PercentageFeesCheckbox);
		Thread.sleep(2000);
		WebEdit(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_PercentageFees_efield,transPercentage);
	}
	//Function Summary  : Method to clickOnAddInvoiceButton
	//Parameter Summary : N/A
	public void clickOnAddInvoiceButton() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Invoice_Addbtn);
		Thread.sleep(2000);
	}

	//Function Summary  : Method to clickOnAddTransactionButton
	//Parameter Summary : N/A
	public void clickOnAddTransactionButton() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_Addbtn);
		Thread.sleep(2000);
	}
	//Function Summary  : Method to EnterTheInviceAmountDetails
	//Parameter Summary : N/A
	public void EnterTheInvoiceAmountDetails(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			EnterFromAmount(testdatamap.get("FromAmount").toString());

			EnterToAmount(testdatamap.get("ToAmount").toString());
			clickOnInvoiceFeesFixedValueCheckboxAndEnterValue(testdatamap.get("FixedValue").toString());

			clickOnInvoiceFeesPercentageCheckboxAndEnterValue(testdatamap.get("Percentage").toString());
			clickOnAddInvoiceButton();
			if (CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_Error)) {
				Log.ReportEvent("FAIL", "Add Fees Based on Invoice Amount Functionality is UnSccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			} else {
				Log.ReportEvent("PASS", "Add Fees Based on invoice Amount Functionality is Sccessful");	
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Add Fees Based on Invoice Amount Functionality is UnSccessful");	
			this.takeScreenShot();
			e.printStackTrace();			
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary  : Method to Verify Page Is Added
	//Parameter Summary : N/A
	public void VerifyPaymentMethodsManagementPageIsAdded(Log Log)
	{
		try {
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng))
			{
				Log.ReportEvent("PASS", "New Payment Method Management Page is Added Functionality is Successful");
			}
			else
			{
				Log.ReportEvent("FAIL", "New Payment Method Management Page is Added Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "New Payment Method Management Page is Added Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary  : Method to EnterTheTransactionAmountDetails
	//Parameter Summary : N/A
	public void EnterTheTransactionAmountDetails(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			EnterFromTransaction(testdatamap.get("FromTransaction").toString());

			EnterToTransaction(testdatamap.get("ToTransaction").toString());
			clickOnTransFeesFixedValueCheckboxAndEnterValue(testdatamap.get("TransFixedValue").toString());

			clickOnTransFeesPercentageCheckboxAndEnterValue(testdatamap.get("TransPercentage").toString());
			clickOnAddTransactionButton();
			if (CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_Transc_Error)) {
				Log.ReportEvent("FAIL", "Add Fees Based on Number of Transaction Functionality is UnSccessful");	
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			} else {
				Log.ReportEvent("PASS", "Add Fees Based on Number of Transaction Functionality is Sccessful");	
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Add Fees Based on Number of Transaction Functionality is UnSccessful");	
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary  : Method to clickOnEditPaymentMethod
	//Parameter Summary : FeesType
	public void clickOnRadioButtonAndEnterTheDetails(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		String FeesType = testdatamap.get("FeesType").toString();
		try {
			if (FeesType.equalsIgnoreCase("FeesByInvoiceAmount")) {
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByInvoicebtn);
				if (CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwTransToInvoice)) {

					WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwTransToInvoice_Yesbtn);	
					clickOnAddInvoicebtn();

					EnterTheInvoiceAmountDetails(testdatamap,Log);
				}
				else
				{
					clickOnAddInvoicebtn();

					EnterTheInvoiceAmountDetails(testdatamap,Log);
				}
			} 
			else {
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByTransactionbtn);
				if (CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans)) {

					WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans_Yesbtn);		
					clickOnAddTransactionbtn();

					EnterTheTransactionAmountDetails(testdatamap,Log);
				}
				else
				{
					clickOnAddTransactionbtn();

					EnterTheTransactionAmountDetails(testdatamap,Log);	
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Function Summary  : Method to verifyThePriorityIsForCategoryFees
	//Parameter Summary : N/A
	public void verifyThePriorityIsForCategoryFees(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
		try {
			clickOnEditPaymentMethod(testdatamap);
			Thread.sleep(2000);
			clickOnRadioButtonAndEnterTheDetails(testdatamap,Log);
			String FeesType = testdatamap.get("FeesType").toString();
			if (FeesType.equalsIgnoreCase("FeesByInvoiceAmount")) {
				VerifyValue1(getText("//table//td[text()='"+testdatamap.get("FromAmount").toString()+"']"),testdatamap.get("FromAmount").toString());
				VerifyValue1(getText("//table//td[text()='"+testdatamap.get("ToAmount").toString()+"']"),testdatamap.get("ToAmount").toString());
				Log.ReportEvent("PASS","Verify that the Priority is for Category Fees when Deduction Payment Method Fees Functionality is Successful");
			}
			else if(FeesType.isEmpty())
			{		
				Log.ReportEvent("FAIL","Verify that the Priority is for Category Fees when Deduction Payment Method Fees Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			else {			
				VerifyValue1(getText("//table//td[text()='"+testdatamap.get("FromTransaction").toString()+"']"),testdatamap.get("FromTransaction").toString());
				VerifyValue1(getText("//table//td[text()='"+testdatamap.get("ToTransaction").toString()+"']"),testdatamap.get("ToTransaction").toString());
				Log.ReportEvent("PASS","Verify that the Priority is for Category Fees when Deduction Payment Method Fees Functionality is Successful");
			}
		} 
		catch (Exception e) {		
			Log.ReportEvent("FAIL","Verify that the Priority is for Category Fees when Deduction Payment Method Fees Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}	
	}
	//Function Summary  : Method to change the category from Invoice based to Transaction count and vice versa
	//Parameter Summary : N/A
	public void verifyToChangeTheCategoryFromInvoiceBasedToTransactionCountAndViceVersa(Map<Object, Object> testdatamap,Log Log) {
		try {	
			clickOnEditIconInPaymentMethodMgm(testdatamap);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByInvoiceAmount);
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwTransToInvoiceMessage)) {
				verifyElementIsPresent(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwTransToInvoiceMessage);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans_Yesbtn);
				Thread.sleep(3000);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByTransactionbtn);
				verifyElementIsPresent(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTransMessage);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans_Yesbtn);
				Log.ReportEvent("PASS", "Verify the Message when the User Change the Category from Invoice Based to Transaction Count and Vice Versa Functionality is Successful");
			}
			else if (!CheckElementExists(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans)) {
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByTransactionbtn);
				verifyElementIsPresent(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTransMessage);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans_Yesbtn);
				Thread.sleep(3000);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_FeesByInvoiceAmount);
				verifyElementIsPresent(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwTransToInvoiceMessage);	
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethodMng_SwitchBtwInvoiceToTrans_Yesbtn);
				Log.ReportEvent("PASS", "Verify the Message when the User Change the Category from Invoice Based to Transaction Count and Vice Versa Functionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "Verify the Message when the User Change the Category from Invoice Based to Transaction Count and Vice Versa Functionality is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();					
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify the Message when the User Change the Category from Invoice Based to Transaction Count and Vice Versa Functionality is UnSuccessful");
			takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary   : Method to navigate  to "BillerUnderActivation"
	//Parameter Summary : N/A
	public void navigateBillerUnderActivation(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_BillerMang);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_BillerUnderActivation);
		Log.ReportEvent("PASS", "Naviagate to Not approved Biller Management ");

	}

	//Function Summary  : Method to Verify View Payment Method Details
	//Parameter Summary : N/A
	public void VerifyViewPaymentMethodDetails(Log Log,Map<Object, Object> testdatamap)
	{
		try {
			Thread.sleep(1000);
			if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("Paid Outside EDAAT"))
			{
				WebClick(EdaatOR.Admin_SystemMng_PaymentMethod_Paidoutside_link);
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_PaidOutsideEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_PaidOutsideArabicName, "value"),testdatamap.get("ArabicName").toString());
				Log.ReportEvent("PASS", "View Payment Method Detail Functionality is Successful");
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
			}
			else if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("Sadad"))
			{
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_Sadad_link);
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_SadadEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_SadadArabicName, "value"),testdatamap.get("ArabicName").toString());
				Log.ReportEvent("PASS", "View Payment Method Detail Functionality is Successful");
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
			}
			else if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("MADA"))
			{
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_MADA_link);
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_MadaEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_MADArabicName, "value"),testdatamap.get("ArabicName").toString());
				Log.ReportEvent("PASS", "View Payment Method Detail Functionality is Successful");
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
			}
			else if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("Visa"))
			{
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_Visa_link);
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_VisaEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_VisaArabicName, "value"),testdatamap.get("ArabicName").toString());
				Log.ReportEvent("PASS", "View Payment Method Detail Functionality is Successful");
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
			}
			else if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("Master Card"))
			{
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_MasterCard_link);
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_MastercardEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_MasterCardArabicName, "value"),testdatamap.get("ArabicName").toString());
				Log.ReportEvent("PASS", "View Payment Method Detail Functionality is Successful");
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
			}
			else if(testdatamap.get("EnglishName").toString().equalsIgnoreCase("ApplePay"))
			{
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_ApplePay_link);
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_ApplePayEnglishName, "value"),testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				VerifyValue1(getAttributeValue(EdaatOR.Admin_SystemMng_PaymentMethod_ApplepayArabicName, "value"),testdatamap.get("ArabicName").toString());
				Thread.sleep(1000);
				Log.ReportEvent("PASS", "View Payment Method Detail Functionality is Successful");
				WebClickUsingJS(EdaatOR.Admin_SystemMng_PaymentMethod_BackButton);
			}
			else {
				Log.ReportEvent("FAIL", "View Payment Method Details Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "View Payment Method Details Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();;
		}
	}
	//Function Summary   : Method to Verify Define AZM fees For Payment Methods
	//Parameter Summary  : FixedValue,Percentage,FixedValueWithTax,PercentageWithTax
	public void VerifyDefineAZMfeesForPaymentMethods(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			WebClick(EdaatOR.Admin_PaymentMethodMngEditFixedValueCheckbox);
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_PaymentMethodMngEditFixedValueCheckbox);
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_PaymentMethodMngEditFixedValueAmount,testdatamap.get("FixedValue").toString());
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_PaymentMethodMngEditPercentageCheckbox);
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_PaymentMethodMngEditPercentageCheckbox);
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_PaymentMethodMngEditPercentageAmount,testdatamap.get("Percentage").toString());		
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_PaymentMethodMngEditSaveButton);
			Thread.sleep(500);
			String actFixedValue=WebGetTextAttribute(EdaatOR.Admin_PaymentMethodMngEditFixedValueAmount);
			String expFixedValue=testdatamap.get("FixedValue").toString();
			String expPercentageValue=testdatamap.get("Percentage").toString();
			String actPercentageValue=WebGetTextAttribute(EdaatOR.Admin_PaymentMethodMngEditPercentageAmount);
			if(actFixedValue.equals(expFixedValue)&&actPercentageValue.equals(expPercentageValue)) {
				Log.ReportEvent("PASS", "Verify to Add Fixed Fees to a Payment Method Functionality is Successful");
			}
			else {
				Log.ReportEvent("Fail", "Verify to Add Fixed Fees to a Payment Method Functionality is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("Fail", "Verify to Add Fixed Fees to a Payment Method Functionality is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to Activate And Deactivate Payment Methods status toggle both in EN and AR
	//Parameter Summary  : PaymentsMethods
	public void VerifyActivateAndDeactivatePaymentMethodsStatusToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(1000);
			Thread.sleep(500);
			if(CheckElementExists("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]"))
			{
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_CancelPopupMessage), testdatamap.get("Inactive").toString());
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
				Thread.sleep(500);
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_ConfirmationPopupMessage), testdatamap.get("Active").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_PaymentMng_ChangetoArabic);
				Thread.sleep(500);
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_ArabicPopupMessage), testdatamap.get("ArabicInactive").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
				Thread.sleep(500);
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_ArabicPopupMessage), testdatamap.get("ArabicActive").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
				Thread.sleep(500);
				WebClick(EdaatOR.Changelanguagebtn);
				Log.ReportEvent("PASS", "Activated and Deactivated the Payment Methods Status Toggle Functionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "Activated and Deactivated the Payment Methods Status Toggle Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch(Exception e)	{				
			Log.ReportEvent("FAIL", "Activated and Deactivated the Payment Methods Status Toggle Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to Activate And Deactivate Payment Methods Fees activation status toggle EN and AR
	//Parameter Summary  : PaymentsMethods
	public void VerifyActivateAndDeactivatePaymentMethodFeesActivationStatusToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(1000);
			if(CheckElementExists("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[2]"))
			{
				Thread.sleep(1000);
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[2]");
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_CancelPopupMessage), testdatamap.get("Inactive").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_FreeActivationYesBtn);
				Thread.sleep(500);
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[2]");
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_ConfirmationPopupMessage), testdatamap.get("Active").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_FreeActivationYesBtn);
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_PaymentMng_ChangetoArabic);
				Thread.sleep(500);
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[2]");
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_FreeActivationPopupMessage), testdatamap.get("ArabicInactive").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_FreeActivationYesBtn);
				Thread.sleep(500);
				WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[2]");
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_FreeActivationPopupMessage), testdatamap.get("ArabicActive").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_FreeActivationYesBtn);
				Thread.sleep(500);
				WebClick(EdaatOR.Changelanguagebtn);
				Log.ReportEvent("PASS", "Activated and Deactivated the Payment Methods Fees Activation Status Toggle Functionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "Activated and Deactivated the Payment Methods Fees Activation Status Toggle Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}catch(Exception e)	{				
			Log.ReportEvent("FAIL", "Activated and Deactivated the Payment Methods Fees Activation Status Toggle Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to Deactivate Payment Methods status toggle 
	//Parameter Summary  : PaymentsMethods
	public void VerifyDeactivatePaymentMethodsStatusToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(500);
			WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");	
			if (getText(EdaatOR.Admin_PaymentMng_CancelPopupMessage).equals(testdatamap.get("Inactive").toString())) {
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_CancelPopupMessage), testdatamap.get("Inactive").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
				Log.ReportEvent("PASS", "Payment Methods Status Toggle De-Activated Functionality is Successful");


			} else if(getText(EdaatOR.Admin_PaymentMng_ConfirmationPopupMessage).equals(testdatamap.get("Active").toString())) {
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_PaymentMng_ConfirmationPopupMessage), testdatamap.get("Active").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_SystemMng_PaymentMng_NoBtn);
				Log.ReportEvent("PASS", "Payment Methods Status Toggle De-Activated Functionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "Payment Methods Status Toggle is De-Activated Functionality is UnSuccessful");		
				this.takeScreenShot();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Payment Methods Status Toggle is De-Activated Functionality is UnSuccessful");		
			this.takeScreenShot();
			e.printStackTrace();
			Assert.fail();
		}

	}
	//Function Summary   : Method to Activate Payment Methods status toggle 
	//Parameter Summary  : PaymentsMethods
	public void VerifyActivatePaymentMethodsStatusToggle(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {					
			Thread.sleep(500);
			WebClick("(//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//input[contains(@class,'switch makeActive')]/parent::span)[1]");
			Thread.sleep(500);
			VerifyValue1(getText(EdaatOR.Admin_PaymentMng_ConfirmationPopupMessage), testdatamap.get("Active").toString());
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_SystemMng_PaymentMng_YesBtn);
			Thread.sleep(500);				
			Log.ReportEvent("PASS", "Activated the Payment Methods status toggle");
			test.log(Status.PASS,"Payment Methods activated " + driver.getTitle()+ " * Payment Methods activated PASS * " );
			this.takeScreenShot();
		}catch(Exception e)	{				
			e.printStackTrace();
			test.log(Status.FAIL,"Payment Methods activated " + driver.getTitle()+ " * Payment Methods activated FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary   : Method to Verify PaymentMethods Add Fixed Fees
	//Parameter Summary  : PaymentsMethods,FixedValue,Percentage
	public void VerifyPaymentMethodsAddFixedFees(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(500);
			WebClick("//a[text()='"+testdatamap.get("PaymentMethods").toString()+"']/parent::td/following-sibling::td//a");
			Thread.sleep(500);
			switchToWindow();
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_PaymentMethodMngEditFixedValueCheckbox);
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_PaymentMethodMngEditFixedValueCheckbox);
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_PaymentMethodMngEditFixedValueAmount,testdatamap.get("FixedValue").toString());
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_PaymentMethodMngEditPercentageCheckbox);
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_PaymentMethodMngEditPercentageCheckbox);
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_PaymentMethodMngEditPercentageAmount,testdatamap.get("Percentage").toString());		
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_PaymentMethodMngEditSaveButton);
			Thread.sleep(500);
			if (WebGetTextAttribute(EdaatOR.Admin_PaymentMethodMngEditFixedValueAmountWithTax).equals(testdatamap.get("FixedValueWithTax").toString())) {
				VerifyValue1(testdatamap.get("FixedValueWithTax").toString(), WebGetTextAttribute(EdaatOR.Admin_PaymentMethodMngEditFixedValueAmountWithTax));
				Thread.sleep(500);
				VerifyValue1(testdatamap.get("PercentageWithTax").toString(), WebGetTextAttribute(EdaatOR.Admin_PaymentMethodMngEditPercentageAmountwithTax));
				Log.ReportEvent("PASS", "Define Payment Method Fees can be Define only as Fixed Value (Fixed/Percentage) Functionality is Successful");									
			} else {
				Log.ReportEvent("FAIL", "Define Payment Method Fees can be Define only as Fixed Value (Fixed/Percentage) Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}	
		}catch(Exception e)	{				
			Log.ReportEvent("FAIL", "Define Payment Method Fees can be Define only as Fixed Value (Fixed/Percentage) Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();				
		}
	}
	//Function Summary   : Method to Verify Payment Methods Add Fees Based On Invoice
	//Parameter Summary  : PaymentsMethods,FixedValue,Percentage
	public void VerifyPaymentMethodsAddFeesBasedOnInvoiceOrTransaction(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(5000);
			clickOnEditPaymentMethod(testdatamap);
			Thread.sleep(2000);
			clickOnRadioButtonAndEnterTheDetails(testdatamap,Log);
			String FeesType = testdatamap.get("FeesType").toString();
			if (FeesType.equalsIgnoreCase("FeesByInvoiceAmount")) {
				VerifyValue1(getText("//table//td[text()='"+testdatamap.get("FromAmount").toString()+"']"),testdatamap.get("FromAmount").toString());
				VerifyValue1(getText("//table//td[text()='"+testdatamap.get("ToAmount").toString()+"']"),testdatamap.get("ToAmount").toString());
				Log.ReportEvent("PASS","Verify to Add Fees Based on Invoice Amount in the Payment Method Functionality is Successful");
			}
			else if(FeesType.isEmpty())
			{		
				Log.ReportEvent("FAIL","Verify to Add Fees Based on Invoice Amount/Transaction Count in the Payment Method Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			else {			
				VerifyValue1(getText("//table//td[text()='"+testdatamap.get("FromTransaction").toString()+"']"),testdatamap.get("FromTransaction").toString());
				VerifyValue1(getText("//table//td[text()='"+testdatamap.get("ToTransaction").toString()+"']"),testdatamap.get("ToTransaction").toString());
				Log.ReportEvent("PASS","Verify to Add Fees Based on Number of Transaction in Payment Method Page Functionality is Successful");
			}
		}catch(Exception e)	{				
			Log.ReportEvent("FAIL","Verify to Add Fees Based on Invoice Amount/Transaction Count in the Payment Method Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	public void ClickOnAddBtn() {
		WebClickUsingJS(EdaatOR.Admin_PaymentMethod_AddButton);
		waitForPageToLoad();
	}
	public void ClickOnInvoiceFeesAddBtn() {
		WebClickUsingJS(EdaatOR.Admin_PaymentMethod_InvoiceFeesAddButton);
		waitForPageToLoad();
	}
	//Function Summary  : Search biller
	public void searchBiller(Map<Object, Object> testdatamap,Log Log) {
		try {
			WebEdit(EdaatOR.Admin_SystemMng_notApprovedBiller_Searchbillername, testdatamap.get("BillerName").toString());
			WebClickUsingJS(EdaatOR.Admin_SystemMng_notApprovedBiller_ClickOnSearch);
			Thread.sleep(2000);
			Log.ReportEvent("PASS", " search Biller");
			test.log(Status.PASS, "search Biller " + driver.getTitle()+ "searchBiller PASS* " );
			this.takeScreenShot();
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL,"Search Biller Failed" + driver.getTitle()+ " * Search Biller FAIL * " );	
			this.takeScreenShot();
		}

	}
	public void navigateToNotApprovedBillers(Log Log) {
		try {
			WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_SystemMng_billerAmangement);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_SystemMng_billerMgm_notApprovedBiller);
		} catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
	}
	//Function Summary  :Method to clickonEditBtn
	public void clickonEditBtn(Log Log) {
		try {
			WebClickUsingJS(EdaatOR.Admin_SystemMng_notApprovedBiller_EditBTN);
			Thread.sleep(1000);
			this.takeScreenShot();
		} catch (Exception e) {
			e.printStackTrace();			}

	}		
	//Function Summary  :Verify that the default payment method is "PayOutsideEdaat"
	public void VerifythattheDefaultPaymentMethodisPayOutsideEdaat(Map<Object, Object>testdatamap,Log Log) {
		try {
			Thread.sleep(3000);
			WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
			WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailablePaymentMethods));
			scrollToElement(driver, element);
			String isSelected=driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_PaidOutsideEDAAT_checkbox)).getAttribute("defaultChecked");
			String isDisabled=driver.findElement(By.xpath(EdaatOR.Admin_BillerMang_AvailPayMeth_PaidOutsideEDAAT_checkbox)).getAttribute("disabled");
			if(Boolean.valueOf(isSelected) && Boolean.valueOf(isDisabled)) {				
				Log.ReportEvent("PASS", "Default Payment Method is Pay Outside Edaat Functionality is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "Default Payment Method is Pay Outside Edaat Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Default Payment Method is Pay Outside Edaat Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	} 
	//Function Summary  :Method to editbuttonforpaymentProvider
	public void editbuttonforpaymentProvider(Log Log) throws InterruptedException {
		WebClickUsingJS(EdaatOR.Admin_SystemMng_editbuttonforpaymentProvider);				
	}

	//Function Summary  :Method to toUpdateTheNameCodeCR
	public void  toUpdateTheNameCodeCR(Map<Object, Object> testdatamap, Log Log) {
		try {	
			editbuttonforpaymentProvider(Log);
			WebEdit(EdaatOR.Admin_SystemMng_editPaymentProviderName, testdatamap.get("Name").toString());
			WebEdit(EdaatOR.Admin_SystemMng_editPaymentProviderCode, testdatamap.get("Code").toString());
			WebEdit(EdaatOR.Admin_SystemMng_editPaymentProviderCR, testdatamap.get("CRNumber").toString());						
			EnterBillerBankCertPath();
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_SystemMng_editPaymentProviderSaveButton)) {
				WebClickUsingJS(EdaatOR.Admin_SystemMng_editPaymentProviderSaveButton);
				Log.ReportEvent("PASS", "Verify the Edit Functionality for the Added Payment Provider Method Functionality is Successful");
			}

			else {
				Log.ReportEvent("Fail", "Verify the Edit Functionality for the Added Payment Provider Method Functionality is UnSuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("Fail", "Verify the Edit Functionality for the Added Payment Provider Method Functionality is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary   : Method to upload Biller BankCertificate.
	//Parameter Summary  :N/A.
	public void EnterBillerBankCertPath() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_SystemMng_editPaymentProviderAttachements);
		getAutoItImagePathFile();

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
}
