package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	private static WebElement element = null ;

	public static WebElement textboxSearch(WebDriver driver) {
		element = driver.findElement(By.name("q")) ;
		return element ;
	}
	
	public static WebElement clickSearchBoxButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(@class, 'FP')]//input[@value='Google Search']")) ;
		return element ;
	}
}
