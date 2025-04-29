/**
* Test Script Name  				 : N/A
* Objective     					 : Verify PaidOutsideEDAAT Functionality
* Version      						 : 1.0
* Author       						 : Basavaraj Mudnur
* Created Date 			      		 : 
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

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.azmqalabs.edaattestautomation.common.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class BillerSettingsPaidOutsideEDAATBillsPage extends BasePage{
	public BillerSettingsPaidOutsideEDAATBillsPage(WebDriver driver,ExtentTest test) {

		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Settings)
	public WebElement Setting;


	public boolean Exists(){
		return super.Exists(Setting); 
	}
	//Function Summary : Navigate to Paid OutsideBillsEdaatBills page 
		//Parameter Summary: N/A
		public void navigatetoPaidOutsideBills(Log Log) {
		try {
			WebClickUsingJS(EdaatOR.Biller_Settings);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_PaidOutsidemenu);
			Thread.sleep(1000);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Verify Navigate to Paid OutsideBillsEdaatBills page " + driver.getTitle() +" * Navigate to Paid OutsideBillsEdaatBills page is Pass * " );
			Log.ReportEvent("PASS", " Verify Navigate PaidOutsideEDAATBills Page is dispayed Suceessfull");
		}
		catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
			test.log(Status.FAIL,"#FUNC-View Navigate to Paid OutsideBillsEdaatBills page " + driver.getTitle() +" * Navigate to Paid OutsideBillsEdaatBills page is Fail * " );
		}
		
		}
		
		//Function Summary : Method to upload Bulk data
		//Parameter Summary: ConfirmMsg
		public void uploadBulkData(Map<Object, Object> testdatamap,Log Log) throws InterruptedException, IOException  {
		try {
			WebClickUsingActions(EdaatOR.Biller_Attachfile);
			Thread.sleep(3000);
			File classpathRoot = new File(System.getProperty("user.dir"));
			File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//BillerSettingsPaidOutsideBills.exe");
			String sFilename = app.toString();
			Runtime.getRuntime().exec(sFilename);
			System.out.println(sFilename);
			Thread.sleep(2000);
			WebClick(EdaatOR.Biller_Proccesbtn);
			VerifyValue1(WebGetText(EdaatOR.Biller_successmsg),testdatamap.get("ConfirmMsg").toString() );
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Verify upload Bulk data " + driver.getTitle() +" * upload Bulk data is Pass * " );
		 	Log.ReportEvent("PASS", " Verify upload Bulk data Is Suceessfull");
		}
		catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
			test.log(Status.FAIL,"#FUNC-Verify upload Bulk data " + driver.getTitle() +" * Verify is Fail * " );
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
		
		public void PaidOutsideuploadBulkDataUI(Map<Object, Object> testdatamap) throws InterruptedException, IOException  {
			try {
				String File = testdatamap.get("FileType").toString();
				if(File.equalsIgnoreCase("Excel")) {
				WebClickUsingActions(EdaatOR.Biller_Attachfile);
				getAutoItImagePathFile1();
				}
				WebClick(EdaatOR.Biller_Proccesbtn);
			    this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify upload Bulk data " + driver.getTitle() +" * upload Bulk data is Pass * " );
			}
			catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
				test.log(Status.FAIL,"#FUNC-Verify upload Bulk data " + driver.getTitle() +" * Verify is Fail * " );
			}
		}
		public void PaidOutsideEdaatErrorMessageValidation(Map<Object, Object> testdatamap) throws InterruptedException, IOException
		{
			PaidOutsideuploadBulkDataUI(testdatamap);
			String Expected=testdatamap.get("ExpectedResult").toString();
			try
			{
				if(ExistsCheck(EdaatOR.Biller_Settings_PaidOutsideEdaatSelectFileError)) {
					VerifyValue(Expected,EdaatOR.Biller_Settings_PaidOutsideEdaatSelectFileError);
					test.log(Status.PASS, "#FUNC-Paid Outside Edaat Upload BulkData Error Message Exists" + driver.getTitle() + " * Paid Outside Edaat Upload BulkData Error Message Exists * ");	    	
			     }
				else if(ExistsCheck(EdaatOR.Biller_Settings_PaidOutsideEdaatInvalidFileError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_PaidOutsideEdaatInvalidFileError);
					test.log(Status.PASS, "#FUNC-Paid Outside Edaat Upload BulkData Error Message Exists" + driver.getTitle() + " * Paid Outside Edaat Upload BulkData Error Message Exists * ");
				}	
				else {

					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
					  }
			}
			catch (Exception e) {
			
				test.log(Status.FAIL,"#FUNC-Paid Outside Edaat Verify to upload Bulk data " + driver.getTitle() +" * Paid Outside Edaat Verify to upload Bulk data FAIL * " );	
			}
		

	
}
}
