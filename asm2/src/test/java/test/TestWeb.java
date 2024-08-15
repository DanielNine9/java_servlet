package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.bean.User;
import test.utils.UserDAO;

import org.apache.commons.io.FileUtils;

public class TestWeb {
	WebDriver driver;
	String password = "secret_sauce";
	String wrongPassword = "wor";
	UserDAO dao = new UserDAO();
	String usernameTest = "testUsername__";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\dinhh\\OneDrive\\Desktop\\ktnc\\advance_test\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
		User user = dao.findById(usernameTest);
		if (user != null) {
			dao.remove(usernameTest);

		}
	}

	@BeforeMethod
	public void before() {
		driver.get("http://localhost:8080/lab7/auth/login");
	}

	@AfterMethod
	public void afterMethod1() {
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
		String expectedTitle = "Bootstrap demo";
		Assert.assertEquals(actualTitle, expectedTitle, "Bootstrap Demo is not title");
	}

//	Register
	@Test
	public void testRegister() {
		driver.get("http://localhost:8080/lab7/auth/register");
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement confirm = driver.findElement(By.id("confirm"));
		WebElement registerButton = driver.findElement(By.id("register"));
		String passwordString = "1234";
		username.sendKeys("admin@admin.com");
		password.sendKeys(passwordString);
		fullname.sendKeys("admin");
		confirm.sendKeys(passwordString);
		registerButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Username đã tồn tại.");
	}

	@Test
	public void testRegisterPasswordEmpty() {
		driver.get("http://localhost:8080/lab7/auth/register");
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement confirm = driver.findElement(By.id("confirm"));
		WebElement registerButton = driver.findElement(By.id("register"));
		String passwordString = "1234";
		username.sendKeys("admin@admin.com");
		password.sendKeys("");
		fullname.sendKeys("admin");
		confirm.sendKeys(passwordString);
		registerButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Vui lòng nhập đầy đủ thông tin đăng ký.");
	}

	@Test
	public void testRegisterUsernameEmpty() {
		driver.get("http://localhost:8080/lab7/auth/register");
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement confirm = driver.findElement(By.id("confirm"));
		WebElement registerButton = driver.findElement(By.id("register"));
		String passwordString = "1234";
		username.sendKeys("");
		password.sendKeys(passwordString);
		fullname.sendKeys("admin");
		confirm.sendKeys(passwordString);
		registerButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Vui lòng nhập đầy đủ thông tin đăng ký.");
	}

	@Test
	public void testRegisterFullNameEmpty() {
		driver.get("http://localhost:8080/lab7/auth/register");
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement confirm = driver.findElement(By.id("confirm"));
		WebElement registerButton = driver.findElement(By.id("register"));
		String passwordString = "1234";
		username.sendKeys("admin");
		password.sendKeys(passwordString);
		fullname.sendKeys("");
		confirm.sendKeys(passwordString);
		registerButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Vui lòng nhập đầy đủ thông tin đăng ký.");
	}

	@Test
	public void testRegisterAllEmpty() {
		driver.get("http://localhost:8080/lab7/auth/register");
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement confirm = driver.findElement(By.id("confirm"));
		WebElement registerButton = driver.findElement(By.id("register"));
		String passwordString = "";
		username.sendKeys("");
		password.sendKeys(passwordString);
		fullname.sendKeys("");
		confirm.sendKeys(passwordString);
		registerButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Vui lòng nhập đầy đủ thông tin đăng ký.");
	}

	@Test
	public void testRegisterNotEqualPasswordAndConfirm() {
		driver.get("http://localhost:8080/lab7/auth/register");
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement confirm = driver.findElement(By.id("confirm"));
		WebElement registerButton = driver.findElement(By.id("register"));
		String passwordString = "1234";
		username.sendKeys("test");
		password.sendKeys(passwordString);
		fullname.sendKeys("test");
		confirm.sendKeys(passwordString + "5");
		registerButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Vui lòng nhập đầy đủ thông tin đăng ký.");
	}

//	Login
	@Test
	public void testLoginWr() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("12345");
		loginButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Tài khoản hoặc mật khẩu không chính xác.");
	}

	@Test
	public void testLoginWithAccountHasNotBeenReigstered() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin123123@admin.com");
		password.sendKeys("12345");
		loginButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Tài khoản hoặc mật khẩu không chính xác.");
	}
	
	@Test
	public void testLoginWithAccountHasNotBeenReigstered1() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin123@admin.com");
		password.sendKeys("12345");
		loginButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Tài khoản hoặc mật khẩu không chính xác.");
	}
	@Test
	public void testLoginWithAccountHasNotBeenReigstered2() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin12ff3@admin.com");
		password.sendKeys("12345");
		loginButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Tài khoản hoặc mật khẩu không chính xác.");
	}
	@Test
	public void testLoginWithAccountHasNotBeenReigstered3() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin123kkk@admin.com");
		password.sendKeys("12345");
		loginButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Tài khoản hoặc mật khẩu không chính xác.");
	}
	

	@Test
	public void testLoginWithEmptyUsername() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("");
		password.sendKeys("12345");
		loginButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Vui lòng nhập đầy đủ tài khoản và mật khẩu.");
	}

	@Test
	public void testLoginWithEmptyPassword() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin");
		password.sendKeys("");
		loginButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Vui lòng nhập đầy đủ tài khoản và mật khẩu.");
	}

	@Test
	public void testLoginWithEmptyPasswordAndEmptyUsername() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("");
		password.sendKeys("");
		loginButton.click();

		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertTrue(alert.isDisplayed(), "Vui lòng nhập đầy đủ tài khoản và mật khẩu.");
	}

//	Login successfully
	@Test
	public void testLoginSuccessfullyCheckWelcome() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));
//		WebElement logoutButton = driver.findElement(By.id("logout"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.id("alert"));
		System.out.println(inventoryTitle.isDisplayed());
		Assert.assertTrue(inventoryTitle.isDisplayed(), "Welcome, admin");
//		WebElement alert = driver.findElement(By.id("alert"));
//		logoutButton.click();
//		System.out.println(logoutButton);

		driver.get("http://localhost:8080/lab7/auth/logout");

	}

	@Test
	public void testLoginSuccessfullyCheckTitle() {
		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.id("title"));
		System.out.println(inventoryTitle.isDisplayed());
		Assert.assertTrue(inventoryTitle.isDisplayed(), "Danh sách sản phẩm");
		driver.get("http://localhost:8080/lab7/auth/logout");
	}

	@Test
	public void testLoginSuccessfullyChecTitle() {
		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		WebElement inventoryTitle = driver.findElement(By.id("title"));
		System.out.println(inventoryTitle.isDisplayed());
		Assert.assertTrue(inventoryTitle.isDisplayed(), "Danh sách sản phẩm");
		driver.get("http://localhost:8080/lab7/auth/logout");

	}

	@Test
	public void testLoginSuccessfullyCheckManagement() {
		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		// Find the management element after login
		WebElement management = driver.findElement(By.id("management"));
		System.out.println(management);
		// Check if the management element is displayed
		assertTrue(management.isDisplayed());
		driver.get("http://localhost:8080/lab7/auth/logout");
	}

	@Test
	public void testLoginSuccessfullyCheckEnterManagement() {
		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		// Find the management element after login
		WebElement management = driver.findElement(By.id("management"));
		System.out.println(management);
		// Check if the management element is displayed
		assertTrue(management.isDisplayed());
		driver.get("http://localhost:8080/lab7/user/index");
		WebElement inventoryTitle = driver.findElement(By.id("title-user"));
		System.out.println("text " + inventoryTitle.getText());
		Assert.assertEquals(inventoryTitle.getText(), "User Form");
		driver.get("http://localhost:8080/lab7/auth/logout");
	}

//	form user
	@Test
	public void testUserFormSubmissionUsernameEmpty() {

		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		// Find the management element after login
		WebElement management = driver.findElement(By.id("management"));
		System.out.println(management);
		// Check if the management element is displayed
		assertTrue(management.isDisplayed());
		driver.get("http://localhost:8080/lab7/user/index");
		WebElement inventoryTitle = driver.findElement(By.id("title-user"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "User Form");
		// Navigate to the form page
		driver.get("http://localhost:8080/lab7/user/index");

		// Wait for the form elements to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Fill in the form fields
		WebElement usernameForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement passwordForm = driver.findElement(By.id("password"));
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement adminRole = driver.findElement(By.id("adminRole"));

		usernameForm.clear();
		usernameForm.sendKeys("");
		passwordForm.clear();
		passwordForm.sendKeys("password123");
		fullname.clear();
		fullname.sendKeys("Test User");
		email.clear();
		email.sendKeys("testuser@example.com");
		adminRole.click();

		WebElement createButton = driver.findElement(By.id("create"));
		createButton.click();

		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert")));
		Assert.assertEquals(successMessage.getText(), "Vui lòng nhập đầy đủ tất cả các trường");

	}

	@Test
	public void testUserFormSubmissionAllEmpty() {

		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		// Find the management element after login
		WebElement management = driver.findElement(By.id("management"));
		System.out.println(management);
		// Check if the management element is displayed
		assertTrue(management.isDisplayed());
		driver.get("http://localhost:8080/lab7/user/index");
		WebElement inventoryTitle = driver.findElement(By.id("title-user"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "User Form");
		// Navigate to the form page
		driver.get("http://localhost:8080/lab7/user/index");

		// Wait for the form elements to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Fill in the form fields
		WebElement usernameForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement passwordForm = driver.findElement(By.id("password"));
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement adminRole = driver.findElement(By.id("adminRole"));

		usernameForm.clear();
		usernameForm.sendKeys("");
		passwordForm.clear();
		passwordForm.sendKeys("");
		fullname.clear();
		fullname.sendKeys("");
		email.clear();
		email.sendKeys("");
		adminRole.click();

		WebElement createButton = driver.findElement(By.id("create"));
		createButton.click();

		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert")));
		Assert.assertEquals(successMessage.getText(), "Vui lòng nhập đầy đủ tất cả các trường");

	}

	@Test
	public void testUserFormSubmissionPasswordEmpty() {

		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		// Find the management element after login
		WebElement management = driver.findElement(By.id("management"));
		System.out.println(management);
		// Check if the management element is displayed
		assertTrue(management.isDisplayed());
		driver.get("http://localhost:8080/lab7/user/index");
		WebElement inventoryTitle = driver.findElement(By.id("title-user"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "User Form");
		// Navigate to the form page
		driver.get("http://localhost:8080/lab7/user/index");

		// Wait for the form elements to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Fill in the form fields
		WebElement usernameForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement passwordForm = driver.findElement(By.id("password"));
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement adminRole = driver.findElement(By.id("adminRole"));

		usernameForm.clear();
		usernameForm.sendKeys("");
		passwordForm.clear();
		passwordForm.sendKeys("");
		fullname.clear();
		fullname.sendKeys("Test User");
		email.clear();
		email.sendKeys("testuser@example.com");
		adminRole.click();

		WebElement createButton = driver.findElement(By.id("create"));
		createButton.click();

		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert")));
		Assert.assertEquals(successMessage.getText(), "Vui lòng nhập đầy đủ tất cả các trường");

	}

	@Test
	public void testUserFormSubmissionFullnameEmpty() {

		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		// Find the management element after login
		WebElement management = driver.findElement(By.id("management"));
		System.out.println(management);
		// Check if the management element is displayed
		assertTrue(management.isDisplayed());
		driver.get("http://localhost:8080/lab7/user/index");
		WebElement inventoryTitle = driver.findElement(By.id("title-user"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "User Form");
		// Navigate to the form page
		driver.get("http://localhost:8080/lab7/user/index");

		// Wait for the form elements to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Fill in the form fields
		WebElement usernameForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement passwordForm = driver.findElement(By.id("password"));
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement adminRole = driver.findElement(By.id("adminRole"));

		usernameForm.clear();
		usernameForm.sendKeys("123");
		passwordForm.clear();
		passwordForm.sendKeys("password123");
		fullname.clear();
		fullname.sendKeys("");
		email.clear();
		email.sendKeys("testuser@example.com");
		adminRole.click();

		WebElement createButton = driver.findElement(By.id("create"));
		createButton.click();

		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert")));
		Assert.assertEquals(successMessage.getText(), "Vui lòng nhập đầy đủ tất cả các trường");

	}

	@Test
	public void testUserFormSubmissionEmailEmpty() {

		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		// Find the management element after login
		WebElement management = driver.findElement(By.id("management"));
		System.out.println(management);
		// Check if the management element is displayed
		assertTrue(management.isDisplayed());
		driver.get("http://localhost:8080/lab7/user/index");
		WebElement inventoryTitle = driver.findElement(By.id("title-user"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "User Form");
		// Navigate to the form page
		driver.get("http://localhost:8080/lab7/user/index");

		// Wait for the form elements to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Fill in the form fields
		WebElement usernameForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement passwordForm = driver.findElement(By.id("password"));
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement adminRole = driver.findElement(By.id("adminRole"));

		usernameForm.clear();
		usernameForm.sendKeys("testuser@example.com");
		passwordForm.clear();
		passwordForm.sendKeys("password123");
		fullname.clear();
		fullname.sendKeys("Test User");
		email.clear();
		email.sendKeys("");
		adminRole.click();

		WebElement createButton = driver.findElement(By.id("create"));
		createButton.click();

		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert")));
		Assert.assertEquals(successMessage.getText(), "Vui lòng nhập đầy đủ tất cả các trường");

	}

	@Test
	public void testUserFormSubmission() {

		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		// Find the management element after login
		WebElement management = driver.findElement(By.id("management"));
		System.out.println(management);
		// Check if the management element is displayed
		assertTrue(management.isDisplayed());
		driver.get("http://localhost:8080/lab7/user/index");
		WebElement inventoryTitle = driver.findElement(By.id("title-user"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "User Form");
		// Navigate to the form page
		driver.get("http://localhost:8080/lab7/user/index");

		// Wait for the form elements to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Fill in the form fields
		WebElement usernameForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement passwordForm = driver.findElement(By.id("password"));
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement adminRole = driver.findElement(By.id("adminRole"));

		usernameForm.clear();
		usernameForm.sendKeys(usernameTest);
		passwordForm.clear();
		passwordForm.sendKeys("password123");
		fullname.clear();
		fullname.sendKeys("Test User");
		email.clear();
		email.sendKeys("testuser@example.com");
		adminRole.click();

		WebElement createButton = driver.findElement(By.id("create"));
		createButton.click();

		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert")));
		Assert.assertEquals(successMessage.getText(), "Thêm mới thành công");

	}

	@Test
	public void testUserFormSubmissionConflict() {

		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		WebElement management = driver.findElement(By.id("management"));
		System.out.println(management);
		assertTrue(management.isDisplayed());
		driver.get("http://localhost:8080/lab7/user/index");
		WebElement inventoryTitle = driver.findElement(By.id("title-user"));
		Assert.assertTrue(inventoryTitle.isDisplayed(), "User Form");
		driver.get("http://localhost:8080/lab7/user/index");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Fill in the form fields
		WebElement usernameForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement passwordForm = driver.findElement(By.id("password"));
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement adminRole = driver.findElement(By.id("adminRole"));

		usernameForm.clear();
		usernameForm.sendKeys(usernameTest);
		passwordForm.clear();
		passwordForm.sendKeys("password123");
		fullname.clear();
		fullname.sendKeys("Test User");
		email.clear();
		email.sendKeys("testuser@example.com");
		adminRole.click();

		WebElement createButton = driver.findElement(By.id("create"));
		createButton.click();

		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert")));
		Assert.assertEquals(successMessage.getText(), "Thêm mới thành công");

		usernameForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		passwordForm = driver.findElement(By.id("password"));
		fullname = driver.findElement(By.id("fullname"));
		email = driver.findElement(By.id("email"));
		adminRole = driver.findElement(By.id("adminRole"));
		usernameForm.clear();
		usernameForm.sendKeys(usernameTest);
		passwordForm.clear();
		passwordForm.sendKeys("password123");
		fullname.clear();
		fullname.sendKeys("Test User");
		email.clear();
		email.sendKeys("testuser@example.com");
		adminRole.click();

		createButton = driver.findElement(By.id("create"));
		createButton.click();

		successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert")));

		Assert.assertEquals(successMessage.getText(), "Username đã tồn tại.");

	}

	@Test
	public void testResetButton() {
		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement management = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("management")));
		management.click();

		driver.get("http://localhost:8080/lab7/user/index");

		WebElement usernameForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement passwordForm = driver.findElement(By.id("password"));
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement email = driver.findElement(By.id("email"));

		usernameForm.clear();
		usernameForm.sendKeys("testuser");
		passwordForm.clear();
		passwordForm.sendKeys("password123");
		fullname.clear();
		fullname.sendKeys("Test User");
		email.clear();
		email.sendKeys("testuser@example.com");
		System.out.println("Email " + email.getText());

		WebElement resetButton = driver.findElement(By.id("reset"));
		resetButton.click();

		passwordForm = driver.findElement(By.id("password"));
		fullname = driver.findElement(By.id("fullname"));
		email = driver.findElement(By.id("email"));

		assertEquals(email.getText(), "");
		assertEquals(fullname.getText(), "");
		assertEquals(passwordForm.getText(), "");

	}

	@Test
	public void testSession() {
		driver.get("http://localhost:8080/lab7/auth/login");

		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		// Use the correct constructor for WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, 30);

		// Wait for the management element to be visible
		WebElement management = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("management")));
		management.click();

		driver.get("http://localhost:8080/lab7/user/index");

		// Wait for the username form element to be visible
		WebElement usernameForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement passwordForm = driver.findElement(By.id("password"));
		WebElement fullname = driver.findElement(By.id("fullname"));
		WebElement email = driver.findElement(By.id("email"));

		usernameForm.clear();
		usernameForm.sendKeys("testuser");
		passwordForm.clear();
		passwordForm.sendKeys("password123");
		fullname.clear();
		fullname.sendKeys("Test User");
		email.clear();
		email.sendKeys("testuser@example.com");

		System.out.println("Email: " + email.getAttribute("value"));

		WebElement resetButton = driver.findElement(By.id("reset"));
		resetButton.click();

		// Wait for the elements to be reset and then check their values
		WebElement resetPasswordForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		WebElement resetFullname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
		WebElement resetEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

		// Use getAttribute("value") for input fields
		assertEquals("", resetEmail.getAttribute("value"));
		assertEquals("", resetFullname.getAttribute("value"));
		assertEquals("", resetPasswordForm.getAttribute("value"));
	}

	@Test
	public void checkTitleUserManagement() {
		driver.get("http://localhost:8080/lab7/auth/login");

		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("admin@admin.com");
		password.sendKeys("1234");
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		// Use the correct constructor for WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, 30);

		// Wait for the management element to be visible
		WebElement management = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("management")));
		management.click();

		driver.get("http://localhost:8080/lab7/user/index");
		String actualTitle = driver.getTitle();
		String expectedTitle = "User Management";
		Assert.assertEquals(actualTitle, expectedTitle, "User Management is not title");
	}
	

	@Test
	public void testUserFormWithUserRole() {

		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("username");
		password.sendKeys("1234");
		loginButton.click();

		driver.get("http://localhost:8080/lab7/user/index");
		
		WebElement alert = driver.findElement(By.id("alert"));
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "Please login with admin role");

	}

	@Test
	public void testUserFormWithUserRoleEmptyUsername() {

		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("");
		password.sendKeys("1234");
		loginButton.click();

		
		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertEquals(alert.getText(), "Vui lòng nhập đầy đủ tài khoản và mật khẩu.");

	}
	@Test
	public void testUserFormWithUserRoleEmptyPassword() {

		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("asd");
		password.sendKeys("");
		loginButton.click();

		
		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertEquals(alert.getText(), "Vui lòng nhập đầy đủ tài khoản và mật khẩu.");

	}
	
	@Test
	public void testUserFormWithUserHasNotBeernREgistered() {

		driver.get("http://localhost:8080/lab7/auth/login");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		username.sendKeys("asd");
		password.sendKeys("123");
		loginButton.click();

		
		WebElement alert = driver.findElement(By.id("alert"));
		Assert.assertEquals(alert.getText(), "Tài khoản hoặc mật khẩu không chính xác.");

	}
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
