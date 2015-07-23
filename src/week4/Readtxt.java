package week4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;





public class Readtxt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		read();
	}
	public static void read() throws IOException{
		File file = new File("files\\test.txt");
		String encoding="GBK";
		if (file.isFile()&& file.exists()){
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while((lineTxt = bufferedReader.readLine()) != null){
                System.out.println(lineTxt);
            }
            read.close();
			
		}else{
			System.out.println("找不到指定的文件");
		}

	}

}
