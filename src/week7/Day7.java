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
		//ѡ�񵥳�
		driver.findElement(By.id("searchTypeSng")).click();
		log.logInfo("ѡ�񵥳�");
		//��ͼ
		ScreenShot ss = new ScreenShot(driver);
		ss.takeSreenshot();
		log.logInfo("���̽�ͼ");
		//�������վ
		WebElement weblementElement = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromCity']"));
		weblementElement.clear();
		weblementElement.sendKeys("����");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
		ss.takeSreenshot();
		log.logInfo("�������վ����ͣ��3���ӣ���ͼ");
		//�����յ�վ
		WebElement webElement = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='toCity']"));
		webElement.clear();
		webElement.sendKeys("����");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		ss.takeSreenshot();
		//���뵱ǰ���ڵ����������
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DAY_OF_YEAR, 7);
		Date dt1 = rightNow.getTime();
		String reStr = formatter.format(dt1);
		WebElement webelemt = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//input[@name='fromDate']"));
		webelemt.clear();
		webelemt.sendKeys(reStr);
		ss.takeSreenshot();
		//�������
		WebElement element = driver.findElement(By.xpath("//div[@id='js_flighttype_tab_domestic']//button[text()='�ѡ���']"));
		//�����Ƿ�Ϊ����
		Assert.assertEquals(element.getText(), "�ѡ���");
		element.click();	
		ss.takeSreenshot();
		//�����������
		boolean wait = false;
		try {
			wait = new WebDriverWait(driver, 50)
					.until(new ExpectedCondition<Boolean>() {
						WebElement webelement;

						public Boolean apply(WebDriver driver) {
							webelement = driver.findElement(By.xpath(".//*[@id='progTip']/span"));
							log.logInfo(webelement.getText());
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
				log.logWarn("������ÿ�κ���������˰��");
			}
			//�����Ʊ
			List<WebElement> element1 = driver.findElements(By.xpath("//*[contains(@id,'itemBar')]//div//span[@class='highlight']/following::div[@class='a_booking']//span/b"));
			
			int order = (int) Math.round(Math.random() * (element1.size() - 1));
			System.out.println(order);
			Assert.assertEquals(element1.get(order).getText(), "��  Ʊ");
			element1.get(order).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			ss.takeSreenshot();
		}else{
			System.out.println("���������⣬û�ﵽ����ҳ��");
			log.logError("���������⣬û�ﵽ����ҳ��");
			ss.takeSreenshot();
		}	
	}
//	public static void main(String[] args) {
//		Day52 day52 =new Day52();
//		day52.startfirefox();
//		day52.inputfromandto("����","����");
//		day52.endfirefox();

//	}

}
