package test;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;


public class TestClass {
	WebDriver driver; 
	HomePage objHomePage;
	
	@BeforeClass
	public void setUp() {
		driver = new main.SetUp().setUp();
		
	}
	@AfterClass
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
	@Test
	public void changeLanguageCurrency() throws InterruptedException {
		objHomePage = new HomePage(driver);
		objHomePage.clickLanguagePopUp();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		objHomePage.selectLanguageDropdown();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		objHomePage.selectCurrencyDropdown();
		objHomePage.clickApply();
		Assert.assertEquals(objHomePage.getCurrencyLanguageText(),"English / $ USD");
	}
	@Test(dependsOnMethods= {"changeLanguageCurrency"})
	public void selectOriginDestination() {
		String departureCity = "Guadalajara";
		String destinationCity = "Seattle";
		objHomePage.departurePopUp();
		objHomePage.departureInput(departureCity);
		objHomePage.clickDepartureCity();
		objHomePage.destinationInput(destinationCity);
		objHomePage.clickDestinationCity();
		Assert.assertEquals(objHomePage.getDeparture(), departureCity);
		Assert.assertEquals(objHomePage.getDestination(), destinationCity);
	}
	@Test (dependsOnMethods= {"selectOriginDestination"})
	public void passengers() {
		objHomePage.clickPassengersPopUp();
		Assert.assertTrue(objHomePage.getPassengersText());
	}
	@Test(dependsOnMethods= {"passengers"})
	public void datePrices() {
		objHomePage.clickCalendarPopUp();
		objHomePage.getCheapest();
	}
	@Test (dependsOnMethods= {"datePrices"})
	public void pickDates() {
		objHomePage.clickDepartureDate();
		objHomePage.clickReturnDate();
		objHomePage.clickDoneBtn();
		Assert.assertEquals(objHomePage.getDepartureDate(),"Wed, Feb 8, 2023");
		Assert.assertEquals(objHomePage.getReturnDate(),"Fri, Feb 10, 2023");
	}
}



	