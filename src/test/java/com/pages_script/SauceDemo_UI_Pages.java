package com.pages_script;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverScript.Driver;
import com.utils.ReadPropertiesFile;

public class SauceDemo_UI_Pages extends Driver {
	public static final String filename = null;
	public ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
	public Properties prop = readPropertiesFile.readPropertiesFile(filename);
	
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"login-button\"]")
	WebElement login_button;

	@FindBy(xpath = "//*[@id=\"login-button\"]/../div[3]/h3")
	WebElement validation_msg;

	public SauceDemo_UI_Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_aEquilibriumUI() {
		driver.get(prop.getProperty("URL"));
	}

	public void click_login_button() {
		login_button.click();
	}

	public String get_validation() {
		String msg = validation_msg.getText();
		return msg;
	}
	
	public void userName_input() {
		username.sendKeys("Abhishek");
	}

	public boolean userName_Displayed() {
		return username.isDisplayed();
	}
	
	public boolean userName_Enabled() {
		return username.isEnabled();
	}
	
	public boolean password_Displayed() {
		return password.isDisplayed();
	}
	
	public boolean password_Enabled() {
		return password.isEnabled();
	}
	
	public boolean login_Displayed() {
		return login_button.isDisplayed();
	}
	
	public boolean login_Enabled() {
		return login_button.isEnabled();
	}
}
