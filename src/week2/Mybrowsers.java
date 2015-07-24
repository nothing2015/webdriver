package week2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Mybrowsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myFirefox();
//		mychrome();
//		myie();

	}
	//启动并加载firebug插件
	public static void myFirefox(){
		//加载firebug插件
		File file = new File("files/firebug-1.8.4.xpi");
		FirefoxProfile firefoxprofile = new FirefoxProfile();
		try{
			firefoxprofile.addExtension(file);	
		}catch(IOException e){
			e.printStackTrace();
		}
		//设置firebug插件属性
		firefoxprofile.setPreference("extension.firebug.currentVersion", "1.8.4");
		//设置http代理方式默认是0直接连接，1是手工设置代理
		firefoxprofile.setPreference("network.proxy.type", 1);
		firefoxprofile.setPreference("network.proxy.http","192.168.1.22");
		firefoxprofile.setPreference("network.proxy.http_port", 8080);
		firefoxprofile.updateUserPrefs(file);
		//启动firefox
		WebDriver webdriver = new FirefoxDriver(firefoxprofile);
		webdriver.get("http://www.baidu.com");
		//注意这里 Driver.Quit()退出driver；Driver.Close()关闭当前窗口；
		webdriver.close();
	}
	public static void mychrome(){
		//设置chrome打开路径
		System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
		//加载插件
		ChromeOptions options = new ChromeOptions();
		File file = new File("files/Video-Sorter-for-YouTube_v1.1.2.crx");
		options.addExtensions(file);
		//启动chrome浏览器
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.quit();		
	}
	public static void myie(){
		//ie无插件可加载
		System.setProperty("webdriver.ie.driver", "files/IEDriver.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://www.baidu.com");
		driver.close();	
	}

}
