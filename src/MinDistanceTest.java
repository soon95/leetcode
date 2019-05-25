
public class MinDistanceTest {
	public static void main(String[] args) {
		//
		String word1 = "a";// intention
		String word2 = "ab";// execution
		//
		System.out.println(minDistance(word1, word2));
	}
	public static int minDistance(String word1,String word2) {
		char[] w1=word1.toCharArray();
		char[] w2=word2.toCharArray();
		
		int cols = w1.length;
		int rows = w2.length;
		
		if (cols == 0) {
			return rows;
		}
		if (rows == 0) {
			return cols;
		}
		
		int[][] dp = new int[rows][cols];
		boolean flag = (w1[0] == w2[0]);
		dp[0][0] = flag? 0 : 1;
		for (int col = 1; col < cols; col++) {
			if (!flag&&(w1[col] == w2[0])) {
				flag=true;
			}
			dp[0][col] = flag ? col : col+1;
		}
		flag = (w1[0] == w2[0]);
		for (int row = 1; row < rows; row++) {
			if (!flag&&(w1[0] == w2[row])) {
				flag=true;
			}
			dp[row][0] = flag ? row : row+1;
		}
		
		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				if (w2[row] == w1[col]) {
					dp[row][col] = dp[row-1][col-1];
				} else {
					int temp = Math.min(dp[row-1][col-1], Math.min(dp[row-1][col], dp[row][col-1]));
					dp[row][col] = temp+1;
				}
			}
		}
		return dp[rows-1][cols-1];
	}
}
