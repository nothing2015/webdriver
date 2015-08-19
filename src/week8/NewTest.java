package week8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;
	@BeforeClass
	public void openurl(){
	driver=new FirefoxDriver();
	driver.get("file:///E:/%E7%82%BC%E6%95%B0%E6%88%90%E9%87%91/selenium/demo.html");
	}
	@AfterClass
	public void over(){
	driver.close();
	driver.quit();
	}
	
	@Test
	public void testinput() {
		DemoPage dp = new DemoPage(driver);
		dp.input("i am ok");
	}
	@Test
	public void testbutton() {
		DemoPage dp = new DemoPage(driver);
		dp.button();
	}
	@Test
	public void selecttest(){
		DemoPage dp = new DemoPage(driver);
		dp.select("volvo");
	}
	
	
}
