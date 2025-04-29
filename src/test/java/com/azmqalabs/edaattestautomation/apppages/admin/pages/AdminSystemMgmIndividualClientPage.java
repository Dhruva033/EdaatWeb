/**
 *
 * Test Script Name                   : N/A
 * Objective                          : Admin Individual Clients Functionality
 * Version                            : 1.0
 * Author                             : Kathirvelu M
 * Created Date                       : 23/05/2023
 * Last Updated on                    : N/A
 * Updated By                         : Kalpana I R
 * Pre-Conditions                     : Admin login credentials* Epic Details                       : N/A
 * User Story Details                 : N/A
 **/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;

public class AdminSystemMgmIndividualClientPage extends BasePage {

	public AdminSystemMgmIndividualClientPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.AdminSystem_Individual)
	public WebElement Individual;

	public boolean Exists() {
		return super.Exists(Individual);
	}

	// Function summary:Navigate to IndividualClient Management
	// Function Parameters:NA
	public void NavigateIndividualClientManagement(Log Log) {
		try {
			WebClickUsingJS(EdaatOR.AdminSystem_Individual_link);
			if (CheckElementExists(EdaatOR.AdminSystem_Individual)) {
				Log.ReportEvent("PASS", "Individual Clients Page is Loaded Successfully");

			} else {
				Log.ReportEvent("FAIL", "Individual Clients Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Individual Clients Page is not Loaded Successfully");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();

		}

	}

	// Function summary:Verify Individual Client name is clickable.
	// Function Parameters: ClientName and National ID
	public void ClientNameClickable(Map<Object, Object> testdatamap, Log Log) {
		try {
			SearchIndividualClient(testdatamap, Log);
			WebClick("//a[text()='" + testdatamap.get("ClientName").toString() + "']");
			switchToWindow();
			Thread.sleep(1000);
			if (getText("//h6[text()='" + testdatamap.get("ClientName").toString() + "']")
					.equals(testdatamap.get("ClientName").toString())) {
				VerifyValue1(getText("//h6[text()='" + testdatamap.get("ClientName").toString() + "']"),
						testdatamap.get("ClientName").toString());
				Thread.sleep(1000);
				Log.ReportEvent("PASS", "Individual Client Name Click Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Individual Client Name Click Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Individual Client Name Click Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	// Function summary:Verify Individual Client Grid View.
	// Function Parameters: ClientName and National ID
	public void IndivudualClientGridView(Map<Object, Object> testdatamap, Log Log) {
		try {
			if (CheckElementExists(EdaatOR.AdminSystem_Individual_grid)) {
				SearchIndividualClient(testdatamap, Log);
				Log.ReportEvent("PASS", "Grid View Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Grid View Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	public void SelectradioButtton(String accountstatus) throws InterruptedException {
		if (accountstatus.equalsIgnoreCase("Suspended Permanently")) {
			WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SuspendPermradioBTN);
			Thread.sleep(3000);
		} else {
			WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SuspendradioBTN);
			Thread.sleep(3000);
		}
	}

	// Function summary:Verify Individual Client Status Activation and
	// De-activation.
	// Function Parameters: Textarea
	public void IndividualClientActivationAndDeactivation(Map<Object, Object> testdatamap, Log Log) {
		try {
			SearchIndividualClient(testdatamap, Log);
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Admin_SymIndividua_statustoggle)) {
				WebClick(EdaatOR.Admin_SymIndividua_statustoggle);
				Thread.sleep(3000);
				WebEdit(EdaatOR.Admin_SymIndividual_statustoggletextarea, testdatamap.get("Textarea").toString());
				Thread.sleep(3000);
				WebClick(EdaatOR.Admin_Symstatustoggleyesbtn);
				Thread.sleep(3000);
				WebClick(EdaatOR.Admin_SymIndividua_statustoggle);
				Thread.sleep(2000);
				WebEdit(EdaatOR.Admin_SymIndividual_statustoggletextarea, testdatamap.get("Textarea").toString());
				Thread.sleep(3000);
				WebClick(EdaatOR.Admin_SymIndividual_statustoggleconformactivation);
				Thread.sleep(3000);
				Log.ReportEvent("PASS", "Status Toggle Activation & De-activation Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Status Toggle Activation & De-activation Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Status Toggle Activation & De-activation Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			e.printStackTrace();
			Assert.fail();
		}
	}

	// Function summary:Verify Individual Client Status Activation and
	// De-activation.
	// Function Parameters: Client Name,National ID,Client Status
	private void Systemindividualclientsearch(Map<Object, Object> testdatamap) throws InterruptedException {
		try {
			WebEdit(EdaatOR.AdminSystem_IndividualClient_Name, testdatamap.get("Client Name").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.AdminSystem_Individual_national);
			WebEdit(EdaatOR.AdminSystem_Individual_national, testdatamap.get("National ID").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_System_Individual_clientstatus);
			WebClick("//option[text()='" + testdatamap.get("Client Status").toString() + "']");
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.AdminSystem_Individual_Search);
			Thread.sleep(1000);

		} catch (Exception e) {

			test.log(Status.FAIL,
					"Verify Individual Client Search" + driver.getTitle() + " * Individual Client Search is FAIL * ");

		}
	}

	// Function summary : Verify Individual Client Request Record button.
	// Function Parameters: History
	public void IndividualclientRequestRecord(Map<Object, Object> testdatamap, Log Log) {
		try {
			SearchIndividualClient(testdatamap, Log);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_SymIndividua_RequestRecordBtn);
			Thread.sleep(3000);
			if (WebGetText(EdaatOR.Admin_SymIndividual_Historypage).equals(testdatamap.get("History").toString())) {
				VerifyValue1(WebGetText(EdaatOR.Admin_SymIndividual_Historypage),
						testdatamap.get("History").toString());
				Thread.sleep(3000);
				Log.ReportEvent("PASS", "Individual Client Request Record Button Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Individual Client Request Record Button Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Individual Client Request Record Button Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();

		}

	}

	public void SelectClientDropdown(Map<Object, Object> testdatamap) throws Exception {
		WebClick(EdaatOR.Admin_SymIndivClientstatus);
		WebClick("//option[text()='" + testdatamap.get("Client Status").toString() + "']");

	}

	// Function summary:Method to Download the NationalID under Individual client
	// module.
	// Function Parameters: ClientName and National ID
	public void NationalIdDownload(Map<Object, Object> testdatamap, Log Log) {
		// TODO Auto-generated method stub
		try {
			SearchIndividualClient(testdatamap, Log);
			Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.Admin_Individualdownload)) {
				WebClick(EdaatOR.Admin_Individualdownload);
				Log.ReportEvent("PASS", "NationalId Download Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "NationalId Download Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "NationalId Download Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	// Function summary:Method to search individual client
	// Function Parameters: ClientName, ClientStatus, National ID
	public void SearchIndividualClient(Map<Object, Object> testdatamap, Log Log) {
		try {
			WebClear(EdaatOR.AdminSystem_IndividualClient_Name);
			WebEdit(EdaatOR.AdminSystem_IndividualClient_Name, testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.AdminSystem_Individual_national);
			WebEdit(EdaatOR.AdminSystem_Individual_national, testdatamap.get("NationalID").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.AdminSystem_IndividualClientStatus,
					testdatamap.get("ClientStatus").toString());
			WebClickUsingJS(EdaatOR.AdminSystem_Individual_Search);
			Thread.sleep(3000);
			if (getText(EdaatOR.AdminNationalIDVerify).equals(testdatamap.get("NationalID").toString())) {
				VerifyValue1(getText(EdaatOR.AdminNationalIDVerify), testdatamap.get("NationalID").toString());
				Log.ReportEvent("PASS", "Search Functionality Is Successful");
			} else {
				Log.ReportEvent("FAIL", "Search Functionality Is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Search Functionality Is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	// Function summary:Method to VerifyAccountSettingButton
	// Function Parameters: Account Status Type, ClientName,National
	// ID,AccountSuspendedReasons
	public void VerifyAccountSettingButton(Map<Object, Object> testdatamap, Log Log) {
		try {
			String accountstatus = testdatamap.get("Account Status Type").toString();
			WebClear(EdaatOR.AdminSystem_IndividualClient_Name);
			WebEdit(EdaatOR.AdminSystem_IndividualClient_Name, testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.AdminSystem_Individual_national);
			WebEdit(EdaatOR.AdminSystem_Individual_national, testdatamap.get("National ID").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.AdminSystem_Individual_Search);
			Thread.sleep(2000);
			if (getText("//a[text()='" + testdatamap.get("ClientName").toString() + "']")
					.equals(testdatamap.get("ClientName").toString())) {
				VerifyValue1(getText("//a[text()='" + testdatamap.get("ClientName").toString() + "']"),
						testdatamap.get("ClientName").toString());
				WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SettingsBTN);
				Thread.sleep(1000);
				SelectradioButtton(accountstatus);
				WebClick(EdaatOR.AdminSystem_Individuaul_SuspendReason);
				Thread.sleep(1000);
				WebClickUsingActions("//li[text()='" + testdatamap.get("AccountSuspendedReasons").toString() + "']");
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SettingConirmBTN);
				if (CheckElementExists(EdaatOR.AdminSystem_Individuaul_SuspendReason_Error)) {
					Log.ReportEvent("FAIL", "Account Setting Button Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				} else {
					Thread.sleep(1000);
					WebClear(EdaatOR.AdminSystem_IndividualClient_Name);
					Thread.sleep(1000);
					WebEdit(EdaatOR.AdminSystem_IndividualClient_Name, testdatamap.get("ClientName").toString());
					Thread.sleep(1000);
					WebClear(EdaatOR.AdminSystem_Individual_national);
					WebEdit(EdaatOR.AdminSystem_Individual_national, testdatamap.get("National ID").toString());
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.AdminSystem_Individual_Search);
					Thread.sleep(1000);
					if (accountstatus.equalsIgnoreCase("suspended permanently")) {
						VerifyValue1(getText("//td[text()='" + accountstatus + "']"), accountstatus);
						Thread.sleep(2000);
						Log.ReportEvent("PASS", "Account Setting Button Functionality is Successful");
					} else {
						VerifyValue1(getText("//td[contains(text(),'" + accountstatus + "')]"), accountstatus);
						Thread.sleep(2000);
						Log.ReportEvent("PASS", "Account Setting Button Functionality is Successful");
					}

				}
			} else {
				Log.ReportEvent("FAIL", "Account Setting Button Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Account Setting Button Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	// Function summary :VerifyClientStatusSearch
	// Function Parameters:ClientName and National ID
	public void VerifyClientStatusSearch(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
		try {
			String clientstatus = testdatamap.get("ClientStatus").toString();
			if (clientstatus.equalsIgnoreCase("registered") || clientstatus.equalsIgnoreCase("approved")) {
				selectDropdownValue_PartialText(EdaatOR.AdminSystem_Individual_Clientstatus, clientstatus);
				Thread.sleep(2000);
				WebClick(EdaatOR.AdminSystem_Individual_Search);
				Thread.sleep(2000);
				if (getText(EdaatOR.AdminSystem_Individual_Clientstatus_Verify).equals("Yes")) {
					VerifyValue1(getText(EdaatOR.AdminSystem_Individual_Clientstatus_Verify), "Yes");
					Log.ReportEvent("PASS", "Search Based on the Client Status Functionality is Successful");
				} else {
					Log.ReportEvent("FAIL", "Search Based on the Client Status Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} else {
				selectDropdownValue_PartialText(EdaatOR.AdminSystem_Individual_Clientstatus, clientstatus);
				Thread.sleep(2000);
				WebClick(EdaatOR.AdminSystem_Individual_Search);
				Thread.sleep(2000);
				if (getText(EdaatOR.AdminSystem_Individual_Clientstatus_Verify).equals("No")) {
					VerifyValue1(getText(EdaatOR.AdminSystem_Individual_Clientstatus_Verify), "No");
					Log.ReportEvent("PASS", "Search Based on the Client Status Functionality is Successful");
				} else {
					Log.ReportEvent("FAIL", "Search Based on the Client Status Functionality is UnSuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Search Based on the Client Status Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			driver.quit();
			Assert.fail();
		}
	}

	public void VerifyAccountSettingButtonErrorMsg(Map<Object, Object> testdatamap, Log Log) {
		try {
			String accountstatus = testdatamap.get("Account Status Type").toString();
			String Expected = testdatamap.get("Expected").toString();
			WebClear(EdaatOR.AdminSystem_IndividualClient_Name);
			WebEdit(EdaatOR.AdminSystem_IndividualClient_Name, testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.AdminSystem_Individual_national);
			WebEdit(EdaatOR.AdminSystem_Individual_national, testdatamap.get("National ID").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.AdminSystem_Individual_Search);
			Thread.sleep(1000);
			VerifyValue1(getText("//a[text()='" + testdatamap.get("ClientName").toString() + "']"),
					testdatamap.get("ClientName").toString());
			WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SettingsBTN);
			Thread.sleep(1000);
			if (accountstatus.equalsIgnoreCase("Suspended Permanently")) {
				WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SuspendPermradioBTN);
				Thread.sleep(3000);
			} else if (accountstatus.equalsIgnoreCase("Suspended")) {
				WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SuspendradioBTN);
				Thread.sleep(3000);
			}
			WebClickUsingJS(EdaatOR.AdminSystem_Individuaul_SettingConirmBTN);
			Thread.sleep(5000);
			if (getText(EdaatOR.AdminSystem_Individuaul_Accountstatuserrormsg).trim().equals(Expected)) {
				Log.ReportEvent("PASS", "Verify 'Please choose a proper action' Error Message is Successful");
			} else if (getText(EdaatOR.AdminSystem_Individuaul_SuspendReasonerrormsg).equals(Expected)) {
				Log.ReportEvent("PASS",
						"Verify 'Please state the reasons for the suspension' Error Message is Successful");
			} else {
				Log.ReportEvent("FAIL",
						"Verify Error Message for Individual Client Account Setting Button is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebClick(EdaatOR.AdminSystem_Individuaul_cancelbtn);
		} catch (Exception e) {
			Log.ReportEvent("FAIL",
					"Verify Error Message for Individual Client Account Setting Button is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
}