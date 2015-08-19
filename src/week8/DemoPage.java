package week8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DemoPage extends Page {
	public DemoPage(WebDriver driver) {
		super(driver);
	}
	public static By input = By.id("user");
	public static By link = By.xpath(".//*[@id='link']/a");
	public static By select = By.cssSelector("select");
	public static By radio = By.name("identity");
	public static By checkbox =By.xpath(".//*[@id='checkbox']/input");
	public static By button = By.className("button");
	public static By alert = By.xpath(".//*[@id='alert']/input");
	public static By upload = By.id("load");
	public static By action = By.xpath(".//*[@id='action']/input");
	public static String frame = "aa";
	public static By wait = By.className("wait");
	
	public void input(String message){
		WebElement element = this.getElement(input);
		element.sendKeys(message);
	}
	public void link(){
		this.getElement(link).click();
	}
	public void select(String selectwhat){
		WebElement element = this.getElement(select);
		Select select = new Select(element);
		select.selectByValue(selectwhat);
	}
	public void button(){
		this.getElement(button);
	}
	public void frame(){
		this.driver.switchTo().frame(frame);
		this.getElement(input);
		this.driver.switchTo().defaultContent();
		this.getElement(input).sendKeys("test");
	}
}
