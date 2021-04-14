package com.medicine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MediPlusTest {
	@Test
	public void mediPlusHome()
	{
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.medplusmart.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        


	}

}
