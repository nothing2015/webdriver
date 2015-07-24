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
	//����������firebug���
	public static void myFirefox(){
		//����firebug���
		File file = new File("files/firebug-1.8.4.xpi");
		FirefoxProfile firefoxprofile = new FirefoxProfile();
		try{
			firefoxprofile.addExtension(file);	
		}catch(IOException e){
			e.printStackTrace();
		}
		//����firebug�������
		firefoxprofile.setPreference("extension.firebug.currentVersion", "1.8.4");
		//����http����ʽĬ����0ֱ�����ӣ�1���ֹ����ô���
		firefoxprofile.setPreference("network.proxy.type", 1);
		firefoxprofile.setPreference("network.proxy.http","192.168.1.22");
		firefoxprofile.setPreference("network.proxy.http_port", 8080);
		firefoxprofile.updateUserPrefs(file);
		//����firefox
		WebDriver webdriver = new FirefoxDriver(firefoxprofile);
		webdriver.get("http://www.baidu.com");
		//ע������ Driver.Quit()�˳�driver��Driver.Close()�رյ�ǰ���ڣ�
		webdriver.close();
	}
	public static void mychrome(){
		//����chrome��·��
		System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
		//���ز��
		ChromeOptions options = new ChromeOptions();
		File file = new File("files/Video-Sorter-for-YouTube_v1.1.2.crx");
		options.addExtensions(file);
		//����chrome�����
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.quit();		
	}
	public static void myie(){
		//ie�޲���ɼ���
		System.setProperty("webdriver.ie.driver", "files/IEDriver.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://www.baidu.com");
		driver.close();	
	}

}
