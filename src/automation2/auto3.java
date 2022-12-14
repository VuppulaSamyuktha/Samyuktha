package automation2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class auto3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vuppula.samyuktha\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();

		 

        driver.get("https://rahulshettyacademy.com/client/");
        driver.findElement(By.id("userEmail")).sendKeys("abc08@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Abc@1234");
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("(//button[text()=' Add To Cart'])[1]")).click();
        Thread.sleep(3000);

 

        driver.findElement(
                By.xpath("//button[text()=' Sign Out ' ]/parent::li/parent::ul//button[contains(text(), 'Cart')]"))
                .click();
        Thread.sleep(3000);

        WebElement checkOut = driver.findElement(By.xpath("//button[text()='Checkout']"));

        

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", checkOut);
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();

 

        Thread.sleep(5000);
        
        WebElement selectCountry = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
        selectCountry.click();
        selectCountry.sendKeys("India");

 

        Thread.sleep(5000);

 

        WebElement valueSelection = driver.findElement(By.xpath(
                "//input[@placeholder='Select Country']/following-sibling::section/button/span[text()=' India']"));
        
        Thread.sleep(3000);
        valueSelection.click();

 

        WebElement placeOrder = driver.findElement(By.partialLinkText("PLACE ORDER"));

 

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView(true)", placeOrder);

 

        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("PLACE ORDER")).click();

 

	}

}
