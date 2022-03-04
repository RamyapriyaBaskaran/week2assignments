package week2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundPrograms {
	public void edit ()
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		System.out.println(driver.findElement(By.id("email")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following-sibling::input")).isEnabled());
		System.out.println(driver.findElement(By.xpath("(//input[@name='username'])[1]")).isEnabled());
		System.out.println(driver.findElement(By.xpath("(//input[@name='username'])[2]")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input")).isEnabled());
		driver.close();
		System.out.println("End of Editable check program");
	}
	
	public void buttons()
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("//img[contains(@src,'images/button.png')]")).click();
		System.out.println("Successfully clicked Buttons in Homepage");
		System.out.println(driver.findElement(By.id("position")).getLocation());
		System.out.println(driver.findElement(By.id("color")).getCssValue("background-color"));
		System.out.println(driver.findElement(By.id("size")).getSize());
		driver.close();
		System.out.println("End of Buttons check program");
	}
	
	public void link()
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		System.out.println(driver.findElement(By.linkText("Go to Home Page")).getAttribute("href"));
		System.out.println(driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href"));
		System.out.println(driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href"));
		System.out.println(driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).getAttribute("href"));
		System.out.println(driver.findElement(By.linkText("How many links are available in this page?")).getAttribute("href"));
		driver.close();
		System.out.println("End of Links check program");
	}
		
	public void image()
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		System.out.println("Successfully Navigated to Homepage");
		driver.findElement(By.xpath("//img[@src='images/image.png']")).click();
		System.out.println("Clicked on Image icon displayed in Homepage");
		driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).click();
		System.out.println("Oops!! Im a Broken image");
		driver.findElement(By.xpath("//img[@src='../images/keyboard.png']")).click();
		System.out.println("Successfully Navigated to Homepage again");
		driver.close();
		System.out.println("End of images check program");	
	}
	
	public void dropdown()
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		WebElement indexElement = driver.findElement(By.id("dropdown1"));
		Select dd1 = new Select(indexElement);
		dd1.selectByIndex(1);
		
		WebElement textElement = driver.findElement(By.name("dropdown2"));
		Select dd2 = new Select(textElement);
		dd2.selectByVisibleText("Selenium");
		
		WebElement valueElement = driver.findElement(By.id("dropdown3"));
		Select dd3 = new Select(valueElement);
		dd3.selectByValue("1");
		
		WebElement noOfDDElement = driver.findElement(By.xpath("//select[@class='dropdown']")); 
		Select dd4 = new Select(noOfDDElement);
		List<WebElement> options = dd4.getOptions();
		for(int i=0;i<options.size();i++)
		{
			if(i==options.size()-1)
			System.out.println("No. of dropdowns are: "+i);
		}
		
		
		driver.findElement(By.xpath("(//div[@class='example'][5])/select")).sendKeys("Selenium");
		
		WebElement selectElement = driver.findElement(By.xpath("(//div[@class='example'][6])/select"));
		Select dd6 = new Select(selectElement);
		dd6.selectByVisibleText("Selenium");
		driver.close();
		System.out.println("End of dropdown check program");
	}
	
	public void checkbox()
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.findElement(By.xpath("//div[text()='Java']/input")).click();
		driver.findElement(By.xpath("//div[text()='C']/input")).click();
		System.out.println("Selected langauages that I know");
		System.out.println(driver.findElement(By.xpath("//div[text()='Selenium']/input")).isSelected());
		driver.findElement(By.xpath("//div[text()='I am Selected']/input")).click();
		System.out.println("Deselected the checkbox");
		driver.findElement(By.xpath("(//div[text()='Option 1'])/input")).click();
		driver.findElement(By.xpath("(//div[text()='Option 2'])/input")).click();
		driver.findElement(By.xpath("(//div[text()='Option 3'])/input")).click();
		driver.findElement(By.xpath("(//div[text()='Option 4'])/input")).click();
		driver.findElement(By.xpath("(//div[text()='Option 5'])/input")).click();
		System.out.println("Selected All options");
		driver.close();
		System.out.println("End of checkbox check program");
		
	}
	
	public static void main(String[] args) {
		LeafGroundPrograms lf = new LeafGroundPrograms();
		lf.edit();
		lf.buttons();
		lf.link();
		lf.image();
		lf.dropdown();
		lf.checkbox();
		System.out.println("!!!END OF LEAFGROUND PROGRAMMING!!!!");
	}
}
