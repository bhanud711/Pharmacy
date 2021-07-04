package com.medicine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class ProceedPayment extends AddToCartItems{
	@Test(dependsOnMethods= {"addItemsToCart"})
public void proceed() throws InterruptedException
{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		 test=report.startTest("Bill Payment for Shoping Items");
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
		WebElement button = driver.findElement(By.xpath("//button[@id='popupLoginButton']"));
		button.click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[@id='microCartQty']")).click();
		Thread.sleep(20000);
		driver.findElement(By.id("pharmaCheckOutBtn")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button[text()='Proceed with current Locality']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//p[text()='MEDPLUS BALANAGAR HYDERABAD']/parent::address")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//button[text()=' Proceed ']")).click();
		Thread.sleep(10000);
		test.log(LogStatus.PASS,"Multiple Payment Methods Displaying"+test.addScreenCapture(Screenshot.snap()));
		WebElement creditcared = driver.findElement(By.xpath("//div[@class='selected-payment']"));
		test.log(LogStatus.PASS," Select credit card"+test.addScreenCapture(Screenshot.snap()));
		WebElement pay = driver.findElement(By.xpath("//button[text()='Pay']"));
		Actions a=new Actions(driver);
		a.moveToElement(creditcared).moveToElement(pay).click().build().perform();
		Thread.sleep(20000);
		driver.findElement(By.name("paymode")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//input[@type='tel'])[1]")).sendKeys("4111 1111 1111 1111");
		driver.findElement(By.xpath("(//input[@type='tel'])[2]")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("678");
		driver.findElement(By.xpath("//span[text()='PAY ']")).click();
		test.log(LogStatus.PASS,"Provided Paymenet Details and click on Pay"+test.addScreenCapture(Screenshot.snap()));
}
}
