
public class UniquePathWithObstaclesTest {
	public static void main(String[] args) {
		//
		int[][] grid = {{1,0},
						{0,0}};
		System.out.println(uniquePathWithObstacles(grid));
		//
		
	}
	public static int uniquePathWithObstacles(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		
		if (rows == 0 || cols == 0) {
			return 0;
		}
		
		int[][] dp = new int[rows][cols];
		
		boolean flag = false;
		for (int col = cols-1; col >= 0; col--) {
			if (!flag && grid[rows-1][col] == 1) {
				flag=true;
			}
			if (flag) {
				dp[rows-1][col] = 0;
			} else {
				dp[rows-1][col] = 1;				
			}
		}		
		
		flag=false;
		for (int row = rows-1; row >= 0; row--) {
			if (!flag && grid[row][cols-1] == 1) {
				flag=true;
			}
			if (flag) {
				dp[row][cols-1] = 0;
			} else {
				dp[row][cols-1] = 1;				
			}
		}
		
		for (int row = rows-2; row >= 0; row--) {
			for (int col = cols-2; col >= 0; col--) {
				if (grid[row][col] == 1) {
					dp[row][col] = 0;
				} else {
					int temp = 0;
					if (grid[row+1][col] != 1) {
						temp += dp[row+1][col];
					}
					if (grid[row][col+1] != 1) {
						temp += dp[row][col+1];
					}
					
					dp[row][col] = temp;
				}
				
			}
		}

		return dp[0][0];
		
	}
}
