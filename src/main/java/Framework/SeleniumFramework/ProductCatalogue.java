package Framework.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	
WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	//driver.findElement(By.cssSelector("ng-animating")
	@FindBy(css=".ng-animating") WebElement spinner;
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	@FindBy(css="[routerlink*='cart']") WebElement cartBtn;
	
	By products1 = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	

	
	public List<WebElement> getProductList() {
		waitForElementToAppear(By.cssSelector(".mb-3"));
		return products;
	}
	
	public  WebElement getProductName(String productName) {
		WebElement prod = getProductList().stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
return prod;
	}
	
	public void addToCart(String productName) throws InterruptedException {
		 WebElement prod = getProductName(productName);
		 prod.findElement(addToCart).click();
		 waitForElementToAppear(toastMessage);
		 waitForElementToDisAppear();
		
	}
	
	
	public Cart goToCart() {
		
		cartBtn.click();
		
		Cart crt = new Cart(driver);
		 return crt;
		
	}
}
