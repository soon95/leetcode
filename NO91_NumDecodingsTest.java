
public class NO91_NumDecodingsTest {
	public static void main(String[] args) {
		//
		String s = "101";
		//
		System.out.println(numDecodings(s));

	}

	public static int numDecodings(String s) {
		int len = s.length();

		int[][] dp = new int[len][len];

		for (int i = 0; i < len; i++) {
			if (Integer.parseInt(s.substring(i, i + 1)) == 0) {
				if (i == 0) {
					return 0;
				} else {
					dp[i][i] = 0;
				}
			} else {
				dp[i][i] = 1;
			}
		}
		for (int row = len - 2; row >= 0; row--) {
			for (int col = row + 1; col < len; col++) {
				if (Integer.parseInt(s.substring(col, col + 1)) == 0) {
					if (Integer.parseInt(s.substring(col - 1, col + 1)) > 26
							|| Integer.parseInt(s.substring(col - 1, col + 1)) == 0) {
						return 0;
					} else {
						dp[row][col] = col - 2 >= row ? dp[row][col - 2] : 1;
					}
				} else if (Integer.parseInt(s.substring(col - 1, col + 1)) <= 26
						&& (Integer.parseInt(s.substring(col - 1, col)) != 0)) {
					dp[row][col] = col - 2 >= row ? dp[row][col - 1] + dp[row][col - 2] : dp[row][col - 1] + 1;
				} else {
					dp[row][col] = dp[row][col - 1];
				}

			}
		}

		return dp[0][len - 1];
	}
}
