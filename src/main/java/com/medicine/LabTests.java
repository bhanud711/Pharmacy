package com.medicine;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LabTests extends Screenshot {

	@Test
	public void labTests()
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe"); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	    driver=new ChromeDriver(options);	
	    test=report.startTest("Labtests");
		driver.get("https://www.medplusmart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		test.log(LogStatus.PASS,"Medplus Application"+test.addScreenCapture(Screenshot.snap()));
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@title='Lab Tests']")).click();
		Set<String> all = driver.getWindowHandles();
		Iterator<String> i=all.iterator();
		while(i.hasNext())
		{
			String child=i.next();
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
			}
		}
		driver.findElement(By.xpath("//input[@id='testSearchInput']")).sendKeys("Total Thyroxine (TT4)",Keys.ENTER);
		test.log(LogStatus.PASS,"Displying Customer Searched LabTest Details with price"+test.addScreenCapture(Screenshot.snap()));
		
	}

}
