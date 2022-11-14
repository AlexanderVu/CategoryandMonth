package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AddCategoryPage;
import util.BrowserFactory;

public class AddCategoryTest {
	
	//Test 1: Validate a user is able to add a category and once the category is added it should display.
	
	WebDriver driver;
	AddCategoryPage addcategorypage;
	@BeforeMethod
	public void navigatetoURL() {
		driver = BrowserFactory.initBrowser();
		addcategorypage = PageFactory.initElements(driver, AddCategoryPage.class);
	}
	@Test
	public void add_CategoryTest() {
		addcategorypage.addCategory("Alexander1");
		
	}

	@AfterMethod
	public void teardown() {
		BrowserFactory.teardown();
	}
}
