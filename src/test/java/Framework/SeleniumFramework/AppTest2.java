package Framework.SeleniumFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class AppTest2 extends BaseTest {
	
	WebDriver driver;
	LandingPage lp;
	
	String productName = "ZARA COAT 3";
@Test(dataProvider = "getData" , groups="PurchaseOrder")
public void submitOrder(HashMap<String , String> input) throws IOException, InterruptedException {
		
		
		
		
			
 
//			driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
//			driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
//			driver.findElement(By.id("login")).click();

//			LandingPage lp= new LandingPage(driver);
//			lp.goTO();
		//LandingPage lp = launchApplication(); Annotation will take care of launching he browser
			
			ProductCatalogue ProductCatalogue=lp.loginApplication(input.get("email"), input.get("password"));

//	WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//
//	 List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//
//	 


			//ProductCatalogue pc = new ProductCatalogue(driver);
			ProductCatalogue.getProductList();
			
			//WebElement prod = products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);

			
			ProductCatalogue.getProductName(input.get("product"));
		
			//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			
//			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("ng-animating"))));			
			
			ProductCatalogue.addToCart(input.get("product"));
			
			//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
			
			Cart crt=ProductCatalogue.goToCart();
			
//			List<WebElement> cart = driver.findElements(By.cssSelector(".cartSection h3"));
//			
//			Boolean match = cart.stream().anyMatch(p->p.getText().equalsIgnoreCase(productName));
//
//	
			
			//Cart crt = new Cart(driver);
			
			Boolean rsult = crt.checkProductInCart(input.get("product"));
			
			//Validation should only be onlt be done test files and not in page object file
			Assert.assertTrue(rsult);
	
//	driver.findElement(By.cssSelector(".totalRow button")).click();
//	
			CheckOutPage checkOut =crt.goToCheckOut();
			
//	Actions act = new Actions(driver);
//	
//	act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country'")), "india").build().perform();
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
			
			
	 
	 
//	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')][2]")).click();
//	driver.findElement(By.cssSelector(".action__submit")).click();
//	
			
			checkOut.selectountry("india");
			ConfirmPage  ConfirmPage=checkOut.submitOrder();
			
	//String confirmsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
			String mssg =ConfirmPage.text();
			Assert.assertTrue(mssg.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
	//driver.close();
	
}





@Test(dependsOnMethods="submitOrder")
public void orderHistoryTest() {
	
	ProductCatalogue ProductCatalogue=lp.loginApplication("anshika@gmail.com", "Iamking@000");

	 OrderPage orderPage = ProductCatalogue.goToOrderPage();
	 
	  Boolean res = orderPage.VerifyOrderDisplay(productName);
Assert.assertTrue(res);

}




@DataProvider
public Object[][] getData() {
	
	HashMap<String , String> map = new HashMap<String, String>();
	
	map.put("email" , "anshika@gmail.com");
	map.put("password" , "IamKing@000");
	map.put("product" , "ZARA COAT 3");
	
	
HashMap<String , String> map2 = new HashMap<String, String>();
	
	map2.put("email" , "shetty@gmail.com");
	map2.put("password" , "IamKing@000");
	map2.put("product" , "ADIDAS ORIGINAL");
	
	
	return new Object [][] {{map},{map2}};
}




}
