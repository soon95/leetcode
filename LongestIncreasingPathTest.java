
public class LongestIncreasingPathTest {
	public static void main(String[] args) {
		//
		int[][] nums = {{9,9,4},
						{6,6,8},
						{2,1,1}};
		//
		System.out.println(longestIncreasingPath(nums));
	}
	
	public static int longestIncreasingPath(int[][] matrix) {
		int rows = matrix.length;
		if (rows == 0) {
			return 0;
		}
		
		int cols = matrix[0].length;
		
		int[][] dp = new int[rows][cols];
		
		int max=0;
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				int temp = dfs(matrix, dp, row, col);
				max = Math.max(max, temp);
			}
		}
		
		return max;
	}
	private static int dfs(int[][] matrix, int[][] dp, int row, int col) {
		if (dp[row][col] != 0) {
			return dp[row][col];
		}
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int max=0;
		if (row-1 >=0 && matrix[row-1][col] > matrix[row][col]) {
			int temp = dfs(matrix, dp, row-1, col);
			max = Math.max(max, temp);
		}
		if (col-1 >=0 && matrix[row][col-1] > matrix[row][col]) {
			int temp = dfs(matrix, dp, row, col-1);
			max = Math.max(max, temp);
		}
		if (row+1 < rows && matrix[row+1][col] > matrix[row][col]) {
			int temp=dfs(matrix, dp, row+1, col);
			max = Math.max(max, temp);
		}
		if (col+1 < cols && matrix[row][col+1] > matrix[row][col]) {
			int temp = dfs(matrix, dp, row, col+1);
			max = Math.max(max, temp);
		}
		
		dp[row][col] = max+1;
		return max+1;
	}
}
