package week4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Readandwrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readandwritefile("files");

	}
	public static void readandwritefile(String filepath) throws IOException{
		File file = new File(filepath);
		//如果是文件就写入其路径到文件
		if(file.isFile()){
			//true表示追加
			FileWriter fileWriter=new FileWriter(filepath, true);
			fileWriter.write(file.toString()+"\n");
			fileWriter.close();
		}
		if(file.isDirectory()){
			String[] filenames = file.toString().split("\\"); 
			String filename = filenames[(filenames.length)-1]; 
			System.out.println(filename);
//			String newfilename = filepath+"\\"+filename;
//			File newfile =new File(newfilename);
//			newfile.createNewFile();
			
		}
	}
}
