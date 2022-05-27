package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindow {
	public static void main(String[] args) {
		// Setuping Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://www.leafground.com/pages/Window.html");

		// Maximize web page
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
	    System.out.println("Title : "+title);
	    
	    driver.findElement(By.xpath("//button[contains(text(),'Open Home Page')]")).click();
	    
	    Set<String> windowHandle  = driver.getWindowHandles();
	    List<String> windowHandleslist  = new ArrayList<String>(windowHandle);
	    driver.switchTo().window(windowHandleslist.get(1));
	  
	    		 System.out.println(driver.getCurrentUrl());
	    		 System.out.println(driver.getTitle());
	    		 
	    driver.switchTo().window(windowHandleslist.get(0));
	    
		 System.out.println(driver.getCurrentUrl());
		 System.out.println(driver.getTitle());
	}
}
