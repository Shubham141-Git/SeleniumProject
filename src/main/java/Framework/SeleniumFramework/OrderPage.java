package Framework.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponents;

public class OrderPage extends AbstractComponents {

	WebDriver driver ;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css=".totalRow button") WebElement checkoutEle;
	
	@FindBy(css="tr td:nth-child(3)") List<WebElement> cartProducts;
	
	
	public Boolean VerifyOrderDisplay(String productName) {
		
		Boolean match = cartProducts.stream().anyMatch(p->p.getText().equalsIgnoreCase(productName));
 return match;
		
	}
	
	

}
