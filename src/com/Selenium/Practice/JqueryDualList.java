package com.Selenium.Practice;

import java.awt.Button;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class JqueryDualList {
	public static String geckopath = "E://SeleniumWebDriver//Installs//geckodriver.exe";
	public static String chromepath = "E://SeleniumWebDriver//Installs//chromedriver.exe";

	static WebDriver driver;

	public JqueryDualList() {
		// TODO Auto-generated constructor stub
	}

	public static void browserFirefoxLaunch() throws InterruptedException {
		// TODO Auto-generated constructor stub
		driver = new FirefoxDriver();
		getUrl();
		driver.manage().window().maximize();

	}

	public static void getUrl() {
		driver.get("http://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");

	}

	public static void picklist() {
		Select listbox = new Select(driver.findElement(By
				.xpath(".//*[@id='pickList']/div/div[1]/select")));
		listbox.getAllSelectedOptions();
		System.out.println("No. of Items in the List = "
				+ listbox.getOptions().size());

		for (int i = 1; listbox.getOptions().size() != 0; i++) {
			WebElement pick = driver.findElement(By
					.xpath(".//*[@id='pickList']/div/div[1]/select/option[1]"));
			pick.click();

			WebElement addButton = driver.findElement(By
					.xpath(".//*[@id='pickList']/div/div[2]/button[1]"));
			addButton.click();

			Select addedList = new Select(driver.findElement(By
					.xpath(".//*[@id='pickList']/div/div[3]/select")));
			System.out.println("No. of Items added in the List = "
					+ addedList.getOptions().size());

			for (int j = 1; j <= addedList.getOptions().size(); j++) {

				WebElement addedpick = driver.findElement(By
						.xpath(".//*[@id='pickList']/div/div[3]/select/option["
								+ j + "]"));
				System.out.println(addedpick.getText());

			}

		}

	}

	public static void multiPicklist() {
		Select listbox = new Select(driver.findElement(By
				.xpath(".//*[@id='pickList']/div/div[1]/select")));
		listbox.getAllSelectedOptions();
		System.out.println("No. of Items in the List = "
				+ listbox.getOptions().size());

		for (int i = 1; listbox.getOptions().size() != 0; i++) {

			if (listbox.getOptions().size() != 1) {

				WebElement pick1 = driver
						.findElement(By
								.xpath(".//*[@id='pickList']/div/div[1]/select/option[1]"));

				WebElement pick2 = driver
						.findElement(By
								.xpath(".//*[@id='pickList']/div/div[1]/select/option[3]"));

				Actions action = new Actions(driver);
				action.keyDown(Keys.LEFT_CONTROL).click(pick1).click(pick2)
						.keyUp(Keys.LEFT_CONTROL).build().perform();

				WebElement addButton = driver.findElement(By
						.xpath(".//*[@id='pickList']/div/div[2]/button[1]"));
				addButton.click();

				Select addedList = new Select(driver.findElement(By
						.xpath(".//*[@id='pickList']/div/div[3]/select")));
				System.out.println("No. of Items added in the List = "
						+ addedList.getOptions().size());

				for (int j = 1; j <= addedList.getOptions().size(); j++) {

					WebElement addedpick = driver
							.findElement(By
									.xpath(".//*[@id='pickList']/div/div[3]/select/option["
											+ j + "]"));
					System.out.println(addedpick.getText());

				}
			}

			else {
				System.out
						.println("We have only one item left in the pick list");
				WebElement pick1 = driver
						.findElement(By
								.xpath(".//*[@id='pickList']/div/div[1]/select/option[1]"));
				pick1.click();

				WebElement addButton = driver.findElement(By
						.xpath(".//*[@id='pickList']/div/div[2]/button[1]"));
				addButton.click();

				Select addedList = new Select(driver.findElement(By
						.xpath(".//*[@id='pickList']/div/div[3]/select")));
				System.out.println("No. of Items added in the List = "
						+ addedList.getOptions().size());

				for (int j = 1; j <= addedList.getOptions().size(); j++) {

					WebElement addedpick = driver
							.findElement(By
									.xpath(".//*[@id='pickList']/div/div[3]/select/option["
											+ j + "]"));
					System.out.println(addedpick.getText());

				}
			}
		}

	}

	@Test
	public static void main(String[] args) throws InterruptedException {
		String browser = null;
		// TODO Auto-generated method stub
		ParallelTest.openBrowser(browser);
		// getUrl();
		picklist();
		multiPicklist();
		Thread.sleep(3000);
		driver.close();

	}

}
