package week2.assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookAccountCreation {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click create new account->Enter firstname, lastname, MobNo, password
		driver.findElement(By.xpath("//a[@data-testid=\"open-registration-form-button\"]")).click();
		driver.findElement(By.name("firstname")).sendKeys("Ramya");
		driver.findElement(By.name("lastname")).sendKeys("Baskaran");
		driver.findElement(By.name("reg_email__")).sendKeys("9988776655");
		driver.findElement(By.id("password_step_input")).sendKeys("ABCDE");
		
		//Select DD, MM, YY
		WebElement selectDate = driver.findElement(By.name("birthday_day"));
		Select date = new Select (selectDate);
		date.selectByVisibleText("1");
		WebElement selectMonth = driver.findElement(By.id("month"));
		Select month = new Select (selectMonth);
		month.selectByVisibleText("Aug");
		WebElement selectYear = driver.findElement(By.name("birthday_year"));
		Select year = new Select (selectYear);
		year.selectByVisibleText("1994");
		
		//Select Gender
		driver.findElement(By.xpath("//label[text()='Female']")).click();	
		System.out.println("End of Program");
	}
}
