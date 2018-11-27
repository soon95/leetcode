
public class IsHappyTest {
	public static void main(String[] args) {
		//
		int n=19;
		//
		System.out.println(isHappy(n));
		
	}
	public static boolean isHappy(int n) {
		boolean ans=false;
		int num=1000;
		int temp=n;
		while(num!=0) {
			temp=transform(temp);
			if (temp==1) {
				ans=true;
				break;
			}
			num--;
		}
		
		return ans;
	}
	public static int transform(int n) {
		int sum=0;
		while(n>9) {
			sum+=Math.pow(n%10, 2);
			n/=10;
		}
		sum+=Math.pow(n, 2);
		return sum;
	}
}
