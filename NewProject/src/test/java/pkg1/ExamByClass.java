package pkg1;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;


public class ExamByClass {
WebDriver driver;
	
	@Test

	public void loginMethod() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\Jyothsna Allada\Eclipse Software - Setup\chromedriver_win32(16)\\chromedriver.exe");
		
		// driver = new ChromeDriver();
		 
			System.setProperty("webdriver.edge.driver", "C:\\drivers\\edge\\edgedriver_win64\\msedgedriver.exe");
			
			 driver = new EdgeDriver();
			 
	 driver.get("https://demo.eschool360.in/index.php");
	
	 org.openqa.selenium.By userName=By.id("auth_user_name");
	 By passWord=By.id("auth_password");
	 By schoolId=By.id("auth_school");
	 By loginButton=By.name("Login");
	 ///exam////
	 By examButton=By.xpath("//span[contains(text(),'EXAMS')]");
	 //mark entries
	 By markEntriesButton=By.xpath("//a[contains(text(),'Marks Entries')]");
	 
	 ///dropdowns///
	 By classNameDropDown=By.id("class_name");
	 By section_id=By.id("section_id");
	 By exam_name=By.id("exam_main_type_id_for_exam_name_combo");
	 By exam_type=By.id("exam_type_id_for_exam_type_combo");
	 ///Exam Main Type Master//
	 By exam_main_type_master=By.xpath("//a[contains(text(),'Exam Main Type Master')]");
	 ///fees//
	 By fees=By.xpath("//span[contains(text(),'FEES')]");
	 By feesDetails=By.xpath("//a[contains(text(),'Fee Details')]");
	 
	 
	  userName.findElement(driver).sendKeys("admin");
	 passWord.findElement(driver).sendKeys("admin");
	 schoolId.findElement(driver).sendKeys("1");
	 loginButton.findElement(driver).click();
	 driver.manage().window().maximize();
      Thread.sleep(3000);
	 
	 examButton.findElement(driver).click();
	 markEntriesButton.findElement(driver).click();
	 Thread.sleep(3000);
	 driver.switchTo().frame(1);
	 
	 Select combobox_Exam;//common  for dpdn 
	
	 classNameDropDown.findElement(driver).click();
	 combobox_Exam=new Select(classNameDropDown.findElement(driver));
	 combobox_Exam.selectByIndex(3);
	 
	 section_id.findElement(driver).click();
	 combobox_Exam=new Select(section_id.findElement(driver));
	 combobox_Exam.selectByVisibleText("Section A");
	 
	
	 exam_name.findElement(driver).click();
	 combobox_Exam=new Select(exam_name.findElement(driver));
	 combobox_Exam.selectByIndex(1);
	 
	 
	 exam_type.findElement(driver).click();
	 combobox_Exam=new Select(exam_type.findElement(driver));
	 combobox_Exam.selectByIndex(1);
	 
	 // changing the marks markenties
	 WebElement student_marks_element ;
	 for(int student = 1;student <= 5;student ++) {
	 for(int marks = 2; marks <= 7; marks++) {
	 student_marks_element = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
	 //student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"95");
	 //student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"95");
	 student_marks_element.clear();
	 student_marks_element.sendKeys("56");
	 }
	 }
	  
	  
	 driver.switchTo().defaultContent();
	 exam_main_type_master.findElement(driver).click();
	 Thread.sleep(3000);
	 /// FEES///
	fees.findElement(driver).click();
	feesDetails.findElement(driver).click();
	 
	 driver.switchTo().defaultContent();
	 
	}
}





