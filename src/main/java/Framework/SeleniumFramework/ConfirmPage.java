package Framework.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponents;

public class ConfirmPage extends AbstractComponents {

	WebDriver driver;
	
	public ConfirmPage(WebDriver driver) {
		super(driver);
		 this.driver =driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary") WebElement text;
	
	
	public String text() {
		 return text.getText();
	}
	
}
