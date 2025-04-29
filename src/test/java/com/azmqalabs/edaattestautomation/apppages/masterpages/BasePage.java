package com.azmqalabs.edaattestautomation.apppages.masterpages;

import java.util.NoSuchElementException;

import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.common.Common;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.codoid.products.fillo.Recordset;

public class BasePage extends Common {

	public void launchApplication() {
		try {
			String MavenCmdLineAppUrl = "";
			MavenCmdLineAppUrl = System.getProperty("appurl");
			System.out.println("Maven externalized parameter: " + MavenCmdLineAppUrl);
			if (MavenCmdLineAppUrl != null)
				driver.get(MavenCmdLineAppUrl);
			else
				System.out.println(GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
			driver.get(GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
			waitForPageToLoad();
			System.out.println("Test URL: " + GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			driver.navigate().to(GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
		}
	}

	public void launchApplication(String sURL) {
		try {
			String MavenCmdLineTestType = "";
			MavenCmdLineTestType = System.getProperty("testtype");
			System.out.println("Maven externalized parameter: " + MavenCmdLineTestType);
			driver.get(sURL);
//			test.log(Status.INFO, "Test URL: " + sURL);
			System.out.println("Test URL: " + sURL);
//			this.takeScreenShot();
		} catch (Exception e) {
			this.takeScreenShot();
//			test.log(Status.FAIL, WARNINGFontColorPrefix
//					+ "launchApplication Page - launchApplication failed - unable to Enter" + e + WARNINGFontColorSuffix);
//			test.log(Status.FAIL,
//					WARNINGFontColorPrefix + "Error found at class: " + this.getClass().getName() + " Code line Number: "
//							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + WARNINGFontColorSuffix);
//			throw new NoSuchElementException("launchApplication - URL not launched");
		}
	}
	public void launchnextApplication() throws Exception {	
		Recordset URL = ReadData.readTestDataBySpecifiedValueLike("URL", "BankName;Environment", "Default1;QA");
		URL.next();
		launchApplication(URL.getField("URL"));
	}

}
