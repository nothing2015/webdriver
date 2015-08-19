package week8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	protected WebDriver driver;
	public Page(WebDriver driver){
		this.driver = driver;
}
	public boolean wait(final By key){
		boolean wait =new WebDriverWait(driver, 10)
		.until(new ExpectedCondition<Boolean>() {
			WebElement webelement;

			public Boolean apply(WebDriver driver) {
				webelement = driver.findElement(key);
				return webelement.isDisplayed();
			}
		});
		return wait;
	}
	protected WebElement getElement(By key){
		WebElement  element =null;
		if(this.wait(key)){
			element = this.driver.findElement(key);
		}
		return element;
	}
}
