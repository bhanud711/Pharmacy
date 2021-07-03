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

public class ItemQty {
	@Test
	public void itemQty() throws InterruptedException
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
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[@id='microCartQty']")).click();
		Thread.sleep(20000);
		driver.findElement(By.id("pharmaCheckOutBtn")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//div[@class='dropdown']/button")).click();
		Thread.sleep(10000);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown-menu show']/button"));
	       for (WebElement ele : list)
	       {  
	    	   WebElement qty = driver.findElement(By.xpath("//button[text()='5 (Packs)']"));
	           Actions a=new Actions(driver);
	          a.moveToElement(qty).click().build().perform();
	    	 /*  System.out.println("Values " + ele.getAttribute("innerHTML"));
	          if (ele.getAttribute("innerHTML").contains("5 (Packs)")) {
	            //ele.click();
	        	  JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", ele);
	             break;
	          }
	          */
	 
	       }
	       
	 
	}

}
