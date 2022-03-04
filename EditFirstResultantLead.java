package week2.assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFirstResultantLead {

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
		
		//Click on Leads tab->Find Leads tab->Search with 'Test'->Click Find Leads
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath(("(//div[@class='x-form-item x-tab-item'])[2]//input"))).sendKeys("Ramya");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Select first resultant username 'Ramya'
		Thread.sleep(3000);
		driver.findElement(By.xpath(("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"))).click();
		
		//Get the page title and verify with expected Title
		String expectedTitle = "View Lead | opentaps CRM";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle))
			System.out.println("Title of the page is matched");
		else
			System.out.println("Title of the page is different");
		
		//Click Edit->Clear and update company->Click on Update
		driver.findElement(By.linkText("Edit")).click();
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys("Google");
		driver.findElement(By.xpath("//input[@class='smallSubmit'][1]")).click();

		//Check the updated company name
		WebElement updated = driver.findElement(By.id(("viewLead_companyName_sp")));
		String str = updated.getText();
		if (str.contains("Google"))
				{
				System.out.println("Company name updated successfully");
				}
				
		driver.close();
		System.out.println("End of Program");
	}

}
