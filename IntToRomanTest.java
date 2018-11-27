import java.util.Arrays;

public class IntToRomanTest {
	public static void main(String[] args) {
		int num=2994;
		System.out.println(intToRoman(num));
	}
	public static String intToRoman(int num) {
		String ans="";
		
		char[] romanChar= {'I','V','X','L','C','D','M'};
		int[] value= {1,5,10,50,100,500,1000};
		int length=value.length;
		
		int[] sep=new int[length];
		
		for (int i = length-1; i >= 0; i--) {
			sep[i]=num/value[i];
			num%=value[i];
		}
		
//		System.out.println(num);
//		System.out.println(Arrays.toString(sep));
//		System.out.println(Arrays.toString(value));
		
		for (int i = 0; i < sep.length-1; i=i+2) {
			if (sep[i]==4) {
				if (sep[i+1]==0) {
					ans=romanChar[i+1]+ans;
					ans=romanChar[i]+ans;
				} else if (sep[i+1]==1) {
					ans=romanChar[i+2]+ans;
					ans=romanChar[i]+ans;
				}
			} else {
				for (int j = 0; j < sep[i]; j++) {
					ans=romanChar[i]+ans;
				}
				for (int j = 0; j < sep[i+1]; j++) {
					ans=romanChar[i+1]+ans;
				}
			}
		}
		for (int i = 0; i < sep[length-1]; i++) {
			ans=romanChar[length-1]+ans;
		}
		
		return ans;
	}
}
