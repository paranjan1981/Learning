package com.Selenium.Practice;
import com.Selenium.Practice.FirefoxLaunch;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static WebDriver driver;
	public static String filePath = "E:\\SeleniumWebDriver\\Automation\\Projects\\javaPractice\\Screenshots\\a.jpg";

	public static void ScreenshotMethod() throws IOException{
		
		//Date date = new Date();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        //FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
		//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:\\a.jpg"));
	}
	
	public static void openUrl() throws IOException
	{
		
		driver.get("https://www.google.co.in");
		
	  try{
         
		  driver.findElement(By.id("testing")).sendKeys("test");
           
          }
	  catch (Exception e){
		  System.out.println("I'm in exception");
		  ScreenshotMethod();
		  System.out.println("Screenshot captured");
	  }
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		FirefoxLaunch.PropertySetGecko();
		FirefoxLaunch.browserFirefoxLaunch();
		openUrl();
		driver.close();
		
	}

}
