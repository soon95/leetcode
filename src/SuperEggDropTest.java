
public class SuperEggDropTest {
	public static void main(String[] args) {
		//
		int k=8;
		int n=5000;
		//
		System.out.println(superEggDrop_method2(k, n));
	}
	public static int superEggDrop_method1(int eggs,int heights) {
		
		int[][] dp=new int[eggs+1][heights+1];
		for (int i = 1; i <= eggs; i++) {
			dp[i][1]=1;
		}
		for (int i = 1; i <= heights; i++) {
			dp[1][i]=i;
		}
		for (int height = 2; height <= heights; height++) {
			for (int egg = 2; egg <= eggs; egg++) {
				int temp=Integer.MAX_VALUE;
				for (int i = 1; i <= height; i++) {
					temp=Math.min(temp, 1+Math.max(dp[egg-1][i-1], dp[egg][height-i]));
				}
				dp[egg][height]=temp;
			}
		}
		return dp[eggs][heights];
	}
	public static int superEggDrop_method2(int k,int n) {
		int[][] dp=new int[k+1][n+1];
		
		for (int m = 1; m <= n; m++) {//m次
			dp[0][m]=0;
			for (int i = 1; i <= k; i++) {
				dp[i][m]=dp[i][m-1]+dp[i-1][m-1]+1;
				if (dp[i][m]>=n) {
					return m;
				}
			}
			
		}
		return n;
	}
}
