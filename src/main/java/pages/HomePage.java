package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;

public class HomePage extends BaseClass {

	private WebDriver driver;

	@FindBy(xpath = "//button[text()='✕']")
	WebElement modalClosebtn;

	@FindBy(xpath = "//input[@placeholder=\"Search for products, brands and more\"]")
	WebElement productSearchBox;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement searchBtn;

	@FindBy(xpath = "//*[text()=\"Electronics\"]")
	WebElement hoverTo;

	@FindBy(xpath = "//*[text()=\"Compact & Bridge Cameras\"]")
	WebElement clickTo;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToUrl(String Url) {
		driver.get(Url);

	}

	public void closeModal() {
		clickBtn(modalClosebtn);
	}

	public void searchProduct(String productName) {
		enterInput(productSearchBox, productName);
		clickBtn(searchBtn);

	}

	public void hoverActions() {
		hoverAndClick(hoverTo);
		clickBtn(clickTo);
	}

}
