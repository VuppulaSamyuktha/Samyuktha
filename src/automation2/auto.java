/*package automation2;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class auto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vuppula.samyuktha\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		String[] itemsNeeded= {"ZARA COAT 3","ADIDAS ORIGINAL","IPHONE 13 PRO"};
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("abc08@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Abc@1234");
        driver.findElement(By.id("login")).click();
        addItems(driver, itemsNeeded);  
           driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
           JavascriptExecutor js = (JavascriptExecutor)driver;
           js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        //   Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Checkout']")));
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
        
        JavascriptExecutor js3 = (JavascriptExecutor)driver;
        js3.executeScript("window.scrollBy(0,-350)","");
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
    //    Thread.sleep(3000);
        List<WebElement> options = driver
     		   .findElements(By.cssSelector("button[class='ta-item list-group-item ng-star-inserted']"));
        

		   for (WebElement option : options)
{
	  if (option.getText().equalsIgnoreCase("India")) 
	  {
		  option.click();
		  break;
		  
	  }
}
		   
		   JavascriptExecutor js4 = (JavascriptExecutor) driver;
	         js4.executeScript("window.scrollBy(0,200)");
	         driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
	         JavascriptExecutor js2 = (JavascriptExecutor) driver;
	         js2.executeScript("window.scrollBy(0,-700)");
	        //Thread.sleep(2000);
	         String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	       //  Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	         System.out.println(confirmMessage);
	         
		}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded)
	  {
	  
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
	                j++;
	                driver.findElements(By.xpath("//section[@id='products']//button[2]")).get(i).click();
	                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	                wait.until(ExpectedConditions
	                        .invisibilityOfAllElements(driver.findElements(By.cssSelector(".ng-animating"))));
	                if (j == itemsNeeded.length) {
	                    System.out.println(" ZARA COAT 3 IS ADDED SUCESSFULLY");
	                    System.out.println(" ADIDAS ORIGINAL IS ADDED SUCESSFULLY");
	                    System.out.println(" IPHONE 13 PRO IS ADDED SUCESSFULLY");
	                    break;
	                }
	            }
	        }
	    
	}
}*/





      
       

		
	