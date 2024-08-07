package commonKeywords;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class driverFile {
	public static WebDriver driver;
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	public static Actions action;
}
