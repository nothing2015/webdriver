package week7;

public class Maopao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number = {9,3,4,3,2,6};
		int temp = 0;
		for (int i=0;i<number.length;i++){
			for(int j=i+1;j<number.length;j++){
				if(number[i]<number[j]){
					temp= number[i];
					number[i]=number[j];
					number[j]=temp;
				}
			}
		}
		for(int i =0;i<number.length;i++){
			System.out.println(number[i]);
		}
	}
}
