package com.Selenium.Practice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class ParallelTest {

	public static WebDriver driver;
	public static String geckopath = "E://SeleniumWebDriver//Installs//geckodriver.exe";
	public static String chromepath = "E://SeleniumWebDriver//Installs//chromedriver.exe";
	public static String edgepath = "E://SeleniumWebDriver//Installs//MicrosoftWebDriver.exe";

	@Parameters({ "browser" })
	
	@BeforeTest
	public static void openBrowser(String browser)

	{
		if (browser.equalsIgnoreCase("Firefox"))

		{
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", edgepath);
			driver = new EdgeDriver();
		}

	}

	public ParallelTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void getUrl() {
		driver.get("http://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
		driver.manage().window().maximize();

	}

	@Test
	public void picklist() throws InterruptedException {
		getUrl();
	
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

	@Test
	public void multiPicklist() throws InterruptedException {
		
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
	@AfterTest
	public void run()
	{
		driver.close();
	}

	}
