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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class BillerTermsmanagementPage extends BasePage
{

	public BillerTermsmanagementPage(WebDriver driver,ExtentTest test)
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
	  //Function Summary :Method to Verify grid view of termsmanagement module. 
	//Parameter Summary: N/A.
	  
		public void VerifyGridView() {
			// TODO Auto-generated method stub
			try {
		        WebClick(EdaatOR.Biller_Settingbtn);
		        Thread.sleep(1000);
		        WebClickUsingJS(EdaatOR.Biller_Termsmanagementbtn);
		        Thread.sleep(2000);
		        verifyElementIsPresent(EdaatOR.Biller_Termsmanagementsym);		       
		        verifyElementIsPresent(EdaatOR.Biller_Termsnameinarabic);		       
	        	Thread.sleep(2000);
	        	this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify gridview is successful" + driver.getTitle() +" * TermsMangement PASS * " );	
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify gridview is Failed" + driver.getTitle() +" * TermsMangement FAIL * " );
				this.takeScreenShot();
			}
			
			
		}

}