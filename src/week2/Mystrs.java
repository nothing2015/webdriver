
package week2;
public class Mystrs {
    public static void main(String[] args) {
        String strs = "abcafgakkaal";
        dodata(strs);
    }
    public static void dodata(String strs){
        char c = 'a';
        int sum = 0;
        int x = 0, y = 0;
        char[] chars = strs.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(c == chars[i]){
                //sumΪ������a�ĸ���
                sum += 1;
                if(sum == 2){
                    x = i+1;
                }
                if(sum == 3){
                    y = i;
               }              
            }
        }
        //newstrsString Ϊ��2�����3��a����ַ���
        String newstrsString = strs.substring(x, y);
        //updatestringString�ѵڶ���a����1����ַ���
        String updatestringString = strs.substring(0,x-1) +"1"+strs.substring(x,strs.length());
        //�����е�a�滻��b
        String changeallb = strs.replaceAll("a", "b");
        System.out.println("������a�ĸ���Ϊ:"+sum);
        System.out.println("��2�����3��a����ַ���Ϊ:"+newstrsString);
        System.out.println("�ѵڶ���a����1��Ϊ:"+updatestringString);
        System.out.println("�����е�a�滻��b�ɺ�Ϊ��"+changeallb);      
    }
}
