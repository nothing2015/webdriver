package week8;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import week7.ScreenShot;

public class Day8 {
	public WebDriver driver = new FirefoxDriver();
	public Log log =new Log();
	Day8demopag dp = new Day8demopag(driver);
	ScreenShot ss = new ScreenShot(driver);
	@BeforeMethod
	public void startfirefox(){
//		driver= new FirefoxDriver();
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
		dp.sng();
		log.logInfo("选择单程");
		//截图
		ss.takeSreenshot();
		log.logInfo("单程截图");
		//输入出发站
		dp.from("银川");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
		ss.takeSreenshot();
		log.logInfo("输入出发站，且停留3秒钟，截图");
		//输入终点站
		dp.to("南阳");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		ss.takeSreenshot();
		//输入当前日期的七天后日期
		dp.date();
		ss.takeSreenshot();
		//点击搜索
		dp.search();
		ss.takeSreenshot();
		//分析搜索结果
		boolean wait = false;
		wait = dp.searchend();
		if (wait){
				dp.flight();
			//点击订票
			dp.order();
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
//	public static void main(String[] args){
//		Day8 day8 = new Day8();
//		day8.startfirefox();
//		day8.inputfromandto();
//		day8.endfirefox();
//		
//	}

}
