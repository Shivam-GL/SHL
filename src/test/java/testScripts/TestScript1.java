package testScripts;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductSearchPage;
import utilities.Constants;
import utilities.Launch;

public class TestScript1 extends Launch {

	private HomePage homepage;
	private ProductSearchPage productsearchpage;

	@Test
	public void test1(ITestContext context) {
		homepage = new HomePage(getWebDriver());
		context.setAttribute("webDriver",getWebDriver());
		homepage.goToUrl(Constants.URL);
		homepage.closeModal();
		homepage.searchProduct("earphones");
		productsearchpage = new ProductSearchPage(getWebDriver());
		productsearchpage.getProducts();
		Assert.fail();
	}
}