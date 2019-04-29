
public class CalculateMinmumHPTest {
	public static void main(String[] args) {
		//
		int[][] dungeon = {{-2,-3,3},
						   {-5,-10,1},
						   {10,30,-5}};
		//
		System.out.println(calculateMinmumHP(dungeon));
	}
	
	public static int calculateMinmumHP(int[][] dungeon) {
		
		int rows = dungeon.length;
		int cols = dungeon[0].length;
		
		
		int[][] dp = new int[rows][cols];
		
		dp[rows-1][cols-1] = dungeon[rows-1][cols-1] < 0 ? dungeon[rows-1][cols-1] : 0;
		
		for (int row = rows-2; row >= 0; row--) {
			dp[row][cols-1] = dungeon[row][cols-1]+dp[row+1][cols-1] < 0 ? dungeon[row][cols-1]+dp[row+1][cols-1] : 0;
		}
		for (int col = cols-2; col >= 0; col--) {
			dp[rows-1][col] = dungeon[rows-1][col]+dp[rows-1][col+1] < 0 ? dungeon[rows-1][col]+dp[rows-1][col+1] : 0;
		}
		
		for (int row = rows-2; row >= 0; row--) {
			for (int col = cols-2; col >= 0; col--) {
				int right = dungeon[row][col]+dp[row][col+1] < 0 ? dungeon[row][col]+dp[row][col+1] : 0;
				int down = dungeon[row][col]+dp[row+1][col] < 0 ? dungeon[row][col]+dp[row+1][col] : 0;
				
				dp[row][col] = Math.max(right, down);
			}
		}
		
		return 1-dp[0][0];
	}
}
