package com.azmqalabs.edaattestautomation.apppages.masterpages.invokeaut;

import org.openqa.selenium.NoSuchElementException;

import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;

public class BaseInvokeApplicationPage extends BasePage {

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

			test.log(Status.INFO, "Test URL: " + GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
			System.out.println("Test URL: " + GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
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
			test.log(Status.INFO, "Test URL: " + sURL);
			System.out.println("Test URL: " + sURL);
		} catch (Exception e) {
			throw new NoSuchElementException("launchApplication - URL not launched");
		}
	}

}
