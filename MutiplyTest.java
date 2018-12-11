
public class MutiplyTest {
	public static void main(String[] args) {
		//
		String num1="11";
		String num2="10";
		//
		System.out.println(mutiply(num1, num2));
		
	}
	
	public static String mutiply(String num1,String num2) {
		int len1=num1.length();
		int len2=num2.length();
		int lenMuti=len1+len2;
		
		int[] arr1=new int[len1];
		int[] arr2=new int[len2];
		
		//数字反转
		for (int i = 0; i < len1; i++) {
			arr1[i]=num1.charAt(len1-1-i)-'0';
		}
		for (int i = 0; i < len2; i++) {
			arr2[i]=num2.charAt(len2-1-i)-'0';
		}
		
		int[] muti=new int[lenMuti];
		
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				muti[i+j]+=arr1[i]*arr2[j];
			}
		}
		
		//进位
		for (int i = 0; i < lenMuti-1; i++) {
			muti[i+1]+=muti[i]/10;
			muti[i]=muti[i]%10;
		}
		
		String ans="";
		
		int index=lenMuti-1;
		while (index>=0&&muti[index]==0) {
			index--;
		}
		if (index==-1) {
			return "0";
		}
		
		for (; index >=0 ; index--) {
			ans=""+ans+muti[index];
		}
		
		return ans;
	}
}
