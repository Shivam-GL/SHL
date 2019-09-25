package testScripts;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;

import utilities.Constants;
import utilities.Launch;


public class TestScript2 extends Launch{
	
	HomePage homepage;
	ComparePage comparePage;
	
	@Test
	public void test1() {
		homepage=new HomePage(getWebDriver());
		homepage.goToUrl(Constants.URL);
		homepage.closeModal();
		homepage.hoverActions();
		comparePage=new ComparePage(getWebDriver());
		comparePage.addToCompare(3);
		comparePage.getMinPrice();
	}
}
