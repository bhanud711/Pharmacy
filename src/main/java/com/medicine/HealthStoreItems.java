package com.medicine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HealthStoreItems {
	
	@Test
	public void healthStore() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
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
		Thread.sleep(10000);
		WebElement store = driver.findElement(By.xpath("(//a[text()='Health Store'])[2]"));
		WebElement otcHealth=driver.findElement(By.xpath("//a[@title='OTC & Health Needs']"));
		WebElement bpWeight = driver.findElement(By.xpath("//a[@title='BP & Weight Monitoring']"));
		Actions a=new Actions(driver);
		a.moveToElement(store).moveToElement(otcHealth).moveToElement(bpWeight).click().perform();
		WebElement item1 = driver.findElement(By.xpath("//div[@id='addMoreProducts']/div[1]"));
		a.moveToElement(item1).build().perform();
		
	}

}
