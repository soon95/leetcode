import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class GetPermutationTest {
	public static void main(String[] args) {
		//
		int n=4;
		int k=9;
		//
		System.out.println(getPermutation(n, k));
	}
	public static String getPermutation(int n,int k) {
		StringBuffer sb=new StringBuffer();
		
		ArrayList<Integer> nums=new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}
		
		int[] digits=new int[n+1];
		int digit=n;
		int temp;
		while(digit>0) {
			temp=factorial(digit-1);
			digits[digit]=(k-1)/temp+1;
			k=(k-1)%temp+1;
			
			digit--;
		}
		
		System.out.println(Arrays.toString(digits));
		
		for (int i = n; i > 0; i--) {
			sb.append(String.valueOf(nums.get(digits[i]-1)));
			nums.remove(digits[i]-1);
		}
		
		return sb.toString();
	}
	public static int factorial(int x) {
		int ans=1;
		while(x>1) {
			ans*=x--;
		}
		return ans;
	}
}
