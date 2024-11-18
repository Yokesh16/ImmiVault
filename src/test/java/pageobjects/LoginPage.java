package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;

public class LoginPage extends Base {
	private static LoginPage instance;

	private LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public static LoginPage getInstance() {
		if (instance == null) {
			synchronized (LoginPage.class) {
				if (instance == null) {
					instance = new LoginPage();
				}
			}
		}
		return instance;
	}

	// Login Page Test data
	public static String Username = "shan";
	public static String pwd = "Avengers@123";

	// Login Page Test Objects

	@FindBy(xpath = "//input[@name='email']")
	private static WebElement userNameFieldLogInPage;

	@FindBy(xpath = "//input[@name='password']")
	private static WebElement pwdFieldLogInPage;

	@FindBy(xpath = "//button[@id='button_submit']")
	private static WebElement SubmitBtnLogInPage;

	// Login Page Actions

	public LoginPage EnterUserName(String Username) {
		userNameFieldLogInPage.sendKeys(Username);
		return this;
	}

	public LoginPage EnterPassword(String pwd) {
		pwdFieldLogInPage.sendKeys(pwd);
		return this;
	}

	public LoginPage clickLogginBtn() {
		SubmitBtnLogInPage.click();
		return this;
	}
	
	
	//for positive login
	public LoginPage Login(String Username, String pwd) {
		EnterUserName(Username).EnterPassword(pwd).clickLogginBtn();
		return this;
	}
	//To check assert on the login field
	public LoginPage Login(String Username, String pwd,WebElement ele, String assertMesage) {
		EnterUserName(Username)
		.EnterPassword(pwd)
		.clickLogginBtn();
		Assert.assertEquals(ele.getText().contains(assertMesage), true);
		return this;
	}
	
	
}
