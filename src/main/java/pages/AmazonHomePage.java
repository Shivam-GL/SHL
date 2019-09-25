package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.BaseClass;
import utilities.Constants;
import utilities.WaitExpectedConditions;

public class AmazonHomePage{
	
	private WebDriver driver;
	private BaseClass baseObject;
	@FindBy(xpath="//input[@name=\"field-keywords\"]")
	WebElement searchBox;
	@FindBy(xpath="(//input[@type=\"submit\"])[1]")
	WebElement searchBtn;
	@FindBy(xpath="//span[text()=\"Smartphones\"]")
	WebElement category;
	@FindBy(xpath="//span[text()=\"Sort by:\"]")
	WebElement sortBy;
	@FindBy(xpath="//a[text()=\"Price: Low to High\"]")
	WebElement sortPrice;
	@FindBy(xpath="(//span[contains(text(),\"stars\")])[1]")
	WebElement star;
	@FindBy(xpath="//table[@id=\"histogramTable\"]//span[contains(text(),\"%\")]")
	List<WebElement>ratings;
	public AmazonHomePage(WebDriver driver) {
		baseObject=new BaseClass(driver);
		this.driver=driver;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,100);
		PageFactory.initElements(factory, this);
	}
	
	public void searchProduct(String productName) {
		baseObject.enterInput(searchBox,productName);
		baseObject.clickBtn(searchBtn);
	}
	
	public void selectCategory(){
		baseObject.clickBtn(category);
	}
	public void sortBy() {
		baseObject.clickBtn(sortBy);
		baseObject.clickBtn(sortPrice);
	}
	public void getstarvalue() {
		baseObject.hoverAndClick(star);
		int i=Constants.STARRATINGS;
		for(WebElement rating:ratings) {
			baseObject.waitCondition(WaitExpectedConditions.PRESENCE_OF_ELEMENT, rating, 5);
			System.out.println(i+" star rating: "+rating.getText());
			i--;
		}
		}
	
	public void goToUrl(String Url) {
		driver.get(Url);

	}
}
