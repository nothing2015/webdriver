package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Iterator;


public class Week3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numtostring();
		stringtonum();
		random();
		printnumbynum();
		arrylist();
		hashmap();
		arrylist2();
	}
	public static void numtostring(){
		int num = 4;
		String string = Integer.toString(num); 
		System.out.println("把数字4转换成为字符串为："+string);
		Object obj = (Object) string;
		System.out.println("测试下类型是否正确，转化后的类型为："+obj.getClass().getSimpleName());
	}
	public static void stringtonum(){
		String string = "123456";
		int num = Integer.valueOf(string).intValue();
		System.out.println("把字符串123456转化为数字为："+num);
		Object obj = (Object) num;
		System.out.println("测试下类型是否正确，转化后的类型为："+obj.getClass().getSimpleName());
	}
	public static void random(){
		int x=(int)(Math.random()*100);
		System.out.println("从100中生成一个随机数："+x);
		int max = 10000;
		int min = 10;
		Random random = new Random();
		int s = random.nextInt(max-min+1)+min;
		System.out.println("从10到10000生成一个随机数："+s);
	}
	public static void printnumbynum(){
		String[] string = {"hello","world","hello","baby"};
		for(int i=0;i< string.length;i++){
			System.out.println("初始化一个字符串数组，循环输出结果，第"+(i+1)+"个字符串为："+string[i]);
		}
	}
	public static void arrylist(){
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		list.add("hello");
		list.add('a');
		list.add("Iam coming");
		list.add(false);
		list.add(1);
		System.out.println("我添加了四个元素,分别为：");
		for(Object tmp:list){
			System.out.println(tmp);
		}		
	}
	public static void hashmap(){
		Map map =new HashMap();
		map.put("性别", "女");
		map.put("身高", "163");
		map.put("姓名", "dsy");
		Set keys = map.keySet();
		for(Object key:keys){
			System.out.println(key+":"+map.get(key));		
		}
	}
	public static void arrylist2(){
		ArrayList list = new ArrayList();
		list.add("hello");
		list.add('a');
		list.add("Iam coming");
		list.add(false);
		list.add(1);
		Iterator it = list.iterator();
		System.out.println("iterator循环输出:");
		 while(it.hasNext()){
			   System.out.print(it.next() + ",");
			  }
        }
	
}
