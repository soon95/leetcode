import java.util.Arrays;

public class MyPowTest {
	public static void main(String[] args) {
		//
		double x=2.1;
		int n=-1;
		//
		System.out.println(myPow(x, n));
//		System.out.println(Arrays.toString(decompose(n)));
	}
	public static double myPow(double x,int n) {
		if (n==0) {
			return 1.0;
		}
		boolean sign;
		if (n>0) {
			sign=true;
		} else {
			sign=false;
			n=-n;
		}
		double ans=1;
		
		boolean[] decom=decompose(n);
		int length=decom.length;
		
		double[] mid=new double[length];
		mid[0]=x;
		for (int i = 1; i < length; i++) {
			mid[i]=mid[i-1]*mid[i-1];
		}
		
		for (int i = 0; i < length; i++) {
			if (decom[i]) {
				ans*=mid[i];
			}
		}
		if (sign) {
			return ans;
		} else {
			return 1/ans;
		}
	}
	public static boolean[] decompose(int n) {
		int temp=2;
		int count=1;
		if (n==1) {
			boolean[] decom= {true};
			return decom;
		}
		
		
		//求最高次
		while(n/temp>1) {
			temp*=2;
			count++;
		}
		n%=temp;
		
		boolean[] decom=new boolean[count+1];
		decom[count]=true;
		
		while(n>1) {
			while(n/temp!=1) {
				temp/=2;
				count--;
			}
			n%=temp;
			decom[count]=true;
		}
		if (n==1) {
			decom[0]=true;
		}
		return decom;
	}
	
}
