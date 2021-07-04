package com.medicine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class InvalidLogin  extends Screenshot{
	@Test
	public void invalidLogin() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	  driver=new ChromeDriver(options);
	  test=report.startTest("Invalid Credentails");
		driver.get("https://www.medplusmart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		test.log(LogStatus.PASS,"Opening Url"+test.addScreenCapture(Screenshot.snap()));
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In/Register']"));
		signIn.click();
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("arora3330@gmail.com");
		test.log(LogStatus.PASS,"Entered Valid Username"+test.addScreenCapture(Screenshot.snap()));
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		passWord.sendKeys("Alpha123");
		test.log(LogStatus.PASS,"Entered Invalid Password"+test.addScreenCapture(Screenshot.snap()));
		WebElement button = driver.findElement(By.xpath("//button[@id='popupLoginButton']"));
		button.click();
		test.log(LogStatus.PASS,"Click on Login button"+test.addScreenCapture(Screenshot.snap()));
	}

}
