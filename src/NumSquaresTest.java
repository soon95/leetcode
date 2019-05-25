
public class NumSquaresTest {
	public static void main(String[] args) {
		//
		int n = 12;
		//
		System.out.println(numSquares(n));
	}
	public static int numSquares(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			if (Math.pow((int)Math.sqrt(i), 2) == i) {
				dp[i] = 1;
			} else {
				int temp = Integer.MAX_VALUE;
				for (int j = 1; j <= i/2; j++) {
					temp = Math.min(temp, dp[j]+dp[i-j]);
				}
				dp[i] = temp;
			}
		}
		return dp[n];
	}
}
