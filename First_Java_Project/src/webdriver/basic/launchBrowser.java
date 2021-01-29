package webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class launchBrowser {

	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//open the web app
		driver.navigate().to("https://amazon.in");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		if (title.equalsIgnoreCase("Amazon.in"))
			System.out.println("Title matched!");
		else
			System.out.println("Title mismatched. Browser title is: " + "'" + title + "'.");
		
		//locate web elements
		String tagname = null;
		//tagname = driver.findElement(By.id("searchDropdownBox")).getText();
		tagname = driver.findElement(By.xpath("//select[@id='searchDropdownBox']")).getText();
		System.out.println(tagname);
		
	
		//click Books link
		WebElement books = driver.findElement(By.xpath("//a[@class='nav-a  ' and text()='Books']"));
		Actions action = new Actions (driver);
		action.moveToElement(books);
		action.click();
		action.perform();
		Thread.sleep(2000);
		
		//type in Search Box
		//input[@id='twotabsearchtextbox']
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("John Grisham");
		searchBox.submit();
		Thread.sleep(2000);
	
		
		//Select the Book
		driver.findElement(By.partialLinkText("Guardians")).click();
		Thread.sleep(2000);
		
		
		//Shift to New Tab
		java.util.Set<String> handles = driver.getWindowHandles();
		String winHandle1 = driver.getWindowHandle(); //this code gets the present window handle
		handles.remove(winHandle1);
		
		String winHandle = handles.iterator().next();
		String winHandle2 = " ";
		if (winHandle!=winHandle1) //means if you have another Tab than the present tab
		{
			winHandle2=winHandle;
			driver.switchTo().window(winHandle2);
			System.out.println(winHandle2);
		}
		Thread.sleep(2000);
	
		
		driver.close();
		driver.quit();
	
	}
	
}