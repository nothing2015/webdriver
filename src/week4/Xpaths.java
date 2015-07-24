package week4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class Xpaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///E:/%E7%82%BC%E6%95%B0%E6%88%90%E9%87%91/selenium/%E7%AC%AC%E4%B8%89%E5%91%A8/demo.html");
		//input�����ı�
		driver.findElement(By.xpath("//div[@id='input']/input")).sendKeys("dsy");
		//����ı�
		driver.findElement(By.cssSelector("#user")).clear();
//		driver.findElement(By.xpath("//div[@id='input']/input")).clear();
		//���link��ť
//		driver.findElement(By.xpath("//div[@id='link']/a")).click();
		//ѡ�������˵�select
		WebElement element = driver.findElement(By.cssSelector("select"));
		Select select = new Select(element);
		//ͨ������ѡ��
		select.selectByIndex(1);
		//ͨ��valueֵѡ������ȫ��ΪСд
		select.selectByValue("audi");
		//ͨ���ı�ѡ�������СдҪ��ȷ
		select.selectByVisibleText("Opel");
		//��ȡ��ǰѡ������ı�����
		String selectnow = select.getFirstSelectedOption().getText();
		//��ȡ��ǰѡ�������
		int selects = select.getAllSelectedOptions().size();
		//��ȡ����ѡ��ĸ���
		int selectsnum = select.getOptions().size();
		//��������ѡ����
		for(int i=0;i<selectsnum;i++){
			select.selectByIndex(i);
		}
		//ѡ��radioBox�еĸ���Ԫ��
		driver.findElement(By.xpath("//div[@id='radio']/input[@class='Volvo']")).click();
		List<WebElement> boxs = driver.findElements(By.cssSelector("#radio>input[name='identity']"));
		boxs.get(1).click();
		int num = boxs.size();
		for(int i=0;i<num;i++){
			boxs.get(i).click();
		}
		boolean selectdd = boxs.get(3).isSelected();
		System.out.println(selectdd);
		//button��ť��ѡ��
		WebElement webelement = driver.findElement(By.className("button"));
		boolean button = webelement.isEnabled();
		if (button){
			element.click();
		}else{
			System.out.print("��ť���ɵ��");
		}
		driver.close();
	}

}
