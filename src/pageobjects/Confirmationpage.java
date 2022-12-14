package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmationpage {
	
	WebDriver driver;




    public Confirmationpage(WebDriver driver) {
          // super(driver);
           this.driver=driver;
           PageFactory.initElements(driver, this);


}
    @FindBy(css=".hero-primary")
    WebElement confirmation;
    
    public void confirmationApplication() throws InterruptedException
    {
    	JavascriptExecutor js1 = (JavascriptExecutor) driver;
    	js1.executeScript("window.scrollBy(0,-350)");
    	Thread.sleep(2000);
    	String message=confirmation.getText();
    	System.out.println(message);
    }
    }
    