import java.util.Arrays;

public class NO132_MinCutTest {
	public static void main(String[] args) {
		//
		String s="cabababcbc";
		//
		System.out.println(minCut(s));
	}
	public static int minCut(String s) {
		char[] chs=s.toCharArray();
		int len=chs.length;
		if (len==0) {
			return 0;
		}
		
		int[][] dp=new int[len][len];
		
		for (int row = len-2; row >=0 ; row--) {
			for (int col = row+1; col < len; col++) {
				if (chs[row]==chs[col]&&dp[row+1][col-1]==0) {
					dp[row][col]=dp[row+1][col-1];
				} else {
					int temp=Integer.MAX_VALUE;
					for (int i = row; i < col; i++) {
						temp=Math.min(temp, dp[row][i]+dp[i+1][col]+1);
					}
					dp[row][col]=temp;
				}
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[0][len-1];
	}
}
