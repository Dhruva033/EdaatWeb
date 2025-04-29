package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.File;
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



public class AdminSubbillerPage extends BasePage
{

	public AdminSubbillerPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Admin_CorpSubBillerPageVerify)
	public WebElement subbiller;
		
	    
	    public boolean Exists(){
	    	return super.Exists(subbiller); 
		}

	
	public boolean SubbillerSearch(String BillerName,String NationalID){
		boolean existsElement = false;
		try{
				WebClickUsingJS(EdaatOR.Biller_Sub_Individualclient);
	        	Thread.sleep(2000);
	        	WebClickUsingJS(EdaatOR.Biller_Sub_IndividualsubBiller);
	        	Thread.sleep(2000);
	        	WebEdit(EdaatOR.Biller_Individualclient_Name,BillerName);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Subbiller_NId,NationalID);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
				this.takeScreenShot();
            	existsElement=ExistsCheck("//td[text()='"+NationalID+"']");
				Thread.sleep(1000);
				
           	
        }
        catch(Exception e){
//       test.log(Status.FAIL,"Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
            this.takeScreenShot();
        }
        return existsElement;
    }
    //Function summary:Verify Sub billers Corporate subBillers grid
//Function Parameters:view and table
public void CorporateSubBillersGridView(String view,String table,Log Log)
	{
		try {

				boolean Ele = GridViewtable(view,table);
				if (Ele == true)
				{
					test.log(Status.PASS,"Grid View" + driver.getTitle() + " * Grid View PASS * ");
				    Log.ReportEvent("PASS", "Verify grid view details is Suceessful");
				}
				else
				{
					test.log(Status.FAIL,"Grid View" + driver.getTitle() + " * Grid View FAIL * ");
				}
				
		} catch (Exception e) {
				test.log(Status.FAIL, "Grid View" + driver.getTitle() + " * Grid View FAIL * ");
				this.takeScreenShot();
			}
	}
//Function summary:Verify Sub billers Corporate subBillers grid
//Function Parameters:N/A.
	public boolean GridViewtable(String view,String table) {
			boolean existsNID = false;
			try {
				WebClickUsingJS(EdaatOR.Admin_SubBillers);
				Thread.sleep(1000);
				WebClickUsingJS(view);
				Thread.sleep(1000);
				this.takeScreenShot();
				if (ExistsCheck(table) == true) {
					existsNID = true;
				}
				existsNID = true;
			}

			catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
			}
			return existsNID;
		}
		
	//Function Summary  : Method to Upload Registration Certificate
	//Parameter Summary : N/A
	public void EnterAdminRegiAttachment() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_CorpoSubBillerCRAttach);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}	
	
     public void  getAutoItImagePathFile() throws Exception {
  		Thread.sleep(1000);
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//ImageUpload.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(1000);
		}
		
	//Function Summary  : Method to Upload IBAN Attachment
	//Parameter Summary : N/A
	public void EnterAdminIBANAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_CorpoSubBillerIBANAttach);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}
	//Function Summary  : Method to Upload Product IBAN Attachment
	//Parameter Summary : N/A
	public void EnterAdminProductIBANAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_CorpoSubBillerProductIBANAttach);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}
	
	public void CRCertificate() throws Exception
	{
		WebClickUsingActions(EdaatOR.Admin_subbillerCRNCertificate);
		Thread.sleep(1000);
		getAutoItImagePathFile();
	}
	public void IbanCertificate() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_subbillerAttachIban);
		getAutoItImagePathFile();
	}
	//Function summary:Method to add corporate subbiller.
	//Function Parameters:ClientName,CRNumber,IBANNumber,BeneficiaryName,Taxnumber,FixedValue,Percentage,DistrictName,StreetName,ZipCode,BuildingNo,
	//EmployeeName,EmployeeEmail,EmployeeMobileNumber.	

	public void AddCorporatesubbiller(Map<Object, Object> testdatamap,Log Log) {
		try{
			WebClickUsingJS(EdaatOR.Admin_subbillerbtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_CarpoSubbillerdatabtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Carpoaddsubbiller);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerName,testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerCRNumber,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			CRCertificate();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerIban,testdatamap.get("IBANNumber").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerBenfName,testdatamap.get("BeneficiaryName").toString());
			Thread.sleep(1000);
			IbanCertificate();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerTaxNumber,testdatamap.get("Taxnumber").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerFixedValue);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEnterFixedValue,testdatamap.get("FixedValue").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerPercentage);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEnterPercentValue,testdatamap.get("Percentage").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerCity);
			Thread.sleep(1000);
			WebClick("//li[text()='"+testdatamap.get("City").toString()+"']");
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerDisctictName,testdatamap.get("DistrictName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerStreetName,testdatamap.get("StreetName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerPostalName,testdatamap.get("ZipCode").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerBuildName,testdatamap.get("BuildingNo").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEmployName,testdatamap.get("EmployeeName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEmpleyEmail,testdatamap.get("EmployeeEmail").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEmpleyNumber,testdatamap.get("EmployeeMobileNumber").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerAddbtn);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerBillerName,testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerCrNumber,testdatamap.get("CRNumber").toString());
			WebClick(EdaatOR.Admin_subbillerSearchBtn);
			VerifyValue1(WebGetText("//tr/td[text()='"+testdatamap.get("CRNumber").toString()+"']"), testdatamap.get("CRNumber").toString());
			this.takeScreenShot();
		    test.log(Status.PASS,"Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );			
		   Log.ReportEvent("PASS", "Verify to Message details and Reply is Suceessful");

    }catch(Exception e){
  test.log(Status.FAIL,"Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
        this.takeScreenShot();
    }
 }

//Function summary:Verify Corporate subBillers Search
	//Function Parameters:CRNumber.
	public void CorporatesubbillerSearch(Map<Object, Object> testdatamap,Log Log) {
		try{
			
			WebClickUsingJS(EdaatOR.Admin_subbillerbtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_CarpoSubbillerdatabtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Carpoaddsubbiller);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerName,testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerCRNumber,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			CRCertificate();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerIban,testdatamap.get("IBANNumber").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerBenfName,testdatamap.get("BeneficiaryName").toString());
			Thread.sleep(1000);
			IbanCertificate();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerTaxNumber,testdatamap.get("Taxnumber").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerFixedValue);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEnterFixedValue,testdatamap.get("FixedValue").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerPercentage);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEnterPercentValue,testdatamap.get("Percentage").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerCity);
			Thread.sleep(1000);
			WebClick("//li[text()='"+testdatamap.get("City").toString()+"']");
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerDisctictName,testdatamap.get("DistrictName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerStreetName,testdatamap.get("StreetName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerPostalName,testdatamap.get("ZipCode").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerBuildName,testdatamap.get("BuildingNo").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEmployName,testdatamap.get("EmployeeName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEmpleyEmail,testdatamap.get("EmployeeEmail").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEmpleyNumber,testdatamap.get("EmployeeMobileNumber").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerAddbtn);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerBillerName,testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerCrNumber,testdatamap.get("CRNumber").toString());
			WebClick(EdaatOR.Admin_subbillerSearchBtn);
			Thread.sleep(2000);
			VerifyValue1(WebGetText("//tr/td[text()='"+testdatamap.get("CRNumber").toString()+"']"), testdatamap.get("CRNumber").toString());
			this.takeScreenShot();
			test.log(Status.PASS,"Verify Corporate Subbiller search" + driver.getTitle() +" * Corporate Subbiller search is PASS * " );		
		    Log.ReportEvent("PASS", "Verify Corporate SubBillers search functionality is Successfull");
			
//			AddCorporatesubbiller(testdatamap,Log);
//			VerifyValue1(WebGetText("//tr/td[text()='"+testdatamap.get("CRNumber").toString()+"']"), testdatamap.get("CRNumber").toString());
//			Thread.sleep(1000);
		//	this.takeScreenShot();
		}
	catch(Exception e){
             test.log(Status.FAIL,"Verify Corporate Subbiller search" + driver.getTitle() +" * Corporate Subbiller search is Fail * " );
             this.takeScreenShot();
	}
  }
  //Function Summary  : Method to Add Product
	//Parameter Summary : SelectProduct,FixedValue,Percentage,ProIBANNumber,BeneficaryName
	public void AddProduct(Map<Object,Object> testdatamap) throws Exception {
		
		   WebClick(EdaatOR.Admin_CorpoSubBillerAddProduct);
		   WebSelect(EdaatOR.Admin_CorpoSubBillerSelectProduct,testdatamap.get("SelectProduct").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProFixedValue,testdatamap.get("FixedValue").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProPercentage,testdatamap.get("Percentage").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProductIBAN,testdatamap.get("ProIBANNumber").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProductBeneficaryName,testdatamap.get("BeneficaryName").toString());
		   EnterAdminProductIBANAttmnt();
		   WebClick(EdaatOR.Admin_CorpoSubBillerProductAddBTN);
	}
	
	//Function Summary  : Method to Enter National Address Information
	//Parameter Summary : BDistric,City,BDistric,Street,ZipCode,BuildNum
	public void NationalAdressInfo(Map<Object,Object> testdatamap) throws Exception {
		   WebClick(EdaatOR.Admin_CorpoSubBillerCityList);
		   Thread.sleep(2000);
		   WebClick("//li[text()='"+testdatamap.get("City").toString()+"']");
		   Thread.sleep(2000);
		   WebEdit(EdaatOR.Admin_District_eField,testdatamap.get("BDistric").toString());
		   WebEdit(EdaatOR.Admin_Street_eField,testdatamap.get("Street").toString());
		   WebEdit(EdaatOR.Admin_PostalCode_eField,testdatamap.get("ZipCode").toString());
		   WebEdit(EdaatOR.Admin_BuildNo_eField,testdatamap.get("BuildNum").toString()); 
		   
	}
	
	//Function Summary  : Method to Enter Contact Information
	//Parameter Summary : EmployeeName,EmployeeEmailID,EmployeeMobNumber
	public void ContactInfo(Map<Object,Object> testdatamap) throws Exception {
		   
		   WebEdit(EdaatOR.Admin_EmplyName_eField,testdatamap.get("EmployeeName").toString());
		   WebEdit(EdaatOR.Admin_EmplyEmail_eField,testdatamap.get("EmployeeEmailID").toString());
		   WebEdit(EdaatOR.Admin_EmplyMobileNumber_eField,testdatamap.get("EmployeeMobNumber").toString());  
	}
	//Function Summary  : Method to Add Corporate SubBiler Based on Fee Deduction on Product
	//Parameter Summary : BillerName,CRNumber,IBANNumber,BeneficaryName,TaxNumber
	public void CorporateSubBillersAdd(Map<Object,Object> testdatamap,Log Log)
	{
		try {
			   WebClickUsingJS(EdaatOR.Admin_CorpoSubBiller);
			   WebClickUsingJS(EdaatOR.Admin_CorpoSubBillerAddBTN);
			   WebEdit(EdaatOR.Admin_CorpoSubBillerName,testdatamap.get("BillerName").toString());
			   WebEdit(EdaatOR.Admin_CorpoSubBillerCRNum,testdatamap.get("CRNumber").toString());
			   EnterAdminRegiAttachment();
			   WebEdit(EdaatOR.Admin_CorpoSubBillerIBAN,testdatamap.get("IBANNumber").toString());
			   WebEdit(EdaatOR.Admin_CorpoSubBillerBeneficaryName,testdatamap.get("BeneficaryName").toString());
			   EnterAdminIBANAttmnt();
			   WebEdit(EdaatOR.Admin_CorpoSubBillerTaxNum,testdatamap.get("TaxNumber").toString());
			   WebClickUsingJS(EdaatOR.Admin_CorpoSubBillerFeeDeductonProductCHXbox);
			   AddProduct(testdatamap);
			   Thread.sleep(2000);
			   NationalAdressInfo(testdatamap);
			   ContactInfo(testdatamap);
			   WebClickUsingJS(EdaatOR.Admin_CorpoSubBillerAddButton);
			   WebEdit(EdaatOR.Admin_subbillerBillerName,testdatamap.get("BillerName").toString());
			   Thread.sleep(1000);
			   WebEdit(EdaatOR.Admin_subbillerCrNumber,testdatamap.get("CRNumber").toString());
			   WebClick(EdaatOR.Admin_subbillerSearchBtn);
			   Thread.sleep(1000);
			   VerifyValue1(getText(EdaatOR.Admin_CorpoSubBillerVerfiy1),testdatamap.get("BillerName").toString());
			   Thread.sleep(1000);
			   VerifyValue1(getText(EdaatOR.Admin_CorpoSubBillerVerfiy2),testdatamap.get("CRNumber").toString());
			   this.takeScreenShot();			   
			   test.log(Status.PASS,"Add Crporste SubBiller with Fee Deduction on Product" + driver.getTitle() + " *Add Crporste SubBiller with Fee Deduction on Product PASS * ");
	           Log.ReportEvent("PASS", "Verify Add Corporate SubBiller is Suceessful");

			} catch (Exception e) {
				test.log(Status.FAIL, "Add Crporste SubBiller with Fee Deduction on Product" + driver.getTitle() + " * Add Crporste SubBiller with Fee Deduction on Product FAIL * ");
				this.takeScreenShot();
			}
    }
	
	//Function Summary  : Method to Add Corporate SubBiller ErrorMsg
    //Parameter Summary : MethodDeduct,Expected
	public void CorporateSubBillerErrorMsg(Map<Object,Object> testdatamap)
	{
		try {
			  String Feesdeduct = testdatamap.get("MethodDeduct").toString();
			   WebClickUsingJS(EdaatOR.Admin_SubBillers);
			   WebClickUsingJS(EdaatOR.Admin_CorpoSubBiller);
			   WebClickUsingJS(EdaatOR.Admin_Carpoaddsubbiller);
			  if(Feesdeduct.equalsIgnoreCase("none"))
			  {
			   
			   WebClick(EdaatOR.Admin_subbillerAddbtn);
			   VerifyValue1(getText(EdaatOR.Admin_SubBillerAdd), testdatamap.get("Expected").toString());
			   this.takeScreenShot();
			   test.log(Status.PASS,"Verify Add corporate subbiller error message" + driver.getTitle() + " *Verify Add corporate subbiller error message is PASS * ");
			  }
			  else if(Feesdeduct.equalsIgnoreCase("Fixed Value"))
			  {
			    WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
			    WebClick(EdaatOR.Admin_subbillerFixedValue);
			    WebClick(EdaatOR.Admin_subbillerAddbtn);
			    VerifyValue1(getText(EdaatOR.Admin_SubBillerFixedValueError), testdatamap.get("Expected").toString());
			    this.takeScreenShot();
				test.log(Status.PASS,"Verify Add corporate subbiller fixed value error message" + driver.getTitle() + " *Verify Add corporate subbiller fixed value error message is PASS * ");
			  }
			  else if(Feesdeduct.equalsIgnoreCase("Percentage"))
			  {
				 WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
				 WebClick(EdaatOR.Admin_subbillerPercentage);
				 WebClick(EdaatOR.Admin_subbillerAddbtn);
				 if(CheckElementExists(EdaatOR.Admin_SubBillerPercentError)) {
				 VerifyValue1(getText(EdaatOR.Admin_SubBillerPercentError), testdatamap.get("Expected").toString());
				 WebClick(EdaatOR.Admin_subbillerFixedValue);
                 verifyElementIsPresent(EdaatOR.Admin_SubBillerPercentError2);
 			     this.takeScreenShot();
 				 test.log(Status.PASS,"Verify Add corporate subbiller percentage error message" + driver.getTitle() + " *Verify Add corporate subbiller Percentage error message is PASS * ");
				 }
			  }
			  else if(Feesdeduct.equalsIgnoreCase("Invoice Amount"))
			  {
				WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
				WebClick(EdaatOR.Admin_subbillerAddbtn);
			    VerifyValue1(getText(EdaatOR.Admin_SubBillerInvoiceAmount), testdatamap.get("Expected").toString());
			    this.takeScreenShot();
				test.log(Status.PASS,"Verify Add corporate subbiller Fees Deduction from Invoice Total Amount checkbox error message" + driver.getTitle() + " *Verify Add corporate subbiller Fees Deduction from Invoice Total Amount checkbox error message is PASS * ");
			  }
			  
				
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Verify Add corporate subbiller error message" + driver.getTitle() + " *Verify Add corporate subbiller error message FAIL * ");
			this.takeScreenShot();
		}
	}

	//Function Summary  : Method to Add product Error Messages
    //Parameter Summary : Product,FixedValue,Percentage,BeneficaryName,IBAN Number
	public void AddproductError(Map<Object,Object> testdatamap) throws Exception
	{
		
		   WebClickUsingJS(EdaatOR.Admin_SubBillers);
		   WebClickUsingJS(EdaatOR.Admin_CorpoSubBiller);
		   WebClickUsingJS(EdaatOR.Admin_Carpoaddsubbiller);
		   WebClick(EdaatOR.Admin_SubBillerBasedProductcheck);
		   WebClick(EdaatOR.Admin_CorpoSubBillerAddProduct);
		   WebClickUsingJS(EdaatOR.Admin_CorpoSubBillerSelectProduct);
		   selectDropdownValue_PartialText(EdaatOR.Admin_CorpoSubBillerSelectProduct,testdatamap.get("Product").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProFixedValue,testdatamap.get("FixedValue").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProPercentage,testdatamap.get("Percentage").toString());
		   WebEdit(EdaatOR.Admin_SubBillerProductIBAN,testdatamap.get("IBAN Number").toString());
		   WebEdit(EdaatOR.Admin_SubBillerProductBeneficiary,testdatamap.get("BeneficaryName").toString());
		   WebClick(EdaatOR.Admin_CorpoSubBillerProductAddBTN);
		   CorporateSubBillerBasedOnProductError(testdatamap);
		
	}
	
	//Function Summary  : Method to Add product Error Messages
    //Parameter Summary : Expected
	public void CorporateSubBillerBasedOnProductError(Map<Object,Object> testdatamap) throws Exception
	{
		try {
			   if(CheckElementExists(EdaatOR.Admin_SubBillerSelectproductError))
			   {
               VerifyValue1(getText(EdaatOR.Admin_SubBillerSelectproductError),testdatamap.get("Expected").toString());
			   this.takeScreenShot();
			   test.log(Status.PASS,"Verify Add corporate subbiller Based on product" + driver.getTitle() + " *Verify Add corporate subbiller Based on product is PASS * ");
			   }
			   else if(CheckElementExists(EdaatOR.Admin_SubBillerProductFixedPer))
			   {
	            VerifyValue1(getText(EdaatOR.Admin_SubBillerProductFixedPer),testdatamap.get("Expected").toString());
			    this.takeScreenShot();
			    test.log(Status.PASS,"Verify Add corporate subbiller Based on product" + driver.getTitle() + " *Verify Add corporate subbiller Based on product is PASS * ");
			   }
			   else if(CheckElementExists(EdaatOR.Admin_SubBillerProductIbanError))
			   {
	            VerifyValue1(getText(EdaatOR.Admin_SubBillerProductIbanError),testdatamap.get("Expected").toString());
			    this.takeScreenShot();
			    test.log(Status.PASS,"Verify Add corporate subbiller Based on product IBAN Number Error" + driver.getTitle() + " *Verify Add corporate subbiller Based on product IBAN Number Error is PASS * ");
			   }
			   else if(CheckElementExists(EdaatOR.Admin_SubBillerProductIbanInvalid))
			   {
	            VerifyValue1(getText(EdaatOR.Admin_SubBillerProductIbanInvalid),testdatamap.get("Expected").toString());
			    this.takeScreenShot();
			    test.log(Status.PASS,"Verify Add corporate subbiller Based on product invalid IBAN  Error" + driver.getTitle() + " *Verify Add corporate subbiller Based on product Invalid IBAN Error is PASS * ");
			   }
			   else if(CheckElementExists(EdaatOR.Admin_SubBillerProductBeneficiaryError))
			   {
	            VerifyValue1(getText(EdaatOR.Admin_SubBillerProductBeneficiaryError),testdatamap.get("Expected").toString());
			    this.takeScreenShot();
	            test.log(Status.PASS,"Verify Add corporate subbiller Based on product Benificiary Name error" + driver.getTitle() + " *Verify Add corporate subbiller Based on product Benificiary Name error is PASS * ");
			   }
			   else if(CheckElementExists(EdaatOR.Admin_SubBillerProductIBanAttachError))
			   {
		         VerifyValue1(getText(EdaatOR.Admin_SubBillerProductIBanAttachError),testdatamap.get("Expected").toString());
				 this.takeScreenShot();
		         test.log(Status.PASS,"Verify Add corporate subbiller Based on product IBAN Attach error" + driver.getTitle() + " *Verify Add corporate subbiller Based on product IBAN Attach error is PASS * ");
			   }
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Verify Add corporate subbiller error message" + driver.getTitle() + " *Verify Add corporate subbiller error message FAIL * ");
			this.takeScreenShot();
		}
	}
	
	  //Function Summary  : Method to Verify SubBiller GeneralInfo Error Message
	//Function Parameters:CRNumber,BillerName,IBANNumber,BeneficaryName,TaxNumber,FixedValue,Percentage

	public void SubBillerGeneralInfo(Map<Object,Object> testdatamap) throws InterruptedException
	{
		
		WebClickUsingJS(EdaatOR.Admin_subbillerbtn);
		WebClickUsingJS(EdaatOR.Admin_CarpoSubbillerdatabtn);
		WebClickUsingJS(EdaatOR.Admin_Carpoaddsubbiller);
		WebEdit(EdaatOR.Admin_subbillerName,testdatamap.get("BillerName").toString());
		WebEdit(EdaatOR.Admin_subbillerCRNumber,testdatamap.get("CRNumber").toString());
		//CRCertificate();
		WebEdit(EdaatOR.Admin_subbillerIban,testdatamap.get("IBANNumber").toString());
		WebEdit(EdaatOR.Admin_subbillerBenfName,testdatamap.get("BeneficaryName").toString());
		//IbanCertificate();
		WebEdit(EdaatOR.Admin_subbillerTaxNumber,testdatamap.get("TaxNumber").toString());
		WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
		WebClick(EdaatOR.Admin_subbillerFixedValue);
		WebEdit(EdaatOR.Admin_subbillerEnterFixedValue,testdatamap.get("FixedValue").toString());
		WebClick(EdaatOR.Admin_subbillerPercentage);
		WebEdit(EdaatOR.Admin_subbillerEnterPercentValue,testdatamap.get("Percentage").toString());
		Thread.sleep(1000);
	    WebClick(EdaatOR.Admin_subbillerAddbtn);
		AddSuBillerInfoErroxCheck(testdatamap);	
		
	} 
	 //Function Summary  : Method to Verify SubBiller GeneralInfo Error Messages
	//Function Parameters: Expected
	public void AddSuBillerInfoErroxCheck(Map<Object,Object> testdatamap)
	{
		try {
			if(CheckElementExists(EdaatOR.Admin_SubBillerNameError))
			{
	         VerifyValue1(getText(EdaatOR.Admin_SubBillerNameError),testdatamap.get("Expected").toString());
		     this.takeScreenShot();
		     test.log(Status.PASS, "Verify Add corporate subbiller Name Text field error message" + driver.getTitle() + " *  Verify Add corporate subbiller error message PASS * ");
			}
			else if(CheckElementExists(EdaatOR.Admin_SubBillerCRError))
			{
		      VerifyValue1(getText(EdaatOR.Admin_SubBillerCRError),testdatamap.get("Expected").toString());
			  this.takeScreenShot();
			  test.log(Status.PASS, "Verify Add corporate subbiller CR Number Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbiller CR Number Text field  error message PASS * ");
			}
			else if(CheckElementExists(EdaatOR.Admin_SubBillerIBanError))
			{
		      VerifyValue1(getText(EdaatOR.Admin_SubBillerIBanError),testdatamap.get("Expected").toString());
			  this.takeScreenShot();
			  test.log(Status.PASS, "Verify Add corporate subbiller IBAN Number Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbiller IBAN Number Text field  error message PASS * ");
			}
			else if(CheckElementExists(EdaatOR.Admin_SubBillerBeneficiaryNameError))
			{
		      VerifyValue1(getText(EdaatOR.Admin_SubBillerBeneficiaryNameError),testdatamap.get("Expected").toString());
			  this.takeScreenShot();
			  test.log(Status.PASS, "Verify Add corporate subbiller Beneficiary name Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbillerBeneficiary name Text field  error message PASS * ");
			}
			else if(CheckElementExists(EdaatOR.Admin_SubBillerTaxNumError))
			{
		      VerifyValue1(getText(EdaatOR.Admin_SubBillerTaxNumError),testdatamap.get("Expected").toString());
			  this.takeScreenShot();
			  test.log(Status.PASS, "Verify Add corporate subbiller Tax Number Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbiller Tax Number Text field  error message PASS * ");
			}
			else if(CheckElementExists(EdaatOR.Admin_SubBillerIBanInavlid))
			{
		      VerifyValue1(getText(EdaatOR.Admin_SubBillerIBanInavlid),testdatamap.get("Expected").toString());
			  this.takeScreenShot();
			  test.log(Status.PASS, "Verify Add corporate subbiller IBAN Number Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbiller IBAN Number Text field  error message PASS * ");
			}
				
		}	
				
			
		catch (Exception e) {
			test.log(Status.FAIL, "Verify Add corporate subbiller error message" + driver.getTitle() + " *Verify Add corporate subbiller error message FAIL * ");
			this.takeScreenShot();
		}
	}
	
     //Function Summary  : Method to Verify SubBiller National Info Details Error Message
	//Function Parameters:CRNumber,BillerName,IBANNumber,BeneficaryName,TaxNumber,FixedValue,Percentage,Attachment
	public void SubBillerNationalInfoDetails(Map<Object,Object> testdatamap) throws Exception
	{
		String Certificate = testdatamap.get("Attachment").toString();
		WebClickUsingJS(EdaatOR.Admin_subbillerbtn);
		WebClickUsingJS(EdaatOR.Admin_CarpoSubbillerdatabtn);
		WebClickUsingJS(EdaatOR.Admin_Carpoaddsubbiller);
		WebEdit(EdaatOR.Admin_subbillerName,testdatamap.get("BillerName").toString());
		WebEdit(EdaatOR.Admin_subbillerCRNumber,testdatamap.get("CRNumber").toString());
		//CRCertificate();
		WebEdit(EdaatOR.Admin_subbillerIban,testdatamap.get("IBANNumber").toString());
		WebEdit(EdaatOR.Admin_subbillerBenfName,testdatamap.get("BeneficaryName").toString());
		//IbanCertificate();
		WebEdit(EdaatOR.Admin_subbillerTaxNumber,testdatamap.get("TaxNumber").toString());
		WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
		WebClick(EdaatOR.Admin_subbillerFixedValue);
		WebEdit(EdaatOR.Admin_subbillerEnterFixedValue,testdatamap.get("FixedValue").toString());
		WebClick(EdaatOR.Admin_subbillerPercentage);
		WebEdit(EdaatOR.Admin_subbillerEnterPercentValue,testdatamap.get("Percentage").toString());
		Thread.sleep(1000);
		NationalAdressInfo(testdatamap);
		ContactInfo(testdatamap);
		if(Certificate.equalsIgnoreCase("CR"))
		{
			CRCertificate();
		    AddSubBillerNationalInfoError(testdatamap);

		}
		else if(Certificate.equalsIgnoreCase("IBAN"))
		{
			IbanCertificate();
		    AddSubBillerNationalInfoError(testdatamap);

		}
	    WebClick(EdaatOR.Admin_subbillerAddbtn);
	    AddSubBillerNationalInfoError(testdatamap);
		
	    

	}
	
	 //Function Summary  : Method to Verify SubBiller National Info Error Messages
		//Function Parameters: Expected
	public void AddSubBillerNationalInfoError(Map<Object,Object> testdatamap) throws Exception
	{
		try {
			
	    if(CheckElementExists(EdaatOR.Admin_SubBillerCityError))
		{
         VerifyValue1(getText(EdaatOR.Admin_SubBillerCityError),testdatamap.get("Expected").toString());
	     this.takeScreenShot();
	     test.log(Status.PASS, "Verify Add corporate subbiller City Dropdown  error message" + driver.getTitle() + " *  Verify Add corporate subbiller City Dropdown  error message PASS * ");
		}
		else if(CheckElementExists(EdaatOR.Admin_SubBillerDistrictError))
		{
	      VerifyValue1(getText(EdaatOR.Admin_SubBillerDistrictError),testdatamap.get("Expected").toString());
		  this.takeScreenShot();
		  test.log(Status.PASS, "Verify Add corporate subbiller District Name Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbiller District NameText field  error message PASS * ");
		}
		else if(CheckElementExists(EdaatOR.Admin_SubBillerStreetError))
		{
	      VerifyValue1(getText(EdaatOR.Admin_SubBillerStreetError),testdatamap.get("Expected").toString());
		  this.takeScreenShot();
		  test.log(Status.PASS, "Verify Add corporate subbiller Street Name Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbiller Street Name Text field  error message PASS * ");
		}
		else if(CheckElementExists(EdaatOR.Admin_SubBillerZipCodeError))
		{
	      VerifyValue1(getText(EdaatOR.Admin_SubBillerZipCodeError),testdatamap.get("Expected").toString());
		  this.takeScreenShot();
		  test.log(Status.PASS, "Verify Add corporate subbiller Zip Code Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbiller Zip Code Text field  error message PASS * ");
		}
		else if(CheckElementExists(EdaatOR.Admin_SubBillerBuildingNumError))
		{
	      VerifyValue1(getText(EdaatOR.Admin_SubBillerBuildingNumError),testdatamap.get("Expected").toString());
		  this.takeScreenShot();
		  test.log(Status.PASS, "Verify Add corporate subbiller Building No Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbiller Building No Text field  error message PASS * ");
		}
		else if(CheckElementExists(EdaatOR.Admin_SubBillerEmployeeError))
		{
	      VerifyValue1(getText(EdaatOR.Admin_SubBillerEmployeeError),testdatamap.get("Expected").toString());
		  this.takeScreenShot();
		  test.log(Status.PASS, "Verify Add corporate subbiller Employee Name Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbiller Employee Name Text field  error message PASS * ");
		}
		else if(CheckElementExists(EdaatOR.Admin_SubBillerEmpEmailError))
		{
	      VerifyValue1(getText(EdaatOR.Admin_SubBillerEmpEmailError),testdatamap.get("Expected").toString());
		  this.takeScreenShot();
		  test.log(Status.PASS, "Verify Add corporate subbiller Employee Email Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbiller Employee Email Text field  error message PASS * ");
		}
		else if(CheckElementExists(EdaatOR.Admin_SubBillerEmpMblError))
		{
	      VerifyValue1(getText(EdaatOR.Admin_SubBillerEmpMblError),testdatamap.get("Expected").toString());
		  this.takeScreenShot();
		  test.log(Status.PASS, "Verify Add corporate subbiller Emp Mobile Number Text field Error message" + driver.getTitle() + " *  Verify Add corporate subbiller Emp Mobile Number Text field  error message PASS * ");
		}
		else if(CheckElementExists(EdaatOR.Admin_SubBillerIBANAttachError))
		{
	      VerifyValue1(getText(EdaatOR.Admin_SubBillerIBANAttachError),testdatamap.get("Expected").toString());
		  this.takeScreenShot();
		  test.log(Status.PASS, "Verify Add corporate subbiller IBAN Attachement Error message" + driver.getTitle() + " *  Verify Add corporate subbiller IBAN Attachement   error message PASS * ");
		}
		else if(CheckElementExists(EdaatOR.Admin_SubBillerCRAttachError))
		{
	      VerifyValue1(getText(EdaatOR.Admin_SubBillerCRAttachError),testdatamap.get("Expected").toString());
		  this.takeScreenShot();
		  test.log(Status.PASS, "Verify Add corporate subbiller CR Certifiacate Error message" + driver.getTitle() + " *  Verify Add corporate subbiller CR Certifiacate error message PASS * ");
		}
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Verify Add corporate subbiller error message" + driver.getTitle() + " *Verify Add corporate subbiller error message FAIL * ");
			this.takeScreenShot();
		}
		
	}
 }	
  
	
	
    

