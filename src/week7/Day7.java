package week7;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day7 {
	public WebDriver driver;
	public Log log =new Log();
	@BeforeMethod
	public void startfirefox(){
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://flight.qunar.com/");
	}
	@AfterMethod
	public void endfirefox(){
		driver.close();		
	}
	@Test
	public void inputfromandto(){
		//选择单程
		driver.findElement(By.id("searchTypeSng")).click();
		log.logInfo("选择单程");
		//截图
		ScreenShot ss = new ScreenShot(driver);
		ss.takeSreenshot();
		log.logInfo("单程截图");
		//输入出发站
		WebElement weblementElement = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromCity']"));
		weblementElement.clear();
		weblementElement.sendKeys("银川");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
		ss.takeSreenshot();
		log.logInfo("输入出发站，且停留3秒钟，截图");
		//输入终点站
		WebElement webElement = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='toCity']"));
		webElement.clear();
		webElement.sendKeys("南阳");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		ss.takeSreenshot();
		//输入当前日期的七天后日期
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DAY_OF_YEAR, 7);
		Date dt1 = rightNow.getTime();
		String reStr = formatter.format(dt1);
		WebElement webelemt = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromDate']"));
		webelemt.clear();
		webelemt.sendKeys(reStr);
		ss.takeSreenshot();
		//点击搜索
		WebElement element = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//button[text()='搜　索']"));
		//断言是否为搜索
		Assert.assertEquals(element.getText(), "搜　索");
		element.click();	
		ss.takeSreenshot();
		//分析搜索结果
		boolean wait = false;
		try {
			wait = new WebDriverWait(driver, 50)
					.until(new ExpectedCondition<Boolean>() {
						WebElement webelement;

						public Boolean apply(WebDriver driver) {
							webelement = driver.findElement(By.xpath(".//*[@id='progTip']/span"));
							log.logInfo(webelement.getText());
							return webelement.getText().contains("搜索结束");
						}
					});
		} catch (Exception e) {
			System.out.println("没有出搜索结束页面");
		}	
		System.out.println(wait);
		if (wait){
			try {
				driver.findElement(By.xpath("//*[contains(@id,'itemBar')]//div//span[@class='highlight']/parent::p")).getText().contains("每段航班均需缴纳税费");
			} catch (Exception e) {
				System.out.println("不存在每段航班均需缴纳税费");
				log.logWarn("不存在每段航班均需缴纳税费");
			}
			//点击订票
			List<WebElement> element1 = driver.findElements(By.xpath("//*[contains(@id,'itemBar')]//div//span[@class='highlight']/following::div[@class='a_booking']//span/b"));
			
			int order = (int) Math.round(Math.random() * (element1.size() - 1));
			System.out.println(order);
			Assert.assertEquals(element1.get(order).getText(), "订  票");
			element1.get(order).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			ss.takeSreenshot();
		}else{
			System.out.println("搜索出问题，没达到搜索页面");
			log.logError("搜索出问题，没达到搜索页面");
			ss.takeSreenshot();
		}	
	}
//	public static void main(String[] args) {
//		Day52 day52 =new Day52();
//		day52.startfirefox();
//		day52.inputfromandto("银川","南阳");
//		day52.endfirefox();

//	}

}
