package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.Constants;
import utilities.Launch;

public class Testscript4 extends Launch{
	private WebDriver driver;
	private AmazonHomePage homepage;

	@Test
	public void test1() {
		homepage=new AmazonHomePage(getWebDriver());
		homepage.goToUrl(Constants.URL2);
		homepage.searchProduct("mobile");
		homepage.selectCategory();
		homepage.sortBy();
		homepage.getstarvalue();
	}
}
