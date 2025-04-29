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
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminMyAccountPage extends BasePage
{

	public AdminMyAccountPage(WebDriver driver,ExtentTest test)
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
	//Function Summary   : Method to  Navigate My Account Page
	//Parameter Summary  : N/A
	public void NavigatetoMyAccountPage() throws InterruptedException {
	
		WebClickUsingJS(EdaatOR.Admin_MyAccount_Menu);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_MyAccount_NotificationSettings);
		Thread.sleep(1000);
		
	}
	//Function Summary   : Method to Verify Notification Settings Send Email Toggel
	//Parameter Summary  : N/A
	public void  VerifySendEmailtoggel(Log Log)
	{
		try{
			NavigatetoMyAccountPage();
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_MyAccount_SendEmailToggelBTN);
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_MyAcc_SendEmailToggelConfirmCancelActivation);
			Thread.sleep(2000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_MyAccount_SendEmailToggelBTN);
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_MyAcc_SendEmailToggelConfirmCancelActivation);
			Thread.sleep(2000);
			this.takeScreenShot();
			test.log(Status.PASS,"Verify Send Email toggel" + driver.getTitle() +" * Verify Send Email toggel PASS * " );
			Log.ReportEvent("PASS", " Verify  Send Email toggel is Sucessful");
	
		}
			catch(Exception e){
				test.log(Status.FAIL,"Verify Send Email toggel FAIL" + driver.getTitle() +" * Verify Send Email toggel FAIL * " );
				this.takeScreenShot();
			}
	}
	
	
	
	    //Function Summary   : Method to Verify Push Notifications toggle
		//Parameter Summary  : N/A
		public void  pushNotificationstoggle(Map<Object, Object>testdatamap,Log Log)
		{
			try{
				NavigatetoMyAccountPage();
				WebClickUsingJS(EdaatOR.Admin_MyAccount_PushNotificationstoggelBTN);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_MyAcc_SendEmailToggelConfirmCancelActivation);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_MyAccount_PushNotificationstoggelBTN);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_MyAcc_SendEmailToggelConfirmCancelActivation);
				Thread.sleep(2000);
				this.takeScreenShot();
			    test.log(Status.PASS,"Push Notifications toggle" + driver.getTitle() +" * Push Notifications toggle is PASS * " );
		        Log.ReportEvent("PASS", "Verify  Push Notifications toggle is Successfull");
	
			}
				catch(Exception e){
					test.log(Status.FAIL,"Verify Push Notifications toggle FAIL" + driver.getTitle() +" * Push Notifications toggle is FAIL * " );
					this.takeScreenShot();
				}
		}

//Function Summary   : Method to Verify Notification Settings Send SMS  Toggle
//Parameter Summary  : N/A
		public void  VerifySendSMStoggle(Log Log)
		{
			try{
				NavigatetoMyAccountPage();
				WebClickUsingJS(EdaatOR.Admin_MyAcc_SendSMSToggle);
				Thread.sleep(1000);
				verifyElementIsPresent(EdaatOR.Admin_MyAcc_SendSMSToggleCancelMsg);
				WebClickUsingJS(EdaatOR.Admin_MyAcc_SendEmailToggelConfirmCancelActivation);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_MyAcc_SendSMSToggle);
				Thread.sleep(1000);
				verifyElementIsPresent(EdaatOR.Admin_MyAcc_SendSMSToggleConfirmMsg);
				WebClickUsingJS(EdaatOR.Admin_MyAcc_SendEmailToggelConfirmCancelActivation);
				Thread.sleep(2000);
				this.takeScreenShot();
				test.log(Status.PASS,"Verify Send Email toggel" + driver.getTitle() +" * Verify Send Email toggel PASS * " );
		        Log.ReportEvent("PASS", " Verify Send SMS  Toggle is Successful");
	
			}
				catch(Exception e){
					test.log(Status.FAIL,"Verify Send Email toggel FAIL" + driver.getTitle() +" * Verify Send Email toggel FAIL * " );
					this.takeScreenShot();
				}
		}

}
