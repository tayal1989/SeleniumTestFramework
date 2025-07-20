package actual_test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver chromeDriver = null ;

	public static void main(String[] args) {
		searchGoogleEngine();
	}

	public static void searchGoogleEngine(){
		WebDriverManager.chromedriver().setup();
		chromeDriver = new ChromeDriver();
		
		chromeDriver.get("https://www.google.com/");
		System.out.println("It will open google website");
		
		chromeDriver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		
			// Enter text in search box
			GoogleSearchPage.textboxSearch(chromeDriver).sendKeys("Automation Step By Step");
			System.out.println("Enters Automation step by step in search box");
			
			//Click on Search Box
			GoogleSearchPage.clickSearchBoxButton(chromeDriver).sendKeys(Keys.RETURN);
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			chromeDriver.quit();
		}	
		
	}
}
