package pkg1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeliniumDemo1 {
WebDriver driver;
	
	@Test

	public void loginMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Jyothsna Allada\\Eclipse Software - Setup\\chromedriver_win32 (16)\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("https://demo.eschool360.in/index.php");
	 driver.findElement(By.id("auth_user_name")).sendKeys("admin");
	 driver.findElement(By.id("auth_password")).sendKeys("admin");
	 driver.findElement(By.id("auth_school")).sendKeys("1");
	 driver.findElement(By.name("Login")).click();
	 driver.manage().window().maximize();
	 Thread.sleep(3000); // wait time page loading//synchronization
	 // setup
	 driver.findElement(By.xpath("//span[contains(text(),'SETUP')]")).click();
	 driver.findElement(By.xpath("//a[contains(text(),'Class Section Subjects')]")).click();
	 Thread.sleep(3000);
	 driver.switchTo().frame(1);//class is under the frame
	 
	 //dropdown//
	 WebElement class_subjects=driver.findElement(By.xpath("//select[contains(@id,'cmb_classname')]"));
	 class_subjects.click();
	 Select sel_class_subjects=new Select(class_subjects);
	 sel_class_subjects.selectByIndex(4);
	 driver.switchTo().defaultContent();//need to comeback to desitination
	 driver.findElement(By.xpath("//a[contains(text(),'Subject Master')]")).click();
	 
		
	}

}



