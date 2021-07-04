package com.medicine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class StoreFinder extends Screenshot {
	@Test()
	public void mediPlusHome() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe"); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		test=report.startTest("Medplus Store Finder");
	    driver=new ChromeDriver(options);	
		driver.get("https://www.medplusmart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Thread.sleep(20000);
		driver.findElement(By.xpath("//a[text()='Store Finder']")).click();
		//Screenshot.snap();
		test.log(LogStatus.PASS,"Store Finder"+test.addScreenCapture(Screenshot.snap()));
	}

}
