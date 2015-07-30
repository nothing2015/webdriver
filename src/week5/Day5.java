package week5;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day5 {
	public WebDriver driver;
	public void startfirefox(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
	}
	public void gotoe(){
		driver.get("file:///E:/%E7%82%BC%E6%95%B0%E6%88%90%E9%87%91/selenium/demo.html");	
	}
	public void endfirefox(){
		driver.close();
		driver.quit();
	}
	public void alert(){
//		driver.findElement(By.className("alert")).click();
		WebElement element =driver.findElement(By.className("alert"));
		Actions action = new Actions(driver);
		action.click(element).perform();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
	}
	public void action(){
		WebElement element =driver.findElement(By.className("over"));
		Actions action =new Actions(driver);
		action.moveToElement(element).perform();
		String text = driver.findElement(By.id("over")).getText();
		System.out.println(text);
	}
	public void upload(){
		driver.findElement(By.id("load")).sendKeys("file:///E:/%E7%82%BC%E6%95%B0%E6%88%90%E9%87%91/selenium/demo.html");
	}
	public void js(){
		driver.get("http://www.haosou.com");
		String ret = (String)((JavascriptExecutor)driver).executeScript("return document.getElementById('search-button').value;");
		System.out.println(ret);
		
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("alert('hello world')");
		System.out.println("overjs");
	}
	public void iframe(){
		driver.switchTo().frame("aa");
		driver.findElement(By.id("user")).sendKeys("test");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("user")).sendKeys("test");
		WebElement webelement =driver.findElement(By.xpath("//iframe[@name='aa']"));
		driver.switchTo().frame(webelement);
		driver.findElement(By.id("user")).sendKeys("test44");
	}
	public void windows() throws InterruptedException{
		
		driver.findElement(By.className("open")).click();
		Set<String> handles = driver.getWindowHandles();
		String handle = driver.getWindowHandle(); //获取到最初的当前窗口
		handles.remove(handle);
		String newhandle = handles.iterator().next();
		driver.switchTo().window(newhandle);
		Thread.sleep(6000);
		driver.findElement(By.id("kw")).sendKeys("baidutest");
		
	}
	public void testwait(){
		driver.findElement(By.className("wait")).click();
		boolean wait = new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.findElement(By.className("red")).isDisplayed();
			}
		});
		System.out.println(wait);
		WebElement element = driver.findElement(By.className("red"));
		System.out.println(element.getText());
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Day5 day5 =new Day5();
		day5.startfirefox();
		day5.gotoe();
		day5.iframe();
		day5.windows();
		day5.testwait();
		day5.alert();
		day5.action();
		day5.upload();
		day5.js();
		day5.endfirefox();
	}

}
