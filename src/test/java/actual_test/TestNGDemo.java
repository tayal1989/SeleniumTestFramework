package actual_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import config.PropertiesFile;
import pages.GoogleSearchPageObjects;
import src.Log4jDemo;

public class TestNGDemo {
	WebDriver driver = null ;
	public static String browserName = null ;
	private static Logger logger = LogManager.getLogger(Log4jDemo.class) ;

	@BeforeTest
	public void setUpTest() {
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		logger.info("Browser Started");
	}
	
	@Test
	public void googleSearchTest() {
		// Go to google page
		driver.get("https://www.google.com/");
		logger.info("Navigating to google.com");
		driver.manage().window().maximize();
		
		GoogleSearchPageObjects gs = new GoogleSearchPageObjects(driver) ;
		try {
			Thread.sleep(3000);
		
			// Enter text in search box			
			gs.setTextInSearchBox("Automation Step By Step");
			
			//Click on Search Box
			gs.clickSearchButton();
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.quit();
		PropertiesFile.setProperties();
	}
}
