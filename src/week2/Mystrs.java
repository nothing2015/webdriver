
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
                //sum为共包含a的个数
                sum += 1;
                if(sum == 2){
                    x = i+1;
                }
                if(sum == 3){
                    y = i;
               }              
            }
        }
        //newstrsString 为第2个与第3个a间的字符串
        String newstrsString = strs.substring(x, y);
        //updatestringString把第二个a换成1后的字符串
        String updatestringString = strs.substring(0,x-1) +"1"+strs.substring(x,strs.length());
        //把所有的a替换成b
        String changeallb = strs.replaceAll("a", "b");
        System.out.println("共包含a的个数为:"+sum);
        System.out.println("第2个与第3个a间的字符串为:"+newstrsString);
        System.out.println("把第二个a换成1后为:"+updatestringString);
        System.out.println("把所有的a替换成b成后为："+changeallb);      
    }
}
