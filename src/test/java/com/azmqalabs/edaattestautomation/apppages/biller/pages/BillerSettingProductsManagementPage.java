/**
* Test Script Name  				 : N/A
* Objective                          : Verify the TermsManagement Functionality.
* Version      						 : 1.0
* Author       						 : Arun Kumar MS
* Created Date 			      		 : 11/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : 
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
* Defects affecting this test script : N/A
* WorkArounds/Known Issues			 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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



public class BillerSettingProductsManagementPage extends BasePage
{

	public BillerSettingProductsManagementPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Termsmanagementsym)
	public WebElement TermsManagement;
		
	    
	    public boolean Exists(){
	    	return super.Exists(TermsManagement); 
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
		//Function Summary   : Method to Edit Product
	    //Parameter Summary : ReferenceCode,Description,MinPrice,MaxPrice
	 	public void VerifyEditFunctionality(Map<Object,Object>testdatamap,Log Log) {
	 		
	 		try {
	 			verifySearchFunctionality(testdatamap);
	 			WebClick(EdaatOR.Biller_Product_EditBtn);
	 			Thread.sleep(1000);
	 			WebEdit(EdaatOR.Biller_Product_RefCode,testdatamap.get("ReferenceCode").toString());
	 			Thread.sleep(2000);
	 			WebEdit(EdaatOR.Biller_Product_Description,testdatamap.get("Description").toString());
	 			Thread.sleep(2000);
	 			WebEdit(EdaatOR.Biller_Product_MinPrice,testdatamap.get("MinPrice").toString());
	 			Thread.sleep(2000);
	 			WebEdit(EdaatOR.Biller_Product_MaxPrice,testdatamap.get("MaxPrice").toString());
	 			Thread.sleep(2000);
	 			//WebClick(EdaatOR.Biller_Product_SingleToggle);
	 			//Thread.sleep(1000);
	 			WebClick(EdaatOR.Biller_Product_SaveChangesBtn);
	 			Thread.sleep(1000);
	 			test.log(Status.PASS,"#FUNC-Search Product Template" + driver.getTitle() +" * Product Management PASS * " );
	        	Log.ReportEvent("PASS", " Verify Product Management Edit functionality Is Suceessfull");

	 		}
	 		catch(Exception e){
	 			test.log(Status.FAIL,"#FUNC-Search Product Template" + driver.getTitle() +" * Product Management FAIL * " );
	 			this.takeScreenShot();
	 		}	 		
	 	}
		
		public void verifySearchFunctionality(Map<Object,Object>testdatamap) throws IOException, Exception {
			try {
				String pName=testdatamap.get("SearchProdName").toString();
				String pCate=testdatamap.get("SearchProdCateg").toString();
				EnterProductInputBox(pName);
				SelectIdProductListBox(pCate);
				ClickOnSearchBtn();
				Thread.sleep(2000);
				if(CheckElementExists(EdaatOR.Biller_Product_NoData)==true) {
					AddProduct(testdatamap.get("ProdArabic").toString(),pName,pCate,testdatamap.get("BasicPrice").toString());
					EnterProductInputBox(pName);
					SelectIdProductListBox(pCate);
					ClickOnSearchBtn();
				}

//				List<WebElement> listTable=driver.findElements(By.xpath(EdaatOR.Biller_Product_Table));
//				for(int i=0;i<listTable.size();i++) {
//					int j=i+1;
//					if(!pName.equalsIgnoreCase("")) {
//						VerifyValue1(getText(EdaatOR.Biller_Product_Table+"["+j+"]/td[3]"), pName);
//					}else if(!pCate.equalsIgnoreCase("")) {
//						VerifyValue1(getText(EdaatOR.Biller_Product_Table+"["+j+"]/td[4]"), pCate);
//					}
//				}
//
//				test.log(Status.PASS,"#FUNC-Search Product Template" + driver.getTitle() +" * Product Management PASS * " );	

			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Search Product Template" + driver.getTitle() +" * Product Management FAIL * " );
				this.takeScreenShot();
			}
		}
		public void AddProduct(String ProdArabic,String ProdEnglish,String Category,String BasicPrice){
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
}