package week2.assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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

		//Click on Leads tab->Find Leads tab->Search with 'phone Number'->Click Find Leads
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath(("(//span[@class='x-tab-strip-inner'])[2]/span"))).click();
		driver.findElement(By.xpath(("(//div[@class='x-plain-bwrap'])[14]//input"))).sendKeys("987654321");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Store First resultant ID and click on it
		Thread.sleep(3000);
		WebElement firstResultantLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String str = firstResultantLead.getText();
		System.out.println("First Resultant lead ID is : "+ str);
		firstResultantLead.click();
		
		//Delete ->Find with deleted ID 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input")).sendKeys(str);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Validate whether ID is deleted
		boolean displayed = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		System.out.println("ID delected: " +displayed);
		System.out.println("Successfully Deleted!!!");
		driver.close();
		System.out.println("End of Program");
	}

}
