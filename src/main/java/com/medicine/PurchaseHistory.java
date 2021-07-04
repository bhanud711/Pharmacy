package com.medicine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class PurchaseHistory extends Screenshot{
	@Test
	public void purchaseHistory() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe"); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	    driver=new ChromeDriver(options);
	    test=report.startTest("Purchase History Details");
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
		WebElement account = driver.findElement(By.xpath("//span[@class='caret']/following::ul/li/a/img[1]"));
		a.moveToElement(account).click().build().perform();
		driver.findElement(By.xpath("//p[text()='Purchase History']")).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS,"Purchase History"+test.addScreenCapture(Screenshot.snap()));
	}

}
