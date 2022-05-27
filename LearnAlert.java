package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {
	public static void main(String[] args) {
		// Setuping Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

		// Maximize web page
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		Alert alert =driver.switchTo().alert();
		alert.sendKeys("Rebecca");
		alert.accept();
		String str = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if(str.contains("Rebecca"))
			{
				  System.out.println(str +"is verified");
			}
		 else
			 {
				 System.out.println(str +"is not exists");
					  
			}
		}
	}

