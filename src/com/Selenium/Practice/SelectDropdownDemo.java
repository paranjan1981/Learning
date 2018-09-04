package com.Selenium.Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class SelectDropdownDemo {
	public static String geckopath = "E://SeleniumWebDriver//Installs//geckodriver.exe";
	public static String chromepath = "E://SeleniumWebDriver//Installs//chromedriver.exe";

	static WebDriver driver;

	public SelectDropdownDemo() {
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

	public static void selectDropdownList() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.linkText("Select Dropdown List")));
		WebElement selectDropdown = driver.findElement(By
				.linkText("Select Dropdown List"));
		selectDropdown.click();

	}

	public static void singleDropdownSelection() throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select-demo")));

		Select dayinweek = new Select(driver.findElement(By.id("select-demo")));

		WebElement daySelected = driver.findElement(By
				.xpath(".//*[@id='easycont']/div/div[2]/div[1]/div[2]/p[2]"));

		for (int i = 0; i <= 7; i++) {
			dayinweek.selectByIndex(i);
			System.out.println(daySelected.getText());

		}

	}

	public static void multiselectionDropdown() throws InterruptedException,
			AWTException {
		Select places = new Select(driver.findElement(By.id("multi-select")));
		System.out.println(places.getOptions().size());

		int countOfOptions = places.getOptions().size();

		WebElement firstSelected = driver.findElement(By.id("printMe"));
		WebElement getAllSelected = driver.findElement(By.id("printAll"));
		WebElement firstSelectedText = driver.findElement(By
				.xpath(".//*[@id='easycont']/div/div[2]/div[2]/div[2]/p[2]"));

		int i = 1;

		for (i = 1; i <= (countOfOptions - 2); i++) {
			WebElement select1 = driver.findElement(By
					.xpath(".//*[@id='multi-select']/option[" + i + "]"));
			WebElement select2 = driver.findElement(By
					.xpath(".//*[@id='multi-select']/option[" + i + "+1]"));
			WebElement select3 = driver.findElement(By
					.xpath(".//*[@id='multi-select']/option[" + i + "+2]"));

			Actions Actions = new Actions(driver);
			Actions.keyDown(Keys.LEFT_CONTROL).click(select1).click(select2)
					.click(select3).keyUp(Keys.LEFT_CONTROL).build().perform();

			getAllSelected.click();
			System.out.println(firstSelectedText.getText());
		}

	}

	public static void main(String[] args) throws InterruptedException,
			AWTException {
		// TODO Auto-generated method stub
		browserFirefoxLaunch();
		getUrl();
		startPracticing();
		selectDropdownList();
		singleDropdownSelection();
		multiselectionDropdown();

		Thread.sleep(5000);
		driver.close();

	}

}
