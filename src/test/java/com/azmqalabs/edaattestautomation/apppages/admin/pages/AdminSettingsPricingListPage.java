/**
* Test Script Name  				 : N/A
* Objective     					 : To Verify Settings Pricelist Functionality
* Version      						 : 1.0
* Author       						 : Kathirvelu Mohan
* Created Date 			      		 : 
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
* Pre-Conditions					 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.apache.poi.ss.formula.functions.EDate;
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



public class AdminSettingsPricingListPage extends BasePage
{

	public AdminSettingsPricingListPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Admin_Setting_pricelistpageVerify)
	public WebElement PriceList;
		
	    
	    public boolean Exists(){
	    	return super.Exists(PriceList); 
		}
 
	  //Function Summary : Method to navigate to pricing list page
	 //Parameter Summary: N/A  
    public void navigatePriceList(Log Log) throws Exception {
			try {
			Thread.sleep(1000);	
			WebClickUsingJS(EdaatOR.Admin_Setting_pricelistlnk);
			waitForPageToLoad();
			this.takeScreenShot();
			test.log(Status.PASS,"Verify Navigate to Pricelist page " + driver.getTitle() +" * Navigate to Pricelist page is Pass * " );
        	Log.ReportEvent("PASS", " Navigate to Pricing List page");

			}
			catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
				test.log(Status.FAIL,"View Navigate to Pricelist page " + driver.getTitle() +" * Navigate to Pricelist page is Fail * " );
			}
		}
  //Function Summary : Method to add price list.
  	//Parameter Summary: Price List Name in Arabic,Price List Name in English,Increase or Decrease Ratio,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate,Description.	
  	public void AddPriceList(Map<Object, Object> testdatamap,Log Log)
  	{
  		try
  		{
		Thread.sleep(2000);
  		WebClick(EdaatOR.Admin_Settings_Addpricelistbtn);
  		WebEdit(EdaatOR.Admin_Settings_PricelistArabicName,testdatamap.get("PriceListNameArabic").toString());
  		WebEdit(EdaatOR.Admin_Settings_PricelistEnglishName,testdatamap.get("PriceListNameEnglish").toString());
  		ImpactOnTheBasicPrice(testdatamap);
  		WebEdit(EdaatOR.Admin_Settings_Pricelistbtn,testdatamap.get("Increase/Decrease Ratio").toString());
  		SelectDate(testdatamap);
      	Rounding(testdatamap);
      	WebEdit(EdaatOR.Admin_Settings_descriptionbtn,testdatamap.get("Description").toString());
      	WebClick(EdaatOR.Biller_ActiveCheckbox);
      	WebClick(EdaatOR.Admin_Settings_AddPricelistbtn2);
      	PriceListSearch(testdatamap,Log);

  		}
  		catch (Exception e) {
  			e.printStackTrace();
  			this.takeScreenShot();
  			test.log(Status.FAIL,"Verify AddPriceList" + driver.getTitle() +" * Add Price List is Fail* " );
  		}
      	
  	}
  //Function Summary : Method to Select radio button of Impact on the base price.
  	//Parameter Summary: Impact On The Basic Price,Increase Price.
  	public void ImpactOnTheBasicPrice(Map<Object, Object> testdatamap)
  	{
  	String ele=testdatamap.get("Impact On The Basic Price").toString();
  	if(ele.equalsIgnoreCase("Increase Price"))
  	{
  		WebClick(EdaatOR.Admin_Settings_Pricelistincradiobtn);
  	}
  	else
  	{
  		WebClick(EdaatOR.Admin_Settings_Pricelistdscradiobtn);
  	}
  	}
	public void Rounding(Map<Object, Object> testdatamap)
	{
		String ele=testdatamap.get("Rounding").toString();
		if(ele.equalsIgnoreCase("Rounding Up"))
		{
			WebClick(EdaatOR.Admin_Settings_Roundinguprdn);
		}
		else if(ele.equalsIgnoreCase("Rounding Down"))
		{
			WebClick(EdaatOR.Admin_Settings_Roundingdownrdn);
		}
		else
		{
			WebClick(EdaatOR.Admin_Settings_RoundingNordn);
		}
	}
  //Function Summary : Method to search pricelist page 
  	//Parameter Summary: N/A
  	private void PriceListSearch(Map<Object,Object>testdatamap,Log Log) {
  		try {
  		WebEdit(EdaatOR.Admin_Settings_PriceListsfield,testdatamap.get("PriceListNameEnglish").toString());
  		Thread.sleep(1000);
  		WebClick(EdaatOR.Admin_Settings_PriceListSeacrchbtn);
  		Thread.sleep(2000);
  		VerifyValue1(getText(EdaatOR.Admin_Settings_PriceListnameverify), testdatamap.get("PriceListNameEnglish").toString());
  		this.takeScreenShot();
  		test.log(Status.PASS,"Verify Search Pricelist" + driver.getTitle() +" * Search Pricelist is Pass * " );
		Log.ReportEvent("PASS", " Verify to Add price list is Suceessful");
		
  		}
  		catch (Exception e) {
  			e.printStackTrace();
  			this.takeScreenShot();
  			test.log(Status.FAIL,"Verify Search Pricelist" + driver.getTitle() +" * Search Pricelist is Fail* " );
  		}
  	}
  	//Function Summary : Method to Select Date
    //Parameter Summary: FromYear,FromMonth,FromDate,ToYear,ToMonth and ToDate.
    	public void SelectDate(Map<Object,Object>testdatamap)
    	{
    		try {
    		WebClick(EdaatOR.Admin_Settings_PriceFromd);
//    		selectDropdownValue_PartialText(EdaatOR.Admin_Settings_PriceFromyear,testdatamap.get("FromYear").toString());
//        	selectDropdownValue_PartialText(EdaatOR.Admin_Settings_PriceFromon,testdatamap.get("FromMonth").toString());
//        	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
    		Thread.sleep(800);
    		WebClick(EdaatOR.Admin_Settings_TodayDate);
    		Thread.sleep(800);
    		WebClick(EdaatOR.Admin_Settings_PriceTod);
        	selectDropdownValue_PartialText(EdaatOR.Admin_Settings_PriceToyear,testdatamap.get("ToYear").toString());
        	selectDropdownValue_PartialText(EdaatOR.Admin_Settings_Priceomon,testdatamap.get("ToMonth").toString());
        	WebClick("//td/a[text()='"+testdatamap.get("ToDate").toString()+"']");
    		}

    		catch (Exception e){
    			e.printStackTrace();
    			this.takeScreenShot();
    			test.log(Status.FAIL,"Select Date" + driver.getTitle() +" *Select Date is Fail* " );
    		}
    	}
  //Function Summary : Method to pricelistsearch
  //Parameter Summary: PriceListNameEnglish
	public void pricelistsearch(Map<Object, Object> testdatamap) throws InterruptedException {
		Thread.sleep(1000);
  		WebEdit(EdaatOR.Admin_Settings_PriceListsfield,testdatamap.get("PriceListNameEnglish").toString());
  		Thread.sleep(1000);
  		WebClick(EdaatOR.Admin_Settings_PriceListSeacrchbtn);
	}
   //Function Summary : Method to pricelistadd
  //Parameter Summary: PriceListNameArabic,PriceListNameEnglish,Increase/Decrease Ratio,Description
  	public void pricelistadd(Map<Object, Object> testdatamap) throws InterruptedException {
  		try {
  		WebClick(EdaatOR.Admin_Settings_Addpricelistbtn);
  		Thread.sleep(1000);
  		WebEdit(EdaatOR.Admin_Settings_PricelistArabicName,testdatamap.get("PriceListNameArabic").toString());
  		Thread.sleep(1000);
  		WebEdit(EdaatOR.Admin_Settings_PricelistEnglishName,testdatamap.get("PriceListNameEnglish").toString());
  		ImpactOnTheBasicPrice(testdatamap);
  		WebEdit(EdaatOR.Admin_Settings_Pricelistbtn,testdatamap.get("Increase/Decrease Ratio").toString());
  		SelectDate(testdatamap);
      	Rounding(testdatamap);
      	WebEdit(EdaatOR.Admin_Settings_descriptionbtn,testdatamap.get("Description").toString());
      	WebClick(EdaatOR.Biller_ActiveCheckbox);
      	Thread.sleep(1000);
      	this.takeScreenShot();
      	WebClick(EdaatOR.Admin_Settings_AddPricelistbtn2);
  		}
  		catch (Exception e) {
			e.printStackTrace();
		}
	}
 //Function Summary : Method to VerifyPriceListSearch
    //Parameter Summary: PriceListNameEnglish
  	public void VerifyPriceListSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException
  	{
  		try
  		{
  		pricelistsearch(testdatamap);
  		if(CheckElementExists(EdaatOR.Admin_Settings_PriceList_nodata)==true)
  		{
  		 pricelistadd(testdatamap);
  		 pricelistsearch(testdatamap);	
  		}
  		VerifyValue1(getText("//td[text()='"+testdatamap.get("PriceListNameEnglish").toString()+"']"),testdatamap.get("PriceListNameEnglish").toString());
  		VerifyValue1(getText("//td[text()='"+testdatamap.get("PriceListNameEnglish").toString()+"']//ancestor::tr//td[6]"),testdatamap.get("Status").toString());
  		Thread.sleep(2000);
  		this.takeScreenShot();
  		test.log(Status.PASS,"Verify Search Pricelist" + driver.getTitle() +" * Search Pricelist is Pass * " );
    	Log.ReportEvent("PASS", " Verify Search pricelist is Suceessfull");

  		}
  		catch (Exception e) {
  		
  		test.log(Status.FAIL,"Verify Search Pricelist" + driver.getTitle() +" * Search Pricelist is Fail* " );
		}
  	}
  	
  	 //Function Summary : Method to Delete pricelist page 
  	//Parameter Summary: N/A
  	public void VerifyPriceListDelete(Map<Object,Object>testdatamap,Log Log) {
  		try {
  			pricelistsearch(testdatamap);
  	  		if(CheckElementExists(EdaatOR.Admin_Settings_PriceList_nodata)==true)
  	  		{
  	  		 pricelistadd(testdatamap);
  	  		 pricelistsearch(testdatamap);
  	  		Thread.sleep(1000);
   			this.takeScreenShot();

  	  		}
  	  		WebClick(EdaatOR.Admin_Settings_PriceList_DeleteBtn);
  	  		WebClick(EdaatOR.Admin_Settings_PriceList_yesDeleteBtn);
  	  		Thread.sleep(1000);
  			this.takeScreenShot();
  			test.log(Status.PASS,"Verify Delete Pricelist" + driver.getTitle() +" * Delete Pricelist is Pass * " );
        	Log.ReportEvent("PASS", " Verify delete price button");
		
  		}
  		catch (Exception e) {
  			e.printStackTrace();
  			this.takeScreenShot();
  			test.log(Status.FAIL,"Verify Delete Pricelist" + driver.getTitle() +" * Delete Pricelist is Fail* " );
  		}

  	}
  	 //Function Summary : Method to Verify grid view of Price list under settings.
  	//Parameter Summary: N/A
	public void VerifyGridView(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try {
			navigatePriceList(Log);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Admin_Settings_PriceListsym);	
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Admin_Settings_PriceListtable);						
			this.takeScreenShot();
			test.log(Status.PASS,"Verify the grid view in Pricelist page " + driver.getTitle() +" * Verification in Pricelist page is Pass * " );
			Log.ReportEvent("PASS", " Verify to Add price list is Suceessful");
	
		}
			catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
				test.log(Status.FAIL,"Verify the grid view in Pricelist page " + driver.getTitle() +" * Verification in Pricelist page is Fail * " );
			}
		}
	//Function Summary : Method to View price lists details
  	//Parameter Summary: PriceListNameEnglish
	public void ViewPriceDetails(Map<Object,Object>testdatamap,Log Log)
  	{
  		try {
  			WebEdit(EdaatOR.Admin_Settings_PriceListsfield, testdatamap.get("PriceListNameEnglish").toString());
  	  		WebClick(EdaatOR.Admin_Settings_PriceListSeacrchbtn);
  	  	    Thread.sleep(1000);
  	  		WebClickUsingJS(EdaatOR.Admin_Settings_PriceListUpdateBtn);
  	  	    Thread.sleep(1000);
  	  		ExistsCheck(EdaatOR.Admin_Settings_PriceListUpdate);
  	  		test.log(Status.PASS,"Verify view details" + driver.getTitle() +" * View price details is Pass * " );
			Log.ReportEvent("PASS", " Verify view price details is Suceessful");

  		}
  		catch (Exception e) {
  			e.printStackTrace();
  			this.takeScreenShot();
  			test.log(Status.FAIL,"Verify view details" + driver.getTitle() +" *View details is Fail* " );
  		}
  		
  	}

	
	public void priceListAdd(Map<Object,Object>testdatamap) throws InterruptedException {
 		WebClick(EdaatOR.Admin_Settings_Addpricelistbtn);
		Thread.sleep(500);
      	WebClick(EdaatOR.Admin_Settings_AddPricelistbtn2);

	}
	//Function Summary  : method to verify Error messages in Add price list page
	//Parameter Summary : ExpectedResult
	public void VerifyAddPriceListErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				navigatePriceList(Log);
				Thread.sleep(500);
				if(testdatamap.get("Increase/Decrease Ratio").toString().equals("")) {
				priceListAdd(testdatamap);}
				else {
					pricelistadd(testdatamap);			
				}
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
				
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ArNameErrorMsg));
						Thread.sleep(500);
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_EnNameErrorMsg));
						Thread.sleep(500);
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_RatioErrorMsg));
						Thread.sleep(500);
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_FromDateErrorMsg));
						Thread.sleep(500);
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ToDateErrorMsg));
						Thread.sleep(500);
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_RoundingErrorMsg));
				
						test.log(Status.PASS, "Add PriceList ErrorMessage Exists" + driver.getTitle() + " *PriceList Error Message Exists * ");
									}
				else if (ExistsCheck(EdaatOR.Admin_RatioErrorMsg)) {
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_RatioErrorMsg));
					test.log(Status.PASS, "PriceList  Ratio ErrorMessage Exists" + driver.getTitle() + " *PriceList Ratio ErrorMessage Exists * ");
				}
				
				else {
					test.log(Status.FAIL, "No error Exists" + driver.getTitle() + " * No error Exists * ");
				}

			} catch (Exception e) {
				throw new NoSuchElementException("Add PriceList "+ "Page - Not Loaded");
			}

		}
	}			
	
}
	
 


	
	
    

