package week2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Mysavefiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用firefox保存；
		mydefault();
		//使用chrome保存；
		mychromedownload();

	}
	public static void mydefault(){
		ProfilesIni allprofiles = new ProfilesIni();
		FirefoxProfile profile = allprofiles.getProfile("default");
		profile.setPreference("browser.download.folderList", "2");
		profile.setPreference("browser.download.dir", "E:\\selenium");
		profile.setPreference("browser.download.useDownloadDir", true);
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream, application/vnd.ms-excel, text/csv, application/zip,application/exe"); 
		WebDriver driver = new FirefoxDriver(profile);
		Navigation navigation = driver.navigate();
		navigation.to("http://url.xdowns.com/down/chromeDriver%202.14@67_136971.exe");
//		driver.get("http://www.baidu.com");
		driver.close();
	}
	public static void mychromedownload(){
		System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ChromeOptions chromeOptions =new ChromeOptions();
		chromeOptions.addEncodedExtensions("c:\\selenium");
		driver.get("http://url.xdowns.com/down/chromeDriver%202.14@67_136971.exe");
		driver.close();
		
	}
}
