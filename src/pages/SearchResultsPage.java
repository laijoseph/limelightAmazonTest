package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
	private static WebElement element = null;
	
	public static WebElement plasticFilter(WebDriver driver) {	
		element = driver.findElement(By.xpath("//span[text()='Plastic']"));
		return element;
	}
	
	public static WebElement setMinimumPrice(WebDriver driver) {	
//		element = driver.findElement(By.id("low-price"));
		element = driver.findElement(By.name("low-price"));
		return element;
	}
	
	public static WebElement setMaximumPrice(WebDriver driver) {	
		element = driver.findElement(By.name("high-price"));
		return element;
	}
}
