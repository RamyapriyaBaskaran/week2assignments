package week2.assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateFirstResultantLead {

	public static void main(String[] args) throws InterruptedException {
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
		
		//Click on Leads tab->Find Leads tab->Search with 'email id'->Click Find Leads
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath(("//span[text()='Email']"))).click();
		driver.findElement(By.xpath(("//input[@name='emailAddress']"))).sendKeys("aaa@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Capture first lead name and Click on First Resultant lead
		Thread.sleep(3000);
		WebElement firstLeadElement = driver.findElement(By.xpath(("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a")));
		String firstLeadName = firstLeadElement.getText();
		System.out.println("First Lead Name displayed : "+firstLeadName);
		firstLeadElement.click();
		
		//Click on Duplicate ->Validate title -> Click on Create Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		WebElement titleValidation = driver.findElement(By.id("sectionHeaderTitle_leads"));
		String str = titleValidation.getText();
		System.out.println("Title displayed in the page: " +str);
		if (str.equals("Duplicate Lead"))
			System.out.println("Title is expected");
		else
			System.out.println("Title is different");
		
		driver.findElement(By.className("smallSubmit")).click();
		
		WebElement duplicatedLeadElement = driver.findElement(By.id("viewLead_firstName_sp"));
		String duplicateLeadName = duplicatedLeadElement.getText();
		System.out.println("Duplicated Lead Name is : "+duplicateLeadName);
		
		if(firstLeadName.equals(duplicateLeadName))
		{
			System.out.println("First Resultant Lead name and Duplicated Lead name are same");
		}
		else 
			System.out.println("First Resultant Lead name and Duplicated Lead name are different");
				
		driver.close();
		System.out.println("End of Program");
	}

}
