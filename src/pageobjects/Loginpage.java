package pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		//super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement userPassword;
	@FindBy(id="login")
	WebElement login;
	
	
	
	 
	public void LoginApplication() throws IOException {
		Properties pro=new Properties();
		FileInputStream files=new FileInputStream("C:\\Users\\vuppula.samyuktha\\eclipse-workspace\\automation1\\src\\properties");
		pro.load(files);
		String Email=pro.getProperty("email");
		String Password=pro.getProperty("password");
		

        
        userEmail.sendKeys(Email);
        userPassword.sendKeys(Password);
        login.click();
	}
	
	
	public void goTo() {
		
		
		driver.get("https://rahulshettyacademy.com/client");
		
		
	}
}
	
        

	
	
	
	
	
	
	
	
	