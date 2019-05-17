package actual_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GoogleSearchPageObjects;

public class TestNGDemo2 {
	WebDriver chromeDriver = null ;

	@BeforeTest
	public void setUpTest() {
		System.out.println("Before Test");
		chromeDriver = new ChromeDriver();
	}
	
	@Test
	public void googleSearchTest2() {
		// Go to google page
		System.out.println("Main Test1");
		chromeDriver.get("https://www.google.com/");
		chromeDriver.manage().window().maximize();
		
		GoogleSearchPageObjects gs = new GoogleSearchPageObjects(chromeDriver) ;
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
	
	@Test
	public void googleSearchTest3() {
		// Go to google page
		System.out.println("Main Test");
		chromeDriver.get("https://www.google.com/");
		chromeDriver.manage().window().maximize();
		
		GoogleSearchPageObjects gs = new GoogleSearchPageObjects(chromeDriver) ;
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
		System.out.println("After Test");
		chromeDriver.close();
	}
}
