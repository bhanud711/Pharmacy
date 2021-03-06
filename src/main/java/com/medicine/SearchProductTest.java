package com.medicine;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SearchProductTest extends Screenshot {
@Test
public void searchProduct() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver=new ChromeDriver(options);
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
	WebElement searchbar = driver.findElement(By.id("enterval"));
	searchbar.sendKeys("DOLO 650",Keys.ENTER);
	Thread.sleep(20000);
	Screenshot.snap();
	WebElement product = driver.findElement(By.xpath("//button[text()='Add to Cart']"));
	product.click();
}
}
