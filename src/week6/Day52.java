package week6;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day52 {
	public WebDriver driver;
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
		//ѡ�񵥳�
		driver.findElement(By.id("searchTypeSng")).click();
		//�������վ
		WebElement weblementElement = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromCity']"));
		weblementElement.clear();
		weblementElement.sendKeys("����");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
		//�����յ�վ
		WebElement webElement = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='toCity']"));
		webElement.clear();
		webElement.sendKeys("����");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//���뵱ǰ���ڵ����������
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DAY_OF_YEAR, 7);
		Date dt1 = rightNow.getTime();
		String reStr = formatter.format(dt1);
		WebElement webelemt = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromDate']"));
		webelemt.clear();
		webelemt.sendKeys(reStr);
//		webelemt.click();
		//�������
		WebElement element = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//button[text()='�ѡ���']"));
		element.click();		
		//�����������
		boolean wait = false;
		try {
			wait = new WebDriverWait(driver, 50)
					.until(new ExpectedCondition<Boolean>() {
						WebElement webelement;

						public Boolean apply(WebDriver driver) {
							webelement = driver.findElement(By.xpath(".//*[@id='progTip']/span"));
							System.out.println(webelement.getText());
							return webelement.getText().contains("��������");
						}
					});
		} catch (Exception e) {
			System.out.println("û�г���������ҳ��");
		}	
		System.out.println(wait);
		if (wait){
			try {
				driver.findElement(By.xpath("//*[contains(@id,'itemBar')]//div//span[@class='highlight']/parent::p")).getText().contains("ÿ�κ���������˰��");
			} catch (Exception e) {
				System.out.println("������ÿ�κ���������˰��");
			}
			//�����Ʊ
			List<WebElement> element1 = driver.findElements(By.xpath("//*[contains(@id,'itemBar')]//div//span[@class='highlight']/following::div[@class='a_booking']//span/b"));
			int order = (int) Math.round(Math.random() * (element1.size() - 1));
			System.out.println(order);
			element1.get(order).click();
		}else{
			System.out.println("���������⣬û�ﵽ����ҳ��");
		}	
	}
//	public static void main(String[] args) {
//		Day52 day52 =new Day52();
//		day52.startfirefox();
//		day52.inputfromandto("����","����");
//		day52.endfirefox();

//	}

}
