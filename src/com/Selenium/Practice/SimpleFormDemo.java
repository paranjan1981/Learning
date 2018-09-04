package com.Selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class SimpleFormDemo {
	public static String geckopath = "E://SeleniumWebDriver//Installs//geckodriver.exe";
	public static String chromepath = "E://SeleniumWebDriver//Installs//chromedriver.exe";

	static WebDriver driver;

	public SimpleFormDemo() {
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
	
	public static void simpleForm()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Simple Form Demo")));
		WebElement simpleFormLink = driver.findElement(By.linkText("Simple Form Demo"));
		simpleFormLink.click();	
		
	}
	
	public static void singleInputField()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-message")));
		
		WebElement enterMessage = driver.findElement(By.id("user-message"));
		
		String inputMessage = "This is the first selenium code";
		
		enterMessage.sendKeys(inputMessage);
		
		driver.findElement(By.xpath(".//*[@id='get-input']/button")).click();
		
		WebElement yourMessage = driver.findElement(By.id("display"));
		System.out.println(yourMessage.getText());
		
		if(yourMessage.getText().equals(inputMessage))
		{
			System.out.println("User Input and displayed message are same");
		}
		
		else
		{
			System.out.println("Input and Output messages are different");
		}
		
		
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		browserFirefoxLaunch();
		getUrl();
		startPracticing();
		simpleForm();
		singleInputField();
		
		Thread.sleep(3000);
		driver.close();

	}

}
