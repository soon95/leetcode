import java.util.Arrays;

public class CanWinNimTest {
	public static void main(String[] args) {
		//
		int n=0;
		//
		System.out.println(canWinNim(n));
		System.out.println(canWinNim_method2(n));
	}
	public static boolean canWinNim(int n) {

		return (n-1)%4<3;
		
	}
	
	public static boolean canWinNim_method2(int n) {
		if (n<=3) {
			return true;
		}
		boolean[] dp=new boolean[n+1];
		
		dp[1]=true;
		dp[2]=true;
		dp[3]=true;
		
		
		for (int i = 4; i <= n; i++) {
			if (!dp[i-1]||!dp[i-2]||!dp[i-3]) {
				dp[i]=true;
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}
