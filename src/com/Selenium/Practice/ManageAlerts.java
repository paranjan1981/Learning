package com.Selenium.Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class ManageAlerts {
	public static String geckopath = "E://SeleniumWebDriver//Installs//geckodriver.exe";
	public static String chromepath = "E://SeleniumWebDriver//Installs//chromedriver.exe";

	static WebDriver driver;

	public ManageAlerts() {
		// TODO Auto-generated constructor stub
	}

	public static void browserFirefoxLaunch() throws InterruptedException {
		// TODO Auto-generated constructor stub
		driver = new FirefoxDriver();
		getUrl();
		
	}

	public static void getUrl() {
		driver.get("http://www.seleniumeasy.com/test/");

	}

	public static void startPracticing() {
		driver.findElement(By.id("btn_basic_example")).click();
		
	}
	
	public static void javaScriptAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Javascript Alerts")));
		WebElement simpleFormLink = driver.findElement(By.linkText("Javascript Alerts"));
		simpleFormLink.click();	
		
	}
	
	public static void javaScriptAlertBox()
	{
		
		WebElement alertBox = driver.findElement(By.xpath(".//*[@id='easycont']/div/div[2]/div[1]/div[2]/button"));
		alertBox.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
	}
	
	public static void javaScriptConfirmBoxDismiss() throws InterruptedException
	{
		WebElement alertBox = driver.findElement(By.xpath(".//*[@id='easycont']/div/div[2]/div[2]/div[2]/button"));
		alertBox.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		
		WebElement alertSelection = driver.findElement(By.id("confirm-demo"));
		System.out.println(alertSelection.getText());
		
	}
	
	public static void javaScriptConfirmBoxAccept() throws InterruptedException
	{
		WebElement alertBox = driver.findElement(By.xpath(".//*[@id='easycont']/div/div[2]/div[2]/div[2]/button"));
		alertBox.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		WebElement alertSelection = driver.findElement(By.id("confirm-demo"));
		System.out.println(alertSelection.getText());
	}
	
	
	public static void javaScriptAlertboxDismiss() throws InterruptedException
	{
		
		WebElement alertBox = driver.findElement(By.xpath(".//*[@id='easycont']/div/div[2]/div[3]/div[2]/button"));
		alertBox.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Hello Pratik");
		alert.dismiss();		
		
	}
	
	public static void javaScriptAlertboxAccept() throws InterruptedException
	{
		
		WebElement alertBox = driver.findElement(By.xpath(".//*[@id='easycont']/div/div[2]/div[3]/div[2]/button"));
		alertBox.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Hello Pratik");
		alert.accept();
		System.out.println(driver.findElement(By.id("prompt-demo")).getText());
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		browserFirefoxLaunch();
		getUrl();
		startPracticing();
		javaScriptAlert();
		//javaScriptAlertBox();
		//javaScriptConfirmBoxDismiss();
		Thread.sleep(3000);
		//javaScriptConfirmBoxAccept();
		javaScriptAlertboxDismiss();
		javaScriptAlertboxAccept();
		
		Thread.sleep(3000);
		driver.close();

	}

}
