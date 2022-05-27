package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnScreenshot {
	public static void main(String[] args) throws IOException, InterruptedException {
	// Setuping Browser property
			WebDriverManager.chromedriver().setup();

			// Launch Chrome Browser
			ChromeDriver driver = new ChromeDriver();

			// Load the URL
			driver.get("https://www.amazon.in/");

			// Maximize web page
			driver.manage().window().maximize();
			
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 9 pro", Keys.ENTER);
			 String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
			 System.out.println("The Price of First Product is : " + price);
				
			 
			 String price1 = price.replaceAll(",", "");
				int price2 = Integer.parseInt(price1);
				System.out.println(price2);

				
				System.out.println("Customer rating for First displayed Product is : "
						+ driver.findElement(By.xpath("(//span[@class='a-icon-alt'])[4]")).getText());
				System.out.println("The No.of.Customer Ratings for First Displayed Product is : "
						+ driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText());

				// Clicking on First link of First displayed image
				driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

				// Assigning new windowsHandles and switching to new window
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> list = new ArrayList<String>(windowHandles);
				String newwindowHandles = list.get(1);
				driver.switchTo().window(newwindowHandles);
				
				File file = driver.getScreenshotAs(OutputType.FILE);
				File destPath = new File("./snaps/IMG002.png");
				FileUtils.copyFile(file, destPath);
				
				driver.findElement(By.id("add-to-cart-button")).click();
				
				Thread.sleep(3000);
						
				String subtotal = driver.findElement(By.xpath("//span[contains(@id,'cart-total')]/following::span[contains(@id,'cart-subtotal')]")).getText();
			
				// Printing SubTotal value
				System.out.println("SubTotal  : " + subtotal);
				
				
				if (price.contains(subtotal)) {
					System.out.println("Verified the cart subtotal");

				} else {
					System.out.println("The Price and SubTotal value in Cart is Not Equal");
				}
	}
}
