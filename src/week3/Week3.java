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
		System.out.println("������4ת����Ϊ�ַ���Ϊ��"+string);
		Object obj = (Object) string;
		System.out.println("�����������Ƿ���ȷ��ת���������Ϊ��"+obj.getClass().getSimpleName());
	}
	public static void stringtonum(){
		String string = "123456";
		int num = Integer.valueOf(string).intValue();
		System.out.println("���ַ���123456ת��Ϊ����Ϊ��"+num);
		Object obj = (Object) num;
		System.out.println("�����������Ƿ���ȷ��ת���������Ϊ��"+obj.getClass().getSimpleName());
	}
	public static void random(){
		int x=(int)(Math.random()*100);
		System.out.println("��100������һ���������"+x);
		int max = 10000;
		int min = 10;
		Random random = new Random();
		int s = random.nextInt(max-min+1)+min;
		System.out.println("��10��10000����һ���������"+s);
	}
	public static void printnumbynum(){
		String[] string = {"hello","world","hello","baby"};
		for(int i=0;i< string.length;i++){
			System.out.println("��ʼ��һ���ַ������飬ѭ������������"+(i+1)+"���ַ���Ϊ��"+string[i]);
		}
	}
	public static void arrylist(){
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		list.add("hello");
		list.add('a');
		list.add("Iam coming");
		list.add(false);
		list.add(1);
		System.out.println("��������ĸ�Ԫ��,�ֱ�Ϊ��");
		for(Object tmp:list){
			System.out.println(tmp);
		}		
	}
	public static void hashmap(){
		Map map =new HashMap();
		map.put("�Ա�", "Ů");
		map.put("���", "163");
		map.put("����", "dsy");
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
		System.out.println("iteratorѭ�����:");
		 while(it.hasNext()){
			   System.out.print(it.next() + ",");
			  }
        }
	
}
