package pageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import components.AbstractComponents;



public class Productcatalogue extends AbstractComponents {
	

	 WebDriver  driver;
	    public Productcatalogue (WebDriver driver)
	    {
	        super(driver);
	        //intialization
	        this.driver=driver;
	        PageFactory.initElements(driver,this);
	        
	    }
	    
	   public void addItems() throws IOException
	   {
		
		   
		   Properties pro=new Properties();
			FileInputStream files=new FileInputStream("C:\\Users\\vuppula.samyuktha\\eclipse-workspace\\automation1\\src\\properties");
			pro.load(files);
			String[] itemsNeeded=pro.getProperty("product").toString().split("#");
			String formattedname = itemsNeeded[0].trim();
	        if (formattedname.length() == 0) {
	            System.out.println(" total no .of products in the property file " + formattedname.length());





	         System.out.println("No products in the property file");
	         System.exit(0);
	       }
	        
	        
	            else if(formattedname.length()>0){



		   int j = 0;
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.xpath("//div[@class='container']//div[@class='row']//h5")));
	        List<WebElement> products = driver.findElements(By.xpath("//div[@class='container']//div[@class='row']//h5"));
	        
	        for (int i = 0; i < products.size(); i++) {
	            String[] name = products.get(i).getText().split("-");
	            String formattedName = name[0].trim();
	            List itemsNeedlist = Arrays.asList(itemsNeeded);
	            if (itemsNeedlist.contains(formattedName)) {
	            	System.out.println("SUCESSFULLY added " +formattedName+ " to cart");
	                j++;
	                
	                driver.findElements(By.xpath("//section[@id='products']//button[2]")).get(i).click();
	                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	                wait.until(ExpectedConditions
	                        .invisibilityOfAllElements(driver.findElements(By.cssSelector(".ng-animating"))));
	                
	                if (j == itemsNeeded.length) {
	      
	                    break;
	                
	                

	        
			
	                }
	            }
	        }
	        

		}

	   }
}

		   
		   
	   