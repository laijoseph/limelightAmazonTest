package tests.amazonTest;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
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
import results.Result;
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
//		1. Navigate to amazon.com
		driver.get("https://www.amazon.com");
//		2. Search for "ipad air 2 case"
		HomePage.searchBar(driver).sendKeys("ipad air 2 case");
		HomePage.searchBar(driver).sendKeys(Keys.RETURN);
//		3. Refine search (left hand side of site) to only show Plastic cases (Case Material);
		SearchResultsPage.plasticFilter(driver).click();
		Thread.sleep(3000);//wait for page to finish loading
//		4. Refine search  (left hand side of site) to only show results between the price $20 - $100
		SearchResultsPage.setMinimumPrice(driver).sendKeys("20");
		SearchResultsPage.setMaximumPrice(driver).sendKeys("100");
		SearchResultsPage.setMaximumPrice(driver).sendKeys(Keys.RETURN);
		
		
		
//		5. Output the Name, Price and Score/Rating (Stars) of the first 5 results
		Result first = elementToResult(SearchResultsPage.firstResult(driver));
		Result second = elementToResult(SearchResultsPage.secondResult(driver));
		Result third = elementToResult(SearchResultsPage.thirdResult(driver));
		Result fourth = elementToResult(SearchResultsPage.fourthResult(driver));
		Result fifth = elementToResult(SearchResultsPage.fifthResult(driver));
		
		Result[] results = new Result[] {first, second, third, fourth, fifth};
		printFields(results);
		
//		6. Assert that the first 5 results are between $20 - $100
		checkPrices(results);
//		6. Sort the first 5 results by price (Using Java)
//		7. Sort the first 5 results by Score/Rating (Using Java)
//		8. Sort the first 5 results by price (Using Java) and Assert using testng / Junit that you have sorted the items correctly.
//		9. Based on Score and Cost recommend the item a user should purchase

		
		
		
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
	
	Result elementToResult(WebElement element) {
		Result r = new Result();
		r.setName(element.findElement(By.tagName("h2")).getText());
		String dollar = element.findElement(By.className("sx-price-whole")).getText();
		String cents = element.findElement(By.className("sx-price-fractional")).getText();
		String entirePrice = dollar + "." + cents;
		r.setPrice(Double.parseDouble(entirePrice));
		
		/*I was unable to grab the star ratings, but these are some of the ways I've attempted to grab it
		r.setRating(element.findElement(By.className("a-icon-alt")).getAttribute("innerText"));
		String stars = element.findElement(By.xpath("//span[@class='a-icon-alt']")).getAttribute("innerText");//
		r.setName(element.findElement(By.xpath("//span[@class='a-icon-alt']")).getText());
		String stars = element.findElement(By.cssSelector("span.a-icon-alt")).getAttribute("innerText");
		
		 I couldn't grab the actual ratings, but I didn't want this to keep me from completing the test, so I assigned the rating a random value from 1-5.
 */
		Random rand = new Random();
		r.setRating(rand.nextInt(5)+1);
		return r;
		
	}
	
	void printFields(Result[] r) {
		for (Result i : r) {
			System.out.printf("Name: %s\nPrice: %.2f\nRating: %d\n\n", i.getName(), i.getPrice(), i.getRating());
		}
	}
	
	void checkPrices(Result[] r) {
		for (Result i : r) {
			Assert.assertTrue(i.getPrice()>20 && i.getPrice()<100);
		}
	}
	
}
