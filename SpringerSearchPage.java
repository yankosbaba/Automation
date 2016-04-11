package springerpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;

public class SpringerSearchPage {
	
	WebDriver driver; 
	
	
	@Before
	public void setUp() throws InterruptedException{
		
		
		driver = new FirefoxDriver(); 
		driver.get("http://link.springer.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	
	public void testSearchEngine() throws InterruptedException{
		
		
		driver.findElement(By.xpath("//*[@id='query']")).sendKeys("Swiss Journal of Palaeontology");
		driver.findElement(By.xpath("//*[@id='search']")).click();
		Thread.sleep(3000);
	}
	
	public boolean assetURL(){
		
		
		return (driver.getCurrentUrl()).contains("http://link.springer.com/");
		
	}
	
	public boolean checkSearchResult(){
		
		
		WebElement searchResultTxt = driver.findElement(By.xpath("//*[@id='results-list']/li[1]/div[2]/h2/a"));
		String searchTxt = searchResultTxt.getText(); 
		boolean searchResultText = searchTxt.equals("wiss Journal of Palaeontology");
		System.out.println("Show me text : " +searchTxt);
		
		
		return searchResultText;
	}
	
	
	
	public void testNegativeSearch() throws InterruptedException{
		
		
		driver.findElement(By.xpath("//*[@id='query']")).sendKeys("sadsdsdsdads");
		driver.findElement(By.xpath("//*[@id='search']")).click();
		Thread.sleep(3000);
	}
	
	public void testNegativeAssert(){
		
		
		WebElement searchResultTxt = driver.findElement(By.xpath("//*[@id='no-results-message']/h2"));
		String searchTxt = searchResultTxt.getText(); 
		boolean searchResultText = searchTxt.equals("Sorry – we couldn’t find what you are looking for. Why not...");
		Assert.assertTrue(searchResultText);
		
	}
	
	
	@After
	public void shutDown(){
		
		driver.close();
		
	}

}
