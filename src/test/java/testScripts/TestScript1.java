package testScripts;


import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.ProductSearchPage;
import utilities.Constants;
import utilities.Launch;

import utilities.ProductDetails;

public class TestScript1 extends Launch{

	WebDriver driver;
	HomePage homepage;
	
	ProductSearchPage productsearchpage;
	ArrayList<ProductDetails> details;

	@BeforeMethod
	public void initBrowser() {
		//managing driver
		driver=getWebDriver();
		driver.get(Constants.URL);
		driver.manage().window().maximize();
		// initializing page objects
		homepage=new HomePage(driver);
		productsearchpage=new ProductSearchPage(driver);
		// creating product details list
		details=new ArrayList<ProductDetails>();
	}

	@Test
	public void test1() {
		homepage.closeModal();
		homepage.searchProduct("earphones");
		
		details = productsearchpage.getProducts();
		
		for(ProductDetails prodDetail:details) {
			System.out.println(prodDetail.getPrdoname()+"\n"+prodDetail.getStar()+"\n"+prodDetail.getRatings());
		}
	}
}
