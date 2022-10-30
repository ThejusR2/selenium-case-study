package selenium_case;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Case {
	WebDriver driver;
	
	@BeforeTest
	public void testcase1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void testcase2() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
	}
	
	@Test
	public void testcase3() throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println("Links present are "+alllinks.size());
		Thread.sleep(2000);
		for(int i=0;i<alllinks.size();i++) {
     		System.out.println(alllinks.get(i).getText());
  		    System.out.println(alllinks.get(i).getAttribute("href"));
		}	
	}
	
	@Test
	public void testcase4() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(6).click();
		Thread.sleep(1000);
		driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(6).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
		
	}
	
	@AfterTest
	public void testcase5() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='oxd-userdropdown']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
	}

}
