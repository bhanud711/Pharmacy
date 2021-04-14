package com.medicine;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchProductTest {
@Test
public void eneterProduct()
{
	System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.medplusmart.com/");
    driver.manage().window().maximize();
    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());
    driver.findElement(By.id("enterval")).sendKeys("PARACITAMOL",Keys.ENTER);
}
}
