package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AddCategoryPage;
import util.BrowserFactory;

public class ValidateMonthTest {
	
	WebDriver driver;
	AddCategoryPage addcategorypage;
	@BeforeMethod
	public void navigatetoUrl() {
		driver = BrowserFactory.initBrowser();
		addcategorypage = PageFactory.initElements(driver, AddCategoryPage.class);
	}
	@Test
	public void getMonthList() {
		addcategorypage.validateMonth();
	}
	
	@AfterMethod
	public void teardown() {
		BrowserFactory.teardown();
	}
	
	
}
