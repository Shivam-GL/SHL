package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.BaseClass;

public class ComparePage{
	private WebDriver driver;
	private BaseClass baseObject;
	@FindBy(xpath="//span[contains(text(),'Add to Compare')]")
	List<WebElement> checkboxList;
	
	@FindBy(xpath="//*[text()=\"COMPARE\"]")
	WebElement compareBtn;
	
	@FindBy(xpath="//div[@class='row'][2]//div[contains(text(),'₹')][1]")
	List<WebElement> priceList;
	@FindBy(xpath="//div[@class='row'][1]//a")
	List<WebElement> products;

	public ComparePage(WebDriver driver) {
		baseObject=new BaseClass(driver);
		this.driver=driver;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,100);
		PageFactory.initElements(factory, this);
	}
	/*Method to add products to compare list
	 * Takes argument->number of items to compare 
	 * */

	public void addToCompare(int items) {
		for(int i=1;i<=items;i++) {
			baseObject.clickBtn(checkboxList.get(i));
		}
		baseObject.clickBtn(compareBtn);
	}
	/**
	 * method to print the product with minimum price
	 */
	public void getMinPrice() {
		int minproductPrice=0;
		WebElement minProduct = null;
		String priceString;
		int iterator=0;
		for(WebElement price:priceList) {
			priceString=price.getText().replaceAll("₹","").replaceAll(",","");
			if(minproductPrice==0||Integer.parseInt(priceString)<minproductPrice) {
				minproductPrice=Integer.parseInt(priceString);
				minProduct=products.get(iterator);
			}
			iterator++;
		}
		System.out.println(minProduct.getText()+"\n"+minproductPrice);
		
	}

}
