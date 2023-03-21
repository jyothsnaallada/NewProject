package pkg1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
WebDriver driver;
	
	@Test

	public void loginMethod() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\Jyothsna Allada\Eclipse Software - Setup\chromedriver_win32(16)\\chromedriver.exe");
		
		// driver = new ChromeDriver();
		 
			System.setProperty("webdriver.edge.driver", "C:\\drivers\\edge\\edgedriver_win64\\msedgedriver.exe");
			
			 driver = new EdgeDriver();
			 
	 driver.get("https://demo.eschool360.in/index.php");
	 Thread.sleep(3000);
	 driver.manage().window().maximize();

	 driver.findElement(By.id("auth_user_name")).sendKeys("admin");
	 driver.findElement(By.id("auth_password")).sendKeys("admin");
	 driver.findElement(By.id("auth_school")).sendKeys("1");
	 driver.findElement(By.name("Login")).click();
	 Thread.sleep(3000);

	 driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
	 driver.findElement(By.xpath("//a[contains(text(),'Marks Entries')] ")).click();
	 //driver.switchTo().frame("1");
	 //driver.switchTo().frame("main");
	 driver.switchTo().frame(driver.findElement(By.id("main")));


	 //CLASS NAME
	 WebElement classname = driver.findElement(By.xpath("//select[contains(@id,'class_name')]"));
	 classname.click();
	 //driver.findElement(By.xpath("//select[contains(@name,'class_name')]")).click();
	 //Select sel = new Select(classname);
	 Select sel = new Select(classname);
	 sel.selectByIndex(3);
	 Thread.sleep(500);

	 // SECTION SELECT
	 WebElement sectionname = driver.findElement(By.xpath("//select[contains(@id,'section_id')]"));
	 sectionname.click();
	 sel = new Select(sectionname);
	 sel.selectByIndex(1);
	 Thread.sleep(500);

	 //EXAM MAIN TYPE
	 WebElement exammaintype = driver.findElement(By.id("exam_main_type_id_for_exam_name_combo"));
	 exammaintype.click();
	 sel = new Select(exammaintype);
	 sel.selectByIndex(1);
	 Thread.sleep(500);

	 //EXAM TYPE
	 WebElement examtype= driver.findElement(By.id("exam_type_id_for_exam_type_combo"));
	 examtype.click();
	 sel = new Select(examtype);
	 sel.selectByIndex(1);
	 Thread.sleep(500);
	 //driver.getCurrentUrl();
	 System.out.println(driver.getCurrentUrl());
	 System.out.println(driver.getTitle());

	 JavascriptExecutor jse = (JavascriptExecutor)driver; // casting the driver into javaScript executor

	 String existing_marks = "65/9/88/80/100/56";
	 String[] indv_marks = existing_marks.split("/");


	 //Adding values into textboxes
	 WebElement student_marks_element ;
	 for(int student = 20;student <= 23;student ++) {
	 int marks_iter = 0;
	 for(int marks = 2; marks <= 7; marks++) {
	 student_marks_element = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
	 //student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"95");
	 jse.executeScript("arguments[0].value= '"+indv_marks[marks_iter]+"';",student_marks_element );
	 marks_iter = marks_iter+1;
	 // jse.executeScript("arguments[0].value= '"+existing_marks+"';",student_marks_element );
	 }
	 }
	 WebElement save = driver.findElement(By.xpath("//input[contains(@id,'mode')]"));
	 jse.executeScript("arguments[0].click()", save);
	 Thread.sleep(2000);

	 Alert alert =driver.switchTo().alert();
	 alert.accept();
	 Thread.sleep(2000);

	 }

	 


	}
