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
		//ѡ�񵥳�
		dp.sng();
		log.logInfo("ѡ�񵥳�");
		//��ͼ
		ss.takeSreenshot();
		log.logInfo("���̽�ͼ");
		//�������վ
		dp.from("����");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
		ss.takeSreenshot();
		log.logInfo("�������վ����ͣ��3���ӣ���ͼ");
		//�����յ�վ
		dp.to("����");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		ss.takeSreenshot();
		//���뵱ǰ���ڵ����������
		dp.date();
		ss.takeSreenshot();
		//�������
		dp.search();
		ss.takeSreenshot();
		//�����������
		boolean wait = false;
		wait = dp.searchend();
		if (wait){
				dp.flight();
			//�����Ʊ
			dp.order();
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
//	public static void main(String[] args){
//		Day8 day8 = new Day8();
//		day8.startfirefox();
//		day8.inputfromandto();
//		day8.endfirefox();
//		
//	}

}
