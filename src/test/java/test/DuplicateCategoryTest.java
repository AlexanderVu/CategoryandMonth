package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AddCategoryPage;
import util.BrowserFactory;

public class DuplicateCategoryTest {
	
	//Test 2: Validate a user is not able to add a duplicated category. If it does then the following message will display: 
	//"The category you want to add already exists: <duplicated category name>."
	
	WebDriver driver;
	AddCategoryPage addcategorypage;
	
	@BeforeMethod
	public void navigatetoURL() {
		driver = BrowserFactory.initBrowser();
		addcategorypage = PageFactory.initElements(driver, AddCategoryPage.class);
	}
	@Test
	public void DuplicatedMessageTest() {
		addcategorypage.addCategory("Alexander1");
		addcategorypage.DuplicateMessage();
		
	}
	@AfterMethod
	public void teardown() {
		BrowserFactory.teardown();
		
	}

}
