package com.medicine;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static int i;
	public static WebDriver driver;
	public String snap()
	{
		Random r= new Random();
		String dummy=null;
	if(r.nextInt()!=0)
	{
		i=i+1;
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=".//Snapshots//img"+i+".png";
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dummy=dest.getAbsolutePath();
	}
	return dummy;
	}

}
