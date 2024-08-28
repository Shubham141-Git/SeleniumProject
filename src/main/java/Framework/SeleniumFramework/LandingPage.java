package Framework.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	 //WebElement email =driver.findElement(By.id("userEmail"));
	
	 
	 //This is Page factory
	 @FindBy(id="userEmail")
	 WebElement userEmail;
	 
	 @FindBy(id="userPassword")
	 WebElement userPassword;
	 
	 @FindBy(id="login")
	 WebElement submit;
	 
	 @FindBy(css="[class*='flyInOut']")
	 WebElement errorMessage;
	 
	 public ProductCatalogue loginApplication(String email , String password) {
		 
		 userEmail.sendKeys(email);
		 userPassword.sendKeys(password);
		 submit.click();
		 
		 //Here we are 500% sure that after this action we will landing to product page rather than to create the object intest class we will create it here TO avoid so much object creation in one file
		 
		 ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
		 return  ProductCatalogue;
	 }
	 
	 public void goTO() {
		 driver.get("https://rahulshettyacademy.com/client");
			
	 }
	 
	 public String getErrorMessage() {
		 
		 waitForWebElementToAppear(errorMessage);
		 return errorMessage.getText();
	 }
	
	
}
