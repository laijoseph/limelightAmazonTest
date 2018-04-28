package tests.amazonTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultsPage;
import selenium.DriverSetup;


public class AmazonTest {

	@BeforeClass(alwaysRun = true)
	public void setupClass()
	{
	
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setupTest()
	{

	}

	@Parameters()
	@Test(description = "Test Description")
	public void groupSetup() throws Exception{
		WebDriver driver = DriverSetup.setupDriver(DriverSetup.Browser.Chrome, "chromedriver 3");
		driver.get("https://www.amazon.com");
		HomePage.searchBar(driver).sendKeys("ipad air 2 case");
		HomePage.searchBar(driver).sendKeys(Keys.RETURN);
		SearchResultsPage.plasticFilter(driver).click();
		Thread.sleep(3000);
		SearchResultsPage.setMinimumPrice(driver).sendKeys("20");
		SearchResultsPage.setMaximumPrice(driver).sendKeys("100");
		SearchResultsPage.setMaximumPrice(driver).sendKeys(Keys.RETURN);
//		driver.close();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDownTest()
	{
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass()
	{

	}
	
	void scrollIntoView(WebDriver driver, WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500); 
	}
}
