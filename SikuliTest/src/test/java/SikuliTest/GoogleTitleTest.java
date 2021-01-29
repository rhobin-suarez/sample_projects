package SikuliTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTitleTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSukuliWDM_DynamicVersion() throws FindFailed {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
		Screen screen = new Screen();
		Pattern IFL = new Pattern(".\\src\\test\\resources\\images\\IFL.png");
		screen.wait(IFL,2000);
		screen.click();
		Pattern Doodles = new Pattern(".\\src\\test\\resources\\images\\Doodles.png");
		screen.wait(Doodles,2000);
		screen.click();
		
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSukuliWDM_DefinedVersion() throws FindFailed {
		WebDriverManager.chromedriver().driverVersion("2.34").setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
		Screen screen = new Screen();
		Pattern IFL = new Pattern(".\\src\\test\\resources\\images\\IFL.png");
		screen.wait(IFL,2000);
		screen.click();
		Pattern Doodles = new Pattern(".\\src\\test\\resources\\images\\Doodles.png");
		screen.wait(Doodles,2000);
		screen.click();
		
		driver.quit();
	}

}
