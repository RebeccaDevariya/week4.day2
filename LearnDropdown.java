package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDropdown {
	public static void main(String[] args) {
		// Setuping Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://leafground.com/pages/Dropdown.html");

		// Maximize web page
		driver.manage().window().maximize();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 WebElement element = driver.findElement(By.id("dropdown1"));
			Select select = new Select(element);
			select.selectByIndex(2);
			
			WebElement element1 = driver.findElement(By.name("dropdown2"));
			Select select1 = new Select(element1);
			select1.selectByVisibleText("Loadrunner");
			
			WebElement element2 = driver.findElement(By.id("dropdown3"));
			Select select2 = new Select(element2);
			select2.selectByValue("2");
			
			WebElement element3 = driver.findElement(By.className("dropdown"));
			Select select3 = new Select(element3);
			List<WebElement> options = select3.getOptions();
			System.out.println(" No.of.Options available under dropdown is : " + options.size());

			driver.findElement(By.xpath("(//select)[5]")).sendKeys("UFT/QTP", Keys.ENTER);
			
			WebElement element4 = driver.findElement(By.xpath("(//select)[6]"));
			Select select4 = new Select(element4);
			select4.selectByValue("4");
			select4.selectByIndex(1);
	}
}
