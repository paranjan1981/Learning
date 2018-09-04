package com.Selenium.Practice;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Wait;

public class FirefoxLaunch {
	public static String geckopath = "E://SeleniumWebDriver//Installs//geckodriver.exe";
	public static String chromepath = "E://SeleniumWebDriver//Installs//chromedriver.exe";

    static WebDriver driver;

	public static void PropertySetGecko() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", geckopath);
		Thread.sleep(1000);

	}

	public static void browserFirefoxLaunch() throws InterruptedException, IOException {
		// TODO Auto-generated constructor stub
		driver = new FirefoxDriver();
		//driver.get("https://www.google.com");
		getUrl();
		Thread.sleep(1000);
		driver.close();
	}

	public static void browserChromeLaunch() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		//driver.get("https://www.yahoo.com");
		getUrl();
		Thread.sleep(1000);
		driver.close();
	}

	public static void getUrl() throws IOException {
		driver.get("http://www.google.co.in");
		
		  try{
	         
			  driver.findElement(By.id("testing")).sendKeys("test");
	           
	          }
		  catch (Exception e){
			  System.out.println("I'm in exception");
	//calls the method to take the screenshot.
			  ScreenshotMethod();
		  }
	}
	
	public static void ScreenshotMethod() throws IOException {
		
		Date date = new Date();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
		//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File (filePath+date.getTime()+".jpg"));
	}

	public static void main(String args[]) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.gecko.driver", geckopath);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		
		Thread.sleep(5000);
		
		/*System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver chromedriver = new ChromeDriver();
		chromedriver.get("https://www.google.com");
		chromedriver.close();*/
		
		//browserFirefoxLaunch();
		Thread.sleep(5000);
		browserChromeLaunch();
		//driver.close();
		

	}

}
