
public class NumDistinctTest {
	public static void main(String[] args) {
		//
		String s = "babgbag";
		String t = "bag";
		//
		System.out.println(numDistinct_method1(s, t));
	}

	public static int numDistinct_method1(String s, String t) {
		char[] arr = s.toCharArray();
		char[] sub = t.toCharArray();

		if (arr.length < sub.length) {
			return 0;
		}

		int cols = arr.length;
		int rows = sub.length;

		int[][] dp = new int[rows][cols];

		int count = 0;
		for (int col = 0; col < cols; col++) {
			if (arr[col] == sub[0]) {
				count++;
			}
			dp[0][col] = count;
		}

		for (int row = 1; row < rows; row++) {
			for (int col = row; col < cols; col++) {
				if (arr[col] == sub[row]) {
					dp[row][col] = dp[row - 1][col - 1] + dp[row][col - 1];
				} else {
					dp[row][col] = dp[row][col - 1];
				}

			}
		}

		return dp[rows - 1][cols - 1];
	}

	static int count;

	public static int numDistinct_method2(String s, String t) {
		char[] arr = s.toCharArray();
		char[] sub = t.toCharArray();

		count = 0;
		distinct(arr, sub, 0, 0);

		return count;
	}

	private static void distinct(char[] arr, char[] sub, int i, int j) {
		if (j == sub.length) {
			count++;
			return;
		}
		if (i >= arr.length) {
			return;
		}

		if (arr[i] == sub[j]) {
			distinct(arr, sub, i + 1, j);
			distinct(arr, sub, i + 1, j + 1);
		} else {
			distinct(arr, sub, i + 1, j);
		}
		return;
	}

}
