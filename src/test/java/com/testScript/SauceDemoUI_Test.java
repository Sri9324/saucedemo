package com.testScript;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.driverScript.Driver;
import com.pages_script.SauceDemo_UI_Pages;
import com.utils.ReadPropertiesFile;

public class SauceDemoUI_Test extends Driver {

	public static final String filename = null;
	public ReadPropertiesFile readfile = new ReadPropertiesFile();
	public Properties prop = readfile.readPropertiesFile(filename);
	SauceDemo_UI_Pages aEquilibrium_page;

	@BeforeClass
	public void init() {
		aEquilibrium_page = new SauceDemo_UI_Pages(driver);
		Driver.init(prop.getProperty("Browser"));
		aEquilibrium_page.navigateTo_aEquilibriumUI();;
		System.out.println("Title is : " + Driver.driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".jpg"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test(priority = 1)
	public void userName_Field_Displayed() throws Throwable {
		aEquilibrium_page = new SauceDemo_UI_Pages(driver);
		boolean flag = aEquilibrium_page.userName_Displayed();
		Assert.assertEquals(true, flag);
	}
	
	@Test(priority = 2)
	public void userName_Field_Enabled() throws Throwable {
		aEquilibrium_page = new SauceDemo_UI_Pages(driver);
		boolean flag = aEquilibrium_page.password_Enabled();
		Assert.assertEquals(true, flag);
	}
	
	@Test(priority = 3)
	public void password_Field_Displayed() throws Throwable {
		aEquilibrium_page = new SauceDemo_UI_Pages(driver);
		boolean flag = aEquilibrium_page.password_Displayed();
		Assert.assertEquals(true, flag);
	}
	
	@Test(priority = 4)
	public void password_Field_Enabled() throws Throwable {
		aEquilibrium_page = new SauceDemo_UI_Pages(driver);
		boolean flag = aEquilibrium_page.userName_Enabled();
		Assert.assertEquals(true, flag);
	}
	
	@Test(priority = 5)
	public void login_Field_Displayed() throws Throwable {
		aEquilibrium_page = new SauceDemo_UI_Pages(driver);
		boolean flag = aEquilibrium_page.login_Displayed();
		Assert.assertEquals(true, flag);
	}
	
	@Test(priority = 6)
	public void login_Field_Enabled() throws Throwable {
		aEquilibrium_page = new SauceDemo_UI_Pages(driver);
		boolean flag = aEquilibrium_page.login_Enabled();
		Assert.assertEquals(true, flag);
	}
	
	@Test(priority = 7)
	public void no_input_Check_validation() throws Throwable {
		aEquilibrium_page = new SauceDemo_UI_Pages(driver);
		aEquilibrium_page.userName_input();
		aEquilibrium_page.click_login_button();
		String validation_message = aEquilibrium_page.get_validation();
		Assert.assertEquals("Epic sadface: Password is required", validation_message);
	}
	
	@AfterTest
	public void quit() {
		Driver.driver.quit();
	}
}