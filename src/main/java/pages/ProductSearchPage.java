package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.BaseClass;




public class ProductSearchPage{


    private WebDriver driver;
	
	private String rating;
	private int highestRating=0;
	private String highestRatingString;
	private int currentRating;
	private BaseClass baseObject;

	@FindBy (xpath="//div[@data-id]//span[contains(text(),'(')]")
	List<WebElement> productRating;

	@FindBy(xpath="//div[@data-id]//div//a//div//div[2]//div//div//input")
	List<WebElement> addToCompare;

	
	ArrayList<WebElement> highestRatedProduct;


	public ProductSearchPage(WebDriver driver) {
		baseObject=new BaseClass(driver);
		this.driver=driver;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,100);
		PageFactory.initElements(factory, this);
		highestRatedProduct=new ArrayList<WebElement>();
	}

	/**
	 * function to print highest rated products
	 */
	public void getProducts() {
		getHighestCurrentRating();
		highestRatedProduct=(ArrayList<WebElement>) driver.findElements(By.xpath("//span[contains(text(),'"+highestRatingString+"')]"));
		for(WebElement highestRating:highestRatedProduct) {
			System.out.println(highestRating.findElement(By.xpath("./parent::div/preceding-sibling::a[1]")).getText());
			System.out.println(highestRating.findElement(By.xpath("./preceding-sibling::span")).getText());
			System.out.println(highestRatingString);
		}

	}

	//function to get the highest product rating 
	public void getHighestCurrentRating() {
		for(WebElement prod:productRating) {
			String currentratingString;
			rating=prod.getText();
			currentratingString= rating.replaceAll("\\p{P}","").replaceAll(",","");
			currentRating=Integer.parseInt(currentratingString);
			if(currentRating>highestRating) {
				highestRating=currentRating;
				highestRatingString=rating;
				
			}
		}
	}
}
