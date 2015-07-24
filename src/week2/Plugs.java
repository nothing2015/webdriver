package week2;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Plugs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chromepl();

	}
	public static void chromepl(){
		System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		//去掉证书提示
		options.addArguments("--test-type");
		File file =new File("D:\\User Data");
		options.addArguments("user-data-dir="+file.getAbsolutePath());
		WebDriver driver =new ChromeDriver(options);
		driver.get("http://www.baidu.com");
	}
	public static void iepl(){
		System.setProperty("webdriver.id.driver", "files/IEDriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//IE默认的就是开启保护模式，要么手动在浏览器中关闭保护模式，要么加上下面这一句即可
		capabilities.setCapability("ignoreProtectedModeSettings", true);
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://www.baidu.com");
		driver.close();
	}

}
