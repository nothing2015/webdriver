package week6;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day6 {
	WebDriver driver;
	
	
	@DataProvider(name = "sendkeysdata")
	public Object[][] data1(){
		return new Object[][]{{"ta"},{"ni"},{"wo"}};
	}
	@DataProvider
	public Object[][] data2(){
		return new Object[][]{{"1"},{"2"},{"3"}};
	}
	@BeforeClass
	//��firefox�����
	public void newdriver(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("newdriver");
	}
	@BeforeMethod
	//��url
	public void openurl(){
		driver.get("http://www.baidu.com");
		System.out.println("openurl");
	}
	@Test(dataProvider="sendkeysdata")
	//�����ѯ�ַ������
	public void sendclick(String info){
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys(info);
		driver.findElement(By.id("su")).click();
		System.out.println("sendclick");
	}
	@Test(dataProvider="data2")
	//�������
	public void anylyresult(String info){
		List<WebElement> element = driver.findElements(By.xpath(".//*[@id='content_left']//h3/a"));
		if (element.size()!=0){
			element.get(0).click();
		}
		System.out.println(info);
	}
	@Test
	public void test(){
		System.out.println("test2");
	}

	@AfterClass
	//�رմ���
	public void close(){
		driver.close();
		System.out.println("close");
	}
//	@AfterClass
	//�ر�driver
//	public void quit(){
//		driver.quit();
//		System.out.println("quit");
//	}

}