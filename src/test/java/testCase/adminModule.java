package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import commonKeywords.driverFile;
import commonKeywords.keywords;

public class adminModule {

	keywords key = new keywords();
	
	@Test
	public void addAdmin() throws InterruptedException {

		key.clickElement("//span[text()='Admin']");
		
		key.waitUntilElementIsVisible("//button[text()=' Add ']");
		key.clickElement("//button[text()=' Add ']");
		key.waitUntilElementIsVisible("//h6[text()='Add User']");
		
		key.inputText("//input[@placeholder='Type for hints...']", "lakshya");
		key.inputText("(//input[@class='oxd-input oxd-input--active'])[2]", "lakshya");
		
//		key.selectFromDropdownByText("(//div[@class='oxd-select-text-input'])[1]", "Admin");
//		key.selectFromDropdownByText("(//div[@class='oxd-select-text-input'])[2]", "Enabled");
		
		key.clickElement("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
		key.clickElement("(//div[@class='oxd-select-text-input'])[1]");
		
		key.clickElement("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
		key.clickElement("(//div[@class='oxd-select-text-input'])[1]");
		
		
		key.inputText("(//input[@type='password'])[1]", "Lakshya@1234");
		key.inputText("(//input[@type='password'])[2]", "Lakshya@1234");
		
		key.clickElement("//button[@type='submit']");
		
		Thread.sleep(10000);
		key.waitUntilElementIsVisible("(//div[@class='data' and text()='lakshya'])[1]");
		key.scrollElementIntoView("(//div[@class='data' and text()='lakshya'])[1]");
		
		int count = driverFile.driver.findElements(By.xpath("//div[@class='oxd-table-card --mobile']")).size();
		for (int i=0; i<=count; i++) {
			String empNameText = driverFile.driver.findElement(By.xpath("(//div[@class='card-item card-header-slot-content --left']/div/div/div[2])"+i)).getText();
			if (empNameText == "lakshya") {
				key.clickElement("//i[@class='oxd-icon bi-trash']"+ i);
			}
		}
		
		Thread.sleep(5000);

		
		
	}
}
