package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;

public class Driver {
	
public static WebDriver driver;
	
	public static WebDriver getDriver() {
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = TestDataReader.getProperty("browser");
		}
		if (driver==null) {
			switch(browser) {
			case "chrome" :
				ChromeDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge" :
				EdgeDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				ChromeDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			
		}
		
		return driver;
	}
	
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}
