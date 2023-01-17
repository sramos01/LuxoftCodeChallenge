package main;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetUp {
	@FindBy(css = "mainHeader")
	WebElement header;
	public WebDriver setUp() {
		//Chrome
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\DANY_\\Downloads\\chromedriver_win321\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-blink-features=AutomationControlled");
		//WebDriver driver = new ChromeDriver(options);
		//Firefox
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\DANY_\\Downloads\\geckodriver-v0.32.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.volaris.com/");
		return driver;
	}
}
