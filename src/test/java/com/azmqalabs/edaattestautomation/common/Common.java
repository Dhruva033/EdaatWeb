package com.azmqalabs.edaattestautomation.common;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Common {

	private static String attValue = null;
	public WebDriver driver;
	public WebElement element;
	public ExtentTest test;

	public String WARNINGFontColorPrefix = "<span style='font-weight:bold;'><font color='red';font-size:16px; line-height:20px>";
	public String WARNINGFontColorSuffix = "</font></span>";
	public String InfoFontColorPrefix = "<span style='font-weight:bold;'><font color='gold';font-size:16px; line-height:20px>";
	public String InfoFontColorSuffix = "</font></span>";
	public String SuccessFontColorPrefix = "<span style='font-weight:bold;'><font color='green';font-size:16px; line-height:20px>";
	public String SuccessFontColorSuffix = "</font></span>";
	public String INFOFontColorPrefix = "<span><font color='blue';font-size:16px; line-height:20px>";
	public String INFOFontColorSuffix = "</font></span>";
	public String FAILFontColorPrefix = "<span><font color='red';font-size:16px; line-height:20px>";
	public String FAILFontColorSuffix = "</font></span>";

	String sExecutionDelay = Config.GetProperty("DRIVER.AUT.ACTION.DELAY").toString();
	int iExecutionDelay = Integer.parseInt(sExecutionDelay);

	public void commonTestMethod() {

	}

	String projectName = "";

	public void takeScreenShot1() {

		projectName = System.getProperty("projectname");
		if (projectName == null) {
			projectName = Config.Get("PROJECT.NAME");
		}
		String skipScreenshot = Config.Get("SCREENSHOT.SKIP");

		if (skipScreenshot.equalsIgnoreCase("no")) {
			try {

				String sProjectName = projectName;

				Date d = new Date();
				String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
				File classpathRoot = new File(System.getProperty("user.dir"));

				File app = new File("src//test//resources//testReport//" + sProjectName + "//screenshots//");
				String filePath = app.toString() + "//" + screenshotFile;

				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				try {
					// String relative = new File(base).toURI().relativize(new
					// File(path).toURI()).getPath();
					FileUtils.copyFile(scrFile, new File(filePath));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				File appScreenshot = new File("screenshots//");
				String filePathScreenshot = appScreenshot.toString() + "//" + screenshotFile;// SA

				test.addScreenCaptureFromPath(filePathScreenshot);
				test.log(Status.INFO, "#TAKE SCREENSHOT" + driver.getTitle() + " * SCREENSHOT CAPTURED * ");
			} catch (Exception e) {
				test.log(Status.INFO, "#TAKE SCREENSHOT" + driver.getTitle() + " * UNABLE TO CAPTURE SCREENSHOT* ");
			}
		}
	}
	
//	public void takeScreenShot() {
//
//		projectName = System.getProperty("projectname");
//		if (projectName == null) {
//			projectName = Config.Get("PROJECT.NAME");
//		}
//		String skipScreenshot = Config.Get("SCREENSHOT.SKIP");
//
//		if (skipScreenshot.equalsIgnoreCase("no")) {
//			try {
//
//				String sProjectName = projectName;
//
//				Date d = new Date();
//				String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
//				File classpathRoot = new File(System.getProperty("user.dir"));
//
//				File app = new File("src//test//resources//testReport//" + sProjectName + "//screenshots//");
//				String filePath = app.toString() + "//" + screenshotFile;
//
//				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//				try {
//					// String relative = new File(base).toURI().relativize(new
//					// File(path).toURI()).getPath();
//					FileUtils.copyFile(scrFile, new File(filePath));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				File appScreenshot = new File("screenshots//");
//				String filePathScreenshot = appScreenshot.toString() + "//" + screenshotFile;// SA
//				
//                test.log(Status.INFO, "Screenshot captured", MediaEntityBuilder.createScreenCaptureFromPath(filePathScreenshot).build());
//
//			} catch (Exception e) {
//				test.log(Status.FAIL, "#TAKE SCREENSHOT" + driver.getTitle() + " * UNABLE TO CAPTURE SCREENSHOT* ");
//			}
//		}
//	}
	
	//attach ss for all the TC as base64
	public void takeScreenShot() {

	    projectName = System.getProperty("projectname");
	    if (projectName == null) {
	        projectName = Config.Get("PROJECT.NAME");
	    }
	    String skipScreenshot = Config.Get("SCREENSHOT.SKIP");

	    if (skipScreenshot.equalsIgnoreCase("no")) {
	        try {

	            // Capture screenshot as Base64 string instead of file
	            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

	            // Log screenshot directly in the report without saving to a file
	            test.log(Status.FAIL, 
	                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

	        } catch (Exception e) {
	            test.log(Status.FAIL, "#TAKE SCREENSHOT" + driver.getTitle() + " * UNABLE TO CAPTURE SCREENSHOT* ");
	            e.printStackTrace();
	        }
	    }
	}
	
//	public String takeScreenShot() {
//	    projectName = System.getProperty("projectname");
//	    if (projectName == null) {
//	        projectName = Config.Get("PROJECT.NAME");
//	    }
//	    String skipScreenshot = Config.Get("SCREENSHOT.SKIP");
//
//	    if (skipScreenshot.equalsIgnoreCase("no")) {
//	        try {
//	            // Capture screenshot as Base64 string
//	            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//
//	            // Log screenshot directly in the report
//	            test.log(Status.INFO,
//	                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
//
//	            // Return the Base64 string for further use
//	            return base64Screenshot;
//
//	        } catch (Exception e) {
//	            test.log(Status.FAIL, "#TAKE SCREENSHOT: " + driver.getTitle() + " *UNABLE TO CAPTURE SCREENSHOT*");
//	            e.printStackTrace();
//	        }
//	    }
//	    return null; // Return null if screenshot is not taken
//	}

	
//	public String takeScreenShot() {
//	    String skipScreenshot = Config.Get("SCREENSHOT.SKIP");
//	    
//	    if ("no".equalsIgnoreCase(skipScreenshot)) {
//	        try {
//	            // Capture screenshot as Base64 string
//	            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return null;
//	        }
//	    }
//	    return null; // Return null if screenshot is skipped
//	}


	public void WaitForPage(Common page) throws InterruptedException, IOException {
		boolean bExists = false;

		String sAddtnlWaitTime = Config.GetProperty("DRIVER.ADDITIONAL.WAIT.TIME").toString();
		int iAddtnlWaitTime = Integer.parseInt(sAddtnlWaitTime);
		Thread.sleep(iAddtnlWaitTime);
		bExists = page.Exists();

		if (bExists == false) {

			try {
				throw new IOException("Page not found");
			} catch (Exception e) {
				test.log(Status.FAIL, "element.toString()" + " NOT EXISTS - " + e);
				test.log(Status.FAIL,
						WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName()
						+ " Code line Number: " + new Exception().getStackTrace()[0].getLineNumber() + "!"
						+ WARNINGFontColorSuffix);
				throw new IOException("Page not found");
			}
		} else {
			test.log(Status.PASS,
					SuccessFontColorPrefix + "Wait for Page [Page Navigation] - WaitForPage Successful - Navigated To: "
							+ page.toString() + SuccessFontColorSuffix);
		}

	}

	public boolean Exists() throws IOException {
		return true;
	}

	public boolean Exists(WebElement element) {

		boolean bExists = false;

		try {
			int globalWait = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			System.out.println("Global synchronization time " + globalWait);
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait + globalWait);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
//			test.log(Status.FAIL, "element.toString()" + " NOT EXISTS - " + e);
//			test.log(Status.FAIL,
//					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
//							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
		return bExists;
	}

	public boolean ExistsClickable1(WebElement element) {

		boolean bExists = false;

		try {
			int globalWait = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			System.out.println("Global synchronization time " + globalWait);
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait + globalWait);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			test.log(Status.FAIL, "element.toString()" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
		return bExists;
	}
	
	public boolean ExistsClickable(WebElement element) {

		boolean bExists = false;

		try {
			int globalWait = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			System.out.println("Global synchronization time " + globalWait);
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait + globalWait);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			test.log(Status.FAIL, "element.toString()" + " NOT EXISTS - ");
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
		return bExists;
	}

	public boolean waitForPageToLoadPop() {

		boolean bExists = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebElement element = driver
					.findElement(By.xpath("//div[@role='dialog' and @aria-describedby='modalDialog']"));
			System.out.println("Global synchronization time " + 1);
			WebDriverWait wait = new WebDriverWait(this.driver, 10);
			wait.until(ExpectedConditions.attributeContains(element, "aria-hidden", "true"));
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
			test.log(Status.INFO, "ExistsCheck - Not Found");
		}
		return bExists;
	}

	public boolean CheckElementClickable(String xPath) {

		boolean bExists = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.xpath(xPath));
			int globalWait = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			System.out.println("Global synchronization time " + globalWait);
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
			// wait.until(ExpectedConditions.stalenessOf(element));
			return true;
		} catch (Exception e) {
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);

		}
		return bExists;
	}

	public boolean ExistsCheck1(WebElement element) {

		boolean bExists = false;

		try {
			int globalWait = Integer.parseInt(Config.Get("DRIVER.PAGE.SYNCTIME"));
			System.out.println("Global synchronization time " + globalWait);
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait + globalWait);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			test.log(Status.INFO, "ExistsCheck - Not Found");
		}
		return bExists;
	}
	
	public boolean ExistsCheck(WebElement element) {

		boolean bExists = false;

		try {
			int globalWait = Integer.parseInt(Config.Get("DRIVER.PAGE.SYNCTIME"));
			System.out.println("Global synchronization time " + globalWait);
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait + globalWait);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			//test.log(Status.INFO, "ExistsCheck - Not Found");
		}
		return bExists;
	}

	public boolean ExistsCheck1(String xpath) {

		boolean bExists = false;

		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			int globalWait = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			System.out.println("Global synchronization time " + globalWait);
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait + globalWait);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			test.log(Status.INFO, "ExistsCheck - Not Found");
		}
		return bExists;
	}
	
	public boolean ExistsCheck(String xpath) {

		boolean bExists = false;

		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			int globalWait = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			System.out.println("Global synchronization time " + globalWait);
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait + globalWait);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			//test.log(Status.INFO, "ExistsCheck - Not Found");
		}
		return bExists;
	}

	public boolean CheckElementExists1(String xpath) {

		boolean bExists = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.xpath(xpath));
			System.out.println("Global synchronization time " + 1);
			WebDriverWait wait = new WebDriverWait(this.driver, 3);
			wait.until(ExpectedConditions.visibilityOf(element));
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
			test.log(Status.INFO, "ExistsCheck - Not Found");
		}
		return bExists;
	}

	public boolean CheckElementExists(String xpath) {

		boolean bExists = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.xpath(xpath));
			System.out.println("Global synchronization time " + 1);
			WebDriverWait wait = new WebDriverWait(this.driver, 3);
			wait.until(ExpectedConditions.visibilityOf(element));
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
			//test.log(Status.INFO, "ExistsCheck - Not Found");
		}
		return bExists;
	}

	public void WebEdit(String sEleXpath, String sEleValue) {
		try {
			SetExecutionDelay();
			Exists(driver.findElement(By.xpath(sEleXpath)));
			WebClickUsingJS(sEleXpath);
			SetExecutionDelay();
			getElement(sEleXpath).clear();
			driver.findElement(By.xpath(sEleXpath)).sendKeys(sEleValue);

		} catch (Exception e) {
//			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
//			test.log(Status.FAIL,
//					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
//							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
	}

	public WebElement getElement(String sEleXpath) {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(sEleXpath));
		} catch (Exception e) {
			test.log(Status.FAIL, "getElement - sEleXpath" + " NOT WebElement - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
		return element;
	}

	public void WebEditCheck(String sEleXpath, String sEleValue) {
		try {
			SetExecutionDelay();
			SetExecutionDelay();
			SetExecutionDelay();
			SetExecutionDelay();
			Exists(driver.findElement(By.xpath(sEleXpath)));
			WebElement existElepath = driver.findElement(By.xpath(sEleXpath));
			if (existElepath.getAttribute("value").trim().equalsIgnoreCase("")) {
				driver.findElement(By.xpath(sEleXpath)).sendKeys(sEleValue);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
	}

	public void WebSelect(String sEleXpath, String sEleValue) {
		try {
			SetExecutionDelay();
			Exists(driver.findElement(By.xpath(sEleXpath)));
			if (sEleValue.equalsIgnoreCase("")) {
				Select select = new Select(driver.findElement(By.xpath(sEleXpath)));
				select.selectByIndex(1);
			} else
				driver.findElement(By.xpath(sEleXpath)).sendKeys(sEleValue);

		} catch (Exception e) {
			// Code to reset implicit wait and select value and then reset implicit wait
			Select select1 = new Select(driver.findElement(By.xpath(sEleXpath)));
			select1.selectByIndex(1);
//			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
//			test.log(Status.FAIL,
//					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
//							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
	}

	public void WebCombobox(String sEleXpath, String sEleValue) {
		try {
			// Use Select or Action object
			SetExecutionDelay();
			Exists(driver.findElement(By.xpath(sEleXpath)));
			driver.findElement(By.xpath(sEleXpath)).sendKeys(sEleValue);

		} catch (Exception e) {
			// Code to reset implicit wait and select value and then reset implicit wait
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
	}
	
	public void AllcheckboxClick(String sEleXpath) {		
		List<WebElement> checkboxes = driver.findElements(By.xpath(sEleXpath));
		for(int i=2; i<checkboxes.size()-1; i++){	
			checkboxes.get(i).click();			
		}
	}

	public void WebClick(String sEleXpath) {
		try {
			SetExecutionDelay();
			SetExecutionDelay();
			driver.findElement(By.xpath(sEleXpath)).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void WebClick(WebElement element) {
		try {
			SetExecutionDelay();
			// ExistsClickable(driver.findElement(By.xpath(sEleXpath)));
			element.click();

		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
	}

	public void WebClickRadiobutton(String sEleXpath) {
		try {
			SetExecutionDelay();
			driver.findElement(By.xpath(sEleXpath)).click();

		} catch (Exception e) {
			test.log(Status.FAIL, "WebClickRadiobutton - sEleXpath" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
	}

	public void WebSelectCheckbox(String sEleXpath) {
		try {
			SetExecutionDelay();
			driver.findElement(By.xpath(sEleXpath)).click();

		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
	}

	public String getText(String sEleXpath) {
		String text = "";
		try {
			SetExecutionDelay();
			SetExecutionDelay();
			text = driver.findElement(By.xpath(sEleXpath)).getText();

		} catch (Exception e) {
//			test.log(Status.FAIL, "WebClick - sEleXpath" + " NOT EXISTS - " + e);
//			test.log(Status.FAIL,
//					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
//							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
		return text;
	}

	public void VerifyValue2(String ActualValue, String ExpectedValue) throws IOException {
		if (ActualValue.equals(ExpectedValue)) {
			System.out.println("Verification Passed for the value {" + ActualValue + "}");
//			test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed, Expected value {" + ActualValue + "}"
//					+ SuccessFontColorPrefix);
		} else {
//			test.log(Status.FAIL, WARNINGFontColorPrefix + "Verificaion Failure, Expected value:{" + ExpectedValue
//					+ "} Actual Value:{" + ActualValue + "}" + WARNINGFontColorPrefix);
		}

	}
	
	public void VerifyValue1(String ActualValue, String ExpectedValue) throws IOException {
		if (ActualValue.equals(ExpectedValue)) {
			System.out.println("Verification Passed for the value {" + ActualValue + "}");
//			test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed");
		} else {
//			test.log(Status.FAIL, WARNINGFontColorPrefix + "Verificaion Failed");
	
		}
		
	}

	public void TestVerifyValue(String element, String ExpectedValue) throws IOException {

		String ActualValue = GetText(element);
		System.out.println("Date is ::" + ActualValue);
		this.VerifyVerification(ActualValue.trim(), ExpectedValue.trim());

	}

	public boolean VerifyObjectEnabled(WebElement element) throws Exception {
		ExistsCheck(element);
		{
			boolean bIsEnabled = element.isEnabled();
			if (bIsEnabled == false) {
				test.log(Status.FAIL, "VerifyObjectDisabled Failed - " + element.toString());
				return true;
			} else {
				test.log(Status.PASS, "VerifyObjectDisabled Passed - " + element.toString());
				return false;
			}
		}
	}

	public boolean VerifyObjectDisabled(String xpath) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		ExistsCheck(element);
		{
			boolean bIsEnabled = element.isEnabled();
			if (bIsEnabled == true) {
//				test.log(Status.FAIL, "VerifyObjectDisabled Failed");
				return true;
			} else {
//				test.log(Status.PASS, "VerifyObjectDisabled Passed");
				return false;
			}
		}
	}

	public void VerifyValue_Tran(String ExpectedValue, String sEleXpath) {
		if (ExpectedValue == "$" && ExpectedValue != "") {
			String ActValue = driver.findElement(By.xpath(sEleXpath)).getAttribute("value");
			String ActualValue = ActValue.replace(",", "");

			System.out.println("Actual Value is::" + ActualValue);
			this.VerifyVerification(ActualValue, ExpectedValue);
		}

	}

	public void VerifyValue(String ExpectedValue, String sEleXpath) {
		if (ExpectedValue != "") {
			String ActValue = getText(sEleXpath);
			String ActualValue = ActValue.replace(",", "");

			System.out.println("Actual Value is::" + ActualValue);
			this.VerifyVerification(ActualValue, ExpectedValue);
		}
	}

	public void VerifydropdownValue(String ExpectedValue, String ActualValue) {
		if (ExpectedValue != "") {
			System.out.println("Actual Value is::" + ActualValue);
			this.VerifyVerification(ActualValue, ExpectedValue);
		}

	}

	public void VerifyVerification1(String ActualValue, String ExpectedValue) {
		if (ActualValue.equals(ExpectedValue)) {
			System.out.println("Verification Passed for the value {" + ActualValue + "}");
			test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed, Expected value {" + ActualValue + "}"
					+ SuccessFontColorSuffix);
		} else {
			test.log(Status.WARNING, WARNINGFontColorPrefix + "Verificaion Failure, Expected value:{" + ExpectedValue
					+ "} Actual Value:{" + ActualValue + "}" + WARNINGFontColorSuffix);
		}
	}
	
	public void VerifyVerification(String ActualValue, String ExpectedValue) {
		if (ActualValue.equals(ExpectedValue)) {
			System.out.println("Verification Passed for the value {" + ActualValue + "}");
//			test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed");
		} else {
//			test.log(Status.WARNING, WARNINGFontColorPrefix + "Verificaion Failure");
			
		}
	}


	public void VerifyObjects1(Object ActualValue, Object ExpectedValue) throws IOException {
		if (ActualValue.equals(ExpectedValue)) {
			test.log(Status.PASS, "VerifyValue" + driver.getTitle() + " * VERIFY VALUE - SUCCESS * " + "Actual value: "
					+ ActualValue + " Expected value: " + ExpectedValue);
		} else {
			test.log(Status.FAIL, "VerifyValue" + driver.getTitle() + " * VERIFY VALUE - FAILED * " + "Actual value: "
					+ ActualValue + " Expected value: " + ExpectedValue);
			takeScreenShot();
		}
	}
	
	public void VerifyObjects(Object ActualValue, Object ExpectedValue) throws IOException {
		if (ActualValue.equals(ExpectedValue)) {
			test.log(Status.PASS,"VERIFY VALUE - SUCCESS");
			takeScreenShot();
		} else {
			test.log(Status.FAIL, "VERIFY VALUE - FAILED ");
			takeScreenShot();
		}
	}

	public void WebClearandEdit(String sEleXpath, String sEleValue) {
		try {
			SetExecutionDelay();
			Exists(driver.findElement(By.xpath(sEleXpath)));
			WebClick(sEleXpath);
			SetExecutionDelay();
			driver.findElement(By.xpath(sEleXpath)).clear();
			driver.findElement(By.xpath(sEleXpath)).sendKeys(sEleValue);

		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
	}

	private String GetText(String element) {
		WebElement ele = null;
		String sActualText = driver.findElement(By.xpath(element)).getAttribute("value");

		if (sActualText == null)
			sActualText = driver.findElement(By.xpath(element)).getAttribute("placeholder");

		if (sActualText.contains("object")) {
			Select sel = new Select(driver.findElement(By.xpath(element)));
			ele = sel.getFirstSelectedOption();
			sActualText = ele.getText();
		}

		return sActualText;

	}

	public void SendData(WebElement element) {
		element.click();
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void LogTestStep(String sStatus, String sDescription) {
		if (sStatus.equalsIgnoreCase("FAIL"))
			test.log(Status.FAIL, sDescription);
		else if (sStatus.equalsIgnoreCase("fail"))
			test.log(Status.FAIL, sDescription);
		else if (sStatus.equalsIgnoreCase("pass"))
			test.log(Status.PASS, sDescription);
		else if (sStatus.equalsIgnoreCase("info"))
			test.log(Status.INFO, sDescription);
	}

	public void SetExecutionDelay() throws Exception {
		// Need to add some logic to handle this behavior
		Thread.sleep(iExecutionDelay);
	}

	public void WebClickUsingJS(String sEleXpath) {

		WebElement element = driver.findElement(By.xpath(sEleXpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}
	public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public void switchTonextwindow() {
		String currentWindowHandle = driver.getWindowHandle();
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		for (String window : windowHandles) {
			if (window != currentWindowHandle) {
				driver.switchTo().window(window);
			}
		}
	}

	public void selectDropdownValue_PartialText(String sEleXpath, String PartialText) {
				try {
			WebobjectExists(driver.findElement(By.xpath(sEleXpath)));
			driver.findElement(By.xpath(sEleXpath))
			.findElement(By.xpath("//option[contains(text(),'" + PartialText + "')]")).click();
		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
            this.takeScreenShot();
		}

	}

	public void WebClickTabKey(String sEleXpath) {
		try {
			Exists(driver.findElement(By.xpath(sEleXpath)));
			driver.findElement(By.xpath(sEleXpath)).sendKeys(Keys.TAB);
			;
		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
		}

	}

	public Integer generateRandomNumber() {
		Random rand = new Random();
		int randint = rand.nextInt(10000);
		return randint;
	}

	public void WebDragAndDrop(WebElement From, WebElement To) {
		try {
			Actions builder = new Actions(driver);
			Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
			dragAndDrop.perform();
		} catch (Exception e) {
			test.log(Status.INFO, "WebDragAndDrop - Not Found");
		}
	}

	public boolean WebobjectExists1(String xpath) {
		boolean bExists = false;
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			int globalWait = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			System.out.println("Global synchronization time " + globalWait);
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait + globalWait);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			test.log(Status.INFO, "objectExists - Not Found");
		}
		return bExists;
	}
	
	public boolean WebobjectExists(String xpath) {
		boolean bExists = false;
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			int globalWait = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			System.out.println("Global synchronization time " + globalWait);
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait + globalWait);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			test.log(Status.FAIL, "objectExists - Not Found");
		}
		return bExists;
	}

	public boolean WebobjectExists1(WebElement element) {
		boolean bExists = false;
		try {
			int globalWait = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait);
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(2000);
			return true;
		} catch (Exception e) {
			test.log(Status.INFO, "objectExists - Not Found");
		}
		return bExists;
	}

	public boolean WebobjectExists(WebElement element) {
		boolean bExists = false;
		try {
			int globalWait = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			WebDriverWait wait = new WebDriverWait(this.driver, globalWait);
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(2000);
			return true;
		} catch (Exception e) {
			//test.log(Status.FAIL, "objectExists - Not Found");
		}
		return bExists;
	}

	public String WebGetText(String sEleXpath) {
		Exists(driver.findElement(By.xpath(sEleXpath)));
		String webEleText = driver.findElement(By.xpath(sEleXpath)).getText();
		return webEleText;
	}

	public String WebGetTextAttribute(String sEleXpath) {
		Exists(driver.findElement(By.xpath(sEleXpath)));
		String webEleText = driver.findElement(By.xpath(sEleXpath)).getAttribute("value");
		return webEleText;
	}

	public void WebSelectByVisibleText(String sEleXpath, String sText) {
		try {
			Select select = new Select(driver.findElement(By.xpath(sEleXpath)));
			select.selectByVisibleText(sText);
		} catch (Exception e) {
			// Code to reset implicit wait and select value and then reset implicit wait
			Select select1 = new Select(driver.findElement(By.xpath(sEleXpath)));
			select1.selectByVisibleText(sText);
			test.log(Status.INFO, "WebSelectByVisibleText - Not Found");
		}
	}

	public void WebClear(String sEleXpath) {
		try {
			Exists(driver.findElement(By.xpath(sEleXpath)));
			driver.findElement(By.xpath(sEleXpath)).clear();
		} catch (Exception e) {
			test.log(Status.INFO, "Web Clear - Not Found");
		}
	}
	
	public void WebClearUsingKeys(String sEleXpath) {
		try {
			Exists(driver.findElement(By.xpath(sEleXpath)));
		    String test=WebGetTextAttribute(sEleXpath);
		    char[] val=test.toCharArray();
		    for(int i=0;i<val.length;i++) {
		    	driver.findElement(By.xpath(sEleXpath)).sendKeys(Keys.BACK_SPACE);;
		    }
			
		} catch (Exception e) {
			test.log(Status.INFO, "Web Clear - Not Found");
		}
	}


	public boolean IsSelected(String xpath) {
		boolean bExists = false;
		try {

			WebElement element = driver.findElement(By.xpath(xpath));
			if (element.isSelected()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			test.log(Status.INFO, "IsSelected - Not Found");
		}
		return bExists;
	}

	public boolean IsDispalyed(String xpath) {
		boolean bExists = false;
		try {
			WebobjectExists(driver.findElement(By.xpath(xpath)));
			WebElement element = driver.findElement(By.xpath(xpath));
			if (element.isDisplayed() && element.isEnabled()) {
				Thread.sleep(500);
				return true;
			}
			return false;
		}

		catch (Exception e) {
			//test.log(Status.INFO, "IsDispalyed - Not Found");
		}
		return bExists;
	}

	public boolean VerifyObjectExists() throws Exception {
		boolean bExists = true;
		boolean bExists1 = false;
		for (int i = 0; i < 60; i++) {
			List<WebElement> selements = driver.findElements(By.xpath("//div[@id='appLoading']"));
			int isize = selements.size();
			try {
				if (driver.findElement(By.xpath("//div[@id='appLoading']")).isDisplayed() == true)
					bExists = true;
				else
					bExists = false;
			} catch (Exception e) {
				try {
					if (driver.findElement(By.xpath("//div[@id='WLdialogContainer']")).isDisplayed() == true)
						bExists = true;
					else
						bExists = false;
				} catch (Exception e1) {
					bExists = false;
				}
			}
			if (bExists == false)
				break;
			Thread.sleep(500);
			System.out.println("APP Loading: " + i);
		}
		return bExists;
	}

	public static String getDate(String date1) throws ParseException {
		String[] arr;
		String strDate = "";
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		if (date1.contains("-")) {
			arr = date1.split("-");
			Long digit = Long.parseLong(arr[1]);
			Long days = 24 * 60 * 60 * 1000 * (digit);
			strDate = formatter.format(new Date(System.currentTimeMillis() - days));
		} else if (date1.contains("+")) {
			arr = date1.split("\\+");
			Long digit = Long.parseLong(arr[1]);
			Long days = 24 * 60 * 60 * 1000 * (digit);
			strDate = formatter.format(new Date(System.currentTimeMillis() + days));
		} else if (date1.contains("day")) {
			strDate = formatter.format(new Date(System.currentTimeMillis()));
		}
		date = formatter.parse(strDate);
		if (date.toString().contains("Sat")) {
			strDate = formatter.format(date.getTime() + (24 * 60 * 60 * 1000 * 2));
		} else if (date.toString().contains("Sun")) {
			strDate = formatter.format(date.getTime() + (24 * 60 * 60 * 1000 * 1));
		}
		return strDate.toString();
	}

	public boolean isNotNull(String var) {
		boolean isNotNullOrEmpty = false;
		if (var != null) {
			isNotNullOrEmpty = true;
		} else {
			isNotNullOrEmpty = false;
		}
		return isNotNullOrEmpty;
	}

	public void dataVerification(String object, String actualValue, String ExpectedValue) throws IOException {

		if (isNotNull(actualValue) && isNotNull(ExpectedValue)) {
			if (actualValue.contains(ExpectedValue)) {
				test.log(Status.PASS, "Verifying Object:--" + object + "---Actual Value IS:" + actualValue + "  "
						+ "---Expected Value IS:" + ExpectedValue);
			} else {
				test.log(Status.FAIL, "Verifying Object:--" + object + "---Actual Value IS:" + actualValue + "  "
						+ "---Expected Value IS:" + ExpectedValue);
			}
		} else {
			test.log(Status.FAIL, "Verifying Object:--" + object + "---Actual Value IS:" + actualValue + "  "
					+ "---Expected Value IS:" + ExpectedValue);
		}
	}

	public void VerifyValue2(String elementName, String ActualValue, String ExpectedValue) throws IOException {
		if (ActualValue.equalsIgnoreCase(ExpectedValue)) {
			test.log(Status.PASS,
					"VerifyValue for--" + elementName + SuccessFontColorPrefix + " * VERIFY VALUE - SUCCESS * "
							+ "Actual value: " + ActualValue + " Expected value: " + ExpectedValue
							+ SuccessFontColorSuffix);
			takeScreenShot();
		} else {
			test.log(Status.FAIL,
					"VerifyValue for--" + elementName + WARNINGFontColorPrefix + " * VERIFY VALUE - FAILED * "
							+ "Actual value: " + ActualValue + " Expected value: " + ExpectedValue
							+ WARNINGFontColorSuffix);
			takeScreenShot();
		}
	}
	
	

	public void VerifyValueNotPresent1(String elementName, String ActualValue, String ExpectedValue) throws IOException {
		if (!ActualValue.equalsIgnoreCase(ExpectedValue)) {
			test.log(Status.PASS, "VerifyValue for--" + elementName + " * VERIFY VALUE - SUCCESS * " + "Actual value: "
					+ ActualValue + " Expected value: " + ExpectedValue);
			takeScreenShot();
		} else {
			test.log(Status.FAIL, "VerifyValue for--" + elementName + " * VERIFY VALUE - FAILED * " + "Actual value: "
					+ ActualValue + " Expected value: " + ExpectedValue);
			takeScreenShot();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void VerifyValueNotPresent(String elementName, String ActualValue, String ExpectedValue) throws IOException {
		if (!ActualValue.equalsIgnoreCase(ExpectedValue)) {
			test.log(Status.PASS, "VERIFY VALUE - SUCCESS");
			takeScreenShot();
		} else {
			test.log(Status.FAIL, "VERIFY VALUE - FAILED");
			takeScreenShot();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void VerifyValue1(String elementName, String xpath, String ExpectedValue) throws IOException {
		WebElement element = driver.findElement(By.xpath(xpath));
		String actualValue = element.getText();
		if (actualValue.equalsIgnoreCase(ExpectedValue)) {
			test.log(Status.PASS, "VerifyValue for--" + elementName + " * VERIFY VALUE - SUCCESS * " + "Actual value: "
					+ actualValue + " Expected value: " + ExpectedValue);
			takeScreenShot();
		} else {
			test.log(Status.FAIL, "VerifyValue for--" + elementName + " * VERIFY VALUE - FAILED * " + "Actual value: "
					+ actualValue + " Expected value: " + ExpectedValue);
			takeScreenShot();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void VerifyValue(String elementName, String xpath, String ExpectedValue) throws IOException {
		WebElement element = driver.findElement(By.xpath(xpath));
		String actualValue = element.getText();
		if (actualValue.equalsIgnoreCase(ExpectedValue)) {
			test.log(Status.PASS,"VERIFY VALUE - SUCCESS");
			takeScreenShot();
		} else {
			test.log(Status.FAIL, "VERIFY VALUE - FAILED");
			takeScreenShot();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void WebSelectCheck(String sEleXpath, String sEleValue) {
		try {
			SetExecutionDelay();
			Exists(driver.findElement(By.xpath(sEleXpath)));
			WebElement existElepath = driver.findElement(By.xpath(sEleXpath));
			if (existElepath.getAttribute("value").trim().equalsIgnoreCase("")) {
				Select selectc = new Select(driver.findElement(By.xpath(sEleXpath)));
				selectc.selectByVisibleText(sEleValue);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
	}

	public void WebSelect1(String sEleXpath, String sEleValue) {
		try {
			SetExecutionDelay();
			Exists(driver.findElement(By.xpath(sEleXpath)));
			WebElement existElepath = driver.findElement(By.xpath(sEleXpath));

			Select selectc = new Select(driver.findElement(By.xpath(sEleXpath)));
			selectc.selectByVisibleText(sEleValue);

		} catch (Exception e) {
//			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
//			test.log(Status.FAIL,
//					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
//							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
	}

	public List<WebElement> getElements(String sEleXpath) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(By.xpath(sEleXpath));
		} catch (Exception e) {
			test.log(Status.FAIL, "getElement - sEleXpath" + " NOT WebElement - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
		return element;
	}

	public void dragAndDrop(String source, String target) {

		try {
			Actions act = new Actions(driver);
			SetExecutionDelay();
			act.dragAndDrop(getElement(source), getElement(target));
			SetExecutionDelay();
		} catch (Exception e) {
			test.log(Status.FAIL, "dragAndDrop - Source and Target" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}

	}

	public void dragAndDrop(WebElement sElement, WebElement tElement) {

		try {
			Actions act = new Actions(driver);
			SetExecutionDelay();
			act.dragAndDrop(sElement, tElement).build().perform();
			SetExecutionDelay();
		} catch (Exception e) {
			test.log(Status.FAIL, "dragAndDrop - Source and Target" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}

	}

	public static void scrollDowntillend(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");
	}

	public boolean waitForPageToLoad1() {

		boolean bExists = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println("Global synchronization time " + 1);
			WebDriverWait wait = new WebDriverWait(this.driver, 500);
			wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//div[@id='appLoading']")),
					"style", "display: none"));
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
			test.log(Status.INFO, "ExistsCheck - Not Found");
		}
		return bExists;
	}
	
	public boolean waitForPageToLoad() {

		boolean bExists = false;

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println("Global synchronization time " + 1);
			WebDriverWait wait = new WebDriverWait(this.driver, 500);
			wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//div[@id='appLoading']")),
					"style", "display: none"));
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
			driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
		}
		return bExists;
	}

	public void validateAttributeValue(String sEleXpath, String attriValue, String ExpectedValue) {
		try {
			// Use Select or Action object
			SetExecutionDelay();
			String ActualValue = driver.findElement(By.xpath(sEleXpath)).getAttribute(attriValue);
			ValidateTwoValue(ActualValue, ExpectedValue);
		} catch (Exception e) {
			// Code to reset implicit wait and select value and then reset implicit wait
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
	}

	public void ValidateTwoValue1(String ActualValue, String ExpectedValue) {
		if (ActualValue.contains(ExpectedValue)) {
			System.out.println("Verification Passed for the value {" + ActualValue + "}");
	     	test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed, Expected value {" + ActualValue + "}"+ SuccessFontColorSuffix);
		} else {
			test.log(Status.FAIL, WARNINGFontColorPrefix + "Verificaion Failure, Expected value:{" + ExpectedValue
					+ "} Actual Value:{" + ActualValue + "}" + WARNINGFontColorSuffix);
		}
	}
	
	
	public void ValidateTwoValue(String ActualValue, String ExpectedValue) {
		if (ActualValue.contains(ExpectedValue)) {
			System.out.println("Verification Passed for the value {" + ActualValue + "}");
	     //	test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed, Expected value {" + ActualValue + "}"+ SuccessFontColorSuffix);
		test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed");
		} else {
	      //test.log(Status.FAIL, WARNINGFontColorPrefix + "Verificaion Failure, Expected value:{" + ExpectedValue+ "} Actual Value:{" + ActualValue + "}" + WARNINGFontColorSuffix);
			test.log(Status.FAIL, SuccessFontColorPrefix + "Verification Failed");
		}
	}

	public String getAttributeValue(String sEleXpath, String attriValue) {
		try {
			// Use Select or Action object
			SetExecutionDelay();
			attValue = driver.findElement(By.xpath(sEleXpath)).getAttribute(attriValue);

		} catch (Exception e) {
			// Code to reset implicit wait and select value and then reset implicit wait
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
		return attValue;
	}

	public void switchToWindow() {
		try {
			SetExecutionDelay();

			for (String handle1 : driver.getWindowHandles()) {
				driver.switchTo().window(handle1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, "Window" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);

		}
	}

	public void switchToDefault() {
		try {
			SetExecutionDelay();
			driver.close();
			Thread.sleep(600);
			for (String handle1 : driver.getWindowHandles()) {
				driver.switchTo().window(handle1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, "Window" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);

		}
	}

	public void verifyElementIsPresent1(String Object) throws Exception {
		if (CheckElementExists(Object) == true) {
			test.log(Status.PASS, "Element is present");
		} else {
			test.log(Status.FAIL, "Element is not present");
		}
	}
	public void verifyElementIsPresent(String xpath) throws Exception {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(this.driver, 3);
		wait.until(ExpectedConditions.visibilityOf(element));
		int iResetWaitTime = Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
		driver.manage().timeouts().implicitlyWait(iResetWaitTime, TimeUnit.SECONDS);
	}        

	public void verifyElementIsNotPresent1(String Object) throws Exception {
		if (CheckElementExists(Object) == false) {
			test.log(Status.PASS, Object + "Element not present");
		} else {
			test.log(Status.FAIL, "Element is not present");
		}
	}
	
	public void verifyElementIsNotPresent(String Object) throws Exception {
		if (CheckElementExists(Object) == false) {
			//test.log(Status.PASS, Object + "Element not present");
		} else {
			test.log(Status.FAIL, "Element is not present");
		}
	}

	public void VerifyTwoIntValue1(int ActualValue, int ExpectedValue) throws IOException {
		if (ActualValue == ExpectedValue) {
			System.out.println("Verification Passed for the value {" + ActualValue + "}");
			test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed, Expected value {" + ActualValue + "}"+ SuccessFontColorPrefix);
		} else {
			test.log(Status.FAIL, WARNINGFontColorPrefix + "Verificaion Failure, Expected value:{" + ExpectedValue
					+ "} Actual Value:{" + ActualValue + "}" + WARNINGFontColorPrefix);
		}
	}
	public void VerifyTwoIntValue(int ActualValue, int ExpectedValue) throws IOException {
		if (ActualValue == ExpectedValue) {
			System.out.println("Verification Passed for the value {" + ActualValue + "}");
		//	test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed, Expected value {" + ActualValue + "}"+ SuccessFontColorPrefix);
			test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed");
		} else {
			//test.log(Status.FAIL, WARNINGFontColorPrefix + "Verificaion Failure, Expected value:{" + ExpectedValue+ "} Actual Value:{" + ActualValue + "}" + WARNINGFontColorPrefix);
			test.log(Status.FAIL, SuccessFontColorPrefix + "Verification Failed");

		}
	}

	public boolean UIvalidation_IsDispalyed(String xpath) {
		boolean bExists = false;
		try {
			WebobjectExists(driver.findElement(By.xpath(xpath)));
			WebElement element = driver.findElement(By.xpath(xpath));
			if (element.isDisplayed()) {
				Thread.sleep(500);
				test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed, Expected value {" + element + "}"
						+ SuccessFontColorPrefix);
				return true;
			}
			test.log(Status.WARNING, WARNINGFontColorPrefix + "Verificaion Failure, Expected element:{" + element + "}"
					+ WARNINGFontColorPrefix);
			return false;
		}

		catch (Exception e) {
			test.log(Status.INFO, "IsDispalyed - Not Found");
		}
		return bExists;
	}

	public void selectDropdownValueStopPay_PartialText(String sEleXpath, String PartialText) {
		try {
			WebobjectExists(driver.findElement(By.xpath(sEleXpath)));
			driver.findElement(By.xpath(sEleXpath))
			.findElement(By.xpath("//span[contains(text(),'" + PartialText + "')]")).click();
		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
		}

	}

	public void openNewWindow(String url) {
		try {
			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);
		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
		}
	}

	public void selectDropdownValueLoanPayments_PartialText(String sEleXpath, String PartialText) {
		try {
			WebobjectExists(driver.findElement(By.xpath(sEleXpath)));
			driver.findElement(By.xpath(sEleXpath))
			.findElement(By.xpath("//span[contains(text(),'" + PartialText + "')]")).click();
		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
		}

	}

	public static void scrollUptillstarting(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
	}

	public void switchBacktoParentwindow() {
		try {
			Set<String> handlesSet = driver.getWindowHandles();
			List<String> handlesList = new ArrayList<String>(handlesSet);
			driver.switchTo().window(handlesList.get(0));
		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
		}

	}

	public void verifyElementIsPresent1(String Object, String Customtext) throws Exception {
		if (CheckElementExists(Object) == true) {
			test.log(Status.PASS, Customtext + "and Element " + Object + " is present");
		} else {
			test.log(Status.FAIL," Element is not present");
		}
	}
	
	public void verifyElementIsPresent(String Object, String Customtext) throws Exception {
		if (CheckElementExists(Object) == true) {
			//test.log(Status.PASS, Customtext + "and Element " + Object + " is present");
		} else {
			test.log(Status.FAIL," Element is not present");
		}
	}

	public void verifyElementIsNotPresent1(String Object, String CustomText) throws Exception {
		if (CheckElementExists(Object) == false) {
			test.log(Status.PASS, CustomText + "and Element " + Object + " is not present");
		} else {
			test.log(Status.FAIL, CustomText + "and Element " + Object + " is present");
		}
	}
	public void verifyElementIsNotPresent(String Object, String CustomText) throws Exception {
		if (CheckElementExists(Object) == false) {
			//test.log(Status.PASS, CustomText + "and Element " + Object + " is not present");
		} else {
			//test.log(Status.FAIL, "Element is not present");
		}
	}


	public String getValueFromDropdown(String sEleXpath) {
		String value = null;
		try {
			Select selectc = new Select(driver.findElement(By.xpath(sEleXpath)));
			value = selectc.getFirstSelectedOption().getText().trim();

		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}
		return value;
	}

	public List<WebElement> getAllValuesFromDropdown(String sEleXpath) {
		List<WebElement> value = null;
		try {
			Select selectc = new Select(driver.findElement(By.xpath(sEleXpath)));
			value = selectc.getOptions();

		} catch (Exception e) {
			test.log(Status.FAIL, "sEleXpath" + " NOT EXISTS - " + e);
			test.log(Status.FAIL,
					WARNINGFontColorPrefix + "WARNING found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
		}

		return value;
	}

	public void clearTextUsingKeys(String sEleXpath) throws Exception {
		String text = WebGetTextAttribute(sEleXpath);
		for (int i = 0; i < text.length(); i++) {
			driver.findElement(By.xpath(sEleXpath)).sendKeys(Keys.BACK_SPACE);
			SetExecutionDelay();
		}
	}

	public boolean waitForElement(String repo) {
		boolean bExists = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo)));
			return true;
		} catch (Exception e) {
			test.log(Status.INFO, "ExistsCheck - Not Found");
		}
		return bExists;
	}

	public void zoomInBrowser(String zoom) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.body.style.zoom = '" + zoom + "%'");
	}

	public void validateNotEquals1(String ActualValue, String ExpectedValue) {
		if (!ActualValue.contains(ExpectedValue)) {
			System.out.println("Verification Passed for the value {" + ActualValue + "}");
			test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed, Expected value {" + ActualValue + "}"
					+ SuccessFontColorSuffix);
		} else {
			test.log(Status.FAIL, WARNINGFontColorPrefix + "Verificaion Failure, Expected value:{" + ExpectedValue
					+ "} Actual Value:{" + ActualValue + "}" + WARNINGFontColorSuffix);
		}
	}
	
	public void validateNotEquals(String ActualValue, String ExpectedValue) {
		if (!ActualValue.contains(ExpectedValue)) {
			System.out.println("Verification Passed for the value {" + ActualValue + "}");
			test.log(Status.PASS, SuccessFontColorPrefix + "Verification Passed");
		} else {
			test.log(Status.FAIL, WARNINGFontColorPrefix + "Verificaion Failure");
		}
	}
	public void swithchToFrame(String Xpath) throws Exception {
		WebElement ele = driver.findElement(By.xpath(Xpath));
		driver.switchTo().frame(ele);
	}

	public void switchToParentWindow() throws Exception {
		SetExecutionDelay();
		driver.getWindowHandles();
	}
	
	public void WebClickUsingActions(String OR) {
		try {
			Actions builder = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath(OR));
			//Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
			builder.click(ele).build().perform();
		} catch (Exception e) {
//			test.log(Status.INFO, "WebDragAndDrop - Not Found");
		}
	}
}
