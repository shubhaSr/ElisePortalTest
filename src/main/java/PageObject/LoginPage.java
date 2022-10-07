package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	
	
	@FindBy(id="email")
	WebElement userElement;
	
	@FindBy(id="password")
	WebElement passwordElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButtonElement;
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginElise(String email,String password)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		userElement.sendKeys(email);
		passwordElement.sendKeys(password);
		loginButtonElement.click();
		
	}
	
	
}
