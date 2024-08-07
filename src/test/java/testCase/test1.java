package testCase;

import java.io.IOException;
import java.time.Duration;


import commonKeywords.driverFile;
import commonKeywords.keywords;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class test1 {

	public keywords key = new keywords();
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driverFile.driver = new ChromeDriver();
        driverFile.wait = new WebDriverWait(driverFile.driver, Duration.ofSeconds(30));
		driverFile.driver.manage().window().maximize();
		driverFile.driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test (priority=1)
	@Parameters ({"username", "password"})
	public void logIn(String username, String password) throws InterruptedException, IOException {
		
		key.inputText("//input[@name='username']", username);
		key.inputText("//input[@name='password']", password);
		key.clickElement("//button[@type='submit']");
		key.capturePageScreenshot();
		Thread.sleep(2000);
		
	}
	
	@Test (priority=2)
	public void menuItemsHamburger() {
		key.elementShouldBeVisible("//span[text()='Admin']");
	}
	
	@AfterTest
	public void testDown() {
		driverFile.driver.quit();
	}
}
