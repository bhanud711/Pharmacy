package com.medicine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class IEMediPlusTest extends Screenshot {
	
	@Test
	public void iEMediPlus()
	{   
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		System.setProperty("webdriver.chrome.driver", ".//drivers//IEDriverServer.exe");
		IEMediPlusTest ip=new IEMediPlusTest();
		driver=new InternetExplorerDriver(capabilities);
		driver.get("https://www.medplusmart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("Medplus webpage is opened in IE"+ip.snap());
	}

}
