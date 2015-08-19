package week8;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Day8demopag extends Page{
	public Day8demopag(WebDriver driver) {
		super(driver);
	}
	
	public static By sng = By.id("searchTypeSng");
	public static By from = By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromCity']");
	public static By to = By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='toCity']");
	public static By date = By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromDate']");
	public static By search = By.xpath("//div[@id='js_flighttype_tab_domestic']//button[text()='搜　索']");
	public static By searchend =By.xpath(".//*[@id='progTip']/span");
	public static By flight = By.xpath("//*[contains(@id,'itemBar')]//div//span[@class='highlight']/parent::p");
	public static By order = By.xpath("//*[contains(@id,'itemBar')]//div//span[@class='highlight']/following::div[@class='a_booking']//span/b");
	
	public void sng(){
		WebElement element = this.getElement(sng);
		element.click();
	}
	public void from(String fromcity){
		WebElement element =this.getElement(from);
		element.clear();
		element.sendKeys(fromcity);
	}
	public void to(String tocity){
		WebElement element = this.getElement(to);
		element.clear();
		element.sendKeys(tocity);
	}
	public void date(){
		WebElement element =this.getElement(date);
		element.clear();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DAY_OF_YEAR, 7);
		Date dt1 = rightNow.getTime();
		String reStr = formatter.format(dt1);
		element.sendKeys(reStr);
	}
	public void search(){
		WebElement element = this.getElement(search);
		Assert.assertEquals(element.getText(), "搜　索");
		element.click();
	}
	public boolean searchend(){
		WebElement element = this.getElement(searchend);
		if(element.getText().contains("搜索结束")){
			return true;
		}else{
			System.out.println("没有出搜索结果");
			return false;
		}
		
	}
	public boolean flight(){
		WebElement element = this.getElement(flight);
		if(element.getText().contains("每段航班均需缴纳税费")){
			return true;
		}else{
			System.out.println("非分段计价");
			return false;
		}

	}
	public void order(){
		List<WebElement> element =(List<WebElement>) driver.findElements(order);
		int order = (int) Math.round(Math.random() * (element.size() - 1));
		Assert.assertEquals(element.get(order).getText(), "订  票");
		element.get(order).click();
	}

}
