package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCategoryPage {

	WebDriver driver;

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "categorydata")
	WebElement Category_Field;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement AddCategory_Button;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'The category you want to add already exists')]")
	WebElement Duplicate_Display_Element;
	@FindBy(how = How.NAME, using = "due_month")
	WebElement DropdownElement;

	String beforeXpath = "//span[contains(text() , '";
	String afterXpath = "')]";
	String Category;

	public void addCategory(String cat_name) {

		Category = cat_name;
		Category_Field.sendKeys(Category);
		AddCategory_Button.click();

		WebElement abc = driver.findElement(By.xpath(beforeXpath + Category + afterXpath));
		String a = abc.getAttribute("textContent");

		Assert.assertEquals(a, Category);

	}

	public void DuplicateMessage() {

		if (Duplicate_Display_Element.isDisplayed()) {
			System.out.println("The category you want to add already exists: " + Category);
		} else {
			System.out.println("Category Created");
		}

	}

//	public void getMonthList() {
//		Select sel = new Select(DropdownElement);
//		List<WebElement> dd_Month = sel.getOptions();
//		int i = 1;
//		for (WebElement ele : dd_Month) {
//			System.out.println(i + "." + ele.getText());
//			i++;
//		}
//	}

	public void validateMonth() {
		String expectedMonth[] = { "None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		Select sel = new Select(DropdownElement);
		List<WebElement> dd_Month = sel.getOptions();
		for (int i = 0; i < dd_Month.size(); i++) {
			System.out.println(dd_Month.get(i).getText() + "-->" + expectedMonth[i]);
			Assert.assertEquals(dd_Month.get(i).getText(), expectedMonth[i]);

		}
	}
}
