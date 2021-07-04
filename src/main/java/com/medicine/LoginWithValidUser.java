package com.medicine;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LoginWithValidUser extends Screenshot {
	@Test
	public void loginValid() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe"); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	    driver=new ChromeDriver(options);
	    test=report.startTest("Login With ValidCredetials");
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
		test.log(LogStatus.PASS,"Provided Valid Username and password"+test.addScreenCapture(Screenshot.snap()));
		WebElement button = driver.findElement(By.xpath("//button[@id='popupLoginButton']"));
		button.click();
		Thread.sleep(10000);
		WebElement accountMgt=driver.findElement(By.xpath("//span[@class='caret']"));
		Actions a=new Actions(driver);
		a.moveToElement(accountMgt).click().build().perform();
		test.log(LogStatus.PASS,"Navigated to account management and clicking on My account"+test.addScreenCapture(Screenshot.snap()));
		WebElement myaccount = driver.findElement(By.xpath("//span[@class='caret']/following::ul/li/a/img[1]"));
		a.moveToElement(myaccount).click().build().perform();
		test.log(LogStatus.PASS,"User information is Displying"+test.addScreenCapture(Screenshot.snap()));
		
	}

}
