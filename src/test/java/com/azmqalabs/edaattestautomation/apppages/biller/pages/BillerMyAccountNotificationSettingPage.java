/**
* Test Script Name  				 : N/A
* Objective                          : Verify the MY Account Functionality.
* Version      						 : 1.0
* Author       						 : Kathirvelu Mohan
* Created Date 			      		 : 11/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : 
* Pre-Conditions					 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
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
import com.azmqalabs.edaattestautomation.common.Log;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class BillerMyAccountNotificationSettingPage extends BasePage
{

	public BillerMyAccountNotificationSettingPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Notificationsym)
	public WebElement NotificationSettings;
		
	    
	    public boolean Exists(){
	    	return super.Exists(NotificationSettings); 
		}

	  //Function Summary :Method to Verify sms toggle button Myaccount module. 
	//Parameter Summary: N/A.
	  
		public void VerifySmstoggle(Log Log) {
			// TODO Auto-generated method stub
			try {
		        WebClick(EdaatOR.Biller_MyAccountbtn);
		        Thread.sleep(1000);
		        WebClickUsingJS(EdaatOR.Biller_Notificationbtn);
		        Thread.sleep(2000);
		        WebClickUsingJS(EdaatOR.Biller_SMSTogglebtn);	
		        verifyElementIsPresent(EdaatOR.Biller_ConformActivationpop);
				WebClickUsingJS(EdaatOR.Biller_ActiveTogglebtn);
		        Thread.sleep(2000);		       
		        WebClickUsingJS(EdaatOR.Biller_SMSTogglebtn);
		        WebClickUsingJS(EdaatOR.Biller_CancalTogglebtn);
		        Thread.sleep(2000);		   
		    	 verifyElementIsPresent(EdaatOR.Biller_CancalActivationpop);
		        Thread.sleep(2000);
		        
		        
	        	this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify toggle button is successful" + driver.getTitle() +" * MyAccount PASS * " );	
				Log.ReportEvent("PASS", " Verify Sms toggle button of Notification settings is Suceessfull");
			}
			catch(Exception e){
				test.log(Status.FAIL,"#FUNC-Verify toggle button is Failed" + driver.getTitle() +" * MyAccount FAIL * " );
				this.takeScreenShot();
			}
			
			
		}
	//Function Summary :Method to VerifyPushNotificationToggel
	    //Parameter Summary:Active,InActive
		public void VerifyPushNotificationToggel(Map<Object, Object> testdatamap,Log Log) {
			
			try
			{
				String Active = testdatamap.get("Active").toString();
				String InActive = testdatamap.get("InActive").toString();
				WebClick(EdaatOR.Biller_MyAccount_pushNotificationtoggelbtn);
				Thread.sleep(1000);
				if(CheckElementExists("//h5[text()='"+Active+"']")==true)
				{
				VerifyValue1(getText("//h5[text()='"+Active+"']"),Active);
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.Biller_MyAccount_pushNotification_Confirmbtn);
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_MyAccount_pushNotificationtoggelbtn);
				Thread.sleep(2000);
				VerifyValue1(getText("//h5[text()='"+InActive+"']"),InActive);
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.Biller_MyAccount_pushNotification_Confirmbtn);
				}
				else
				{
					VerifyValue1(getText("//h5[text()='"+InActive+"']"),InActive);
					Thread.sleep(2000);
					this.takeScreenShot();
					WebClick(EdaatOR.Biller_MyAccount_pushNotification_Confirmbtn);
					WebClick(EdaatOR.Biller_MyAccount_pushNotificationtoggelbtn);
					Thread.sleep(1000);
					VerifyValue1(getText("//h5[text()='"+Active+"']"),Active);
					Thread.sleep(1000);
					this.takeScreenShot();
					WebClick(EdaatOR.Biller_MyAccount_pushNotification_Confirmbtn);
				}
				test.log(Status.PASS,"#FUNC- Verify Push Notifications toggel is successful" + driver.getTitle() +" * Push Notifications toggel PASS * " );	
			  	Log.ReportEvent("PASS", " Verify Push Notifications toggel is successful");
	
			}
			catch (Exception e) {
				test.log(Status.FAIL,"#FUNC- Verify Push Notifications toggel is unsuccessful" + driver.getTitle() +" * Push Notifications toggel FAIL * " );
				this.takeScreenShot();
			}
		}
			//Function Summary :Method to Navigate MyAccount Notification Settings 
			//Parameter Summary: N/A.	
		public void NavigatetoMyAccountNotificationSettings(Log Log) throws InterruptedException
        {
            WebClick(EdaatOR.Biller_MyAccountbtn);
            Thread.sleep(1000);
            WebClickUsingJS(EdaatOR.Biller_Notificationbtn);
            Thread.sleep(2000);
            Log.ReportEvent("PASS", " Navigate to My Account Notification settings page");
        }
			//Function Summary :Method to Verify Send Email toggle button.
			//Parameter Summary: N/A.	
		public void MyAccountSendEmailToggle(Map<Object, Object> testdatamap,Log Log)
		{
			try
            {
				NavigatetoMyAccountNotificationSettings(Log);
				WebClickUsingJS(EdaatOR.Biller_MyAccount_sendEmail_togglebtn);
                if(CheckElementExists(EdaatOR.Biller_MyAccount_sendEmail_CancelActive_verify)==true)
                {
                	Thread.sleep(2000);
                    WebClickUsingJS(EdaatOR.Biller_MyAccount_sendEmail_CancelActive_yesbtn);
                    Thread.sleep(2000);
    				this.takeScreenShot();
    				WebClickUsingJS(EdaatOR.Biller_MyAccount_sendEmail_togglebtn);
                	Thread.sleep(2000);
                	VerifyValue1(getText(EdaatOR.Biller_MyAccount_sendEmail_ConfirmActive_verify),testdatamap.get("Confirm").toString());
    				this.takeScreenShot();
                	Thread.sleep(2000);
                	WebClickUsingJS(EdaatOR.Biller_MyAccount_sendEmail_ConfirmActive_yesbtn);
                    Thread.sleep(2000);
                    test.log(Status.PASS,"#FUNC Send Email notification toggle"+driver.getTitle()+" Send Email notification toggle is Succesull active and deactivate");
                    Log.ReportEvent("PASS", "  Verify Send Email Notifications toggel is successful");
                }
                else if(CheckElementExists(EdaatOR.Biller_MyAccount_sendEmail_ConfirmActive_verify)==true)
                {
                	Thread.sleep(2000);
                	WebClickUsingJS(EdaatOR.Biller_MyAccount_sendEmail_ConfirmActive_yesbtn);
                	Thread.sleep(2000);
    				WebClickUsingJS(EdaatOR.Biller_MyAccount_sendEmail_togglebtn);
                	VerifyValue1(getText(EdaatOR.Biller_MyAccount_sendEmail_CancelActive_verify),testdatamap.get("Cancel").toString());
                    WebClickUsingJS(EdaatOR.Biller_MyAccount_sendEmail_CancelActive_yesbtn);
                    test.log(Status.PASS,"#FUNC Send Email notification toggle"+driver.getTitle()+" Send Email notification toggle is Succesully deactivate and activate ");
                    Log.ReportEvent("PASS", "  Verify Send Email Notifications toggel is successful");
                }
            }
            catch (Exception e) {
                test.log(Status.FAIL,"#FUNC- Verify send Email Notifications toggel is unsuccessful" + driver.getTitle() +" * send Email Notifications toggel FAIL * " );
                this.takeScreenShot();
            }

		}
     
}