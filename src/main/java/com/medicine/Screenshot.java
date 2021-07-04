package com.medicine;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Screenshot {
	public static int i;
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public static String snap()
	{
		Random r= new Random();
		String dummy=null;
	if(r.nextInt()!=0)
	{
		i=i+1;
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=".//Snapshots//img"+i+".png";
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dummy=dest.getAbsolutePath();
	}
	return dummy;
	}
	
	@BeforeSuite()
	public static void begin()
	{
	report=new ExtentReports(".//ExtentReports//medplus.html", true);
	report.addSystemInfo("Environment", "Production");
	report.addSystemInfo("Author", "Kanika");
	report.addSystemInfo("MedplusApplication", "FinalProjectSubMission");

	}
	
	@AfterSuite()
	public void finalEnd()
	{
		report.endTest(test);
		report.flush();
	}
	}


