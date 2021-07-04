package com.medicine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class MediplusLogout extends Screenshot {
	
	@Test
	public void logout() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe"); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	    driver=new ChromeDriver(options);	
	    test=report.startTest("User Logout Validation");
		driver.get("https://www.medplusmart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In/Register']"));
		signIn.click();
		Thread.sleep(10000);
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("arora3330@gmail.com");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		passWord.sendKeys("Kanika24");
		test.log(LogStatus.PASS,"Entered username and password"+test.addScreenCapture(Screenshot.snap()));
		WebElement button = driver.findElement(By.xpath("//button[@id='popupLoginButton']"));
		button.click();
		Thread.sleep(10000);
		WebElement accountMgt=driver.findElement(By.xpath("//span[@class='caret']"));
		Actions a=new Actions(driver);
		a.moveToElement(accountMgt).click().build().perform();
		test.log(LogStatus.PASS,"Navigated to accountmanagement and clicking on logout"+test.addScreenCapture(Screenshot.snap()));
		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
		a.moveToElement(logout).click().build().perform();
		Thread.sleep(5000);
		test.log(LogStatus.PASS,"User Logedout From medplus "+test.addScreenCapture(Screenshot.snap()));
		
	}

}
