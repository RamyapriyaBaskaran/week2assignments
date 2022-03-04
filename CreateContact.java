 package week2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Login
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

		//Click on Contacts tab->Click on Create contact tab->Enter details
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Ramya");
		driver.findElement(By.id("lastNameField")).sendKeys("B");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Meena");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Rathi");
		driver.findElement(By.name("departmentName")).sendKeys("IT");
		driver.findElement(By.name("description")).sendKeys("Information Technology");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("aaa@gmail.com");
		
		//Select state from Dropdown
		WebElement elementstate = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select dropdown = new Select(elementstate);
		dropdown.selectByVisibleText("New York");
		
		//Submit the details
		driver.findElement(By.className("smallSubmit")).click();
		
		//Click on Edit->Clear description->enter important notes->Update it
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']/preceding-sibling::a")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.name("importantNote")).sendKeys("Hello, Welcome to Edit!!!");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		
		//Get the page title
		String title = driver.getTitle();
		System.out.println("Title of the page is : " +title);
		System.out.println("End of Program");
	}
}
