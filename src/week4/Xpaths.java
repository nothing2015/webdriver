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
		//input输入文本
		driver.findElement(By.xpath("//div[@id='input']/input")).sendKeys("dsy");
		//清除文本
		driver.findElement(By.cssSelector("#user")).clear();
//		driver.findElement(By.xpath("//div[@id='input']/input")).clear();
		//点击link按钮
//		driver.findElement(By.xpath("//div[@id='link']/a")).click();
		//选择下拉菜单select
		WebElement element = driver.findElement(By.cssSelector("select"));
		Select select = new Select(element);
		//通过索引选择
		select.selectByIndex(1);
		//通过value值选择，这里全部为小写
		select.selectByValue("audi");
		//通过文本选择，这里大小写要正确
		select.selectByVisibleText("Opel");
		//获取当前选择项的文本名字
		String selectnow = select.getFirstSelectedOption().getText();
		//获取当前选中项个数
		int selects = select.getAllSelectedOptions().size();
		//获取所有选择的个数
		int selectsnum = select.getOptions().size();
		//遍历整个选择项
		for(int i=0;i<selectsnum;i++){
			select.selectByIndex(i);
		}
		//选择radioBox中的各个元素
		driver.findElement(By.xpath("//div[@id='radio']/input[@class='Volvo']")).click();
		List<WebElement> boxs = driver.findElements(By.cssSelector("#radio>input[name='identity']"));
		boxs.get(1).click();
		int num = boxs.size();
		for(int i=0;i<num;i++){
			boxs.get(i).click();
		}
		boolean selectdd = boxs.get(3).isSelected();
		System.out.println(selectdd);
		//button按钮的选择
		WebElement webelement = driver.findElement(By.className("button"));
		boolean button = webelement.isEnabled();
		if (button){
			element.click();
		}else{
			System.out.print("按钮不可点击");
		}
		driver.close();
	}

}
