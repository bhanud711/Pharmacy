package com.medicine;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MedplusReport {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String path;
	public static int i=0;
	@BeforeSuite()
	public void begin()
	{
	report=new ExtentReports(".//ExtentReports//medplus.html", true);
	report.addSystemInfo("Environment", "Production");
	report.addSystemInfo("Author", "Jay");
	report.addSystemInfo("UserStory", "HT10");
	test=report.startTest("To verify the IHG TextFields Functionality");
	}
@Test()
	public void rama() throws IOException
{
	System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
	driver=new ChromeDriver();
	
	driver.get("https://www.ihg.com/rewardsclub/us/en/enrollment/join");
	test.log(LogStatus.PASS,"IHG WebPage is Loading"+test.addScreenCapture(snap()));
	
	driver.manage().window().maximize();
	test.log(LogStatus.PASS,"IHG page is maximizing"+test.addScreenCapture(snap()));
	
	System.out.println(driver.getTitle());
	test.log(LogStatus.PASS,"IHG page is titile"+test.addScreenCapture(snap()));
	
	System.out.println(driver.getCurrentUrl());
	test.log(LogStatus.PASS,"IHG WebPage is URL"+test.addScreenCapture(snap()));
	
	driver.findElement(By.id("firstName")).sendKeys("ramarao");
	test.log(LogStatus.PASS,"Entered firstname"+test.addScreenCapture(snap()));
	
	driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Derangulla");
	test.log(LogStatus.PASS,"Entered lastname"+test.addScreenCapture(snap()));
	
}

public String snap() throws IOException
{
	Random r= new Random();
	String dummy=null;
if(r.nextInt()!=0)
{
	i=i+1;
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path=".//Snapshots//img"+i+".png";
	File dest=new File(path);
	FileUtils.copyFile(src, dest);
	dummy=dest.getAbsolutePath();
}
return dummy;
}

@AfterSuite()
public void finalEnd()
{
	report.endTest(test);
	report.flush();
}
}
