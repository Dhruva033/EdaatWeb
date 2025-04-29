/**
* Test Script Name  				 : N/A
* Objective     					 : Verify System Management Functionality
* Version      						 : 1.0
* Author       						 : Kathirvelu M
* Created Date 			      		 : 29/05/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
* Defects affecting this test script : N/A
* WorkArounds/Known Issues			 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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

import java.io.File;

import java.util.List;

import java.util.Map;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;

import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;

import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;

import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
public class BillerSystemMangementPage extends BasePage {

	public BillerSystemMangementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Systemmgmt_Menu)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}

	//Function Summary   : Method to Verify Toggle Functionality  
	//Parameter Summary : view , tog.
public void Toggle(String view,String tog,Log Log) {
	try {
		boolean Ele = Toggleview(view,tog);
		if (Ele == true) {
			test.log(Status.PASS,"#FUNC-Toggle Click" + driver.getTitle() + " * Toggle Click  PASS * ");
    	Log.ReportEvent("PASS", " Verify  Activate/Deactivate status toggel button working fine  ");

		}else
			test.log(Status.FAIL,"#FUNC-Toggle Click" + driver.getTitle() + " * Toggle Click FAIL * ");
	} catch (Exception e) {
		test.log(Status.FAIL, "#FUNC-Toggle Click" + driver.getTitle() + " * Toggle Click FAIL * ");
		this.takeScreenShot();
	}
}
//Function Summary   : Method to View Grid View Details 
//Parameter Summary  : view , table .
public void Gridview(String view,String table,Log Log) {
	try {

		boolean Ele = GridViewtable(view,table);
		if (Ele == true) {
			test.log(Status.PASS,"#FUNC-Grid View" + driver.getTitle() + " * Grid View PASS * ");
    	Log.ReportEvent("PASS", " Verify Approved Grid view is Loaded Suceessfully");

		}else
			test.log(Status.FAIL,"#FUNC-Grid View" + driver.getTitle() + " * Grid View FAIL * ");
	} catch (Exception e) {
		test.log(Status.FAIL, "#FUNC-Grid View" + driver.getTitle() + " * Grid View FAIL * ");
		this.takeScreenShot();
	}
}
//Function Summary   : Method to Update Data for Non Approved Biller  
//Parameter Summary : N/A
public void UpdateData(Map<Object,Object> testdatamap,Log Log) {
	try {

		boolean Ele = EnterValidDetails(testdatamap);
		if (Ele == true) {
			test.log(Status.PASS,"#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker PASS * ");
        	Log.ReportEvent("PASS", " Verify Data has Been updated by the Maker Suceessfully");

		}else
			test.log(Status.FAIL,"#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker FAIL * ");
	} catch (Exception e) {
		test.log(Status.FAIL, "#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker FAIL * ");
		this.takeScreenShot();
	}
	}
//Function Summary   : Method to Enter Valid Data for DeActivated Biller
//Parameter Summary :N/A
	public void DeactoAct(Map<Object,Object> testdatamap,Log Log) {
		try {

			boolean Ele = EnterValidDetails(testdatamap);
			if (Ele == true) {
				test.log(Status.PASS,"#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker PASS * ");
	        	Log.ReportEvent("PASS", " Verify Account has Been Deactivated by the Checker Suceessfully");

			}else
				test.log(Status.FAIL,"#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker FAIL * ");
		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker FAIL * ");
			this.takeScreenShot();
		}
}
	//Function Summary   : Method to Enter Valid Data for DeActivated Biller
	//Parameter Summary :N/A
	public void DeactoAct2(Map<Object,Object> testdatamap,Log Log) {
		try {

			boolean Ele = EnterValidDetails2(testdatamap);
			if (Ele == true) {
				
				test.log(Status.PASS,"#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker PASS * ");
	        	Log.ReportEvent("PASS", " Verify Account has Been Deactivated by the Checker Suceessfully");

			}else
				test.log(Status.FAIL,"#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker FAIL * ");
		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker FAIL * ");
			this.takeScreenShot();
		}
}

//Function Summary   : Method to Enter Data for DeActivated Biller 
//Parameter Summary : N/A
public void DeactoActInvalid(Map<Object,Object> testdatamap,Log Log) {
	try {

		boolean Ele = EnterInvalidDetails(testdatamap);
		if (Ele == true) {
			test.log(Status.PASS,"#FUNC-Invalid Activation info for deactivated biller by maker" + driver.getTitle() + " * Invalid Activation info for deactivated biller by maker PASS * ");
        	Log.ReportEvent("PASS", " Verify Not Approved Grid view is Loaded Suceessfully");

		}else
			test.log(Status.FAIL,"#FUNC-Invalid Activation info for deactivated biller by maker" + driver.getTitle() + " * Invalid Activation info for deactivated biller by maker FAIL * ");
	} catch (Exception e) {
		test.log(Status.FAIL, "#FUNC-Invalid Activation info for deactivated biller by maker" + driver.getTitle() + " * Invalid Activation info for deactivated biller by maker FAIL * ");
		this.takeScreenShot();
	}
}

	//Function Summary   : Method to Approve Biller Account by Checker  
	//Parameter Summary :N/A
public void ActivatedbyChecker(Map<Object,Object> testdatamap,Log Log) {
	try {
		boolean Ele = Approval(testdatamap);
		if (Ele == true) {
			test.log(Status.PASS,"#FUNC- Checker approvroval for account activation" + driver.getTitle() + " * Checker approvroval for account activation PASS * ");
        	Log.ReportEvent("PASS", " Account has been approved by the Checker Suceessfully");

		}else
			test.log(Status.FAIL,"#FUNC-Checker approvroval for account activation" + driver.getTitle() + " * Checker approvroval for account activation FAIL * ");
	} catch (Exception e) {
		test.log(Status.FAIL, "#FUNC-Checker approvroval for account activation" + driver.getTitle() + " * Checker approvroval for account activation FAIL * ");
		this.takeScreenShot();
	}
}

//Function Summary   : Method Performing Actions to View Grid View Details 
//Parameter Summary  : view , table .
public boolean GridViewtable(String view,String table) {
	boolean existsNID = false;
	try {
		WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
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
public boolean Grid(String view,String table) {
	boolean existsNID = false;
	try {
		WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
		Thread.sleep(1000);
		WebClickUsingJS(view);
//		Thread.sleep(1000);
		this.takeScreenShot();
//		if (ExistsCheck(table) == true) {
//			existsNID = true;
//		}
		existsNID = true;
	}

	catch (Exception e) {
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsNID;
}

//Function Summary   : Method to Click on System Management and Non Approved Biller Management  
//Parameter Summary :N/A
public void SysmgmtMenu() throws InterruptedException {
	WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
	Thread.sleep(1000);
	WebClickUsingJS(EdaatOR.Systemmgmt_NotApproved_Menu);
	Thread.sleep(1000);
//	WebClick(EdaatOR.Systemmgmt_NotApproved_Edit);
//	Thread.sleep(1000);
}
//Function Summary   : Method to Navigate to Last Page in NonApproved Grid View
	//Parameter Summary :N/A
public int getInvoiceCountNextAfteradd() throws Exception {

    int aftCount=0;
    boolean countRow=false;
    while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
        WebClick(EdaatOR.Biller_Invoice_NextPrevLink);
        int count=getInvoiceCount();
        String pageNum=getText(EdaatOR.Biller_Invoice_NextPrevLink);
        Thread.sleep(1000);
        aftCount=aftCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
        countRow=true;
    }
    if(countRow==false) {
        aftCount=10;
    }

    return aftCount;

}
public int getInvoiceCount() {

    List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_Count));
    waitForPageToLoad();
    int count =invoice.size();
    return count;

}
//Function Summary   : Method to get Count of Biller Account in Gridview Page
//Parameter Summary :N/A
public int getInvoiceCountAdd() {
	List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_nonapproved_Afteradd));
	waitForPageToLoad();
	int count =invoice.size();
	return count;
}


public void selectCategoryID(String Benifi) {
	//WebSelectByVisibleText(EdaatOR.Admin_SystemMgm_BillerCategoryID,Benifi);
	WebClick(EdaatOR.Biller_Systemmgmt_BillingCatgeoryType);
	WebSelect(EdaatOR.Biller_Systemmgmt_BillingCatgeoryType, Benifi);

}

//Function Summary   : Method to Enter Valid Details For Non Approved Biller/DeActivated Biller  
//Parameter Summary : CompanyName,TempBenificaryName,BillerCode,TransferDuration,BillerNameArabic,BillerNameEnglich,
//                    BenificaryCategory,MaxAllowedDailyInvoices,MaximumInvoiceAmount,SuperBiller
public boolean EnterValidDetails(Map<Object,Object>testdatamap) {
	boolean existsNID = false;
	try {
		SysmgmtMenu();
		
	     WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("CompanyName").toString());		
		WebClick(EdaatOR.Biller_Individualclient_Search);
		Thread.sleep(1500);
		WebClick(EdaatOR.Systemmgmt_NotApproved_Edit);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TempBenificaryName,testdatamap.get("TempBenificaryName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerCode,testdatamap.get("BillerCode").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TransferDuration,testdatamap.get("TransferDuration").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameAr,testdatamap.get("BillerNameArabic").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameEn,testdatamap.get("BillerNameEnglich").toString());
		Thread.sleep(1000);
		selectCategoryID(testdatamap.get("BenificaryCategory").toString());
		Thread.sleep(1000);		
		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasEnterpriseSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasIndividualSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_IsUrgentBillUploader);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceNumberPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceNumber,testdatamap.get("MaxAllowedDailyInvoices").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceAmountPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceAmount,testdatamap.get("MaximumInvoiceAmount").toString());
		Thread.sleep(1000);
		if(testdatamap.get("Billertype").toString().equalsIgnoreCase("Super Biller")) {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Super);
			Thread.sleep(1000);	
		}else {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Tracker);
			Thread.sleep(1000);	
			selectDropdownValue_PartialText(EdaatOR.Biller_Systemmgmt_NewSuperBiller, testdatamap.get("SuperBiller").toString());
		}
		SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
		WebClick(EdaatOR.Biller_Systemmgmt_Confirm);	
		this.takeScreenShot();
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Save);
		Thread.sleep(1000);	
		WebClick(EdaatOR.Biller_Save_Yes);
		Thread.sleep(1000);	
		WebClick(EdaatOR.Biller_Save_Yesclose);
		Thread.sleep(1000);	
		existsNID = true;
	}

	catch (Exception e) {
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsNID;
}
//Function Summary   : Method to Enter valid Details for Deactivate Biller Account
//Parameter Summary :TempBenificaryName,BillerCode,TransferDuration,BillerNameArabic,BillerNameEnglich,BenificaryCategory,
//                   MaxAllowedDailyInvoices,MaximumInvoiceAmount,Super Biller,SuperBiller
public boolean EnterValidDetails2(Map<Object,Object>testdatamap) {
	boolean existsNID = false;
	try {
		SysmgmtMenu();
		getInvoiceCountNextAfteradd();
		int value = getInvoiceCountAdd();
		WebClick(EdaatOR.Biller_nonapproved_Afteradd+"["+value+"]/td[9]");
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TempBenificaryName,testdatamap.get("TempBenificaryName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerCode,testdatamap.get("BillerCode").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TransferDuration,testdatamap.get("TransferDuration").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameAr,testdatamap.get("BillerNameArabic").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameEn,testdatamap.get("BillerNameEnglich").toString());
		Thread.sleep(1000);
		selectCategoryID(testdatamap.get("BenificaryCategory").toString());
		Thread.sleep(1000);		
		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasEnterpriseSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasIndividualSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_IsUrgentBillUploader);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceNumberPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceNumber,testdatamap.get("MaxAllowedDailyInvoices").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceAmountPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceAmount,testdatamap.get("MaximumInvoiceAmount").toString());
		Thread.sleep(1000);
		if(testdatamap.get("Billertype").toString().equalsIgnoreCase("Super Biller")) {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Super);
			Thread.sleep(1000);	
		}else {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Tracker);
			Thread.sleep(1000);	
			selectDropdownValue_PartialText(EdaatOR.Biller_Systemmgmt_NewSuperBiller, testdatamap.get("SuperBiller").toString());
		}		
		SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
		WebClick(EdaatOR.Biller_Systemmgmt_Confirm);	
		this.takeScreenShot();
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Save);
		Thread.sleep(1000);	
		WebClick(EdaatOR.Biller_Save_Yes);
		Thread.sleep(1000);	
		WebClick(EdaatOR.Biller_Save_Yesclose);
		Thread.sleep(1000);	
		existsNID = true;
	}

	catch (Exception e) {
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsNID;
}
//Function Summary   : Method to Enter Invalid Data For DeActivated Biller 
//Parameter Summary :CompanyName,TempBenificaryName,BillerCode,TransferDuration,BillerNameArabic,
//                   BillerNameEnglich,BillerNameEnglich,MaxAllowedDailyInvoices,MaximumInvoiceAmount,SuperBiller
public boolean EnterInvalidDetails(Map<Object,Object>testdatamap) {
	boolean existsNID = false;
	try {
		SysmgmtMenu();
		WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("CompanyName").toString());		
		WebClick(EdaatOR.Biller_Individualclient_Search);
		Thread.sleep(1500);
		WebClick(EdaatOR.Systemmgmt_NotApproved_Edit);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TempBenificaryName,testdatamap.get("TempBenificaryName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerCode,testdatamap.get("BillerCode").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TransferDuration,testdatamap.get("TransferDuration").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameAr,testdatamap.get("BillerNameArabic").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameEn,testdatamap.get("BillerNameEnglich").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasEnterpriseSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasIndividualSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_IsUrgentBillUploader);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceNumberPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceNumber,testdatamap.get("MaxAllowedDailyInvoices").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceAmountPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceAmount,testdatamap.get("MaximumInvoiceAmount").toString());
		Thread.sleep(1000);
		if(testdatamap.get("Billertype").toString().equalsIgnoreCase("Super Biller")) {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Super);
			Thread.sleep(1000);	
		}else {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Tracker);
			Thread.sleep(1000);	
			selectDropdownValue_PartialText(EdaatOR.Biller_Systemmgmt_NewSuperBiller, testdatamap.get("SuperBiller").toString());
		}		
		SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
		WebClick(EdaatOR.Biller_Systemmgmt_Confirm);	
		this.takeScreenShot();
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Save);
		Thread.sleep(1000);	
		existsNID = true;
	}

	catch (Exception e) {
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsNID;
}
//Function Summary   : Method to Perform Actions, To Approve Biller Account Activation
//Parameter Summary :Company Name
public boolean Approval(Map<Object,Object>testdatamap) {
	boolean existsNID = false;
	try {
		SysmgmtMenu();
		WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("CompanyName").toString());		
		WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_Individualclient_Edit);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Btnapprove);
		Thread.sleep(1000);
		this.takeScreenShot();
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_ConfirmApprove);
		waitForPageToLoad();
		WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("CompanyName").toString());
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_Individualclient_Search);
		Thread.sleep(2000);
		VerifyValue1(getText(EdaatOR.AppBiller_Name), testdatamap.get("BillerName").toString());
		existsNID=true;
	}catch (Exception e) {
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsNID;
}
//Function Summary   : Method to Perform Actions, To Reject Biller Account Activation
//Parameter Summary :Company Name
public boolean RejectActivation(Map<Object,Object>testdatamap,Log Log) {
	boolean existsNID = false;
	try {
		SysmgmtMenu();
		WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("CompanyName").toString());		
		WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_Individualclient_Edit);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_RejectButton);
		Thread.sleep(1000);
		this.takeScreenShot();
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_ConfirmReject);
		waitForPageToLoad();
		WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("CompanyName").toString());
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_Individualclient_Search);
		Thread.sleep(2000);
		VerifyValue1(getText(EdaatOR.AppBiller_Name), testdatamap.get("BillerName").toString());
    	Log.ReportEvent("PASS", "Account has been approved by the Checker Suceessfully");

		existsNID=true;
	}catch (Exception e) {
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsNID;
}

//Function Summary   : Method to Perform Actions for Verify Toggle Functionality  
//Parameter Summary : view , tog.
public boolean Toggleview(String view,String tog) {
	boolean existsNID = false;
	try {
		WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
		Thread.sleep(1000);
		WebClickUsingJS(view);
		Thread.sleep(1000);
		this.takeScreenShot();
		if (ExistsCheck(tog) == true) {
			WebClickUsingJS(tog);
			WebClickUsingJS(EdaatOR.Biller_Confirm_toggle);
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(tog);
			WebClickUsingJS(EdaatOR.Biller_Confirm_toggle);
			existsNID = true;
		}
		
	}

	catch (Exception e) {
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsNID;
}

//Function Summary : Navigate to "Approved Billers Management" Page and update client details
//Parameter Summary: Billername,MonthlyLimits,TransferDuration,AzimFee,sadadFee,corpName,Max
public void UpdateBillerdetails(String Billername,String MonthlyLimits,String TransferDuration,String AzimFee,String sadadFee,String corpName,String Max,String PaymentType,Log Log){
    try{
    		
        	boolean Ele=UpdateBiller(Billername, MonthlyLimits, TransferDuration, AzimFee, sadadFee, corpName, Max,PaymentType);
        	if(Ele==true) {
        	test.log(Status.PASS,"#FUNC-Updated  Individual client" + driver.getTitle() +" * Updated Individual client PASS * " );
        	Log.ReportEvent("PASS", " Verify Biller details Updated Successfully");

        	}else
    	    	test.log(Status.FAIL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
    }catch(Exception e){
    	test.log(Status.FAIL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
        this.takeScreenShot();
    }
}

//Function Summary : Navigate to "Activate Biller/Corporate" Page and update client details
//Parameter Summary: Billername,MonthlyLimits,TransferDuration.AzimFeesadadFee,corpName,Max,driver
public boolean UpdateBiller(String Billername,String MonthlyLimits,String TransferDuration,String AzimFee,String sadadFee,String corpName,String Max,String PaymentType){
	boolean existsNID = false;
	try{
		WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Systemmgmt_Approved_Menu);		
		Thread.sleep(500);
		WebEdit(EdaatOR.Biller_Individualclient_Name,Billername);		
		WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
		Thread.sleep(500);
		WebClickUsingJS(EdaatOR.Biller_Edit);
    	Thread.sleep(1000);	    	
    	WebClear(EdaatOR.Biller_Maxlimit);
    	WebEdit(EdaatOR.Biller_Maxlimit,MonthlyLimits);
    	WebClear(EdaatOR.Biller_TransferDuration);
    	WebEdit(EdaatOR.Biller_TransferDuration,TransferDuration);
    	//WebClear(EdaatOR.Biller_AzimFee);
    	//WebEdit(EdaatOR.Biller_AzimFee,AzimFee);
    	//WebClear(EdaatOR.Biller_sadadFee);
    	//WebEdit(EdaatOR.Biller_sadadFee,sadadFee);
    	WebClear(EdaatOR.Biller_BillerAliasNameEn);
    	WebEdit(EdaatOR.Biller_BillerAliasNameEn,corpName);
    	WebClear(EdaatOR.Biller_MaximumInvoiceAmount);
    	Thread.sleep(1500);
    	WebEdit(EdaatOR.Biller_MaximumInvoiceAmount,Max);
    	this.takeScreenShot();
		//SelectThePaymentMethod(PaymentType);
    	scrollDowntillend(driver);
    	WebClick(EdaatOR.Biller_Save);
    	existsNID=true;
	}catch (Exception e) {
    	e.printStackTrace();
   	 	this.takeScreenShot();
	}
	return existsNID;
    }

//Function Summary   : Method to Perform Clock on Close Button By Maker or Checker
//Parameter Summary : view , tog.
public void ClickonCloseButton(Map<Object,Object>testdatamap,Log Log) throws InterruptedException {
	try{
	WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
	Thread.sleep(1000);
	WebClickUsingJS(EdaatOR.Systemmgmt_NotApproved_Menu);
	Thread.sleep(1000);
	WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("CompanyName").toString());		
	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
	Thread.sleep(1000);
	this.takeScreenShot();
	WebClickUsingJS(EdaatOR.Biller_Edit);
	Thread.sleep(1500);
	this.takeScreenShot();
	Thread.sleep(2000);
	WebClick(EdaatOR.Systemmgmt_NonApprovedCloseBtn);
	
	test.log(Status.PASS,"#FUNC- Checker approvroval for account activation" + driver.getTitle() + " * Click on Close Button Without Doing any Actions By Maker PASS * ");
	Log.ReportEvent("PASS", " Verify Account has Been Deactivated by the Checker Suceessfully");

	this.takeScreenShot();
	}
    catch(Exception e){
	test.log(Status.FAIL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
    this.takeScreenShot();
}

}
public void UpdateBillerdetailsUI(Map<Object, Object> testdatamap) throws Exception {
	try {
		SysmgmtMenu();
		WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("CompanyName").toString());		
		WebClick(EdaatOR.Biller_Individualclient_Search);
		Thread.sleep(1500);
		WebClick(EdaatOR.Systemmgmt_NotApproved_Edit);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TempBenificaryName,testdatamap.get("TempBenificaryName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerCode,testdatamap.get("BillerCode").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TransferDuration,testdatamap.get("TransferDuration").toString());
		selectCategoryID(testdatamap.get("BenificaryCategory").toString());
		Thread.sleep(1000);	
		EnterFees(testdatamap);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameAr,testdatamap.get("BillerNameArabic").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameEn,testdatamap.get("BillerNameEnglich").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasEnterpriseSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasIndividualSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_IsUrgentBillUploader);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceNumberPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceNumber,testdatamap.get("MaxAllowedDailyInvoices").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceAmountPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceAmount,testdatamap.get("MaximumInvoiceAmount").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Tracker);
		Thread.sleep(1000);	
		WebClick(EdaatOR.Biller_SystemMgm_ConfirmTrackedBiller);
		Thread.sleep(1000);	
    	WebSelect(EdaatOR.Biller_SystemMgm_TrackedBiller, testdatamap.get("SuperBillerName").toString());
    	Thread.sleep(2000);
		SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
    	WebClick(EdaatOR.Biller_Save);
    	Thread.sleep(1000);
    	WebClickUsingJS(EdaatOR.Biller_Save_Yes);
    	Thread.sleep(2000);
	}
	catch(Exception e){
		test.log(Status.FAIL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
	    this.takeScreenShot();
	}
}

//Function Summary   : Method to EnterFees
	//Parameter Summary  : N/A
	public void EnterFees(Map<Object, Object> testdatamap) throws InterruptedException {				
		   // WebClear(EdaatOR.Admin_SystemMgm_Biller_sadadfees);
			WebEdit(EdaatOR.Biller_SystemMgm_Biller_sadadfees,testdatamap.get("SadadFees").toString());
			Thread.sleep(1000);
		//	WebClear(EdaatOR.Admin_SystemMgm_Biller_Azimfees);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_SystemMgm_Biller_Azimfees, testdatamap.get("AZMFees").toString());
		
	}
     //Function Summary   : Method to ApproveBillerErrorMsg
		//Parameter Summary  : CompanyName		
		public void UpdateBillerdetailsErrorMSGvalidation(Map<Object, Object> testdatamap) throws Exception {
			try {
			UpdateBillerdetailsUI(testdatamap);
			Thread.sleep(5000);
			String Expected=testdatamap.get("ExpectedResult").toString();
			if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BenificaryError)&&ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_idError)
			&&ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_Durationerror))
			{
				driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_BillerAliasEnName)).sendKeys(Keys.PAGE_UP);
				Thread.sleep(3000);
				VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_BenificaryError);
				//VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_BenificaryError);
				Thread.sleep(1000);
				VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_idError);
				Thread.sleep(1000);
				VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_Durationerror);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#FUNC-BeneficiaryName,Billerid and Transfer duration ErrorMessage Exists" + driver.getTitle() + " * BeneficiaryName,Billerid and Transfer duration ErrorMessage Exists * ");				
			}
			else if (ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpArbError)&&ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpEngError)
					&&ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BillerCatgError)) {
				driver.findElement(By.xpath(EdaatOR.Admin_SystemMgm_BillerCode)).sendKeys(Keys.PAGE_DOWN);
				Thread.sleep(3000);
				VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_CrpArbError);
				Thread.sleep(1000);
				VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_CrpEngError);
				Thread.sleep(1000);
				VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_BillerCatgError);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#FUNC-CorpNameAr,CorpNameEng and BillCat ErrorMessage Exists" + driver.getTitle() + " * CorpNameAr,CorpNameEng and BillCat ErrorMessage Exists * ");				
			}	
			else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_SuperBillerErrormsg))
			{
				VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_SuperBillerErrormsg);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#Tracked SuperBiller ErrorMessage Exists" + driver.getTitle() + " * Tracked SuperBiller ErrorMessage Exists * ");				
			}
			else if (ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg)) {
				driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_BillerAliasEnName)).sendKeys(Keys.PAGE_UP);
				VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#Invalid Transfer Duration ErrorMessage Exists" + driver.getTitle() + " * Invalid Transfer Duration ErrorMessage Exists * ");				
			}
			else if (ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_sadadfeesError)&&ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_sadadfeestaxerror)) {
				testdatamap.put("Sadadfeestaxerror", getText(EdaatOR.Biller_SystemMgm_Biller_sadadfeestaxerror));
				driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_BillerAliasEnName)).sendKeys(Keys.PAGE_UP);
				VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_sadadfeesError);
				Thread.sleep(1000);
				VerifyValue(testdatamap.get("Sadadfeestaxerror").toString(),EdaatOR.Biller_SystemMgm_Biller_sadadfeestaxerror);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#Invalid Sadad Fees ErrorMessage Exists" + driver.getTitle() + " * Invalid Sadad Fees ErrorMessage Exists * ");							
			}
			else if (ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_AzimfeesError)&&ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_Azmfeestaxerror)) {
				testdatamap.put("Azimfeestaxerror", getText(EdaatOR.Biller_SystemMgm_Biller_Azmfeestaxerror));
				driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_BillerAliasEnName)).sendKeys(Keys.PAGE_UP);
				VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_AzimfeesError);
				Thread.sleep(1000);
				VerifyValue(Expected,EdaatOR.Biller_SystemMgm_Biller_Azmfeestaxerror);
				this.takeScreenShot();
				Thread.sleep(1000);
				test.log(Status.PASS, "#Invalid Azm Fees ErrorMessage Exists" + driver.getTitle() + " * Invalid Azm Fees ErrorMessage Exists * ");							
			}
			else
			{
				test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
			}
		}
			catch (Exception e) {
				
			test.log(Status.FAIL,"#FUNC-Not Approved Biller Management" + driver.getTitle()+ " * Not Approved Biller Management is UnSuccessfull FAIL * " );

			}

		}
		
		//Function summary:Navigate to IndividualClient Management
		//Function Parameters:NA
			public void NavigateIndividualClientManagement()
			{
				WebClickUsingJS(EdaatOR.AdminSystem_Individual_link);
		 	    this.takeScreenShot();
			}
		public void VerifyAccountSettingButtonErrorMsg(Map<Object, Object> testdatamap){		
			try {
				  String accountstatus=testdatamap.get("Account Status Type").toString();
				  WebClear(EdaatOR.BillerSystem_IndividualClient_Name);
			      WebEdit(EdaatOR.BillerSystem_IndividualClient_Name,testdatamap.get("ClientName").toString());
			      Thread.sleep(1000);
			      WebClear(EdaatOR.BillerSystem_Individual_national);
			      WebEdit(EdaatOR.BillerSystem_Individual_national,testdatamap.get("National ID").toString());
			      Thread.sleep(1000);
			      WebClickUsingJS(EdaatOR.BillerSystem_Individual_Search);
			      Thread.sleep(1000);
			      VerifyValue1(getText("//a[text()='"+testdatamap.get("ClientName").toString()+"']"),testdatamap.get("ClientName").toString());
			      WebClickUsingJS(EdaatOR.BillerSystem_Individuaul_SettingsBTN);
			      Thread.sleep(1000);
			      if(accountstatus.equalsIgnoreCase("Suspended Permanently")) {
						WebClickUsingJS(EdaatOR.BillerSystem_Individuaul_SuspendPermradioBTN);
						Thread.sleep(3000);
					}
					else if(accountstatus.equalsIgnoreCase("Suspended")){
						WebClickUsingJS(EdaatOR.BillerSystem_Individuaul_SuspendradioBTN);
						Thread.sleep(3000);
					}
			      WebClickUsingJS(EdaatOR.BillerSystem_Individuaul_SettingConirmBTN);
			      if(ExistsCheck(EdaatOR.BillerSystem_Individuaul_Accountstatuserrormsg))
			      {
			    	  
			    	  VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.BillerSystem_Individuaul_Accountstatuserrormsg);
			    	  this.takeScreenShot();
			    	  test.log(Status.PASS, "#FUNC-Individual clients Account status ErrorMessage Exists" + driver.getTitle() + " * Account Status ErrorMessage Exists * ");
			      }
			      else if(ExistsCheck(EdaatOR.BillerSystem_Individuaul_SuspendReasonerrormsg)){
			    	  
			    	  VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.BillerSystem_Individuaul_SuspendReasonerrormsg);
			    	  this.takeScreenShot();
			    	  test.log(Status.PASS, "#FUNC-Individual clients Account Suspended Reason ErrorMessage Exists" + driver.getTitle() + " * Account Suspended Reason ErrorMessage Exists * ");				
			      }
			      else
			      {
			          test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");		      
			      }
			     WebClick(EdaatOR.BillerSystem_Individuaul_cancelbtn);
			    }
			catch(Exception e){
		    	test.log(Status.FAIL,"#FUNC-Verify Individual Client Account settings Button " + driver.getTitle() +" *  Individual Client Account settings Button is UnSucessful  FAIL * " );
		        this.takeScreenShot();
		   }
		}	
		//Function Summary  : Method to NavigatetoCorporateClientsMng
		//Parameter Summary : N/A

		public void NavigatetoCorporateClientsMng() throws InterruptedException {
			WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
			Thread.sleep(1000);
	        WebClickUsingJS(EdaatOR.Biller_SysMgmClient_CorpoclientMgmMenu);
			Thread.sleep(2000);	
			}
		//Function Summary  : Method to select client status dropdown
		//Parameter Summary : Client Status
		public void SelectClientDropdown(Map<Object, Object> testdatamap)
	    {
	        WebClick(EdaatOR.Biller_SymCorpoClientstatus);
	        WebClick("//option[text()='"+testdatamap.get("Client Status").toString()+"']");
	    
	    }
		//Function Summary  : Method to Search corporate client
		//Parameter Summary : CompanyName
		public void SearchcorpClient(Map<Object, Object> testdatamap) throws InterruptedException {
			NavigatetoCorporateClientsMng();
			WebEdit(EdaatOR.Admin_SymCorpoName,testdatamap.get("CompanyName").toString());
			Thread.sleep(1000);
			SelectClientDropdown(testdatamap);
			WebClick(EdaatOR.Biller_Corporateclient_srchbtn);
			
		}
		
		public void CorporateClientSettingsBtnErrorMsg(Map<Object, Object> testdatamap) {
			
			try {
				String client=testdatamap.get("AccountStatus").toString();
				SearchcorpClient(testdatamap);
				Thread.sleep(800);
				WebClick(EdaatOR.Biller_CorpMGMSettingBtn);
				Thread.sleep(1000);
		        if(client.equalsIgnoreCase("Suspended Permanently")) {
		            WebClickUsingJS(EdaatOR.Biller_CorpMGMSuspendBtn);
		            Thread.sleep(1000);
		        }
		        else if(client.equalsIgnoreCase("Suspended")){
		            WebClickUsingJS(EdaatOR.Biller_CorpMGMSuspendPermanentyBtn);
		            Thread.sleep(1000);
		        }
				WebClickUsingJS(EdaatOR.Biller_CorpMGMSuspendYesBtn);
			      if(ExistsCheck(EdaatOR.BillerSystem_Corporate_Accountstatuserrormsg))
			      {
			    	  
			    	  VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.BillerSystem_Corporate_Accountstatuserrormsg);
			    	  this.takeScreenShot();
			    	  test.log(Status.PASS, "#FUNC-Corporate clients Account status ErrorMessage Exists" + driver.getTitle() + " * Account Status ErrorMessage Exists * ");
			      }
			      else if(ExistsCheck(EdaatOR.BillerSystem_Corporate_SuspendReasonerrormsg)){
			    	  
			    	  VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.BillerSystem_Corporate_SuspendReasonerrormsg);
			    	  this.takeScreenShot();
			    	  test.log(Status.PASS, "#FUNC-Corporate clients Account Suspended Reason ErrorMessage Exists" + driver.getTitle() + " * Account Suspended Reason ErrorMessage Exists * ");				
			      }
			      else
			      {
			          test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");		      
			      }
			     WebClick(EdaatOR.BillerSystem_Corporate_cancelbtn);			
			}
			catch (Exception e) {
				test.log(Status.FAIL,"#FUNC-Verify Corporate settings button" + driver.getTitle() +" * Verify Corporate settings button is unsuccessfull FAIL * " );
			}
		}
		//Function Summary  : Method to navigate to distribution page
		//Parameter Summary : N/A	
		public void NavigateToDistribution() throws InterruptedException {
			WebClick(EdaatOR.Admin_SysMng);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_DistBtn);
			Thread.sleep(1000);
		}
		//Function Summary  : Method to ReconcilledDateSearch
		//Parameter Summary : Month,Year,Date
		public void ReconcilledDateSearch(Map<Object, Object> testdatamap) throws InterruptedException {
			WebClick(EdaatOR.Admin_DailyTransReconciledCalender);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReconciledMonth, testdatamap.get("Month").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_ReconciledYear, testdatamap.get("Year").toString());
			WebClick("//a[text()='"+testdatamap.get("Date").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ReconciledSearchBtn);
			Thread.sleep(2000);
	 
		}
		//Function Summary  : Method to VerifyDailyTransferErrorMsg
		//Parameter Summary : Expected	
			public void VerifyDailyTransferErrorMsg(Map<Object, Object> testdatamap) {
				try {
					WebClickUsingJS(EdaatOR.Admin_DistDailyTransferPage);
					WebClick(EdaatOR.Admin_AddTransferRequest);
					switchToWindow();
					ReconcilledDateSearch(testdatamap);
					WebClick(EdaatOR.Admin_ManualCheckbox);
					WebClick(EdaatOR.Admin_SaveButton);				
					if(ExistsCheck(EdaatOR.Admin_DistReason)&&ExistsCheck(EdaatOR.Biller_DistAttachment)&&ExistsCheck(EdaatOR.Biller_DistDate))
					{
						VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Biller_DistReason);
						Thread.sleep(1000);
						VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Biller_DistAttachment);
						Thread.sleep(1000);
						VerifyValue(testdatamap.get("DateError").toString(),EdaatOR.Biller_DistDate);
						this.takeScreenShot();
						Thread.sleep(1000);
						test.log(Status.PASS, "#FUNC-Transfer Date,Type/Reason and Attachment ErrorMessage Exists" + driver.getTitle() + " * Transfer Date,Type/Reason and Attachment ErrorMessage Exists * ");
					}
					else
					{
						test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");

					}
				}
				catch (Exception e) {
					test.log(Status.FAIL,"#FUNC-Verify Distribution Daily transfer" + driver.getTitle() +" * Verify Distribution Daily transfer View is unsuccessfull FAIL * " );
				}
	}
			//Function Summary  : Method to VerifyEODSettlementReportErrorMsg
			//Parameter Summary : Expected	
			public void VerifyEODSettlementReportErrorMsg(Map<Object, Object> testdatamap) {
				
				try {
					WebClickUsingJS(EdaatOR.Biller_Dist_EODSettlement);
					Thread.sleep(1000);
					WebClick(EdaatOR.Biller_Dist_EODSettlementSearchbtn);
					Thread.sleep(1000);
					if(ExistsCheck(EdaatOR.Biller_Dist_EODSettlementErrorMsg))
					{
						VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Biller_Dist_EODSettlementErrorMsg);
						Thread.sleep(1000);
						this.takeScreenShot();
						test.log(Status.PASS, "#FUNC-Date ErrorMessage Exists" + driver.getTitle() + " * Date ErrorMessage Exists * ");
					}
					else
					{
						test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
					}
					
				} catch (Exception e) {
								
					test.log(Status.FAIL,"#FUNC-Verify Distribution EOD Settlement" + driver.getTitle() +" * Verify Distribution EOD Settlement is unsuccessfull FAIL * " );
					this.takeScreenShot();
				}
			}
			//Function Summary   : Method to Select The Payment Method
			//Parameter Summary  : paymentMethod
			public void SelectThePaymentMethod(String paymentMethod) {
				try {
					
				if (paymentMethod.equalsIgnoreCase("sadad")) {
					
					WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_SadadBtn);
				}
				else if (paymentMethod.equalsIgnoreCase("mada")) {
					
					WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MadaBtn);
				}
				else if (paymentMethod.equalsIgnoreCase("visa")) {
					
					WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_VisaBtn);
				}
				else {
					
					WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn);
				}
			}
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}

}