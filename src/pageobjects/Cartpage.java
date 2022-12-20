package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import components.AbstractComponents;

public class Cartpage {

	WebDriver driver;

	public Cartpage(WebDriver driver) {

		// super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement Cart;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement check;

	public void cartApplication() throws InterruptedException {

		Cart.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 400)");
		Thread.sleep(3000);
		//Actions actions = new Actions(driver);
		//actions.moveToElement(check);
		check.click();
		Thread.sleep(2000);
		check.click();
		Thread.sleep(2000);
	}
}