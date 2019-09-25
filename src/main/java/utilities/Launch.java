package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Launch {
	
	private WebDriver driver;
	private String browserName;
	
	@BeforeMethod
	public  void initWebDriver(){
		//if browser-name is not read from excel get it from constants file
		browserName=(browserName==null)?Constants.BROWSER:browserName;
		
		switch(browserName) {
		case "Chrome": WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;

		case "Firefox": WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;

		case "InternetExplorer": WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		break;
		
		}
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}

	public WebDriver getWebDriver() {
		return driver;
	}
	
	public void setBrowserName(String browser) {
		browserName=browser;
	}
}
