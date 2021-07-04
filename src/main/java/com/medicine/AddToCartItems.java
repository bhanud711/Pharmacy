package com.medicine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class AddToCartItems extends Screenshot{
	@Test
	public void addItemsToCart() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		test=report.startTest("Add Items To Cart");
		driver.get("https://www.medplusmart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		test.log(LogStatus.PASS,"Opening MedPlus Application"+test.addScreenCapture(Screenshot.snap()));
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In/Register']"));
		signIn.click();
		test.log(LogStatus.PASS,"Click on SignIn"+test.addScreenCapture(Screenshot.snap()));
		Thread.sleep(10000);
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("arora3330@gmail.com");
		test.log(LogStatus.PASS,"Entered username"+test.addScreenCapture(Screenshot.snap()));
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		passWord.sendKeys("Kanika24");
		test.log(LogStatus.PASS,"Entered password"+test.addScreenCapture(Screenshot.snap()));
		WebElement button = driver.findElement(By.xpath("//button[@id='popupLoginButton']"));
		button.click();
		test.log(LogStatus.PASS,"Click on Login"+test.addScreenCapture(Screenshot.snap()));
		Thread.sleep(10000);
		WebElement store = driver.findElement(By.xpath("(//a[text()='Health Store'])[2]"));
		WebElement otcHealth=driver.findElement(By.xpath("//a[@title='OTC & Health Needs']"));
		WebElement bpWeight = driver.findElement(By.xpath("//a[@title='BP & Weight Monitoring']"));
		Actions a=new Actions(driver);
		a.moveToElement(store).moveToElement(otcHealth).moveToElement(bpWeight).click().perform();
		WebElement item1 = driver.findElement(By.xpath("//div[@id='addMoreProducts']/div[1]"));
		a.moveToElement(item1).build().perform();
		test.log(LogStatus.PASS,"Select Item"+test.addScreenCapture(Screenshot.snap()));
		WebElement addToCart = driver.findElement(By.xpath("(//button[text()='Add to Cart'])[2]"));
		a.moveToElement(addToCart).click().build().perform();
		test.log(LogStatus.PASS,"Item added to cart"+test.addScreenCapture(Screenshot.snap()));
	}

}
