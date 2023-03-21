package pkg1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class HardAssertion {




//test = extent.createTest("functionality1Test1");
WebDriver driver;	
	@Test

	public void loginMethod() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
		
		// driver = new ChromeDriver();
		 
			System.setProperty("webdriver.edge.driver", "C:\\drivers\\edge\\edgedriver_win64\\msedgedriver.exe");
			
			 driver = new EdgeDriver();
			 driver.get("https://demo.eschool360.in/index.php");
			 
	 
	System.out.println(driver.getTitle());
	String ActualTittle=driver.getTitle();
	String verifyAssertNull=null;
	String ExpectedTitle = "School";
	Boolean verifyTitleIsPresent=driver.getTitle().equalsIgnoreCase("School");
	Boolean verifyTitleIsChanged=driver.getTitle().equalsIgnoreCase("next");
     assertEquals(ActualTittle,ExpectedTitle);
	assertNotEquals(ExpectedTitle, "school");
	assertTrue(verifyTitleIsPresent);
	assertFalse(verifyTitleIsChanged);
	assertNotNull(verifyTitleIsPresent);
	assertNull(verifyAssertNull);

	
	
	
	
}

	}

	
