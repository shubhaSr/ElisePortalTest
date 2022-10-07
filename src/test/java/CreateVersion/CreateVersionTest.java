package CreateVersion;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.CreateNewVersionPage;
import PageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateVersionTest {
	WebDriver driver;	
	
	@DataProvider(name="CreateVersion")
	public Object[][] data(){
		return new Object[][] {
			{"version1","newverion with fix of bug", "release note 1", "22.07 Elegant Europa"},
			{"version2","newverion with fix of bug", "release note 2", "21.10 Blazing Bennu"},
		};		
	} 


	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://portal-staging.elise.de/marketplace/my-add-ins/34fd593b-98fb-4994-a51e-f0fea8494c98/create");
		LoginPage login= new LoginPage(driver);
		login.loginElise("qa.applicant@elise.de", "kIJR3WSDPUb$PscE");
		
	}
	

	@Test(dataProvider = "createVersion")
	public void createVersion(String version, String description, String releasNoteString, String minimumVersion)
	{	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		CreateNewVersionPage createNewVersionPage= new CreateNewVersionPage(driver);
		createNewVersionPage.SelectDropDown(minimumVersion);
		createNewVersionPage.EnterVersion(version);
		createNewVersionPage.enterDescription(description);
		createNewVersionPage.enterReleaseNotes(releasNoteString);
		createNewVersionPage.SelectDropDown(minimumVersion);
		
		createNewVersionPage.uploadFile();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		createNewVersionPage.clickdeaft();
	}
	
	@AfterTest
	public void terminateBrowser()
	{
		driver.quit();
	}
}
