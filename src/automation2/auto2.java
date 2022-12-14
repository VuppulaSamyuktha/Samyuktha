package automation2;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class auto2 {

	public static void main(String[] args) throws InterruptedException {
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
        WebElement element = driver.findElement(By.xpath("//button[text()='Checkout']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0, 400)");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
        driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]"));
        driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("India");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
        
        

	}

	 

    public static void addItems(WebDriver driver, String[] itemsNeeded) {
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

}
