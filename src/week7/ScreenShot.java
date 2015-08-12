package week7;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public WebDriver driver;
	public ScreenShot(WebDriver driver){
		this.driver =driver;
	}
	private void takeScreenshot(String screenPath){
		try{
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(screenPath));
		}catch (IOException e){
			System.out.println("Screen shot error:"+screenPath);
		}
	}
	public void takeSreenshot(){
		//格式化当前时间作为截图文件名
		Date curDate = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
		String str = dateFormat.format(curDate);
		String screenName = String.valueOf(str+".jpg");
		File dir = new File("test-output/snapshot");
		if(!dir.exists()){
			dir.mkdirs();
		}
		String screenPath = dir.getAbsolutePath()+"/"+screenName;
		this.takeScreenshot(screenPath);
	}

}
