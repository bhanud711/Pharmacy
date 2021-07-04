package com.medicine;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class ItemRemove extends ProceedPayment  {
	@Test(dependsOnMethods= {"proceed"})
	public void itemRemove() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		test=report.startTest("Items Remove From Cart");
		driver.get("https://www.medplusmart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		test.log(LogStatus.PASS,"Opened Medplus application"+test.addScreenCapture(Screenshot.snap()));
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In/Register']"));
		signIn.click();
		Thread.sleep(10000);
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("arora3330@gmail.com");
		test.log(LogStatus.PASS,"Entered Username"+test.addScreenCapture(Screenshot.snap()));
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		passWord.sendKeys("Kanika24");
		test.log(LogStatus.PASS,"Entered password"+test.addScreenCapture(Screenshot.snap()));
		WebElement button = driver.findElement(By.xpath("//button[@id='popupLoginButton']"));
		test.log(LogStatus.PASS,"Click on Login"+test.addScreenCapture(Screenshot.snap()));
		button.click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[@id='microCartQty']")).click();
		test.log(LogStatus.PASS,"Click on Cart"+test.addScreenCapture(Screenshot.snap()));
		Thread.sleep(20000);
		driver.findElement(By.id("pharmaCheckOutBtn")).click();
		Thread.sleep(10000);
		test.log(LogStatus.PASS,"Items Displying in cart"+test.addScreenCapture(Screenshot.snap()));
		driver.findElement(By.xpath("//button[@class='btn btn-outline-danger action']")).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS,"Item Removed from cart"+test.addScreenCapture(Screenshot.snap()));
	       }
	       
	 
	}
