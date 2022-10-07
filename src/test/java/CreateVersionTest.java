import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateVersionTest {
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://portal.elise.de/");
		this.login("ssss", "sss");

	}
	
	public void login(String userName,String password)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		
		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys(userName);
		
		WebElement passwordElement=driver.findElement(By.id("password"));
		passwordElement.sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
	}
	
	@Test
	public Void version()
	{	
		return null;

		
	}
	
	@AfterTest
	public void terminateBrowser()
	{
		driver.quit();
	}
	
	

}
