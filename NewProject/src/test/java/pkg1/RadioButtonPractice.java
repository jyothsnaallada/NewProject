package pkg1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class RadioButtonPractice {
	
WebDriver driver;
	
	@Test

	public void loginMethod() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\Jyothsna Allada\Eclipse Software - Setup\chromedriver_win32(16)\\chromedriver.exe");
		// driver = new ChromeDriver();
			System.setProperty("webdriver.edge.driver", "C:\\drivers\\edge\\edgedriver_win64\\msedgedriver.exe");
			 driver = new EdgeDriver();
			 driver.get("https://courses.letskodeit.com/practice");
	}		 

}
