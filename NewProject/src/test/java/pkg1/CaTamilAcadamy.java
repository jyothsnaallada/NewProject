package pkg1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;



public class CaTamilAcadamy {
	WebDriver driver;
	String msg=null;
	Select combobox_value;
	String value="";
	//select getFirstselection;
	@Test
	public void loginMethod() throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\drivers\\edge\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.catamilacademy.org/cta/login.aspx");
		Thread.sleep(3000);

		By UserName=By.id("Txt_Mail_Id");
		By PassWord=By.id("Txt_Password");
		By Login=By.name("Btn_Login");
		By username1=By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[2]/td");
		By Joycelins=By.id("Txt_Uname");
		By useremail=By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[3]/td[1]");
		By Joyemail=By.id("Txt_Mailid");
		//By UserAlternateEmail=By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[4]/td[1]");
		By Gender=By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[5]/td[1]");
		By selectgender=By.id("Ddl_Gender");
		By Street=By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[6]/td[1]");
		By street1=By.id("Txt_Street");
		By City=By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[7]/td[1]");
		By city1=By.id("Txt_City");
		//By CountryState=By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[8]/td[1]");
		//By selectcountry=By.id("Ddl_State");
		By ZipPostalCode=By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[9]/td[1]");
		By zip1=By.id("Txt_Zip");
		By phone1=By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[10]/td[1]/p");
		By phonenum1=By.id("Txt_Phone");

		editBox_Util(UserName,"User Name", "main page", "joycelins@north.aztamilschools.org");
		editBox_Util(PassWord,"password","main page","Passw0rd.");
		button_menu_click(Login,"login", "main page");
		Thread.sleep(3000);

		Actions action=new Actions(driver);//mouse HOVER//
		//WebElement element =driver.findElement(By.xpath("(//span[contains(text(),'Profile')])[1]"));
		action.moveToElement(driver.findElement(By.xpath("(//span[contains(text(),'Profile')])[1]"))).perform();
		driver.findElement(By.xpath("(//span[contains(text(),'Modify My Profile')])[1]")).click();

		Thread.sleep(6000);

		driver.switchTo().frame(driver.findElement(By.id("contentFrame")));
		Thread.sleep(3000);
		Verify_GetText(username1, "User Name", "username1", "modify my profile page");
		Verify_GetAttributeValue(Joycelins, "Joycelins", "Joycelins", "modify my profile page");
		Verify_GetText(useremail, "User Email", "useremail","modify my profile page");
		Verify_GetAttributeValue(Joyemail, "JoycelinS@north.aztamilschools.org", "joyemail","modify my profile page" );
		//Verify_GetText(UserAlternateEmail, "User Alternate Email", "User Alternate Email", "modify my profile page");
		Verify_GetText(Gender, "Gender", "Gender","modify my profile page" );
		Verify_Dropdown(selectgender, "Female", "selectgender", "modify my profile page");
		Verify_GetText(Street, "Street", "Street", "modify my profile page");
		Verify_GetAttributeValue(street1, "1", "1", "modify my profile page");
		Verify_GetText(City, "City", "City", "modify my profile page");
		Verify_GetAttributeValue(city1, "1", "1", "modify my profile page");
		Verify_GetText(ZipPostalCode, "Zip/Postal Code", "ZipPostalCode", "modify my profile page");
		//Verify_GetText(CountryState, "Country & State", "CountryState","modify my profile page");
		Verify_GetAttributeValue(zip1, "1", "1", "modify my profile page");
		Verify_GetText(phone1, "Phone #1","phone1","modify my profile page");
		Verify_GetAttributeValue(phonenum1, "1", "1", "modify my profile page");		


	}
	public  String elementPresent(By locator, String locatorName, String pageName) {
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		//WebElement element =(WebElement) locator; 
		try {
			Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver)
					//new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class);
			//.ignoring(StaleElementReferenceException.class);
			//.until(ExpectedConditions.visibilityOfElementLocated(By.id("auth_user_name")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			// TODO Auto-generated catch block	
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			System.out.println("I have entered into catch block");
			//e.printStackTrace();
			msg = "Locator Name:-"+locatorName+" : "+locator+" is not identified in Page : "+pageName;

		}

		return msg;

	}


	/// edit box///
	public void editBox_Util(By locator, String locatorName, String pageName,String value) {
		System.out.println(driver);
		System.out.println(locator);
		msg=elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			locator.findElement(driver).sendKeys(Keys.chord(Keys.CONTROL,"a"),value);
			//locator.partialLinkText(value);
		}else {
			System.out.println(msg);
		}
	}

	public void button_menu_click(By locator,String locatorName,String pageName) {
		System.out.println(driver);
		System.out.println(locator);
		msg=elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			locator.findElement(driver).click();
		}else {
			System.out.println(msg);
		}
	}
	//SELECT//
	public void dropdown_select(By locator, String locatorName, String pageName, int value) throws InterruptedException {
		System.out.println(driver);
		System.out.println(locator);
		msg=elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			locator.findElement(driver).click();
			combobox_value=new Select(locator.findElement(driver));
			combobox_value.selectByIndex(value);		
		}else {
			System.out.println(msg);
		}
	}
	///get text//VERIFICATION//EDITBOX
	public void Verify_GetText(By locator, String expectedValue, String locatorName, String pageName ) {
		msg=elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			String actualValue=locator.findElement(driver).getText();
			System.out.println(actualValue);
			System.out.println(expectedValue);
			if(actualValue.equalsIgnoreCase(expectedValue)) {
				System.out.println("actualValue is same as excepted value");
			}else {
				System.out.println("actualValue is not same as excepted value");
			}
		}
	}
	///get value///
	public void Verify_GetAttributeValue(By locator, String expectedValue, String locatorName, String pageName ) {
		msg=elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			String actualValue=( locator.findElement(driver)).getAttribute("value");
			//System.out.println(userNameValue);
			System.out.println("ActualValue:"+actualValue);
			System.out.println("ExpectedValue:"+expectedValue);
			if(actualValue.equalsIgnoreCase(expectedValue)) {
				System.out.println("actualValue is same as excepted value");
			}else {
				System.out.println("actualValue is not same as excepted value");
			}		

		}



	}
//checking the dropdown//
	public void Verify_Dropdown(By locator,String expectedresult,String locatorName, String pageName ) {
		msg=elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			Select select=new Select(locator.findElement(driver));
			if(select.getFirstSelectedOption().getText().equalsIgnoreCase(expectedresult)) {
				System.out.println("dropdown value is selected: "+expectedresult );
			}else {
				System.out.println("dropdown value is notselected: "+expectedresult );
			}

		}
	

	}
}











