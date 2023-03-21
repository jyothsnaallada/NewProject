package pkg1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	WebDriver driver;
	String msg;
	SoftAssert softassert=new SoftAssert();
		
		@Test

		public void loginMethod() throws InterruptedException {
			//System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
			
			// driver = new ChromeDriver();
			 
				System.setProperty("webdriver.edge.driver", "C:\\drivers\\edge\\edgedriver_win64\\msedgedriver.exe");
				
				 driver = new EdgeDriver();
				 driver.get("https://demo.eschool360.in/index.php");
				 
		 
		System.out.println(driver.getTitle());
		String ActualTittle=driver.getTitle();
		

}
}