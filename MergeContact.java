package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) {
		// Setuping Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://www.leafground.com/pages/Window.html");

		// Maximize web page
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");

		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		 driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();	
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();

		// Click widget
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();

		// Assigning new windowsHandles and switching to new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String newwindowHandles = list.get(1);
		driver.switchTo().window(newwindowHandles);

		// Click first Resulting contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

		// giving control to base window
		driver.switchTo().window(list.get(0));

		// Click on To Contact widget
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();

		// Assigning new windowsHandles and switching to new window

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles1);
		String newwindowHandles1 = list1.get(1);
		driver.switchTo().window(newwindowHandles1);

		// Click the first Resulting contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();

		// giving control back to base window
		driver.switchTo().window(list1.get(0));

		// Clicking on Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		// Switching to alert
		Alert alert = driver.switchTo().alert();

		// Accepting Alert
		alert.accept();

		// Viewing title of the page
		System.out.println("Title of the Page is : " + driver.getTitle());
	}
}
