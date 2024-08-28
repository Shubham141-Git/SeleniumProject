package Framework.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import junit.framework.Assert;

public class ErrorValidation extends BaseTest {

	@Test(groups="ErrorHdling")
	public void validateErrorMessageInLoginPage() {
ProductCatalogue hh = lp.loginApplication("anshika@gmail.com", "htxrdtj");
  String mssg = lp.getErrorMessage();	
  
  Assert.assertEquals("Incorrct email or password", mssg);


	}
	
	
	
	@Test
	public void ProductErrorValidation() throws InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalogue pc = lp.loginApplication("anshika@gmail.com", "Iamking@000");		
	 List<WebElement> products = pc.getProductList();
	 pc.addToCart(productName);
	 Cart cart = pc.goToCart();
	  Boolean match = cart.checkProductInCart("ZARA COAT 35");
	Assert.assertFalse(match);
	
	
	}
	
	
	
}
