package com.Selenium.Practice;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class MultipleCheckBoxDemo {
	public static String geckopath = "E://SeleniumWebDriver//Installs//geckodriver.exe";
	public static String chromepath = "E://SeleniumWebDriver//Installs//chromedriver.exe";

	static WebDriver driver;

	public MultipleCheckBoxDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void browserFirefoxLaunch() throws InterruptedException {
		// TODO Auto-generated constructor stub
		driver = new FirefoxDriver();
		getUrl();
		
	}

	public static void getUrl() {
		driver.get("http://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();

	}

	public static void startPracticing() {
		driver.findElement(By.id("btn_basic_example")).click();
		
		
		
	}
	
	public static void multipleCheckBoxForm()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Check Box Demo")));
		WebElement checkBoxForm = driver.findElement(By.linkText("Check Box Demo"));
		checkBoxForm.click();	
		
	}
	
	public static void multiCheckboxDeSelection() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check1")));
		
		WebElement checkAllButton = driver.findElement(By.id("check1"));
		
		for (int i = 1; i<=4; i++)
			
		{
			Thread.sleep(1000);
			WebElement checkboxes = driver.findElement(By.xpath(".//*[@id='easycont']/div/div[2]/div[2]/div[2]/div["+i+"]/label/input"));
			
			if (checkboxes.isSelected())
			{
				checkboxes.click();
			}
			else
			{
				System.out.println("Checkbox: "+checkboxes+" is already deselected");
			}
		}
		
	}
	
	public static void multiCheckboxSelection() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check1")));
		
		WebElement checkAllButton = driver.findElement(By.id("check1"));
		
		System.out.println("Button Name when all checkboxes are deselected-"+checkAllButton.getAttribute("value"));
		
		checkAllButton.click();
		
		System.out.println("Button Name when all checkboxes are Selected-"+checkAllButton.getAttribute("value"));
		
	}
	
	public static void samplemultiCheckboxDeSelection() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check1")));
		
		WebElement checkAllButton = driver.findElement(By.id("check1"));
		
		System.out.println("Button Name when all checkboxes are Selected-"+checkAllButton.getAttribute("value"));
		
		for (int i = 2; i<=3; i++)
			
		{
			Thread.sleep(1000);
			WebElement checkboxes = driver.findElement(By.xpath(".//*[@id='easycont']/div/div[2]/div[2]/div[2]/div["+i+"]/label/input"));
			
			if (checkboxes.isSelected())
			{
				checkboxes.click();
			}
			else
			{
				System.out.println("Checkbox: "+checkboxes+" is already deselected");
			}
		}

		
		System.out.println("Button Name when any checkbox is Deselected-"+checkAllButton.getAttribute("value"));
		
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		browserFirefoxLaunch();
		getUrl();
		startPracticing();
		multipleCheckBoxForm();
		multiCheckboxDeSelection();
		multiCheckboxSelection();
		samplemultiCheckboxDeSelection();
		
		Thread.sleep(5000);
		driver.close();

	}

}
