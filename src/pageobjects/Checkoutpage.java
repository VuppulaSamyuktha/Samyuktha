package pageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage {
	
	  WebDriver driver;



	    public Checkoutpage(WebDriver driver) {
	    // super(driver);
	     this.driver=driver;
	     PageFactory.initElements(driver, this);
	}
	    @FindBy(xpath="//input[@placeholder='Select Country']")
	    WebElement country;
	    
	    @FindBy(xpath="//button[@type='button'][2]")
	    WebElement select;
	    @FindBy(xpath="//a[contains(text(),'Place Order')]")
	    WebElement Placeorder;
	    
	 
	    
	   
	    public void checkOutApplication() throws  InterruptedException, IOException {
	    	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    	js1.executeScript("window.scrollBy(0,-350)");
	    	Properties pro=new Properties();
			FileInputStream files=new FileInputStream("C:\\Users\\vuppula.samyuktha\\eclipse-workspace\\automation1\\src\\properties");
			pro.load(files);
			country.click();
			String place =pro.getProperty("place");
	    	country.sendKeys(place);
	    	Thread.sleep(3000);
	    	select.click();
	    	Placeorder.click();
	    	
	    	
	    }
}
