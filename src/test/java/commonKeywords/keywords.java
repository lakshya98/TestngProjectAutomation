package commonKeywords;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.io.Files;


public class keywords {
	
	public void clickElement(String locator) {
		driverFile.driver.findElement(By.xpath(locator)).click();
	}
	
	public void inputText(String locator, String text) {
		driverFile.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		driverFile.driver.findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public void capturePageScreenshot() throws IOException {
		Date currentDate = new Date();
		String Screenshots = currentDate.toString().replace(" ", "-").replace(":","-" );
		File SS = ((TakesScreenshot) driverFile.driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SS, new File(".\\Screenshots\\"+Screenshots+"test.png"));
	}
	
	public void elementShouldBeVisible(String locator) {
		Boolean Ispresent = driverFile.driver.findElement(By.xpath(locator)).isDisplayed();
		Assert.assertTrue(Ispresent);
	}
	
	public void waitUntilElementIsVisible(String locator) {
		driverFile.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
	public void selectFromDropdownByText(String locator , String text) {
		Select select = new Select(driverFile.driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(text);
	}

	public void scrollElementIntoView(String locator) {
		WebElement element = driverFile.driver.findElement(By.xpath(locator));
		driverFile.action.scrollToElement(element);
		
	}
}
