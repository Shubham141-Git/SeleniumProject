package Framework.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class Cart {
	
	WebDriver driver;
	
	public Cart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> cart = driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css=".cartSection h3") List<WebElement> cartProducts;

	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=".totalRow button") WebElement checkout;
	
public Boolean checkProductInCart(String productName) {
	Boolean match = cartProducts.stream().anyMatch(p->p.getText().equalsIgnoreCase(productName));

	return match;

}

public CheckOutPage goToCheckOut() {
	
	checkout.click();
	
	CheckOutPage checkOut = new CheckOutPage(driver);
	return checkOut;
	
}


}

