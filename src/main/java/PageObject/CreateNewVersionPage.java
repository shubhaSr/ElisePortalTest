package PageObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewVersionPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='app-textfieldVersion']")
	WebElement versionTextBoxElement;
	
	@FindBy(xpath="//textarea[@id='app-textarea-Description']")
	WebElement descriptionElement;
	
	@FindBy(xpath="//div[@class='v-input__control']/div[@role='button']")
	WebElement minimumVersionDropDownElement;
	
	@FindBy(className="v-select__selections")
	WebElement dropdownValue;
	
	@FindBy(xpath="//textarea[@id='app-textarea-Release notes']")
	WebElement ReleaseElement;
	
	@FindBy(xpath="//input[@id='input_upload'][1]")
	WebElement uploadFilElement;
	
	@FindBy(xpath="//*[contains(text(),' Save draft ')]")
	WebElement saveDraftButton;
	
	@FindBy(xpath="//div[@class='v-list-item__title' and text()='22.07 Elegant Europa']")
	WebElement selectvalue;
	
	
	public CreateNewVersionPage(WebDriver driver)
	{
		this.driver= driver;	
		PageFactory.initElements(driver, this);
	}
	
	
	public void  EnterVersion(String version)
	{
		versionTextBoxElement.sendKeys(version);
	}
	
	
	 public void enterDescription(String description) {
		 descriptionElement.sendKeys(description);
		
	}
	 
	 public void enterReleaseNotes(String releaseNotes) {
		 ReleaseElement.sendKeys(releaseNotes);
		
	}
	
	public void SelectDropDown(String minimunVersion)
	{
		minimumVersionDropDownElement.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(selectvalue));
		selectvalue.click();
	}
	
	public void uploadFile() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		uploadFilElement.sendKeys("C:\\Users\\sshree\\eclipse-workspace\\ElisePortalTest\\src\\main\\resources\\UploadFile\\codility.PNG");
		
	}
	public void clickdeaft() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(saveDraftButton));
		driver.getTitle();
		saveDraftButton.click();
		
	}

}
