package abstractComponent;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.SeleniumFramework.OrderPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(css="[routerlink*='myorders']") WebElement orderHader;
	
	public AbstractComponents(WebDriver driver) {
		 this.driver = driver;
	}

	public void waitForElementToAppear(By FindBy) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));

	}
	
	public void waitForWebElementToAppear(WebElement FindBy) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(FindBy));

	}

	public void waitForElementToDisAppear() throws InterruptedException {
Thread.sleep(4000);
		
		//		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	public OrderPage goToOrderPage() {
		
		orderHader.click();
		 OrderPage orderPage = new OrderPage(driver);
		 return orderPage;
		
	}
	
	public String getScreenShot(String testcaseName , WebDriver driver) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot) driver;
		
		File src =ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//" + testcaseName +".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+ "//reports//" + testcaseName +".png";
		
	}
}
