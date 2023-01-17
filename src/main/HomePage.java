package main;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
WebDriver driver;

@FindBy(id ="onesignal-slidedown-cancel-button")
WebElement cancelBtn;
@FindBy(xpath = "//ul[@class = 'sign-md']/li/a")
WebElement languagePopUp;
@FindBy (xpath = "(//div[@class='mat-form-field-infix']/select)[1]")
WebElement languageDropdown;
@FindBy(xpath = "(//div[@class='mat-form-field-infix']/select)[2]")
WebElement currencyDropdown;
@FindBy(css="button[class='btn btn-large mat-flat-button mat-button-base mat-primary']")
WebElement applyButton;
@FindBy(css="#mcp>a>span:nth-child(1)")
WebElement languageCurrencyText;
@FindBy(css=".btnSearch.radius-6")
WebElement departureCityPopUp;
@FindBy(id="fnameOrigin")
WebElement inputDepartureCity;
@FindBy(css="li.row.row-spec.ng-star-inserted")
WebElement citiesList;
@FindBy(id = "fnameDestination")
WebElement inputDestinationCity;
@FindBy(css = "#mat-input-14")
WebElement passengersPopUp;
@FindBy(css="(//mat-form-field/div/div/div/input[@tabindex=-1])[3]")
WebElement passengersText;
@FindBy(css = "#mat-input-5")
WebElement calendar;
@FindBy(css = "span.price")
WebElement datePrices;
@FindBy(css= ".datecell-20230208")
WebElement departureDate;
@FindBy(css = ".datecell-20230210")
WebElement returnDate;
@FindBy(css="btn-calendar.d-none.d-md-block.mat-flat-button.mat-button-base.mat-secondary")
WebElement doneBtn;
@FindBy(css="h3>input[placeholder = 'Mexico City']")
WebElement getDepartureText;
@FindBy(css="h3>input[placeholder = '- - -']")
WebElement getDestinationText;
@FindBy(css="(//mat-form-field/div/div/div/input[@tabindex=-1])[1]")
WebElement departureDateText;
@FindBy(css="(//mat-form-field/div/div/div/input[@tabindex=-1])[2]")
WebElement returnDateText;

public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void clickCancel() {
	cancelBtn.click();
}

public void clickLanguagePopUp() {
	languagePopUp.click();
}

public void selectLanguageDropdown() {
	Select selectLanguage = new Select(languageDropdown);
	selectLanguage.selectByValue("1: Object");
}
public void selectCurrencyDropdown() {
	Select selectLanguage = new Select(languageDropdown);
	selectLanguage.selectByValue("1: Object");
}
public void clickApply() {
	applyButton.click();
}
public String getCurrencyLanguageText() {
	return languageCurrencyText.getText();
}
public void departurePopUp() {
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	departureCityPopUp.click();
}
public void departureInput(String city) {
	inputDepartureCity.sendKeys(city);
}
public void clickDepartureCity() {
	citiesList.click();
}
public void destinationInput(String city) {
	inputDestinationCity.sendKeys(city);
}
public void clickDestinationCity() {
	citiesList.click();
}
public String getDeparture() {
	return getDepartureText.getText();
}
public String getDestination() {
	return getDestinationText.getText();
}
public void clickPassengersPopUp() {
	passengersPopUp.click();
}
public boolean getPassengersText() {
	return passengersText.getText().contains("1");
}
public void clickCalendarPopUp() {
	calendar.click();
}
public void getCheapest() {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("span.price"))));
	List<WebElement> prices = driver.findElements(By.cssSelector("span.price"));
	List<Double> pricesNum = new ArrayList<Double>();
	for (WebElement item:prices) {
	pricesNum.add(Double.parseDouble(item.getText().replace(",","").substring(1)));
	}
	System.out.println("Max val: " + Collections.max(pricesNum));
	System.out.println("Min val: " + Collections.min(pricesNum));
}
public void clickDepartureDate() {
	departureDate.click();
}
public void clickReturnDate() {
	returnDate.click();
}
public void clickDoneBtn() {
	doneBtn.click();
}
public String getDepartureDate() {
	return departureDateText.getText();
}
public String getReturnDate() {
	return returnDateText.getText();
}
}
