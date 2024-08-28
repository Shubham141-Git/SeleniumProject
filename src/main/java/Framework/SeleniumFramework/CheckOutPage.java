package Framework.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	
	WebDriver driver ; 
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		 this.driver =driver;
		 PageFactory.initElements(driver, this);
	}
	//By.cssSelector("[placeholder='Select Country'")), "india"
	@FindBy(css="[placeholder='Select Country'") WebElement country;
	@FindBy(xpath="(//button[contains(@class,'ta-item')][2]") WebElement item;
	
	@FindBy(css=".action__submit") WebElement btn;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectountry(String Country) {
		Actions act = new Actions(driver);
		
		act.sendKeys(country, Country).build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		waitForElementToAppear(results);
		item.click();
		
		
		
		
	}
	
	public  ConfirmPage submitOrder() {
		
		
		btn.click();
		ConfirmPage ConfirmPage = new ConfirmPage(driver);
	
	
	return ConfirmPage;
			}
	
}
