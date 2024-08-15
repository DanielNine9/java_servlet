package test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class TestSauceDemo {
	WebDriver driver;
	String password = "secret_sauce";
	String wrongPassword = "wor";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\dinhh\\OneDrive\\Desktop\\ktnc\\advance_test\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
//		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void before() {
		driver.get("https://www.saucedemo.com/");
	}

	@AfterMethod
	public void afterMethod() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String uuid = UUID.randomUUID().toString();
		File destFile = new File("./images/" + uuid + ".png");

		try {
			FileUtils.copyFile(scrFile, destFile);
			System.out.println("Screenshot taken: " + destFile.getAbsolutePath());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void checkTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected title.");
	}

	@Test
	public void testLogin() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("standard_user");
		password.sendKeys(this.password);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("title"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "Login failed or incorrect page title");
	}

	@Test
	public void testLoginlocked_out_user() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("locked_out_user");
		password.sendKeys(this.password);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("error"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "Epic sadface: Sorry, this user has been locked out.");
	}

	@Test
	public void testLoginproblem_user() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("problem_user");
		password.sendKeys(this.password);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("title"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "Products");
	}

	@Test
	public void testLoginperformance_glitch_user() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("performance_glitch_user");
		password.sendKeys(this.password);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("title"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "Products");
	}

	@Test
	public void testLoginerror_user() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("error_user");
		password.sendKeys(this.password);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("title"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "Products");
	}

	@Test
	public void testLoginvisual_user() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("visual_user");
		password.sendKeys(this.password);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("title"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "Products");
	}

	@Test
	public void testWithWrongPasswordvisual_user() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("visual_user");
		password.sendKeys(this.wrongPassword);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("error"));
		System.out.println(inventoryTitle.isDisplayed());
		Assert.assertTrue(inventoryTitle.isDisplayed(),
				"Epic sadface: Username and password do not match any user in this service");
	}

	@Test
	public void testWithWrongPassworderror_user() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("error_user");
		password.sendKeys(this.wrongPassword);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("error"));
		System.out.println(inventoryTitle.isDisplayed());
		Assert.assertTrue(inventoryTitle.isDisplayed(),
				"Epic sadface: Username and password do not match any user in this service");
	}

	@Test
	public void testWithWrongPasswordperformance_glitch_user() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("performance_glitch_user");
		password.sendKeys(this.wrongPassword);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("error"));
		System.out.println(inventoryTitle.isDisplayed());
		Assert.assertTrue(inventoryTitle.isDisplayed(),
				"Epic sadface: Username and password do not match any user in this service");
	}

	@Test
	public void testWithWrongPasswordproblem_user() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("problem_user");
		password.sendKeys(this.wrongPassword);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("error"));
		System.out.println(inventoryTitle.isDisplayed());
		Assert.assertTrue(inventoryTitle.isDisplayed(),
				"Epic sadface: Username and password do not match any user in this service");
	}

	@Test
	public void testWithWrongPasswordlocked_out_user() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("locked_out_user");
		password.sendKeys(this.wrongPassword);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("error"));
		System.out.println(inventoryTitle.isDisplayed());
		Assert.assertTrue(inventoryTitle.isDisplayed(),
				"Epic sadface: Username and password do not match any user in this service");
	}

	@Test
	public void testWithWrongPasswordstandarduser() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("standard_user");
		password.sendKeys(this.wrongPassword);
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.className("error"));
		System.out.println(inventoryTitle.isDisplayed());
		Assert.assertTrue(inventoryTitle.isDisplayed(),
				"Epic sadface: Username and password do not match any user in this service");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
