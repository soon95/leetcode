
public class MinPathSumTest {
	public static void main(String[] args) {
		//
		int[][] grid = {{1,3,1},
						{1,5,1},
						{4,2,1}};
		//
		System.out.println(minPathSum(grid));
	}
	public static int minPathSum(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		
		int[][] dp = new int[rows][cols];
		dp[rows-1][cols-1] = grid[rows-1][cols-1];
		for (int i = cols-2; i >= 0; i--) {
			dp[rows-1][i] = dp[rows-1][i+1]+grid[rows-1][i];
		}
		for (int i = rows-2; i >= 0; i--) {
			dp[i][cols-1] = dp[i+1][cols-1]+grid[i][cols-1];
		}
		
		for (int row = rows-2; row >= 0; row--) {
			for (int col = cols-2; col >= 0; col--) {
				dp[row][col] = Math.min(dp[row][col+1], dp[row+1][col])+grid[row][col];
			}
		}
		return dp[0][0];
	}
	
	/*
	 * 递归
	 */
	public static int minPathSum_method2(int[][] grid) {
		return dfs(grid, 0, 0);
	}
	public static int dfs(int[][] grid, int row, int col) {
		if (row >= grid.length || col >= grid[0].length) {
			return Integer.MAX_VALUE;
		}
		if (row == grid.length-1 && col == grid[0].length-1) {
			return grid[row][col];
		}
		int min=Math.min(dfs(grid, row+1, col), dfs(grid, row, col+1));
		return min+grid[row][col];
	}
}
